package com.baidu.rtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.EglBase;
import org.webrtc.EglBase_CC;
import org.webrtc.GlRectDrawer;
import org.webrtc.Logging;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceEglRenderer;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
/* loaded from: classes5.dex */
public class RTCVideoExternalRenderImp extends RTCVideoExternalRender implements RendererCommon.RendererEvents {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ExternalRenderImp";
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceEglRenderer eglRenderer;
    public Boolean hasSurface;
    public SurfaceHolder holder;
    public boolean isGetDimension;
    public RendererCommon.RendererEvents rendererEvents;
    public BaiduRtcRoom.BaiduRtcRoomDelegate roomDelegate;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    public Surface surface;
    public long userId;
    public int videoHeight;
    public int videoRotation;
    public int videoWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCVideoExternalRenderImp(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate, long j2) {
        super(null, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduRtcRoomDelegate, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaiduRtcRoom.BaiduRtcRoomVideoObserver) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoRotation = 0;
        this.isGetDimension = false;
        this.hasSurface = Boolean.FALSE;
        this.roomDelegate = baiduRtcRoomDelegate;
        this.userId = j2;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCVideoExternalRenderImp(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, long j2) {
        super(null, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rendererEvents, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaiduRtcRoom.BaiduRtcRoomVideoObserver) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoRotation = 0;
        this.isGetDimension = false;
        this.hasSurface = Boolean.FALSE;
        this.userId = j2;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j2));
        init(context, rendererEvents);
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void changeSurfaceSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            setLayoutAspect(i2 / i3);
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void clearImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.eglRenderer.clearImage();
        }
    }

    public void disableFpsReduction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.eglRenderer.disableFpsReduction();
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public Surface getSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.surface : (Surface) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.videoHeight : invokeV.intValue;
    }

    public int getVideoRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.videoRotation : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.videoWidth : invokeV.intValue;
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public boolean hasSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.hasSurface.booleanValue() : invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Logging.d(TAG, this.userId + " : External renderer init");
            init(EglBase_CC.create().getEglBaseContext(), null);
        }
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, rendererEvents) == null) {
            init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
        }
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, context, rendererEvents, iArr, glDrawer) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.rendererEvents = rendererEvents;
            this.rotatedFrameWidth = 0;
            this.rotatedFrameHeight = 0;
            this.eglRenderer.init(context, this, iArr, glDrawer);
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (rendererEvents = this.rendererEvents) == null) {
            return;
        }
        rendererEvents.onFirstFrameRendered();
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, videoFrame) == null) {
            Logging.d(TAG, this.userId + " : onFrame time stamp:" + videoFrame.getTimestampNs());
            if (!this.isGetDimension) {
                this.videoWidth = videoFrame.getBuffer().getWidth();
                this.videoHeight = videoFrame.getBuffer().getHeight();
                this.videoRotation = videoFrame.getRotation();
                this.isGetDimension = true;
            }
            this.eglRenderer.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i2, i3, i4) == null) {
            this.videoWidth = i2;
            this.videoHeight = i3;
            this.videoRotation = i4;
            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.roomDelegate;
            if (baiduRtcRoomDelegate != null) {
                baiduRtcRoomDelegate.onRoomEventUpdate(500, this.userId, null);
            }
            RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
            if (rendererEvents != null) {
                rendererEvents.onFrameResolutionChanged(i2, i3, i4);
            }
        }
    }

    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.eglRenderer.pauseVideo();
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Logging.d(TAG, this.userId + " : External renderer release");
            this.eglRenderer.release();
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void releaseSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.eglRenderer.surfaceDestroyed(this.holder);
            this.hasSurface = Boolean.FALSE;
            this.surface = null;
            Logging.d(TAG, this.userId + " : External renderer release surface " + this.surface);
        }
    }

    public void setFpsReduction(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.eglRenderer.setFpsReduction(f2);
        }
    }

    public void setLayoutAspect(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.eglRenderer.setLayoutAspectRatio(f2);
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.eglRenderer.setMirror(z);
        }
    }

    public void setRoomDelegate(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, baiduRtcRoomDelegate) == null) {
            this.roomDelegate = baiduRtcRoomDelegate;
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void setSurface(Surface surface) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, surface) == null) {
            if (surface == null || this.surface == surface) {
                str = this.userId + " : Set remote surface fail! cause surface: " + surface;
            } else {
                if (this.hasSurface.booleanValue() && this.surface != null) {
                    releaseSurface();
                }
                this.surface = surface;
                SurfaceHolder surfaceHolder = new SurfaceHolder(this) { // from class: com.baidu.rtc.RTCVideoExternalRenderImp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RTCVideoExternalRenderImp this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.SurfaceHolder
                    public void addCallback(SurfaceHolder.Callback callback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, callback) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public Surface getSurface() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.surface : (Surface) invokeV.objValue;
                    }

                    @Override // android.view.SurfaceHolder
                    public Rect getSurfaceFrame() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return null;
                        }
                        return (Rect) invokeV.objValue;
                    }

                    @Override // android.view.SurfaceHolder
                    public boolean isCreating() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                            return true;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // android.view.SurfaceHolder
                    public Canvas lockCanvas() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                            return null;
                        }
                        return (Canvas) invokeV.objValue;
                    }

                    @Override // android.view.SurfaceHolder
                    public Canvas lockCanvas(Rect rect) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, rect)) == null) {
                            return null;
                        }
                        return (Canvas) invokeL.objValue;
                    }

                    @Override // android.view.SurfaceHolder
                    public void removeCallback(SurfaceHolder.Callback callback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048582, this, callback) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void setFixedSize(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048583, this, i2, i3) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void setFormat(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void setKeepScreenOn(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048585, this, z) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void setSizeFromLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void setType(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048587, this, i2) == null) {
                        }
                    }

                    @Override // android.view.SurfaceHolder
                    public void unlockCanvasAndPost(Canvas canvas) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048588, this, canvas) == null) {
                        }
                    }
                };
                this.holder = surfaceHolder;
                this.eglRenderer.surfaceCreated(surfaceHolder);
                this.hasSurface = Boolean.TRUE;
                str = this.userId + " : External renderer set surface =" + this.surface;
            }
            Logging.d(TAG, str);
        }
    }
}
