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
/* loaded from: classes2.dex */
public class VrVideoView extends MovieView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CyberVRRenderProvider f4847a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VrVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public VrVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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

    public CyberVRRenderProvider a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            CyberVRRenderProvider cyberVRRenderProvider = null;
            try {
                cyberVRRenderProvider = d.a(this.f5104b);
                cyberVRRenderProvider.displayMode(i3).interactiveMode(i2).projectionMode(i4).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback(this) { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VrVideoView f4849a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f4849a = this;
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                    public void onSurfaceReady(Surface surface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                            this.f4849a.a(1, "surface ready");
                            this.f4849a.f5105c = surface;
                            if (this.f4849a.f5110h != null) {
                                this.f4849a.f5110h.setSurface(surface);
                            } else {
                                this.f4849a.e();
                            }
                            this.f4849a.onOrientationChanged();
                            if (this.f4849a.A != null) {
                                this.f4849a.A.a();
                            }
                        }
                    }
                }).ifNotSupport(new CyberVRRenderProvider.INotSupportCallback(this) { // from class: com.baidu.cyberplayer.sdk.VrVideoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VrVideoView f4848a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f4848a = this;
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.INotSupportCallback
                    public void onNotSupport(int i5) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i5) == null) || this.f4848a.w == null) {
                            return;
                        }
                        this.f4848a.w.onInfo(1, i5, null);
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
            CyberVRRenderProvider cyberVRRenderProvider = this.f4847a;
            if (cyberVRRenderProvider == null) {
                CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
                return;
            }
            int i2 = this.P;
            if (i2 == 1) {
                cyberVRRenderProvider.init((SurfaceView) this.f5106d);
            } else if (i2 == 2) {
                cyberVRRenderProvider.init((TextureView) this.f5106d);
            } else {
                a(4, "GLView invalid type");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            if (this.f4847a == null) {
                super.a(i2, i3, i4, i5);
                return;
            }
            if (i5 > 0 && i4 > 0) {
                if (i4 > i5) {
                    i2 = (i2 * i4) / i5;
                } else {
                    i3 = (i3 * i5) / i4;
                }
            }
            this.f4847a.onTextureResize(i2, i3);
            a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i2), Integer.valueOf(i3)));
            this.R = i2;
            this.S = i3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (super.a(i2)) {
                return true;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            if (i2 == 1) {
                View gLSurfaceView = new GLSurfaceView(getContext());
                this.f5106d = gLSurfaceView;
                addView(gLSurfaceView, 0, layoutParams);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            a(1, String.format("playerType:" + i2 + " interactiveMode:" + i3 + " displayMode:" + i4 + " projectionMode:" + i5 + " viewType:" + i6, new Object[0]));
            this.f5108f = false;
            this.f5111i = i2;
            this.M = i3;
            this.N = i4;
            this.O = i5;
            this.P = i6;
            CyberVRRenderProvider a2 = a(i3, i4, i5);
            this.f4847a = a2;
            if (a2 == null) {
                CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
                return false;
            }
            b(i6);
            a();
            return b(this.f5104b);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5108f || this.f4847a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        cyberVRRenderProvider.onDestroy();
        this.f4847a = null;
        this.T = MovieView.i.f5127a;
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
            if (this.f5111i == 0) {
                this.f5111i = 1;
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
            a(1, String.format("playerType:" + this.f5111i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
            return a(this.f5111i, this.M, this.N, this.O, this.P);
        }
        return invokeV.booleanValue;
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        cyberVRRenderProvider.onOrientationChanged();
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (cyberVRRenderProvider = this.f4847a) != null && this.T == MovieView.i.f5128b) {
            cyberVRRenderProvider.onPause();
            this.T = MovieView.i.f5127a;
        }
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        cyberVRRenderProvider.pinchEnabled(z);
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (cyberVRRenderProvider = this.f4847a) != null && this.T == MovieView.i.f5127a) {
            cyberVRRenderProvider.onResume();
            this.T = MovieView.i.f5128b;
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.N = i2;
            switchDisplayMode(i2);
        }
    }

    public void setFov(float f2, float f3, float f4) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        cyberVRRenderProvider.setFov(f2, f3, f4);
    }

    public void setInteractiveMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.M = i2;
            switchInteractiveMode(i2);
        }
    }

    public void setProjectionMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.O = i2;
            switchProjectionMode(i2);
        }
    }

    public void setSourceType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.Q = i2;
        }
    }

    public void switchDisplayMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        this.N = i2;
        cyberVRRenderProvider.switchDisplayMode(i2);
    }

    public void switchInteractiveMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        this.M = i2;
        cyberVRRenderProvider.switchInteractiveMode(i2);
    }

    public void switchProjectionMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (cyberVRRenderProvider = this.f4847a) == null) {
            return;
        }
        this.O = i2;
        cyberVRRenderProvider.switchProjectionMode(i2);
    }
}
