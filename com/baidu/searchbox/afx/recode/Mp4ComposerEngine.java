package com.baidu.searchbox.afx.recode;

import android.content.res.AssetFileDescriptor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes15.dex */
class Mp4ComposerEngine {
    private static final long PROGRESS_INTERVAL_STEPS = 10;
    private static final float PROGRESS_UNKNOWN = -1.0f;
    private static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 10;
    private static final String TAG = "Mp4ComposerEngine";
    private long mDurationUs;
    private ProgressCallback mProgressCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface ProgressCallback {
        void onProgress(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgressCallback(ProgressCallback progressCallback) {
        this.mProgressCallback = progressCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void compose(FileDescriptor fileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(fileDescriptor);
        compose(mediaExtractor, str, mp4Info);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void compose(AssetFileDescriptor assetFileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor());
        } else {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
        compose(mediaExtractor, str, mp4Info);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void compose(MediaExtractor mediaExtractor, String str, Mp4Info mp4Info) throws IOException {
        VideoTrackTranscoder videoTrackTranscoder;
        MediaMuxer mediaMuxer;
        int i;
        try {
            int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
            if (selectVideoTrackIndex < 0) {
                Log.e(TAG, "No video track found in " + str);
                throw new RuntimeException("No video track found in " + str);
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
            String string = trackFormat.getString(IMediaFormat.KEY_MIME);
            try {
                i = trackFormat.getInteger("frame-rate");
            } catch (Exception e) {
                Log.e(TAG, "get frame rate (FPS) failed.", e);
                i = 25;
            }
            this.mDurationUs = mp4Info.getDurationUs();
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(string, mp4Info.getWidth(), mp4Info.getHeight());
            createVideoFormat.setInteger("bitrate-mode", 0);
            createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, mp4Info.getBitrate() * 3);
            createVideoFormat.setInteger("frame-rate", i);
            createVideoFormat.setInteger("i-frame-interval", 0);
            createVideoFormat.setInteger("color-format", 2130708361);
            mediaMuxer = new MediaMuxer(str, 0);
            try {
                videoTrackTranscoder = new VideoTrackTranscoder(mediaExtractor, selectVideoTrackIndex, createVideoFormat, new QueuedMuxer(mediaMuxer));
            } catch (Throwable th) {
                th = th;
                videoTrackTranscoder = null;
            }
            try {
                videoTrackTranscoder.setup(mp4Info);
                mediaExtractor.selectTrack(selectVideoTrackIndex);
                runPipelinesNoAudio(videoTrackTranscoder);
                mediaMuxer.stop();
                if (videoTrackTranscoder != null) {
                    videoTrackTranscoder.release();
                }
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
                if (mediaMuxer != null) {
                    mediaMuxer.release();
                }
            } catch (Throwable th2) {
                th = th2;
                if (videoTrackTranscoder != null) {
                    videoTrackTranscoder.release();
                }
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
                if (mediaMuxer != null) {
                    mediaMuxer.release();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            videoTrackTranscoder = null;
            mediaMuxer = null;
            if (videoTrackTranscoder != null) {
            }
            if (mediaExtractor != null) {
            }
            if (mediaMuxer != null) {
            }
            throw th;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    private void runPipelinesNoAudio(VideoTrackTranscoder videoTrackTranscoder) {
        if (this.mDurationUs <= 0 && this.mProgressCallback != null) {
            this.mProgressCallback.onProgress(PROGRESS_UNKNOWN);
        }
        long j = 0;
        while (!videoTrackTranscoder.isFinished()) {
            boolean stepPipeline = videoTrackTranscoder.stepPipeline();
            j++;
            if (this.mDurationUs > 0 && j % 10 == 0) {
                float min = videoTrackTranscoder.isFinished() ? 1.0f : Math.min(1.0f, ((float) videoTrackTranscoder.getWrittenPresentationTimeUs()) / ((float) this.mDurationUs));
                if (this.mProgressCallback != null) {
                    this.mProgressCallback.onProgress(min);
                }
            }
            if (!stepPipeline) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
