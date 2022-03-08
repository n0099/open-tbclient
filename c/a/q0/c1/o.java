package c.a.q0.c1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public long f12214b;

    /* renamed from: c  reason: collision with root package name */
    public long f12215c;

    /* renamed from: d  reason: collision with root package name */
    public long f12216d;

    /* renamed from: e  reason: collision with root package name */
    public long f12217e;

    /* renamed from: f  reason: collision with root package name */
    public long f12218f;

    /* renamed from: g  reason: collision with root package name */
    public long f12219g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12220h;

    /* renamed from: i  reason: collision with root package name */
    public b f12221i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12222j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12223e;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12223e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12223e.f12219g > this.f12223e.f12218f) {
                    o oVar = this.f12223e;
                    oVar.f12218f = currentTimeMillis - oVar.f12216d;
                    o oVar2 = this.f12223e;
                    oVar2.f12219g = oVar2.f12218f;
                }
                long j2 = currentTimeMillis - this.f12223e.f12218f;
                this.f12223e.f12215c += this.f12223e.f12216d;
                if (this.f12223e.f12215c < this.f12223e.f12214b) {
                    this.f12223e.a.postDelayed(this.f12223e.f12222j, (this.f12223e.f12216d * 2) - j2);
                    if (this.f12223e.f12221i != null) {
                        this.f12223e.f12221i.onCountDown(this.f12223e.f12214b, this.f12223e.f12214b - this.f12223e.f12215c);
                    }
                } else {
                    o oVar3 = this.f12223e;
                    oVar3.f12215c = oVar3.f12214b;
                    this.f12223e.m();
                }
                this.f12223e.f12218f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onCountDown(long j2, long j3);

        void onCountDownFinish(long j2);
    }

    public o(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f12220h = false;
        this.f12222j = new a(this);
        this.f12214b = j2;
        this.f12216d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12221i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12214b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12215c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12220h) {
            return;
        }
        this.f12220h = true;
        this.f12219g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12222j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12220h) {
            this.f12220h = false;
            this.a.postDelayed(this.f12222j, this.f12216d - (this.f12219g - this.f12218f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12221i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12217e = currentTimeMillis;
            this.f12218f = currentTimeMillis;
            b bVar = this.f12221i;
            if (bVar != null) {
                long j2 = this.f12214b;
                bVar.onCountDown(j2, j2 - this.f12215c);
            }
            this.a.postDelayed(this.f12222j, this.f12216d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12220h = false;
            long j2 = this.f12217e;
            this.f12218f = j2;
            this.f12219g = j2;
            this.a.removeCallbacks(this.f12222j);
        }
    }
}
