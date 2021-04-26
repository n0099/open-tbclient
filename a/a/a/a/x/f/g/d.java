package a.a.a.a.x.f.g;

import a.a.a.a.x.f.e;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.x.f.d f1394a = a.a.a.a.x.f.d.a();

    /* renamed from: b  reason: collision with root package name */
    public final String f1395b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1396c;

    /* loaded from: classes.dex */
    public class a extends HashMap<String, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f1397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1398b;

        public a(Object[] objArr, String str) {
            this.f1397a = objArr;
            this.f1398b = str;
            Object[] objArr2 = this.f1397a;
            if (objArr2 != null && objArr2.length > 0) {
                if (objArr2.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i2 = 0;
                while (true) {
                    Object[] objArr3 = this.f1397a;
                    if (i2 >= objArr3.length) {
                        break;
                    }
                    put(objArr3[i2].toString(), this.f1397a[i2 + 1]);
                    i2 += 2;
                }
            }
            put("st", this.f1398b);
            put("sid", d.this.f1395b);
            put("ldr_i", Integer.valueOf(a.a.a.a.x.b.a(d.this.f1395b)));
            put("type", d.this.f1396c);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public b(String str) {
            super(str, "n");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public c(String str) {
            super(str, "p");
        }
    }

    /* renamed from: a.a.a.a.x.f.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005d extends d {

        /* renamed from: d  reason: collision with root package name */
        public long f1400d;

        public C0005d(String str) {
            super(str, "s");
        }

        public void a(int i2, int i3) {
            a("ldr_ld_err", "layer", Integer.valueOf(i2), NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i3));
        }

        public void a(int i2, String str, int i3) {
            a("ldr_sld_st", "layer", Integer.valueOf(i2), "stype", str, "sst", Integer.valueOf(i3));
        }

        @Override // a.a.a.a.x.f.g.d
        public void a(String str, Object... objArr) {
            Object[] objArr2 = new Object[objArr.length + 2];
            objArr2[0] = "lid";
            objArr2[1] = Long.valueOf(this.f1400d);
            System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
            super.a(str, objArr2);
        }

        public void a(boolean z) {
            this.f1400d = System.currentTimeMillis();
            a();
            a("ldr_ld_start", "irpt", Integer.valueOf(z ? 1 : 0));
        }

        @Override // a.a.a.a.x.f.g.d
        public void b() {
            throw new UnsupportedOperationException();
        }
    }

    public d(String str, String str2) {
        this.f1395b = str;
        this.f1396c = str2;
    }

    public void a() {
        int a2 = a.a.a.a.x.b.a(this.f1395b);
        a.a.a.a.x.b.f1360a.edit().putInt("key_sid_c_pre_" + this.f1395b, a2 + 1).apply();
    }

    public void b() {
        a();
        a("ldr_ld_start", new Object[0]);
    }

    public void c() {
        a("ldr_sh_start", new Object[0]);
    }

    public void a(String str, Object... objArr) {
        ((e) this.f1394a).f1374b.obtainMessage(0, new e.a("ad_ldr", new JSONObject(new a(objArr, str)))).sendToTarget();
    }
}
