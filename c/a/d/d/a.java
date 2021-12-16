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
    public static class C0076a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f2252c;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final e f2253b;

        public C0076a() {
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
            this.a = 0;
            this.f2253b = new e();
            if (NSGif.f32028f) {
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
                synchronized (C0076a.class) {
                    if (f2252c == null) {
                        f2252c = new C0076a();
                    }
                    aVar = f2252c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // c.a.d.d.a
        public c.a.d.m.d.a a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.a == 0) {
                    try {
                        return this.f2253b.a(bArr, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.d.m.d.a) invokeLII.objValue;
        }

        @Override // c.a.d.d.a
        public c.a.d.m.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.a == 0) {
                    try {
                        return this.f2253b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (c.a.d.m.d.a) invokeL.objValue;
        }
    }

    c.a.d.m.d.a a(byte[] bArr, int i2, int i3);

    c.a.d.m.d.a get(String str);
}
