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
/* loaded from: classes5.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b asN;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0128a {
        private Map<String, C0129a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0129a {
            boolean b;
            long c;

            C0129a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0128a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ei = trustSubject.ei("config-cs");
                if (TextUtils.isEmpty(ei) || (optJSONObject = new JSONObject(ei).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0129a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0129a ec(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {
        volatile com.baidu.helios.ids.b asR;
        volatile com.baidu.helios.channels.b asS;
        volatile TrustSubjectManager asT;
        volatile TrustSubjectManager.d asU;
        volatile Future<Boolean> asV;
        volatile com.baidu.helios.common.c.a asW;
        volatile g asX;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes5.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> asP;

        public c(a.c<T> cVar) {
            this.asP = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.asP.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.asP.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class d {
        private Map<String, C0130a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0130a {

            /* renamed from: a  reason: collision with root package name */
            boolean f1827a;

            C0130a(boolean z) {
                this.f1827a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ei = trustSubject.ei("config-ids");
                if (TextUtils.isEmpty(ei) || (optJSONObject = new JSONObject(ei).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0130a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0130a ed(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        private a.C0139a asY;
        private FileLock asZ;
        private FileOutputStream b;

        public e(a.C0139a c0139a) {
            this.asY = c0139a;
        }

        public boolean a() {
            this.asY.vl();
            try {
                this.b = new FileOutputStream(this.asY.getFile("lock"));
                this.asZ = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.asZ != null) {
                try {
                    this.asZ.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.asZ = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.asZ = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.asZ = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f1828a;
        public String b;
        public long c;

        public f(String str, String str2, long j) {
            this.f1828a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class g {
        private List<f> d = new ArrayList();

        g() {
        }

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (f fVar : this.d) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f1828a);
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
            this.asN.asV.get();
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
        bVar.asW = aVar;
        e eVar = new e(aVar.vk().eg(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.atq = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.asT = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.asU = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.asG.asI);
            bVar.asR = bVar2;
            a.C0140a c0140a = new a.C0140a();
            c0140a.applicationContext = this.c;
            c0140a.atq = aVar;
            c0140a.auC = bVar.asU;
            c0140a.asK = this.asG.asK;
            c0140a.asL = this.asG.asL;
            a.b bVar3 = new a.b();
            bVar3.auD = false;
            List<com.baidu.helios.ids.a> vr = bVar2.vr();
            ArrayList<com.baidu.helios.ids.a> arrayList = vr == null ? new ArrayList() : new ArrayList(vr);
            if (bVar.asU.avx != null) {
                d dVar2 = new d();
                dVar2.a(bVar.asU.avx);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0130a ed = dVar.ed(((com.baidu.helios.ids.a) it.next()).getName());
                    if (ed != null && !ed.f1827a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0140a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.asG.asJ);
            bVar.asS = bVar4;
            a.C0134a c0134a = new a.C0134a();
            c0134a.applicationContext = this.c;
            c0134a.atr = bVar2;
            c0134a.atq = aVar;
            List<com.baidu.helios.channels.a> uQ = bVar4.uQ();
            ArrayList arrayList2 = uQ == null ? new ArrayList() : new ArrayList(uQ);
            if (arrayList2.size() > 0 && bVar.asU.avx != null) {
                C0128a c0128a = new C0128a();
                c0128a.a(bVar.asU.avx);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0128a.C0129a ec = c0128a.ec(next.getName());
                    if (ec != null) {
                        if (!ec.b) {
                            it2.remove();
                        } else if (ec.c > -1) {
                            next.setPriority(ec.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.atp);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0134a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0130a ed2 = dVar != null ? dVar.ed("sids") : null;
            if (ed2 == null || ed2.f1827a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.asU.avw;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.asX = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.asX.a(trustSubject.packageName, a2.id, trustSubject.vw());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.asN.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.asG.asK.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.asN.asX == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.asN.asX.a(), null);
                }
            });
        } else {
            this.asG.asK.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.asG.applicationContext;
        this.asN = new b();
        this.asN.asV = this.asG.asK.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.asN);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.asN.i.get(str);
        return aVar != null ? a.d.eb(aVar.vp()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean ea(String str) {
        a();
        List<TrustSubject> list = this.asN.asU.avw;
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
