package com.baidu.nadcore.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.j;
import c.a.c0.s.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class SurfaceView extends android.view.SurfaceView implements SurfaceHolder.Callback, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f38074e;

    /* renamed from: f  reason: collision with root package name */
    public int f38075f;

    /* renamed from: g  reason: collision with root package name */
    public int f38076g;

    /* renamed from: h  reason: collision with root package name */
    public final j f38077h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceView(Context context, j jVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jVar};
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
        this.f38074e = 1;
        this.f38077h = jVar;
        getHolder().addCallback(this);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            requestLayout();
            invalidate();
        }
    }

    public int getDisplayMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38074e : invokeV.intValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int defaultSize = android.view.SurfaceView.getDefaultSize(this.f38075f, i2);
            int defaultSize2 = android.view.SurfaceView.getDefaultSize(this.f38076g, i3);
            int i5 = this.f38075f;
            if (i5 > 0 && (i4 = this.f38076g) > 0) {
                int i6 = this.f38074e;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 == 3) {
                            defaultSize = i5;
                            defaultSize2 = i4;
                        } else if (i6 == 4) {
                            int i7 = defaultSize * 9;
                            int i8 = defaultSize2 * 16;
                            if (i7 < i8) {
                                defaultSize2 = i7 / 16;
                            } else if (i7 > i8) {
                                defaultSize = i8 / 9;
                            }
                        } else if (i6 == 5) {
                            int i9 = defaultSize * 3;
                            int i10 = defaultSize2 * 4;
                            if (i9 < i10) {
                                defaultSize2 = i9 / 4;
                            } else if (i9 > i10) {
                                defaultSize = i10 / 3;
                            }
                        } else if (i6 == 6) {
                            defaultSize = (i5 * defaultSize2) / i4;
                        } else if (i6 == 7) {
                            if (i5 * defaultSize2 > defaultSize * i4) {
                                defaultSize = (i5 * defaultSize2) / i4;
                            } else if (i5 * defaultSize2 < defaultSize * i4) {
                                defaultSize2 = (i4 * defaultSize) / i5;
                            }
                        }
                    } else if (i5 * defaultSize2 > defaultSize * i4) {
                        defaultSize2 = (i4 * defaultSize) / i5;
                    } else if (i5 * defaultSize2 < defaultSize * i4) {
                        defaultSize = (i5 * defaultSize2) / i4;
                    }
                } else if (i3 * i5 > i2 * i4 && i5 * defaultSize2 > defaultSize * i4) {
                    defaultSize2 = (i4 * defaultSize) / i5;
                }
            }
            String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f38075f), Integer.valueOf(this.f38076g));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // c.a.c0.s.k
    public void onVideoSizeChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f38075f = i2;
            this.f38076g = i3;
            if (i2 == 0 || i3 == 0) {
                return;
            }
            a();
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38074e = i2;
        }
    }

    public void setEndSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) || (jVar = this.f38077h) == null) {
            return;
        }
        jVar.surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) || (jVar = this.f38077h) == null) {
            return;
        }
        jVar.a();
    }
}
