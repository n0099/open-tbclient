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
    public Handler f12981a;

    /* renamed from: b  reason: collision with root package name */
    public long f12982b;

    /* renamed from: c  reason: collision with root package name */
    public long f12983c;

    /* renamed from: d  reason: collision with root package name */
    public long f12984d;

    /* renamed from: e  reason: collision with root package name */
    public long f12985e;

    /* renamed from: f  reason: collision with root package name */
    public long f12986f;

    /* renamed from: g  reason: collision with root package name */
    public long f12987g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12988h;

    /* renamed from: i  reason: collision with root package name */
    public b f12989i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12990j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f12991e;

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
            this.f12991e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12991e.f12987g > this.f12991e.f12986f) {
                    m mVar = this.f12991e;
                    mVar.f12986f = currentTimeMillis - mVar.f12984d;
                    m mVar2 = this.f12991e;
                    mVar2.f12987g = mVar2.f12986f;
                }
                long j2 = currentTimeMillis - this.f12991e.f12986f;
                this.f12991e.f12983c += this.f12991e.f12984d;
                if (this.f12991e.f12983c < this.f12991e.f12982b) {
                    this.f12991e.f12981a.postDelayed(this.f12991e.f12990j, (this.f12991e.f12984d * 2) - j2);
                    if (this.f12991e.f12989i != null) {
                        this.f12991e.f12989i.onCountDown(this.f12991e.f12982b, this.f12991e.f12982b - this.f12991e.f12983c);
                    }
                } else {
                    m mVar3 = this.f12991e;
                    mVar3.f12983c = mVar3.f12982b;
                    this.f12991e.m();
                }
                this.f12991e.f12986f = currentTimeMillis;
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
        this.f12981a = new Handler(Looper.getMainLooper());
        this.f12988h = false;
        this.f12990j = new a(this);
        this.f12982b = j2;
        this.f12984d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12989i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12982b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12983c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12988h) {
            return;
        }
        this.f12988h = true;
        this.f12987g = System.currentTimeMillis();
        this.f12981a.removeCallbacks(this.f12990j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12988h) {
            this.f12988h = false;
            this.f12981a.postDelayed(this.f12990j, this.f12984d - (this.f12987g - this.f12986f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12989i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12985e = currentTimeMillis;
            this.f12986f = currentTimeMillis;
            b bVar = this.f12989i;
            if (bVar != null) {
                long j2 = this.f12982b;
                bVar.onCountDown(j2, j2 - this.f12983c);
            }
            this.f12981a.postDelayed(this.f12990j, this.f12984d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12988h = false;
            long j2 = this.f12985e;
            this.f12986f = j2;
            this.f12987g = j2;
            this.f12981a.removeCallbacks(this.f12990j);
        }
    }
}
