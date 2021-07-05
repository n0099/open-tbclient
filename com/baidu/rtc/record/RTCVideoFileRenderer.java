package com.baidu.rtc.record;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.webrtc.EglBase;
import org.webrtc.EglBase_CC;
import org.webrtc.GlRectDrawer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;
import org.webrtc.VideoSink;
/* loaded from: classes3.dex */
public class RTCVideoFileRenderer implements VideoSink, RTCAudioSamples.RTCRemoteSamplesReadyCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRE_PREIOD_AUDIO_BUFFER_SIZE = 3840;
    public static final String TAG = "RTCVideoFileRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec.BufferInfo audioBufferInfo;
    public volatile int audioEncodeBufferSize;
    public MediaCodec audioEncoder;
    public ByteBuffer[] audioInputBuffers;
    public ByteBuffer[] audioOutputBuffers;
    public final HandlerThread audioThread;
    public final Handler audioThreadHandler;
    public int audioTrackIndex;
    public GlRectDrawer drawer;
    public EglBase eglBase;
    public MediaEncodeParams encodeParams;
    public boolean encoderStarted;
    public VideoFrameDrawer frameDrawer;
    public boolean isRunning;
    public byte[] mByteBuffer;
    public final RecorderCallback mCallback;
    public MediaMuxer mediaMuxer;
    public volatile boolean muxerStarted;
    public final String outputFileName;
    public long presTime;
    public final HandlerThread renderThread;
    public final Handler renderThreadHandler;
    public EglBase.Context sharedContext;
    public Surface surface;
    public int trackIndex;
    public MediaCodec.BufferInfo videoBufferInfo;
    public MediaCodec videoEncoder;
    public long videoFrameStart;
    public ByteBuffer[] videoOutputBuffers;

    public RTCVideoFileRenderer(String str, MediaEncodeParams mediaEncodeParams, EglBase.Context context, boolean z, RecorderCallback recorderCallback) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mediaEncodeParams, context, Boolean.valueOf(z), recorderCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackIndex = -1;
        this.isRunning = true;
        this.encoderStarted = false;
        this.muxerStarted = false;
        this.videoFrameStart = 0L;
        this.presTime = 0L;
        this.audioEncodeBufferSize = 0;
        this.mByteBuffer = null;
        this.encodeParams = mediaEncodeParams;
        if (mediaEncodeParams == null) {
            this.encodeParams = new MediaEncodeParams();
        }
        this.outputFileName = str;
        HandlerThread handlerThread = new HandlerThread("RTCVideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        this.renderThreadHandler = new Handler(this.renderThread.getLooper());
        if (z) {
            HandlerThread handlerThread2 = new HandlerThread("RTCVideoFileRendererAudioThread");
            this.audioThread = handlerThread2;
            handlerThread2.start();
            this.audioThreadHandler = new Handler(this.audioThread.getLooper());
            this.mByteBuffer = new byte[3840];
        } else {
            this.audioThread = null;
            this.audioThreadHandler = null;
        }
        this.videoBufferInfo = new MediaCodec.BufferInfo();
        this.sharedContext = context;
        this.mediaMuxer = new MediaMuxer(this.outputFileName, this.encodeParams.getOutputFormat());
        this.audioTrackIndex = z ? -1 : 0;
        this.mCallback = recorderCallback;
    }

    private void audioSamplesRecord(final RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rTCAudioSamples) == null) || rTCAudioSamples == null) {
            return;
        }
        this.audioThreadHandler.post(new Runnable() { // from class: com.baidu.rtc.record._$$Lambda$RTCVideoFileRenderer$IR4KFudZn8pFkt9qCB0HXfxm5xE
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RTCVideoFileRenderer.lambda$audioSamplesRecord$2(RTCVideoFileRenderer.this, rTCAudioSamples);
                }
            }
        });
    }

    private void drainAudio() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65538, this) != null) {
            return;
        }
        if (this.audioBufferInfo == null) {
            this.audioBufferInfo = new MediaCodec.BufferInfo();
        }
        while (true) {
            int dequeueOutputBuffer = this.audioEncoder.dequeueOutputBuffer(this.audioBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                this.audioOutputBuffers = this.audioEncoder.getOutputBuffers();
                Log.w(TAG, "encoder output buffers changed");
            } else {
                boolean z = true;
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.audioEncoder.getOutputFormat();
                    Log.w(TAG, "audio encoder output format changed: " + outputFormat);
                    this.audioTrackIndex = this.mediaMuxer.addTrack(outputFormat);
                    if (this.trackIndex != -1 && !this.muxerStarted) {
                        this.mediaMuxer.start();
                        this.muxerStarted = true;
                    }
                    if (!this.muxerStarted) {
                        return;
                    }
                } else if (dequeueOutputBuffer < 0) {
                    Log.e(TAG, "unexpected on audio encoder dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    try {
                        ByteBuffer byteBuffer = this.audioOutputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            Log.e(TAG, "encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            return;
                        }
                        byteBuffer.position(this.audioBufferInfo.offset);
                        byteBuffer.limit(this.audioBufferInfo.offset + this.audioBufferInfo.size);
                        if (this.muxerStarted && this.mediaMuxer != null) {
                            this.mediaMuxer.writeSampleData(this.audioTrackIndex, byteBuffer, this.audioBufferInfo);
                        }
                        if (!this.isRunning || (this.audioBufferInfo.flags & 4) != 0) {
                            z = false;
                        }
                        this.isRunning = z;
                        this.audioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.audioBufferInfo.flags & 4) != 0) {
                            return;
                        }
                    } catch (Exception e2) {
                        Log.e(TAG, e2.getMessage());
                        return;
                    }
                }
            }
        }
    }

    private void drainVideo() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        if (!this.encoderStarted) {
            this.videoEncoder.start();
            this.videoOutputBuffers = this.videoEncoder.getOutputBuffers();
            this.encoderStarted = true;
            return;
        }
        while (true) {
            int dequeueOutputBuffer = this.videoEncoder.dequeueOutputBuffer(this.videoBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                this.videoOutputBuffers = this.videoEncoder.getOutputBuffers();
                str = "video encoder output buffers changed";
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.videoEncoder.getOutputFormat();
                Log.e(TAG, "video encoder output format changed: " + outputFormat);
                this.trackIndex = this.mediaMuxer.addTrack(outputFormat);
                if (this.audioTrackIndex != -1 && !this.muxerStarted) {
                    this.mediaMuxer.start();
                    this.muxerStarted = true;
                }
                if (!this.muxerStarted) {
                    return;
                }
            } else if (dequeueOutputBuffer < 0) {
                str = "unexpected on video encoder dequeueOutputBuffer: " + dequeueOutputBuffer;
            } else {
                try {
                    ByteBuffer byteBuffer = this.videoOutputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        Log.e(TAG, "encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                        return;
                    }
                    byteBuffer.position(this.videoBufferInfo.offset);
                    byteBuffer.limit(this.videoBufferInfo.offset + this.videoBufferInfo.size);
                    if (this.videoFrameStart == 0 && this.videoBufferInfo.presentationTimeUs != 0) {
                        this.videoFrameStart = this.videoBufferInfo.presentationTimeUs;
                    }
                    this.videoBufferInfo.presentationTimeUs -= this.videoFrameStart;
                    if (this.muxerStarted && this.mediaMuxer != null) {
                        this.mediaMuxer.writeSampleData(this.trackIndex, byteBuffer, this.videoBufferInfo);
                    }
                    this.isRunning = this.isRunning && (this.videoBufferInfo.flags & 4) == 0;
                    this.videoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.videoBufferInfo.flags & 4) != 0) {
                        return;
                    }
                } catch (Exception e2) {
                    Log.wtf(TAG, e2);
                    return;
                }
            }
            Log.e(TAG, str);
        }
    }

    private void initStartAudioEncoder(RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, rTCAudioSamples) == null) {
            try {
                this.encodeParams.setAudioSampleRate(rTCAudioSamples.getSampleRate());
                this.audioEncoder = MediaCodec.createEncoderByType(this.encodeParams.getAudioCodec());
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString(IMediaFormat.KEY_MIME, this.encodeParams.getAudioCodec());
                mediaFormat.setInteger("channel-count", this.encodeParams.getAudioChannel());
                mediaFormat.setInteger("sample-rate", this.encodeParams.getAudioSampleRate());
                mediaFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.encodeParams.getAudioBitrate());
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("max-input-size", 3840);
                this.audioEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                this.audioEncoder.start();
                this.audioInputBuffers = this.audioEncoder.getInputBuffers();
                this.audioOutputBuffers = this.audioEncoder.getOutputBuffers();
            } catch (IOException e2) {
                Log.e(TAG, e2.getMessage());
            }
        }
    }

    private void initVideoEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.encodeParams.getVideoCodec(), this.encodeParams.getVideoWidth(), this.encodeParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.encodeParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", this.encodeParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", this.encodeParams.getVideoIFrameInterval());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.encodeParams.getVideoCodec());
                this.videoEncoder = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.renderThreadHandler.post(new Runnable() { // from class: com.baidu.rtc.record._$$Lambda$RTCVideoFileRenderer$4X3W21YKlCQ0fnPh79e7wedKXWM
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RTCVideoFileRenderer.lambda$initVideoEncoder$0(RTCVideoFileRenderer.this);
                        }
                    }
                });
            } catch (Exception e2) {
                Log.wtf(TAG, e2);
            }
        }
    }

    public static /* synthetic */ void lambda$audioSamplesRecord$2(RTCVideoFileRenderer rTCVideoFileRenderer, RTCAudioSamples rTCAudioSamples) {
        if (rTCVideoFileRenderer.audioEncoder == null) {
            rTCVideoFileRenderer.initStartAudioEncoder(rTCAudioSamples);
        }
        int dequeueInputBuffer = rTCVideoFileRenderer.audioEncoder.dequeueInputBuffer(0L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = rTCVideoFileRenderer.audioInputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byte[] data = rTCAudioSamples.getData();
            byteBuffer.put(data);
            rTCVideoFileRenderer.audioEncoder.queueInputBuffer(dequeueInputBuffer, 0, data.length, rTCVideoFileRenderer.presTime, 0);
            rTCVideoFileRenderer.presTime += ((data.length / 2) * 1000000) / rTCVideoFileRenderer.encodeParams.getAudioSampleRate();
        }
        rTCVideoFileRenderer.drainAudio();
    }

    public static /* synthetic */ void lambda$initVideoEncoder$0(RTCVideoFileRenderer rTCVideoFileRenderer) {
        rTCVideoFileRenderer.eglBase = EglBase_CC.create(rTCVideoFileRenderer.sharedContext, EglBase.CONFIG_RECORDABLE);
        Surface createInputSurface = rTCVideoFileRenderer.videoEncoder.createInputSurface();
        rTCVideoFileRenderer.surface = createInputSurface;
        rTCVideoFileRenderer.eglBase.createSurface(createInputSurface);
        rTCVideoFileRenderer.eglBase.makeCurrent();
        rTCVideoFileRenderer.drawer = new GlRectDrawer();
    }

    public static /* synthetic */ void lambda$release$3(RTCVideoFileRenderer rTCVideoFileRenderer) {
        Log.w(TAG, "stop audio encoder ...");
        MediaCodec mediaCodec = rTCVideoFileRenderer.audioEncoder;
        if (mediaCodec != null) {
            mediaCodec.flush();
            rTCVideoFileRenderer.audioEncoder.stop();
            rTCVideoFileRenderer.audioEncoder.release();
            rTCVideoFileRenderer.audioEncoder = null;
        }
        try {
            if (rTCVideoFileRenderer.mediaMuxer != null && rTCVideoFileRenderer.muxerStarted) {
                rTCVideoFileRenderer.mediaMuxer.stop();
                rTCVideoFileRenderer.mediaMuxer.release();
                if (rTCVideoFileRenderer.mCallback != null) {
                    rTCVideoFileRenderer.mCallback.onRecordCompleted(true, rTCVideoFileRenderer.outputFileName);
                }
            } else if (rTCVideoFileRenderer.mCallback != null) {
                rTCVideoFileRenderer.mCallback.onRecordCompleted(false, "Record is not started!");
            }
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Stop media muxer exception : " + e2.getLocalizedMessage());
            RecorderCallback recorderCallback = rTCVideoFileRenderer.mCallback;
            if (recorderCallback != null) {
                recorderCallback.onRecordCompleted(false, e2.getLocalizedMessage());
            }
        }
        rTCVideoFileRenderer.audioThread.quit();
    }

    public static /* synthetic */ void lambda$release$4(RTCVideoFileRenderer rTCVideoFileRenderer) {
        Log.w(TAG, "stop video encoder ...");
        MediaCodec mediaCodec = rTCVideoFileRenderer.videoEncoder;
        if (mediaCodec != null) {
            mediaCodec.flush();
            rTCVideoFileRenderer.videoEncoder.stop();
            rTCVideoFileRenderer.videoEncoder.release();
            rTCVideoFileRenderer.videoEncoder = null;
        }
        rTCVideoFileRenderer.renderThread.quit();
        EglBase eglBase = rTCVideoFileRenderer.eglBase;
        if (eglBase != null) {
            eglBase.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, videoFrame) == null) {
            if (this.frameDrawer == null) {
                this.frameDrawer = new VideoFrameDrawer();
            }
            this.frameDrawer.drawFrame(videoFrame, this.drawer, null, 0, 0, this.encodeParams.getVideoWidth(), this.encodeParams.getVideoHeight());
            videoFrame.release();
            drainVideo();
            this.eglBase.swapBuffers();
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoFrame) == null) {
            videoFrame.retain();
            if (this.videoEncoder == null) {
                initVideoEncoder();
            }
            this.renderThreadHandler.post(new Runnable() { // from class: com.baidu.rtc.record._$$Lambda$RTCVideoFileRenderer$Z3ulws2pi3dcvoGS1q2LU3OTpMQ
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        RTCVideoFileRenderer.this.renderFrameOnRenderThread(videoFrame);
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCRemoteSamplesReadyCallback
    public void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rTCAudioSamples) == null) {
            if (this.audioEncodeBufferSize + rTCAudioSamples.getData().length > 3840) {
                RTCAudioSamples rTCAudioSamples2 = new RTCAudioSamples(rTCAudioSamples.getAudioFormat(), rTCAudioSamples.getChannelCount(), rTCAudioSamples.getSampleRate(), Arrays.copyOfRange(this.mByteBuffer, 0, this.audioEncodeBufferSize));
                this.audioEncodeBufferSize = 0;
                audioSamplesRecord(rTCAudioSamples2);
            }
            System.arraycopy(rTCAudioSamples.getData(), 0, this.mByteBuffer, this.audioEncodeBufferSize, rTCAudioSamples.getData().length);
            this.audioEncodeBufferSize += rTCAudioSamples.getData().length;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.isRunning = false;
            Handler handler = this.audioThreadHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.rtc.record._$$Lambda$RTCVideoFileRenderer$3Rniwa9Q_TpRL66PXoAH_jTeAC0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RTCVideoFileRenderer.lambda$release$3(RTCVideoFileRenderer.this);
                        }
                    }
                });
            }
            Handler handler2 = this.renderThreadHandler;
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: com.baidu.rtc.record._$$Lambda$RTCVideoFileRenderer$L4ugvnTVIS7nvLQRQyzDiLIBHRY
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RTCVideoFileRenderer.lambda$release$4(RTCVideoFileRenderer.this);
                        }
                    }
                });
            }
        }
    }
}
