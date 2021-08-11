package c.a.o0.b1;

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
    public Handler f12597a;

    /* renamed from: b  reason: collision with root package name */
    public long f12598b;

    /* renamed from: c  reason: collision with root package name */
    public long f12599c;

    /* renamed from: d  reason: collision with root package name */
    public long f12600d;

    /* renamed from: e  reason: collision with root package name */
    public long f12601e;

    /* renamed from: f  reason: collision with root package name */
    public long f12602f;

    /* renamed from: g  reason: collision with root package name */
    public long f12603g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12604h;

    /* renamed from: i  reason: collision with root package name */
    public b f12605i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f12606j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f12607e;

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
            this.f12607e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f12607e.f12603g > this.f12607e.f12602f) {
                    j jVar = this.f12607e;
                    jVar.f12602f = currentTimeMillis - jVar.f12600d;
                    j jVar2 = this.f12607e;
                    jVar2.f12603g = jVar2.f12602f;
                }
                long j2 = currentTimeMillis - this.f12607e.f12602f;
                this.f12607e.f12599c += this.f12607e.f12600d;
                if (this.f12607e.f12599c < this.f12607e.f12598b) {
                    this.f12607e.f12597a.postDelayed(this.f12607e.f12606j, (this.f12607e.f12600d * 2) - j2);
                    if (this.f12607e.f12605i != null) {
                        this.f12607e.f12605i.onCountDown(this.f12607e.f12598b, this.f12607e.f12598b - this.f12607e.f12599c);
                    }
                } else {
                    j jVar3 = this.f12607e;
                    jVar3.f12599c = jVar3.f12598b;
                    this.f12607e.m();
                }
                this.f12607e.f12602f = currentTimeMillis;
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
        this.f12597a = new Handler(Looper.getMainLooper());
        this.f12604h = false;
        this.f12606j = new a(this);
        this.f12598b = j2;
        this.f12600d = j3;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f12605i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.f12598b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12599c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12604h) {
            return;
        }
        this.f12604h = true;
        this.f12603g = System.currentTimeMillis();
        this.f12597a.removeCallbacks(this.f12606j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12604h) {
            this.f12604h = false;
            this.f12597a.postDelayed(this.f12606j, this.f12600d - (this.f12603g - this.f12602f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12605i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12601e = currentTimeMillis;
            this.f12602f = currentTimeMillis;
            b bVar = this.f12605i;
            if (bVar != null) {
                long j2 = this.f12598b;
                bVar.onCountDown(j2, j2 - this.f12599c);
            }
            this.f12597a.postDelayed(this.f12606j, this.f12600d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12604h = false;
            long j2 = this.f12601e;
            this.f12602f = j2;
            this.f12603g = j2;
            this.f12597a.removeCallbacks(this.f12606j);
        }
    }
}
