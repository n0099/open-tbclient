package c.a.j.e.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import c.a.j.e.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f3615b;

    /* renamed from: c  reason: collision with root package name */
    public long f3616c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3617d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3618e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3619f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3620g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.e.c.a f3621h;

    /* renamed from: i  reason: collision with root package name */
    public long f3622i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f3623j;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                synchronized (this.a) {
                    if (!this.a.f3617d && !this.a.f3619f) {
                        long j3 = this.a.f3622i;
                        long elapsedRealtime = this.a.f3616c - SystemClock.elapsedRealtime();
                        long j4 = 0;
                        if (elapsedRealtime <= 0) {
                            this.a.f3620g = true;
                            this.a.f3622i = this.a.a;
                            this.a.f3621h.a(0L, Math.max(this.a.f3622i - j3, 0L));
                            this.a.f3621h.onFinish();
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            this.a.f3622i = this.a.a - elapsedRealtime;
                            this.a.f3621h.a(elapsedRealtime, Math.max(this.a.f3622i - j3, 0L));
                            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            if (elapsedRealtime < this.a.f3615b) {
                                j2 = elapsedRealtime - elapsedRealtime3;
                                if (j2 < 0) {
                                    sendMessageDelayed(obtainMessage(1), j4);
                                }
                            } else {
                                j2 = this.a.f3615b - elapsedRealtime3;
                                while (j2 < 0) {
                                    j2 += this.a.f3615b;
                                }
                            }
                            j4 = j2;
                            sendMessageDelayed(obtainMessage(1), j4);
                        }
                    }
                }
            }
        }
    }

    public b(long j2, long j3, c.a.j.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3617d = false;
        this.f3618e = false;
        this.f3619f = false;
        this.f3620g = false;
        this.f3622i = 0L;
        this.f3623j = new a(this, Looper.getMainLooper());
        this.a = j2;
        this.f3615b = j3;
        this.f3622i = 0L;
        this.f3621h = aVar;
    }

    public final synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                this.f3617d = false;
                this.f3620g = false;
                this.f3619f = false;
                this.f3618e = false;
                if (this.a <= 0) {
                    this.f3620g = true;
                    this.f3621h.onFinish();
                    return this;
                }
                this.f3616c = SystemClock.elapsedRealtime() + this.a;
                this.f3623j.sendMessage(this.f3623j.obtainMessage(1));
                this.f3621h.onStart();
                this.f3618e = true;
                return this;
            }
        }
        return (b) invokeV.objValue;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f3619f && !this.f3617d && !this.f3620g && this.f3618e) {
                    SystemClock.elapsedRealtime();
                    this.f3619f = true;
                    this.f3617d = false;
                    this.f3620g = false;
                    this.f3621h.onPause();
                    this.f3623j.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f3617d = true;
                this.f3619f = false;
                this.f3620g = false;
                this.f3618e = false;
                this.f3623j.removeMessages(1);
                this.f3621h.onCancel();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f3621h = new a.C0156a();
                h();
            }
        }
    }
}
