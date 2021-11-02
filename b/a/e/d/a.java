package b.a.e.d;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: b.a.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f1577c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1578a;

        /* renamed from: b  reason: collision with root package name */
        public final e f1579b;

        public C0025a() {
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
            this.f1578a = 0;
            this.f1579b = new e();
            if (NSGif.f34377f) {
                this.f1578a = 0;
            } else {
                this.f1578a = 1;
            }
        }

        public static synchronized a b() {
            InterceptResult invokeV;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (C0025a.class) {
                    if (f1577c == null) {
                        f1577c = new C0025a();
                    }
                    aVar = f1577c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // b.a.e.d.a
        public b.a.e.l.d.a a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.f1578a == 0) {
                    try {
                        return this.f1579b.a(bArr, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (b.a.e.l.d.a) invokeLII.objValue;
        }

        @Override // b.a.e.d.a
        public b.a.e.l.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f1578a == 0) {
                    try {
                        return this.f1579b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (b.a.e.l.d.a) invokeL.objValue;
        }
    }

    b.a.e.l.d.a a(byte[] bArr, int i2, int i3);

    b.a.e.l.d.a get(String str);
}
