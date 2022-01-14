package com.baidu.sdk.container.player;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import c.a.m0.a.j.b;
import c.a.m0.a.j.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f38238e;

    /* renamed from: f  reason: collision with root package name */
    public int f38239f;

    /* renamed from: g  reason: collision with root package name */
    public int f38240g;

    /* renamed from: h  reason: collision with root package name */
    public b f38241h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSurfaceView(Context context, b bVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
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
        this.f38238e = 1;
        this.f38241h = bVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38238e : invokeV.intValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int defaultSize = SurfaceView.getDefaultSize(this.f38239f, i2);
            int defaultSize2 = SurfaceView.getDefaultSize(this.f38240g, i3);
            int i5 = this.f38239f;
            if (i5 > 0 && (i4 = this.f38240g) > 0) {
                int i6 = this.f38238e;
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
            String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f38239f), Integer.valueOf(this.f38240g));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // c.a.m0.a.j.c
    public void onVideoSizeChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f38239f = i2;
            this.f38240g = i3;
            if (i2 == 0 || i3 == 0) {
                return;
            }
            a();
        }
    }

    @Override // c.a.m0.a.j.c
    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38238e = i2;
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
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) || (bVar = this.f38241h) == null) {
            return;
        }
        bVar.surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) || (bVar = this.f38241h) == null) {
            return;
        }
        bVar.a();
    }
}
