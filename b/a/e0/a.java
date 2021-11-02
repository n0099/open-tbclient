package b.a.e0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2543a;

    /* renamed from: b.a.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2544a;

        /* renamed from: b  reason: collision with root package name */
        public Context f2545b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2546c;

        public C0046a() {
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
            this.f2544a = 1;
            this.f2546c = false;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (a) invokeV.objValue;
        }

        public C0046a e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f2545b = context;
                return this;
            }
            return (C0046a) invokeL.objValue;
        }

        public C0046a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f2546c = z;
                return this;
            }
            return (C0046a) invokeZ.objValue;
        }

        public C0046a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f2544a = i2;
                return this;
            }
            return (C0046a) invokeI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public abstract void a(int i2, String str);
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ a(C0046a c0046a, c cVar) {
        this(c0046a);
    }

    public void a(Context context, Bundle bundle, b.a.e0.o.a.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, bundle, cVar, bVar) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (cVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2543a < 1000) {
                    b.a.e0.n.d.e("cashier pay time interval less than 1s");
                    return;
                }
                this.f2543a = currentTimeMillis;
                b.a.e0.n.d.e("cashier pay");
                b.a.e0.k.h.a.c(Long.valueOf(currentTimeMillis));
                b.a.e0.k.h.d.b(new b.a.e0.k.h.b("0"));
                PolyActivity.a(context, cVar, bVar, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void b(int i2, JSONObject jSONObject, b.a.e0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, jSONObject, aVar) == null) {
            if (i2 == 1) {
                b.a.e0.k.b.a.b(jSONObject, aVar);
            } else if (i2 == 2) {
                b.a.e0.k.c.a.a(aVar);
            } else if (aVar != null) {
                aVar.a(1, "unknown command");
            }
        }
    }

    public a(C0046a c0046a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0046a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2543a = 0L;
        if (c0046a != null) {
            if (c0046a.f2545b != null) {
                b.a.e0.k.b.a.c(c0046a.f2544a);
                b.a.e0.k.d.b.a(b.a.e0.k.d.a.e(c0046a.f2545b.getApplicationContext()));
                b.a.e0.n.g.b(c0046a.f2545b.getApplicationContext());
                b.a.e0.n.d.f2687d = c0046a.f2546c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
