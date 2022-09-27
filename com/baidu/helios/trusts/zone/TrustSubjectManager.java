package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.tieba.h60;
import com.baidu.tieba.k50;
import com.baidu.tieba.t40;
import com.baidu.tieba.u40;
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
/* loaded from: classes2.dex */
public class TrustSubjectManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k50.a a;
    public Context b;
    public TrustSubject c;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public k50 b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        public c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public static c a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String i = trustSubject.i("config-pkgs");
                    if (TextUtils.isEmpty(i)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONObject(i).getJSONArray("value");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.getString(i2));
                    }
                    return new c(arrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public List<String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<String> a;

        public e(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
        }

        public static e a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String i = trustSubject.i("config-revoke-sigs");
                    if (TextUtils.isEmpty(i)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONObject(i).getJSONArray("revoke-sigs");
                    int length = jSONArray.length();
                    HashSet hashSet = new HashSet(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        hashSet.add(jSONArray.getString(i2));
                    }
                    return new e(hashSet);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public Set<String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<TrustSubject> a;
        public TrustSubject b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public TrustSubjectManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void i(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            i(file2);
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

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.b = aVar.a;
            k50.a f2 = aVar.b.d().f("tz");
            this.a = f2;
            f2.a();
        }
    }

    public final void b(List<TrustSubject> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            HashMap hashMap = new HashMap();
            for (TrustSubject trustSubject : list) {
                hashMap.put(trustSubject.a, trustSubject);
            }
            File b2 = this.a.b();
            if (b2 == null || (listFiles = b2.listFiles(new TrustSubject.d())) == null) {
                return;
            }
            for (File file : listFiles) {
                String s = TrustSubject.s(file.getName());
                if (!TextUtils.isEmpty(s) && !hashMap.containsKey(s)) {
                    i(file);
                }
            }
        }
    }

    public final void c(List<TrustSubject> list, TrustSubject trustSubject) {
        e a2;
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, trustSubject) == null) || (a2 = e.a(trustSubject)) == null || (b2 = a2.b()) == null || b2.size() <= 0) {
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
                    } else if (b2.contains(it2.next())) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public final u40 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? t40.a(h60.a, h60.b) : (u40) invokeV.objValue;
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TrustSubject trustSubject = new TrustSubject(this.b.getPackageName(), this.b, this.a);
            trustSubject.m();
            boolean q = trustSubject.q();
            boolean z = false;
            boolean z2 = true;
            if (!q || trustSubject.h().c(3L) == 0) {
                trustSubject.x(d());
            }
            if (!q || trustSubject.h().c(384L) == 0) {
                trustSubject.w();
            }
            if (q) {
                long c2 = trustSubject.h().c(48L);
                if (c2 == 0 || (c2 != 32 && c2 == 16 && trustSubject.h().c(64L) != 64)) {
                    z = true;
                }
                z2 = z;
            }
            if (z2) {
                trustSubject.u();
            }
            trustSubject.v();
            trustSubject.t();
            this.c = trustSubject;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0173, code lost:
        r7 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0117 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f g(u40 u40Var) {
        InterceptResult invokeL;
        TrustSubject trustSubject;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, u40Var)) == null) {
            f fVar = new f();
            TrustSubject trustSubject2 = this.c;
            if (trustSubject2.n()) {
                HashMap hashMap = new HashMap();
                hashMap.put(trustSubject2.a, trustSubject2);
                HashSet hashSet = new HashSet();
                long j = 3;
                long j2 = 1;
                if (trustSubject2.h().c(3L) == 1) {
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
                    c a2 = c.a(trustSubject3);
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
                            TrustSubject trustSubject5 = trustSubject2.a.equals(next) ? trustSubject2 : new TrustSubject(next, this.b, this.a);
                            hashMap.put(next, trustSubject5);
                            if (trustSubject5.o()) {
                                trustSubject5.m();
                                arrayList.add(trustSubject5);
                                boolean q = trustSubject5.q();
                                if (!q || trustSubject5.h().c(j) == 0) {
                                    trustSubject5.x(u40Var);
                                }
                                if (trustSubject5.h().c(j) == 1) {
                                    hashSet.add(trustSubject5);
                                    if ((!q || trustSubject5.h().c(384L) == 0) ? true : true) {
                                        trustSubject5.w();
                                    }
                                    if (trustSubject5.h().c(384L) == 128) {
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
                    Collections.sort(arrayList2, TrustSubject.h);
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        trustSubject = (TrustSubject) it2.next();
                        if (trustSubject.q()) {
                            long c2 = trustSubject.h().c(48L);
                            if (c2 != 0) {
                                if (c2 == 32) {
                                    continue;
                                } else if (c2 != 16 || trustSubject.h().c(64L) == 64) {
                                    z = false;
                                    if (z || trustSubject.u()) {
                                        if (!trustSubject.p()) {
                                            if (trustSubject.k() > trustSubject3.k()) {
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
                        trustSubject6.f();
                        trustSubject6.g();
                    }
                    trustSubject6.v();
                    trustSubject6.e();
                    trustSubject6.t();
                }
                b(arrayList);
                ArrayList arrayList3 = new ArrayList(hashSet);
                if (trustSubject3 != null) {
                    c(arrayList3, trustSubject3);
                }
                Collections.sort(arrayList3, TrustSubject.g);
                fVar.a = arrayList3;
                if (trustSubject3 != null) {
                    trustSubject3.r();
                    fVar.b = trustSubject3;
                }
                return fVar;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f h(u40 u40Var) {
        InterceptResult invokeL;
        boolean z;
        TrustSubject trustSubject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, u40Var)) == null) {
            f fVar = new f();
            List<ResolveInfo> queryBroadcastReceivers = this.b.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.HELIOS"), 0);
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (resolveInfo.activityInfo.packageName.equals(this.c.a)) {
                        trustSubject = this.c;
                    } else {
                        TrustSubject trustSubject2 = new TrustSubject(resolveInfo.activityInfo.packageName, this.b, this.a);
                        trustSubject2.m();
                        trustSubject = trustSubject2;
                    }
                    arrayList2.add(trustSubject);
                    boolean q = trustSubject.q();
                    if (!q || trustSubject.h().c(3L) == 0) {
                        trustSubject.x(u40Var);
                    }
                    if (trustSubject.h().c(3L) == 1) {
                        hashSet.add(trustSubject);
                        if (!q || trustSubject.h().c(384L) == 0) {
                            trustSubject.w();
                        }
                        if (trustSubject.h().c(384L) == 128) {
                            arrayList.add(trustSubject);
                        }
                    }
                }
            }
            TrustSubject trustSubject3 = null;
            Collections.sort(arrayList, TrustSubject.h);
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TrustSubject trustSubject4 = (TrustSubject) it.next();
                if (trustSubject4.q()) {
                    long c2 = trustSubject4.h().c(48L);
                    if (c2 != 0) {
                        if (c2 == 32) {
                            continue;
                        } else if (c2 != 16 || trustSubject4.h().c(64L) == 64) {
                            z = false;
                            if (z || trustSubject4.u()) {
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
                    trustSubject5.f();
                    trustSubject5.g();
                }
                trustSubject5.v();
                trustSubject5.e();
                trustSubject5.t();
            }
            b(arrayList2);
            ArrayList arrayList3 = new ArrayList(hashSet);
            if (trustSubject3 != null) {
                c(arrayList3, trustSubject3);
            }
            Collections.sort(arrayList3, TrustSubject.g);
            fVar.a = arrayList3;
            if (trustSubject3 != null) {
                trustSubject3.r();
                fVar.b = trustSubject3;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public f query(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            u40 d2 = d();
            int i = dVar.a;
            if (i == 1) {
                return h(d2);
            }
            if (i == 2) {
                return g(d2);
            }
            f h = h(d2);
            List<TrustSubject> list = h.a;
            return (list == null || list.size() == 0) ? g(d2) : h;
        }
        return (f) invokeL.objValue;
    }
}
