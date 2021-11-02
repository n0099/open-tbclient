package b.a.n0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3628f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f3629g;

        public a(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3629g = jVar;
            this.f3628f = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3629g.b(this.f3628f);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    j jVar = this.f3629g;
                    jVar.d(this.f3628f, 3, 2009, jVar.f3621c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3630f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f3631g;

        public b(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3631g = jVar;
            this.f3630f = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3631g.g(this.f3630f, this.f3631g.f3621c, this.f3631g.f3626h);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    j jVar = this.f3631g;
                    jVar.m(this.f3630f, 3, 2009, jVar.f3621c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.n0.e.i
    public void i(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.i(context, i2, j);
            c(i2, 2);
            b.a.n0.k.e.c().b(new a(this, i2));
        }
    }

    @Override // b.a.n0.e.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.f3623e)) {
                this.f3625g = null;
                this.f3624f = 0L;
                return true;
            } else if (this.f3624f - System.currentTimeMillis() < b.a.n0.l.b.f3705a) {
                this.f3625g = null;
                this.f3624f = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.n0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
            c(i2, 4);
            b.a.n0.k.e.c().b(new b(this, i2));
        }
    }

    @Override // b.a.n0.e.i
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f3626h)) {
                this.f3627i = 0L;
                return true;
            } else if (this.f3627i - System.currentTimeMillis() < b.a.n0.l.b.f3705a) {
                this.f3627i = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
