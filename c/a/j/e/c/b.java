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
    public final long f3107b;

    /* renamed from: c  reason: collision with root package name */
    public long f3108c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3109d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3111f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3112g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.e.c.a f3113h;
    public long i;
    public Handler j;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                synchronized (this.a) {
                    if (!this.a.f3109d && !this.a.f3111f) {
                        long j2 = this.a.i;
                        long elapsedRealtime = this.a.f3108c - SystemClock.elapsedRealtime();
                        long j3 = 0;
                        if (elapsedRealtime <= 0) {
                            this.a.f3112g = true;
                            this.a.i = this.a.a;
                            this.a.f3113h.a(0L, Math.max(this.a.i - j2, 0L));
                            this.a.f3113h.onFinish();
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            this.a.i = this.a.a - elapsedRealtime;
                            this.a.f3113h.a(elapsedRealtime, Math.max(this.a.i - j2, 0L));
                            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            if (elapsedRealtime < this.a.f3107b) {
                                j = elapsedRealtime - elapsedRealtime3;
                                if (j < 0) {
                                    sendMessageDelayed(obtainMessage(1), j3);
                                }
                            } else {
                                j = this.a.f3107b - elapsedRealtime3;
                                while (j < 0) {
                                    j += this.a.f3107b;
                                }
                            }
                            j3 = j;
                            sendMessageDelayed(obtainMessage(1), j3);
                        }
                    }
                }
            }
        }
    }

    public b(long j, long j2, c.a.j.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3109d = false;
        this.f3110e = false;
        this.f3111f = false;
        this.f3112g = false;
        this.i = 0L;
        this.j = new a(this, Looper.getMainLooper());
        this.a = j;
        this.f3107b = j2;
        this.i = 0L;
        this.f3113h = aVar;
    }

    public final synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                this.f3109d = false;
                this.f3112g = false;
                this.f3111f = false;
                this.f3110e = false;
                if (this.a <= 0) {
                    this.f3112g = true;
                    this.f3113h.onFinish();
                    return this;
                }
                this.f3108c = SystemClock.elapsedRealtime() + this.a;
                this.j.sendMessage(this.j.obtainMessage(1));
                this.f3113h.onStart();
                this.f3110e = true;
                return this;
            }
        }
        return (b) invokeV.objValue;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f3111f && !this.f3109d && !this.f3112g && this.f3110e) {
                    SystemClock.elapsedRealtime();
                    this.f3111f = true;
                    this.f3109d = false;
                    this.f3112g = false;
                    this.f3113h.onPause();
                    this.j.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f3109d = true;
                this.f3111f = false;
                this.f3112g = false;
                this.f3110e = false;
                this.j.removeMessages(1);
                this.f3113h.onCancel();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f3113h = new a.C0162a();
                h();
            }
        }
    }
}
