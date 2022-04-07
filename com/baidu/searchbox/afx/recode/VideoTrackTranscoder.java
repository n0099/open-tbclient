package com.baidu.searchbox.afx.recode;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.recode.QueuedMuxer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.webrtc.HardwareVideoEncoder;
/* loaded from: classes2.dex */
public class VideoTrackTranscoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DRAIN_STATE_CONSUMED = 2;
    public static final int DRAIN_STATE_NONE = 0;
    public static final int DRAIN_STATE_SHOULD_RETRY_IMMEDIATELY = 1;
    public static final String TAG = "VideoTrackTranscoder";
    public transient /* synthetic */ FieldHolder $fh;
    public MediaFormat mActualOutputFormat;
    public final MediaCodec.BufferInfo mBufferInfo;
    public MediaCodec mDecoder;
    public ByteBuffer[] mDecoderInputBuffers;
    public OutputSurface mDecoderOutputSurfaceWrapper;
    public boolean mDecoderStarted;
    public MediaCodec mEncoder;
    public InputSurface mEncoderInputSurfaceWrapper;
    public ByteBuffer[] mEncoderOutputBuffers;
    public boolean mEncoderStarted;
    public final MediaExtractor mExtractor;
    public boolean mIsDecoderEOS;
    public boolean mIsEncoderEOS;
    public boolean mIsExtractorEOS;
    public final QueuedMuxer mMuxer;
    public final MediaFormat mOutputFormat;
    public final int mTrackIndex;
    public long mWrittenPresentationTimeUs;

    public VideoTrackTranscoder(MediaExtractor mediaExtractor, int i, MediaFormat mediaFormat, QueuedMuxer queuedMuxer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaExtractor, Integer.valueOf(i), mediaFormat, queuedMuxer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mExtractor = mediaExtractor;
        this.mTrackIndex = i;
        this.mOutputFormat = mediaFormat;
        this.mMuxer = queuedMuxer;
    }

    private int drainDecoder(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            if (this.mIsDecoderEOS) {
                return 0;
            }
            int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, j);
            if (dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2) {
                return 1;
            }
            if (dequeueOutputBuffer != -1) {
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
                    return 2;
                }
                return 2;
            }
            return 0;
        }
        return invokeJ.intValue;
    }

    private int drainEncoder(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            if (this.mIsEncoderEOS) {
                return 0;
            }
            int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, j);
            if (dequeueOutputBuffer == -3) {
                this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
                return 1;
            } else if (dequeueOutputBuffer == -2) {
                if (this.mActualOutputFormat == null) {
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    this.mActualOutputFormat = outputFormat;
                    this.mMuxer.setOutputFormat(QueuedMuxer.SampleType.VIDEO, outputFormat);
                    return 1;
                }
                throw new RuntimeException("Video output format changed twice.");
            } else if (dequeueOutputBuffer != -1) {
                if (this.mActualOutputFormat != null) {
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    int i = bufferInfo.flags;
                    if ((i & 4) != 0) {
                        this.mIsEncoderEOS = true;
                        bufferInfo.set(0, 0, 0L, i);
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                    if ((bufferInfo2.flags & 2) != 0) {
                        this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        return 1;
                    }
                    this.mMuxer.writeSampleData(QueuedMuxer.SampleType.VIDEO, this.mEncoderOutputBuffers[dequeueOutputBuffer], bufferInfo2);
                    this.mWrittenPresentationTimeUs = this.mBufferInfo.presentationTimeUs;
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return 2;
                }
                throw new RuntimeException("Could not determine actual output format.");
            } else {
                return 0;
            }
        }
        return invokeJ.intValue;
    }

    private int drainExtractor(long j) {
        InterceptResult invokeJ;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
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
        return invokeJ.intValue;
    }

    public MediaFormat getDeterminedFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mActualOutputFormat : (MediaFormat) invokeV.objValue;
    }

    public long getWrittenPresentationTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrittenPresentationTimeUs : invokeV.longValue;
    }

    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsEncoderEOS : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            OutputSurface outputSurface = this.mDecoderOutputSurfaceWrapper;
            if (outputSurface != null) {
                outputSurface.release();
                this.mDecoderOutputSurfaceWrapper = null;
            }
            InputSurface inputSurface = this.mEncoderInputSurfaceWrapper;
            if (inputSurface != null) {
                inputSurface.release();
                this.mEncoderInputSurfaceWrapper = null;
            }
            MediaCodec mediaCodec = this.mDecoder;
            if (mediaCodec != null) {
                if (this.mDecoderStarted) {
                    mediaCodec.stop();
                }
                this.mDecoder.release();
                this.mDecoder = null;
            }
            MediaCodec mediaCodec2 = this.mEncoder;
            if (mediaCodec2 != null) {
                if (this.mEncoderStarted) {
                    mediaCodec2.stop();
                }
                this.mEncoder.release();
                this.mEncoder = null;
            }
        }
    }

    public void setup(Mp4Info mp4Info) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mp4Info) == null) {
            this.mExtractor.selectTrack(this.mTrackIndex);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.mOutputFormat.getString("mime"));
            this.mEncoder = createEncoderByType;
            try {
                createEncoderByType.configure(this.mOutputFormat, (Surface) null, (MediaCrypto) null, 1);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                this.mOutputFormat.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, 1);
                this.mOutputFormat.setInteger("bitrate", mp4Info.getBitrate());
                this.mEncoder.configure(this.mOutputFormat, (Surface) null, (MediaCrypto) null, 1);
            }
            InputSurface inputSurface = new InputSurface(this.mEncoder.createInputSurface());
            this.mEncoderInputSurfaceWrapper = inputSurface;
            inputSurface.makeCurrent();
            this.mEncoder.start();
            this.mEncoderStarted = true;
            this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(this.mTrackIndex);
            if (trackFormat.containsKey("rotation-degrees")) {
                trackFormat.setInteger("rotation-degrees", 0);
            }
            this.mDecoder = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            OutputSurface outputSurface = new OutputSurface();
            this.mDecoderOutputSurfaceWrapper = outputSurface;
            this.mDecoder.configure(trackFormat, outputSurface.getSurface(), (MediaCrypto) null, 0);
            this.mDecoder.start();
            this.mDecoderStarted = true;
            this.mDecoderInputBuffers = this.mDecoder.getInputBuffers();
        }
    }

    public boolean stepPipeline() {
        InterceptResult invokeV;
        int drainDecoder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return invokeV.booleanValue;
    }
}
