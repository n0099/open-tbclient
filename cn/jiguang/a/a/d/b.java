package cn.jiguang.a.a.d;

import android.app.Application;
import android.content.Context;
import cn.jiguang.d.d.aa;
import cn.jiguang.g.i;
import com.baidu.ar.util.IoUtils;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static volatile b kS = null;
    public static boolean a = false;
    public static boolean b = false;
    private ExecutorService kT = Executors.newSingleThreadExecutor();
    private String e = null;
    private String f = null;
    private long g = 30;
    private long h = 0;
    private long i = 0;
    private boolean j = true;
    private boolean k = false;
    private boolean l = true;
    private long m = 0;
    private JSONObject kU = null;
    private final Object kV = new Object();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
        if ((r10.h - r10.i) > (r10.g * 1000)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if ((r10.h - r2) <= (r10.g * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(b bVar, Context context) {
        JSONObject d;
        boolean z = false;
        if (bVar.j) {
            bVar.j = false;
            long c = cn.jiguang.a.b.c.bs().c(context, "last_pause", -1L);
            if (c != -1) {
            }
            z = true;
        }
        if (!z) {
            bVar.f = cn.jiguang.a.b.c.bs().a(context, ETAG.KEY_STATISTICS_SEESIONID, null);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject e = bVar.e(context, bVar.h);
        if (e != null) {
            jSONArray.put(e);
        }
        synchronized (bVar.kV) {
            d = bVar.d(context);
            if (d != null && d.length() > 0) {
                try {
                    aa.a(context, d, "active_terminate");
                } catch (Exception e2) {
                }
                aa.b(context, "jpush_stat_cache.json", null);
                bVar.kU = null;
            }
        }
        if (d != null && d.length() > 0) {
            jSONArray.put(d);
        }
        aa.a(context, jSONArray);
    }

    private static void a(JSONObject jSONObject) {
        String a2 = cn.jiguang.d.h.c.a();
        String str = a2.split(BaseRequestAction.SPLITE)[0];
        String str2 = a2.split(BaseRequestAction.SPLITE)[1];
        jSONObject.put("date", str);
        jSONObject.put("time", str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, Context context) {
        long j;
        if (context != null) {
            synchronized (bVar.kV) {
                cn.jiguang.a.b.c.bs().d(context, "last_pause", bVar.i);
                cn.jiguang.a.b.c.bs().d(context, "cur_seesion_end", bVar.i);
                JSONObject d = bVar.d(context);
                JSONObject jSONObject = d == null ? new JSONObject() : d;
                try {
                    long c = cn.jiguang.a.b.c.bs().c(context, "cur_session_start", 0L);
                    if (c == 0) {
                        long j2 = bVar.i - bVar.m;
                        j = j2 > 0 ? j2 / 1000 : 10L;
                        cn.jiguang.a.b.c.bs().d(context, "cur_session_start", bVar.m);
                    } else {
                        j = (bVar.i - c) / 1000;
                    }
                    jSONObject.put("duration", j);
                    jSONObject.put("itime", cn.jiguang.d.a.a.bG());
                    jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, bVar.f);
                    a(jSONObject);
                } catch (Exception e) {
                }
                bVar.kU = jSONObject;
                if (bVar.kU != null) {
                    try {
                        aa.a(context, bVar.kU.toString().getBytes(IoUtils.UTF_8).length);
                    } catch (UnsupportedEncodingException e2) {
                    } catch (Exception e3) {
                    }
                }
                aa.b(context, "jpush_stat_cache.json", jSONObject);
            }
        }
    }

    public static b br() {
        if (kS == null) {
            synchronized (b.class) {
                kS = new b();
            }
        }
        return kS;
    }

    private boolean c(Context context, String str) {
        if (this.l && context != null) {
            if (context instanceof Application) {
                cn.jiguang.e.c.d("JPushSA", "Context should be an Activity on this method : " + str);
                return false;
            }
            return true;
        }
        return false;
    }

    private JSONObject d(Context context) {
        if (this.kU == null) {
            this.kU = aa.I(context, "jpush_stat_cache.json");
        }
        return this.kU;
    }

    private JSONObject e(Context context, long j) {
        cn.jiguang.a.b.c.bs().d(context, "cur_session_start", this.h);
        StringBuilder sb = new StringBuilder();
        String b2 = cn.jiguang.d.a.b(context);
        if (!i.a(b2)) {
            sb.append(b2);
        }
        String i = cn.jiguang.g.a.i(context);
        if (!i.a(i)) {
            sb.append(i);
        }
        sb.append(j);
        this.f = cn.jiguang.g.a.a(sb.toString());
        cn.jiguang.a.b.c.bs().b(context, ETAG.KEY_STATISTICS_SEESIONID, this.f);
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            aa.a(context, jSONObject, "active_launch");
            jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public final void a(Context context) {
        if (c(context, "onResume")) {
            a = true;
            try {
                this.k = false;
            } catch (ClassCastException e) {
            } catch (Exception e2) {
            }
            if (this.k) {
                return;
            }
            this.k = true;
            this.h = System.currentTimeMillis();
            this.e = context.getClass().getName();
            try {
                this.kT.execute(new e(this, context.getApplicationContext()));
            } catch (Throwable th) {
            }
        }
    }

    public final void a(Context context, String str) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.e = str;
        this.h = System.currentTimeMillis();
        try {
            this.kT.execute(new c(this, context.getApplicationContext()));
        } catch (Throwable th) {
        }
    }

    public final void b(Context context) {
        if (c(context, AudioStatusCallback.ON_PAUSE)) {
            b = true;
            try {
                this.k = true;
            } catch (ClassCastException e) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.k) {
                this.k = false;
                if (this.e == null || !this.e.equals(context.getClass().getName())) {
                    return;
                }
                this.i = System.currentTimeMillis();
                this.m = this.h;
                try {
                    this.kT.execute(new f(this, context.getApplicationContext()));
                } catch (Throwable th) {
                }
            }
        }
    }

    public final void b(Context context, String str) {
        if (this.k) {
            this.k = false;
            if (this.e == null || !this.e.equals(str)) {
                cn.jiguang.e.c.d("JPushSA", "page name didn't match the last one passed by onResume");
                return;
            }
            this.i = System.currentTimeMillis();
            try {
                this.kT.execute(new d(this, context.getApplicationContext()));
            } catch (Throwable th) {
            }
        }
    }

    public final void c(Context context) {
        try {
            if (this.e == null || !this.k) {
                return;
            }
            this.i = System.currentTimeMillis();
            try {
                this.kT.execute(new g(this, context.getApplicationContext()));
            } catch (Throwable th) {
            }
        } catch (Exception e) {
        }
    }
}
