package c.a.f0.p;

import android.os.Handler;
import android.os.HandlerThread;
import c.a.f0.r.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f3181f;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3182b;

    /* renamed from: c  reason: collision with root package name */
    public int f3183c;

    /* renamed from: d  reason: collision with root package name */
    public int f3184d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3185e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3186e;

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
            this.f3186e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.g("开始重试");
                if (f.n()) {
                    h.g("重试成功");
                    this.f3186e.f3183c = 0;
                    this.f3186e.a.quitSafely();
                    this.f3186e.f3182b.removeCallbacks(this);
                    return;
                }
                e.c(this.f3186e);
                if (this.f3186e.f3183c >= 3) {
                    this.f3186e.f3183c = 0;
                    h.g("重试三次结束重试");
                    this.f3186e.a.quitSafely();
                    this.f3186e.f3182b.removeCallbacks(this);
                    return;
                }
                h.g("重试失败继续重试");
                this.f3186e.f3182b.postDelayed(this, this.f3186e.f3184d);
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
        this.f3184d = 10000;
        this.f3185e = new a(this);
    }

    public static /* synthetic */ int c(e eVar) {
        int i2 = eVar.f3183c;
        eVar.f3183c = i2 + 1;
        return i2;
    }

    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f3181f == null) {
                synchronized (e.class) {
                    if (f3181f == null) {
                        f3181f = new e();
                    }
                }
            }
            return f3181f;
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
            this.f3182b = handler;
            handler.postDelayed(this.f3185e, this.f3184d);
        }
    }
}
