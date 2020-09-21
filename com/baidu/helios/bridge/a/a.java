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
/* loaded from: classes15.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b avP;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0138a {
        private Map<String, C0139a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C0139a {
            boolean b;
            long c;

            C0139a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0138a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fA = trustSubject.fA("config-cs");
                if (TextUtils.isEmpty(fA) || (optJSONObject = new JSONObject(fA).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0139a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0139a fu(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class b {
        volatile com.baidu.helios.ids.b avT;
        volatile com.baidu.helios.channels.b avU;
        volatile TrustSubjectManager avV;
        volatile TrustSubjectManager.d avW;
        volatile Future<Boolean> avX;
        volatile com.baidu.helios.common.c.a avY;
        volatile g avZ;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes15.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> avR;

        public c(a.c<T> cVar) {
            this.avR = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.avR.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.avR.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class d {
        private Map<String, C0140a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C0140a {
            boolean a;

            C0140a(boolean z) {
                this.a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fA = trustSubject.fA("config-ids");
                if (TextUtils.isEmpty(fA) || (optJSONObject = new JSONObject(fA).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0140a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0140a fv(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class e {
        private a.C0149a awa;
        private FileLock awb;
        private FileOutputStream b;

        public e(a.C0149a c0149a) {
            this.awa = c0149a;
        }

        public boolean a() {
            this.awa.Aw();
            try {
                this.b = new FileOutputStream(this.awa.getFile("lock"));
                this.awb = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.awb != null) {
                try {
                    this.awb.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awb = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awb = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awb = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
    /* loaded from: classes15.dex */
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
            this.avP.avX.get();
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
        bVar.avY = aVar;
        e eVar = new e(aVar.Av().fy(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.awt = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.avV = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.avW = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.avI.avK);
            bVar.avT = bVar2;
            a.C0150a c0150a = new a.C0150a();
            c0150a.applicationContext = this.c;
            c0150a.awt = aVar;
            c0150a.axI = bVar.avW;
            c0150a.avM = this.avI.avM;
            c0150a.avN = this.avI.avN;
            a.b bVar3 = new a.b();
            bVar3.axJ = false;
            List<com.baidu.helios.ids.a> AC = bVar2.AC();
            ArrayList<com.baidu.helios.ids.a> arrayList = AC == null ? new ArrayList() : new ArrayList(AC);
            if (bVar.avW.ayG != null) {
                d dVar2 = new d();
                dVar2.a(bVar.avW.ayG);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0140a fv = dVar.fv(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fv != null && !fv.a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0150a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.avI.avL);
            bVar.avU = bVar4;
            a.C0144a c0144a = new a.C0144a();
            c0144a.applicationContext = this.c;
            c0144a.awu = bVar2;
            c0144a.awt = aVar;
            List<com.baidu.helios.channels.a> Ad = bVar4.Ad();
            ArrayList arrayList2 = Ad == null ? new ArrayList() : new ArrayList(Ad);
            if (arrayList2.size() > 0 && bVar.avW.ayG != null) {
                C0138a c0138a = new C0138a();
                c0138a.a(bVar.avW.ayG);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0138a.C0139a fu = c0138a.fu(next.getName());
                    if (fu != null) {
                        if (!fu.b) {
                            it2.remove();
                        } else if (fu.c > -1) {
                            next.setPriority(fu.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.aws);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0144a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0140a fv2 = dVar != null ? dVar.fv("sids") : null;
            if (fv2 == null || fv2.a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.avW.ayF;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.avZ = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a = it.next().a(trustSubject.packageName, fVar);
                    if (a != null && a.isSuccess()) {
                        bVar.avZ.a(trustSubject.packageName, a.id, trustSubject.AH());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.avP.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.avI.avM.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.avP.avZ == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.avP.avZ.a(), null);
                }
            });
        } else {
            this.avI.avM.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.avI.applicationContext;
        this.avP = new b();
        this.avP.avX = this.avI.avM.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.avP);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.avP.i.get(str);
        return aVar != null ? a.d.ft(aVar.AA()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fs(String str) {
        a();
        List<TrustSubject> list = this.avP.avW.ayF;
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
