package com.baidu.rtc.record;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RemoteAudioSamplesInterceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.c.i0;
import java.io.File;
import java.io.IOException;
import org.webrtc.VideoTrack;
/* loaded from: classes11.dex */
public class RTCMediaRecorderImpl implements IMediaRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RTCMediaRecorderImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteAudioSamplesInterceptor audioInterceptor;
    public boolean isRunning;
    public RTCVideoFileRenderer videoFileRenderer;
    public final VideoTrack videoTrack;

    public RTCMediaRecorderImpl(@Nullable VideoTrack videoTrack, @Nullable RemoteAudioSamplesInterceptor remoteAudioSamplesInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoTrack, remoteAudioSamplesInterceptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isRunning = false;
        this.videoTrack = videoTrack;
        this.audioInterceptor = remoteAudioSamplesInterceptor;
    }

    public boolean isRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isRunning : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
        r11.onRecordCompleted(false, "Is current recording with file path " + r9);
     */
    @Override // com.baidu.rtc.record.IMediaRecord
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void startRecording(String str, MediaEncodeParams mediaEncodeParams, RecorderCallback recorderCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, mediaEncodeParams, recorderCallback) == null) {
            synchronized (this) {
                if (!this.isRunning && !TextUtils.isEmpty(str) && mediaEncodeParams != null) {
                    File file = new File(str);
                    if (!file.getParentFile().exists()) {
                        try {
                            file.getParentFile().mkdirs();
                        } catch (Exception e2) {
                            if (recorderCallback != null) {
                                recorderCallback.onRecordCompleted(false, e2.getMessage());
                                return;
                            }
                            return;
                        }
                    }
                    if (this.videoTrack != null) {
                        if (mediaEncodeParams == null) {
                            try {
                                mediaEncodeParams = new MediaEncodeParams();
                            } catch (IOException e3) {
                                this.isRunning = false;
                                recorderCallback.onRecordCompleted(false, e3.getMessage());
                                return;
                            }
                        }
                        RTCVideoFileRenderer rTCVideoFileRenderer = new RTCVideoFileRenderer(file.getAbsolutePath(), mediaEncodeParams, i0.a().getEglBaseContext(), this.audioInterceptor != null, recorderCallback);
                        this.videoFileRenderer = rTCVideoFileRenderer;
                        this.videoTrack.addSink(rTCVideoFileRenderer);
                        if (this.audioInterceptor != null) {
                            this.audioInterceptor.attachCallback(this.videoFileRenderer);
                        }
                        if (recorderCallback != null) {
                            recorderCallback.onRecordStart();
                        }
                        this.isRunning = true;
                    } else {
                        if (this.audioInterceptor != null) {
                            recorderCallback.onRecordCompleted(false, "Audio only is not support, add video track");
                        }
                        this.isRunning = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.rtc.record.IMediaRecord
    public synchronized void stopRecording() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.isRunning) {
                    if (this.audioInterceptor != null) {
                        this.audioInterceptor.detachCallback();
                    }
                    if (this.videoTrack != null && this.videoFileRenderer != null) {
                        this.videoTrack.removeSink(this.videoFileRenderer);
                        this.videoFileRenderer.release();
                        this.videoFileRenderer = null;
                    }
                    this.isRunning = false;
                }
            }
        }
    }
}
