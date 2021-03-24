package com.baidu.searchbox.afx.recode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class QueuedMuxer {
    public static final int BUFFER_SIZE = 65536;
    public static final String TAG = "QueuedMuxer";
    public ByteBuffer mByteBuffer;
    public final MediaMuxer mMuxer;
    public final List<SampleInfo> mSampleInfoList = new ArrayList();
    public boolean mStarted;
    public MediaFormat mVideoFormat;
    public int mVideoTrackIndex;

    /* renamed from: com.baidu.searchbox.afx.recode.QueuedMuxer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType;

        static {
            int[] iArr = new int[SampleType.values().length];
            $SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType = iArr;
            try {
                iArr[SampleType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SampleInfo {
        public final int mFlags;
        public final long mPresentationTimeUs;
        public final SampleType mSampleType;
        public final int mSize;

        public /* synthetic */ SampleInfo(SampleType sampleType, int i, MediaCodec.BufferInfo bufferInfo, AnonymousClass1 anonymousClass1) {
            this(sampleType, i, bufferInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToBufferInfo(MediaCodec.BufferInfo bufferInfo, int i) {
            bufferInfo.set(i, this.mSize, this.mPresentationTimeUs, this.mFlags);
        }

        public SampleInfo(SampleType sampleType, int i, MediaCodec.BufferInfo bufferInfo) {
            this.mSampleType = sampleType;
            this.mSize = i;
            this.mPresentationTimeUs = bufferInfo.presentationTimeUs;
            this.mFlags = bufferInfo.flags;
        }
    }

    /* loaded from: classes2.dex */
    public enum SampleType {
        VIDEO
    }

    public QueuedMuxer(MediaMuxer mediaMuxer) {
        this.mMuxer = mediaMuxer;
    }

    private int getTrackIndexForSampleType(SampleType sampleType) {
        if (AnonymousClass1.$SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType[sampleType.ordinal()] == 1) {
            return this.mVideoTrackIndex;
        }
        throw new AssertionError();
    }

    private void onSetOutputFormat() {
        MediaFormat mediaFormat = this.mVideoFormat;
        if (mediaFormat == null) {
            return;
        }
        this.mVideoTrackIndex = this.mMuxer.addTrack(mediaFormat);
        this.mMuxer.start();
        this.mStarted = true;
        int i = 0;
        if (this.mByteBuffer == null) {
            this.mByteBuffer = ByteBuffer.allocate(0);
        }
        this.mByteBuffer.flip();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        for (SampleInfo sampleInfo : this.mSampleInfoList) {
            sampleInfo.writeToBufferInfo(bufferInfo, i);
            this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleInfo.mSampleType), this.mByteBuffer, bufferInfo);
            i += sampleInfo.mSize;
        }
        this.mSampleInfoList.clear();
        this.mByteBuffer = null;
    }

    public void setOutputFormat(SampleType sampleType, MediaFormat mediaFormat) {
        if (AnonymousClass1.$SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType[sampleType.ordinal()] == 1) {
            this.mVideoFormat = mediaFormat;
            onSetOutputFormat();
            return;
        }
        throw new AssertionError();
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
        this.mSampleInfoList.add(new SampleInfo(sampleType, bufferInfo.size, bufferInfo, null));
    }
}
