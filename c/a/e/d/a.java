package c.a.e.d;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f2037c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2038a;

        /* renamed from: b  reason: collision with root package name */
        public final e f2039b;

        public C0040a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2038a = 0;
            this.f2039b = new e();
            if (NSGif.f36033f) {
                this.f2038a = 0;
            } else {
                this.f2038a = 1;
            }
        }

        public static synchronized a b() {
            InterceptResult invokeV;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (C0040a.class) {
                    if (f2037c == null) {
                        f2037c = new C0040a();
                    }
                    aVar = f2037c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // c.a.e.d.a
        public c.a.e.k.d.a a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.f2038a == 0) {
                    try {
                        return this.f2039b.a(bArr, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.e.k.d.a) invokeLII.objValue;
        }

        @Override // c.a.e.d.a
        public c.a.e.k.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f2038a == 0) {
                    try {
                        return this.f2039b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.e.k.d.a) invokeL.objValue;
        }
    }

    c.a.e.k.d.a a(byte[] bArr, int i2, int i3);

    c.a.e.k.d.a get(String str);
}
