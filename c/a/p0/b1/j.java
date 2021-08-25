package c.a.p0.b1;

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
    public Handler f12867a;

    /* renamed from: b  reason: collision with root package name */
    public long f12868b;

    /* renamed from: c  reason: collision with root package name */
    public long f12869c;

    /* renamed from: d  reason: collision with root package name */
    public long f12870d;

    /* renamed from: e  reason: collision with root package name */
    public long f12871e;

    /* renamed from: f  reason: collision with root package name */
    public long f12872f;

    /* renamed from: g  reason: collision with root package name */
    public long f12873g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12874h;

    /* renamed from: i  reason: collision with root package name */
    public b f12875i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12876j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f12877e;

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
            this.f12877e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12877e.f12873g > this.f12877e.f12872f) {
                    j jVar = this.f12877e;
                    jVar.f12872f = currentTimeMillis - jVar.f12870d;
                    j jVar2 = this.f12877e;
                    jVar2.f12873g = jVar2.f12872f;
                }
                long j2 = currentTimeMillis - this.f12877e.f12872f;
                this.f12877e.f12869c += this.f12877e.f12870d;
                if (this.f12877e.f12869c < this.f12877e.f12868b) {
                    this.f12877e.f12867a.postDelayed(this.f12877e.f12876j, (this.f12877e.f12870d * 2) - j2);
                    if (this.f12877e.f12875i != null) {
                        this.f12877e.f12875i.onCountDown(this.f12877e.f12868b, this.f12877e.f12868b - this.f12877e.f12869c);
                    }
                } else {
                    j jVar3 = this.f12877e;
                    jVar3.f12869c = jVar3.f12868b;
                    this.f12877e.m();
                }
                this.f12877e.f12872f = currentTimeMillis;
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
        this.f12867a = new Handler(Looper.getMainLooper());
        this.f12874h = false;
        this.f12876j = new a(this);
        this.f12868b = j2;
        this.f12870d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12875i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12868b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12869c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12874h) {
            return;
        }
        this.f12874h = true;
        this.f12873g = System.currentTimeMillis();
        this.f12867a.removeCallbacks(this.f12876j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12874h) {
            this.f12874h = false;
            this.f12867a.postDelayed(this.f12876j, this.f12870d - (this.f12873g - this.f12872f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12875i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12871e = currentTimeMillis;
            this.f12872f = currentTimeMillis;
            b bVar = this.f12875i;
            if (bVar != null) {
                long j2 = this.f12868b;
                bVar.onCountDown(j2, j2 - this.f12869c);
            }
            this.f12867a.postDelayed(this.f12876j, this.f12870d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12874h = false;
            long j2 = this.f12871e;
            this.f12872f = j2;
            this.f12873g = j2;
            this.f12867a.removeCallbacks(this.f12876j);
        }
    }
}
