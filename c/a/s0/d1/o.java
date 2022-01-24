package c.a.s0.d1;

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
    public long f12542b;

    /* renamed from: c  reason: collision with root package name */
    public long f12543c;

    /* renamed from: d  reason: collision with root package name */
    public long f12544d;

    /* renamed from: e  reason: collision with root package name */
    public long f12545e;

    /* renamed from: f  reason: collision with root package name */
    public long f12546f;

    /* renamed from: g  reason: collision with root package name */
    public long f12547g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12548h;

    /* renamed from: i  reason: collision with root package name */
    public b f12549i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12550j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f12551e;

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
            this.f12551e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12551e.f12547g > this.f12551e.f12546f) {
                    o oVar = this.f12551e;
                    oVar.f12546f = currentTimeMillis - oVar.f12544d;
                    o oVar2 = this.f12551e;
                    oVar2.f12547g = oVar2.f12546f;
                }
                long j2 = currentTimeMillis - this.f12551e.f12546f;
                this.f12551e.f12543c += this.f12551e.f12544d;
                if (this.f12551e.f12543c < this.f12551e.f12542b) {
                    this.f12551e.a.postDelayed(this.f12551e.f12550j, (this.f12551e.f12544d * 2) - j2);
                    if (this.f12551e.f12549i != null) {
                        this.f12551e.f12549i.onCountDown(this.f12551e.f12542b, this.f12551e.f12542b - this.f12551e.f12543c);
                    }
                } else {
                    o oVar3 = this.f12551e;
                    oVar3.f12543c = oVar3.f12542b;
                    this.f12551e.m();
                }
                this.f12551e.f12546f = currentTimeMillis;
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
        this.f12548h = false;
        this.f12550j = new a(this);
        this.f12542b = j2;
        this.f12544d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12549i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12542b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12543c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12548h) {
            return;
        }
        this.f12548h = true;
        this.f12547g = System.currentTimeMillis();
        this.a.removeCallbacks(this.f12550j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12548h) {
            this.f12548h = false;
            this.a.postDelayed(this.f12550j, this.f12544d - (this.f12547g - this.f12546f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12549i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12545e = currentTimeMillis;
            this.f12546f = currentTimeMillis;
            b bVar = this.f12549i;
            if (bVar != null) {
                long j2 = this.f12542b;
                bVar.onCountDown(j2, j2 - this.f12543c);
            }
            this.a.postDelayed(this.f12550j, this.f12544d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12548h = false;
            long j2 = this.f12545e;
            this.f12546f = j2;
            this.f12547g = j2;
            this.a.removeCallbacks(this.f12550j);
        }
    }
}
