package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import d.a.q.g.d.a;
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
/* loaded from: classes2.dex */
public class TrustSubjectManager {

    /* renamed from: a  reason: collision with root package name */
    public a.C1846a f6305a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6306b;

    /* renamed from: c  reason: collision with root package name */
    public TrustSubject f6307c;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f6308a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q.g.d.a f6309b;
    }

    /* loaded from: classes2.dex */
    public static class b {
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6310a = 0;
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<TrustSubject> f6311a;

        /* renamed from: b  reason: collision with root package name */
        public TrustSubject f6312b;
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f6313a;

        public e(List<String> list) {
            this.f6313a = list;
        }

        public static e a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-pkgs");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                JSONArray jSONArray = new JSONObject(m).getJSONArray("value");
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
                return new e(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public List<String> b() {
            return this.f6313a;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Set<String> f6314a;

        public f(Set<String> set) {
            this.f6314a = set;
        }

        public static f a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-revoke-sigs");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                JSONArray jSONArray = new JSONObject(m).getJSONArray("revoke-sigs");
                int length = jSONArray.length();
                HashSet hashSet = new HashSet(length);
                for (int i2 = 0; i2 < length; i2++) {
                    hashSet.add(jSONArray.getString(i2));
                }
                return new f(hashSet);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public Set<String> b() {
            return this.f6314a;
        }
    }

    public static void c(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        c(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public final d.a.q.g.b.e.a a() {
        return d.a.q.g.b.c.a(d.a.q.j.a.a.f68044a, d.a.q.j.a.a.f68045b);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x011a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d b(d.a.q.g.b.e.a aVar) {
        boolean z;
        TrustSubject trustSubject;
        d dVar = new d();
        List<ResolveInfo> queryBroadcastReceivers = this.f6306b.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.HELIOS"), 0);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo.packageName.equals(this.f6307c.f6290a)) {
                    trustSubject = this.f6307c;
                } else {
                    TrustSubject trustSubject2 = new TrustSubject(resolveInfo.activityInfo.packageName, this.f6306b, this.f6305a);
                    trustSubject2.v();
                    trustSubject = trustSubject2;
                }
                arrayList2.add(trustSubject);
                boolean u = trustSubject.u();
                if (!u || trustSubject.a().a(3L) == 0) {
                    trustSubject.d(aVar);
                }
                if (trustSubject.a().a(3L) == 1) {
                    hashSet.add(trustSubject);
                    if (!u || trustSubject.a().a(384L) == 0) {
                        trustSubject.g();
                    }
                    if (trustSubject.a().a(384L) == 128) {
                        arrayList.add(trustSubject);
                    }
                }
            }
        }
        TrustSubject trustSubject3 = null;
        Collections.sort(arrayList, TrustSubject.f6289h);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrustSubject trustSubject4 = (TrustSubject) it.next();
            if (trustSubject4.u()) {
                long a2 = trustSubject4.a().a(48L);
                if (a2 != 0) {
                    if (a2 == 32) {
                        continue;
                    } else if (a2 != 16 || trustSubject4.a().a(64L) == 64) {
                        z = false;
                        if (z || trustSubject4.h()) {
                            if (!trustSubject4.p()) {
                                trustSubject3 = trustSubject4;
                                break;
                            }
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
            if (!trustSubject4.p()) {
            }
        }
        for (TrustSubject trustSubject5 : arrayList2) {
            if (!trustSubject5.equals(trustSubject3)) {
                trustSubject5.j();
                trustSubject5.k();
            }
            trustSubject5.q();
            trustSubject5.l();
            trustSubject5.w();
        }
        d(arrayList2);
        ArrayList arrayList3 = new ArrayList(hashSet);
        if (trustSubject3 != null) {
            e(arrayList3, trustSubject3);
        }
        Collections.sort(arrayList3, TrustSubject.f6288g);
        dVar.f6311a = arrayList3;
        if (trustSubject3 != null) {
            trustSubject3.i();
            dVar.f6312b = trustSubject3;
        }
        return dVar;
    }

    public final void d(List<TrustSubject> list) {
        File[] listFiles;
        HashMap hashMap = new HashMap();
        for (TrustSubject trustSubject : list) {
            hashMap.put(trustSubject.f6290a, trustSubject);
        }
        File b2 = this.f6305a.b();
        if (b2 == null || (listFiles = b2.listFiles(new TrustSubject.d())) == null) {
            return;
        }
        for (File file : listFiles) {
            String f2 = TrustSubject.f(file.getName());
            if (!TextUtils.isEmpty(f2) && !hashMap.containsKey(f2)) {
                c(file);
            }
        }
    }

    public final void e(List<TrustSubject> list, TrustSubject trustSubject) {
        Set<String> b2;
        f a2 = f.a(trustSubject);
        if (a2 == null || (b2 = a2.b()) == null || b2.size() <= 0) {
            return;
        }
        Iterator<TrustSubject> it = list.iterator();
        while (it.hasNext()) {
            Set<String> t = it.next().t();
            if (t != null && t.size() > 0) {
                Iterator<String> it2 = t.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (b2.contains(it2.next())) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public void f(a aVar) {
        this.f6306b = aVar.f6308a;
        a.C1846a f2 = aVar.f6309b.d().f("tz");
        this.f6305a = f2;
        f2.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x016f, code lost:
        r7 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0113 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d g(d.a.q.g.b.e.a aVar) {
        TrustSubject trustSubject;
        boolean z;
        d dVar = new d();
        TrustSubject trustSubject2 = this.f6307c;
        if (trustSubject2.r()) {
            HashMap hashMap = new HashMap();
            hashMap.put(trustSubject2.f6290a, trustSubject2);
            HashSet hashSet = new HashSet();
            long j = 3;
            long j2 = 1;
            if (trustSubject2.a().a(3L) == 1) {
                hashSet.add(trustSubject2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(trustSubject2);
            TrustSubject trustSubject3 = trustSubject2;
            TrustSubject trustSubject4 = null;
            while (true) {
                if (trustSubject4 != null && trustSubject4.equals(trustSubject3)) {
                    break;
                }
                e a2 = e.a(trustSubject3);
                List<String> b2 = a2 != null ? a2.b() : null;
                if (b2 == null || hashMap.keySet().containsAll(b2)) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it = b2.iterator();
                while (true) {
                    boolean z2 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!hashMap.containsKey(next)) {
                        TrustSubject trustSubject5 = trustSubject2.f6290a.equals(next) ? trustSubject2 : new TrustSubject(next, this.f6306b, this.f6305a);
                        hashMap.put(next, trustSubject5);
                        if (trustSubject5.s()) {
                            trustSubject5.v();
                            arrayList.add(trustSubject5);
                            boolean u = trustSubject5.u();
                            if (!u || trustSubject5.a().a(j) == 0) {
                                trustSubject5.d(aVar);
                            }
                            if (trustSubject5.a().a(j) == 1) {
                                hashSet.add(trustSubject5);
                                if ((!u || trustSubject5.a().a(384L) == 0) ? true : true) {
                                    trustSubject5.g();
                                }
                                if (trustSubject5.a().a(384L) == 128) {
                                    arrayList2.add(trustSubject5);
                                }
                            }
                            j2 = 1;
                            j = 3;
                        } else {
                            j2 = 1;
                        }
                    }
                }
                long j3 = j2;
                Collections.sort(arrayList2, TrustSubject.f6289h);
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    trustSubject = (TrustSubject) it2.next();
                    if (trustSubject.u()) {
                        long a3 = trustSubject.a().a(48L);
                        if (a3 != 0) {
                            if (a3 == 32) {
                                continue;
                            } else if (a3 != 16 || trustSubject.a().a(64L) == 64) {
                                z = false;
                                if (z || trustSubject.h()) {
                                    if (!trustSubject.p()) {
                                        if (trustSubject.n() > trustSubject3.n()) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    if (!trustSubject.p()) {
                    }
                }
                trustSubject4 = trustSubject3;
                j2 = j3;
                trustSubject3 = trustSubject;
                j = 3;
            }
            for (TrustSubject trustSubject6 : arrayList) {
                if (!trustSubject6.equals(trustSubject3)) {
                    trustSubject6.j();
                    trustSubject6.k();
                }
                trustSubject6.q();
                trustSubject6.l();
                trustSubject6.w();
            }
            d(arrayList);
            ArrayList arrayList3 = new ArrayList(hashSet);
            if (trustSubject3 != null) {
                e(arrayList3, trustSubject3);
            }
            Collections.sort(arrayList3, TrustSubject.f6288g);
            dVar.f6311a = arrayList3;
            if (trustSubject3 != null) {
                trustSubject3.i();
                dVar.f6312b = trustSubject3;
            }
            return dVar;
        }
        return dVar;
    }

    public final void h() {
        TrustSubject trustSubject = new TrustSubject(this.f6306b.getPackageName(), this.f6306b, this.f6305a);
        trustSubject.v();
        boolean u = trustSubject.u();
        boolean z = false;
        boolean z2 = true;
        if (!u || trustSubject.a().a(3L) == 0) {
            trustSubject.d(a());
        }
        if (!u || trustSubject.a().a(384L) == 0) {
            trustSubject.g();
        }
        if (u) {
            long a2 = trustSubject.a().a(48L);
            if (a2 == 0 || (a2 != 32 && a2 == 16 && trustSubject.a().a(64L) != 64)) {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            trustSubject.h();
        }
        trustSubject.q();
        trustSubject.w();
        this.f6307c = trustSubject;
    }

    public void i(b bVar) {
        h();
    }

    public d j(c cVar) {
        d.a.q.g.b.e.a a2 = a();
        int i2 = cVar.f6310a;
        if (i2 == 1) {
            return b(a2);
        }
        if (i2 == 2) {
            return g(a2);
        }
        d b2 = b(a2);
        List<TrustSubject> list = b2.f6311a;
        return (list == null || list.size() == 0) ? g(a2) : b2;
    }
}
