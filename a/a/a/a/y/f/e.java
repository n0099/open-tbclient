package a.a.a.a.y.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a.a.a.a.y.f.d {

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1382b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1383c;

    /* loaded from: classes.dex */
    public class a extends C0005e {
        public a(JSONObject jSONObject) {
            super(jSONObject);
            a.a.a.a.y.b.d();
        }

        @Override // a.a.a.a.y.f.e.b
        public void c() {
            a.a.a.a.y.b.a("key_rpt_suc_c", a.a.a.a.y.b.c() + 1);
            e eVar = e.this;
            d dVar = null;
            if (eVar != null) {
                int a2 = a.a.a.a.y.b.a();
                int i2 = a.a.a.a.y.b.f1368a.getInt("key_rpt_mis_c", 0);
                if (a2 > 0 || i2 > 0) {
                    int b2 = a.a.a.a.y.b.b();
                    int c2 = a.a.a.a.y.b.c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ContentUtil.REQ_KEY_REQ, b2);
                        jSONObject.put("fai", a2);
                        jSONObject.put("suc", c2);
                        jSONObject.put("mis", i2);
                    } catch (JSONException unused) {
                    }
                    dVar = new d(eVar, a.a.a.a.y.f.c.a("k_rpt", jSONObject, System.currentTimeMillis()), b2, a2, c2, i2);
                }
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            throw null;
        }

        @Override // a.a.a.a.y.f.e.C0005e
        public void e() {
            a.a.a.a.y.b.a("key_rpt_fai_c", a.a.a.a.y.b.a() + 1);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f1385a;

        public b(JSONObject jSONObject) {
            this.f1385a = jSONObject;
            if (FunAdSdk.isLogEnabled()) {
                a.a.a.a.y.d.c("report Event:" + this, new Object[0]);
            }
        }

        @Override // a.a.a.a.y.f.e.c
        public boolean a() {
            return d();
        }

        public void b() {
        }

        public void c() {
        }

        public final boolean d() {
            boolean z = false;
            try {
                a.a.a.a.w.f a2 = new a.a.a.a.w.c(e.this.f1383c, new a.a.a.a.w.e(this.f1385a)).a();
                if (a2 != null) {
                    if (a2.f1360a == 200) {
                        z = true;
                    }
                }
            } catch (IOException e2) {
                a.a.a.a.y.d.a(e2);
            }
            if (z) {
                c();
            } else {
                b();
            }
            return z;
        }

        public String toString() {
            try {
                return "Event{key=" + this.f1385a.getString("key") + ", content=" + this.f1385a.getString("content") + '}';
            } catch (JSONException unused) {
                return "Unknown Event";
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes.dex */
    public class d extends b {

        /* renamed from: c  reason: collision with root package name */
        public final int f1387c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1388d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1389e;

        /* renamed from: f  reason: collision with root package name */
        public final int f1390f;

        public d(e eVar, JSONObject jSONObject, int i2, int i3, int i4, int i5) {
            super(jSONObject);
            this.f1387c = i2;
            this.f1388d = i3;
            this.f1389e = i4;
            this.f1390f = i5;
        }

        @Override // a.a.a.a.y.f.e.b
        public void c() {
            a.a.a.a.y.b.a(this.f1387c, this.f1388d, this.f1389e, this.f1390f);
        }
    }

    /* renamed from: a.a.a.a.y.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0005e extends b {

        /* renamed from: c  reason: collision with root package name */
        public int f1391c;

        public C0005e(JSONObject jSONObject) {
            super(jSONObject);
            this.f1391c = 0;
        }

        @Override // a.a.a.a.y.f.e.b
        public final void b() {
            int i2 = this.f1391c;
            int i3 = i2 + 1;
            this.f1391c = i3;
            if (i2 < 3) {
                try {
                    this.f1385a.put("retry_i", i3);
                } catch (JSONException unused) {
                }
                e eVar = e.this;
                eVar.f1382b.sendMessageDelayed(eVar.f1382b.obtainMessage(102, this), 2000L);
                return;
            }
            a.a.a.a.y.d.b("Give up report event:" + this, new Object[0]);
            e();
        }

        public void e() {
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Handler {
        public f(@NonNull Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 != 101) {
                if (i2 != 102) {
                    return;
                }
                ((c) message.obj).a();
                return;
            }
            int i3 = message.arg1;
            int c2 = a.a.a.a.y.b.c();
            int a2 = a.a.a.a.y.b.a();
            int i4 = (i3 - c2) - a2;
            a.a.a.a.y.d.a("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(c2), Integer.valueOf(a2), Integer.valueOf(i4));
            if (i4 > 0) {
                a.a.a.a.y.b.a("key_rpt_mis_c", i4);
            }
        }
    }

    public e(String str) {
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        this.f1382b = new f(handlerThread.getLooper());
        this.f1383c = str;
        this.f1382b.obtainMessage(101, a.a.a.a.y.b.b(), 0).sendToTarget();
    }

    @Override // a.a.a.a.y.f.d
    public void a(String str, String str2, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, obj);
        } catch (JSONException unused) {
        }
        a(str, jSONObject);
    }

    @Override // a.a.a.a.y.f.d
    public void a(String str, Map<String, Object> map) {
        a(str, new JSONObject(map));
    }

    public void a(String str, JSONObject jSONObject) {
        JSONObject a2 = a.a.a.a.y.f.c.a(str, jSONObject, System.currentTimeMillis());
        this.f1382b.sendMessageDelayed(this.f1382b.obtainMessage(102, "ad".equals(str) ? new a(a2) : new C0005e(a2)), 0L);
    }
}
