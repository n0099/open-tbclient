package com.baidu.sdk.container.player;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sl1;
import com.baidu.tieba.tl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, tl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public sl1 d;

    public void setEndSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, surfaceHolder, i, i2, i3) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSurfaceView(Context context, sl1 sl1Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sl1Var};
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
        this.a = 1;
        this.d = sl1Var;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int defaultSize = SurfaceView.getDefaultSize(this.b, i);
            int defaultSize2 = SurfaceView.getDefaultSize(this.c, i2);
            int i4 = this.b;
            if (i4 > 0 && (i3 = this.c) > 0) {
                int i5 = this.a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 != 5) {
                                    if (i5 != 6) {
                                        if (i5 == 7) {
                                            if (i4 * defaultSize2 > defaultSize * i3) {
                                                defaultSize = (i4 * defaultSize2) / i3;
                                            } else if (i4 * defaultSize2 < defaultSize * i3) {
                                                defaultSize2 = (i3 * defaultSize) / i4;
                                            }
                                        }
                                    } else {
                                        defaultSize = (i4 * defaultSize2) / i3;
                                    }
                                } else {
                                    int i6 = defaultSize * 3;
                                    int i7 = defaultSize2 * 4;
                                    if (i6 < i7) {
                                        defaultSize2 = i6 / 4;
                                    } else if (i6 > i7) {
                                        defaultSize = i7 / 3;
                                    }
                                }
                            } else {
                                int i8 = defaultSize * 9;
                                int i9 = defaultSize2 * 16;
                                if (i8 < i9) {
                                    defaultSize2 = i8 / 16;
                                } else if (i8 > i9) {
                                    defaultSize = i9 / 9;
                                }
                            }
                        } else {
                            defaultSize = i4;
                            defaultSize2 = i3;
                        }
                    } else if (i4 * defaultSize2 > defaultSize * i3) {
                        defaultSize2 = (i3 * defaultSize) / i4;
                    } else if (i4 * defaultSize2 < defaultSize * i3) {
                        defaultSize = (i4 * defaultSize2) / i3;
                    }
                } else if (i2 * i4 > i * i3 && i4 * defaultSize2 > defaultSize * i3) {
                    defaultSize2 = (i3 * defaultSize) / i4;
                }
            }
            Log.d("BaseSurfaceView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.b), Integer.valueOf(this.c)));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // com.baidu.tieba.tl1
    public void onVideoSizeChanged(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.b = i;
            this.c = i2;
            if (i != 0 && i2 != 0) {
                a();
            }
        }
    }

    @Override // com.baidu.tieba.tl1
    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a = i;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        sl1 sl1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) && (sl1Var = this.d) != null) {
            sl1Var.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        sl1 sl1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) && (sl1Var = this.d) != null) {
            sl1Var.b();
        }
    }
}
