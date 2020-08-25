package com.baidu.helios.bridge.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.bridge.a;
import com.baidu.helios.channels.a;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b avl;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0137a {
        private Map<String, C0138a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C0138a {
            boolean b;
            long c;

            C0138a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0137a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fx = trustSubject.fx("config-cs");
                if (TextUtils.isEmpty(fx) || (optJSONObject = new JSONObject(fx).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0138a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0138a fr(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class b {
        volatile com.baidu.helios.ids.b avp;
        volatile com.baidu.helios.channels.b avq;
        volatile TrustSubjectManager avr;
        volatile TrustSubjectManager.d avs;
        volatile Future<Boolean> avt;
        volatile com.baidu.helios.common.c.a avu;
        volatile g avv;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes18.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> avn;

        public c(a.c<T> cVar) {
            this.avn = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.avn.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.avn.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class d {
        private Map<String, C0139a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C0139a {
            boolean a;

            C0139a(boolean z) {
                this.a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fx = trustSubject.fx("config-ids");
                if (TextUtils.isEmpty(fx) || (optJSONObject = new JSONObject(fx).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0139a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0139a fs(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class e {
        private a.C0148a avw;
        private FileLock avx;
        private FileOutputStream b;

        public e(a.C0148a c0148a) {
            this.avw = c0148a;
        }

        public boolean a() {
            this.avw.Ai();
            try {
                this.b = new FileOutputStream(this.avw.getFile("lock"));
                this.avx = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.avx != null) {
                try {
                    this.avx.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avx = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avx = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avx = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class f {
        public String a;
        public String b;
        public long c;

        public f(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class g {
        private List<f> d = new ArrayList();

        g() {
        }

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (f fVar : this.d) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.a);
                    jSONObject.put("aid", fVar.b);
                    jSONObject.put("priority", fVar.c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e) {
            }
            return jSONArray.toString();
        }

        public void a(String str, String str2, long j) {
            this.d.add(new f(str, str2, j));
        }
    }

    private void a() {
        try {
            this.avl.avt.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        d dVar;
        com.baidu.helios.common.c.a aVar = new com.baidu.helios.common.c.a(this.c);
        bVar.avu = aVar;
        e eVar = new e(aVar.Ah().fv(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.avP = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.avr = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.avs = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.ave.avg);
            bVar.avp = bVar2;
            a.C0149a c0149a = new a.C0149a();
            c0149a.applicationContext = this.c;
            c0149a.avP = aVar;
            c0149a.axe = bVar.avs;
            c0149a.avi = this.ave.avi;
            c0149a.avj = this.ave.avj;
            a.b bVar3 = new a.b();
            bVar3.axf = false;
            List<com.baidu.helios.ids.a> Ao = bVar2.Ao();
            ArrayList<com.baidu.helios.ids.a> arrayList = Ao == null ? new ArrayList() : new ArrayList(Ao);
            if (bVar.avs.ayc != null) {
                d dVar2 = new d();
                dVar2.a(bVar.avs.ayc);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0139a fs = dVar.fs(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fs != null && !fs.a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0149a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.ave.avh);
            bVar.avq = bVar4;
            a.C0143a c0143a = new a.C0143a();
            c0143a.applicationContext = this.c;
            c0143a.avQ = bVar2;
            c0143a.avP = aVar;
            List<com.baidu.helios.channels.a> zP = bVar4.zP();
            ArrayList arrayList2 = zP == null ? new ArrayList() : new ArrayList(zP);
            if (arrayList2.size() > 0 && bVar.avs.ayc != null) {
                C0137a c0137a = new C0137a();
                c0137a.a(bVar.avs.ayc);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0137a.C0138a fr = c0137a.fr(next.getName());
                    if (fr != null) {
                        if (!fr.b) {
                            it2.remove();
                        } else if (fr.c > -1) {
                            next.setPriority(fr.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.avO);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0143a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0139a fs2 = dVar != null ? dVar.fs("sids") : null;
            if (fs2 == null || fs2.a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.avs.ayb;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.avv = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a = it.next().a(trustSubject.packageName, fVar);
                    if (a != null && a.isSuccess()) {
                        bVar.avv.a(trustSubject.packageName, a.id, trustSubject.At());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.avl.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.ave.avi.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.avl.avv == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.avl.avv.a(), null);
                }
            });
        } else {
            this.ave.avi.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.ave.applicationContext;
        this.avl = new b();
        this.avl.avt = this.ave.avi.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.avl);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.avl.i.get(str);
        return aVar != null ? a.d.fq(aVar.Am()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fp(String str) {
        a();
        List<TrustSubject> list = this.avl.avs.ayb;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.packageName.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
