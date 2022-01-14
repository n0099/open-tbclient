package c.a.s0.e1;

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
    public long f12403b;

    /* renamed from: c  reason: collision with root package name */
    public long f12404c;

    /* renamed from: d  reason: collision with root package name */
    public long f12405d;

    /* renamed from: e  reason: collision with root package name */
    public long f12406e;

    /* renamed from: f  reason: collision with root package name */
    public long f12407f;

    /* renamed from: g  reason: collision with root package name */
    public long f12408g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12409h;

    /* renamed from: i  reason: collision with root package name */
    public b f12410i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12411j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12412e;

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
            this.f12412e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12412e.f12408g > this.f12412e.f12407f) {
                    o oVar = this.f12412e;
                    oVar.f12407f = currentTimeMillis - oVar.f12405d;
                    o oVar2 = this.f12412e;
                    oVar2.f12408g = oVar2.f12407f;
                }
                long j2 = currentTimeMillis - this.f12412e.f12407f;
                this.f12412e.f12404c += this.f12412e.f12405d;
                if (this.f12412e.f12404c < this.f12412e.f12403b) {
                    this.f12412e.a.postDelayed(this.f12412e.f12411j, (this.f12412e.f12405d * 2) - j2);
                    if (this.f12412e.f12410i != null) {
                        this.f12412e.f12410i.onCountDown(this.f12412e.f12403b, this.f12412e.f12403b - this.f12412e.f12404c);
                    }
                } else {
                    o oVar3 = this.f12412e;
                    oVar3.f12404c = oVar3.f12403b;
                    this.f12412e.m();
                }
                this.f12412e.f12407f = currentTimeMillis;
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
        this.f12409h = false;
        this.f12411j = new a(this);
        this.f12403b = j2;
        this.f12405d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12410i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12403b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12404c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12409h) {
            return;
        }
        this.f12409h = true;
        this.f12408g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12411j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12409h) {
            this.f12409h = false;
            this.a.postDelayed(this.f12411j, this.f12405d - (this.f12408g - this.f12407f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12410i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12406e = currentTimeMillis;
            this.f12407f = currentTimeMillis;
            b bVar = this.f12410i;
            if (bVar != null) {
                long j2 = this.f12403b;
                bVar.onCountDown(j2, j2 - this.f12404c);
            }
            this.a.postDelayed(this.f12411j, this.f12405d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12409h = false;
            long j2 = this.f12406e;
            this.f12407f = j2;
            this.f12408g = j2;
            this.a.removeCallbacks(this.f12411j);
        }
    }
}
