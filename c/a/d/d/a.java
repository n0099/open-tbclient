package c.a.d.d;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f2026c;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final d f2027b;

        public C0090a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.f2027b = new d();
            if (NSGif.f23809f) {
                this.a = 0;
            } else {
                this.a = 1;
            }
        }

        public static synchronized a b() {
            InterceptResult invokeV;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (C0090a.class) {
                    if (f2026c == null) {
                        f2026c = new C0090a();
                    }
                    aVar = f2026c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // c.a.d.d.a
        public c.a.d.o.d.a a(byte[] bArr, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
                if (this.a == 0) {
                    try {
                        return this.f2027b.a(bArr, i, i2);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.d.o.d.a) invokeLII.objValue;
        }

        @Override // c.a.d.d.a
        public c.a.d.o.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.a == 0) {
                    try {
                        return this.f2027b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.d.o.d.a) invokeL.objValue;
        }
    }

    c.a.d.o.d.a a(byte[] bArr, int i, int i2);

    c.a.d.o.d.a get(String str);
}
