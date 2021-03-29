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
    public static boolean f9945a = true;

    /* renamed from: b  reason: collision with root package name */
    public Context f9946b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a f9947c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.f.b f9948d;

    /* renamed from: f  reason: collision with root package name */
    public C0122b f9950f;

    /* renamed from: g  reason: collision with root package name */
    public a f9951g;
    public com.baidu.platform.comapi.walknavi.d.a.a.b i;
    public com.baidu.platform.comapi.walknavi.d.a.d.b l;
    public f m;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.f.c f9949e = null;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a.a f9952h = new com.baidu.platform.comapi.walknavi.d.a.a.a();
    public c j = c.INITIAL_STATE;
    public boolean k = false;

    /* loaded from: classes2.dex */
    public static class a implements com.baidu.platform.comapi.walknavi.d.a.f.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference<b> f9953a;

        public a(b bVar) {
            this.f9953a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            try {
                if (this.f9953a.get() != null) {
                    this.f9953a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9953a.get().f9947c != null) {
                        this.f9953a.get().f9947c.a(6, str);
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
                if (this.f9953a.get() != null) {
                    this.f9953a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9953a.get().f9947c != null) {
                        this.f9953a.get().f9947c.a(0, str);
                        if (this.f9953a.get().i != null) {
                            this.f9953a.get().m.a(this.f9953a.get().i.c(), str);
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onResponse exception: " + e2.getMessage());
            }
        }

        private int b(int i) {
            return (this.f9953a.get() == null || !this.f9953a.get().k) ? i : (i / 2) + 50;
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(int i) {
            try {
                if (this.f9953a.get() == null || this.f9953a.get().f9947c == null) {
                    return;
                }
                this.f9953a.get().f9947c.a(b(i));
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onProgress exception: " + e2.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(boolean z, float f2) {
            try {
                if (this.f9953a.get() != null) {
                    this.f9953a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9953a.get().f9947c != null) {
                        com.baidu.platform.comapi.walknavi.d.a.g.a.a("isUpdate=" + z + ", size=" + f2);
                        if (this.f9953a.get().l != null && this.f9953a.get().i != null && this.f9953a.get().l.a(this.f9953a.get().i.h())) {
                            z = true;
                        }
                        this.f9953a.get().f9947c.a(z, f2);
                    }
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onUpdate exception: " + e2.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9953a.get() != null) {
                    this.f9953a.get().j = c.INITIAL_STATE;
                }
                this.f9953a.clear();
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download destroy exception: " + e2.getMessage());
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0122b implements f.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference<b> f9954a;

        public C0122b(b bVar) {
            this.f9954a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("http error msg = " + str);
            try {
                if (this.f9954a.get() != null) {
                    this.f9954a.get().j = c.INITIAL_STATE;
                    if (this.f9954a.get().f9947c != null) {
                        this.f9954a.get().f9947c.a(5, str);
                    }
                    this.f9954a.get().f9949e = null;
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onErrorResponse exception: " + e2.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void a(JSONObject jSONObject) {
            try {
                if (this.f9954a.get() != null) {
                    this.f9954a.get().a(jSONObject);
                }
            } catch (Exception e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onResponse exception: " + e2.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9954a.get() != null) {
                    this.f9954a.get().j = c.INITIAL_STATE;
                }
                this.f9954a.clear();
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
        this.f9946b = context;
        this.l = new com.baidu.platform.comapi.walknavi.d.a.d.b(context);
        this.m = new f(this.f9946b);
        com.baidu.platform.comapi.walknavi.d.a.g.f.a(this.f9946b.getPackageName());
    }

    private void h() {
        com.baidu.platform.comapi.walknavi.d.a.f.b bVar = this.f9948d;
        if (bVar != null) {
            bVar.cancel(true);
            this.f9948d = null;
        }
        a aVar = this.f9951g;
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
                com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9947c;
                if (aVar2 != null) {
                    aVar2.a(7, "query in progress");
                    return;
                }
                return;
            } else if (cVar != c.DOWNLOADING || (aVar = this.f9947c) == null) {
                return;
            } else {
                aVar.a(8, "download in progress");
                return;
            }
        }
        a(this.f9952h);
    }

    private void d() {
        com.baidu.platform.comapi.walknavi.d.a.a.b bVar = this.i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! mARResource is null");
        } else if (TextUtils.isEmpty(bVar.d())) {
        } else {
            this.j = c.DOWNLOADING;
            this.f9951g = new a(this);
            e();
        }
    }

    private void e() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download start");
        com.baidu.platform.comapi.walknavi.d.a.a.b bVar = this.i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! bundle data is null");
        } else if (TextUtils.isEmpty(bVar.h())) {
            this.f9951g.b("so url is null");
        } else {
            this.l.a(new com.baidu.platform.comapi.walknavi.d.a.c(this));
            this.l.b(bVar.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f9948d = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.i.c(), this.i.e(), this.i.d(), com.baidu.platform.comapi.walknavi.d.a.g.d.f10007d, this.f9951g);
    }

    private void g() {
        com.baidu.platform.comapi.walknavi.d.a.f.c cVar = this.f9949e;
        if (cVar != null) {
            cVar.a();
            this.f9949e = null;
        }
        C0122b c0122b = this.f9950f;
        if (c0122b != null) {
            c0122b.a();
        }
    }

    public void b(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        f9945a = false;
        this.f9952h.a(str);
        this.f9952h.a(4);
        this.f9947c = aVar;
        if (g.a(this.f9946b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9947c;
        if (aVar2 != null) {
            aVar2.a(1, "no network");
        }
    }

    public void a(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        f9945a = true;
        this.f9952h.a(str);
        this.f9952h.a(4);
        this.f9947c = aVar;
        if (g.a(this.f9946b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9947c;
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
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i] != null && !listFiles[i].getAbsolutePath().contains(a2)) {
                        com.baidu.platform.comapi.walknavi.d.a.g.f.a(new File(listFiles[i].getAbsolutePath()));
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
        C0122b c0122b = new C0122b(this);
        this.f9950f = c0122b;
        com.baidu.platform.comapi.walknavi.d.a.f.c a2 = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.f9946b, aVar, c0122b);
        this.f9949e = a2;
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
        this.i = a2;
        if (a2 == null && (aVar = this.f9947c) != null) {
            aVar.a(-1, "ar resource is null");
        }
        if (this.i.a() != 0) {
            this.j = c.INITIAL_STATE;
            int a3 = this.i.a();
            if (a3 == 1051) {
                com.baidu.platform.comapi.walknavi.d.a.a aVar2 = this.f9947c;
                if (aVar2 != null) {
                    aVar2.a(3, this.i.b());
                }
            } else if (a3 != 1052) {
                com.baidu.platform.comapi.walknavi.d.a.a aVar3 = this.f9947c;
                if (aVar3 != null) {
                    aVar3.a(-1, this.i.b());
                }
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("error code = " + this.i.a() + ", error msg = " + this.i.b());
            } else {
                com.baidu.platform.comapi.walknavi.d.a.a aVar4 = this.f9947c;
                if (aVar4 != null) {
                    aVar4.a(4, this.i.b());
                }
            }
            this.f9949e = null;
        } else if (!this.i.f() && this.i.g()) {
            this.f9949e = null;
            d();
        } else {
            this.j = c.INITIAL_STATE;
            com.baidu.platform.comapi.walknavi.d.a.a aVar5 = this.f9947c;
            if (aVar5 != null) {
                aVar5.a(2, "not support AR");
            }
            this.f9949e = null;
        }
    }
}
