package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.cyberplayer.sdk.vrplayer.MovieView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class VrVideoView extends MovieView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberVRRenderProvider a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VrVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initVR();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VrVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initVR();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VrVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
        initVR();
    }

    private boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) ? ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072 : invokeL.booleanValue;
    }

    public CyberVRRenderProvider a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            CyberVRRenderProvider cyberVRRenderProvider = null;
            try {
                cyberVRRenderProvider = d.a(this.f25482b);
                cyberVRRenderProvider.displayMode(i2).interactiveMode(i).projectionMode(i3).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback(this) { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VrVideoView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                    public void onSurfaceReady(Surface surface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                            this.a.a(1, "surface ready");
                            this.a.f25483c = surface;
                            if (this.a.f25488h != null) {
                                this.a.f25488h.setSurface(surface);
                            } else {
                                this.a.e();
                            }
                            this.a.onOrientationChanged();
                            if (this.a.A != null) {
                                this.a.A.a();
                            }
                        }
                    }
                }).ifNotSupport(new CyberVRRenderProvider.INotSupportCallback(this) { // from class: com.baidu.cyberplayer.sdk.VrVideoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VrVideoView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.INotSupportCallback
                    public void onNotSupport(int i4) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.a.w == null) {
                            return;
                        }
                        this.a.w.onInfo(1, i4, null);
                    }
                }).pinchEnabled(false);
                return cyberVRRenderProvider;
            } catch (Exception e2) {
                e2.printStackTrace();
                return cyberVRRenderProvider;
            }
        }
        return (CyberVRRenderProvider) invokeIII.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberVRRenderProvider cyberVRRenderProvider = this.a;
            if (cyberVRRenderProvider == null) {
                CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
                return;
            }
            int i = this.P;
            if (i == 1) {
                cyberVRRenderProvider.init((SurfaceView) this.f25484d);
            } else if (i == 2) {
                cyberVRRenderProvider.init((TextureView) this.f25484d);
            } else {
                a(4, "GLView invalid type");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void a(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            if (this.a == null) {
                super.a(i, i2, i3, i4);
                return;
            }
            if (i4 > 0 && i3 > 0) {
                if (i3 > i4) {
                    i = (i * i3) / i4;
                } else {
                    i2 = (i2 * i4) / i3;
                }
            }
            this.a.onTextureResize(i, i2);
            a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i), Integer.valueOf(i2)));
            this.R = i;
            this.S = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (super.a(i)) {
                return true;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            if (i == 1) {
                View gLSurfaceView = new GLSurfaceView(getContext());
                this.f25484d = gLSurfaceView;
                addView(gLSurfaceView, 0, layoutParams);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            a(1, String.format("playerType:" + i + " interactiveMode:" + i2 + " displayMode:" + i3 + " projectionMode:" + i4 + " viewType:" + i5, new Object[0]));
            this.f25486f = false;
            this.i = i;
            this.M = i2;
            this.N = i3;
            this.O = i4;
            this.P = i5;
            CyberVRRenderProvider a = a(i2, i3, i4);
            this.a = a;
            if (a == null) {
                CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
                return false;
            }
            b(i5);
            a();
            return b(this.f25482b);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25486f || this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        cyberVRRenderProvider.onDestroy();
        this.a = null;
        this.T = MovieView.i.a;
    }

    public int getSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Q : invokeV.intValue;
    }

    public boolean initVR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == 0) {
                this.i = 1;
            }
            if (this.M == 0) {
                this.M = 5;
            }
            if (this.N == 0) {
                this.N = 101;
            }
            if (this.O == 0) {
                this.O = 201;
            }
            if (this.P == 0) {
                this.P = 1;
            }
            a(1, String.format("playerType:" + this.i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
            return a(this.i, this.M, this.N, this.O, this.P);
        }
        return invokeV.booleanValue;
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        cyberVRRenderProvider.onOrientationChanged();
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (cyberVRRenderProvider = this.a) != null && this.T == MovieView.i.f25496b) {
            cyberVRRenderProvider.onPause();
            this.T = MovieView.i.a;
        }
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        cyberVRRenderProvider.pinchEnabled(z);
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (cyberVRRenderProvider = this.a) != null && this.T == MovieView.i.a) {
            cyberVRRenderProvider.onResume();
            this.T = MovieView.i.f25496b;
        }
    }

    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.N = i;
            switchDisplayMode(i);
        }
    }

    public void setFov(float f2, float f3, float f4) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        cyberVRRenderProvider.setFov(f2, f3, f4);
    }

    public void setInteractiveMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.M = i;
            switchInteractiveMode(i);
        }
    }

    public void setProjectionMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.O = i;
            switchProjectionMode(i);
        }
    }

    public void setSourceType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.Q = i;
        }
    }

    public void switchDisplayMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        this.N = i;
        cyberVRRenderProvider.switchDisplayMode(i);
    }

    public void switchInteractiveMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        this.M = i;
        cyberVRRenderProvider.switchInteractiveMode(i);
    }

    public void switchProjectionMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (cyberVRRenderProvider = this.a) == null) {
            return;
        }
        this.O = i;
        cyberVRRenderProvider.switchProjectionMode(i);
    }
}
