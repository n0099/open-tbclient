package c.a.q0.d1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f12942a;

    /* renamed from: b  reason: collision with root package name */
    public long f12943b;

    /* renamed from: c  reason: collision with root package name */
    public long f12944c;

    /* renamed from: d  reason: collision with root package name */
    public long f12945d;

    /* renamed from: e  reason: collision with root package name */
    public long f12946e;

    /* renamed from: f  reason: collision with root package name */
    public long f12947f;

    /* renamed from: g  reason: collision with root package name */
    public long f12948g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12949h;

    /* renamed from: i  reason: collision with root package name */
    public b f12950i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12951j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f12952e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12952e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12952e.f12948g > this.f12952e.f12947f) {
                    j jVar = this.f12952e;
                    jVar.f12947f = currentTimeMillis - jVar.f12945d;
                    j jVar2 = this.f12952e;
                    jVar2.f12948g = jVar2.f12947f;
                }
                long j2 = currentTimeMillis - this.f12952e.f12947f;
                this.f12952e.f12944c += this.f12952e.f12945d;
                if (this.f12952e.f12944c < this.f12952e.f12943b) {
                    this.f12952e.f12942a.postDelayed(this.f12952e.f12951j, (this.f12952e.f12945d * 2) - j2);
                    if (this.f12952e.f12950i != null) {
                        this.f12952e.f12950i.onCountDown(this.f12952e.f12943b, this.f12952e.f12943b - this.f12952e.f12944c);
                    }
                } else {
                    j jVar3 = this.f12952e;
                    jVar3.f12944c = jVar3.f12943b;
                    this.f12952e.m();
                }
                this.f12952e.f12947f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onCountDown(long j2, long j3);

        void onCountDownFinish(long j2);
    }

    public j(long j2, long j3) {
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
        this.f12942a = new Handler(Looper.getMainLooper());
        this.f12949h = false;
        this.f12951j = new a(this);
        this.f12943b = j2;
        this.f12945d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12950i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12943b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12944c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12949h) {
            return;
        }
        this.f12949h = true;
        this.f12948g = System.currentTimeMillis();
        this.f12942a.removeCallbacks(this.f12951j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12949h) {
            this.f12949h = false;
            this.f12942a.postDelayed(this.f12951j, this.f12945d - (this.f12948g - this.f12947f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12950i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12946e = currentTimeMillis;
            this.f12947f = currentTimeMillis;
            b bVar = this.f12950i;
            if (bVar != null) {
                long j2 = this.f12943b;
                bVar.onCountDown(j2, j2 - this.f12944c);
            }
            this.f12942a.postDelayed(this.f12951j, this.f12945d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12949h = false;
            long j2 = this.f12946e;
            this.f12947f = j2;
            this.f12948g = j2;
            this.f12942a.removeCallbacks(this.f12951j);
        }
    }
}
