package c.a.h0.p;

import android.os.Handler;
import android.os.HandlerThread;
import c.a.h0.r.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f3603f;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3604b;

    /* renamed from: c  reason: collision with root package name */
    public int f3605c;

    /* renamed from: d  reason: collision with root package name */
    public int f3606d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3607e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3608e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3608e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.g("开始重试");
                if (f.n()) {
                    h.g("重试成功");
                    this.f3608e.f3605c = 0;
                    this.f3608e.a.quitSafely();
                    this.f3608e.f3604b.removeCallbacks(this);
                    return;
                }
                e.c(this.f3608e);
                if (this.f3608e.f3605c >= 3) {
                    this.f3608e.f3605c = 0;
                    h.g("重试三次结束重试");
                    this.f3608e.a.quitSafely();
                    this.f3608e.f3604b.removeCallbacks(this);
                    return;
                }
                h.g("重试失败继续重试");
                this.f3608e.f3604b.postDelayed(this, this.f3608e.f3606d);
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3606d = 10000;
        this.f3607e = new a(this);
    }

    public static /* synthetic */ int c(e eVar) {
        int i2 = eVar.f3605c;
        eVar.f3605c = i2 + 1;
        return i2;
    }

    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f3603f == null) {
                synchronized (e.class) {
                    if (f3603f == null) {
                        f3603f = new e();
                    }
                }
            }
            return f3603f;
        }
        return (e) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.g("触发重试");
            HandlerThread handlerThread = new HandlerThread("StatisticsReload");
            this.a = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.a.getLooper());
            this.f3604b = handler;
            handler.postDelayed(this.f3607e, this.f3606d);
        }
    }
}
