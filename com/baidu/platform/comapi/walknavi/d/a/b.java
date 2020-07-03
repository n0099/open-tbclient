package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.f.f;
import com.baidu.platform.comapi.walknavi.d.a.g.g;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static boolean a = true;
    private Context b;
    private com.baidu.platform.comapi.walknavi.d.a.a c;
    private com.baidu.platform.comapi.walknavi.d.a.f.b d;
    private C0227b f;
    private a g;
    private com.baidu.platform.comapi.walknavi.d.a.a.b i;
    private com.baidu.platform.comapi.walknavi.d.a.d.b l;
    private f m;
    private com.baidu.platform.comapi.walknavi.d.a.f.c e = null;
    private com.baidu.platform.comapi.walknavi.d.a.a.a h = new com.baidu.platform.comapi.walknavi.d.a.a.a();
    private c j = c.INITIAL_STATE;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum c {
        INITIAL_STATE,
        QUERYING,
        DOWNLOADING,
        DOWNLOAD_FINISHED
    }

    public b(Context context) {
        this.b = context;
        this.l = new com.baidu.platform.comapi.walknavi.d.a.d.b(this.b);
        this.m = new f(this.b);
        com.baidu.platform.comapi.walknavi.d.a.g.f.a(this.b.getPackageName());
    }

    public void a(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        a = true;
        this.h.a(str);
        this.h.a(4);
        this.c = aVar;
        if (g.a(this.b) != null) {
            c();
        } else if (this.c != null) {
            this.c.a(1, "no network");
        }
    }

    public void b(String str, com.baidu.platform.comapi.walknavi.d.a.a aVar) {
        b();
        a = false;
        this.h.a(str);
        this.h.a(4);
        this.c = aVar;
        if (g.a(this.b) != null) {
            c();
        } else if (this.c != null) {
            this.c.a(1, "no network");
        }
    }

    public String a(String str) {
        if (this.l.a()) {
            return this.m.a(str);
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("so not loaded");
        return "";
    }

    public boolean a(String str, boolean z) {
        if (z) {
            File file = new File(com.baidu.platform.comapi.walknavi.d.a.g.f.a(str, 4));
            if (file != null && file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return true;
                }
                String a2 = a(str);
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i] != null && !listFiles[i].getAbsolutePath().contains(a2)) {
                        com.baidu.platform.comapi.walknavi.d.a.g.f.a(new File(listFiles[i].getAbsolutePath()));
                    }
                }
                return true;
            }
            return true;
        }
        return com.baidu.platform.comapi.walknavi.d.a.g.f.a(new File(com.baidu.platform.comapi.walknavi.d.a.g.f.a(str, 4)));
    }

    public boolean a() {
        return this.l.a();
    }

    public void b() {
        g();
        h();
    }

    private void c() {
        if (this.j == c.INITIAL_STATE || this.j == c.DOWNLOAD_FINISHED) {
            a(this.h);
        } else if (this.j == c.QUERYING) {
            if (this.c != null) {
                this.c.a(7, "query in progress");
            }
        } else if (this.j == c.DOWNLOADING && this.c != null) {
            this.c.a(8, "download in progress");
        }
    }

    private void a(com.baidu.platform.comapi.walknavi.d.a.a.a aVar) {
        this.j = c.QUERYING;
        this.f = new C0227b(this);
        this.e = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.b, aVar, this.f);
        if (this.e == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("Http Request Occur Error! Please Check");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0227b implements f.a<JSONObject> {
        private SoftReference<b> a;

        public C0227b(b bVar) {
            this.a = new SoftReference<>(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void a(JSONObject jSONObject) {
            try {
                if (this.a.get() != null) {
                    this.a.get().a(jSONObject);
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onResponse exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("http error msg = " + str);
            try {
                if (this.a.get() != null) {
                    this.a.get().j = c.INITIAL_STATE;
                    if (this.a.get().c != null) {
                        this.a.get().c.a(5, str);
                    }
                    this.a.get().e = null;
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query onErrorResponse exception: " + e.getMessage());
            }
        }

        public void a() {
            try {
                if (this.a.get() != null) {
                    this.a.get().j = c.INITIAL_STATE;
                }
                this.a.clear();
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("query destroy exception: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR query response: " + jSONObject.toString());
        } else {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR query response is null");
        }
        this.i = com.baidu.platform.comapi.walknavi.d.a.c.a.a(jSONObject);
        if (this.i == null && this.c != null) {
            this.c.a(-1, "ar resource is null");
        }
        if (this.i.a() != 0) {
            this.j = c.INITIAL_STATE;
            switch (this.i.a()) {
                case 1051:
                    if (this.c != null) {
                        this.c.a(3, this.i.b());
                        break;
                    }
                    break;
                case 1052:
                    if (this.c != null) {
                        this.c.a(4, this.i.b());
                        break;
                    }
                    break;
                default:
                    if (this.c != null) {
                        this.c.a(-1, this.i.b());
                    }
                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("error code = " + this.i.a() + ", error msg = " + this.i.b());
                    break;
            }
            this.e = null;
        } else if (this.i.f() || !this.i.g()) {
            this.j = c.INITIAL_STATE;
            if (this.c != null) {
                this.c.a(2, "not support AR");
            }
            this.e = null;
        } else {
            this.e = null;
            d();
        }
    }

    private void d() {
        if (this.i == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! mARResource is null");
        } else if (!TextUtils.isEmpty(this.i.d())) {
            this.j = c.DOWNLOADING;
            this.g = new a(this);
            e();
        }
    }

    private void e() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download start");
        com.baidu.platform.comapi.walknavi.d.a.a.b bVar = this.i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ERROR!! bundle data is null");
        } else if (TextUtils.isEmpty(bVar.h())) {
            this.g.b("so url is null");
        } else {
            this.l.a(new com.baidu.platform.comapi.walknavi.d.a.c(this));
            this.l.b(bVar.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d = com.baidu.platform.comapi.walknavi.d.a.f.e.a(this.i.c(), this.i.e(), this.i.d(), com.baidu.platform.comapi.walknavi.d.a.g.d.d, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements com.baidu.platform.comapi.walknavi.d.a.f.a<String> {
        private SoftReference<b> a;

        public a(b bVar) {
            this.a = new SoftReference<>(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void a(String str) {
            try {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download res finished");
                if (this.a.get() != null) {
                    this.a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.a.get().c != null) {
                        this.a.get().c.a(0, str);
                        if (this.a.get().i != null) {
                            this.a.get().m.a(this.a.get().i.c(), str);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onResponse exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.f.a
        public void b(String str) {
            try {
                if (this.a.get() != null) {
                    this.a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.a.get().c != null) {
                        this.a.get().c.a(6, str);
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onErrorResponse exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(int i) {
            try {
                if (this.a.get() != null && this.a.get().c != null) {
                    this.a.get().c.a(b(i));
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onProgress exception: " + e.getMessage());
            }
        }

        private int b(int i) {
            if (this.a.get() != null && this.a.get().k) {
                return (i / 2) + 50;
            }
            return i;
        }

        @Override // com.baidu.platform.comapi.walknavi.d.a.f.a
        public void a(boolean z, float f) {
            try {
                if (this.a.get() != null) {
                    this.a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.a.get().c != null) {
                        com.baidu.platform.comapi.walknavi.d.a.g.a.a("isUpdate=" + z + ", size=" + f);
                        if (this.a.get().l != null && this.a.get().i != null && this.a.get().l.a(this.a.get().i.h())) {
                            z = true;
                        }
                        this.a.get().c.a(z, f);
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download onUpdate exception: " + e.getMessage());
            }
        }

        public void a() {
            try {
                if (this.a.get() != null) {
                    this.a.get().j = c.INITIAL_STATE;
                }
                this.a.clear();
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("download destroy exception: " + e.getMessage());
            }
        }
    }

    private void g() {
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    private void h() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        if (this.g != null) {
            this.g.a();
        }
        if (this.l != null) {
            this.l.b();
        }
    }
}
