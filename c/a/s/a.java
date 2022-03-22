package c.a.s;

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
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f21226c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f21227d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f21228e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f21229f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile Map<Long, MessageUbc> f21230g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f21231h;
    public static Context i;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t.a.b.d.b f21232b;

    /* renamed from: c.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1576a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21233b;

        public RunnableC1576a(a aVar, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21233b = aVar;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21233b.j(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.t.a.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t.a.b.d.b
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            MessageUbc messageUbc;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bArr}) == null) {
                LogUtils.i("IMServiceImpl", "IMService err :" + i + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
                int i2 = (j2 > 231L ? 1 : (j2 == 231L ? 0 : -1));
                if (i2 == 0) {
                    NotifyMessageHandler.handleRtcReport("begin", new String(bArr));
                }
                if (i != 0) {
                    synchronized (a.f21229f) {
                        if (a.f21229f != null && a.f21229f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f21229f.get(Long.valueOf(j3))).handleMessageResult(a.i, null, i, str);
                            a.f21229f.remove(Long.valueOf(j3));
                        }
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                    String optString = jSONObject.optString("msg", "");
                    if (this.a.i((int) j2)) {
                        synchronized (a.f21229f) {
                            messageUbc = (MessageUbc) a.f21230g.get(Long.valueOf(j3));
                            a.f21230g.remove(Long.valueOf(j3));
                        }
                        if (messageUbc != null) {
                            c.a.r.a.a.d().f(messageUbc.generateUBCData(String.valueOf(optInt), optString), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                        }
                    }
                    if (j2 == 96) {
                        NotifyMessageHandler.handleDeliverMessage(a.i.getApplicationContext(), jSONObject);
                    } else if (j2 == 196) {
                        NotifyMessageHandler.handleMcastMessage(a.i.getApplicationContext(), jSONObject);
                    } else if (j2 == 197) {
                        NotifyMessageHandler.handleConfigMessage(a.i.getApplicationContext(), jSONObject);
                    } else if (j2 == 226) {
                        NotifyMessageHandler.handleMediaNotifyMessage(a.i.getApplicationContext(), jSONObject);
                    } else if (i2 == 0) {
                        NotifyMessageHandler.handleRtcNotifyMessage(a.i, jSONObject);
                    } else {
                        LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                        synchronized (a.f21229f) {
                            if (a.f21229f != null && a.f21229f.containsKey(Long.valueOf(j3))) {
                                ((Message) a.f21229f.get(Long.valueOf(j3))).handleMessageResult(a.i, jSONObject, optInt, optString);
                                a.f21229f.remove(Long.valueOf(j3));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    LogUtils.e("IMServiceImpl", "handle response e :", e2);
                    synchronized (a.f21229f) {
                        if (a.f21229f != null && a.f21229f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f21229f.get(Long.valueOf(j3))).handleMessageResult(a.i, null, -1, "");
                            a.f21229f.remove(Long.valueOf(j3));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896114308, "Lc/a/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896114308, "Lc/a/s/a;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f21227d = handlerThread;
        handlerThread.start();
        f21226c = new Handler(f21227d.getLooper());
        f21228e = true;
        f21229f = new LinkedHashMap();
        f21230g = new LinkedHashMap();
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
        this.a = new AtomicInteger();
        this.f21232b = new b(this);
        h();
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (f21229f) {
                if (f21229f == null) {
                    return;
                }
                for (Message message : f21229f.values()) {
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
            if (f21231h == null) {
                synchronized (a.class) {
                    if (f21231h == null) {
                        i = context.getApplicationContext();
                        f21231h = new a();
                    }
                }
            }
            return f21231h;
        }
        return (a) invokeL.objValue;
    }

    public void f(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
            TaskManager.getInstance(context).submitForNetWork(new RunnableC1576a(this, intent));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                LogUtils.d("IMServiceImpl", "isSmallFlow :" + f21228e);
                IMManager.init(i.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(i.getApplicationContext()));
                if (f21228e) {
                    k();
                } else if (IMSDK.getInstance(i.getApplicationContext()).init()) {
                } else {
                    IMConnection.getInstance(i).disconnectedByPeer();
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
            LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f21228e);
            if (intent == null) {
                intent = new Intent();
                LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
            }
            if (f21228e) {
                try {
                    int intExtra = intent.getIntExtra("method", -1);
                    int intExtra2 = intent.getIntExtra("service_id", -1);
                    if (intExtra != -1 && intExtra2 != -1) {
                        if (intExtra == 50 || intExtra == 201) {
                            k();
                        }
                        Message createNewMessage = MessageFactory.getInstance().createNewMessage(i, intExtra, intent);
                        if (createNewMessage != null) {
                            if (intExtra == 50) {
                                boolean z = false;
                                synchronized (f21229f) {
                                    LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f21229f.keySet());
                                    Iterator<Long> it = f21229f.keySet().iterator();
                                    while (it.hasNext()) {
                                        if (it.next().longValue() % 100 == 50) {
                                            z = true;
                                        }
                                    }
                                }
                                if (z || LoginManager.getInstance(i.getApplicationContext()).isIMLogined()) {
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
                            bLCPRequest.a = intExtra2;
                            long type = createNewMessage.getType();
                            bLCPRequest.f25611b = type;
                            if (intExtra2 == 3 && type == 55) {
                                bLCPRequest.f25611b = 185L;
                            }
                            bLCPRequest.f25612c = createNewMessage.getBody().getBytes();
                            bLCPRequest.f25614e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                            long j = (bLCPRequest.a * 1000000000000000L) + bLCPRequest.f25611b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                            sb2.append(this.a.incrementAndGet());
                            bLCPRequest.f25613d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                            synchronized (f21229f) {
                                if (i((int) bLCPRequest.f25611b) && (createNewMessage instanceof IMSendMsg)) {
                                    f21230g.put(Long.valueOf(bLCPRequest.f25613d), new MessageUbc(i, ((IMSendMsg) createNewMessage).getChatMsg(), UBCConstants.BCSEND_UBCID));
                                }
                                f21229f.put(Long.valueOf(bLCPRequest.f25613d), createNewMessage);
                                LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f25613d + ". msg :" + f21229f.keySet().toString());
                            }
                            if (intExtra == 50) {
                                new IMTrack.RequestBuilder(i.getApplicationContext()).method(ReturnKeyType.SEND).requestId("2").errorCode(50L).ext("" + bLCPRequest.f25613d).aliasId(501112L).build();
                            }
                            c.a.t.a.b.a.c(bLCPRequest, this.f21232b);
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
                if (IMSDK.getInstance(i.getApplicationContext()).handleOnStart(intent)) {
                    return;
                }
                IMConnection.getInstance(i).disconnectedByPeer();
            } catch (Exception e3) {
                LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    if (removeListener instanceof ILoginListener) {
                        ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(i));
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
            c.a.t.a.b.d.a aVar = new c.a.t.a.b.d.a();
            aVar.a = i2;
            aVar.f25611b = i3;
            c.a.t.a.b.a.c(aVar, this.f21232b);
        }
    }
}
