package c.a.e.c.e.c.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static byte f1978g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f1979h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f1980i = 64;

    /* renamed from: j  reason: collision with root package name */
    public static byte f1981j = 8;
    public static byte k = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1982a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1983b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1984c;

    /* renamed from: d  reason: collision with root package name */
    public int f1985d;

    /* renamed from: e  reason: collision with root package name */
    public int f1986e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1987f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2048103761, "Lc/a/e/c/e/c/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2048103761, "Lc/a/e/c/e/c/j/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1982a = false;
        this.f1983b = false;
        this.f1984c = false;
        this.f1987f = false;
    }

    public static a a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
            a aVar = new a();
            byte b2 = wrap.get();
            if ((f1979h & b2) != 0) {
                aVar.f1982a = true;
            }
            if ((f1980i & b2) != 0) {
                aVar.f1983b = true;
            }
            if ((f1981j & b2) != 0) {
                aVar.f1984c = true;
            }
            if ((b2 & k) != 0) {
                aVar.f1987f = true;
            }
            aVar.f1985d = wrap.getInt();
            aVar.f1986e = wrap.getInt();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 9;
        }
        return invokeV.intValue;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), bArr, Boolean.valueOf(z3)})) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
            byte b2 = z ? (byte) (f1979h | 0) : (byte) 0;
            if (z2) {
                b2 = (byte) (f1980i | b2);
            }
            byte b3 = (byte) (f1981j | b2);
            if (z3) {
                b3 = (byte) (b3 | k);
            }
            allocate.put(b3);
            allocate.putInt(i2);
            allocate.putInt(i3);
            if (bArr != null) {
                allocate.put(bArr);
            }
            allocate.flip();
            return allocate.array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1985d : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1983b : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1982a : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1987f : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1984c : invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1986e : invokeV.intValue;
    }
}
