package b.a.q0.d1;

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
    public Handler f12140a;

    /* renamed from: b  reason: collision with root package name */
    public long f12141b;

    /* renamed from: c  reason: collision with root package name */
    public long f12142c;

    /* renamed from: d  reason: collision with root package name */
    public long f12143d;

    /* renamed from: e  reason: collision with root package name */
    public long f12144e;

    /* renamed from: f  reason: collision with root package name */
    public long f12145f;

    /* renamed from: g  reason: collision with root package name */
    public long f12146g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12147h;

    /* renamed from: i  reason: collision with root package name */
    public b f12148i;
    public Runnable j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f12149e;

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
            this.f12149e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12149e.f12146g > this.f12149e.f12145f) {
                    m mVar = this.f12149e;
                    mVar.f12145f = currentTimeMillis - mVar.f12143d;
                    m mVar2 = this.f12149e;
                    mVar2.f12146g = mVar2.f12145f;
                }
                long j = currentTimeMillis - this.f12149e.f12145f;
                this.f12149e.f12142c += this.f12149e.f12143d;
                if (this.f12149e.f12142c < this.f12149e.f12141b) {
                    this.f12149e.f12140a.postDelayed(this.f12149e.j, (this.f12149e.f12143d * 2) - j);
                    if (this.f12149e.f12148i != null) {
                        this.f12149e.f12148i.onCountDown(this.f12149e.f12141b, this.f12149e.f12141b - this.f12149e.f12142c);
                    }
                } else {
                    m mVar3 = this.f12149e;
                    mVar3.f12142c = mVar3.f12141b;
                    this.f12149e.m();
                }
                this.f12149e.f12145f = currentTimeMillis;
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
        this.f12140a = new Handler(Looper.getMainLooper());
        this.f12147h = false;
        this.j = new a(this);
        this.f12141b = j;
        this.f12143d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12148i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12141b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12142c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12147h) {
            return;
        }
        this.f12147h = true;
        this.f12146g = System.currentTimeMillis();
        this.f12140a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12147h) {
            this.f12147h = false;
            this.f12140a.postDelayed(this.j, this.f12143d - (this.f12146g - this.f12145f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12148i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12144e = currentTimeMillis;
            this.f12145f = currentTimeMillis;
            b bVar = this.f12148i;
            if (bVar != null) {
                long j = this.f12141b;
                bVar.onCountDown(j, j - this.f12142c);
            }
            this.f12140a.postDelayed(this.j, this.f12143d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12147h = false;
            long j = this.f12144e;
            this.f12145f = j;
            this.f12146g = j;
            this.f12140a.removeCallbacks(this.j);
        }
    }
}
