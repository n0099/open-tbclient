package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.C0801a a;

    /* renamed from: b  reason: collision with root package name */
    public Context f33222b;

    /* renamed from: c  reason: collision with root package name */
    public TrustSubject f33223c;

    /* loaded from: classes4.dex */
    public static class IntegrationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationException(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationException(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.q.h.d.a f33224b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<TrustSubject> a;

        /* renamed from: b  reason: collision with root package name */
        public TrustSubject f33225b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        public e(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public static e a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
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
            return (e) invokeL.objValue;
        }

        public List<String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<String> a;

        public f(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
        }

        public static f a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
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
            return (f) invokeL.objValue;
        }

        public Set<String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Set) invokeV.objValue;
        }
    }

    public TrustSubjectManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
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
    }

    public final c.a.q.h.b.e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q.h.b.c.a(c.a.q.l.a.a.a, c.a.q.l.a.a.f11777b) : (c.a.q.h.b.e.a) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        r7 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x016b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x011c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d b(c.a.q.h.b.e.a aVar) {
        InterceptResult invokeL;
        TrustSubject trustSubject;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            d dVar = new d();
            TrustSubject trustSubject2 = this.f33223c;
            if (trustSubject2.r()) {
                HashMap hashMap = new HashMap();
                hashMap.put(trustSubject2.a, trustSubject2);
                HashSet hashSet = new HashSet();
                long j2 = 3;
                long j3 = 1;
                if (trustSubject2.j().b(3L) == 1) {
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
                        boolean z2 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (!hashMap.containsKey(next)) {
                            TrustSubject trustSubject5 = trustSubject2.a.equals(next) ? trustSubject2 : new TrustSubject(next, this.f33222b, this.a);
                            hashMap.put(next, trustSubject5);
                            if (trustSubject5.s()) {
                                trustSubject5.l();
                                arrayList.add(trustSubject5);
                                boolean q = trustSubject5.q();
                                if (!q || trustSubject5.j().b(j2) == 0) {
                                    trustSubject5.d(aVar);
                                }
                                if (trustSubject5.j().b(j2) == 1) {
                                    hashSet.add(trustSubject5);
                                    if (q && trustSubject5.j().b(384L) != 0) {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        trustSubject5.x();
                                    }
                                    if (trustSubject5.j().b(384L) == 128) {
                                        arrayList2.add(trustSubject5);
                                    }
                                    j3 = 1;
                                    j2 = 3;
                                } else {
                                    j3 = 1;
                                }
                            } else {
                                j3 = 1;
                            }
                        }
                    }
                    long j4 = j3;
                    Collections.sort(arrayList2, TrustSubject.f33208h);
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        trustSubject = (TrustSubject) it2.next();
                        if (trustSubject.q()) {
                            long b3 = trustSubject.j().b(48L);
                            if (b3 != 0) {
                                if (b3 == 32) {
                                    continue;
                                } else if (b3 != 16 || trustSubject.j().b(64L) == 64) {
                                    z = false;
                                    if (z || trustSubject.v()) {
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
                    j3 = j4;
                    trustSubject3 = trustSubject;
                    j2 = 3;
                }
                for (TrustSubject trustSubject6 : arrayList) {
                    if (!trustSubject6.equals(trustSubject3)) {
                        trustSubject6.h();
                        trustSubject6.i();
                    }
                    trustSubject6.w();
                    trustSubject6.g();
                    trustSubject6.u();
                }
                d(arrayList);
                ArrayList arrayList3 = new ArrayList(hashSet);
                if (trustSubject3 != null) {
                    e(arrayList3, trustSubject3);
                }
                Collections.sort(arrayList3, TrustSubject.f33207g);
                dVar.a = arrayList3;
                if (trustSubject3 != null) {
                    trustSubject3.t();
                    dVar.f33225b = trustSubject3;
                }
                return dVar;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void d(List<TrustSubject> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            HashMap hashMap = new HashMap();
            for (TrustSubject trustSubject : list) {
                hashMap.put(trustSubject.a, trustSubject);
            }
            File b2 = this.a.b();
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
    }

    public final void e(List<TrustSubject> list, TrustSubject trustSubject) {
        f a2;
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, trustSubject) == null) || (a2 = f.a(trustSubject)) == null || (b2 = a2.b()) == null || b2.size() <= 0) {
            return;
        }
        Iterator<TrustSubject> it = list.iterator();
        while (it.hasNext()) {
            Set<String> k = it.next().k();
            if (k != null && k.size() > 0) {
                Iterator<String> it2 = k.iterator();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f33222b = aVar.a;
            a.C0801a f2 = aVar.f33224b.d().f("tz");
            this.a = f2;
            f2.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d g(c.a.q.h.b.e.a aVar) {
        InterceptResult invokeL;
        boolean z;
        TrustSubject trustSubject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            d dVar = new d();
            List<ResolveInfo> queryBroadcastReceivers = this.f33222b.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.HELIOS"), 0);
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (resolveInfo.activityInfo.packageName.equals(this.f33223c.a)) {
                        trustSubject = this.f33223c;
                    } else {
                        TrustSubject trustSubject2 = new TrustSubject(resolveInfo.activityInfo.packageName, this.f33222b, this.a);
                        trustSubject2.l();
                        trustSubject = trustSubject2;
                    }
                    arrayList2.add(trustSubject);
                    boolean q = trustSubject.q();
                    if (!q || trustSubject.j().b(3L) == 0) {
                        trustSubject.d(aVar);
                    }
                    if (trustSubject.j().b(3L) == 1) {
                        hashSet.add(trustSubject);
                        if (!q || trustSubject.j().b(384L) == 0) {
                            trustSubject.x();
                        }
                        if (trustSubject.j().b(384L) == 128) {
                            arrayList.add(trustSubject);
                        }
                    }
                }
            }
            TrustSubject trustSubject3 = null;
            Collections.sort(arrayList, TrustSubject.f33208h);
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TrustSubject trustSubject4 = (TrustSubject) it.next();
                if (trustSubject4.q()) {
                    long b2 = trustSubject4.j().b(48L);
                    if (b2 != 0) {
                        if (b2 == 32) {
                            continue;
                        } else if (b2 != 16 || trustSubject4.j().b(64L) == 64) {
                            z = false;
                            if (z || trustSubject4.v()) {
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
                    trustSubject5.h();
                    trustSubject5.i();
                }
                trustSubject5.w();
                trustSubject5.g();
                trustSubject5.u();
            }
            d(arrayList2);
            ArrayList arrayList3 = new ArrayList(hashSet);
            if (trustSubject3 != null) {
                e(arrayList3, trustSubject3);
            }
            Collections.sort(arrayList3, TrustSubject.f33207g);
            dVar.a = arrayList3;
            if (trustSubject3 != null) {
                trustSubject3.t();
                dVar.f33225b = trustSubject3;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TrustSubject trustSubject = new TrustSubject(this.f33222b.getPackageName(), this.f33222b, this.a);
            trustSubject.l();
            boolean q = trustSubject.q();
            boolean z = true;
            if (!q || trustSubject.j().b(3L) == 0) {
                trustSubject.d(a());
            }
            if (!q || trustSubject.j().b(384L) == 0) {
                trustSubject.x();
            }
            if (q) {
                long b2 = trustSubject.j().b(48L);
                if (b2 != 0 && (b2 == 32 || b2 != 16 || trustSubject.j().b(64L) == 64)) {
                    z = false;
                }
            }
            if (z) {
                trustSubject.v();
            }
            trustSubject.w();
            trustSubject.u();
            this.f33223c = trustSubject;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            h();
        }
    }

    public d query(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            c.a.q.h.b.e.a a2 = a();
            int i2 = cVar.a;
            if (i2 == 1) {
                return g(a2);
            }
            if (i2 == 2) {
                return b(a2);
            }
            d g2 = g(a2);
            List<TrustSubject> list = g2.a;
            return (list == null || list.size() == 0) ? b(a2) : g2;
        }
        return (d) invokeL.objValue;
    }
}
