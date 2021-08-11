package c.a.t;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f29657c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f29658d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f29659e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f29660f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile Map<Long, MessageUbc> f29661g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f29662h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f29663i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f29664a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u.a.b.d.b f29665b;

    /* renamed from: c.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1385a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f29666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29667f;

        public RunnableC1385a(a aVar, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29667f = aVar;
            this.f29666e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29667f.j(this.f29666e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.u.a.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f29668a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29668a = aVar;
        }

        @Override // c.a.u.a.b.d.b
        public void onResponse(int i2, String str, long j2, long j3, long j4, byte[] bArr) {
            MessageUbc messageUbc;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), bArr}) == null) {
                LogUtils.i("IMServiceImpl", "IMService err :" + i2 + ", methodId :" + j3 + ", data :" + bArr.length + ", Response :" + new String(bArr));
                int i3 = (j3 > 231L ? 1 : (j3 == 231L ? 0 : -1));
                if (i3 == 0) {
                    NotifyMessageHandler.handleRtcReport(ProgressInfo.JSON_KEY_BEGIN, new String(bArr));
                }
                if (i2 != 0) {
                    synchronized (a.f29660f) {
                        if (a.f29660f != null && a.f29660f.containsKey(Long.valueOf(j4))) {
                            ((Message) a.f29660f.get(Long.valueOf(j4))).handleMessageResult(a.f29663i, null, i2, str);
                            a.f29660f.remove(Long.valueOf(j4));
                        }
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                    String optString = jSONObject.optString("msg", "");
                    if (this.f29668a.i((int) j3)) {
                        synchronized (a.f29660f) {
                            messageUbc = (MessageUbc) a.f29661g.get(Long.valueOf(j4));
                            a.f29661g.remove(Long.valueOf(j4));
                        }
                        if (messageUbc != null) {
                            c.a.s.a.a.d().f(messageUbc.generateUBCData(String.valueOf(optInt), optString), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                        }
                    }
                    if (j3 == 96) {
                        NotifyMessageHandler.handleDeliverMessage(a.f29663i.getApplicationContext(), jSONObject);
                    } else if (j3 == 196) {
                        NotifyMessageHandler.handleMcastMessage(a.f29663i.getApplicationContext(), jSONObject);
                    } else if (j3 == 197) {
                        NotifyMessageHandler.handleConfigMessage(a.f29663i.getApplicationContext(), jSONObject);
                    } else if (j3 == 226) {
                        NotifyMessageHandler.handleMediaNotifyMessage(a.f29663i.getApplicationContext(), jSONObject);
                    } else if (i3 == 0) {
                        NotifyMessageHandler.handleRtcNotifyMessage(a.f29663i, jSONObject);
                    } else {
                        LogUtils.d("IMServiceImpl", "key :" + j4 + "response :" + jSONObject.toString());
                        synchronized (a.f29660f) {
                            if (a.f29660f != null && a.f29660f.containsKey(Long.valueOf(j4))) {
                                ((Message) a.f29660f.get(Long.valueOf(j4))).handleMessageResult(a.f29663i, jSONObject, optInt, optString);
                                a.f29660f.remove(Long.valueOf(j4));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    LogUtils.e("IMServiceImpl", "handle response e :", e2);
                    synchronized (a.f29660f) {
                        if (a.f29660f != null && a.f29660f.containsKey(Long.valueOf(j4))) {
                            ((Message) a.f29660f.get(Long.valueOf(j4))).handleMessageResult(a.f29663i, null, -1, "");
                            a.f29660f.remove(Long.valueOf(j4));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896084517, "Lc/a/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896084517, "Lc/a/t/a;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f29658d = handlerThread;
        handlerThread.start();
        f29657c = new Handler(f29658d.getLooper());
        f29659e = true;
        f29660f = new LinkedHashMap();
        f29661g = new LinkedHashMap();
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
                return;
            }
        }
        this.f29664a = new AtomicInteger();
        this.f29665b = new b(this);
        h();
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            synchronized (f29660f) {
                if (f29660f == null) {
                    return;
                }
                for (Message message : f29660f.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
            }
        }
    }

    public static a g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (f29662h == null) {
                synchronized (a.class) {
                    if (f29662h == null) {
                        f29663i = context.getApplicationContext();
                        f29662h = new a();
                    }
                }
            }
            return f29662h;
        }
        return (a) invokeL.objValue;
    }

    public void f(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
            TaskManager.getInstance(context).submitForNetWork(new RunnableC1385a(this, intent));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                LogUtils.d("IMServiceImpl", "isSmallFlow :" + f29659e);
                IMManager.init(f29663i.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f29663i.getApplicationContext()));
                if (f29659e) {
                    k();
                } else if (IMSDK.getInstance(f29663i.getApplicationContext()).init()) {
                } else {
                    IMConnection.getInstance(f29663i).disconnectedByPeer();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 == 55 : invokeI.booleanValue;
    }

    public void j(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f29659e);
            if (intent == null) {
                intent = new Intent();
                LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
            }
            if (f29659e) {
                try {
                    int intExtra = intent.getIntExtra("method", -1);
                    int intExtra2 = intent.getIntExtra("service_id", -1);
                    if (intExtra != -1 && intExtra2 != -1) {
                        if (intExtra == 50 || intExtra == 201) {
                            k();
                        }
                        Message createNewMessage = MessageFactory.getInstance().createNewMessage(f29663i, intExtra, intent);
                        if (createNewMessage != null) {
                            if (intExtra == 50) {
                                boolean z = false;
                                synchronized (f29660f) {
                                    LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f29660f.keySet());
                                    Iterator<Long> it = f29660f.keySet().iterator();
                                    while (it.hasNext()) {
                                        if (it.next().longValue() % 100 == 50) {
                                            z = true;
                                        }
                                    }
                                }
                                if (z || LoginManager.getInstance(f29663i.getApplicationContext()).isIMLogined()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("cur state is ");
                                    sb.append(z ? "logining" : "loggined");
                                    sb.append(" , abandon other 50");
                                    LogUtils.d("IMServiceImpl", sb.toString());
                                    return;
                                }
                            }
                            createNewMessage.isSending(true);
                            BLCPRequest bLCPRequest = new BLCPRequest();
                            bLCPRequest.f40425a = intExtra2;
                            long type = createNewMessage.getType();
                            bLCPRequest.f40426b = type;
                            if (intExtra2 == 3 && type == 55) {
                                bLCPRequest.f40426b = 185L;
                            }
                            bLCPRequest.f40427c = createNewMessage.getBody().getBytes();
                            bLCPRequest.f40429e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                            long j2 = (bLCPRequest.f40425a * 1000000000000000L) + bLCPRequest.f40426b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                            sb2.append(this.f29664a.incrementAndGet());
                            bLCPRequest.f40428d = j2 + (Long.valueOf(sb2.toString()).longValue() * 1000);
                            synchronized (f29660f) {
                                if (i((int) bLCPRequest.f40426b) && (createNewMessage instanceof IMSendMsg)) {
                                    f29661g.put(Long.valueOf(bLCPRequest.f40428d), new MessageUbc(f29663i, ((IMSendMsg) createNewMessage).getChatMsg(), UBCConstants.BCSEND_UBCID));
                                }
                                f29660f.put(Long.valueOf(bLCPRequest.f40428d), createNewMessage);
                                LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f40428d + ". msg :" + f29660f.keySet().toString());
                            }
                            if (intExtra == 50) {
                                new IMTrack.RequestBuilder(f29663i.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f40428d).aliasId(501112L).build();
                            }
                            c.a.u.a.b.a.c(bLCPRequest, this.f29665b);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    LogUtils.e("IMServiceImpl", "onStartCommand isSmallFlow Exception", e2);
                    return;
                }
            }
            try {
                if (IMSDK.getInstance(f29663i.getApplicationContext()).handleOnStart(intent)) {
                    return;
                }
                IMConnection.getInstance(f29663i).disconnectedByPeer();
            } catch (Exception e3) {
                LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    if (removeListener instanceof ILoginListener) {
                        ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f29663i));
                    }
                } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                    ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231};
            for (int i2 = 0; i2 < 5; i2++) {
                l(2, Integer.valueOf(iArr[i2]).intValue());
            }
            l(3, 196);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            c.a.u.a.b.d.a aVar = new c.a.u.a.b.d.a();
            aVar.f40425a = i2;
            aVar.f40426b = i3;
            c.a.u.a.b.a.c(aVar, this.f29665b);
        }
    }
}
