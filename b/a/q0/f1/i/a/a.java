package b.a.q0.f1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f12329a;

    /* renamed from: b  reason: collision with root package name */
    public final C0650a f12330b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f12331c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f12332d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f12333e;

    /* renamed from: f  reason: collision with root package name */
    public int f12334f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f12335g;

    /* renamed from: b.a.q0.f1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0650a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12336a;

        /* renamed from: b  reason: collision with root package name */
        public int f12337b;

        /* renamed from: c  reason: collision with root package name */
        public int f12338c;

        public C0650a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12337b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12336a : invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12338c : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof C0650a) {
                    C0650a c0650a = (C0650a) obj;
                    if (this.f12336a == c0650a.b() && this.f12337b == c0650a.a() && this.f12338c == c0650a.c()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((((119 + this.f12336a) * 17) + this.f12337b) * 17) + (this.f12338c * 100) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Position{row=" + this.f12336a + ", column=" + this.f12337b + ", sampleScale=" + this.f12338c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0650a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f12336a = i2;
            this.f12337b = i3;
            this.f12338c = i4;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1241585495, "Lb/a/q0/f1/i/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1241585495, "Lb/a/q0/f1/i/a/a;");
        }
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12330b = new C0650a();
        this.f12331c = new Rect();
        this.f12332d = new Rect();
        this.f12333e = new Rect();
        this.f12329a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f12334f = i2;
        this.f12335g = new Canvas();
    }

    public void a() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bitmap = this.f12329a) == null || bitmap.isRecycled() || !this.f12329a.isMutable()) {
            return;
        }
        this.f12335g.setBitmap(this.f12329a);
        this.f12335g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12329a : (Bitmap) invokeV.objValue;
    }

    public Rect c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12332d : (Rect) invokeV.objValue;
    }

    public C0650a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12330b : (C0650a) invokeV.objValue;
    }

    public Rect e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f12334f;
            C0650a c0650a = this.f12330b;
            int i3 = c0650a.f12338c;
            int i4 = c0650a.f12337b * i2 * i3;
            int i5 = c0650a.f12336a * i2 * i3;
            this.f12333e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
            return this.f12333e;
        }
        return (Rect) invokeV.objValue;
    }

    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12331c : (Rect) invokeV.objValue;
    }

    public boolean g(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rect)) == null) {
            if (rect == null) {
                return false;
            }
            int i2 = rect.right - rect.left;
            int i3 = this.f12334f;
            return i2 == i3 && rect.bottom - rect.top == i3;
        }
        return invokeL.booleanValue;
    }

    public void h(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bitmap) == null) {
            this.f12329a = bitmap;
        }
    }

    public void i(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            this.f12332d.set(i2, i3, i4, i5);
        }
    }

    public void j(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i2, i3, i4) == null) {
            C0650a c0650a = this.f12330b;
            c0650a.f12336a = i2;
            c0650a.f12337b = i3;
            c0650a.f12338c = i4;
        }
    }

    public void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            this.f12331c.set(i2, i3, i4, i5);
        }
    }

    public a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12330b = new C0650a();
        this.f12331c = new Rect();
        this.f12332d = new Rect();
        this.f12333e = new Rect();
        if (bitmap != null) {
            this.f12329a = bitmap;
            this.f12331c.set(0, 0, bitmap.getWidth(), this.f12329a.getHeight());
        }
        this.f12335g = new Canvas();
    }
}
