package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a60;
import com.baidu.tieba.b70;
import com.baidu.tieba.c70;
import com.baidu.tieba.d60;
import com.baidu.tieba.v50;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TrustSubject {
    public static /* synthetic */ Interceptable $ic;
    public static Comparator<TrustSubject> g;
    public static Comparator<TrustSubject> h;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final c70 b;
    public final b70 c;
    public Context d;
    public d60.a e;
    public c f;

    /* loaded from: classes3.dex */
    public static class ConfigNotFoundException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigNotFoundException(String str) {
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
        public ConfigNotFoundException(String str, Throwable th) {
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
        public ConfigNotFoundException(Throwable th) {
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

    /* loaded from: classes3.dex */
    public static class a implements Comparator<TrustSubject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trustSubject, trustSubject2)) == null) {
                int i = ((trustSubject.f.k() - trustSubject2.f.k()) > 0L ? 1 : ((trustSubject.f.k() - trustSubject2.f.k()) == 0L ? 0 : -1));
                return i != 0 ? i > 0 ? -1 : 1 : trustSubject.a.compareTo(trustSubject2.a);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<TrustSubject> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trustSubject, trustSubject2)) == null) {
                int i = ((trustSubject.f.o() - trustSubject2.f.o()) > 0L ? 1 : ((trustSubject.f.o() - trustSubject2.f.o()) == 0L ? 0 : -1));
                return i != 0 ? i > 0 ? -1 : 1 : trustSubject.a.compareTo(trustSubject2.a);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public long d;
        public long e;
        public a60 f;
        public boolean g;
        public Set<String> h;
        public final /* synthetic */ TrustSubject i;

        public c(TrustSubject trustSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trustSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = trustSubject;
            this.f = new a60();
            this.g = true;
            this.h = new HashSet();
        }

        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f.a(j) : invokeJ.longValue;
        }

        public void c(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                if (set == null || set.size() == 0) {
                    if (this.h.size() == 0) {
                        return;
                    }
                    this.h.clear();
                } else if (this.h.equals(set)) {
                    return;
                } else {
                    this.h.clear();
                    this.h.addAll(set);
                }
                this.g = true;
            }
        }

        public boolean d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (this.a != i) {
                    this.a = i;
                    this.g = true;
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        public boolean e(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (this.f.c(j, j2)) {
                    this.g = true;
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                return e(z ? 1L : 2L, 3L);
            }
            return invokeZ.booleanValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.b != j) {
                    this.b = j;
                    this.g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.longValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                if (this.c != j) {
                    this.c = j;
                    this.g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : invokeV.longValue;
        }

        public boolean l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                if (this.e != j) {
                    this.e = j;
                    this.g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : invokeV.longValue;
        }

        public boolean n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
                if (this.d != j) {
                    this.d = j;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : invokeV.longValue;
        }

        public Set<String> p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h : (Set) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (this.g) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.b);
                        jSONObject.put("version_code", this.a);
                        jSONObject.put("trust_priority", this.c);
                        jSONObject.put("quick_config_version", this.d);
                        jSONObject.put("config_version", this.e);
                        jSONObject.put("flags", this.f.d());
                        if (this.h.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str : this.h) {
                                jSONArray.put(str);
                            }
                            jSONObject.put("pkg_sigs", jSONArray);
                        }
                        this.i.e.i("ts_info", jSONObject.toString(), true);
                        this.g = false;
                        return true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                String g = this.i.e.g("ts_info", true);
                if (TextUtils.isEmpty(g)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g);
                    this.b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                    this.a = jSONObject.getInt("version_code");
                    this.c = jSONObject.getLong("trust_priority");
                    this.d = jSONObject.getLong("quick_config_version");
                    this.e = jSONObject.getLong("config_version");
                    this.f.b(jSONObject.getLong("flags"));
                    this.h.clear();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            this.h.add(optJSONArray.getString(i));
                        }
                    }
                    this.g = false;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && file.getName().startsWith("pkg-") : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1992020501, "Lcom/baidu/helios/trusts/zone/TrustSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1992020501, "Lcom/baidu/helios/trusts/zone/TrustSubject;");
                return;
            }
        }
        g = new a();
        h = new b();
    }

    public TrustSubject(String str, Context context, d60.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new c70();
        this.c = new b70();
        this.f = new c(this);
        this.d = context;
        this.a = str;
        this.e = aVar.f(c(str));
        x();
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return "pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() > 4) {
                try {
                    return new String(Base64.decode(str.substring(4), 3));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (c) invokeV.objValue;
    }

    public void d(v50 v50Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v50Var) == null) {
            this.b.b(v50Var, true);
            this.f.f(this.b.d());
            this.f.j(this.b.i());
            this.f.c(this.b.j());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrustSubject.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((TrustSubject) obj).a);
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long a2 = this.c.a();
            this.f.e(a2 > -1 ? 128L : 256L, 384L);
            this.f.n(a2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d2 = this.c.d();
            if (d2 == 0) {
                this.f.e(16L, 48L);
                this.f.e(64L, 64L);
                this.f.e(4L, 12L);
                i();
                this.f.l(this.c.j());
                return true;
            } else if (d2 != 3) {
                this.f.e(32L, 48L);
                this.f.e(0L, 64L);
                return false;
            } else {
                this.f.e(32L, 48L);
                this.f.e(8L, 12L);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.i();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.f();
            this.f.e(0L, 64L);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.g();
        }
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.c.h();
            return this.c.b(str);
        }
        return (String) invokeL.objValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f.e : invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f.k() : invokeV.longValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f.o() == this.f.m() : invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.a, 0);
                long j = packageInfo.lastUpdateTime;
                int i = packageInfo.versionCode;
                this.f.h(j);
                this.f.d(i);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f.a(12L) == 4 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                packageInfo = this.d.getPackageManager().getPackageInfo(this.a, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null;
        }
        return invokeV.booleanValue;
    }

    public Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new HashSet(this.f.p()) : (Set) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.a, 0);
                long j = packageInfo.lastUpdateTime;
                int i = packageInfo.versionCode;
                if (this.f.i() == j) {
                    return this.f.g() == i;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f.r();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f.q() : invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.b.c(this.a, this.d);
            this.c.c(this.a, this.d, this.e);
        }
    }
}
