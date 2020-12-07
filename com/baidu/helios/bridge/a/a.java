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
    private volatile b avM;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0138a {
        private Map<String, C0139a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
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
                String fD = trustSubject.fD("config-cs");
                if (TextUtils.isEmpty(fD) || (optJSONObject = new JSONObject(fD).optJSONObject(IXAdRequestInfo.CS)) == null) {
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

        C0139a fx(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class b {
        volatile com.baidu.helios.ids.b avQ;
        volatile com.baidu.helios.channels.b avR;
        volatile TrustSubjectManager avS;
        volatile TrustSubjectManager.d avT;
        volatile Future<Boolean> avU;
        volatile com.baidu.helios.common.c.a avV;
        volatile g avW;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes18.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> avO;

        public c(a.c<T> cVar) {
            this.avO = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.avO.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.avO.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class d {
        private Map<String, C0140a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C0140a {

            /* renamed from: a  reason: collision with root package name */
            boolean f1789a;

            C0140a(boolean z) {
                this.f1789a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fD = trustSubject.fD("config-ids");
                if (TextUtils.isEmpty(fD) || (optJSONObject = new JSONObject(fD).optJSONObject("ids")) == null) {
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

        C0140a fy(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class e {
        private a.C0149a avX;
        private FileLock avY;
        private FileOutputStream b;

        public e(a.C0149a c0149a) {
            this.avX = c0149a;
        }

        public boolean a() {
            this.avX.zP();
            try {
                this.b = new FileOutputStream(this.avX.getFile("lock"));
                this.avY = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.avY != null) {
                try {
                    this.avY.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avY = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avY = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.avY = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f1790a;
        public String b;
        public long c;

        public f(String str, String str2, long j) {
            this.f1790a = str;
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
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f1790a);
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
            this.avM.avU.get();
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
        bVar.avV = aVar;
        e eVar = new e(aVar.zO().fB(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.awq = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.avS = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.avT = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.avF.avH);
            bVar.avQ = bVar2;
            a.C0150a c0150a = new a.C0150a();
            c0150a.applicationContext = this.c;
            c0150a.awq = aVar;
            c0150a.axF = bVar.avT;
            c0150a.avJ = this.avF.avJ;
            c0150a.avK = this.avF.avK;
            a.b bVar3 = new a.b();
            bVar3.axG = false;
            List<com.baidu.helios.ids.a> zV = bVar2.zV();
            ArrayList<com.baidu.helios.ids.a> arrayList = zV == null ? new ArrayList() : new ArrayList(zV);
            if (bVar.avT.ayD != null) {
                d dVar2 = new d();
                dVar2.a(bVar.avT.ayD);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0140a fy = dVar.fy(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fy != null && !fy.f1789a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0150a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.avF.avI);
            bVar.avR = bVar4;
            a.C0144a c0144a = new a.C0144a();
            c0144a.applicationContext = this.c;
            c0144a.awr = bVar2;
            c0144a.awq = aVar;
            List<com.baidu.helios.channels.a> zu = bVar4.zu();
            ArrayList arrayList2 = zu == null ? new ArrayList() : new ArrayList(zu);
            if (arrayList2.size() > 0 && bVar.avT.ayD != null) {
                C0138a c0138a = new C0138a();
                c0138a.a(bVar.avT.ayD);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0138a.C0139a fx = c0138a.fx(next.getName());
                    if (fx != null) {
                        if (!fx.b) {
                            it2.remove();
                        } else if (fx.c > -1) {
                            next.setPriority(fx.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.awp);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0144a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0140a fy2 = dVar != null ? dVar.fy("sids") : null;
            if (fy2 == null || fy2.f1789a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.avT.ayC;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.avW = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.avW.a(trustSubject.packageName, a2.id, trustSubject.Aa());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.avM.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.avF.avJ.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.avM.avW == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.avM.avW.a(), null);
                }
            });
        } else {
            this.avF.avJ.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.avF.applicationContext;
        this.avM = new b();
        this.avM.avU = this.avF.avJ.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.avM);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.avM.i.get(str);
        return aVar != null ? a.d.fw(aVar.zT()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fv(String str) {
        a();
        List<TrustSubject> list = this.avM.avT.ayC;
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
