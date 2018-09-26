package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.parser.ARResourceKey;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class y {
    private static final Object c = new Object();
    private static z lC;
    private static volatile FutureTask<?> lD;

    public static void a(Context context, boolean z) {
        if (lC == null) {
            lC = new z(context, (byte) 0);
        }
        if (lD == null || lD.isCancelled() || lD.isDone()) {
            synchronized (c) {
                if (lD == null || lD.isCancelled() || lD.isDone()) {
                    try {
                        FutureTask<?> futureTask = new FutureTask<>(lC, null);
                        lD = futureTask;
                        cn.jiguang.api.e.a(futureTask, new int[0]);
                    } catch (Throwable th) {
                    }
                }
            }
        }
        if (z) {
            try {
                lD.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
            } catch (Throwable th2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashSet<String> aj(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String p = cn.jiguang.d.a.d.p(context);
        if (!TextUtils.isEmpty(p)) {
            try {
                JSONArray jSONArray = new JSONArray(p);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedHashSet.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ cn.jiguang.d.b.a.g ak(Context context) {
        String b = cn.jiguang.d.a.b(context);
        long c2 = cn.jiguang.d.a.d.c(context);
        int a = cn.jiguang.g.k.a(context);
        String b2 = cn.jiguang.g.k.b(context);
        cn.jiguang.a.a.b.e R = cn.jiguang.a.a.b.f.R(context);
        return new cn.jiguang.d.b.a.g(a, b, "1.2.5", c2, b2, R.b(), R.c(), R.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        c a = k.a(str, str2, context, true, 3, 2);
        if (a.a() == 0) {
            String b = a.b();
            if (!TextUtils.isEmpty(b)) {
                try {
                    f.bE().a(context, new JSONObject(b).getJSONObject(ARResourceKey.HTTP_RET));
                    return true;
                } catch (Throwable th) {
                }
            }
        }
        return false;
    }
}
