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
/* loaded from: classes6.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b aoZ;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0130a {
        private Map<String, C0131a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
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
                String ed = trustSubject.ed("config-cs");
                if (TextUtils.isEmpty(ed) || (optJSONObject = new JSONObject(ed).optJSONObject(IXAdRequestInfo.CS)) == null) {
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

        C0131a dX(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b {
        volatile com.baidu.helios.ids.b apd;
        volatile com.baidu.helios.channels.b ape;
        volatile TrustSubjectManager apf;
        volatile TrustSubjectManager.d apg;
        volatile Future<Boolean> aph;
        volatile com.baidu.helios.common.c.a api;
        volatile g apj;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes6.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> apb;

        public c(a.c<T> cVar) {
            this.apb = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.apb.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.apb.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d {
        private Map<String, C0132a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
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
                String ed = trustSubject.ed("config-ids");
                if (TextUtils.isEmpty(ed) || (optJSONObject = new JSONObject(ed).optJSONObject("ids")) == null) {
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

        C0132a dY(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        private a.C0141a apk;
        private FileLock apl;
        private FileOutputStream b;

        public e(a.C0141a c0141a) {
            this.apk = c0141a;
        }

        public boolean a() {
            this.apk.ut();
            try {
                this.b = new FileOutputStream(this.apk.getFile("lock"));
                this.apl = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.apl != null) {
                try {
                    this.apl.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.apl = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.apl = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.apl = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
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
            this.aoZ.aph.get();
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
        bVar.api = aVar;
        e eVar = new e(aVar.us().eb(com.baidu.sapi2.outsdk.c.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.apE = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.apf = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.apg = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.aoS.aoU);
            bVar.apd = bVar2;
            a.C0142a c0142a = new a.C0142a();
            c0142a.applicationContext = this.c;
            c0142a.apE = aVar;
            c0142a.aqT = bVar.apg;
            c0142a.aoW = this.aoS.aoW;
            c0142a.aoX = this.aoS.aoX;
            a.b bVar3 = new a.b();
            bVar3.aqU = false;
            List<com.baidu.helios.ids.a> uz = bVar2.uz();
            ArrayList<com.baidu.helios.ids.a> arrayList = uz == null ? new ArrayList() : new ArrayList(uz);
            if (bVar.apg.arR != null) {
                d dVar2 = new d();
                dVar2.a(bVar.apg.arR);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0132a dY = dVar.dY(((com.baidu.helios.ids.a) it.next()).getName());
                    if (dY != null && !dY.a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0142a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.aoS.aoV);
            bVar.ape = bVar4;
            a.C0136a c0136a = new a.C0136a();
            c0136a.applicationContext = this.c;
            c0136a.apF = bVar2;
            c0136a.apE = aVar;
            List<com.baidu.helios.channels.a> ua = bVar4.ua();
            ArrayList arrayList2 = ua == null ? new ArrayList() : new ArrayList(ua);
            if (arrayList2.size() > 0 && bVar.apg.arR != null) {
                C0130a c0130a = new C0130a();
                c0130a.a(bVar.apg.arR);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0130a.C0131a dX = c0130a.dX(next.getName());
                    if (dX != null) {
                        if (!dX.b) {
                            it2.remove();
                        } else if (dX.c > -1) {
                            next.setPriority(dX.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.apD);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0136a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0132a dY2 = dVar != null ? dVar.dY("sids") : null;
            if (dY2 == null || dY2.a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.apg.arQ;
        a.f fVar = new a.f();
        fVar.apG = true;
        bVar.apj = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a = it.next().a(trustSubject.packageName, fVar);
                    if (a != null && a.isSuccess()) {
                        bVar.apj.a(trustSubject.packageName, a.id, trustSubject.uE());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.aoZ.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.aoS.aoW.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aoZ.apj == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.aoZ.apj.a(), null);
                }
            });
        } else {
            this.aoS.aoW.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.aoS.applicationContext;
        this.aoZ = new b();
        this.aoZ.aph = this.aoS.aoW.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.aoZ);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.aoZ.i.get(str);
        return aVar != null ? a.d.dW(aVar.ux()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dV(String str) {
        a();
        List<TrustSubject> list = this.aoZ.apg.arQ;
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
