package c.a.e0.g;

import android.os.Handler;
import android.os.HandlerThread;
import c.a.e0.i.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f2788f;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2789b;

    /* renamed from: c  reason: collision with root package name */
    public int f2790c;

    /* renamed from: d  reason: collision with root package name */
    public int f2791d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f2792e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.g("开始重试");
                if (f.n()) {
                    h.g("重试成功");
                    this.a.f2790c = 0;
                    this.a.a.quitSafely();
                    this.a.f2789b.removeCallbacks(this);
                    return;
                }
                e.c(this.a);
                if (this.a.f2790c >= 3) {
                    this.a.f2790c = 0;
                    h.g("重试三次结束重试");
                    this.a.a.quitSafely();
                    this.a.f2789b.removeCallbacks(this);
                    return;
                }
                h.g("重试失败继续重试");
                this.a.f2789b.postDelayed(this, this.a.f2791d);
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2791d = 10000;
        this.f2792e = new a(this);
    }

    public static /* synthetic */ int c(e eVar) {
        int i = eVar.f2790c;
        eVar.f2790c = i + 1;
        return i;
    }

    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2788f == null) {
                synchronized (e.class) {
                    if (f2788f == null) {
                        f2788f = new e();
                    }
                }
            }
            return f2788f;
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
            this.f2789b = handler;
            handler.postDelayed(this.f2792e, this.f2791d);
        }
    }
}
