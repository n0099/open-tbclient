package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface cq {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f8957a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f8958b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f8959c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f8960d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f8961e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f8962f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f8963g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628789031, "Lcom/baidu/mobstat/cq$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628789031, "Lcom/baidu/mobstat/cq$a;");
                    return;
                }
            }
            f8957a = new a("CONTINUOUS", 0);
            f8958b = new a("TEXT", 1);
            f8959c = new a("BINARY", 2);
            f8960d = new a("PING", 3);
            f8961e = new a("PONG", 4);
            a aVar = new a("CLOSING", 5);
            f8962f = aVar;
            f8963g = new a[]{f8957a, f8958b, f8959c, f8960d, f8961e, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f8963g.clone() : (a[]) invokeV.objValue;
        }
    }

    void a(cq cqVar) throws ci;

    ByteBuffer c();

    boolean d();

    boolean e();

    a f();
}
