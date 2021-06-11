package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.a.f;
import cn.com.chinatelecom.gateway.lib.c.i;
import java.net.URLEncoder;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1543a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f1544b = {15, 31, 94, 10, 90, 15, 91, 24, 10, 30, 88, 7, 89, 10, 95, 30};

    public static void a(Context context, int i2) {
        try {
            cn.com.chinatelecom.gateway.lib.c.b.a(context, "key_c_l_l_v", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        char c2;
        int hashCode = str.hashCode();
        int i2 = 0;
        if (hashCode == 64897) {
            if (str.equals("ALL")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 78159) {
            if (hashCode == 66247144 && str.equals("ERROR")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("OFF")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                i2 = -1;
            } else if (c2 == 2) {
                i2 = -2;
            }
        }
        a(context, i2);
    }

    public static void a(Context context, List<String> list) {
        int b2 = b(context);
        if (b2 == -2) {
            return;
        }
        b(context, list, b2);
    }

    public static int b(Context context) {
        try {
            return cn.com.chinatelecom.gateway.lib.c.b.b(context, "key_c_l_l_v", 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static String b(Context context, String str) {
        return a.a(context, "https://collect.ux.21cn.com/collect/custom/accountMsg", str);
    }

    public static String b(Context context, Queue<String> queue) {
        String a2;
        JSONArray jSONArray = new JSONArray();
        String jSONArray2 = jSONArray.toString();
        if (!queue.isEmpty()) {
            for (String str : queue) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (jSONArray.length() <= 0) {
            return "";
        }
        String jSONArray3 = jSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray3)) {
            try {
                a2 = cn.com.chinatelecom.gateway.lib.a.b.a(cn.com.chinatelecom.gateway.lib.a.a.b(jSONArray3, f.a(f1544b)));
            } catch (Exception e3) {
                e = e3;
            }
            try {
                jSONArray2 = URLEncoder.encode(a2, "UTF-8");
            } catch (Exception e4) {
                e = e4;
                jSONArray2 = a2;
                e.printStackTrace();
                return b(context, jSONArray2);
            }
        }
        return b(context, jSONArray2);
    }

    public static void b(final Context context, final List<String> list, final int i2) {
        i.a(new Runnable() { // from class: cn.com.chinatelecom.gateway.lib.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Queue c2 = d.c(context, list, i2);
                    if (c2.isEmpty()) {
                        return;
                    }
                    String b2 = d.b(context, c2);
                    JSONObject jSONObject = null;
                    int i3 = -1;
                    try {
                        if (!TextUtils.isEmpty(b2)) {
                            JSONObject jSONObject2 = new JSONObject(b2);
                            try {
                                i3 = jSONObject2.getInt("code");
                                jSONObject = jSONObject2;
                            } catch (Exception e2) {
                                e = e2;
                                jSONObject = jSONObject2;
                                e.printStackTrace();
                                if (jSONObject != null) {
                                }
                                d.b(context, c2, i2);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (jSONObject != null || i3 != 0) {
                        d.b(context, c2, i2);
                        return;
                    }
                    d.c(context);
                    c2.clear();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static void b(Context context, Queue<String> queue, int i2) {
        String str;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (queue != null && !queue.isEmpty()) {
            int i3 = 0;
            for (String str2 : queue) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (i2 != -1 || jSONObject.getInt("rt") != 0) {
                    jSONArray.put(jSONObject);
                    i3++;
                    if (i3 > 10) {
                        break;
                    }
                }
            }
        }
        if (jSONArray.length() > 0) {
            try {
                str = cn.com.chinatelecom.gateway.lib.a.a.a(jSONArray.toString(), f.a(f1544b));
            } catch (Exception e3) {
                e3.printStackTrace();
                str = null;
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.a(context, str);
    }

    public static synchronized Queue<String> c(Context context, List<String> list, int i2) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (d.class) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            String a2 = c.a(context);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONArray jSONArray = new JSONArray(cn.com.chinatelecom.gateway.lib.a.a.c(a2, f.a(f1544b)));
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length && i3 <= 10; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            concurrentLinkedQueue.add(jSONObject.toString());
                        }
                    }
                    c.a(context, "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (i2 == -1) {
                for (String str : list) {
                    try {
                        if (new JSONObject(str).getInt("rt") != 0) {
                            concurrentLinkedQueue.add(str);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (i2 == 0) {
                concurrentLinkedQueue.addAll(list);
            }
            while (concurrentLinkedQueue.size() > 10) {
                concurrentLinkedQueue.poll();
            }
        }
        return concurrentLinkedQueue;
    }

    public static void c(Context context) {
        c.a(context, "");
    }
}
