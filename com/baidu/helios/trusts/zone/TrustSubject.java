package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.r.g.c.a.e;
import c.a.r.g.d.a;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class TrustSubject {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static Comparator<TrustSubject> f40455g;

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f40456h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f40457a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r.j.a.c.a f40458b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r.j.a.b.a f40459c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40460d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1379a f40461e;

    /* renamed from: f  reason: collision with root package name */
    public c f40462f;

    /* loaded from: classes5.dex */
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
        public ConfigNotFoundException(String str, Throwable th) {
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
        public ConfigNotFoundException(Throwable th) {
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

    /* loaded from: classes5.dex */
    public static class a implements Comparator<TrustSubject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trustSubject, trustSubject2)) == null) {
                int i2 = ((trustSubject.f40462f.k() - trustSubject2.f40462f.k()) > 0L ? 1 : ((trustSubject.f40462f.k() - trustSubject2.f40462f.k()) == 0L ? 0 : -1));
                return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f40457a.compareTo(trustSubject2.f40457a);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Comparator<TrustSubject> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trustSubject, trustSubject2)) == null) {
                int i2 = ((trustSubject.f40462f.o() - trustSubject2.f40462f.o()) > 0L ? 1 : ((trustSubject.f40462f.o() - trustSubject2.f40462f.o()) == 0L ? 0 : -1));
                return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f40457a.compareTo(trustSubject2.f40457a);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40463a;

        /* renamed from: b  reason: collision with root package name */
        public long f40464b;

        /* renamed from: c  reason: collision with root package name */
        public long f40465c;

        /* renamed from: d  reason: collision with root package name */
        public long f40466d;

        /* renamed from: e  reason: collision with root package name */
        public long f40467e;

        /* renamed from: f  reason: collision with root package name */
        public e f40468f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f40469g;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f40470h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TrustSubject f40471i;

        public c(TrustSubject trustSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trustSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40471i = trustSubject;
            this.f40468f = new e();
            this.f40469g = true;
            this.f40470h = new HashSet();
        }

        public long a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f40468f.a(j2) : invokeJ.longValue;
        }

        public void c(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                if (set == null || set.size() == 0) {
                    if (this.f40470h.size() == 0) {
                        return;
                    }
                    this.f40470h.clear();
                } else if (this.f40470h.equals(set)) {
                    return;
                } else {
                    this.f40470h.clear();
                    this.f40470h.addAll(set);
                }
                this.f40469g = true;
            }
        }

        public boolean d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (this.f40463a != i2) {
                    this.f40463a = i2;
                    this.f40469g = true;
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        public boolean e(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                if (this.f40468f.c(j2, j3)) {
                    this.f40469g = true;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40463a : invokeV.intValue;
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (this.f40464b != j2) {
                    this.f40464b = j2;
                    this.f40469g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40464b : invokeV.longValue;
        }

        public boolean j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                if (this.f40465c != j2) {
                    this.f40465c = j2;
                    this.f40469g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40465c : invokeV.longValue;
        }

        public boolean l(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                if (this.f40467e != j2) {
                    this.f40467e = j2;
                    this.f40469g = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40467e : invokeV.longValue;
        }

        public boolean n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
                if (this.f40466d != j2) {
                    this.f40466d = j2;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40466d : invokeV.longValue;
        }

        public Set<String> p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f40470h : (Set) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (this.f40469g) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f40464b);
                        jSONObject.put("version_code", this.f40463a);
                        jSONObject.put("trust_priority", this.f40465c);
                        jSONObject.put("quick_config_version", this.f40466d);
                        jSONObject.put("config_version", this.f40467e);
                        jSONObject.put("flags", this.f40468f.d());
                        if (this.f40470h.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str : this.f40470h) {
                                jSONArray.put(str);
                            }
                            jSONObject.put("pkg_sigs", jSONArray);
                        }
                        this.f40471i.f40461e.i("ts_info", jSONObject.toString(), true);
                        this.f40469g = false;
                        return true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                String g2 = this.f40471i.f40461e.g("ts_info", true);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f40464b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                    this.f40463a = jSONObject.getInt("version_code");
                    this.f40465c = jSONObject.getLong("trust_priority");
                    this.f40466d = jSONObject.getLong("quick_config_version");
                    this.f40467e = jSONObject.getLong("config_version");
                    this.f40468f.b(jSONObject.getLong("flags"));
                    this.f40470h.clear();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            this.f40470h.add(optJSONArray.getString(i2));
                        }
                    }
                    this.f40469g = false;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        f40455g = new a();
        f40456h = new b();
    }

    public TrustSubject(String str, Context context, a.C1379a c1379a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context, c1379a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40458b = new c.a.r.j.a.c.a();
        this.f40459c = new c.a.r.j.a.b.a();
        this.f40462f = new c(this);
        this.f40460d = context;
        this.f40457a = str;
        this.f40461e = c1379a.f(c(str));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40462f : (c) invokeV.objValue;
    }

    public void d(c.a.r.g.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f40458b.b(aVar, true);
            this.f40462f.f(this.f40458b.d());
            this.f40462f.j(this.f40458b.i());
            this.f40462f.c(this.f40458b.j());
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
            return this.f40457a.equals(((TrustSubject) obj).f40457a);
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long a2 = this.f40459c.a();
            this.f40462f.e(a2 > -1 ? 128L : 256L, 384L);
            this.f40462f.n(a2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d2 = this.f40459c.d();
            if (d2 == 0) {
                this.f40462f.e(16L, 48L);
                this.f40462f.e(64L, 64L);
                this.f40462f.e(4L, 12L);
                i();
                this.f40462f.l(this.f40459c.j());
                return true;
            } else if (d2 != 3) {
                this.f40462f.e(32L, 48L);
                this.f40462f.e(0L, 64L);
                return false;
            } else {
                this.f40462f.e(32L, 48L);
                this.f40462f.e(8L, 12L);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40457a.hashCode() : invokeV.intValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f40459c.h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f40459c.i();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f40459c.f();
            this.f40462f.e(0L, 64L);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f40459c.g();
        }
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f40459c.h();
            return this.f40459c.b(str);
        }
        return (String) invokeL.objValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40462f.f40467e : invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40462f.k() : invokeV.longValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40462f.o() == this.f40462f.m() : invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                PackageInfo packageInfo = this.f40460d.getPackageManager().getPackageInfo(this.f40457a, 0);
                long j2 = packageInfo.lastUpdateTime;
                int i2 = packageInfo.versionCode;
                this.f40462f.h(j2);
                this.f40462f.d(i2);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40462f.a(12L) == 4 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                packageInfo = this.f40460d.getPackageManager().getPackageInfo(this.f40457a, 0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new HashSet(this.f40462f.p()) : (Set) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                PackageInfo packageInfo = this.f40460d.getPackageManager().getPackageInfo(this.f40457a, 0);
                long j2 = packageInfo.lastUpdateTime;
                int i2 = packageInfo.versionCode;
                if (this.f40462f.i() == j2) {
                    return this.f40462f.g() == i2;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f40462f.r();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f40462f.q() : invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f40458b.c(this.f40457a, this.f40460d);
            this.f40459c.c(this.f40457a, this.f40460d, this.f40461e);
        }
    }
}
