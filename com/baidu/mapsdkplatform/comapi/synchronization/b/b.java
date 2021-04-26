package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8018a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.c.a f8019b;

    /* renamed from: c  reason: collision with root package name */
    public static OnHistoryTraceListener f8020c;

    /* renamed from: e  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.b.a f8021e;

    /* renamed from: g  reason: collision with root package name */
    public static int f8022g;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f8023d;

    /* renamed from: f  reason: collision with root package name */
    public a f8024f;

    /* renamed from: h  reason: collision with root package name */
    public HandlerThread f8025h;

    /* renamed from: i  reason: collision with root package name */
    public e f8026i;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private String a(HistoryTraceQueryOptions historyTraceQueryOptions) {
            String a2 = new f(historyTraceQueryOptions).a();
            if (TextUtils.isEmpty(a2)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f8018a, "Build request url failed");
                return null;
            }
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, String str, int i3, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (b.f8021e == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f8018a, "Data parser handler is null");
                return;
            }
            Message obtainMessage = b.f8021e.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.obj = str;
            b.f8021e.sendMessage(obtainMessage);
            b.f8021e.a(historyTraceQueryOptions);
        }

        private void a(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
            String a2 = a(historyTraceQueryOptions);
            if (TextUtils.isEmpty(a2)) {
                b.b(10002, "QueryOptions is null, please check.", i2);
            } else {
                a(a2, i2, historyTraceQueryOptions);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c.a aVar, int i2) {
            int i3;
            String str;
            int i4 = c.f8027a[aVar.ordinal()];
            if (i4 == 1) {
                i3 = 0;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
            } else if (i4 == 2 || i4 == 3) {
                i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
            } else if (i4 == 4) {
                i3 = 100010;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
            } else if (i4 != 5) {
                i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
            } else {
                i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
            }
            b.b(i3, str, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f8018a, "Request url is null");
                return;
            }
            if (b.f8019b == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.c.a unused = b.f8019b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
            }
            b.f8019b.a(str, new d(this, i2, historyTraceQueryOptions, str));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            String str = b.f8018a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The query type is: " + i2);
            HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message.obj;
            if (i2 != 1) {
                return;
            }
            a(historyTraceQueryOptions, i2);
        }
    }

    public b() {
        f8019b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.f8024f = new a();
        HandlerThread handlerThread = new HandlerThread("HistoryTraceDataParser");
        this.f8023d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar = new com.baidu.mapsdkplatform.comapi.synchronization.b.a(this.f8023d.getLooper());
        f8021e = aVar;
        aVar.a(this.f8024f);
        HandlerThread handlerThread2 = new HandlerThread("HistoryTraceRender");
        this.f8025h = handlerThread2;
        handlerThread2.start();
        this.f8026i = new e(this.f8025h.getLooper());
    }

    private void a(HistoryTraceData historyTraceData, int i2) {
        if (this.f8026i == null) {
            this.f8026i = new e(this.f8025h.getLooper());
        }
        Message obtainMessage = this.f8026i.obtainMessage();
        obtainMessage.what = i2;
        if (historyTraceData != null) {
            obtainMessage.obj = historyTraceData;
        }
        this.f8026i.sendMessage(obtainMessage);
    }

    private boolean a(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
        int i3;
        String str;
        if (historyTraceQueryOptions == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "QueryOptions is null, please check!");
            i3 = 10001;
            str = "QueryOptions is null, please check.";
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "Query orderId is null, please check");
            i3 = 10003;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
        } else if (historyTraceQueryOptions.getRoleType() != 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "Current role type not the passenger");
            i3 = 10004;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "Order's user id is null");
            i3 = 10005;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
        } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
            return true;
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "Driver id is null");
            i3 = 10006;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
        }
        b(i3, str, i2);
        return false;
    }

    public static void b(int i2, String str, int i3) {
        OnHistoryTraceListener onHistoryTraceListener = f8020c;
        if (onHistoryTraceListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "OnHistoryTraceListener is null");
        } else if (i3 == 1) {
            onHistoryTraceListener.onQueryHistroyTraceData(i2, str, null);
        } else if (i3 != 2) {
        } else {
            onHistoryTraceListener.onRenderHistroyTrace(i2, str);
        }
    }

    private void b(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
        if (this.f8024f == null) {
            this.f8024f = new a();
        }
        Message obtainMessage = this.f8024f.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.obj = historyTraceQueryOptions;
        this.f8024f.sendMessage(obtainMessage);
    }

    public void a() {
        if (f8019b != null) {
            f8019b = null;
        }
        if (f8020c != null) {
            f8020c = null;
        }
        a aVar = this.f8024f;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.f8024f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar2 = f8021e;
        if (aVar2 != null) {
            aVar2.removeCallbacksAndMessages(null);
            f8021e.a();
            f8021e = null;
        }
        HandlerThread handlerThread = this.f8023d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f8023d = null;
        }
        e eVar = this.f8026i;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.f8026i.a();
            this.f8026i = null;
        }
        HandlerThread handlerThread2 = this.f8025h;
        if (handlerThread2 != null) {
            handlerThread2.quit();
            this.f8025h = null;
        }
        this.j = false;
    }

    public void a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i2) {
        if (baiduMap == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "BaiduMap instance is null");
            OnHistoryTraceListener onHistoryTraceListener = f8020c;
            if (onHistoryTraceListener != null) {
                onHistoryTraceListener.onRenderHistroyTrace(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            }
        } else if (5 == i2) {
            this.f8026i.a(historyTraceDisplayOptions, baiduMap, i2);
            a(historyTraceData, 4);
        } else {
            OnHistoryTraceListener onHistoryTraceListener2 = f8020c;
            if (onHistoryTraceListener2 != null) {
                onHistoryTraceListener2.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            }
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (a(historyTraceQueryOptions, 1)) {
            b(historyTraceQueryOptions, 1);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8018a, "QueryOptions error, please check!");
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        f8020c = onHistoryTraceListener;
        f8021e.a(onHistoryTraceListener);
        this.f8026i.a(onHistoryTraceListener);
    }
}
