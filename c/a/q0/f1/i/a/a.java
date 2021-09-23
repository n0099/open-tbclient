package c.a.q0.f1.i.a;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f13172a;

    /* renamed from: b  reason: collision with root package name */
    public final C0656a f13173b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f13174c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f13175d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f13176e;

    /* renamed from: f  reason: collision with root package name */
    public int f13177f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f13178g;

    /* renamed from: c.a.q0.f1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0656a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f13179a;

        /* renamed from: b  reason: collision with root package name */
        public int f13180b;

        /* renamed from: c  reason: collision with root package name */
        public int f13181c;

        public C0656a() {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13180b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13179a : invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13181c : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof C0656a) {
                    C0656a c0656a = (C0656a) obj;
                    if (this.f13179a == c0656a.b() && this.f13180b == c0656a.a() && this.f13181c == c0656a.c()) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((((119 + this.f13179a) * 17) + this.f13180b) * 17) + (this.f13181c * 100) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Position{row=" + this.f13179a + ", column=" + this.f13180b + ", sampleScale=" + this.f13181c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0656a(int i2, int i3, int i4) {
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
            this.f13179a = i2;
            this.f13180b = i3;
            this.f13181c = i4;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1752119672, "Lc/a/q0/f1/i/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1752119672, "Lc/a/q0/f1/i/a/a;");
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
        this.f13173b = new C0656a();
        this.f13174c = new Rect();
        this.f13175d = new Rect();
        this.f13176e = new Rect();
        this.f13172a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f13177f = i2;
        this.f13178g = new Canvas();
    }

    public void a() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bitmap = this.f13172a) == null || bitmap.isRecycled() || !this.f13172a.isMutable()) {
            return;
        }
        this.f13178g.setBitmap(this.f13172a);
        this.f13178g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13172a : (Bitmap) invokeV.objValue;
    }

    public Rect c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13175d : (Rect) invokeV.objValue;
    }

    public C0656a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13173b : (C0656a) invokeV.objValue;
    }

    public Rect e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f13177f;
            C0656a c0656a = this.f13173b;
            int i3 = c0656a.f13181c;
            int i4 = c0656a.f13180b * i2 * i3;
            int i5 = c0656a.f13179a * i2 * i3;
            this.f13176e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
            return this.f13176e;
        }
        return (Rect) invokeV.objValue;
    }

    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13174c : (Rect) invokeV.objValue;
    }

    public boolean g(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rect)) == null) {
            if (rect == null) {
                return false;
            }
            int i2 = rect.right - rect.left;
            int i3 = this.f13177f;
            return i2 == i3 && rect.bottom - rect.top == i3;
        }
        return invokeL.booleanValue;
    }

    public void h(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bitmap) == null) {
            this.f13172a = bitmap;
        }
    }

    public void i(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            this.f13175d.set(i2, i3, i4, i5);
        }
    }

    public void j(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i2, i3, i4) == null) {
            C0656a c0656a = this.f13173b;
            c0656a.f13179a = i2;
            c0656a.f13180b = i3;
            c0656a.f13181c = i4;
        }
    }

    public void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            this.f13174c.set(i2, i3, i4, i5);
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
        this.f13173b = new C0656a();
        this.f13174c = new Rect();
        this.f13175d = new Rect();
        this.f13176e = new Rect();
        if (bitmap != null) {
            this.f13172a = bitmap;
            this.f13174c.set(0, 0, bitmap.getWidth(), this.f13172a.getHeight());
        }
        this.f13178g = new Canvas();
    }
}
