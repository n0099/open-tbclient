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
    private volatile b awz;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0142a {
        private Map<String, C0143a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C0143a {
            boolean b;
            long c;

            C0143a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0142a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fF = trustSubject.fF("config-cs");
                if (TextUtils.isEmpty(fF) || (optJSONObject = new JSONObject(fF).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0143a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0143a fz(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class b {
        volatile com.baidu.helios.ids.b awD;
        volatile com.baidu.helios.channels.b awE;
        volatile TrustSubjectManager awF;
        volatile TrustSubjectManager.d awG;
        volatile Future<Boolean> awH;
        volatile com.baidu.helios.common.c.a awI;
        volatile g awJ;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes18.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> awB;

        public c(a.c<T> cVar) {
            this.awB = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.awB.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.awB.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class d {
        private Map<String, C0144a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C0144a {

            /* renamed from: a  reason: collision with root package name */
            boolean f1785a;

            C0144a(boolean z) {
                this.f1785a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fF = trustSubject.fF("config-ids");
                if (TextUtils.isEmpty(fF) || (optJSONObject = new JSONObject(fF).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0144a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0144a fA(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class e {
        private a.C0153a awK;
        private FileLock awL;
        private FileOutputStream b;

        public e(a.C0153a c0153a) {
            this.awK = c0153a;
        }

        public boolean a() {
            this.awK.AE();
            try {
                this.b = new FileOutputStream(this.awK.getFile("lock"));
                this.awL = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.awL != null) {
                try {
                    this.awL.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awL = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awL = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.awL = null;
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
        public String f1786a;
        public String b;
        public long c;

        public f(String str, String str2, long j) {
            this.f1786a = str;
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
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f1786a);
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
            this.awz.awH.get();
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
        bVar.awI = aVar;
        e eVar = new e(aVar.AD().fD(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.axd = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.awF = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.awG = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.aws.awu);
            bVar.awD = bVar2;
            a.C0154a c0154a = new a.C0154a();
            c0154a.applicationContext = this.c;
            c0154a.axd = aVar;
            c0154a.ays = bVar.awG;
            c0154a.aww = this.aws.aww;
            c0154a.awx = this.aws.awx;
            a.b bVar3 = new a.b();
            bVar3.ayt = false;
            List<com.baidu.helios.ids.a> AK = bVar2.AK();
            ArrayList<com.baidu.helios.ids.a> arrayList = AK == null ? new ArrayList() : new ArrayList(AK);
            if (bVar.awG.azq != null) {
                d dVar2 = new d();
                dVar2.a(bVar.awG.azq);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0144a fA = dVar.fA(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fA != null && !fA.f1785a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0154a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.aws.awv);
            bVar.awE = bVar4;
            a.C0148a c0148a = new a.C0148a();
            c0148a.applicationContext = this.c;
            c0148a.axe = bVar2;
            c0148a.axd = aVar;
            List<com.baidu.helios.channels.a> Al = bVar4.Al();
            ArrayList arrayList2 = Al == null ? new ArrayList() : new ArrayList(Al);
            if (arrayList2.size() > 0 && bVar.awG.azq != null) {
                C0142a c0142a = new C0142a();
                c0142a.a(bVar.awG.azq);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0142a.C0143a fz = c0142a.fz(next.getName());
                    if (fz != null) {
                        if (!fz.b) {
                            it2.remove();
                        } else if (fz.c > -1) {
                            next.setPriority(fz.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.axc);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0148a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0144a fA2 = dVar != null ? dVar.fA("sids") : null;
            if (fA2 == null || fA2.f1785a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.awG.azp;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.awJ = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.awJ.a(trustSubject.packageName, a2.id, trustSubject.AP());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.awz.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.aws.aww.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.awz.awJ == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.awz.awJ.a(), null);
                }
            });
        } else {
            this.aws.aww.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.aws.applicationContext;
        this.awz = new b();
        this.awz.awH = this.aws.aww.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.awz);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.awz.i.get(str);
        return aVar != null ? a.d.fy(aVar.AI()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fx(String str) {
        a();
        List<TrustSubject> list = this.awz.awG.azp;
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
