package com.baidu.i;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.client.bean.b;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static volatile boolean aze;
    private static volatile a azg;
    private static final HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
    private static Context mContext;
    public static Handler mHandler;
    private static volatile Map<Long, Message> msgList;
    public boolean azf = false;
    private AtomicInteger azh = new AtomicInteger();
    private b azi = new b() { // from class: com.baidu.i.a.2
        @Override // com.baidu.lcp.sdk.client.bean.b
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            LogUtils.i("IMServiceImpl", "IMService err :" + i + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
            if (i != 0) {
                synchronized (a.msgList) {
                    if (a.msgList != null && a.msgList.containsKey(Long.valueOf(j3))) {
                        ((Message) a.msgList.get(Long.valueOf(j3))).handleMessageResult(a.mContext, null, i, str);
                        a.msgList.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt("err_code", -1);
                String optString = jSONObject.optString("msg", "");
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.mContext.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.mContext.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.mContext.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.mContext.getApplicationContext(), jSONObject);
                } else if (j2 == 231) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.mContext, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.msgList) {
                        if (a.msgList != null && a.msgList.containsKey(Long.valueOf(j3))) {
                            ((Message) a.msgList.get(Long.valueOf(j3))).handleMessageResult(a.mContext, jSONObject, optInt, optString);
                            a.msgList.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e) {
                LogUtils.e("IMServiceImpl", "handle response e :", e);
                synchronized (a.msgList) {
                    if (a.msgList != null && a.msgList.containsKey(Long.valueOf(j3))) {
                        ((Message) a.msgList.get(Long.valueOf(j3))).handleMessageResult(a.mContext, null, -1, "");
                        a.msgList.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    };

    static {
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        aze = true;
        msgList = new LinkedHashMap();
    }

    public static a ap(Context context) {
        if (azg == null) {
            synchronized (a.class) {
                if (azg == null) {
                    mContext = context.getApplicationContext();
                    azg = new a();
                }
            }
        }
        return azg;
    }

    public void e(Context context, final Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.onHandleWork(intent);
            }
        });
    }

    private a() {
        initService();
    }

    private void initService() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + aze);
            IMManager.init(mContext.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(mContext.getApplicationContext()));
            if (aze) {
                zv();
            } else if (!IMSDK.getInstance(mContext.getApplicationContext()).init()) {
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } catch (Exception e) {
        }
    }

    private void zv() {
        for (int i : new int[]{96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231}) {
            s(2, Integer.valueOf(i).intValue());
        }
        s(3, 196);
        this.azf = true;
    }

    private void s(int i, int i2) {
        com.baidu.lcp.sdk.client.bean.a aVar = new com.baidu.lcp.sdk.client.bean.a();
        aVar.serviceId = i;
        aVar.methodId = i2;
        com.baidu.lcp.sdk.client.a.a(aVar, this.azi);
    }

    public void onHandleWork(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + aze);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (aze) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra(Constants.EXTRA_SERVICE, -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        zv();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(mContext, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (msgList) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + msgList.keySet());
                                Iterator<Long> it = msgList.keySet().iterator();
                                while (it.hasNext()) {
                                    z = it.next().longValue() % 100 == 50 ? true : z;
                                }
                            }
                            if (z || LoginManager.getInstance(mContext.getApplicationContext()).isIMLogined()) {
                                LogUtils.d("IMServiceImpl", "cur state is " + (z ? "logining" : "loggined") + " , abandon other 50");
                                return;
                            }
                        }
                        createNewMessage.isSending(true);
                        BLCPRequest bLCPRequest = new BLCPRequest();
                        bLCPRequest.serviceId = intExtra2;
                        bLCPRequest.methodId = createNewMessage.getType();
                        if (intExtra2 == 3 && bLCPRequest.methodId == 55) {
                            bLCPRequest.methodId = 185L;
                        }
                        bLCPRequest.azt = createNewMessage.getBody().getBytes();
                        bLCPRequest.azu = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        bLCPRequest.msgId = (bLCPRequest.serviceId * 1000000000000000L) + bLCPRequest.methodId + (Long.valueOf((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6) + this.azh.incrementAndGet()).longValue() * 1000);
                        synchronized (msgList) {
                            msgList.put(Long.valueOf(bLCPRequest.msgId), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.msgId + ". msg :" + msgList.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(mContext.getApplicationContext()).method(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND).requestId("2").errorCode(50L).ext("" + bLCPRequest.msgId).aliasId(501112L).build();
                        }
                        com.baidu.lcp.sdk.client.a.a(bLCPRequest, this.azi);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                LogUtils.e("IMServiceImpl", "onStartCommand isSmallFlow Exception", e);
                return;
            }
        }
        try {
            if (!IMSDK.getInstance(mContext.getApplicationContext()).handleOnStart(intent)) {
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } catch (Exception e2) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e2);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(mContext));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
    }

    public static void aq(Context context) {
        synchronized (msgList) {
            if (msgList != null) {
                for (Message message : msgList.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
            }
        }
    }
}
