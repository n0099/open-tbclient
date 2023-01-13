package com.baidu.sdk.container.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nh1;
import com.baidu.tieba.oh1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(14)
/* loaded from: classes2.dex */
public class BaseTextureView extends TextureView implements TextureView.SurfaceTextureListener, nh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public oh1 d;
    public SurfaceTexture e;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i, i2) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTextureView(Context context, oh1 oh1Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oh1Var};
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
        this.d = oh1Var;
        setSurfaceTextureListener(this);
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

    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (surfaceTexture = this.e) != null) {
            setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int defaultSize = TextureView.getDefaultSize(this.b, i);
            int defaultSize2 = TextureView.getDefaultSize(this.c, i2);
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
            Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.b), Integer.valueOf(this.c)));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        oh1 oh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i, i2) == null) && (oh1Var = this.d) != null) {
            oh1Var.b(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
            oh1 oh1Var = this.d;
            if (oh1Var != null) {
                oh1Var.a();
            }
            this.e = surfaceTexture;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.nh1
    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.tieba.nh1
    public void onVideoSizeChanged(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            this.b = i;
            this.c = i2;
            if (i != 0 && i2 != 0) {
                a();
            }
        }
    }
}
