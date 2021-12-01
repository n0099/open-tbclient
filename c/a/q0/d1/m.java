package c.a.q0.d1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public long f11917b;

    /* renamed from: c  reason: collision with root package name */
    public long f11918c;

    /* renamed from: d  reason: collision with root package name */
    public long f11919d;

    /* renamed from: e  reason: collision with root package name */
    public long f11920e;

    /* renamed from: f  reason: collision with root package name */
    public long f11921f;

    /* renamed from: g  reason: collision with root package name */
    public long f11922g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11923h;

    /* renamed from: i  reason: collision with root package name */
    public b f11924i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f11925j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f11926e;

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
            this.f11926e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f11926e.f11922g > this.f11926e.f11921f) {
                    m mVar = this.f11926e;
                    mVar.f11921f = currentTimeMillis - mVar.f11919d;
                    m mVar2 = this.f11926e;
                    mVar2.f11922g = mVar2.f11921f;
                }
                long j2 = currentTimeMillis - this.f11926e.f11921f;
                this.f11926e.f11918c += this.f11926e.f11919d;
                if (this.f11926e.f11918c < this.f11926e.f11917b) {
                    this.f11926e.a.postDelayed(this.f11926e.f11925j, (this.f11926e.f11919d * 2) - j2);
                    if (this.f11926e.f11924i != null) {
                        this.f11926e.f11924i.onCountDown(this.f11926e.f11917b, this.f11926e.f11917b - this.f11926e.f11918c);
                    }
                } else {
                    m mVar3 = this.f11926e;
                    mVar3.f11918c = mVar3.f11917b;
                    this.f11926e.m();
                }
                this.f11926e.f11921f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.a = new Handler(Looper.getMainLooper());
        this.f11923h = false;
        this.f11925j = new a(this);
        this.f11917b = j2;
        this.f11919d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f11924i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f11917b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11918c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f11923h) {
            return;
        }
        this.f11923h = true;
        this.f11922g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f11925j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f11923h) {
            this.f11923h = false;
            this.a.postDelayed(this.f11925j, this.f11919d - (this.f11922g - this.f11921f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f11924i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f11920e = currentTimeMillis;
            this.f11921f = currentTimeMillis;
            b bVar = this.f11924i;
            if (bVar != null) {
                long j2 = this.f11917b;
                bVar.onCountDown(j2, j2 - this.f11918c);
            }
            this.a.postDelayed(this.f11925j, this.f11919d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f11923h = false;
            long j2 = this.f11920e;
            this.f11921f = j2;
            this.f11922g = j2;
            this.a.removeCallbacks(this.f11925j);
        }
    }
}
