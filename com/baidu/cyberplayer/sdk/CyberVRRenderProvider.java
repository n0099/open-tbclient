package com.baidu.cyberplayer.sdk;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes2.dex */
public abstract class CyberVRRenderProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes2.dex */
    public interface INotSupportCallback {
        void onNotSupport(int i);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface IOnSurfaceReadyCallback {
        void onSurfaceReady(Surface surface);
    }

    public CyberVRRenderProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract CyberVRRenderProvider asVideo(IOnSurfaceReadyCallback iOnSurfaceReadyCallback);

    public abstract CyberVRRenderProvider displayMode(int i);

    public abstract CyberVRRenderProvider ifNotSupport(INotSupportCallback iNotSupportCallback);

    public abstract void init(SurfaceView surfaceView);

    public abstract void init(TextureView textureView);

    public abstract CyberVRRenderProvider interactiveMode(int i);

    public abstract void onDestroy();

    public abstract void onOrientationChanged();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onTextureResize(float f, float f2);

    public abstract CyberVRRenderProvider pinchEnabled(boolean z);

    public abstract CyberVRRenderProvider projectionMode(int i);

    public abstract CyberVRRenderProvider setFov(float f, float f2, float f3);

    public abstract void switchDisplayMode(int i);

    public abstract void switchInteractiveMode(int i);

    public abstract void switchProjectionMode(int i);
}
