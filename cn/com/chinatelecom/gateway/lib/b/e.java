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
    public static final String f1528a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static int f1529b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, b> f1530c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f1531d = new ArrayList();

    public static synchronized b a(String str) {
        b bVar;
        synchronized (e.class) {
            try {
                bVar = f1530c.containsKey(str) ? f1530c.get(str) : null;
                if (bVar == null) {
                    bVar = new b(str);
                    f1530c.put(str, bVar);
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
                if (f1530c.containsKey(str)) {
                    f1531d.add(f1530c.get(str).toString());
                    f1530c.remove(str);
                }
                if (f1529b != 1 && !f1531d.isEmpty()) {
                    f1529b = 1;
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
        int i = -1;
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                i = jSONObject.getInt("result");
                str4 = jSONObject.optString("msg");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b a2 = a(str).a(i);
        if (i == 0) {
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
                arrayList.addAll(f1531d);
                f1529b = 0;
                f1531d.clear();
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
