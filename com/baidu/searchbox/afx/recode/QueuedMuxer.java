package com.baidu.searchbox.afx.recode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class QueuedMuxer {
    private static final int BUFFER_SIZE = 65536;
    private static final String TAG = "QueuedMuxer";
    private ByteBuffer mByteBuffer;
    private final MediaMuxer mMuxer;
    private final List<SampleInfo> mSampleInfoList = new ArrayList();
    private boolean mStarted;
    private MediaFormat mVideoFormat;
    private int mVideoTrackIndex;

    /* loaded from: classes13.dex */
    public enum SampleType {
        VIDEO
    }

    public QueuedMuxer(MediaMuxer mediaMuxer) {
        this.mMuxer = mediaMuxer;
    }

    public void setOutputFormat(SampleType sampleType, MediaFormat mediaFormat) {
        switch (sampleType) {
            case VIDEO:
                this.mVideoFormat = mediaFormat;
                onSetOutputFormat();
                return;
            default:
                throw new AssertionError();
        }
    }

    private void onSetOutputFormat() {
        int i = 0;
        if (this.mVideoFormat != null) {
            this.mVideoTrackIndex = this.mMuxer.addTrack(this.mVideoFormat);
            this.mMuxer.start();
            this.mStarted = true;
            if (this.mByteBuffer == null) {
                this.mByteBuffer = ByteBuffer.allocate(0);
            }
            this.mByteBuffer.flip();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            Iterator<SampleInfo> it = this.mSampleInfoList.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    this.mSampleInfoList.clear();
                    this.mByteBuffer = null;
                    return;
                }
                SampleInfo next = it.next();
                next.writeToBufferInfo(bufferInfo, i2);
                this.mMuxer.writeSampleData(getTrackIndexForSampleType(next.mSampleType), this.mByteBuffer, bufferInfo);
                i = next.mSize + i2;
            }
        }
    }

    public void writeSampleData(SampleType sampleType, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mStarted) {
            this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleType), byteBuffer, bufferInfo);
            return;
        }
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.position(bufferInfo.offset);
        if (this.mByteBuffer == null) {
            this.mByteBuffer = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
        }
        this.mByteBuffer.put(byteBuffer);
        this.mSampleInfoList.add(new SampleInfo(sampleType, bufferInfo.size, bufferInfo));
    }

    private int getTrackIndexForSampleType(SampleType sampleType) {
        switch (sampleType) {
            case VIDEO:
                return this.mVideoTrackIndex;
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class SampleInfo {
        private final int mFlags;
        private final long mPresentationTimeUs;
        private final SampleType mSampleType;
        private final int mSize;

        private SampleInfo(SampleType sampleType, int i, MediaCodec.BufferInfo bufferInfo) {
            this.mSampleType = sampleType;
            this.mSize = i;
            this.mPresentationTimeUs = bufferInfo.presentationTimeUs;
            this.mFlags = bufferInfo.flags;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToBufferInfo(MediaCodec.BufferInfo bufferInfo, int i) {
            bufferInfo.set(i, this.mSize, this.mPresentationTimeUs, this.mFlags);
        }
    }
}
