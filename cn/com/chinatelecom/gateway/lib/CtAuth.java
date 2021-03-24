package cn.com.chinatelecom.gateway.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.b.e;
import cn.com.chinatelecom.gateway.lib.c.a;
import cn.com.chinatelecom.gateway.lib.c.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class CtAuth {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1493a = "CtAuth";
    public static TraceLogger mTraceLogger;
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    public static int mTotalTimeout = 0;
    public static int mConnTimeoutL = 0;
    public static int mReadTimeout = 0;

    public static void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        String str4;
        if (preCodeListener == null) {
            mTraceLogger = null;
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "{\"result\":80106,\"msg\":\"请求参数异常\"}";
        } else if (f.b(context)) {
            if (f.c(context)) {
                new a().a(context, str, str2, str3, preCodeListener);
                return;
            } else if (f.d(context)) {
                new a().b(context, str, str2, str3, preCodeListener);
                return;
            } else {
                preCodeListener.onResult("{\"result\":80004,\"msg\":\"移动网络未开启\"}");
                mTraceLogger = null;
                return;
            }
        } else {
            str4 = "{\"result\":80003,\"msg\":\"网络无连接\"}";
        }
        preCodeListener.onResult(str4);
        mTraceLogger = null;
    }

    public static void info(String str, String str2) {
        if (mTraceLogger != null) {
            try {
                mTraceLogger.info("CT_" + str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(int i, int i2, int i3, TraceLogger traceLogger) {
        mConnTimeoutL = i;
        mReadTimeout = i2;
        mTotalTimeout = i3;
        mTraceLogger = traceLogger;
    }

    public static void postResultOnMainThread(final Context context, final String str, final String str2, final PreCodeListener preCodeListener) {
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.gateway.lib.CtAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (PreCodeListener.this != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("reqId", str2);
                        PreCodeListener.this.onResult(jSONObject.toString());
                        String str3 = CtAuth.f1493a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("callback result : ");
                        sb.append(jSONObject.toString());
                        CtAuth.info(str3, sb.toString());
                    } catch (Exception unused) {
                        PreCodeListener.this.onResult(str);
                        String str4 = CtAuth.f1493a;
                        CtAuth.info(str4, "Exception callback result : " + str);
                    }
                    CtAuth.mTraceLogger = null;
                    e.a(context, str2);
                }
            }
        });
    }

    public static void requestPreAuth(Context context, String str, String str2, PreCodeListener preCodeListener) {
        String str3 = f1493a;
        info(str3, "called requestPreAuth()   appId：" + str + ",appSecret:" + str2);
        a(context, str, str2, "mhqh", preCodeListener);
    }

    public static void requestPreAuthCode(Context context, String str, String str2, PreCodeListener preCodeListener) {
        String str3 = f1493a;
        info(str3, "called requestPreAuthCode()   appId：" + str + ",appSecret:" + str2);
        a(context, str, str2, "qhx", preCodeListener);
    }

    public static void warn(String str, String str2, Throwable th) {
        if (mTraceLogger != null) {
            try {
                mTraceLogger.warn("CT_" + str, str2, th);
            } catch (Throwable unused) {
            }
        }
    }
}
