package c.a.p0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import c.a.p0.a.v2.w;
import com.alipay.sdk.util.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f10884d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10885a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10886b;

    /* renamed from: c  reason: collision with root package name */
    public d f10887c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0545b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f10888e;

        /* renamed from: f  reason: collision with root package name */
        public String f10889f;

        public /* synthetic */ RunnableC0545b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.g.c.a.n().t(this.f10889f);
                c.a.p0.g.c.a.n().l(this.f10888e);
                c.a.p0.g.c.a.n().k();
            }
        }

        public RunnableC0545b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10888e = str;
            this.f10889f = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f10890e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10891f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.p0.g.c.f.a f10892g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f10893h;

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, c.a.p0.g.c.f.a aVar, Activity activity, a aVar2) {
            this(jSONObject, jSONObject2, aVar, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.g.c.a.n().G(this.f10891f);
                c.a.p0.g.c.i.c.a(this.f10890e.optString("packageName"), "installApp", null, null, new c.a.p0.g.c.i.a(this.f10891f));
                b.d(this.f10893h, this.f10890e, this.f10892g);
            }
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull c.a.p0.g.c.f.a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONObject2, aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10890e = jSONObject;
            this.f10891f = jSONObject2;
            this.f10892g = aVar;
            this.f10893h = activity;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10894a;

        /* renamed from: b  reason: collision with root package name */
        public String f10895b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10896c;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10896c = bVar;
        }

        @Override // c.a.p0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10895b = str;
            }
        }

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (b.f10884d) {
                    String str = "onResult mPackageName:" + this.f10894a;
                }
                this.f10896c.f(bVar);
                c.a.p0.g.c.c.b.f10844d.execute(new RunnableC0545b(this.f10895b, this.f10894a, null));
            }
        }

        @Override // c.a.p0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10894a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343832864, "Lc/a/p0/g/c/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343832864, "Lc/a/p0/g/c/e/b;");
                return;
            }
        }
        f10884d = k.f7077a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10887c = new d(this);
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull c.a.p0.g.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, activity, jSONObject, aVar) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (c.a.p0.g.c.a.n().y(optString) == null && optBoolean) {
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                c.a.p0.h.t.a.c().d(optString, optString2);
                return;
            }
            c.a.p0.g.c.a.n().r(activity, optString, optString2, aVar);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f10887c != null) {
                c.a.p0.g.c.a.n().B(this.f10885a, this.f10887c);
                this.f10887c = null;
            }
            this.f10887c = null;
        }
    }

    public final void f(c.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (bVar != null) {
                this.mResult.putString("functionType", bVar.a());
                this.mResult.putString("resultData", bVar.b());
                this.mResult.putInt(i.f36094a, bVar.c());
                if (!bVar.d()) {
                    c.a.p0.g.c.i.c.a(this.f10885a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.p0.g.c.i.a(this.f10886b));
                }
            }
            e();
            finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f10884d) {
                String str = "onAgentDestroy mPackageName:" + this.f10885a;
            }
            e();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f10884d) {
                String str = "onExec mParams" + this.mParams;
            }
            this.f10886b = w.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = w.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.f10885a = optString;
            this.mResult.putString("packageName", optString);
            c.a.p0.g.c.c.b.f10844d.execute(new c(d2, this.f10886b, this.f10887c, getAgent(), null));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10884d) {
                String str = "onSelfFinish mPackageName:" + this.f10885a;
            }
            c.a.p0.g.c.i.c.a(this.f10885a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new c.a.p0.g.c.i.a(this.f10886b));
            e();
        }
    }
}
