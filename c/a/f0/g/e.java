package c.a.f0.g;

import android.os.Handler;
import android.os.HandlerThread;
import c.a.f0.i.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f3338f;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3339b;

    /* renamed from: c  reason: collision with root package name */
    public int f3340c;

    /* renamed from: d  reason: collision with root package name */
    public int f3341d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3342e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3343e;

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
            this.f3343e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.g("开始重试");
                if (f.n()) {
                    h.g("重试成功");
                    this.f3343e.f3340c = 0;
                    this.f3343e.a.quitSafely();
                    this.f3343e.f3339b.removeCallbacks(this);
                    return;
                }
                e.c(this.f3343e);
                if (this.f3343e.f3340c >= 3) {
                    this.f3343e.f3340c = 0;
                    h.g("重试三次结束重试");
                    this.f3343e.a.quitSafely();
                    this.f3343e.f3339b.removeCallbacks(this);
                    return;
                }
                h.g("重试失败继续重试");
                this.f3343e.f3339b.postDelayed(this, this.f3343e.f3341d);
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
        this.f3341d = 10000;
        this.f3342e = new a(this);
    }

    public static /* synthetic */ int c(e eVar) {
        int i2 = eVar.f3340c;
        eVar.f3340c = i2 + 1;
        return i2;
    }

    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f3338f == null) {
                synchronized (e.class) {
                    if (f3338f == null) {
                        f3338f = new e();
                    }
                }
            }
            return f3338f;
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
            this.f3339b = handler;
            handler.postDelayed(this.f3342e, this.f3341d);
        }
    }
}
