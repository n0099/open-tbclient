package c.a.e.l.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Object m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2944a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f2945b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f2946c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2947d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f2948e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2949f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f2950g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.d.b f2951h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2952i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f2953j;
    public boolean k;
    public NinePatch l;

    /* renamed from: c.a.e.l.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049a extends BitmapDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f2954a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0049a(a aVar, Bitmap bitmap) {
            super(bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Bitmap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2954a = aVar;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f2954a.f2945b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.f2954a.f2945b, (Rect) null, getBounds(), getPaint());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411738520, "Lc/a/e/l/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411738520, "Lc/a/e/l/d/a;");
                return;
            }
        }
        m = new Object();
    }

    public a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2945b = bitmap;
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap bitmap = this.f2945b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight() * this.f2945b.getRowBytes();
        }
        return invokeV.intValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f2950g.set(z);
        }
    }

    public final void c() {
        Bitmap bitmap;
        byte[] ninePatchChunk;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bitmap = this.f2945b) == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f2945b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bitmap bitmap = this.f2945b;
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            this.f2947d = false;
            Bitmap bitmap2 = this.f2945b;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            return new BitmapShader(bitmap2, tileMode, tileMode);
        }
        return (BitmapShader) invokeV.objValue;
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), paint}) == null) || this.f2945b == null) {
            return;
        }
        this.f2950g.set(true);
        canvas.drawBitmap(this.f2945b, f2, f3, paint);
        this.f2950g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, canvas, matrix, paint) == null) || this.f2945b == null) {
            return;
        }
        this.f2950g.set(true);
        canvas.drawBitmap(this.f2945b, matrix, paint);
        this.f2950g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, canvas, rect, rectF, paint) == null) || this.f2945b == null) {
            return;
        }
        this.f2950g.set(true);
        canvas.drawBitmap(this.f2945b, rect, rectF, paint);
        this.f2950g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView) == null) || imageView == null || (bitmap = this.f2945b) == null) {
            return;
        }
        this.f2947d = false;
        imageView.setImageBitmap(bitmap);
    }

    public void i(Canvas canvas, RectF rectF) {
        NinePatch ninePatch;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, canvas, rectF) == null) && this.k && (ninePatch = this.l) != null) {
            ninePatch.draw(canvas, rectF);
        }
    }

    public BitmapDrawable j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f2945b == null) {
                return null;
            }
            this.f2947d = false;
            return new C0049a(this, this.f2945b);
        }
        return (BitmapDrawable) invokeV.objValue;
    }

    public byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2948e : (byte[]) invokeV.objValue;
    }

    public c.a.e.d.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2951h : (c.a.e.d.b) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Bitmap bitmap = this.f2945b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        return invokeV.intValue;
    }

    public byte[] n() {
        InterceptResult invokeV;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f2945b == null) {
                return null;
            }
            synchronized (m) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f2945b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2953j : (Rect) invokeV.objValue;
    }

    public Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f2947d = false;
            return this.f2945b;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f2944a : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Bitmap bitmap = this.f2945b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        return invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f2952i : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f2946c : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f2949f : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f2945b != null : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f2947d && !this.f2950g.get()) {
                Bitmap bitmap = this.f2945b;
                if (bitmap != null) {
                    this.f2945b = null;
                    bitmap.recycle();
                }
                c.a.e.d.b bVar = this.f2951h;
                if (bVar != null) {
                    this.f2951h = null;
                    bVar.close();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f2949f = z;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
        }
    }

    public a(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2945b = bitmap;
        this.f2946c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2945b = bitmap;
        this.f2946c = z;
        this.f2944a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, rect};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2945b = bitmap;
        this.f2946c = z;
        this.f2944a = str;
        this.f2953j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, bArr};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2945b = bitmap;
        this.f2946c = z;
        this.f2944a = str;
        this.f2948e = bArr;
        c();
    }

    public a(c.a.e.d.b bVar, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2951h = bVar;
        this.f2945b = bitmap;
        this.f2946c = z;
    }

    public a(c.a.e.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.f2945b = null;
        this.f2946c = false;
        this.f2947d = true;
        this.f2948e = null;
        this.f2949f = true;
        this.f2950g = new AtomicBoolean(false);
        this.f2952i = false;
        this.k = false;
        this.f2951h = bVar;
        this.f2952i = true;
    }
}
