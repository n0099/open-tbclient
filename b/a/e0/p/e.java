package b.a.e0.p;

import android.os.Handler;
import android.os.HandlerThread;
import b.a.e0.r.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f2667f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f2668a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2669b;

    /* renamed from: c  reason: collision with root package name */
    public int f2670c;

    /* renamed from: d  reason: collision with root package name */
    public int f2671d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f2672e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f2673e;

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
            this.f2673e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.g("开始重试");
                if (f.n()) {
                    h.g("重试成功");
                    this.f2673e.f2670c = 0;
                    this.f2673e.f2668a.quitSafely();
                    this.f2673e.f2669b.removeCallbacks(this);
                    return;
                }
                e.c(this.f2673e);
                if (this.f2673e.f2670c >= 3) {
                    this.f2673e.f2670c = 0;
                    h.g("重试三次结束重试");
                    this.f2673e.f2668a.quitSafely();
                    this.f2673e.f2669b.removeCallbacks(this);
                    return;
                }
                h.g("重试失败继续重试");
                this.f2673e.f2669b.postDelayed(this, this.f2673e.f2671d);
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
        this.f2671d = 10000;
        this.f2672e = new a(this);
    }

    public static /* synthetic */ int c(e eVar) {
        int i2 = eVar.f2670c;
        eVar.f2670c = i2 + 1;
        return i2;
    }

    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2667f == null) {
                synchronized (e.class) {
                    if (f2667f == null) {
                        f2667f = new e();
                    }
                }
            }
            return f2667f;
        }
        return (e) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.g("触发重试");
            HandlerThread handlerThread = new HandlerThread("StatisticsReload");
            this.f2668a = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f2668a.getLooper());
            this.f2669b = handler;
            handler.postDelayed(this.f2672e, this.f2671d);
        }
    }
}
