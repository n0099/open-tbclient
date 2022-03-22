package c.a.o0.c1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public long f9970b;

    /* renamed from: c  reason: collision with root package name */
    public long f9971c;

    /* renamed from: d  reason: collision with root package name */
    public long f9972d;

    /* renamed from: e  reason: collision with root package name */
    public long f9973e;

    /* renamed from: f  reason: collision with root package name */
    public long f9974f;

    /* renamed from: g  reason: collision with root package name */
    public long f9975g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9976h;
    public b i;
    public Runnable j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.f9975g > this.a.f9974f) {
                    o oVar = this.a;
                    oVar.f9974f = currentTimeMillis - oVar.f9972d;
                    o oVar2 = this.a;
                    oVar2.f9975g = oVar2.f9974f;
                }
                long j = currentTimeMillis - this.a.f9974f;
                this.a.f9971c += this.a.f9972d;
                if (this.a.f9971c < this.a.f9970b) {
                    this.a.a.postDelayed(this.a.j, (this.a.f9972d * 2) - j);
                    if (this.a.i != null) {
                        this.a.i.onCountDown(this.a.f9970b, this.a.f9970b - this.a.f9971c);
                    }
                } else {
                    o oVar3 = this.a;
                    oVar3.f9971c = oVar3.f9970b;
                    this.a.m();
                }
                this.a.f9974f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onCountDown(long j, long j2);

        void onCountDownFinish(long j);
    }

    public o(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f9976h = false;
        this.j = new a(this);
        this.f9970b = j;
        this.f9972d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f9970b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9971c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f9976h) {
            return;
        }
        this.f9976h = true;
        this.f9975g = System.currentTimeMillis();
        this.a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f9976h) {
            this.f9976h = false;
            this.a.postDelayed(this.j, this.f9972d - (this.f9975g - this.f9974f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9973e = currentTimeMillis;
            this.f9974f = currentTimeMillis;
            b bVar = this.i;
            if (bVar != null) {
                long j = this.f9970b;
                bVar.onCountDown(j, j - this.f9971c);
            }
            this.a.postDelayed(this.j, this.f9972d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f9976h = false;
            long j = this.f9973e;
            this.f9974f = j;
            this.f9975g = j;
            this.a.removeCallbacks(this.j);
        }
    }
}
