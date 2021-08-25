package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public interface cq {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f43375a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f43376b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f43377c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f43378d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f43379e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f43380f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f43381g;
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
            f43375a = new a("CONTINUOUS", 0);
            f43376b = new a("TEXT", 1);
            f43377c = new a("BINARY", 2);
            f43378d = new a("PING", 3);
            f43379e = new a("PONG", 4);
            a aVar = new a("CLOSING", 5);
            f43380f = aVar;
            f43381g = new a[]{f43375a, f43376b, f43377c, f43378d, f43379e, aVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f43381g.clone() : (a[]) invokeV.objValue;
        }
    }

    void a(cq cqVar) throws ci;

    ByteBuffer c();

    boolean d();

    boolean e();

    a f();
}
