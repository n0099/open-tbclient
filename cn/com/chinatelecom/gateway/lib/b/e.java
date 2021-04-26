package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1535a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static int f1536b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, b> f1537c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f1538d = new ArrayList();

    public static synchronized b a(String str) {
        b bVar;
        synchronized (e.class) {
            try {
                bVar = f1537c.containsKey(str) ? f1537c.get(str) : null;
                if (bVar == null) {
                    bVar = new b(str);
                    f1537c.put(str, bVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return new b(str);
            }
        }
        return bVar;
    }

    public static void a(final Context context, String str) {
        try {
            synchronized (e.class) {
                if (f1537c.containsKey(str)) {
                    f1538d.add(f1537c.get(str).toString());
                    f1537c.remove(str);
                }
                if (f1536b != 1 && !f1538d.isEmpty()) {
                    f1536b = 1;
                    new Timer().schedule(new TimerTask() { // from class: cn.com.chinatelecom.gateway.lib.b.e.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            e.b(context);
                        }
                    }, 8000L);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3) {
        String str4 = "";
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("result");
                str4 = jSONObject.optString("msg");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b a2 = a(str).a(i2);
        if (i2 == 0) {
            a2.f(str4);
        } else {
            a2.f(str4).e(str3);
        }
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (e.class) {
                arrayList.addAll(f1538d);
                f1536b = 0;
                f1538d.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.a(context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        d.a(context, str);
    }
}
