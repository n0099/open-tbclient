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
/* loaded from: classes17.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b auO;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0140a {
        private Map<String, C0141a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C0141a {
            boolean b;
            long c;

            C0141a(boolean z, long j) {
                this.b = z;
                this.c = j;
            }
        }

        C0140a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fz = trustSubject.fz("config-cs");
                if (TextUtils.isEmpty(fz) || (optJSONObject = new JSONObject(fz).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0141a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0141a ft(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class b {
        volatile com.baidu.helios.ids.b auS;
        volatile com.baidu.helios.channels.b auT;
        volatile TrustSubjectManager auU;
        volatile TrustSubjectManager.d auV;
        volatile Future<Boolean> auW;
        volatile com.baidu.helios.common.c.a auX;
        volatile g auY;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes17.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> auQ;

        public c(a.c<T> cVar) {
            this.auQ = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.auQ.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.auQ.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class d {
        private Map<String, C0142a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C0142a {

            /* renamed from: a  reason: collision with root package name */
            boolean f1787a;

            C0142a(boolean z) {
                this.f1787a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fz = trustSubject.fz("config-ids");
                if (TextUtils.isEmpty(fz) || (optJSONObject = new JSONObject(fz).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0142a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0142a fu(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class e {
        private a.C0151a auZ;
        private FileLock ava;
        private FileOutputStream b;

        public e(a.C0151a c0151a) {
            this.auZ = c0151a;
        }

        public boolean a() {
            this.auZ.zV();
            try {
                this.b = new FileOutputStream(this.auZ.getFile("lock"));
                this.ava = this.b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.ava != null) {
                try {
                    this.ava.release();
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.ava = null;
                    return true;
                } catch (IOException e) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.ava = null;
                } catch (Throwable th) {
                    if (this.b != null) {
                        com.baidu.helios.common.b.a.c.b(this.b);
                        this.b = null;
                    }
                    this.ava = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f1788a;
        public String b;
        public long c;

        public f(String str, String str2, long j) {
            this.f1788a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class g {
        private List<f> d = new ArrayList();

        g() {
        }

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (f fVar : this.d) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f1788a);
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
            this.auO.auW.get();
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
        bVar.auX = aVar;
        e eVar = new e(aVar.zU().fx(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.avs = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.auU = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.auV = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.auH.auJ);
            bVar.auS = bVar2;
            a.C0152a c0152a = new a.C0152a();
            c0152a.applicationContext = this.c;
            c0152a.avs = aVar;
            c0152a.awH = bVar.auV;
            c0152a.auL = this.auH.auL;
            c0152a.auM = this.auH.auM;
            a.b bVar3 = new a.b();
            bVar3.awI = false;
            List<com.baidu.helios.ids.a> Ab = bVar2.Ab();
            ArrayList<com.baidu.helios.ids.a> arrayList = Ab == null ? new ArrayList() : new ArrayList(Ab);
            if (bVar.auV.axF != null) {
                d dVar2 = new d();
                dVar2.a(bVar.auV.axF);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0142a fu = dVar.fu(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fu != null && !fu.f1787a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0152a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.auH.auK);
            bVar.auT = bVar4;
            a.C0146a c0146a = new a.C0146a();
            c0146a.applicationContext = this.c;
            c0146a.avt = bVar2;
            c0146a.avs = aVar;
            List<com.baidu.helios.channels.a> zC = bVar4.zC();
            ArrayList arrayList2 = zC == null ? new ArrayList() : new ArrayList(zC);
            if (arrayList2.size() > 0 && bVar.auV.axF != null) {
                C0140a c0140a = new C0140a();
                c0140a.a(bVar.auV.axF);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0140a.C0141a ft = c0140a.ft(next.getName());
                    if (ft != null) {
                        if (!ft.b) {
                            it2.remove();
                        } else if (ft.c > -1) {
                            next.setPriority(ft.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.avr);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0146a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0142a fu2 = dVar != null ? dVar.fu("sids") : null;
            if (fu2 == null || fu2.f1787a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.auV.axE;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.auY = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.auY.a(trustSubject.packageName, a2.id, trustSubject.Ag());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.auO.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.auH.auL.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.auO.auY == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.auO.auY.a(), null);
                }
            });
        } else {
            this.auH.auL.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.auH.applicationContext;
        this.auO = new b();
        this.auO.auW = this.auH.auL.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.auO);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.auO.i.get(str);
        return aVar != null ? a.d.fs(aVar.zZ()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fr(String str) {
        a();
        List<TrustSubject> list = this.auO.auV.axE;
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
