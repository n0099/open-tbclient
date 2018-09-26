package cn.jiguang.a.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.a.a.b.f;
import cn.jiguang.a.a.c.g;
import cn.jiguang.d.d.aa;
import cn.jiguang.d.h.h;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private static int b = 102400;

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i) {
        int i2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<JSONArray> arrayList = new ArrayList<>();
            int i3 = 0;
            int i4 = 0;
            JSONArray jSONArray3 = jSONArray2;
            while (i3 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject == null || optJSONObject.length() == 0) {
                    i2 = i4;
                } else {
                    i2 = h.a(optJSONObject);
                    if (i4 + i2 > i) {
                        if (jSONArray3.length() > 0) {
                            arrayList.add(jSONArray3);
                        }
                        jSONArray3 = new JSONArray();
                        jSONArray3.put(optJSONObject);
                    } else {
                        jSONArray3.put(optJSONObject);
                        i2 += i4;
                    }
                }
                i3++;
                i4 = i2;
            }
            if (jSONArray3.length() > 0) {
                arrayList.add(jSONArray3);
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(Context context) {
        ArrayList<JSONArray> a2;
        if (context == null || (a2 = a(cn.jiguang.a.a.c.d.T(context), b)) == null || a2.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        aa.a(context, jSONObject, "app_list");
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            JSONArray jSONArray = a2.get(i);
            JSONObject jSONObject2 = new JSONObject();
            try {
                h.a(jSONObject2, jSONObject);
                jSONObject2.put("data", jSONArray);
                jSONObject2.put("slice_index", i + 1);
                jSONObject2.put("slice_count", size);
                aa.a(context, jSONObject2);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, int i) {
        try {
            a.execute(new d(context, i));
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str) {
        if (cn.jiguang.d.a.d.d(context)) {
            if (TextUtils.isEmpty(cn.jiguang.a.a.c.a.a(context))) {
                a(context);
                cn.jiguang.a.a.c.a.a(context, cn.jiguang.a.a.c.d.g(context, true));
                return;
            }
            try {
                new cn.jiguang.a.a.c.a(context, str).start();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (cn.jiguang.d.a.d.d(context)) {
            if (context == null) {
                throw new IllegalArgumentException("NULL context");
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            aa.a(context, jSONObject);
        }
    }

    public static void a(Context context, boolean z) {
        try {
            f.a(context, false);
        } catch (Throwable th) {
        }
    }

    public static void b(Context context) {
        String[] S = cn.jiguang.a.a.c.d.S(context);
        if (S == null || S.length == 0) {
            return;
        }
        int length = S.length;
        String str = "[";
        String b2 = cn.jiguang.d.a.b(context);
        long c = cn.jiguang.d.a.d.c(context);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            String str2 = S[i];
            str = i2 == 0 ? str + "\"" + str2 + "\"" : str + ",\"" + str2 + "\"";
            int i4 = i + 1;
            int i5 = i2 + 1;
            if (i5 >= 50 || str.length() > 1000 || i4 == length) {
                aa.a(context, cn.jiguang.g.a.a("android_permissions", String.format(Locale.ENGLISH, "{\"total\":%d,\"page\":%d,\"senderid\":\"%s\",\"uid\":%s,\"permission_list\":%s}", Integer.valueOf(length), Integer.valueOf(i3), b2, Long.valueOf(c), str + "]")));
                str = "[";
                i3++;
                i5 = 0;
            }
            i2 = i5;
            i = i4;
        }
    }

    public static void b(Context context, int i) {
        g.a(context, i);
    }
}
