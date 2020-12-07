package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class TrustSubjectManager {
    a.C0149a avX;
    private TrustSubject ayA;
    private a ayz;
    private Context d;

    /* loaded from: classes17.dex */
    public static class IntegrationException extends RuntimeException {
        public IntegrationException(String str) {
            super(str);
        }

        public IntegrationException(String str, Throwable th) {
            super(str, th);
        }

        public IntegrationException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes17.dex */
    public static class a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a awq;
    }

    /* loaded from: classes17.dex */
    public static class b {
    }

    /* loaded from: classes17.dex */
    public static class c {
        public int ayB = 0;
    }

    /* loaded from: classes17.dex */
    public static class d {
        public List<TrustSubject> ayC;
        public TrustSubject ayD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f1823a;

        e(List<String> list) {
            this.f1823a = list;
        }

        public static e e(TrustSubject trustSubject) {
            try {
                String fD = trustSubject.fD("config-pkgs");
                if (!TextUtils.isEmpty(fD)) {
                    JSONArray jSONArray = new JSONObject(fD).getJSONArray("value");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    return new e(arrayList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public List<String> a() {
            return this.f1823a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private Set<String> f1824a;

        f(Set<String> set) {
            this.f1824a = set;
        }

        public static f f(TrustSubject trustSubject) {
            try {
                String fD = trustSubject.fD("config-revoke-sigs");
                if (!TextUtils.isEmpty(fD)) {
                    JSONArray jSONArray = new JSONObject(fD).getJSONArray("revoke-sigs");
                    int length = jSONArray.length();
                    HashSet hashSet = new HashSet(length);
                    for (int i = 0; i < length; i++) {
                        hashSet.add(jSONArray.getString(i));
                    }
                    return new f(hashSet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public Set<String> a() {
            return this.f1824a;
        }
    }

    private com.baidu.helios.common.a.b.a Ae() {
        return com.baidu.helios.common.a.c.c(com.baidu.helios.trusts.zone.a.f1825a, com.baidu.helios.trusts.zone.a.b);
    }

    private static void a(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        a(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        } catch (Exception e2) {
        }
    }

    private void a(List<TrustSubject> list) {
        File[] listFiles;
        HashMap hashMap = new HashMap();
        for (TrustSubject trustSubject : list) {
            hashMap.put(trustSubject.packageName, trustSubject);
        }
        File zQ = this.avX.zQ();
        if (zQ == null || (listFiles = zQ.listFiles(new TrustSubject.b())) == null) {
            return;
        }
        for (File file : listFiles) {
            String b2 = TrustSubject.b(file.getName());
            if (!TextUtils.isEmpty(b2) && !hashMap.containsKey(b2)) {
                a(file);
            }
        }
    }

    private void a(List<TrustSubject> list, TrustSubject trustSubject) {
        Set<String> a2;
        f f2 = f.f(trustSubject);
        if (f2 == null || (a2 = f2.a()) == null || a2.size() <= 0) {
            return;
        }
        Iterator<TrustSubject> it = list.iterator();
        while (it.hasNext()) {
            Set<String> Ac = it.next().Ac();
            if (Ac != null && Ac.size() > 0) {
                Iterator<String> it2 = Ac.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (a2.contains(it2.next())) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    private d b(com.baidu.helios.common.a.b.a aVar) {
        TrustSubject trustSubject;
        TrustSubject trustSubject2;
        d dVar = new d();
        List<ResolveInfo> queryBroadcastReceivers = this.d.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.HELIOS"), 0);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo.packageName.equals(this.ayA.packageName)) {
                    trustSubject2 = this.ayA;
                } else {
                    TrustSubject trustSubject3 = new TrustSubject(resolveInfo.activityInfo.packageName, this.d, this.avX);
                    trustSubject3.l();
                    trustSubject2 = trustSubject3;
                }
                arrayList2.add(trustSubject2);
                boolean k = trustSubject2.k();
                boolean z = false;
                if (!k) {
                    z = true;
                } else if (trustSubject2.zX().a(3L) == 0) {
                    z = true;
                }
                if (z) {
                    trustSubject2.a(aVar);
                }
                if (trustSubject2.zX().a(3L) == 1) {
                    hashSet.add(trustSubject2);
                    boolean z2 = false;
                    if (!k) {
                        z2 = true;
                    } else if (trustSubject2.zX().a(384L) == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        trustSubject2.b();
                    }
                    if (trustSubject2.zX().a(384L) == 128) {
                        arrayList.add(trustSubject2);
                    }
                }
            }
        }
        TrustSubject trustSubject4 = null;
        Collections.sort(arrayList, TrustSubject.ayv);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrustSubject trustSubject5 = (TrustSubject) it.next();
            boolean z3 = false;
            if (trustSubject5.k()) {
                long a2 = trustSubject5.zX().a(48L);
                if (a2 == 0) {
                    z3 = true;
                } else if (a2 == 32) {
                    continue;
                } else if (a2 == 16 && trustSubject5.zX().a(64L) != 64) {
                    z3 = true;
                }
            } else {
                z3 = true;
            }
            if (!z3 || trustSubject5.c()) {
                if (trustSubject5.h()) {
                    if (0 == 0) {
                        trustSubject = trustSubject5;
                    } else if (trustSubject5.zZ() > trustSubject4.zZ()) {
                        trustSubject = trustSubject5;
                    }
                }
            }
        }
        trustSubject = null;
        for (TrustSubject trustSubject6 : arrayList2) {
            if (!trustSubject6.equals(trustSubject)) {
                trustSubject6.e();
                trustSubject6.f();
            }
            trustSubject6.i();
            trustSubject6.g();
            trustSubject6.m();
        }
        a(arrayList2);
        ArrayList arrayList3 = new ArrayList(hashSet);
        if (trustSubject != null) {
            a(arrayList3, trustSubject);
        }
        Collections.sort(arrayList3, TrustSubject.f1822a);
        dVar.ayC = arrayList3;
        if (trustSubject != null) {
            trustSubject.d();
            dVar.ayD = trustSubject;
        }
        return dVar;
    }

    private void b() {
        boolean z = true;
        TrustSubject trustSubject = new TrustSubject(this.d.getPackageName(), this.d, this.avX);
        trustSubject.l();
        boolean k = trustSubject.k();
        if (k ? trustSubject.zX().a(3L) == 0 : true) {
            trustSubject.a(Ae());
        }
        if (k ? trustSubject.zX().a(384L) == 0 : true) {
            trustSubject.b();
        }
        if (k) {
            long a2 = trustSubject.zX().a(48L);
            if (a2 != 0) {
                if (a2 == 32) {
                    z = false;
                } else if (a2 != 16 || trustSubject.zX().a(64L) == 64) {
                    z = false;
                }
            }
        }
        if (z) {
            trustSubject.c();
        }
        trustSubject.i();
        trustSubject.m();
        this.ayA = trustSubject;
    }

    private d c(com.baidu.helios.common.a.b.a aVar) {
        TrustSubject trustSubject;
        d dVar = new d();
        TrustSubject trustSubject2 = this.ayA;
        if (trustSubject2.Ab()) {
            HashMap hashMap = new HashMap();
            hashMap.put(trustSubject2.packageName, trustSubject2);
            HashSet hashSet = new HashSet();
            if (trustSubject2.zX().a(3L) == 1) {
                hashSet.add(trustSubject2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(trustSubject2);
            TrustSubject trustSubject3 = null;
            TrustSubject trustSubject4 = trustSubject2;
            while (true) {
                if (trustSubject3 != null && trustSubject3.equals(trustSubject4)) {
                    break;
                }
                e e2 = e.e(trustSubject4);
                List<String> a2 = e2 != null ? e2.a() : null;
                if (a2 == null || hashMap.keySet().containsAll(a2)) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : a2) {
                    if (!hashMap.containsKey(str)) {
                        TrustSubject trustSubject5 = trustSubject2.packageName.equals(str) ? trustSubject2 : new TrustSubject(str, this.d, this.avX);
                        hashMap.put(str, trustSubject5);
                        if (trustSubject5.zY()) {
                            trustSubject5.l();
                            arrayList.add(trustSubject5);
                            boolean k = trustSubject5.k();
                            boolean z = false;
                            if (!k) {
                                z = true;
                            } else if (trustSubject5.zX().a(3L) == 0) {
                                z = true;
                            }
                            if (z) {
                                trustSubject5.a(aVar);
                            }
                            if (trustSubject5.zX().a(3L) == 1) {
                                hashSet.add(trustSubject5);
                                boolean z2 = false;
                                if (!k) {
                                    z2 = true;
                                } else if (trustSubject5.zX().a(384L) == 0) {
                                    z2 = true;
                                }
                                if (z2) {
                                    trustSubject5.b();
                                }
                                if (trustSubject5.zX().a(384L) == 128) {
                                    arrayList2.add(trustSubject5);
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, TrustSubject.ayv);
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    trustSubject = (TrustSubject) it.next();
                    boolean z3 = false;
                    if (trustSubject.k()) {
                        long a3 = trustSubject.zX().a(48L);
                        if (a3 == 0) {
                            z3 = true;
                        } else if (a3 == 32) {
                            continue;
                        } else if (a3 == 16 && trustSubject.zX().a(64L) != 64) {
                            z3 = true;
                        }
                    } else {
                        z3 = true;
                    }
                    if (!z3 || trustSubject.c()) {
                        if (trustSubject.h()) {
                            if (trustSubject.zZ() > trustSubject4.zZ()) {
                            }
                        }
                    }
                }
                trustSubject = trustSubject4;
                TrustSubject trustSubject6 = trustSubject4;
                trustSubject4 = trustSubject;
                trustSubject3 = trustSubject6;
            }
            for (TrustSubject trustSubject7 : arrayList) {
                if (!trustSubject7.equals(trustSubject4)) {
                    trustSubject7.e();
                    trustSubject7.f();
                }
                trustSubject7.i();
                trustSubject7.g();
                trustSubject7.m();
            }
            a(arrayList);
            ArrayList arrayList3 = new ArrayList(hashSet);
            if (trustSubject4 != null) {
                a(arrayList3, trustSubject4);
            }
            Collections.sort(arrayList3, TrustSubject.f1822a);
            dVar.ayC = arrayList3;
            if (trustSubject4 != null) {
                trustSubject4.d();
                dVar.ayD = trustSubject4;
            }
            return dVar;
        }
        return dVar;
    }

    public d a(c cVar) {
        com.baidu.helios.common.a.b.a Ae = Ae();
        if (cVar.ayB == 1) {
            return b(Ae);
        }
        if (cVar.ayB == 2) {
            return c(Ae);
        }
        d b2 = b(Ae);
        return (b2.ayC == null || b2.ayC.size() == 0) ? c(Ae) : b2;
    }

    public void a(a aVar) {
        this.ayz = aVar;
        this.d = aVar.applicationContext;
        this.avX = aVar.awq.zO().fB("tz");
        this.avX.zP();
    }

    public void a(b bVar) {
        b();
    }
}
