package com.baidu.searchbox.afx.recode;

import android.content.res.AssetFileDescriptor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import org.webrtc.HardwareVideoEncoder;
/* loaded from: classes2.dex */
public class Mp4ComposerEngine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PROGRESS_INTERVAL_STEPS = 10;
    public static final float PROGRESS_UNKNOWN = -1.0f;
    public static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 10;
    public static final String TAG = "Mp4ComposerEngine";
    public transient /* synthetic */ FieldHolder $fh;
    public long mDurationUs;
    public ProgressCallback mProgressCallback;

    /* loaded from: classes2.dex */
    public interface ProgressCallback {
        void onProgress(float f2);
    }

    public Mp4ComposerEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void runPipelinesNoAudio(VideoTrackTranscoder videoTrackTranscoder) {
        ProgressCallback progressCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, videoTrackTranscoder) == null) {
            if (this.mDurationUs <= 0 && (progressCallback = this.mProgressCallback) != null) {
                progressCallback.onProgress(-1.0f);
            }
            long j = 0;
            while (!videoTrackTranscoder.isFinished()) {
                boolean stepPipeline = videoTrackTranscoder.stepPipeline();
                j++;
                if (this.mDurationUs > 0 && j % 10 == 0) {
                    float min = videoTrackTranscoder.isFinished() ? 1.0f : Math.min(1.0f, ((float) videoTrackTranscoder.getWrittenPresentationTimeUs()) / ((float) this.mDurationUs));
                    ProgressCallback progressCallback2 = this.mProgressCallback;
                    if (progressCallback2 != null) {
                        progressCallback2.onProgress(min);
                    }
                }
                if (!stepPipeline) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public static MediaCodecInfo selectCodec(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
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
        return (MediaCodecInfo) invokeL.objValue;
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaExtractor)) == null) {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                if (mediaExtractor.getTrackFormat(i2).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void compose(FileDescriptor fileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fileDescriptor, str, mp4Info) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(fileDescriptor);
            compose(mediaExtractor, str, mp4Info);
        }
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, progressCallback) == null) {
            this.mProgressCallback = progressCallback;
        }
    }

    public void compose(AssetFileDescriptor assetFileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, assetFileDescriptor, str, mp4Info) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            if (assetFileDescriptor.getDeclaredLength() < 0) {
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor());
            } else {
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            compose(mediaExtractor, str, mp4Info);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void compose(MediaExtractor mediaExtractor, String str, Mp4Info mp4Info) throws IOException {
        MediaMuxer mediaMuxer;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65537, this, mediaExtractor, str, mp4Info) != null) {
            return;
        }
        VideoTrackTranscoder videoTrackTranscoder = null;
        try {
            int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
            if (selectVideoTrackIndex >= 0) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
                String string = trackFormat.getString("mime");
                int i2 = 25;
                try {
                    i2 = trackFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    Log.e(TAG, "get frame rate (FPS) failed.", e2);
                }
                this.mDurationUs = mp4Info.getDurationUs();
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(string, mp4Info.getWidth(), mp4Info.getHeight());
                createVideoFormat.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, 0);
                createVideoFormat.setInteger("bitrate", mp4Info.getBitrate() * 3);
                createVideoFormat.setInteger("frame-rate", i2);
                createVideoFormat.setInteger("i-frame-interval", 0);
                createVideoFormat.setInteger("color-format", 2130708361);
                mediaMuxer = new MediaMuxer(str, 0);
                try {
                    VideoTrackTranscoder videoTrackTranscoder2 = new VideoTrackTranscoder(mediaExtractor, selectVideoTrackIndex, createVideoFormat, new QueuedMuxer(mediaMuxer));
                    try {
                        videoTrackTranscoder2.setup(mp4Info);
                        mediaExtractor.selectTrack(selectVideoTrackIndex);
                        runPipelinesNoAudio(videoTrackTranscoder2);
                        mediaMuxer.stop();
                        videoTrackTranscoder2.release();
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        mediaMuxer.release();
                    } catch (Throwable th) {
                        videoTrackTranscoder = videoTrackTranscoder2;
                        th = th;
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
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                Log.e(TAG, "No video track found in " + str);
                throw new RuntimeException("No video track found in " + str);
            }
        } catch (Throwable th3) {
            th = th3;
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
}
