package c.a.e.c.e.c.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.e.c.e.c.h;
import c.a.e.c.e.c.i;
import c.a.e.e.p.j;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2054a;

    /* renamed from: b  reason: collision with root package name */
    public int f2055b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f2056c;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2057a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
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
            this.f2057a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.f2057a.f2056c.removeMessages(1);
                BdLog.i("this is reconn time:" + this.f2057a.f2055b);
                BdSocketLinkService.startService(true, "time to reconnStragety");
                d.c(this.f2057a);
                if (j.z()) {
                    if (this.f2057a.f2055b >= c.a.e.e.n.m.a.o().q("alert_im", 3)) {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.alert("alert_im", "Socket_Reconnect_" + String.valueOf(this.f2057a.f2055b) + "_times");
                    }
                }
                int[] c2 = h.c();
                if (c2 != null && this.f2057a.f2055b < c2.length) {
                    BdLog.i("Next will be delay:" + c2[this.f2057a.f2055b]);
                    this.f2057a.f2056c.sendMessageDelayed(this.f2057a.f2056c.obtainMessage(1), (long) (c2[this.f2057a.f2055b] * 1000));
                    return;
                }
                this.f2057a.f("reconnStragety to the end");
            }
        }
    }

    public d() {
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
        this.f2054a = false;
        this.f2055b = 0;
        this.f2056c = new a(this, Looper.getMainLooper());
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f2055b;
        dVar.f2055b = i2 + 1;
        return i2;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (!BdSocketLinkService.isAvailable()) {
                f("online failed 5");
            } else if (!this.f2054a) {
                this.f2054a = true;
                this.f2056c.removeMessages(1);
                if (c.a.e.e.r.h.j().l()) {
                    BdLog.d("启动重连策略失败，  WebSocketClient opened");
                    f("in Opened");
                    return;
                }
                d();
                BdLog.d("启动重连策略");
                this.f2055b = 0;
                int[] c2 = h.c();
                if (c2 != null && c2.length >= 1) {
                    BdLog.i("start reconnStrategy... the first will be delay" + c2[0]);
                    int i2 = BdSocketLinkService.STOP_RECONN;
                    i.a("reconn", 0, 0, "reconn", i2, str + " retryTimes=" + String.valueOf(this.f2055b));
                    Handler handler = this.f2056c;
                    handler.sendMessageDelayed(handler.obtainMessage(1), (long) (c2[0] * 1000));
                    return;
                }
                BdLog.i("don't have reconnStrategy!");
            } else {
                BdLog.d("重连策略正在运行中， 再次启动无效");
                i.a("reconn", 0, 0, "start", BdSocketLinkService.ALLREADY, "have in Running,so invalid");
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f2054a) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.f2054a = false;
            this.f2055b = 0;
            BdLog.i("stop reconnStrategy");
            this.f2056c.removeMessages(1);
        }
    }
}
