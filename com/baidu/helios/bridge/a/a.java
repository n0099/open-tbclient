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
    private volatile b awj;
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

            /* renamed from: b  reason: collision with root package name */
            boolean f2450b;
            long c;

            C0131a(boolean z, long j) {
                this.f2450b = z;
                this.c = j;
            }
        }

        C0130a() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fo = trustSubject.fo("config-cs");
                if (TextUtils.isEmpty(fo) || (optJSONObject = new JSONObject(fo).optJSONObject(IXAdRequestInfo.CS)) == null) {
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

        C0131a fi(String str) {
            return this.e.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b {
        volatile com.baidu.helios.ids.b awn;
        volatile com.baidu.helios.channels.b awo;
        volatile TrustSubjectManager awp;
        volatile TrustSubjectManager.d awq;
        volatile Future<Boolean> awr;
        volatile com.baidu.helios.common.c.a aws;
        volatile g awt;
        volatile Map<String, com.baidu.helios.channels.a> h = new HashMap();
        volatile Map<String, com.baidu.helios.ids.a> i = new HashMap();

        b() {
        }
    }

    /* loaded from: classes6.dex */
    static class c<T> implements a.c<T> {
        private a.c<T> awl;

        public c(a.c<T> cVar) {
            this.awl = cVar;
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(int i, Exception exc, Bundle bundle) {
            this.awl.a(i, exc, bundle);
        }

        @Override // com.baidu.helios.ids.a.c
        public void a(T t, Bundle bundle) {
            this.awl.a(t, bundle);
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

            /* renamed from: a  reason: collision with root package name */
            boolean f2451a;

            C0132a(boolean z) {
                this.f2451a = z;
            }
        }

        d() {
        }

        void a(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String fo = trustSubject.fo("config-ids");
                if (TextUtils.isEmpty(fo) || (optJSONObject = new JSONObject(fo).optJSONObject("ids")) == null) {
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

        C0132a fj(String str) {
            return this.d.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        private a.C0141a awu;
        private FileLock awv;

        /* renamed from: b  reason: collision with root package name */
        private FileOutputStream f2452b;

        public e(a.C0141a c0141a) {
            this.awu = c0141a;
        }

        public boolean a() {
            this.awu.zg();
            try {
                this.f2452b = new FileOutputStream(this.awu.getFile("lock"));
                this.awv = this.f2452b.getChannel().lock();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IGET, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            if (this.awv != null) {
                try {
                    this.awv.release();
                    if (this.f2452b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2452b);
                        this.f2452b = null;
                    }
                    this.awv = null;
                    return true;
                } catch (IOException e) {
                    if (this.f2452b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2452b);
                        this.f2452b = null;
                    }
                    this.awv = null;
                } catch (Throwable th) {
                    if (this.f2452b != null) {
                        com.baidu.helios.common.b.a.c.c(this.f2452b);
                        this.f2452b = null;
                    }
                    this.awv = null;
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
        public String f2453a;

        /* renamed from: b  reason: collision with root package name */
        public String f2454b;
        public long c;

        public f(String str, String str2, long j) {
            this.f2453a = str;
            this.f2454b = str2;
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
                    jSONObject.put(Config.INPUT_DEF_PKG, fVar.f2453a);
                    jSONObject.put("aid", fVar.f2454b);
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
            this.awj.awr.get();
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
        bVar.aws = aVar;
        e eVar = new e(aVar.zf().fm(OneKeyLoginSdkCall.l));
        try {
            eVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.applicationContext = this.c;
            aVar2.awL = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            bVar.awp = trustSubjectManager;
            trustSubjectManager.a(aVar2);
            trustSubjectManager.a(new TrustSubjectManager.b());
            bVar.awq = trustSubjectManager.a(new TrustSubjectManager.c());
            com.baidu.helios.ids.b bVar2 = new com.baidu.helios.ids.b(this.awc.awe);
            bVar.awn = bVar2;
            a.C0142a c0142a = new a.C0142a();
            c0142a.applicationContext = this.c;
            c0142a.awL = aVar;
            c0142a.axY = bVar.awq;
            c0142a.awg = this.awc.awg;
            c0142a.awh = this.awc.awh;
            a.b bVar3 = new a.b();
            bVar3.axZ = false;
            List<com.baidu.helios.ids.a> zm = bVar2.zm();
            ArrayList<com.baidu.helios.ids.a> arrayList = zm == null ? new ArrayList() : new ArrayList(zm);
            if (bVar.awq.ayU != null) {
                d dVar2 = new d();
                dVar2.a(bVar.awq.ayU);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (arrayList.size() > 0 && dVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.C0132a fj = dVar.fj(((com.baidu.helios.ids.a) it.next()).getName());
                    if (fj != null && !fj.f2451a) {
                        it.remove();
                    }
                }
            }
            for (com.baidu.helios.ids.a aVar3 : arrayList) {
                bVar.i.put(aVar3.getName(), aVar3);
                aVar3.a(c0142a);
                aVar3.a(bVar3);
            }
            com.baidu.helios.channels.b bVar4 = new com.baidu.helios.channels.b(this.awc.awf);
            bVar.awo = bVar4;
            a.C0136a c0136a = new a.C0136a();
            c0136a.applicationContext = this.c;
            c0136a.awM = bVar2;
            c0136a.awL = aVar;
            List<com.baidu.helios.channels.a> yL = bVar4.yL();
            ArrayList arrayList2 = yL == null ? new ArrayList() : new ArrayList(yL);
            if (arrayList2.size() > 0 && bVar.awq.ayU != null) {
                C0130a c0130a = new C0130a();
                c0130a.a(bVar.awq.ayU);
                Iterator<com.baidu.helios.channels.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.baidu.helios.channels.a next = it2.next();
                    C0130a.C0131a fi = c0130a.fi(next.getName());
                    if (fi != null) {
                        if (!fi.f2450b) {
                            it2.remove();
                        } else if (fi.c > -1) {
                            next.setPriority(fi.c);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, com.baidu.helios.channels.a.awK);
            a.c cVar = new a.c();
            a.d dVar3 = new a.d();
            for (com.baidu.helios.channels.a aVar4 : arrayList2) {
                bVar.h.put(aVar4.getName(), aVar4);
                aVar4.a(c0136a);
                aVar4.a(cVar);
                aVar4.a(dVar3);
            }
            d.C0132a fj2 = dVar != null ? dVar.fj("sids") : null;
            if (fj2 == null || fj2.f2451a) {
                a(bVar, arrayList2);
            }
        } finally {
            eVar.b();
        }
    }

    private void a(b bVar, List<com.baidu.helios.channels.a> list) {
        List<TrustSubject> list2 = bVar.awq.ayT;
        a.f fVar = new a.f();
        fVar.useCache = true;
        bVar.awt = new g();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<com.baidu.helios.channels.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.g a2 = it.next().a(trustSubject.packageName, fVar);
                    if (a2 != null && a2.isSuccess()) {
                        bVar.awt.a(trustSubject.packageName, a2.id, trustSubject.zr());
                        break;
                    }
                }
            }
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        a();
        com.baidu.helios.ids.a aVar = this.awj.i.get(str);
        if (aVar != null) {
            aVar.a(new c(cVar));
        } else if ("sids".equals(str)) {
            this.awc.awg.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.awj.awt == null) {
                        cVar.a(-1, null, null);
                        return;
                    }
                    cVar.a(a.this.awj.awt.a(), null);
                }
            });
        } else {
            this.awc.awg.submit(new Runnable() { // from class: com.baidu.helios.bridge.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(-1, null, null);
                }
            });
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.c = this.awc.applicationContext;
        this.awj = new b();
        this.awj.awr = this.awc.awg.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                a.this.a(a.this.awj);
                return true;
            }
        });
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        a();
        com.baidu.helios.ids.a aVar = this.awj.i.get(str);
        return aVar != null ? a.d.fh(aVar.zk()) : a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fg(String str) {
        a();
        List<TrustSubject> list = this.awj.awq.ayT;
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
