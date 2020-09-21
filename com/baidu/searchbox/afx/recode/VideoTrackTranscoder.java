package com.baidu.searchbox.afx.recode;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.searchbox.afx.recode.QueuedMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class VideoTrackTranscoder {
    private static final int DRAIN_STATE_CONSUMED = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SHOULD_RETRY_IMMEDIATELY = 1;
    private static final String TAG = "VideoTrackTranscoder";
    private MediaFormat mActualOutputFormat;
    private final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec mDecoder;
    private ByteBuffer[] mDecoderInputBuffers;
    private OutputSurface mDecoderOutputSurfaceWrapper;
    private boolean mDecoderStarted;
    private MediaCodec mEncoder;
    private InputSurface mEncoderInputSurfaceWrapper;
    private ByteBuffer[] mEncoderOutputBuffers;
    private boolean mEncoderStarted;
    private final MediaExtractor mExtractor;
    private boolean mIsDecoderEOS;
    private boolean mIsEncoderEOS;
    private boolean mIsExtractorEOS;
    private final QueuedMuxer mMuxer;
    private final MediaFormat mOutputFormat;
    private final int mTrackIndex;
    private long mWrittenPresentationTimeUs;

    public VideoTrackTranscoder(MediaExtractor mediaExtractor, int i, MediaFormat mediaFormat, QueuedMuxer queuedMuxer) {
        this.mExtractor = mediaExtractor;
        this.mTrackIndex = i;
        this.mOutputFormat = mediaFormat;
        this.mMuxer = queuedMuxer;
    }

    public void setup(Mp4Info mp4Info) throws IOException {
        this.mExtractor.selectTrack(this.mTrackIndex);
        this.mEncoder = MediaCodec.createEncoderByType(this.mOutputFormat.getString("mime"));
        try {
            this.mEncoder.configure(this.mOutputFormat, (Surface) null, (MediaCrypto) null, 1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.mOutputFormat.setInteger("bitrate-mode", 1);
            this.mOutputFormat.setInteger("bitrate", mp4Info.getBitrate());
            this.mEncoder.configure(this.mOutputFormat, (Surface) null, (MediaCrypto) null, 1);
        }
        this.mEncoderInputSurfaceWrapper = new InputSurface(this.mEncoder.createInputSurface());
        this.mEncoderInputSurfaceWrapper.makeCurrent();
        this.mEncoder.start();
        this.mEncoderStarted = true;
        this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
        MediaFormat trackFormat = this.mExtractor.getTrackFormat(this.mTrackIndex);
        if (trackFormat.containsKey("rotation-degrees")) {
            trackFormat.setInteger("rotation-degrees", 0);
        }
        this.mDecoder = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        this.mDecoderOutputSurfaceWrapper = new OutputSurface();
        this.mDecoder.configure(trackFormat, this.mDecoderOutputSurfaceWrapper.getSurface(), (MediaCrypto) null, 0);
        this.mDecoder.start();
        this.mDecoderStarted = true;
        this.mDecoderInputBuffers = this.mDecoder.getInputBuffers();
    }

    public MediaFormat getDeterminedFormat() {
        return this.mActualOutputFormat;
    }

    public boolean stepPipeline() {
        int drainDecoder;
        boolean z = false;
        while (drainEncoder(0L) != 0) {
            z = true;
        }
        do {
            drainDecoder = drainDecoder(0L);
            if (drainDecoder != 0) {
                z = true;
                continue;
            }
        } while (drainDecoder == 1);
        while (drainExtractor(0L) != 0) {
            z = true;
        }
        return z;
    }

    public long getWrittenPresentationTimeUs() {
        return this.mWrittenPresentationTimeUs;
    }

    public boolean isFinished() {
        return this.mIsEncoderEOS;
    }

    public void release() {
        if (this.mDecoderOutputSurfaceWrapper != null) {
            this.mDecoderOutputSurfaceWrapper.release();
            this.mDecoderOutputSurfaceWrapper = null;
        }
        if (this.mEncoderInputSurfaceWrapper != null) {
            this.mEncoderInputSurfaceWrapper.release();
            this.mEncoderInputSurfaceWrapper = null;
        }
        if (this.mDecoder != null) {
            if (this.mDecoderStarted) {
                this.mDecoder.stop();
            }
            this.mDecoder.release();
            this.mDecoder = null;
        }
        if (this.mEncoder != null) {
            if (this.mEncoderStarted) {
                this.mEncoder.stop();
            }
            this.mEncoder.release();
            this.mEncoder = null;
        }
    }

    private int drainExtractor(long j) {
        int dequeueInputBuffer;
        if (this.mIsExtractorEOS) {
            return 0;
        }
        int sampleTrackIndex = this.mExtractor.getSampleTrackIndex();
        if ((sampleTrackIndex < 0 || sampleTrackIndex == this.mTrackIndex) && (dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(j)) >= 0) {
            if (sampleTrackIndex < 0) {
                this.mIsExtractorEOS = true;
                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                return 0;
            }
            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, this.mExtractor.readSampleData(this.mDecoderInputBuffers[dequeueInputBuffer], 0), this.mExtractor.getSampleTime(), (this.mExtractor.getSampleFlags() & 1) != 0 ? 1 : 0);
            this.mExtractor.advance();
            return 2;
        }
        return 0;
    }

    private int drainDecoder(long j) {
        if (this.mIsDecoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, j);
        switch (dequeueOutputBuffer) {
            case -3:
            case -2:
                return 1;
            case -1:
                return 0;
            default:
                if ((this.mBufferInfo.flags & 4) != 0) {
                    this.mEncoder.signalEndOfInputStream();
                    this.mIsDecoderEOS = true;
                    this.mBufferInfo.size = 0;
                }
                boolean z = this.mBufferInfo.size > 0;
                this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, z);
                if (z) {
                    this.mDecoderOutputSurfaceWrapper.awaitNewImage();
                    this.mDecoderOutputSurfaceWrapper.drawImage();
                    this.mEncoderInputSurfaceWrapper.setPresentationTime(this.mBufferInfo.presentationTimeUs * 1000);
                    this.mEncoderInputSurfaceWrapper.swapBuffers();
                }
                return 2;
        }
    }

    private int drainEncoder(long j) {
        if (this.mIsEncoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, j);
        switch (dequeueOutputBuffer) {
            case -3:
                this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
                return 1;
            case -2:
                if (this.mActualOutputFormat != null) {
                    throw new RuntimeException("Video output format changed twice.");
                }
                this.mActualOutputFormat = this.mEncoder.getOutputFormat();
                this.mMuxer.setOutputFormat(QueuedMuxer.SampleType.VIDEO, this.mActualOutputFormat);
                return 1;
            case -1:
                return 0;
            default:
                if (this.mActualOutputFormat == null) {
                    throw new RuntimeException("Could not determine actual output format.");
                }
                if ((this.mBufferInfo.flags & 4) != 0) {
                    this.mIsEncoderEOS = true;
                    this.mBufferInfo.set(0, 0, 0L, this.mBufferInfo.flags);
                }
                if ((this.mBufferInfo.flags & 2) != 0) {
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return 1;
                }
                this.mMuxer.writeSampleData(QueuedMuxer.SampleType.VIDEO, this.mEncoderOutputBuffers[dequeueOutputBuffer], this.mBufferInfo);
                this.mWrittenPresentationTimeUs = this.mBufferInfo.presentationTimeUs;
                this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return 2;
        }
    }
}
