package b.a.p0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.v2.w;
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
/* loaded from: classes4.dex */
public class b extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f10098d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10099a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10100b;

    /* renamed from: c  reason: collision with root package name */
    public d f10101c;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0540b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f10102e;

        /* renamed from: f  reason: collision with root package name */
        public String f10103f;

        public /* synthetic */ RunnableC0540b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.g.c.a.n().t(this.f10103f);
                b.a.p0.g.c.a.n().l(this.f10102e);
                b.a.p0.g.c.a.n().k();
            }
        }

        public RunnableC0540b(String str, String str2) {
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
            this.f10102e = str;
            this.f10103f = str2;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f10104e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10105f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.g.c.f.a f10106g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f10107h;

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, b.a.p0.g.c.f.a aVar, Activity activity, a aVar2) {
            this(jSONObject, jSONObject2, aVar, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.g.c.a.n().G(this.f10105f);
                b.a.p0.g.c.i.c.a(this.f10104e.optString("packageName"), "installApp", null, null, new b.a.p0.g.c.i.a(this.f10105f));
                b.d(this.f10107h, this.f10104e, this.f10106g);
            }
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull b.a.p0.g.c.f.a aVar, Activity activity) {
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
            this.f10104e = jSONObject;
            this.f10105f = jSONObject2;
            this.f10106g = aVar;
            this.f10107h = activity;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a.p0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10108a;

        /* renamed from: b  reason: collision with root package name */
        public String f10109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10110c;

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
            this.f10110c = bVar;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (b.f10098d) {
                    String str = "onResult mPackageName:" + this.f10108a;
                }
                this.f10110c.setResult(bVar);
                b.a.p0.g.c.c.b.f10058d.execute(new RunnableC0540b(this.f10109b, this.f10108a, null));
            }
        }

        @Override // b.a.p0.g.c.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f10109b = str;
            }
        }

        @Override // b.a.p0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10108a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163718945, "Lb/a/p0/g/c/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163718945, "Lb/a/p0/g/c/e/b;");
                return;
            }
        }
        f10098d = k.f6397a;
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
        this.f10101c = new d(this);
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull b.a.p0.g.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, activity, jSONObject, aVar) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (b.a.p0.g.c.a.n().y(optString) == null && optBoolean) {
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                b.a.p0.h.t.a.c().d(optString, optString2);
                return;
            }
            b.a.p0.g.c.a.n().r(activity, optString, optString2, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(b.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bVar) == null) {
            if (bVar != null) {
                this.mResult.putString("functionType", bVar.a());
                this.mResult.putString("resultData", bVar.b());
                this.mResult.putInt("resultStatus", bVar.c());
                if (!bVar.d()) {
                    b.a.p0.g.c.i.c.a(this.f10099a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new b.a.p0.g.c.i.a(this.f10100b));
                }
            }
            e();
            finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f10101c != null) {
                b.a.p0.g.c.a.n().B(this.f10099a, this.f10101c);
                this.f10101c = null;
            }
            this.f10101c = null;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f10098d) {
                String str = "onAgentDestroy mPackageName:" + this.f10099a;
            }
            e();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f10098d) {
                String str = "onExec mParams" + this.mParams;
            }
            this.f10100b = w.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = w.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.f10099a = optString;
            this.mResult.putString("packageName", optString);
            b.a.p0.g.c.c.b.f10058d.execute(new c(d2, this.f10100b, this.f10101c, getAgent(), null));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f10098d) {
                String str = "onSelfFinish mPackageName:" + this.f10099a;
            }
            b.a.p0.g.c.i.c.a(this.f10099a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new b.a.p0.g.c.i.a(this.f10100b));
            e();
        }
    }
}
