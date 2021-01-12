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
/* loaded from: classes6.dex */
public class a extends com.baidu.helios.bridge.a {
    private volatile b arx;
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.bridge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0122a {
        private Map<String, C0123a> e = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0123a {

            /* renamed from: b  reason: collision with root package name */
            boolean f2401b;
            long c;

            C0123a(boolean z, long j) {
                this.f2401b = z;
                this.c = j;
            }
        }

        C0122a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ec = trustSubject.ec("config-cs");
                if (TextUtils.isEmpty(ec) || (optJSONObject = new JSONObject(ec).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.e.put(next, new C0123a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception e) {
            }
        }

        C0123a dW(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b {
        volatile com.baidu.helios.ids.b arB;
        volatile com.baidu.helios.channels.b arC;
        volatile TrustSubjectManager arD;
        volatile TrustSubjectManager.d arE;
        volatile Future<Boolean> arF;
        volatile com.baidu.helios.common.c.a arG;
        volatile g arH;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes6.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> arz;

        public c(a.c<T> cVar) {
            this.arz = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.arz.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.arz.a(t, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d {
        private Map<String, C0124a> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.helios.bridge.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0124a {

            /* renamed from: a  reason: collision with root package name */
            boolean f2402a;

            C0124a(boolean z) {
                this.f2402a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String ec = trustSubject.ec("config-ids");
                if (TextUtils.isEmpty(ec) || (optJSONObject = new JSONObject(ec).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.d.put(next, new C0124a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception e) {
            }
        }

        C0124a dX(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        private a.C0133a arI;
        private FileLock arJ;

        /* renamed from: b  reason: collision with root package name */
        private FileOutputStream f2403b;

        public e(a.C0133a c0133a) {
            this.arI = c0133a;
        }

        public boolean a() {
            this.arI.vl();
            try {
                this.f2403b = new FileOutputStream(this.arI.getFile("lock"));
                this.arJ = this.f2403b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.arJ != null) {
                try {
                    this.arJ.release();
                    if (this.f2403b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2403b);
                        this.f2403b = null;
                    }
                    this.arJ = null;
                    return true;
                } catch (IOException e) {
                    if (this.f2403b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2403b);
                        this.f2403b = null;
                    }
                    this.arJ = null;
                } catch (Throwable th) {
                    if (this.f2403b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2403b);
                        this.f2403b = null;
                    }
                    this.arJ = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f2404a;

        /* renamed from: b  reason: collision with root package name */
        public String f2405b;
        public long c;

        public f(String str, String str2, long j) {
            this.f2404a = str;
            this.f2405b = str2;
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
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f2404a);
                    jSONObject.put("aid", fVar.f2405b);
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
            this.arx.arF.get();
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
        bVar.arG = aVar;
        e eVar = new e(aVar.vk().ea(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.arZ = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.arD = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.arE = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.arq.ars);
            bVar.arB = bVar2;
            a.C0134a c0134a = new a.C0134a();
            c0134a.applicationContext = this.c;
            c0134a.arZ = aVar;
            c0134a.atm = bVar.arE;
            c0134a.aru = this.arq.aru;
            c0134a.arv = this.arq.arv;
            a.b bVar3 = new a.b();
            bVar3.atn = false;
            List<com.baidu.helios.ids.a> vr = bVar2.vr();
            ArrayList<com.baidu.helios.ids.a> arrayList = vr == null ? new ArrayList() : new ArrayList(vr);
            if (bVar.arE.aui != null) {
                d dVar2 = new d();
                dVar2.a(bVar.arE.aui);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0124a dX = dVar.dX(((com.baidu.helios.ids.a) it.next()).getName());
                    if (dX != null && !dX.f2402a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0134a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.arq.art);
            bVar.arC = bVar4;
            a.C0128a c0128a = new a.C0128a();
            c0128a.applicationContext = this.c;
            c0128a.asa = bVar2;
            c0128a.arZ = aVar;
            List<com.baidu.helios.channels.a> uQ = bVar4.uQ();
            ArrayList arrayList2 = uQ == null ? new ArrayList() : new ArrayList(uQ);
            if (arrayList2.size() > 0 && bVar.arE.aui != null) {
                C0122a c0122a = new C0122a();
                c0122a.a(bVar.arE.aui);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0122a.C0123a dW = c0122a.dW(next.getName());
                    if (dW != null) {
                        if (!dW.f2401b) {
                            it2.remove();
                        } else if (dW.c > -1) {
                            next.setPriority(dW.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.arY);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0128a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0124a dX2 = dVar != null ? dVar.dX("sids") : null;
            if (dX2 == null || dX2.f2402a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.arE.auh;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.arH = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.arH.a(trustSubject.packageName, a2.id, trustSubject.vw());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.arx.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.arq.aru.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.arx.arH == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.arx.arH.a(), null);
                }
            });
        } else {
            this.arq.aru.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.arq.applicationContext;
        this.arx = new b();
        this.arx.arF = this.arq.aru.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.arx);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.arx.i.get(str);
        return aVar != null ? a.d.dV(aVar.vp()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dU(String str) {
        a();
        List<TrustSubject> list = this.arx.arE.auh;
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
