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
/* loaded from: classes3.dex */
public class h extends TextureView implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f4899a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f4900b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f4901c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f4902d;

    /* renamed from: e  reason: collision with root package name */
    public f f4903e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4904f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4905g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4906h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4907i;
    public boolean j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f4908a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4908a = hVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i2 + " height:" + i3);
                this.f4908a.f4906h = false;
                if (this.f4908a.f4907i && !this.f4908a.f4905g) {
                    this.f4908a.a(surfaceTexture);
                }
                if (this.f4908a.f4900b == null) {
                    this.f4908a.f4900b = surfaceTexture;
                    if (this.f4908a.f4902d == null) {
                        return;
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    h hVar = this.f4908a;
                    hVar.setSurfaceTexture(hVar.f4900b);
                    return;
                } else {
                    this.f4908a.f4900b = surfaceTexture;
                    if (this.f4908a.f4902d == null) {
                        return;
                    }
                }
                this.f4908a.f4902d.a(1);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureDestroyed surface:" + surfaceTexture);
                this.f4908a.f4906h = true;
                if (!this.f4908a.f4907i || this.f4908a.f4905g) {
                    return false;
                }
                if (surfaceTexture != this.f4908a.f4900b && surfaceTexture != null) {
                    surfaceTexture.release();
                }
                this.f4908a.g();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
                CyberLog.d("CyberTextureView", "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i2 + " height:" + i3);
                this.f4908a.f4906h = false;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) || this.f4908a.f4904f) {
                return;
            }
            this.f4908a.f4904f = true;
            if (this.f4908a.f4902d != null) {
                this.f4908a.f4902d.a(System.currentTimeMillis());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        a aVar = new a(this);
        this.f4899a = aVar;
        setSurfaceTextureListener(aVar);
        this.f4903e = new f();
        this.f4904f = false;
        this.f4905g = false;
        this.f4906h = false;
        this.f4907i = CyberCfgManager.getInstance().a("textureview_texture_auto_release", true);
        this.j = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            int g2 = this.f4903e.g();
            if (g2 > 0) {
                g2 = 360 - g2;
            }
            CyberLog.i("CyberTextureView", "updateRotation rotate:" + i2 + " drawFrameRotation:" + g2);
            setRotation((float) g2);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, surfaceTexture) == null) || (surfaceTexture2 = this.f4900b) == null || surfaceTexture2 == surfaceTexture) {
            return;
        }
        CyberLog.i("CyberTextureView", "releaseLastSurfaceTexture mSurfaceTexture:" + this.f4900b);
        g();
    }

    private void b(int i2, int i3, int i4, int i5) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(65543, this, i2, i3, i4, i5) == null) && this.j) {
            if (this.f4903e.f()) {
                Matrix matrix = new Matrix();
                getTransform(matrix);
                CyberLog.i("CyberTextureView", "doTranslate old_width:" + i2 + " old_height:" + i3 + " width:" + i4 + " height:" + i5);
                float f2 = ((float) (i4 - i2)) / 2.0f;
                float f3 = ((float) (i5 - i3)) / 2.0f;
                StringBuilder sb = new StringBuilder();
                sb.append("doTranslate x:");
                sb.append(f2);
                sb.append(" y:");
                sb.append(f3);
                CyberLog.i("CyberTextureView", sb.toString());
                int d2 = this.f4903e.d();
                if (d2 == 7) {
                    f2 = -f2;
                } else if (d2 != 8) {
                    if (d2 == 9) {
                        matrix.setTranslate(0.0f, -f3);
                    } else if (d2 == 10) {
                        matrix.setTranslate(0.0f, f3);
                    }
                    setTransform(matrix);
                    z = true;
                }
                matrix.setTranslate(f2, 0.0f);
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
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (surfaceTexture = this.f4900b) == null) {
            return;
        }
        surfaceTexture.release();
        CyberLog.i("CyberTextureView", "releaseSurfaceTexture mSurfaceTexture:" + this.f4900b);
        this.f4900b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? getBitmap() : (Bitmap) invokeCommon.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.f4900b);
            Surface surface = this.f4901c;
            if (surface != null) {
                surface.release();
                this.f4901c = null;
            }
            this.f4905g = false;
            if (!this.f4907i) {
                this.f4900b = null;
            } else if (this.f4906h) {
                CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.f4900b + " mIsDestoryed:" + this.f4906h);
                g();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) && this.f4903e.a(i2, i3, i4, i5)) {
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
            this.f4903e.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4901c);
            Surface surface = this.f4901c;
            if (surface != null) {
                surface.release();
                this.f4901c = null;
            }
            CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
            if (getSurfaceTexture() != null) {
                this.f4905g = true;
                this.f4901c = new Surface(getSurfaceTexture());
                if (this.f4907i) {
                    a(getSurfaceTexture());
                }
                this.f4900b = getSurfaceTexture();
                this.f4904f = false;
            }
            CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4901c);
            return this.f4901c;
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
    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            this.f4903e.a(size, size2);
            this.f4903e.b();
            i.a aVar = this.f4902d;
            if (aVar != null) {
                aVar.a(size, size2);
            }
            boolean z = this.f4903e.g() == 90 || this.f4903e.g() == 270;
            if (z) {
                i3 = i2;
                i2 = i3;
            }
            int defaultSize = View.getDefaultSize(this.f4903e.h(), i2);
            int defaultSize2 = View.getDefaultSize(this.f4903e.i(), i3);
            float[] c2 = this.f4903e.c();
            if (z) {
                i4 = (int) (c2[1] * defaultSize);
                f2 = c2[0];
            } else {
                i4 = (int) (c2[0] * defaultSize);
                f2 = c2[1];
            }
            int i5 = (int) (f2 * defaultSize2);
            setMeasuredDimension(i4, i5);
            b(defaultSize, defaultSize2, i4, i5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && this.f4903e.b(i2)) {
            a(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f4902d = aVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && this.f4903e.c(i2)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && this.f4903e.a(i2)) {
            a(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }
}
