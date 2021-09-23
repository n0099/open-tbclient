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
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f12971a;

    /* renamed from: b  reason: collision with root package name */
    public long f12972b;

    /* renamed from: c  reason: collision with root package name */
    public long f12973c;

    /* renamed from: d  reason: collision with root package name */
    public long f12974d;

    /* renamed from: e  reason: collision with root package name */
    public long f12975e;

    /* renamed from: f  reason: collision with root package name */
    public long f12976f;

    /* renamed from: g  reason: collision with root package name */
    public long f12977g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12978h;

    /* renamed from: i  reason: collision with root package name */
    public b f12979i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12980j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f12981e;

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
            this.f12981e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12981e.f12977g > this.f12981e.f12976f) {
                    m mVar = this.f12981e;
                    mVar.f12976f = currentTimeMillis - mVar.f12974d;
                    m mVar2 = this.f12981e;
                    mVar2.f12977g = mVar2.f12976f;
                }
                long j2 = currentTimeMillis - this.f12981e.f12976f;
                this.f12981e.f12973c += this.f12981e.f12974d;
                if (this.f12981e.f12973c < this.f12981e.f12972b) {
                    this.f12981e.f12971a.postDelayed(this.f12981e.f12980j, (this.f12981e.f12974d * 2) - j2);
                    if (this.f12981e.f12979i != null) {
                        this.f12981e.f12979i.onCountDown(this.f12981e.f12972b, this.f12981e.f12972b - this.f12981e.f12973c);
                    }
                } else {
                    m mVar3 = this.f12981e;
                    mVar3.f12973c = mVar3.f12972b;
                    this.f12981e.m();
                }
                this.f12981e.f12976f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onCountDown(long j2, long j3);

        void onCountDownFinish(long j2);
    }

    public m(long j2, long j3) {
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
        this.f12971a = new Handler(Looper.getMainLooper());
        this.f12978h = false;
        this.f12980j = new a(this);
        this.f12972b = j2;
        this.f12974d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12979i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12972b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12973c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12978h) {
            return;
        }
        this.f12978h = true;
        this.f12977g = System.currentTimeMillis();
        this.f12971a.removeCallbacks(this.f12980j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12978h) {
            this.f12978h = false;
            this.f12971a.postDelayed(this.f12980j, this.f12974d - (this.f12977g - this.f12976f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12979i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12975e = currentTimeMillis;
            this.f12976f = currentTimeMillis;
            b bVar = this.f12979i;
            if (bVar != null) {
                long j2 = this.f12972b;
                bVar.onCountDown(j2, j2 - this.f12973c);
            }
            this.f12971a.postDelayed(this.f12980j, this.f12974d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12978h = false;
            long j2 = this.f12975e;
            this.f12976f = j2;
            this.f12977g = j2;
            this.f12971a.removeCallbacks(this.f12980j);
        }
    }
}
