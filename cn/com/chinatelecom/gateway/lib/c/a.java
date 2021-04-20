package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import cn.com.chinatelecom.gateway.lib.c.e;
import cn.com.chinatelecom.gateway.lib.c.i;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1519a = "a";

    public static String a(Context context, String str, String str2, Network network) {
        return c(context, d.a(context, str, network), str2, network);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str, String str2, String str3, Network network, String str4) {
        String b2 = b();
        String a2 = g.a(context, str, str2, str3, b2);
        String str5 = f1519a;
        CtAuth.info(str5, "request params : " + a2);
        String a3 = d.a(context, "https://id6.me/auth/preauth.do", a2, network, str4);
        String str6 = f1519a;
        CtAuth.info(str6, "request result : " + a3);
        String b3 = b(context, a3, b2, network);
        if (TextUtils.isEmpty(b3)) {
            return "{\"result\":80001,\"msg\":\"请求异常\"}";
        }
        cn.com.chinatelecom.gateway.lib.b.e.a(str4, b3, a2);
        return b3;
    }

    public static String a(Context context, List<String> list, String str, Network network) {
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                return null;
            }
            try {
                String str2 = list.get(i);
                if (!TextUtils.isEmpty(list.get(i)) && context != null && Build.VERSION.SDK_INT < 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(e.a(e.b(str2))))).booleanValue();
                    }
                }
                String a2 = a(context, list.get(i), str, network);
                try {
                    JSONObject jSONObject = TextUtils.isEmpty(a2) ? null : new JSONObject(a2);
                    if (jSONObject != null && jSONObject.getInt("result") == 0) {
                        return a2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            i++;
        }
    }

    public static String a(String str, String str2) {
        return cn.com.chinatelecom.gateway.lib.a.a.c(str, str2);
    }

    private void a(final Context context, final String str, final i.a aVar, final int i, final PreCodeListener preCodeListener) {
        final Future b2 = i.b(aVar);
        i.a(new Runnable() { // from class: cn.com.chinatelecom.gateway.lib.c.a.4
            /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF, INVOKE, IF] complete} */
            @Override // java.lang.Runnable
            public void run() {
                Future future;
                Context context2;
                String str2;
                PreCodeListener preCodeListener2;
                try {
                    b2.get(i, TimeUnit.MILLISECONDS);
                    Future future2 = b2;
                    if (future2 == null || future2.isDone()) {
                    }
                } catch (Throwable th) {
                    try {
                        aVar.a(true);
                        String str3 = "{\"result\":80000,\"msg\":\"请求超时\"}";
                        if (th instanceof TimeoutException) {
                            cn.com.chinatelecom.gateway.lib.b.e.a(str, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                            cn.com.chinatelecom.gateway.lib.b.e.a(str).h("submitOnTimeoutInterrupted()");
                            context2 = context;
                            str2 = str;
                            preCodeListener2 = preCodeListener;
                        } else {
                            cn.com.chinatelecom.gateway.lib.b.e.a(str, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                            cn.com.chinatelecom.gateway.lib.b.b a2 = cn.com.chinatelecom.gateway.lib.b.e.a(str);
                            StringBuilder sb = new StringBuilder();
                            sb.append("submitOnTimeoutInterrupted other exception : ");
                            sb.append(th.getMessage());
                            a2.h(sb.toString());
                            CtAuth.warn(a.f1519a, "submitOnTimeoutInterrupted other exception", th);
                            context2 = context;
                            str2 = str;
                            preCodeListener2 = preCodeListener;
                            str3 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                        }
                        CtAuth.postResultOnMainThread(context2, str3, str2, preCodeListener2);
                        if (future == null) {
                            return;
                        }
                    } finally {
                        future = b2;
                        if (future != null && !future.isDone()) {
                            b2.cancel(true);
                        }
                    }
                }
            }
        });
    }

    private String b() {
        try {
            String uuid = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(uuid)) {
                return "";
            }
            String replace = uuid.replace("-", "");
            return replace.length() >= 16 ? replace.substring(0, 16) : replace;
        } catch (Throwable th) {
            CtAuth.warn(f1519a, "generateAesKey error", th);
            return "";
        }
    }

    private String b(Context context, String str, String str2, Network network) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("data");
            if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                String a2 = a(optString, str2);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        jSONObject.put("data", new JSONObject(a2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        jSONObject.put("data", a2);
                    }
                    if (optInt == 30002) {
                        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("data");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = jSONObject2.optJSONArray("urls");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.getString(i));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return a(context, arrayList, str2, network);
                    }
                    return jSONObject.toString();
                }
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            CtAuth.warn(f1519a, "decryptResult error", th);
            return null;
        }
    }

    public static String c(Context context, String str, String str2, Network network) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("data");
            if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                String a2 = a(optString, str2);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        jSONObject.put("data", new JSONObject(a2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        jSONObject.put("data", a2);
                    }
                }
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            CtAuth.warn(f1519a, "decryptResult error", th);
            return null;
        }
    }

    public void a(final Context context, final String str, final String str2, final String str3, final PreCodeListener preCodeListener) {
        int i = CtAuth.mTotalTimeout;
        int i2 = i <= 0 ? 10000 : i;
        final String a2 = c.a();
        cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(c.a(context)).d("preauth").c(f.f(context));
        a(context, a2, new i.a() { // from class: cn.com.chinatelecom.gateway.lib.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                String a3 = a.this.a(context, str, str2, str3, null, a2);
                if (a()) {
                    return;
                }
                CtAuth.postResultOnMainThread(context, a3, a2, preCodeListener);
            }
        }, i2, preCodeListener);
    }

    public void b(final Context context, final String str, final String str2, final String str3, final PreCodeListener preCodeListener) {
        int i = CtAuth.mTotalTimeout;
        int i2 = i <= 0 ? 10000 : i;
        final String a2 = c.a();
        cn.com.chinatelecom.gateway.lib.b.e.a(a2).a(str).b(c.a(context)).d("preauth").c(f.f(context));
        if (Build.VERSION.SDK_INT < 21) {
            a(context, a2, new i.a() { // from class: cn.com.chinatelecom.gateway.lib.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!new e().a(context, "https://id6.me/auth/preauth.do")) {
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(context, h.a(80800, "WIFI切换超时"), a2, preCodeListener);
                    } else if (a()) {
                    } else {
                        String a3 = a.this.a(context, str, str2, str3, null, a2);
                        if (a()) {
                            return;
                        }
                        CtAuth.postResultOnMainThread(context, a3, a2, preCodeListener);
                    }
                }
            }, i2, preCodeListener);
            return;
        }
        e eVar = new e();
        eVar.a(context, new e.a() { // from class: cn.com.chinatelecom.gateway.lib.c.a.2

            /* renamed from: h  reason: collision with root package name */
            public boolean f1534h = false;
            public boolean i = false;

            @Override // cn.com.chinatelecom.gateway.lib.c.e.a
            public synchronized void a() {
                this.f1534h = true;
                if (!this.i) {
                    cn.com.chinatelecom.gateway.lib.b.e.a(a2, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                    CtAuth.postResultOnMainThread(context, "{\"result\":80000,\"msg\":\"请求超时\"}", a2, preCodeListener);
                }
            }

            @Override // cn.com.chinatelecom.gateway.lib.c.e.a
            public synchronized void a(int i3, String str4, long j) {
                if (!this.f1534h && !this.i) {
                    this.i = true;
                    cn.com.chinatelecom.gateway.lib.b.b a3 = cn.com.chinatelecom.gateway.lib.b.e.a(a2);
                    a3.h("switchToMobile_L  onFail()  expendTime : " + j).a(i3).f(str4).b(j);
                    CtAuth.postResultOnMainThread(context, h.a(i3, str4), a2, preCodeListener);
                    String str5 = a.f1519a;
                    CtAuth.info(str5, "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j);
                }
            }

            @Override // cn.com.chinatelecom.gateway.lib.c.e.a
            public void a(Network network, long j) {
                String str4 = a.f1519a;
                CtAuth.info(str4, "Switching network successfully (L) , expendTime ：" + j);
                if (this.f1534h || this.i) {
                    return;
                }
                cn.com.chinatelecom.gateway.lib.b.e.a(a2).b(j);
                String a3 = a.this.a(context, str, str2, str3, network, a2);
                synchronized (this) {
                    if (!this.f1534h && !this.i) {
                        this.i = true;
                        CtAuth.postResultOnMainThread(context, a3, a2, preCodeListener);
                    }
                }
            }
        });
        eVar.a(i2);
    }
}
