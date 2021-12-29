package c.a.d.n.d;

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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f3279b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3280c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3281d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3282e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3283f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f3284g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.d.b f3285h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3286i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f3287j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3288k;
    public NinePatch l;

    /* renamed from: c.a.d.n.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0117a extends BitmapDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0117a(a aVar, Bitmap bitmap) {
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
            this.a = aVar;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.a.f3279b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.a.f3279b, (Rect) null, getBounds(), getPaint());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273813513, "Lc/a/d/n/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-273813513, "Lc/a/d/n/d/a;");
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
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3279b = bitmap;
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
            Bitmap bitmap = this.f3279b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight() * this.f3279b.getRowBytes();
        }
        return invokeV.intValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f3284g.set(z);
        }
    }

    public final void c() {
        Bitmap bitmap;
        byte[] ninePatchChunk;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bitmap = this.f3279b) == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.f3288k = true;
        this.l = new NinePatch(this.f3279b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bitmap bitmap = this.f3279b;
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            this.f3281d = false;
            Bitmap bitmap2 = this.f3279b;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            return new BitmapShader(bitmap2, tileMode, tileMode);
        }
        return (BitmapShader) invokeV.objValue;
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), paint}) == null) || this.f3279b == null) {
            return;
        }
        this.f3284g.set(true);
        canvas.drawBitmap(this.f3279b, f2, f3, paint);
        this.f3284g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, canvas, matrix, paint) == null) || (bitmap = this.f3279b) == null || bitmap.isRecycled()) {
            return;
        }
        this.f3284g.set(true);
        canvas.drawBitmap(this.f3279b, matrix, paint);
        this.f3284g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, canvas, rect, rectF, paint) == null) || this.f3279b == null) {
            return;
        }
        this.f3284g.set(true);
        canvas.drawBitmap(this.f3279b, rect, rectF, paint);
        this.f3284g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView) == null) || imageView == null || (bitmap = this.f3279b) == null) {
            return;
        }
        this.f3281d = false;
        imageView.setImageBitmap(bitmap);
    }

    public void i(Canvas canvas, RectF rectF) {
        NinePatch ninePatch;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, canvas, rectF) == null) && this.f3288k && (ninePatch = this.l) != null) {
            ninePatch.draw(canvas, rectF);
        }
    }

    public BitmapDrawable j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f3279b == null) {
                return null;
            }
            this.f3281d = false;
            return new C0117a(this, this.f3279b);
        }
        return (BitmapDrawable) invokeV.objValue;
    }

    public byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f3282e : (byte[]) invokeV.objValue;
    }

    public c.a.d.d.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f3285h : (c.a.d.d.b) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Bitmap bitmap = this.f3279b;
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
            if (this.f3279b == null) {
                return null;
            }
            synchronized (m) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f3279b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3287j : (Rect) invokeV.objValue;
    }

    public Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f3281d = false;
            return this.f3279b;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Bitmap bitmap = this.f3279b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f3286i : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f3280c : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f3283f : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f3288k : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Bitmap bitmap = this.f3279b;
            return (bitmap == null || bitmap.isRecycled()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f3281d && !this.f3284g.get()) {
                Bitmap bitmap = this.f3279b;
                if (bitmap != null) {
                    this.f3279b = null;
                    bitmap.recycle();
                }
                c.a.d.d.b bVar = this.f3285h;
                if (bVar != null) {
                    this.f3285h = null;
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
            this.f3283f = z;
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
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3279b = bitmap;
        this.f3280c = z;
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
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3279b = bitmap;
        this.f3280c = z;
        this.a = str;
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
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3279b = bitmap;
        this.f3280c = z;
        this.a = str;
        this.f3287j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, bArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3279b = bitmap;
        this.f3280c = z;
        this.a = str;
        this.f3282e = bArr;
        c();
    }

    public a(c.a.d.d.b bVar, Bitmap bitmap, boolean z) {
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
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3285h = bVar;
        this.f3279b = bitmap;
        this.f3280c = z;
    }

    public a(c.a.d.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.f3279b = null;
        this.f3280c = false;
        this.f3281d = true;
        this.f3282e = null;
        this.f3283f = true;
        this.f3284g = new AtomicBoolean(false);
        this.f3286i = false;
        this.f3288k = false;
        this.f3285h = bVar;
        this.f3286i = true;
    }
}
