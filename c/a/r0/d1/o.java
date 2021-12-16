package c.a.r0.d1;

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
    public long f12239b;

    /* renamed from: c  reason: collision with root package name */
    public long f12240c;

    /* renamed from: d  reason: collision with root package name */
    public long f12241d;

    /* renamed from: e  reason: collision with root package name */
    public long f12242e;

    /* renamed from: f  reason: collision with root package name */
    public long f12243f;

    /* renamed from: g  reason: collision with root package name */
    public long f12244g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12245h;

    /* renamed from: i  reason: collision with root package name */
    public b f12246i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12247j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12248e;

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
            this.f12248e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12248e.f12244g > this.f12248e.f12243f) {
                    o oVar = this.f12248e;
                    oVar.f12243f = currentTimeMillis - oVar.f12241d;
                    o oVar2 = this.f12248e;
                    oVar2.f12244g = oVar2.f12243f;
                }
                long j2 = currentTimeMillis - this.f12248e.f12243f;
                this.f12248e.f12240c += this.f12248e.f12241d;
                if (this.f12248e.f12240c < this.f12248e.f12239b) {
                    this.f12248e.a.postDelayed(this.f12248e.f12247j, (this.f12248e.f12241d * 2) - j2);
                    if (this.f12248e.f12246i != null) {
                        this.f12248e.f12246i.onCountDown(this.f12248e.f12239b, this.f12248e.f12239b - this.f12248e.f12240c);
                    }
                } else {
                    o oVar3 = this.f12248e;
                    oVar3.f12240c = oVar3.f12239b;
                    this.f12248e.m();
                }
                this.f12248e.f12243f = currentTimeMillis;
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
        this.f12245h = false;
        this.f12247j = new a(this);
        this.f12239b = j2;
        this.f12241d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12246i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12239b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12240c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12245h) {
            return;
        }
        this.f12245h = true;
        this.f12244g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12247j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12245h) {
            this.f12245h = false;
            this.a.postDelayed(this.f12247j, this.f12241d - (this.f12244g - this.f12243f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12246i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12242e = currentTimeMillis;
            this.f12243f = currentTimeMillis;
            b bVar = this.f12246i;
            if (bVar != null) {
                long j2 = this.f12239b;
                bVar.onCountDown(j2, j2 - this.f12240c);
            }
            this.a.postDelayed(this.f12247j, this.f12241d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12245h = false;
            long j2 = this.f12242e;
            this.f12243f = j2;
            this.f12244g = j2;
            this.a.removeCallbacks(this.f12247j);
        }
    }
}
