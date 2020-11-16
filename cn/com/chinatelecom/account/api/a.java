package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import cn.com.chinatelecom.account.api.b.c;
import cn.com.chinatelecom.account.api.b.d;
import cn.com.chinatelecom.account.api.b.e;
import cn.com.chinatelecom.account.api.b.f;
import cn.com.chinatelecom.account.api.c.f;
import cn.com.chinatelecom.account.api.c.i;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f966a = a.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str, String str2, String str3, CtSetting ctSetting) {
        try {
            JSONObject jSONObject = new JSONObject(f.a(context, str, str2, str3, cn.com.chinatelecom.account.api.c.a.a(str3), cn.com.chinatelecom.account.api.c.a.a(context), ""));
            String optString = jSONObject.optString("p");
            return cn.com.chinatelecom.account.api.c.a.a(context, c.a(context, f.a(), optString, ctSetting, null, false, 0, "Auth").b, jSONObject.optString("k"));
        } catch (Throwable th) {
            CtAuth.warn(f966a, "AuthManager requestNetworkAuth() exception", th);
            return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str, String str2, String str3, CtSetting ctSetting, Network network) {
        try {
            long a2 = cn.com.chinatelecom.account.api.c.a.a(context);
            String a3 = f.a(context);
            JSONObject jSONObject = new JSONObject(f.a(context, str, str2, str3, a2, ""));
            String optString = jSONObject.optString("p");
            String optString2 = jSONObject.optString("k");
            e a4 = c.a(context, a3, optString, ctSetting, network, true, 0, "preAuth");
            return a4.c ? b(context, str, str2, str3, ctSetting, network) : cn.com.chinatelecom.account.api.c.a.a(context, a4, optString2, network, true);
        } catch (Throwable th) {
            CtAuth.warn(f966a, "AuthManager getPreMobile() exception", th);
            return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
        }
    }

    private void a(final f.a aVar, final int i, final ResultListener resultListener) {
        final Future b = cn.com.chinatelecom.account.api.b.f.b(aVar);
        cn.com.chinatelecom.account.api.b.f.a(new Runnable() { // from class: cn.com.chinatelecom.account.api.a.4
            /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF, IGET, INVOKE, IF] complete} */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.get(i, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    try {
                        aVar.a(true);
                        if (th instanceof TimeoutException) {
                            CtAuth.postResultOnMainThread("{\"result\":-8003,\"msg\":\"请求超时\"}", resultListener);
                        } else {
                            CtAuth.warn(a.f966a, "submitOnTimeoutInterrupted other exception", th);
                            CtAuth.postResultOnMainThread("{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}", resultListener);
                        }
                        if (b == null || b.isDone()) {
                            return;
                        }
                        b.cancel(true);
                    } finally {
                        if (b != null && !b.isDone()) {
                            b.cancel(true);
                        }
                    }
                }
            }
        });
    }

    private String b(Context context, String str, String str2, String str3, CtSetting ctSetting, Network network) {
        try {
            long a2 = cn.com.chinatelecom.account.api.c.a.a(context);
            String a3 = cn.com.chinatelecom.account.api.c.f.a(context);
            JSONObject jSONObject = new JSONObject(cn.com.chinatelecom.account.api.c.f.a(context, str, str2, str3, a2, ""));
            String optString = jSONObject.optString("p");
            return cn.com.chinatelecom.account.api.c.a.a(context, c.a(context, a3, optString, ctSetting, network, true, 0, "preAuth"), jSONObject.optString("k"), network, true);
        } catch (Throwable th) {
            CtAuth.warn(f966a, "AuthManager retryPreMobile() exception", th);
            return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
        }
    }

    public void a(final Context context, final String str, final String str2, final String str3, final CtSetting ctSetting, final ResultListener resultListener) {
        a(new f.a() { // from class: cn.com.chinatelecom.account.api.a.1
            @Override // java.lang.Runnable
            public void run() {
                String a2 = a.this.a(context, str, str2, str3, ctSetting, (Network) null);
                if (a()) {
                    return;
                }
                CtAuth.postResultOnMainThread(a2, resultListener);
            }
        }, CtSetting.getTotalTimeout(ctSetting), resultListener);
    }

    public void b(final Context context, final String str, final String str2, final String str3, final CtSetting ctSetting, final ResultListener resultListener) {
        int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        if (Build.VERSION.SDK_INT < 21) {
            a(new f.a() { // from class: cn.com.chinatelecom.account.api.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!new d().a(context, cn.com.chinatelecom.account.api.c.f.a(context))) {
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(i.a(-720002, "切换移动网络超时(4.x)"), resultListener);
                    } else if (a()) {
                    } else {
                        String a2 = a.this.a(context, str, str2, str3, ctSetting, (Network) null);
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(a2, resultListener);
                    }
                }
            }, totalTimeout, resultListener);
            return;
        }
        d dVar = new d();
        dVar.a(context, new d.a() { // from class: cn.com.chinatelecom.account.api.a.2
            private boolean h = false;
            private boolean i = false;

            @Override // cn.com.chinatelecom.account.api.b.d.a
            public synchronized void a() {
                this.h = true;
                if (!this.i) {
                    CtAuth.postResultOnMainThread("{\"result\":-8003,\"msg\":\"请求超时\"}", resultListener);
                }
            }

            @Override // cn.com.chinatelecom.account.api.b.d.a
            public synchronized void a(int i, String str4, long j) {
                if (!this.h && !this.i) {
                    this.i = true;
                    CtAuth.postResultOnMainThread(i.a(i, str4), resultListener);
                    CtAuth.info(a.f966a, "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j);
                }
            }

            @Override // cn.com.chinatelecom.account.api.b.d.a
            public void a(Network network, long j) {
                CtAuth.info(a.f966a, "Switching network successfully (L) , expendTime ：" + j);
                if (this.h || this.i) {
                    return;
                }
                String a2 = a.this.a(context, str, str2, str3, ctSetting, network);
                synchronized (this) {
                    if (!this.h && !this.i) {
                        this.i = true;
                        CtAuth.postResultOnMainThread(a2, resultListener);
                    }
                }
            }
        });
        dVar.a(totalTimeout);
    }

    public void c(final Context context, final String str, final String str2, final String str3, final CtSetting ctSetting, final ResultListener resultListener) {
        a(new f.a() { // from class: cn.com.chinatelecom.account.api.a.5
            @Override // java.lang.Runnable
            public void run() {
                String a2 = a.this.a(context, str, str2, str3, ctSetting);
                if (a()) {
                    return;
                }
                CtAuth.postResultOnMainThread(a2, resultListener);
            }
        }, CtSetting.getTotalTimeout(ctSetting), resultListener);
    }
}
