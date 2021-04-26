package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.f.f;
import com.baidu.platform.comapi.walknavi.d.a.g.g;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9859a = true;

    /* renamed from: b  reason: collision with root package name */
    public Context f9860b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a f9861c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.f.b f9862d;

    /* renamed from: f  reason: collision with root package name */
    public C0121b f9864f;

    /* renamed from: g  reason: collision with root package name */
    public a f9865g;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a.b f9867i;
    public com.baidu.platform.comapi.walknavi.d.a.d.b l;
    public f m;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.f.c f9863e = null;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a.a f9866h = new com.baidu.platform.comapi.walknavi.d.a.a.a();
    public c j = c.INITIAL_STATE;
    public boolean k = false;

    /* loaded from: classes2.dex */
    public static class a implements com.baidu.platform.comapi.walknavi.d.a.f.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference<b> f9868a;

        public a(b bVar) {
            this.f9868a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            try {
                if (this.f9868a.get() != null) {
                    this.f9868a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9868a.get().f9861c != null) {
                        this.f9868a.get().f9861c.a(6, str);
                    }
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onErrorResponse exception: " + e2.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void a(String str) {
            try {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download res finished");
                if (this.f9868a.get() != null) {
                    this.f9868a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9868a.get().f9861c != null) {
                        this.f9868a.get().f9861c.a(0, str);
                        if (this.f9868a.get().f9867i != null) {
                            this.f9868a.get().m.a(this.f9868a.get().f9867i.c(), str);
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onResponse exception: " + e2.getMessage());
            }
        }

        private int b(int i2) {
            return (this.f9868a.get() == null || !this.f9868a.get().k) ? i2 : (i2 / 2) + 50;
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(int i2) {
            try {
                if (this.f9868a.get() == null || this.f9868a.get().f9861c == null) {
                    return;
                }
                this.f9868a.get().f9861c.a(b(i2));
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onProgress exception: " + e2.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(boolean z, float f2) {
            try {
                if (this.f9868a.get() != null) {
                    this.f9868a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9868a.get().f9861c != null) {
                        com.baidu.platform.comapi.walknavi.d.a.g.a.a("isUpdate=" + z + ", size=" + f2);
                        if (this.f9868a.get().l != null && this.f9868a.get().f9867i != null && this.f9868a.get().l.a(this.f9868a.get().f9867i.h())) {
                            z = true;
                        }
                        this.f9868a.get().f9861c.a(z, f2);
                    }
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onUpdate exception: " + e2.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9868a.get() != null) {
                    this.f9868a.get().j = c.INITIAL_STATE;
                }
                this.f9868a.clear();
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download destroy exception: " + e2.getMessage());
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0121b implements f.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference<b> f9869a;

        public C0121b(b bVar) {
            this.f9869a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("http error msg = " + str);
            try {
                if (this.f9869a.get() != null) {
                    this.f9869a.get().j = c.INITIAL_STATE;
                    if (this.f9869a.get().f9861c != null) {
                        this.f9869a.get().f9861c.a(5, str);
                    }
                    this.f9869a.get().f9863e = null;
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onErrorResponse exception: " + e2.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void a(JSONObject jSONObject) {
            try {
                if (this.f9869a.get() != null) {
                    this.f9869a.get().a(jSONObject);
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onResponse exception: " + e2.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9869a.get() != null) {
                    this.f9869a.get().j = c.INITIAL_STATE;
                }
                this.f9869a.clear();
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query destroy exception: " + e2.getMessage());
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        INITIAL_STATE,
        QUERYING,
        DOWNLOADING,
        DOWNLOAD_FINISHED
    }

    public b(Context context) {
        this.f9860b = context;
        this.l = new com.baidu.platform.comapi.walknavi.d.a.d.b(context);
        this.m = new f(this.f9860b);
        com.baidu.platform.comapi.walknavi.d.a.g.f.a(this.f9860b.getPackageName());
    }

    private void h() {
        com.baidu.platform.comapi.walknavi.d.a.f.b bVar = this.f9862d;
        if (bVar != null) {
            bVar.cancel(true);
            this.f9862d = null;
        }
        a aVar = this.f9865g;
        if (aVar != null) {
            aVar.a();
        }
        com.baidu.platform.comapi.walknavi.d.a.d.b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    private void c() {
        com.baidu.platform.comapi.walknavi.d.a.a aVar;
        c cVar = this.j;
        if (cVar != c.INITIAL_STATE && cVar != c.DOWNLOAD_FINISHED) {
            if (cVar == c.QUERYING) {
                com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9861c;
                if (aVar2 != null) {
                    aVar2.a(7, "query in progress");
                    return;
                }
                return;
            } else if (cVar != c.DOWNLOADING || (aVar = this.f9861c) == null) {
                return;
            } else {
                aVar.a(8, "download in progress");
                return;
            }
        }
        a(this.f9866h);
    }

    private void d() {
        com.baidu.platform.comapi.walknavi.d.a.a.b bVar = this.f9867i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! mARResource is null");
        } else if (TextUtils.isEmpty(bVar.d())) {
        } else {
            this.j = c.DOWNLOADING;
            this.f9865g = new a(this);
            e();
        }
    }

    private void e() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download start");
        com.baidu.platform.comapi.walknavi.d.a.a.b bVar = this.f9867i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! bundle data is null");
        } else if (TextUtils.isEmpty(bVar.h())) {
            this.f9865g.b("so url is null");
        } else {
            this.l.a(new com.baidu.platform.comapi.walknavi.d.a.c(this));
            this.l.b(bVar.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f9862d = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.f9867i.c(), this.f9867i.e(), this.f9867i.d(), com.baidu.platform.comapi.walknavi.d.a.g.d.f9922d, this.f9865g);
    }

    private void g() {
        com.baidu.platform.comapi.walknavi.d.a.f.c cVar = this.f9863e;
        if (cVar != null) {
            cVar.a();
            this.f9863e = null;
        }
        C0121b c0121b = this.f9864f;
        if (c0121b != null) {
            c0121b.a();
        }
    }

    public void b(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        f9859a = false;
        this.f9866h.a(str);
        this.f9866h.a(4);
        this.f9861c = aVar;
        if (g.a(this.f9860b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9861c;
        if (aVar2 != null) {
            aVar2.a(1, "no network");
        }
    }

    public void a(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        f9859a = true;
        this.f9866h.a(str);
        this.f9866h.a(4);
        this.f9861c = aVar;
        if (g.a(this.f9860b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9861c;
        if (aVar2 != null) {
            aVar2.a(1, "no network");
        }
    }

    public void b() {
        g();
        h();
    }

    public String a(String str) {
        if (this.l.a()) {
            return this.m.a(str);
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("so not loaded");
        return "";
    }

    public boolean a(String str, boolean z) {
        File[] listFiles;
        if (z) {
            File file = new File(com.baidu.platform.comapi.walknavi.d.a.g.f.a(str, 4));
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                String a2 = a(str);
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (listFiles[i2] != null && !listFiles[i2].getAbsolutePath().contains(a2)) {
                        com.baidu.platform.comapi.walknavi.d.a.g.f.a(new File(listFiles[i2].getAbsolutePath()));
                    }
                }
            }
            return true;
        }
        return com.baidu.platform.comapi.walknavi.d.a.g.f.a(new File(com.baidu.platform.comapi.walknavi.d.a.g.f.a(str, 4)));
    }

    public boolean a() {
        return this.l.a();
    }

    private void a(com.baidu.platform.comapi.walknavi.d.a.a.a aVar) {
        this.j = c.QUERYING;
        C0121b c0121b = new C0121b(this);
        this.f9864f = c0121b;
        com.baidu.platform.comapi.walknavi.d.a.f.c a2 = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.f9860b, aVar, c0121b);
        this.f9863e = a2;
        if (a2 == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("Http Request Occur Error! Please Check");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        com.baidu.platform.comapi.walknavi.d.a.a aVar;
        if (jSONObject != null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR query response: " + jSONObject.toString());
        } else {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR query response is null");
        }
        com.baidu.platform.comapi.walknavi.d.a.a.b a2 = com.baidu.platform.comapi.walknavi.d.a.c.a.a(jSONObject);
        this.f9867i = a2;
        if (a2 == null && (aVar = this.f9861c) != null) {
            aVar.a(-1, "ar resource is null");
        }
        if (this.f9867i.a() != 0) {
            this.j = c.INITIAL_STATE;
            int a3 = this.f9867i.a();
            if (a3 == 1051) {
                com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9861c;
                if (aVar2 != null) {
                    aVar2.a(3, this.f9867i.b());
                }
            } else if (a3 != 1052) {
                com.baidu.platform.comapi.walknavi.d.a.a aVar3 = this.f9861c;
                if (aVar3 != null) {
                    aVar3.a(-1, this.f9867i.b());
                }
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("error code = " + this.f9867i.a() + ", error msg = " + this.f9867i.b());
            } else {
                com.baidu.platform.comapi.walknavi.d.a.a aVar4 = this.f9861c;
                if (aVar4 != null) {
                    aVar4.a(4, this.f9867i.b());
                }
            }
            this.f9863e = null;
        } else if (!this.f9867i.f() && this.f9867i.g()) {
            this.f9863e = null;
            d();
        } else {
            this.j = c.INITIAL_STATE;
            com.baidu.platform.comapi.walknavi.d.a.a aVar5 = this.f9861c;
            if (aVar5 != null) {
                aVar5.a(2, "not support AR");
            }
            this.f9863e = null;
        }
    }
}
