package c.a.p0.o.a.c;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class g<E> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Object f12189i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12190e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f12191f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f12192g;

    /* renamed from: h  reason: collision with root package name */
    public int f12193h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950871369, "Lc/a/p0/o/a/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950871369, "Lc/a/p0/o/a/c/g;");
                return;
            }
        }
        f12189i = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
        this(10);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f12193h;
            Object[] objArr = this.f12192g;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = null;
            }
            this.f12193h = 0;
            this.f12190e = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public g<E> clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (g) invokeV.objValue;
        }
        g<E> gVar = null;
        try {
            g<E> gVar2 = (g) super.clone();
            try {
                gVar2.f12191f = (int[]) this.f12191f.clone();
                gVar2.f12192g = (Object[]) this.f12192g.clone();
                return gVar2;
            } catch (CloneNotSupportedException unused) {
                gVar = gVar2;
                return gVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f12193h;
            int[] iArr = this.f12191f;
            Object[] objArr = this.f12192g;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != f12189i) {
                    if (i4 != i3) {
                        iArr[i3] = iArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f12190e = false;
            this.f12193h = i3;
        }
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.f12190e) {
                f();
            }
            return this.f12191f[i2];
        }
        return invokeI.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f12190e) {
                f();
            }
            return this.f12193h;
        }
        return invokeV.intValue;
    }

    public E i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f12190e) {
                f();
            }
            return (E) this.f12192g[i2];
        }
        return (E) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h() <= 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.f12193h * 28);
            sb.append(ExtendedMessageFormat.START_FE);
            for (int i2 = 0; i2 < this.f12193h; i2++) {
                if (i2 > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(g(i2));
                sb.append(com.alipay.sdk.encrypt.a.f35988h);
                E i3 = i(i2);
                if (i3 != this) {
                    sb.append(i3);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12190e = false;
        if (i2 == 0) {
            this.f12191f = b.f12164a;
            this.f12192g = b.f12165b;
        } else {
            int d2 = b.d(i2);
            this.f12191f = new int[d2];
            this.f12192g = new Object[d2];
        }
        this.f12193h = 0;
    }
}
