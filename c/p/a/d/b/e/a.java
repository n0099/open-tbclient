package c.p.a.d.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.p.a.a.a.c.r;
import c.p.a.d.b.c;
import c.p.a.d.b.g;
import c.p.a.d.b.l;
import c.p.a.d.f;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<Activity> f34544a;

    /* renamed from: c.p.a.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1527a implements h.i.a<Boolean, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f34545a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f34546b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f34547c;

        public C1527a(a aVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34547c = aVar;
            this.f34545a = j2;
            this.f34546b = j3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.p.a.d.h.i.a
        public Object a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f34547c.b(c.C1524c.b(this.f34545a, this.f34546b));
                    c.p.a.d.b.e.b.f("lp_app_dialog_try_show", this.f34546b);
                    return null;
                }
                this.f34547c.i(this.f34546b);
                return null;
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.i.a<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f34548a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f34549b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f34550c;

        /* renamed from: c.p.a.d.b.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1528a implements r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f34551a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f34552b;

            public C1528a(b bVar, boolean[] zArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, zArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34552b = bVar;
                this.f34551a = zArr;
            }

            @Override // c.p.a.a.a.c.r
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    boolean[] zArr = this.f34551a;
                    b bVar = this.f34552b;
                    zArr[0] = bVar.f34550c.d(bVar.f34548a, bVar.f34549b, str);
                }
            }

            @Override // c.p.a.a.a.c.r
            public void a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    c.p.a.d.b.e.b.a(2, this.f34552b.f34549b);
                    this.f34551a[0] = false;
                }
            }
        }

        public b(a aVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34550c = aVar;
            this.f34548a = j2;
            this.f34549b = j3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.p.a.d.h.i.a
        public Boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                boolean[] zArr = {false};
                l.q().a("GET", str, new HashMap(), new C1528a(this, zArr));
                return Boolean.valueOf(zArr[0]);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f34553a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1465330562, "Lc/p/a/d/b/e/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1465330562, "Lc/p/a/d/b/e/a$c;");
                    return;
                }
            }
            f34553a = new a(null);
        }
    }

    public /* synthetic */ a(C1527a c1527a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f34553a : (a) invokeV.objValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            TTDelegateActivity.a(j2);
        }
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.f34544a = new SoftReference<>(activity);
        }
    }

    public final boolean d(long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(AsInstallService.SCHEME_PACKAGE_ADDED);
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    c.C1524c c1524c = new c.C1524c();
                    c1524c.f34490a = j2;
                    c1524c.f34491b = j3;
                    c1524c.f34492c = optJSONObject.optString("icon_url");
                    c1524c.f34493d = optJSONObject.optString("app_name");
                    optJSONObject.optString("package_name");
                    c1524c.f34494e = optJSONObject.optString("version_name");
                    c1524c.f34495f = optJSONObject.optString("developer_name");
                    c1524c.f34497h = optJSONObject.optString("policy_url");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                            c1524c.f34496g.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                        }
                    }
                    com.ss.android.downloadlib.addownload.compliance.c.a().a(c1524c);
                    d.a().a(c1524c.a(), j3, c1524c.f34492c);
                    return true;
                }
                c.p.a.d.b.e.b.a(7, j3);
                return false;
            } catch (Exception e2) {
                f.e.b().a(e2, "AdLpComplianceManager parseResponse");
                c.p.a.d.b.e.b.a(7, j3);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean e(c.p.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (dVar.t() && l.v().optInt("ad_lp_show_app_dialog") != 0) {
                String a2 = dVar.x() == null ? null : dVar.x().a();
                return (TextUtils.isEmpty(a2) || Pattern.compile(l.v().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(a2).matches()) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(@NonNull c.f fVar) {
        InterceptResult invokeL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) {
            if (!TextUtils.isEmpty(fVar.f34513b.u())) {
                try {
                    j2 = h.r.g(new JSONObject(fVar.f34513b.u()), "convert_id");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j2 = 0;
                }
                if (j2 <= 0) {
                    c.p.a.d.b.e.b.b(3, fVar);
                }
                j3 = j2;
            } else {
                c.p.a.d.b.e.b.b(9, fVar);
                f.e.b().d("requestAppInfo getLogExtra null");
                j3 = 0;
            }
            long j4 = fVar.f34512a;
            c.C1524c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(j3, j4);
            if (a2 != null) {
                d.a().a(a2.a(), j4, a2.f34492c);
                b(a2.a());
                c.p.a.d.b.e.b.d("lp_app_dialog_try_show", fVar);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            if (j3 > 0) {
                sb.append("convert_id=");
                sb.append(j3);
            }
            if (!TextUtils.isEmpty(fVar.f34513b.v())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(fVar.f34513b.v());
            }
            if (sb.length() <= 0) {
                c.p.a.d.b.e.b.b(6, fVar);
                return false;
            }
            long j5 = j3;
            h.i.c(new b(this, j5, j4), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).b(new C1527a(this, j5, j4)).d();
            return true;
        }
        return invokeL.booleanValue;
    }

    public Activity h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Activity activity = this.f34544a.get();
            this.f34544a = null;
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            g a2 = c.p.a.d.g.b().a(c.g.e().v(j2).f34513b.a());
            if (a2 != null) {
                a2.r(true, true);
                return;
            }
            c.p.a.d.b.e.b.a(11, j2);
            f.e.b().g("startDownload handler null");
        }
    }

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
