package com.baidu.searchbox.ugc.transcoder;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ugc.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes14.dex */
public class VideoTranscoder {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int MAX_WIDTH = 640;
    private static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
    private static final int OUTPUT_AUDIO_BIT_RATE = 1411200;
    private static final int OUTPUT_AUDIO_CHANNEL_COUNT = 2;
    private static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
    private static final int OUTPUT_VIDEO_BIT_RATE = 520000;
    private static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
    private static final int OUTPUT_VIDEO_FRAME_RATE = 25;
    private static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 10;
    private static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    private static final String TAG = "VideoTranscoder";
    private static final int TIMEOUT_USEC = 10000;
    private int mHeight;
    private String mInputFile;
    private volatile boolean mIsStop;
    private String mOutputFile;
    private int mOutputFileMaxSize;
    private StateCallback mStateCallback;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface StateCallback {
        void onError();

        void onFinish(String str);
    }

    public String startTranscoder(Context context, String str, int i, boolean z) {
        if (startTranscoder(context, str, new File(context.getExternalFilesDir(null), System.currentTimeMillis() + "_out.mp4").getAbsolutePath(), i, z)) {
            return this.mOutputFile;
        }
        return null;
    }

    public boolean startTranscoder(Context context, String str, String str2, int i, boolean z) {
        if (DeviceUtil.OSInfo.hasJellyBeanMR2()) {
            this.mIsStop = false;
            try {
                this.mInputFile = str;
                this.mOutputFileMaxSize = i;
                this.mOutputFile = str2;
                File file = new File(this.mOutputFile);
                if (!file.exists()) {
                    file.createNewFile();
                }
                ChangerWrapper changerWrapper = new ChangerWrapper(this);
                if (z) {
                    changerWrapper.run();
                } else {
                    ExecutorUtilsExt.postOnElastic(changerWrapper, ChangerWrapper.class.getSimpleName(), 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mStateCallback != null) {
                    this.mStateCallback.onError();
                }
                FileUtils.deleteFile(this.mOutputFile);
            }
            if (!this.mIsStop) {
                return this.mOutputFile != null && new File(this.mOutputFile).exists();
            }
            FileUtils.deleteFile(this.mOutputFile);
            return false;
        }
        return false;
    }

    public String startTranscoder(Context context, String str, int i) {
        return startTranscoder(context, str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class ChangerWrapper implements Runnable {
        private static final int TRY_MAX = 2;
        private VideoTranscoder mChanger;
        private int tryNum;

        private ChangerWrapper(VideoTranscoder videoTranscoder) {
            this.tryNum = 0;
            this.mChanger = videoTranscoder;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            while (!z && this.tryNum < 2) {
                this.tryNum++;
                try {
                    this.mChanger.prepareAndChangeResolution(this.tryNum);
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    FileUtils.deleteFile(VideoTranscoder.this.mOutputFile);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            File file = new File(VideoTranscoder.this.mOutputFile);
            if (!z || !file.exists() || file.length() > VideoTranscoder.this.mOutputFileMaxSize) {
                if (VideoTranscoder.this.mStateCallback != null) {
                    VideoTranscoder.this.mStateCallback.onError();
                }
                FileUtils.deleteFile(VideoTranscoder.this.mOutputFile);
            } else if (VideoTranscoder.this.mStateCallback != null) {
                VideoTranscoder.this.mStateCallback.onFinish(VideoTranscoder.this.mOutputFile);
            }
            if (VideoTranscoder.DEBUG) {
                Log.e(VideoTranscoder.TAG, "总共尝试次数tryNum=" + this.tryNum);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [337=6, 338=6, 340=6, 341=6, 346=6, 347=6, 349=6, 350=6, 355=6, 356=6, 357=6, 359=6, 360=6, 365=6, 366=6, 368=6, 369=6, 374=6, 375=6, 376=6, 378=6, 379=6, 380=6, 384=6, 385=6, 386=6, 388=6, 389=6, 390=6, 394=6, 395=6, 396=6, 398=6, 399=6, 400=6, 404=6, 405=6, 406=6, 408=6, 409=6, 414=6, 415=6, 417=6, 418=6] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x044d, code lost:
        if (r2 == null) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x044f, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0483, code lost:
        if (r2 != null) goto L275;
     */
    /* JADX WARN: Removed duplicated region for block: B:385:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:413:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:465:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:504:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prepareAndChangeResolution(int i) throws Exception {
        InputSurface inputSurface;
        OutputSurface outputSurface;
        MediaCodec mediaCodec;
        MediaMuxer mediaMuxer;
        MediaExtractor mediaExtractor = null;
        MediaExtractor mediaExtractor2 = null;
        OutputSurface outputSurface2 = null;
        MediaCodec mediaCodec2 = null;
        MediaCodec mediaCodec3 = null;
        MediaCodec mediaCodec4 = null;
        MediaCodec mediaCodec5 = null;
        MediaMuxer mediaMuxer2 = null;
        InputSurface inputSurface2 = null;
        try {
            mediaExtractor2 = FileUtils.getMediaExtractor(this.mInputFile);
        } catch (Exception e) {
            e = e;
            inputSurface = null;
            outputSurface = null;
            mediaCodec = null;
            mediaMuxer = null;
        } catch (Throwable th) {
            th = th;
        }
        if (mediaExtractor2 == null) {
            if (0 != 0) {
                try {
                    mediaExtractor.release();
                } catch (Exception e2) {
                    e = e2;
                    if (0 != 0) {
                        e = null;
                    }
                }
            }
            e = null;
            if (mediaExtractor2 != null) {
                try {
                    mediaExtractor2.release();
                } catch (Exception e3) {
                    e = e3;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec2.stop();
                    mediaCodec2.release();
                } catch (Exception e4) {
                    e = e4;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    outputSurface2.release();
                } catch (Exception e5) {
                    e = e5;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec4.stop();
                    mediaCodec4.release();
                } catch (Exception e6) {
                    if (e == null) {
                        e = e6;
                    }
                }
            }
            if (0 != 0) {
                try {
                    mediaCodec3.stop();
                    mediaCodec3.release();
                } catch (Exception e7) {
                    if (e == null) {
                        e = e7;
                    }
                }
            }
            if (0 != 0) {
                try {
                    mediaCodec5.stop();
                    mediaCodec5.release();
                } catch (Exception e8) {
                    if (e == null) {
                        e = e8;
                    }
                }
            }
            if (0 != 0) {
                try {
                    mediaMuxer2.stop();
                    mediaMuxer2.release();
                } catch (Exception e9) {
                    e = e9;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    inputSurface2.release();
                    return;
                } catch (Exception e10) {
                    if (e == null) {
                    }
                    return;
                }
            }
            return;
        }
        MediaFormat trackFormat = mediaExtractor2.getTrackFormat(getAndSelectAudioTrackIndex(mediaExtractor2));
        String string = trackFormat.getString("mime");
        if (DEBUG) {
            Log.e(TAG, "原始声音编码器 audioMime=" + string);
        }
        MediaFormat mediaFormat = null;
        MediaCodecInfo mediaCodecInfo = null;
        switch (i) {
            case 1:
                mediaCodecInfo = selectCodec(string);
                if (mediaCodecInfo != null) {
                    int integer = trackFormat.getInteger("channel-count");
                    if (integer <= 0) {
                        integer = 2;
                    }
                    trackFormat.setInteger("channel-count", integer);
                    trackFormat.setInteger("bitrate", 44100 * integer * 16);
                    mediaFormat = trackFormat;
                    break;
                }
                break;
            case 2:
                mediaCodecInfo = selectCodec(OUTPUT_AUDIO_MIME_TYPE);
                if (mediaCodecInfo != null) {
                    mediaFormat = MediaFormat.createAudioFormat(OUTPUT_AUDIO_MIME_TYPE, 44100, 2);
                    mediaFormat.setInteger("bitrate", OUTPUT_AUDIO_BIT_RATE);
                    mediaFormat.setInteger("aac-profile", 2);
                    break;
                }
                break;
        }
        if (mediaFormat == null || mediaCodecInfo == null) {
            if (DEBUG) {
                Log.e(TAG, "找不到声音编码器");
            }
            throw new Exception("no found audioCodecInfo");
        }
        if (DEBUG) {
            Log.e(TAG, "inputAudioFormat" + trackFormat);
            Log.e(TAG, "outputAudioFormat" + mediaFormat);
        }
        mediaCodec5 = createAudioEncoder(mediaCodecInfo, mediaFormat);
        mediaCodec3 = createAudioDecoder(trackFormat);
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec == null) {
            throw new Exception("no found videoCodecInfo for video/avc");
        }
        mediaExtractor = FileUtils.getMediaExtractor(this.mInputFile);
        if (mediaExtractor == null) {
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e11) {
                    e = e11;
                    if (0 != 0) {
                        e = null;
                    }
                }
            }
            e = null;
            if (mediaExtractor2 != null) {
                try {
                    mediaExtractor2.release();
                } catch (Exception e12) {
                    e = e12;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec2.stop();
                    mediaCodec2.release();
                } catch (Exception e13) {
                    e = e13;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    outputSurface2.release();
                } catch (Exception e14) {
                    e = e14;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec4.stop();
                    mediaCodec4.release();
                } catch (Exception e15) {
                    if (e == null) {
                        e = e15;
                    }
                }
            }
            if (mediaCodec3 != null) {
                try {
                    mediaCodec3.stop();
                    mediaCodec3.release();
                } catch (Exception e16) {
                    if (e == null) {
                        e = e16;
                    }
                }
            }
            if (mediaCodec5 != null) {
                try {
                    mediaCodec5.stop();
                    mediaCodec5.release();
                } catch (Exception e17) {
                    if (e == null) {
                        e = e17;
                    }
                }
            }
            if (0 != 0) {
                try {
                    mediaMuxer2.stop();
                    mediaMuxer2.release();
                } catch (Exception e18) {
                    e = e18;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    inputSurface2.release();
                    return;
                } catch (Exception e19) {
                    if (e == null) {
                    }
                    return;
                }
            }
            return;
        }
        MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(getAndSelectVideoTrackIndex(mediaExtractor));
        MediaMetadataRetriever mediaMetadataRetriever = FileUtils.getMediaMetadataRetriever(this.mInputFile);
        if (mediaMetadataRetriever == null) {
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e20) {
                    e = e20;
                    if (0 != 0) {
                        e = null;
                    }
                }
            }
            e = null;
            if (mediaExtractor2 != null) {
                try {
                    mediaExtractor2.release();
                } catch (Exception e21) {
                    e = e21;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec2.stop();
                    mediaCodec2.release();
                } catch (Exception e22) {
                    e = e22;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    outputSurface2.release();
                } catch (Exception e23) {
                    e = e23;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    mediaCodec4.stop();
                    mediaCodec4.release();
                } catch (Exception e24) {
                    if (e == null) {
                        e = e24;
                    }
                }
            }
            if (mediaCodec3 != null) {
                try {
                    mediaCodec3.stop();
                    mediaCodec3.release();
                } catch (Exception e25) {
                    if (e == null) {
                        e = e25;
                    }
                }
            }
            if (mediaCodec5 != null) {
                try {
                    mediaCodec5.stop();
                    mediaCodec5.release();
                } catch (Exception e26) {
                    if (e == null) {
                        e = e26;
                    }
                }
            }
            if (0 != 0) {
                try {
                    mediaMuxer2.stop();
                    mediaMuxer2.release();
                } catch (Exception e27) {
                    e = e27;
                    if (e != null) {
                        e = e;
                    }
                }
            }
            e = e;
            if (0 != 0) {
                try {
                    inputSurface2.release();
                    return;
                } catch (Exception e28) {
                    if (e == null) {
                    }
                    return;
                }
            }
            return;
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        int width = frameAtTime.getWidth();
        int height = frameAtTime.getHeight();
        if (width <= 640 && height <= 640) {
            this.mWidth = width;
            this.mHeight = height;
        } else if (width > height) {
            this.mWidth = 640;
            this.mHeight = (height * this.mWidth) / width;
        } else {
            this.mHeight = 640;
            this.mWidth = (width * this.mHeight) / height;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.mWidth, this.mHeight);
        createVideoFormat.setInteger("color-format", OUTPUT_VIDEO_COLOR_FORMAT);
        createVideoFormat.setInteger("bitrate", OUTPUT_VIDEO_BIT_RATE);
        createVideoFormat.setInteger("frame-rate", 25);
        createVideoFormat.setInteger("i-frame-interval", 10);
        if (DEBUG) {
            Log.e(TAG, "inputvideoFormat=" + trackFormat2);
            Log.e(TAG, "outputVideoFormat=" + createVideoFormat);
        }
        AtomicReference<Surface> atomicReference = new AtomicReference<>();
        mediaCodec4 = createVideoEncoder(selectCodec, createVideoFormat, atomicReference);
        inputSurface = new InputSurface(atomicReference.get());
        try {
            inputSurface.makeCurrent();
            outputSurface = new OutputSurface();
            try {
                mediaCodec = createVideoDecoder(trackFormat2, outputSurface.getSurface());
                try {
                    mediaMuxer = new MediaMuxer(this.mOutputFile, 0);
                } catch (Exception e29) {
                    e = e29;
                    mediaMuxer = null;
                } catch (Throwable th2) {
                    th = th2;
                    mediaCodec2 = mediaCodec;
                    outputSurface2 = outputSurface;
                    inputSurface2 = inputSurface;
                }
                try {
                    changeResolution(mediaExtractor, mediaExtractor2, mediaCodec, mediaCodec4, mediaCodec3, mediaCodec5, mediaMuxer, inputSurface, outputSurface);
                    if (mediaExtractor != null) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e30) {
                            e = e30;
                            if (0 != 0) {
                                e = null;
                            }
                        }
                    }
                    e = null;
                    if (mediaExtractor2 != null) {
                        try {
                            mediaExtractor2.release();
                        } catch (Exception e31) {
                            e = e31;
                            if (e != null) {
                                e = e;
                            }
                        }
                    }
                    e = e;
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                            mediaCodec.release();
                        } catch (Exception e32) {
                            e = e32;
                            if (e != null) {
                                e = e;
                            }
                        }
                    }
                    e = e;
                    if (outputSurface != null) {
                        try {
                            outputSurface.release();
                        } catch (Exception e33) {
                            e = e33;
                            if (e != null) {
                                e = e;
                            }
                        }
                    }
                    e = e;
                    if (mediaCodec4 != null) {
                        try {
                            mediaCodec4.stop();
                            mediaCodec4.release();
                        } catch (Exception e34) {
                            if (e == null) {
                                e = e34;
                            }
                        }
                    }
                    if (mediaCodec3 != null) {
                        try {
                            mediaCodec3.stop();
                            mediaCodec3.release();
                        } catch (Exception e35) {
                            if (e == null) {
                                e = e35;
                            }
                        }
                    }
                    if (mediaCodec5 != null) {
                        try {
                            mediaCodec5.stop();
                            mediaCodec5.release();
                        } catch (Exception e36) {
                            if (e == null) {
                                e = e36;
                            }
                        }
                    }
                    if (mediaMuxer != null) {
                        try {
                            mediaMuxer.stop();
                            mediaMuxer.release();
                        } catch (Exception e37) {
                            if (e == null) {
                                e = e37;
                            }
                        }
                    }
                    if (inputSurface != null) {
                        try {
                            inputSurface.release();
                        } catch (Exception e38) {
                            e = e38;
                        }
                    }
                    e = e;
                } catch (Exception e39) {
                    e = e39;
                    Exception exc = 0 == 0 ? e : null;
                    if (mediaExtractor != null) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e40) {
                            e = e40;
                            if (exc != null) {
                                e = exc;
                            }
                            if (mediaExtractor2 != null) {
                                try {
                                    mediaExtractor2.release();
                                } catch (Exception e41) {
                                    e = e41;
                                    if (e != null) {
                                        e = e;
                                    }
                                    if (mediaCodec != null) {
                                        try {
                                            mediaCodec.stop();
                                            mediaCodec.release();
                                        } catch (Exception e42) {
                                            e = e42;
                                            if (e != null) {
                                                e = e;
                                            }
                                            if (outputSurface != null) {
                                                try {
                                                    outputSurface.release();
                                                } catch (Exception e43) {
                                                    e = e43;
                                                    if (e != null) {
                                                        e = e;
                                                    }
                                                    if (mediaCodec4 != null) {
                                                    }
                                                    if (mediaCodec3 != null) {
                                                    }
                                                    if (mediaCodec5 != null) {
                                                    }
                                                    if (mediaMuxer != null) {
                                                    }
                                                    if (inputSurface != null) {
                                                    }
                                                    e = e;
                                                    if (e == null) {
                                                    }
                                                }
                                            }
                                            e = e;
                                            if (mediaCodec4 != null) {
                                                try {
                                                    mediaCodec4.stop();
                                                    mediaCodec4.release();
                                                } catch (Exception e44) {
                                                    if (e == null) {
                                                        e = e44;
                                                    }
                                                }
                                            }
                                            if (mediaCodec3 != null) {
                                                try {
                                                    mediaCodec3.stop();
                                                    mediaCodec3.release();
                                                } catch (Exception e45) {
                                                    if (e == null) {
                                                        e = e45;
                                                    }
                                                }
                                            }
                                            if (mediaCodec5 != null) {
                                                try {
                                                    mediaCodec5.stop();
                                                    mediaCodec5.release();
                                                } catch (Exception e46) {
                                                    if (e == null) {
                                                        e = e46;
                                                    }
                                                }
                                            }
                                            if (mediaMuxer != null) {
                                                try {
                                                    mediaMuxer.stop();
                                                    mediaMuxer.release();
                                                } catch (Exception e47) {
                                                    if (e == null) {
                                                        e = e47;
                                                    }
                                                }
                                            }
                                            if (inputSurface != null) {
                                                try {
                                                    inputSurface.release();
                                                } catch (Exception e48) {
                                                    e = e48;
                                                }
                                            }
                                            e = e;
                                            if (e == null) {
                                            }
                                        }
                                    }
                                    e = e;
                                    if (outputSurface != null) {
                                    }
                                    e = e;
                                    if (mediaCodec4 != null) {
                                    }
                                    if (mediaCodec3 != null) {
                                    }
                                    if (mediaCodec5 != null) {
                                    }
                                    if (mediaMuxer != null) {
                                    }
                                    if (inputSurface != null) {
                                    }
                                    e = e;
                                    if (e == null) {
                                    }
                                }
                            }
                            e = e;
                            if (mediaCodec != null) {
                            }
                            e = e;
                            if (outputSurface != null) {
                            }
                            e = e;
                            if (mediaCodec4 != null) {
                            }
                            if (mediaCodec3 != null) {
                            }
                            if (mediaCodec5 != null) {
                            }
                            if (mediaMuxer != null) {
                            }
                            if (inputSurface != null) {
                            }
                            e = e;
                            if (e == null) {
                            }
                        }
                    }
                    e = exc;
                    if (mediaExtractor2 != null) {
                    }
                    e = e;
                    if (mediaCodec != null) {
                    }
                    e = e;
                    if (outputSurface != null) {
                    }
                    e = e;
                    if (mediaCodec4 != null) {
                    }
                    if (mediaCodec3 != null) {
                    }
                    if (mediaCodec5 != null) {
                    }
                    if (mediaMuxer != null) {
                    }
                    if (inputSurface != null) {
                    }
                    e = e;
                    if (e == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    mediaMuxer2 = mediaMuxer;
                    outputSurface2 = outputSurface;
                    mediaCodec2 = mediaCodec;
                    inputSurface2 = inputSurface;
                    if (mediaExtractor != null) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e49) {
                            e = e49;
                            if (0 != 0) {
                                e = null;
                            }
                            if (mediaExtractor2 != null) {
                                try {
                                    mediaExtractor2.release();
                                } catch (Exception e50) {
                                    e = e50;
                                    if (e != null) {
                                        e = e;
                                    }
                                    if (mediaCodec2 != null) {
                                        try {
                                            mediaCodec2.stop();
                                            mediaCodec2.release();
                                        } catch (Exception e51) {
                                            e = e51;
                                            if (e != null) {
                                                e = e;
                                            }
                                            if (outputSurface2 != null) {
                                            }
                                            e = e;
                                            if (mediaCodec4 != null) {
                                            }
                                            if (mediaCodec3 != null) {
                                            }
                                            if (mediaCodec5 != null) {
                                            }
                                            if (mediaMuxer2 != null) {
                                            }
                                            e = e;
                                            if (inputSurface2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    e = e;
                                    if (outputSurface2 != null) {
                                        try {
                                            outputSurface2.release();
                                        } catch (Exception e52) {
                                            e = e52;
                                            if (e != null) {
                                                e = e;
                                            }
                                            if (mediaCodec4 != null) {
                                            }
                                            if (mediaCodec3 != null) {
                                            }
                                            if (mediaCodec5 != null) {
                                            }
                                            if (mediaMuxer2 != null) {
                                            }
                                            e = e;
                                            if (inputSurface2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    e = e;
                                    if (mediaCodec4 != null) {
                                        try {
                                            mediaCodec4.stop();
                                            mediaCodec4.release();
                                        } catch (Exception e53) {
                                            if (e == null) {
                                                e = e53;
                                            }
                                        }
                                    }
                                    if (mediaCodec3 != null) {
                                        try {
                                            mediaCodec3.stop();
                                            mediaCodec3.release();
                                        } catch (Exception e54) {
                                            if (e == null) {
                                                e = e54;
                                            }
                                        }
                                    }
                                    if (mediaCodec5 != null) {
                                        try {
                                            mediaCodec5.stop();
                                            mediaCodec5.release();
                                        } catch (Exception e55) {
                                            if (e == null) {
                                                e = e55;
                                            }
                                        }
                                    }
                                    if (mediaMuxer2 != null) {
                                        try {
                                            mediaMuxer2.stop();
                                            mediaMuxer2.release();
                                        } catch (Exception e56) {
                                            e = e56;
                                            if (e != null) {
                                                e = e;
                                            }
                                            if (inputSurface2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    e = e;
                                    if (inputSurface2 != null) {
                                        try {
                                            inputSurface2.release();
                                        } catch (Exception e57) {
                                            if (e == null) {
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            }
                            e = e;
                            if (mediaCodec2 != null) {
                            }
                            e = e;
                            if (outputSurface2 != null) {
                            }
                            e = e;
                            if (mediaCodec4 != null) {
                            }
                            if (mediaCodec3 != null) {
                            }
                            if (mediaCodec5 != null) {
                            }
                            if (mediaMuxer2 != null) {
                            }
                            e = e;
                            if (inputSurface2 != null) {
                            }
                            throw th;
                        }
                    }
                    e = null;
                    if (mediaExtractor2 != null) {
                    }
                    e = e;
                    if (mediaCodec2 != null) {
                    }
                    e = e;
                    if (outputSurface2 != null) {
                    }
                    e = e;
                    if (mediaCodec4 != null) {
                    }
                    if (mediaCodec3 != null) {
                    }
                    if (mediaCodec5 != null) {
                    }
                    if (mediaMuxer2 != null) {
                    }
                    e = e;
                    if (inputSurface2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e58) {
                e = e58;
                mediaCodec = null;
                mediaMuxer = null;
            } catch (Throwable th4) {
                th = th4;
                inputSurface2 = inputSurface;
                outputSurface2 = outputSurface;
            }
        } catch (Exception e59) {
            e = e59;
            mediaCodec = null;
            outputSurface = null;
            mediaMuxer = null;
        } catch (Throwable th5) {
            th = th5;
            inputSurface2 = inputSurface;
        }
        if (e == null) {
            throw e;
        }
    }

    private MediaCodec createVideoDecoder(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec createVideoEncoder(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        atomicReference.set(createByCodecName.createInputSurface());
        createByCodecName.start();
        return createByCodecName;
    }

    private MediaCodec createAudioDecoder(MediaFormat mediaFormat) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec createAudioEncoder(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        createByCodecName.start();
        return createByCodecName;
    }

    private int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (isVideoFormat(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    private int getAndSelectAudioTrackIndex(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (isAudioFormat(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    private void changeResolution(MediaExtractor mediaExtractor, MediaExtractor mediaExtractor2, MediaCodec mediaCodec, MediaCodec mediaCodec2, MediaCodec mediaCodec3, MediaCodec mediaCodec4, MediaMuxer mediaMuxer, InputSurface inputSurface, OutputSurface outputSurface) {
        boolean z;
        int i;
        boolean z2;
        MediaFormat mediaFormat;
        ByteBuffer[] byteBufferArr;
        MediaFormat mediaFormat2;
        ByteBuffer[] byteBufferArr2;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        ByteBuffer[] inputBuffers2 = mediaCodec3.getInputBuffers();
        ByteBuffer[] outputBuffers3 = mediaCodec3.getOutputBuffers();
        ByteBuffer[] inputBuffers3 = mediaCodec4.getInputBuffers();
        ByteBuffer[] outputBuffers4 = mediaCodec4.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo3 = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo4 = new MediaCodec.BufferInfo();
        MediaFormat mediaFormat3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i2 = -1;
        boolean z8 = false;
        int i3 = -1;
        int i4 = -1;
        MediaFormat mediaFormat4 = null;
        ByteBuffer[] byteBufferArr3 = outputBuffers4;
        boolean z9 = false;
        while (true) {
            if ((!z4 || !z6) && !this.mIsStop) {
                if (z9 || !(mediaFormat3 == null || z7)) {
                    z = z9;
                } else if (!this.mIsStop) {
                    int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                    if (dequeueInputBuffer == -1) {
                        z = z9;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                        long sampleTime = mediaExtractor.getSampleTime();
                        if (readSampleData >= 0) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                        }
                        z = !mediaExtractor.advance();
                        if (z) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                    }
                } else {
                    return;
                }
                if (!z5 && (mediaFormat4 == null || z7)) {
                    if (!this.mIsStop) {
                        int dequeueInputBuffer2 = mediaCodec3.dequeueInputBuffer(10000L);
                        if (dequeueInputBuffer2 != -1) {
                            int readSampleData2 = mediaExtractor2.readSampleData(inputBuffers2[dequeueInputBuffer2], 0);
                            long sampleTime2 = mediaExtractor2.getSampleTime();
                            if (readSampleData2 >= 0) {
                                mediaCodec3.queueInputBuffer(dequeueInputBuffer2, 0, readSampleData2, sampleTime2, mediaExtractor2.getSampleFlags());
                            }
                            z5 = !mediaExtractor2.advance();
                            if (z5) {
                                mediaCodec3.queueInputBuffer(dequeueInputBuffer2, 0, 0, 0L, 4);
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (!z3 && (mediaFormat3 == null || z7)) {
                    if (!this.mIsStop) {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1) {
                            if (dequeueOutputBuffer == -3) {
                                outputBuffers = mediaCodec.getOutputBuffers();
                            } else if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else {
                                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                if ((bufferInfo.flags & 2) != 0) {
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                } else {
                                    boolean z10 = bufferInfo.size != 0;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z10);
                                    if (z10) {
                                        outputSurface.awaitNewImage();
                                        outputSurface.drawImage();
                                        inputSurface.setPresentationTime(bufferInfo.presentationTimeUs * 1000);
                                        inputSurface.swapBuffers();
                                    }
                                    if ((bufferInfo.flags & 4) != 0) {
                                        mediaCodec2.signalEndOfInputStream();
                                        z3 = true;
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (!z8 && i2 == -1 && (mediaFormat4 == null || z7)) {
                    if (!this.mIsStop) {
                        int dequeueOutputBuffer2 = mediaCodec3.dequeueOutputBuffer(bufferInfo3, 10000L);
                        if (dequeueOutputBuffer2 != -1) {
                            if (dequeueOutputBuffer2 == -3) {
                                outputBuffers3 = mediaCodec3.getOutputBuffers();
                            } else if (dequeueOutputBuffer2 == -2) {
                                mediaCodec3.getOutputFormat();
                            } else {
                                ByteBuffer byteBuffer2 = outputBuffers3[dequeueOutputBuffer2];
                                if ((bufferInfo3.flags & 2) != 0) {
                                    mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, false);
                                } else {
                                    i2 = dequeueOutputBuffer2;
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (i2 == -1) {
                    i = i2;
                    z2 = z8;
                } else if (!this.mIsStop) {
                    int dequeueInputBuffer3 = mediaCodec4.dequeueInputBuffer(10000L);
                    ByteBuffer byteBuffer3 = inputBuffers3[dequeueInputBuffer3];
                    int i5 = bufferInfo3.size;
                    long j = bufferInfo3.presentationTimeUs;
                    if (i5 >= 0) {
                        ByteBuffer duplicate = outputBuffers3[i2].duplicate();
                        duplicate.position(bufferInfo3.offset);
                        duplicate.limit(bufferInfo3.offset + i5);
                        byteBuffer3.position(0);
                        byteBuffer3.put(duplicate);
                        mediaCodec4.queueInputBuffer(dequeueInputBuffer3, 0, i5, j, bufferInfo3.flags);
                    }
                    mediaCodec3.releaseOutputBuffer(i2, false);
                    if ((bufferInfo3.flags & 4) != 0) {
                        i = -1;
                        z2 = true;
                    } else {
                        i = -1;
                        z2 = z8;
                    }
                } else {
                    return;
                }
                if (z4 || !(mediaFormat3 == null || z7)) {
                    mediaFormat = mediaFormat3;
                    byteBufferArr = outputBuffers2;
                } else if (!this.mIsStop) {
                    int dequeueOutputBuffer3 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
                    if (dequeueOutputBuffer3 == -1) {
                        mediaFormat = mediaFormat3;
                        byteBufferArr = outputBuffers2;
                    } else if (dequeueOutputBuffer3 == -3) {
                        mediaFormat = mediaFormat3;
                        byteBufferArr = mediaCodec2.getOutputBuffers();
                    } else if (dequeueOutputBuffer3 == -2) {
                        mediaFormat = mediaCodec2.getOutputFormat();
                        byteBufferArr = outputBuffers2;
                    } else {
                        ByteBuffer byteBuffer4 = outputBuffers2[dequeueOutputBuffer3];
                        if ((bufferInfo2.flags & 2) != 0) {
                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer3, false);
                            mediaFormat = mediaFormat3;
                            byteBufferArr = outputBuffers2;
                        } else {
                            if (bufferInfo2.size != 0) {
                                mediaMuxer.writeSampleData(i4, byteBuffer4, bufferInfo2);
                            }
                            boolean z11 = (bufferInfo2.flags & 4) != 0 ? true : z4;
                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer3, false);
                            z4 = z11;
                            mediaFormat = mediaFormat3;
                            byteBufferArr = outputBuffers2;
                        }
                    }
                } else {
                    return;
                }
                if (z6 || !(mediaFormat4 == null || z7)) {
                    mediaFormat2 = mediaFormat4;
                    byteBufferArr2 = byteBufferArr3;
                } else if (!this.mIsStop) {
                    int dequeueOutputBuffer4 = mediaCodec4.dequeueOutputBuffer(bufferInfo4, 10000L);
                    if (dequeueOutputBuffer4 == -1) {
                        mediaFormat2 = mediaFormat4;
                        byteBufferArr2 = byteBufferArr3;
                    } else if (dequeueOutputBuffer4 == -3) {
                        mediaFormat2 = mediaFormat4;
                        byteBufferArr2 = mediaCodec4.getOutputBuffers();
                    } else if (dequeueOutputBuffer4 == -2) {
                        mediaFormat2 = mediaCodec4.getOutputFormat();
                        byteBufferArr2 = byteBufferArr3;
                    } else {
                        ByteBuffer byteBuffer5 = byteBufferArr3[dequeueOutputBuffer4];
                        if ((bufferInfo4.flags & 2) != 0) {
                            mediaCodec4.releaseOutputBuffer(dequeueOutputBuffer4, false);
                            mediaFormat2 = mediaFormat4;
                            byteBufferArr2 = byteBufferArr3;
                        } else {
                            if (bufferInfo4.size != 0) {
                                mediaMuxer.writeSampleData(i3, byteBuffer5, bufferInfo4);
                            }
                            boolean z12 = (bufferInfo4.flags & 4) != 0 ? true : z6;
                            mediaCodec4.releaseOutputBuffer(dequeueOutputBuffer4, false);
                            z6 = z12;
                            mediaFormat2 = mediaFormat4;
                            byteBufferArr2 = byteBufferArr3;
                        }
                    }
                } else {
                    return;
                }
                if (z7 || mediaFormat2 == null || mediaFormat == null) {
                    i2 = i;
                    z8 = z2;
                    z9 = z;
                    mediaFormat4 = mediaFormat2;
                    byteBufferArr3 = byteBufferArr2;
                    mediaFormat3 = mediaFormat;
                    outputBuffers2 = byteBufferArr;
                } else {
                    int addTrack = mediaMuxer.addTrack(mediaFormat);
                    int addTrack2 = mediaMuxer.addTrack(mediaFormat2);
                    mediaMuxer.start();
                    z7 = true;
                    i2 = i;
                    z8 = z2;
                    i3 = addTrack2;
                    i4 = addTrack;
                    mediaFormat4 = mediaFormat2;
                    byteBufferArr3 = byteBufferArr2;
                    mediaFormat3 = mediaFormat;
                    z9 = z;
                    outputBuffers2 = byteBufferArr;
                }
            } else {
                return;
            }
        }
    }

    private static boolean isVideoFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("video/");
    }

    private static boolean isAudioFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("audio/");
    }

    private static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
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

    public void stop() {
        this.mIsStop = true;
    }

    public void setStateCallback(StateCallback stateCallback) {
        this.mStateCallback = stateCallback;
    }
}
