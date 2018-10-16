package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.d.d.aa;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e implements Thread.UncaughtExceptionHandler {
    public boolean a;
    private Thread.UncaughtExceptionHandler kP = null;
    private static e kO = new e();
    private static int c = 1048576;

    private e() {
        this.a = true;
        this.a = cn.jiguang.d.a.d.b();
    }

    private static JSONArray T(Context context) {
        String f = cn.jiguang.d.h.f.f(cn.jiguang.d.h.f.K(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        try {
            return new JSONArray(f);
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject U(Context context) {
        JSONArray T = T(context);
        if (T == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", T);
            jSONObject.put(HttpConstants.NETWORK_TYPE, cn.jiguang.g.a.e(context));
            aa.a(context, jSONObject, com.baidu.fsg.base.statistics.b.o);
            JSONObject a = b.a(context);
            if (a == null || a.length() <= 0) {
                return jSONObject;
            }
            jSONObject.put("device_info", a);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    private static String a(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length > 1) {
                for (int length = split.length - 1; length >= 0; length--) {
                    if (split[length].endsWith("Exception") || split[length].endsWith("Error")) {
                        return split[length];
                    }
                }
                return th2;
            }
            return th2;
        } catch (NullPointerException e) {
            return th2;
        } catch (PatternSyntaxException e2) {
            return th2;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x009d: IGET  (r1v7 int A[REMOVE]) = (r1v5 android.content.pm.PackageInfo) android.content.pm.PackageInfo.versionCode int)] */
    private JSONArray a(Context context, JSONArray jSONArray, int i, Throwable th) {
        JSONObject jSONObject;
        int i2;
        int i3 = 0;
        long bH = cn.jiguang.d.a.a.bH() + System.currentTimeMillis();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i4 = 0;
        while (true) {
            try {
                if (i4 >= jSONArray.length()) {
                    jSONObject = null;
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i4);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put(Config.TRACE_VISIT_RECENT_COUNT, jSONObject.getInt(Config.TRACE_VISIT_RECENT_COUNT) + 1);
                    jSONObject.put("crashtime", bH);
                    break;
                }
                i4++;
            } catch (Throwable th2) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", bH);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", a(th));
            jSONObject2.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
            jSONObject2.put("networktype", cn.jiguang.g.a.e(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String sb = new StringBuilder().append(packageInfo.versionCode).toString();
                jSONObject2.put("versionname", str);
                jSONObject2.put("versioncode", sb);
            }
            if (jSONObject2.toString().length() + i < c) {
                jSONArray.put(jSONObject2);
            } else {
                long j = -1;
                int i5 = 0;
                while (i5 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("crashtime");
                        if (j == -1 || optLong < j) {
                            j = optLong;
                            i2 = i5;
                            i5++;
                            i3 = i2;
                        }
                    }
                    i2 = i3;
                    i5++;
                    i3 = i2;
                }
                jSONArray.put(i3, jSONObject2);
            }
        }
        return jSONArray;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        cn.jiguang.d.h.f.a(cn.jiguang.d.h.f.K(context, "jpush_uncaughtexception_file"));
    }

    public static void a(Context context, String str) {
        if (!cn.jiguang.g.i.a(str) && str.equals(com.baidu.fsg.base.statistics.b.o)) {
            e eVar = kO;
            if (context == null || !cn.jiguang.d.a.d.d(context)) {
                return;
            }
            try {
                new f(eVar).start();
            } catch (Throwable th) {
            }
        }
    }

    public static e bq() {
        return kO;
    }

    private JSONArray c(Context context, Throwable th) {
        JSONArray jSONArray;
        int i = 0;
        String f = cn.jiguang.d.h.f.f(cn.jiguang.d.h.f.K(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(f)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(f);
                try {
                    i = f.length();
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                jSONArray = null;
            }
        }
        return a(context, jSONArray, i, th);
    }

    public final void b() {
        if (this.kP == null) {
            this.kP = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Context X;
        File K;
        if (this.a) {
            if (this.a && (X = cn.jiguang.d.a.X(null)) != null) {
                JSONArray c2 = c(X, th);
                a(X);
                String jSONArray = c2 != null ? c2.toString() : null;
                if (!TextUtils.isEmpty(jSONArray) && (K = cn.jiguang.d.h.f.K(X, "jpush_uncaughtexception_file")) != null) {
                    cn.jiguang.d.h.f.b(K, jSONArray);
                }
            }
            try {
                f fVar = new f(this);
                fVar.start();
                fVar.join(SystemScreenshotManager.DELAY_TIME);
            } catch (InterruptedException e) {
            } catch (Throwable th2) {
            }
        }
        if (this.kP != this) {
            this.kP.uncaughtException(thread, th);
        }
        throw new RuntimeException(th);
    }
}
