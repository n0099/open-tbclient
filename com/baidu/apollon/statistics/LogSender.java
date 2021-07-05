package com.baidu.apollon.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogSender {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3937a = 10002;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3938b = 10003;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3939d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3940e = 10001;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f3941c;

    /* renamed from: f  reason: collision with root package name */
    public Handler f3942f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LogSender f3944a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323546643, "Lcom/baidu/apollon/statistics/LogSender$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(323546643, "Lcom/baidu/apollon/statistics/LogSender$a;");
                    return;
                }
            }
            f3944a = new LogSender();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (c2 = PayStatisticsUtil.c()) == null) {
            return;
        }
        this.f3942f.removeMessages(10001);
        int d2 = g.a().d();
        if (com.baidu.apollon.statistics.a.a(c2)) {
            d2 = g.a().c();
        }
        this.f3942f.sendEmptyMessageDelayed(10001, d2 * 60000);
    }

    public static LogSender getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f3944a : (LogSender) invokeV.objValue;
    }

    public void triggerSending(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (Config.w.equals(str)) {
                this.f3942f.sendEmptyMessage(10003);
            } else {
                this.f3942f.obtainMessage(10000, str).sendToTarget();
            }
        }
    }

    public LogSender() {
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
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        this.f3941c = handlerThread;
        handlerThread.start();
        this.f3942f = new Handler(this, this.f3941c.getLooper()) { // from class: com.baidu.apollon.statistics.LogSender.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LogSender f3943a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3943a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) || PayStatisticsUtil.c() == null) {
                    return;
                }
                int i4 = message.what;
                if (10000 == i4) {
                    this.f3943a.a((String) message.obj);
                    this.f3943a.b();
                } else if (10001 == i4) {
                    this.f3943a.a("normal_log");
                    this.f3943a.b();
                } else if (10002 == i4) {
                    g.a().a(PayStatisticsUtil.c());
                } else if (10003 == i4) {
                    String sendData = CustomerService.getInstance().getSendData();
                    if (TextUtils.isEmpty(sendData)) {
                        return;
                    }
                    this.f3943a.a(sendData, CustomerService.sMarkString);
                }
            }
        };
    }

    public void a() {
        Context c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = PayStatisticsUtil.c()) == null) {
            return;
        }
        f.a(BasicStoreTools.getInstance().getLastEvtId(c2));
        this.f3942f.sendEmptyMessage(10002);
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Context c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a().c() || (c2 = PayStatisticsUtil.c()) == null || !com.baidu.apollon.statistics.a.a(c2)) {
                return false;
            }
            c.a a2 = c.a().a(str);
            if (a2.f3961a == 0 || TextUtils.isEmpty(a2.f3962b) || !a(a2.f3962b, (String) null)) {
                return false;
            }
            if (str.equals("normal_log")) {
                BasicStoreTools.getInstance().setLastData(c2, com.baidu.apollon.statistics.a.a(a2.f3962b.getBytes(), false));
            }
            d.a().a(str, a2.f3961a);
            return true;
        }
        return invokeL.booleanValue;
    }

    private synchronized boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, context, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lastData = BasicStoreTools.getInstance().getLastData(context);
                if (TextUtils.isEmpty(lastData)) {
                    return false;
                }
                return lastData.equals(com.baidu.apollon.statistics.a.a(str.getBytes(), false));
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        SyncHttpImpl b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            String str3 = str.toString();
            Context c2 = PayStatisticsUtil.c();
            if (c2 != null && a(c2, str)) {
                try {
                    StatisticsSettings a2 = PayStatisticsUtil.getInstance().a();
                    if (a2 == null || (b2 = PayStatisticsUtil.getInstance().b()) == null) {
                        return false;
                    }
                    String uploadUrl = a2.getUploadUrl();
                    String encodeToString = Base64.encodeToString(str3.getBytes(), 2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("publish_data", encodeToString);
                    String str4 = a2.isReleaseVersion() ? "(null)" : "MhxzKhl";
                    hashMap.put("sign", com.baidu.apollon.statistics.a.a((encodeToString + str4).getBytes("GBK"), false));
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("mk", str2);
                    }
                    return b2.send(c2, 1, uploadUrl, hashMap);
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, str)) == null) {
            if (c.a().c() || !b(context, str)) {
                return true;
            }
            c.a().b("normal_log");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
