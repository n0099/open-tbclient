package c.a.u;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f14714c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f14715d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f14716e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f14717f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile Map<Long, MessageUbc> f14718g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f14719h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f14720i;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.v.a.b.d.b f14721b;

    /* renamed from: c.a.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0933a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f14722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14723f;

        public RunnableC0933a(a aVar, Intent intent) {
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
            this.f14723f = aVar;
            this.f14722e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14723f.j(this.f14722e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.v.a.b.d.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.v.a.b.d.b
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
                    synchronized (a.f14717f) {
                        if (a.f14717f != null && a.f14717f.containsKey(Long.valueOf(j4))) {
                            ((Message) a.f14717f.get(Long.valueOf(j4))).handleMessageResult(a.f14720i, null, i2, str);
                            a.f14717f.remove(Long.valueOf(j4));
                        }
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                    String optString = jSONObject.optString("msg", "");
                    if (this.a.i((int) j3)) {
                        synchronized (a.f14717f) {
                            messageUbc = (MessageUbc) a.f14718g.get(Long.valueOf(j4));
                            a.f14718g.remove(Long.valueOf(j4));
                        }
                        if (messageUbc != null) {
                            c.a.t.a.a.d().f(messageUbc.generateUBCData(String.valueOf(optInt), optString), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                        }
                    }
                    if (j3 == 96) {
                        NotifyMessageHandler.handleDeliverMessage(a.f14720i.getApplicationContext(), jSONObject);
                    } else if (j3 == 196) {
                        NotifyMessageHandler.handleMcastMessage(a.f14720i.getApplicationContext(), jSONObject);
                    } else if (j3 == 197) {
                        NotifyMessageHandler.handleConfigMessage(a.f14720i.getApplicationContext(), jSONObject);
                    } else if (j3 == 226) {
                        NotifyMessageHandler.handleMediaNotifyMessage(a.f14720i.getApplicationContext(), jSONObject);
                    } else if (i3 == 0) {
                        NotifyMessageHandler.handleRtcNotifyMessage(a.f14720i, jSONObject);
                    } else {
                        LogUtils.d("IMServiceImpl", "key :" + j4 + "response :" + jSONObject.toString());
                        synchronized (a.f14717f) {
                            if (a.f14717f != null && a.f14717f.containsKey(Long.valueOf(j4))) {
                                ((Message) a.f14717f.get(Long.valueOf(j4))).handleMessageResult(a.f14720i, jSONObject, optInt, optString);
                                a.f14717f.remove(Long.valueOf(j4));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    LogUtils.e("IMServiceImpl", "handle response e :", e2);
                    synchronized (a.f14717f) {
                        if (a.f14717f != null && a.f14717f.containsKey(Long.valueOf(j4))) {
                            ((Message) a.f14717f.get(Long.valueOf(j4))).handleMessageResult(a.f14720i, null, -1, "");
                            a.f14717f.remove(Long.valueOf(j4));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896054726, "Lc/a/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896054726, "Lc/a/u/a;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f14715d = handlerThread;
        handlerThread.start();
        f14714c = new Handler(f14715d.getLooper());
        f14716e = true;
        f14717f = new LinkedHashMap();
        f14718g = new LinkedHashMap();
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
        this.f14721b = new b(this);
        h();
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (f14717f) {
                if (f14717f == null) {
                    return;
                }
                for (Message message : f14717f.values()) {
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
            if (f14719h == null) {
                synchronized (a.class) {
                    if (f14719h == null) {
                        f14720i = context.getApplicationContext();
                        f14719h = new a();
                    }
                }
            }
            return f14719h;
        }
        return (a) invokeL.objValue;
    }

    public void f(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
            TaskManager.getInstance(context).submitForNetWork(new RunnableC0933a(this, intent));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                LogUtils.d("IMServiceImpl", "isSmallFlow :" + f14716e);
                IMManager.init(f14720i.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f14720i.getApplicationContext()));
                if (f14716e) {
                    k();
                } else if (IMSDK.getInstance(f14720i.getApplicationContext()).init()) {
                } else {
                    IMConnection.getInstance(f14720i).disconnectedByPeer();
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
            LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f14716e);
            if (intent == null) {
                intent = new Intent();
                LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
            }
            if (f14716e) {
                try {
                    int intExtra = intent.getIntExtra("method", -1);
                    int intExtra2 = intent.getIntExtra("service_id", -1);
                    if (intExtra != -1 && intExtra2 != -1) {
                        if (intExtra == 50 || intExtra == 201) {
                            k();
                        }
                        Message createNewMessage = MessageFactory.getInstance().createNewMessage(f14720i, intExtra, intent);
                        if (createNewMessage != null) {
                            if (intExtra == 50) {
                                boolean z = false;
                                synchronized (f14717f) {
                                    LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f14717f.keySet());
                                    Iterator<Long> it = f14717f.keySet().iterator();
                                    while (it.hasNext()) {
                                        if (it.next().longValue() % 100 == 50) {
                                            z = true;
                                        }
                                    }
                                }
                                if (z || LoginManager.getInstance(f14720i.getApplicationContext()).isIMLogined()) {
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
                            bLCPRequest.f34855b = type;
                            if (intExtra2 == 3 && type == 55) {
                                bLCPRequest.f34855b = 185L;
                            }
                            bLCPRequest.f34856c = createNewMessage.getBody().getBytes();
                            bLCPRequest.f34858e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                            long j2 = (bLCPRequest.a * 1000000000000000L) + bLCPRequest.f34855b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                            sb2.append(this.a.incrementAndGet());
                            bLCPRequest.f34857d = j2 + (Long.valueOf(sb2.toString()).longValue() * 1000);
                            synchronized (f14717f) {
                                if (i((int) bLCPRequest.f34855b) && (createNewMessage instanceof IMSendMsg)) {
                                    f14718g.put(Long.valueOf(bLCPRequest.f34857d), new MessageUbc(f14720i, ((IMSendMsg) createNewMessage).getChatMsg(), UBCConstants.BCSEND_UBCID));
                                }
                                f14717f.put(Long.valueOf(bLCPRequest.f34857d), createNewMessage);
                                LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f34857d + ". msg :" + f14717f.keySet().toString());
                            }
                            if (intExtra == 50) {
                                new IMTrack.RequestBuilder(f14720i.getApplicationContext()).method(ReturnKeyType.SEND).requestId("2").errorCode(50L).ext("" + bLCPRequest.f34857d).aliasId(501112L).build();
                            }
                            c.a.v.a.b.a.c(bLCPRequest, this.f14721b);
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
                if (IMSDK.getInstance(f14720i.getApplicationContext()).handleOnStart(intent)) {
                    return;
                }
                IMConnection.getInstance(f14720i).disconnectedByPeer();
            } catch (Exception e3) {
                LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    if (removeListener instanceof ILoginListener) {
                        ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f14720i));
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
            c.a.v.a.b.d.a aVar = new c.a.v.a.b.d.a();
            aVar.a = i2;
            aVar.f34855b = i3;
            c.a.v.a.b.a.c(aVar, this.f14721b);
        }
    }
}
