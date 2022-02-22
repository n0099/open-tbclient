package c.a.t0.d1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public long f12798b;

    /* renamed from: c  reason: collision with root package name */
    public long f12799c;

    /* renamed from: d  reason: collision with root package name */
    public long f12800d;

    /* renamed from: e  reason: collision with root package name */
    public long f12801e;

    /* renamed from: f  reason: collision with root package name */
    public long f12802f;

    /* renamed from: g  reason: collision with root package name */
    public long f12803g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12804h;

    /* renamed from: i  reason: collision with root package name */
    public b f12805i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12806j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12807e;

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
            this.f12807e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12807e.f12803g > this.f12807e.f12802f) {
                    o oVar = this.f12807e;
                    oVar.f12802f = currentTimeMillis - oVar.f12800d;
                    o oVar2 = this.f12807e;
                    oVar2.f12803g = oVar2.f12802f;
                }
                long j2 = currentTimeMillis - this.f12807e.f12802f;
                this.f12807e.f12799c += this.f12807e.f12800d;
                if (this.f12807e.f12799c < this.f12807e.f12798b) {
                    this.f12807e.a.postDelayed(this.f12807e.f12806j, (this.f12807e.f12800d * 2) - j2);
                    if (this.f12807e.f12805i != null) {
                        this.f12807e.f12805i.onCountDown(this.f12807e.f12798b, this.f12807e.f12798b - this.f12807e.f12799c);
                    }
                } else {
                    o oVar3 = this.f12807e;
                    oVar3.f12799c = oVar3.f12798b;
                    this.f12807e.m();
                }
                this.f12807e.f12802f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f12804h = false;
        this.f12806j = new a(this);
        this.f12798b = j2;
        this.f12800d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12805i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12798b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12799c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12804h) {
            return;
        }
        this.f12804h = true;
        this.f12803g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12806j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12804h) {
            this.f12804h = false;
            this.a.postDelayed(this.f12806j, this.f12800d - (this.f12803g - this.f12802f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12805i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12801e = currentTimeMillis;
            this.f12802f = currentTimeMillis;
            b bVar = this.f12805i;
            if (bVar != null) {
                long j2 = this.f12798b;
                bVar.onCountDown(j2, j2 - this.f12799c);
            }
            this.a.postDelayed(this.f12806j, this.f12800d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12804h = false;
            long j2 = this.f12801e;
            this.f12802f = j2;
            this.f12803g = j2;
            this.a.removeCallbacks(this.f12806j);
        }
    }
}
