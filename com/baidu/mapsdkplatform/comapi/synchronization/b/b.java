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
    public static final String f7740a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.c.a f7741b;

    /* renamed from: c  reason: collision with root package name */
    public static OnHistoryTraceListener f7742c;

    /* renamed from: e  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.b.a f7743e;

    /* renamed from: g  reason: collision with root package name */
    public static int f7744g;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f7745d;

    /* renamed from: f  reason: collision with root package name */
    public a f7746f;

    /* renamed from: h  reason: collision with root package name */
    public HandlerThread f7747h;
    public e i;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private String a(HistoryTraceQueryOptions historyTraceQueryOptions) {
            String a2 = new f(historyTraceQueryOptions).a();
            if (TextUtils.isEmpty(a2)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7740a, "Build request url failed");
                return null;
            }
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (b.f7743e == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7740a, "Data parser handler is null");
                return;
            }
            Message obtainMessage = b.f7743e.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            b.f7743e.sendMessage(obtainMessage);
            b.f7743e.a(historyTraceQueryOptions);
        }

        private void a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
            String a2 = a(historyTraceQueryOptions);
            if (TextUtils.isEmpty(a2)) {
                b.b(10002, "QueryOptions is null, please check.", i);
            } else {
                a(a2, i, historyTraceQueryOptions);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c.a aVar, int i) {
            int i2;
            String str;
            int i3 = c.f7748a[aVar.ordinal()];
            if (i3 == 1) {
                i2 = 0;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
            } else if (i3 == 2 || i3 == 3) {
                i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
            } else if (i3 == 4) {
                i2 = 100010;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
            } else if (i3 != 5) {
                i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
            } else {
                i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
            }
            b.b(i2, str, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7740a, "Request url is null");
                return;
            }
            if (b.f7741b == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.c.a unused = b.f7741b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
            }
            b.f7741b.a(str, new d(this, i, historyTraceQueryOptions, str));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            String str = b.f7740a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The query type is: " + i);
            HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message.obj;
            if (i != 1) {
                return;
            }
            a(historyTraceQueryOptions, i);
        }
    }

    public b() {
        f7741b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.f7746f = new a();
        HandlerThread handlerThread = new HandlerThread("HistoryTraceDataParser");
        this.f7745d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar = new com.baidu.mapsdkplatform.comapi.synchronization.b.a(this.f7745d.getLooper());
        f7743e = aVar;
        aVar.a(this.f7746f);
        HandlerThread handlerThread2 = new HandlerThread("HistoryTraceRender");
        this.f7747h = handlerThread2;
        handlerThread2.start();
        this.i = new e(this.f7747h.getLooper());
    }

    private void a(HistoryTraceData historyTraceData, int i) {
        if (this.i == null) {
            this.i = new e(this.f7747h.getLooper());
        }
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.what = i;
        if (historyTraceData != null) {
            obtainMessage.obj = historyTraceData;
        }
        this.i.sendMessage(obtainMessage);
    }

    private boolean a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        int i2;
        String str;
        if (historyTraceQueryOptions == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "QueryOptions is null, please check!");
            i2 = 10001;
            str = "QueryOptions is null, please check.";
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "Query orderId is null, please check");
            i2 = 10003;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
        } else if (historyTraceQueryOptions.getRoleType() != 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "Current role type not the passenger");
            i2 = 10004;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "Order's user id is null");
            i2 = 10005;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
        } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
            return true;
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "Driver id is null");
            i2 = 10006;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
        }
        b(i2, str, i);
        return false;
    }

    public static void b(int i, String str, int i2) {
        OnHistoryTraceListener onHistoryTraceListener = f7742c;
        if (onHistoryTraceListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "OnHistoryTraceListener is null");
        } else if (i2 == 1) {
            onHistoryTraceListener.onQueryHistroyTraceData(i, str, null);
        } else if (i2 != 2) {
        } else {
            onHistoryTraceListener.onRenderHistroyTrace(i, str);
        }
    }

    private void b(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        if (this.f7746f == null) {
            this.f7746f = new a();
        }
        Message obtainMessage = this.f7746f.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = historyTraceQueryOptions;
        this.f7746f.sendMessage(obtainMessage);
    }

    public void a() {
        if (f7741b != null) {
            f7741b = null;
        }
        if (f7742c != null) {
            f7742c = null;
        }
        a aVar = this.f7746f;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.f7746f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar2 = f7743e;
        if (aVar2 != null) {
            aVar2.removeCallbacksAndMessages(null);
            f7743e.a();
            f7743e = null;
        }
        HandlerThread handlerThread = this.f7745d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f7745d = null;
        }
        e eVar = this.i;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.i.a();
            this.i = null;
        }
        HandlerThread handlerThread2 = this.f7747h;
        if (handlerThread2 != null) {
            handlerThread2.quit();
            this.f7747h = null;
        }
        this.j = false;
    }

    public void a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (baiduMap == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "BaiduMap instance is null");
            OnHistoryTraceListener onHistoryTraceListener = f7742c;
            if (onHistoryTraceListener != null) {
                onHistoryTraceListener.onRenderHistroyTrace(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            }
        } else if (5 == i) {
            this.i.a(historyTraceDisplayOptions, baiduMap, i);
            a(historyTraceData, 4);
        } else {
            OnHistoryTraceListener onHistoryTraceListener2 = f7742c;
            if (onHistoryTraceListener2 != null) {
                onHistoryTraceListener2.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            }
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (a(historyTraceQueryOptions, 1)) {
            b(historyTraceQueryOptions, 1);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7740a, "QueryOptions error, please check!");
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        f7742c = onHistoryTraceListener;
        f7743e.a(onHistoryTraceListener);
        this.i.a(onHistoryTraceListener);
    }
}
