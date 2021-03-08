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
/* loaded from: classes4.dex */
public class TrustSubjectManager {
    a.C0139a asY;
    private a avt;
    private TrustSubject avu;
    private Context d;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a atq;
    }

    /* loaded from: classes4.dex */
    public static class b {
    }

    /* loaded from: classes4.dex */
    public static class c {
        public int avv = 0;
    }

    /* loaded from: classes4.dex */
    public static class d {
        public List<TrustSubject> avw;
        public TrustSubject avx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f1861a;

        e(List<String> list) {
            this.f1861a = list;
        }

        public static e e(TrustSubject trustSubject) {
            try {
                String ei = trustSubject.ei("config-pkgs");
                if (!TextUtils.isEmpty(ei)) {
                    JSONArray jSONArray = new JSONObject(ei).getJSONArray("value");
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
            return this.f1861a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private Set<String> f1862a;

        f(Set<String> set) {
            this.f1862a = set;
        }

        public static f f(TrustSubject trustSubject) {
            try {
                String ei = trustSubject.ei("config-revoke-sigs");
                if (!TextUtils.isEmpty(ei)) {
                    JSONArray jSONArray = new JSONObject(ei).getJSONArray("revoke-sigs");
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
            return this.f1862a;
        }
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
        File vm = this.asY.vm();
        if (vm == null || (listFiles = vm.listFiles(new TrustSubject.b())) == null) {
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
            Set<String> j = it.next().j();
            if (j != null && j.size() > 0) {
                Iterator<String> it2 = j.iterator();
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
                if (resolveInfo.activityInfo.packageName.equals(this.avu.packageName)) {
                    trustSubject2 = this.avu;
                } else {
                    TrustSubject trustSubject3 = new TrustSubject(resolveInfo.activityInfo.packageName, this.d, this.asY);
                    trustSubject3.l();
                    trustSubject2 = trustSubject3;
                }
                arrayList2.add(trustSubject2);
                boolean k = trustSubject2.k();
                boolean z = false;
                if (!k) {
                    z = true;
                } else if (trustSubject2.vt().a(3L) == 0) {
                    z = true;
                }
                if (z) {
                    trustSubject2.a(aVar);
                }
                if (trustSubject2.vt().a(3L) == 1) {
                    hashSet.add(trustSubject2);
                    boolean z2 = false;
                    if (!k) {
                        z2 = true;
                    } else if (trustSubject2.vt().a(384L) == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        trustSubject2.b();
                    }
                    if (trustSubject2.vt().a(384L) == 128) {
                        arrayList.add(trustSubject2);
                    }
                }
            }
        }
        TrustSubject trustSubject4 = null;
        Collections.sort(arrayList, TrustSubject.avq);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrustSubject trustSubject5 = (TrustSubject) it.next();
            boolean z3 = false;
            if (trustSubject5.k()) {
                long a2 = trustSubject5.vt().a(48L);
                if (a2 == 0) {
                    z3 = true;
                } else if (a2 == 32) {
                    continue;
                } else if (a2 == 16 && trustSubject5.vt().a(64L) != 64) {
                    z3 = true;
                }
            } else {
                z3 = true;
            }
            if (!z3 || trustSubject5.c()) {
                if (trustSubject5.h()) {
                    if (0 == 0) {
                        trustSubject = trustSubject5;
                    } else if (trustSubject5.vv() > trustSubject4.vv()) {
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
        Collections.sort(arrayList3, TrustSubject.f1860a);
        dVar.avw = arrayList3;
        if (trustSubject != null) {
            trustSubject.d();
            dVar.avx = trustSubject;
        }
        return dVar;
    }

    private void b() {
        boolean z = true;
        TrustSubject trustSubject = new TrustSubject(this.d.getPackageName(), this.d, this.asY);
        trustSubject.l();
        boolean k = trustSubject.k();
        if (k ? trustSubject.vt().a(3L) == 0 : true) {
            trustSubject.a(vy());
        }
        if (k ? trustSubject.vt().a(384L) == 0 : true) {
            trustSubject.b();
        }
        if (k) {
            long a2 = trustSubject.vt().a(48L);
            if (a2 != 0) {
                if (a2 == 32) {
                    z = false;
                } else if (a2 != 16 || trustSubject.vt().a(64L) == 64) {
                    z = false;
                }
            }
        }
        if (z) {
            trustSubject.c();
        }
        trustSubject.i();
        trustSubject.m();
        this.avu = trustSubject;
    }

    private d c(com.baidu.helios.common.a.b.a aVar) {
        TrustSubject trustSubject;
        d dVar = new d();
        TrustSubject trustSubject2 = this.avu;
        if (trustSubject2.vx()) {
            HashMap hashMap = new HashMap();
            hashMap.put(trustSubject2.packageName, trustSubject2);
            HashSet hashSet = new HashSet();
            if (trustSubject2.vt().a(3L) == 1) {
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
                        TrustSubject trustSubject5 = trustSubject2.packageName.equals(str) ? trustSubject2 : new TrustSubject(str, this.d, this.asY);
                        hashMap.put(str, trustSubject5);
                        if (trustSubject5.vu()) {
                            trustSubject5.l();
                            arrayList.add(trustSubject5);
                            boolean k = trustSubject5.k();
                            boolean z = false;
                            if (!k) {
                                z = true;
                            } else if (trustSubject5.vt().a(3L) == 0) {
                                z = true;
                            }
                            if (z) {
                                trustSubject5.a(aVar);
                            }
                            if (trustSubject5.vt().a(3L) == 1) {
                                hashSet.add(trustSubject5);
                                boolean z2 = false;
                                if (!k) {
                                    z2 = true;
                                } else if (trustSubject5.vt().a(384L) == 0) {
                                    z2 = true;
                                }
                                if (z2) {
                                    trustSubject5.b();
                                }
                                if (trustSubject5.vt().a(384L) == 128) {
                                    arrayList2.add(trustSubject5);
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, TrustSubject.avq);
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    trustSubject = (TrustSubject) it.next();
                    boolean z3 = false;
                    if (trustSubject.k()) {
                        long a3 = trustSubject.vt().a(48L);
                        if (a3 == 0) {
                            z3 = true;
                        } else if (a3 == 32) {
                            continue;
                        } else if (a3 == 16 && trustSubject.vt().a(64L) != 64) {
                            z3 = true;
                        }
                    } else {
                        z3 = true;
                    }
                    if (!z3 || trustSubject.c()) {
                        if (trustSubject.h()) {
                            if (trustSubject.vv() > trustSubject4.vv()) {
                            }
                        }
                    }
                }
                trustSubject = trustSubject4;
                trustSubject3 = trustSubject4;
                trustSubject4 = trustSubject;
            }
            for (TrustSubject trustSubject6 : arrayList) {
                if (!trustSubject6.equals(trustSubject4)) {
                    trustSubject6.e();
                    trustSubject6.f();
                }
                trustSubject6.i();
                trustSubject6.g();
                trustSubject6.m();
            }
            a(arrayList);
            ArrayList arrayList3 = new ArrayList(hashSet);
            if (trustSubject4 != null) {
                a(arrayList3, trustSubject4);
            }
            Collections.sort(arrayList3, TrustSubject.f1860a);
            dVar.avw = arrayList3;
            if (trustSubject4 != null) {
                trustSubject4.d();
                dVar.avx = trustSubject4;
            }
            return dVar;
        }
        return dVar;
    }

    private com.baidu.helios.common.a.b.a vy() {
        return com.baidu.helios.common.a.c.c(com.baidu.helios.trusts.zone.a.f1863a, com.baidu.helios.trusts.zone.a.b);
    }

    public d a(c cVar) {
        com.baidu.helios.common.a.b.a vy = vy();
        if (cVar.avv == 1) {
            return b(vy);
        }
        if (cVar.avv == 2) {
            return c(vy);
        }
        d b2 = b(vy);
        return (b2.avw == null || b2.avw.size() == 0) ? c(vy) : b2;
    }

    public void a(a aVar) {
        this.avt = aVar;
        this.d = aVar.applicationContext;
        this.asY = aVar.atq.vk().eg("tz");
        this.asY.vl();
    }

    public void a(b bVar) {
        b();
    }
}
