package com.baidu.nadcore.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.k;
import c.a.c0.s.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(14)
/* loaded from: classes10.dex */
public class TextureView extends android.view.TextureView implements TextureView.SurfaceTextureListener, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f38241e;

    /* renamed from: f  reason: collision with root package name */
    public int f38242f;

    /* renamed from: g  reason: collision with root package name */
    public int f38243g;

    /* renamed from: h  reason: collision with root package name */
    public final l f38244h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f38245i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureView(Context context, l lVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lVar};
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
        this.f38241e = 1;
        this.f38244h = lVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38241e : invokeV.intValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int defaultSize = android.view.TextureView.getDefaultSize(this.f38242f, i2);
            int defaultSize2 = android.view.TextureView.getDefaultSize(this.f38243g, i3);
            int i5 = this.f38242f;
            if (i5 > 0 && (i4 = this.f38243g) > 0) {
                int i6 = this.f38241e;
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
            String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f38242f), Integer.valueOf(this.f38243g));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i2, i3) == null) || (lVar = this.f38244h) == null) {
            return;
        }
        lVar.b(new Surface(surfaceTexture));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
            l lVar = this.f38244h;
            if (lVar != null) {
                lVar.a();
            }
            this.f38245i = surfaceTexture;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i2, i3) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
        }
    }

    @Override // c.a.c0.s.k
    public void onVideoSizeChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.f38242f = i2;
            this.f38243g = i3;
            if (i2 == 0 || i3 == 0) {
                return;
            }
            a();
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f38241e = i2;
        }
    }

    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (surfaceTexture = this.f38245i) == null) {
            return;
        }
        setSurfaceTexture(surfaceTexture);
    }
}
