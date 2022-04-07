package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h extends TextureView implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public SurfaceTexture b;
    public Surface c;
    public i.a d;
    public f e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    /* loaded from: classes.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i, i2) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
                this.a.h = false;
                if (this.a.i && !this.a.g) {
                    this.a.a(surfaceTexture);
                }
                if (this.a.b == null) {
                    this.a.b = surfaceTexture;
                    if (this.a.d == null) {
                        return;
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    h hVar = this.a;
                    hVar.setSurfaceTexture(hVar.b);
                    return;
                } else {
                    this.a.b = surfaceTexture;
                    if (this.a.d == null) {
                        return;
                    }
                }
                this.a.d.a(1);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureDestroyed surface:" + surfaceTexture);
                this.a.h = true;
                if (!this.a.i || this.a.g) {
                    return false;
                }
                if (surfaceTexture != this.a.b && surfaceTexture != null) {
                    surfaceTexture.release();
                }
                this.a.g();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i, i2) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i + " height:" + i2);
                this.a.h = false;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            if (this.a.d != null) {
                this.a.d.a(System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
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
        this.k = false;
        a aVar = new a(this);
        this.a = aVar;
        setSurfaceTextureListener(aVar);
        this.e = new f();
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = CyberCfgManager.getInstance().a("textureview_texture_auto_release", true);
        this.j = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            int g = this.e.g();
            if (g > 0) {
                g = 360 - g;
            }
            CyberLog.i("CyberTextureView", "updateRotation rotate:" + i + " drawFrameRotation:" + g);
            setRotation((float) g);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, surfaceTexture) == null) || (surfaceTexture2 = this.b) == null || surfaceTexture2 == surfaceTexture) {
            return;
        }
        CyberLog.i("CyberTextureView", "releaseLastSurfaceTexture mSurfaceTexture:" + this.b);
        g();
    }

    private void b(int i, int i2, int i3, int i4) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(65543, this, i, i2, i3, i4) == null) && this.j) {
            if (this.e.f()) {
                Matrix matrix = new Matrix();
                getTransform(matrix);
                CyberLog.i("CyberTextureView", "doTranslate old_width:" + i + " old_height:" + i2 + " width:" + i3 + " height:" + i4);
                float f = ((float) (i3 - i)) / 2.0f;
                float f2 = ((float) (i4 - i2)) / 2.0f;
                StringBuilder sb = new StringBuilder();
                sb.append("doTranslate x:");
                sb.append(f);
                sb.append(" y:");
                sb.append(f2);
                CyberLog.i("CyberTextureView", sb.toString());
                int d = this.e.d();
                if (d == 7) {
                    f = -f;
                } else if (d != 8) {
                    if (d == 9) {
                        matrix.setTranslate(0.0f, -f2);
                    } else if (d == 10) {
                        matrix.setTranslate(0.0f, f2);
                    }
                    setTransform(matrix);
                    z = true;
                }
                matrix.setTranslate(f, 0.0f);
                setTransform(matrix);
                z = true;
            } else if (!this.k) {
                return;
            } else {
                Matrix matrix2 = new Matrix();
                getTransform(matrix2);
                matrix2.setTranslate(0.0f, 0.0f);
                setTransform(matrix2);
                z = false;
            }
            this.k = z;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (surfaceTexture = this.b) == null) {
            return;
        }
        surfaceTexture.release();
        CyberLog.i("CyberTextureView", "releaseSurfaceTexture mSurfaceTexture:" + this.b);
        this.b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? getBitmap() : (Bitmap) invokeCommon.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.b);
            Surface surface = this.c;
            if (surface != null) {
                surface.release();
                this.c = null;
            }
            this.g = false;
            if (!this.i) {
                this.b = null;
            } else if (this.h) {
                CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.b + " mIsDestoryed:" + this.h);
                g();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) && this.e.a(i, i2, i3, i4)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setRotation(0.0f);
            this.e.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
            Surface surface = this.c;
            if (surface != null) {
                surface.release();
                this.c = null;
            }
            CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
            if (getSurfaceTexture() != null) {
                this.g = true;
                this.c = new Surface(getSurfaceTexture());
                if (this.i) {
                    a(getSurfaceTexture());
                }
                this.b = getSurfaceTexture();
                this.f = false;
            }
            CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
            return this.c;
        }
        return (Surface) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            this.e.a(size, size2);
            this.e.b();
            i.a aVar = this.d;
            if (aVar != null) {
                aVar.a(size, size2);
            }
            boolean z = this.e.g() == 90 || this.e.g() == 270;
            if (z) {
                i2 = i;
                i = i2;
            }
            int defaultSize = View.getDefaultSize(this.e.h(), i);
            int defaultSize2 = View.getDefaultSize(this.e.i(), i2);
            float[] c = this.e.c();
            if (z) {
                i3 = (int) (c[1] * defaultSize);
                f = c[0];
            } else {
                i3 = (int) (c[0] * defaultSize);
                f = c[1];
            }
            int i4 = (int) (f * defaultSize2);
            setMeasuredDimension(i3, i4);
            b(defaultSize, defaultSize2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.e.b(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && this.e.c(i)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && this.e.a(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }
}
