package b.a.q0.c1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f12814a;

    /* renamed from: b  reason: collision with root package name */
    public long f12815b;

    /* renamed from: c  reason: collision with root package name */
    public long f12816c;

    /* renamed from: d  reason: collision with root package name */
    public long f12817d;

    /* renamed from: e  reason: collision with root package name */
    public long f12818e;

    /* renamed from: f  reason: collision with root package name */
    public long f12819f;

    /* renamed from: g  reason: collision with root package name */
    public long f12820g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12821h;

    /* renamed from: i  reason: collision with root package name */
    public b f12822i;
    public Runnable j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f12823e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12823e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12823e.f12820g > this.f12823e.f12819f) {
                    m mVar = this.f12823e;
                    mVar.f12819f = currentTimeMillis - mVar.f12817d;
                    m mVar2 = this.f12823e;
                    mVar2.f12820g = mVar2.f12819f;
                }
                long j = currentTimeMillis - this.f12823e.f12819f;
                this.f12823e.f12816c += this.f12823e.f12817d;
                if (this.f12823e.f12816c < this.f12823e.f12815b) {
                    this.f12823e.f12814a.postDelayed(this.f12823e.j, (this.f12823e.f12817d * 2) - j);
                    if (this.f12823e.f12822i != null) {
                        this.f12823e.f12822i.onCountDown(this.f12823e.f12815b, this.f12823e.f12815b - this.f12823e.f12816c);
                    }
                } else {
                    m mVar3 = this.f12823e;
                    mVar3.f12816c = mVar3.f12815b;
                    this.f12823e.m();
                }
                this.f12823e.f12819f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onCountDown(long j, long j2);

        void onCountDownFinish(long j);
    }

    public m(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12814a = new Handler(Looper.getMainLooper());
        this.f12821h = false;
        this.j = new a(this);
        this.f12815b = j;
        this.f12817d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12822i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12815b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12816c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12821h) {
            return;
        }
        this.f12821h = true;
        this.f12820g = System.currentTimeMillis();
        this.f12814a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12821h) {
            this.f12821h = false;
            this.f12814a.postDelayed(this.j, this.f12817d - (this.f12820g - this.f12819f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12822i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12818e = currentTimeMillis;
            this.f12819f = currentTimeMillis;
            b bVar = this.f12822i;
            if (bVar != null) {
                long j = this.f12815b;
                bVar.onCountDown(j, j - this.f12816c);
            }
            this.f12814a.postDelayed(this.j, this.f12817d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12821h = false;
            long j = this.f12818e;
            this.f12819f = j;
            this.f12820g = j;
            this.f12814a.removeCallbacks(this.j);
        }
    }
}
