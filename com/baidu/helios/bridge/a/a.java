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
/* loaded from: classes8.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b aqo;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0130a {
        private Map<String, C0131a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0131a {
            boolean b;
            long c;

            C0131a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0130a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ee = trustSubject.ee("config-cs");
                if (TextUtils.isEmpty(ee) || (optJSONObject = new JSONObject(ee).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0131a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0131a dY(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b {
        volatile com.baidu.helios.ids.b aqs;
        volatile com.baidu.helios.channels.b aqt;
        volatile TrustSubjectManager aqu;
        volatile TrustSubjectManager.d aqv;
        volatile Future<Boolean> aqw;
        volatile com.baidu.helios.common.c.a aqx;
        volatile g aqy;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes8.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> aqq;

        public c(a.c<T> cVar) {
            this.aqq = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.aqq.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.aqq.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class d {
        private Map<String, C0132a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0132a {
            boolean a;

            C0132a(boolean z) {
                this.a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ee = trustSubject.ee("config-ids");
                if (TextUtils.isEmpty(ee) || (optJSONObject = new JSONObject(ee).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0132a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0132a dZ(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class e {
        private FileLock aqA;
        private a.C0141a aqz;
        private FileOutputStream b;

        public e(a.C0141a c0141a) {
            this.aqz = c0141a;
        }

        public boolean a() {
            this.aqz.uL();
            try {
                this.b = new FileOutputStream(this.aqz.getFile("lock"));
                this.aqA = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.aqA != null) {
                try {
                    this.aqA.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.aqA = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.aqA = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.aqA = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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
            this.aqo.aqw.get();
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
        bVar.aqx = aVar;
        e eVar = new e(aVar.uK().ec(com.baidu.sapi2.outsdk.c.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.aqS = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.aqu = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.aqv = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.aqh.aqj);
            bVar.aqs = bVar2;
            a.C0142a c0142a = new a.C0142a();
            c0142a.applicationContext = this.c;
            c0142a.aqS = aVar;
            c0142a.ash = bVar.aqv;
            c0142a.aql = this.aqh.aql;
            c0142a.aqm = this.aqh.aqm;
            a.b bVar3 = new a.b();
            bVar3.asi = false;
            List<com.baidu.helios.ids.a> uR = bVar2.uR();
            ArrayList<com.baidu.helios.ids.a> arrayList = uR == null ? new ArrayList() : new ArrayList(uR);
            if (bVar.aqv.atg != null) {
                d dVar2 = new d();
                dVar2.a(bVar.aqv.atg);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0132a dZ = dVar.dZ(((com.baidu.helios.ids.a) it.next()).getName());
                    if (dZ != null && !dZ.a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0142a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.aqh.aqk);
            bVar.aqt = bVar4;
            a.C0136a c0136a = new a.C0136a();
            c0136a.applicationContext = this.c;
            c0136a.aqT = bVar2;
            c0136a.aqS = aVar;
            List<com.baidu.helios.channels.a> us = bVar4.us();
            ArrayList arrayList2 = us == null ? new ArrayList() : new ArrayList(us);
            if (arrayList2.size() > 0 && bVar.aqv.atg != null) {
                C0130a c0130a = new C0130a();
                c0130a.a(bVar.aqv.atg);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0130a.C0131a dY = c0130a.dY(next.getName());
                    if (dY != null) {
                        if (!dY.b) {
                            it2.remove();
                        } else if (dY.c > -1) {
                            next.setPriority(dY.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.aqR);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0136a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0132a dZ2 = dVar != null ? dVar.dZ("sids") : null;
            if (dZ2 == null || dZ2.a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.aqv.atf;
        a.f fVar = new a.f();
        fVar.aqU = true;
        bVar.aqy = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a = it.next().a(trustSubject.packageName, fVar);
                    if (a != null && a.isSuccess()) {
                        bVar.aqy.a(trustSubject.packageName, a.id, trustSubject.uW());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.aqo.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.aqh.aql.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aqo.aqy == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.aqo.aqy.a(), null);
                }
            });
        } else {
            this.aqh.aql.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.aqh.applicationContext;
        this.aqo = new b();
        this.aqo.aqw = this.aqh.aql.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.aqo);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.aqo.i.get(str);
        return aVar != null ? a.d.dX(aVar.uP()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dW(String str) {
        a();
        List<TrustSubject> list = this.aqo.aqv.atf;
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
