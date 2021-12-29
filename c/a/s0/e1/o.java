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
    public long f12702b;

    /* renamed from: c  reason: collision with root package name */
    public long f12703c;

    /* renamed from: d  reason: collision with root package name */
    public long f12704d;

    /* renamed from: e  reason: collision with root package name */
    public long f12705e;

    /* renamed from: f  reason: collision with root package name */
    public long f12706f;

    /* renamed from: g  reason: collision with root package name */
    public long f12707g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12708h;

    /* renamed from: i  reason: collision with root package name */
    public b f12709i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12710j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12711e;

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
            this.f12711e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12711e.f12707g > this.f12711e.f12706f) {
                    o oVar = this.f12711e;
                    oVar.f12706f = currentTimeMillis - oVar.f12704d;
                    o oVar2 = this.f12711e;
                    oVar2.f12707g = oVar2.f12706f;
                }
                long j2 = currentTimeMillis - this.f12711e.f12706f;
                this.f12711e.f12703c += this.f12711e.f12704d;
                if (this.f12711e.f12703c < this.f12711e.f12702b) {
                    this.f12711e.a.postDelayed(this.f12711e.f12710j, (this.f12711e.f12704d * 2) - j2);
                    if (this.f12711e.f12709i != null) {
                        this.f12711e.f12709i.onCountDown(this.f12711e.f12702b, this.f12711e.f12702b - this.f12711e.f12703c);
                    }
                } else {
                    o oVar3 = this.f12711e;
                    oVar3.f12703c = oVar3.f12702b;
                    this.f12711e.m();
                }
                this.f12711e.f12706f = currentTimeMillis;
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
        this.f12708h = false;
        this.f12710j = new a(this);
        this.f12702b = j2;
        this.f12704d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12709i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12702b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12703c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12708h) {
            return;
        }
        this.f12708h = true;
        this.f12707g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12710j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12708h) {
            this.f12708h = false;
            this.a.postDelayed(this.f12710j, this.f12704d - (this.f12707g - this.f12706f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12709i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12705e = currentTimeMillis;
            this.f12706f = currentTimeMillis;
            b bVar = this.f12709i;
            if (bVar != null) {
                long j2 = this.f12702b;
                bVar.onCountDown(j2, j2 - this.f12703c);
            }
            this.a.postDelayed(this.f12710j, this.f12704d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12708h = false;
            long j2 = this.f12705e;
            this.f12706f = j2;
            this.f12707g = j2;
            this.a.removeCallbacks(this.f12710j);
        }
    }
}
