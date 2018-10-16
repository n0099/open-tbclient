package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class s {
    private static String a = null;
    private static ConcurrentHashMap<File, Boolean> b = new ConcurrentHashMap<>();

    public static File a(Context context, String str, JSONObject jSONObject) {
        File file = new File(e(context) + str + File.separator + UUID.randomUUID().toString());
        b.put(file, true);
        cn.jiguang.d.h.f.b(file, jSONObject.toString());
        return file;
    }

    private static List<q> a(String str, Set<String> set, JSONObject jSONObject) {
        File[] e = cn.jiguang.d.h.f.e(str, false);
        if (e == null || e.length == 0) {
            return null;
        }
        boolean z = !cn.jiguang.d.h.h.h(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (File file : e) {
            Boolean bool = b.get(file);
            if (bool == null || !bool.booleanValue()) {
                q a2 = r.a(file, set);
                if (a2 == null) {
                    cn.jiguang.d.h.f.a(file);
                } else if (!cn.jiguang.d.h.h.h(a2.e())) {
                    arrayList.add(a2);
                } else if (z) {
                    a2.b(jSONObject);
                    a2.b(true);
                    a2.a(true);
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context) {
        File[] a2 = cn.jiguang.d.h.f.a(context.getFilesDir(), true);
        if (a2 == null) {
            return;
        }
        for (File file : a2) {
            if (file.getName().startsWith("jpush_stat_history")) {
                cn.jiguang.d.h.f.i(file);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        File[] a2 = cn.jiguang.d.h.f.a(context.getFilesDir(), (FileFilter) new t());
        if (a2 == null || a2.length == 0) {
            return;
        }
        u uVar = new u(null);
        v vVar = new v(str2);
        for (File file : a2) {
            try {
                File[] a3 = cn.jiguang.d.h.f.a(file, (FileFilter) uVar);
                if (a3 != null && a3.length != 0) {
                    for (File file2 : a3) {
                        File[] a4 = cn.jiguang.d.h.f.a(file2, (FileFilter) vVar);
                        if (a4 != null && a4.length != 0) {
                            for (File file3 : a4) {
                                cn.jiguang.d.h.f.i(file3);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(File file) {
        b.remove(file);
    }

    private static void a(List<q> list, long j) {
        long j2 = 0;
        for (q qVar : list) {
            j2 = qVar.a() + j2;
        }
        long j3 = j2 - j;
        while (j3 > 0) {
            q qVar2 = (q) Collections.min(list, new x());
            j3 -= qVar2.a();
            list.remove(qVar2);
            cn.jiguang.d.h.f.a(qVar2.c());
        }
    }

    public static void b(Context context) {
        cn.jiguang.api.e.a("REPORT_HISTORY", new w(context), new int[0]);
    }

    private static synchronized void d(Context context) {
        synchronized (s.class) {
            if (a == null) {
                String c = cn.jiguang.d.b.a.c(context);
                if (TextUtils.isEmpty(c)) {
                    a = null;
                } else if (c.equals(context.getPackageName())) {
                    a = "";
                } else {
                    a = c.replaceFirst(context.getPackageName() + ":", BaseRequestAction.SPLITE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(Context context, File file) {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add(AiAppsApsUtils.APP_KEY);
        hashSet.add(ETAG.KEY_SDK_VER);
        hashSet.add("core_sdk_ver");
        hashSet.add("share_sdk_ver");
        hashSet.add("statistics_sdk_ver");
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject d = aa.d(context);
        String absolutePath = file.getAbsolutePath();
        ArrayList arrayList = new ArrayList();
        List<q> a2 = a(absolutePath + File.separator + "tmp", hashSet, d);
        if ((a2 != null ? a2.size() : 0) > 0) {
            arrayList.addAll(a2);
        }
        if (!cn.jiguang.d.h.h.h(d)) {
            List<q> a3 = a(absolutePath + File.separator + "nowrap", (Set<String>) null, d);
            if ((a3 != null ? a3.size() : 0) > 0) {
                arrayList.addAll(a3);
            }
        }
        File[] a4 = cn.jiguang.d.h.f.a(file, false);
        File c = cn.jiguang.d.h.f.c(a4);
        ArrayList<q> arrayList2 = new ArrayList();
        if ((a4 != null ? a4.length : 0) > 0) {
            for (File file2 : a4) {
                if (!file2.equals(c)) {
                    arrayList2.add(r.d(file2));
                }
            }
        }
        q a5 = r.a(c, hashSet);
        if (a5 != null) {
            arrayList.add(0, a5);
        }
        try {
            if (arrayList.size() >= 2) {
                r.a(arrayList, 40960);
            }
        } catch (Throwable th) {
        }
        arrayList2.addAll(r.a(arrayList, file));
        a(arrayList2, 512000L);
        for (q qVar : arrayList2) {
            if (aa.a(context, aa.f(qVar.cb()), qVar.cb(), qVar.c()) == -2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        d(context);
        return context.getFilesDir().getPath() + File.separator + "jpush_stat_history" + (a != null ? a : "");
    }
}
