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
    public final long f3998b;

    /* renamed from: c  reason: collision with root package name */
    public long f3999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4000d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4001e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4002f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4003g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.e.c.a f4004h;

    /* renamed from: i  reason: collision with root package name */
    public long f4005i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f4006j;

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
                    if (!this.a.f4000d && !this.a.f4002f) {
                        long j3 = this.a.f4005i;
                        long elapsedRealtime = this.a.f3999c - SystemClock.elapsedRealtime();
                        long j4 = 0;
                        if (elapsedRealtime <= 0) {
                            this.a.f4003g = true;
                            this.a.f4005i = this.a.a;
                            this.a.f4004h.a(0L, Math.max(this.a.f4005i - j3, 0L));
                            this.a.f4004h.onFinish();
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            this.a.f4005i = this.a.a - elapsedRealtime;
                            this.a.f4004h.a(elapsedRealtime, Math.max(this.a.f4005i - j3, 0L));
                            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            if (elapsedRealtime < this.a.f3998b) {
                                j2 = elapsedRealtime - elapsedRealtime3;
                                if (j2 < 0) {
                                    sendMessageDelayed(obtainMessage(1), j4);
                                }
                            } else {
                                j2 = this.a.f3998b - elapsedRealtime3;
                                while (j2 < 0) {
                                    j2 += this.a.f3998b;
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
        this.f4000d = false;
        this.f4001e = false;
        this.f4002f = false;
        this.f4003g = false;
        this.f4005i = 0L;
        this.f4006j = new a(this, Looper.getMainLooper());
        this.a = j2;
        this.f3998b = j3;
        this.f4005i = 0L;
        this.f4004h = aVar;
    }

    public final synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                this.f4000d = false;
                this.f4003g = false;
                this.f4002f = false;
                this.f4001e = false;
                if (this.a <= 0) {
                    this.f4003g = true;
                    this.f4004h.onFinish();
                    return this;
                }
                this.f3999c = SystemClock.elapsedRealtime() + this.a;
                this.f4006j.sendMessage(this.f4006j.obtainMessage(1));
                this.f4004h.onStart();
                this.f4001e = true;
                return this;
            }
        }
        return (b) invokeV.objValue;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f4002f && !this.f4000d && !this.f4003g && this.f4001e) {
                    SystemClock.elapsedRealtime();
                    this.f4002f = true;
                    this.f4000d = false;
                    this.f4003g = false;
                    this.f4004h.onPause();
                    this.f4006j.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f4000d = true;
                this.f4002f = false;
                this.f4003g = false;
                this.f4001e = false;
                this.f4006j.removeMessages(1);
                this.f4004h.onCancel();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f4004h = new a.C0174a();
                h();
            }
        }
    }
}
