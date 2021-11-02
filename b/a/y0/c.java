package b.a.y0;

import android.content.Context;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import b.a.y0.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f29966b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29967c;

    /* renamed from: d  reason: collision with root package name */
    public static c f29968d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29969a;

    /* loaded from: classes6.dex */
    public class a implements b.a.y0.e.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f29970a;

        public a(c cVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29970a = bVar;
        }

        @Override // b.a.y0.e.f.b
        public void a(b.a.y0.e.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (c.f29967c) {
                    String unused = c.f29966b;
                    String str = "异步回调 结果:" + cVar;
                    String unused2 = c.f29966b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.f29970a != null);
                    sb.toString();
                }
                b bVar = this.f29970a;
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new b.a.y0.a(cVar.c(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1131990071, "Lb/a/y0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1131990071, "Lb/a/y0/c;");
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29969a = context.getApplicationContext();
    }

    public static c c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f29968d == null) {
                synchronized (c.class) {
                    if (f29968d == null) {
                        f29968d = new c(context);
                        b.a.y0.e.a.c(context);
                    }
                }
            }
            return f29968d;
        }
        return (c) invokeL.objValue;
    }

    public void d(d dVar, b bVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, dVar, bVar, looper) == null) {
            e.o().i(this.f29969a, looper, new a(this, bVar));
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            d dVar = new d();
            dVar.b(1);
            dVar.a(false);
            d(dVar, bVar, Looper.getMainLooper());
        }
    }
}
