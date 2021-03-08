package cn.com.chinatelecom.account.api;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.c.b;
import cn.com.chinatelecom.account.api.c.e;
/* loaded from: classes4.dex */
public class CtAuth {
    private static volatile CtAuth instance;
    public static Context mContext;
    public static TraceLogger mTraceLogger;
    private static final String TAG = CtAuth.class.getSimpleName();
    public static String mAppKey = "";
    public static String mAppSecret = "";
    public static Handler mHandler = new Handler(Looper.getMainLooper());

    public static CtAuth getInstance() {
        if (instance == null) {
            synchronized (CtAuth.class) {
                if (instance == null) {
                    instance = new CtAuth();
                }
            }
        }
        return instance;
    }

    public static void info(String str, String str2) {
        if (mTraceLogger != null) {
            mTraceLogger.info("CT_" + str, str2);
        }
    }

    public static void postResultOnMainThread(final String str, final ResultListener resultListener) {
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (ResultListener.this != null) {
                    CtAuth.info(CtAuth.TAG, "callback result : " + str);
                    ResultListener.this.onResult(str);
                }
            }
        });
    }

    public static void warn(String str, String str2, Throwable th) {
        if (mTraceLogger != null) {
            mTraceLogger.warn("CT_" + str, str2, th);
        }
    }

    public void init(Context context, String str, String str2, TraceLogger traceLogger) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null!");
        }
        if (str == null) {
            throw new IllegalArgumentException("appKey must not be null!");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("appSecret must not be null!");
        }
        if (context instanceof Application) {
            mContext = context;
        } else {
            mContext = context.getApplicationContext();
        }
        mAppKey = str;
        mAppSecret = str2;
        mTraceLogger = traceLogger;
    }

    public void requestLogin(String str, CtSetting ctSetting, ResultListener resultListener) {
        info(TAG, "call requestNetworkAuth()   accessCode：" + str);
        if (resultListener == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppKey) || TextUtils.isEmpty(mAppSecret)) {
            resultListener.onResult("{\"result\":\"-8005\",\"msg\":\"请先初始化SDK\"}");
        } else if (e.b(mContext)) {
            new a().c(mContext, mAppKey, mAppSecret, str, ctSetting, resultListener);
        } else {
            resultListener.onResult("{\"result\":\"-8100\",\"msg\":\"网络无连接\"}");
        }
    }

    @Deprecated
    public void requestNetworkAuth(String str, CtSetting ctSetting, ResultListener resultListener) {
        requestLogin(str, ctSetting, resultListener);
    }

    @Deprecated
    public void requestPreCode(CtSetting ctSetting, ResultListener resultListener) {
        requestPreLogin(ctSetting, resultListener);
    }

    public void requestPreLogin(CtSetting ctSetting, ResultListener resultListener) {
        info(TAG, "call requestPreCode()");
        if (resultListener == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppKey) || TextUtils.isEmpty(mAppSecret)) {
            resultListener.onResult("{\"result\":\"-8005\",\"msg\":\"请先初始化SDK\"}");
        } else if (!e.b(mContext)) {
            resultListener.onResult("{\"result\":\"-8100\",\"msg\":\"网络无连接\"}");
        } else if (e.d(mContext)) {
            new a().a(mContext, mAppKey, mAppSecret, d.a(b.f1045a), ctSetting, resultListener);
        } else if (e.e(mContext)) {
            new a().b(mContext, mAppKey, mAppSecret, d.a(b.f1045a), ctSetting, resultListener);
        } else {
            resultListener.onResult("{\"result\":-8004,\"msg\":\"移动网络未开启\"}");
        }
    }
}
