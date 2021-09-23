package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.v2.w;
import c.a.p0.f.j.n.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes6.dex */
public class InstallActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InstallActivity";
    public static ExecutorService sExecutorService;
    public transient /* synthetic */ FieldHolder $fh;
    public String downloadPackageName;
    public String downloadUrl;
    public String mDownloadParams;
    public boolean mFallbackFinish;
    public int mResumeCount;
    public JSONObject mUbcParams;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f47068e;

        /* renamed from: f  reason: collision with root package name */
        public String f47069f;

        /* renamed from: g  reason: collision with root package name */
        public String f47070g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f47071h;

        public /* synthetic */ b(Activity activity, String str, String str2, String str3, a aVar) {
            this(activity, str, str2, str3);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f47068e) || TextUtils.isEmpty(this.f47069f)) {
                return;
            }
            boolean handleInstallApp = InstallActivity.handleInstallApp(this.f47071h, this.f47068e, this.f47069f, this.f47070g);
            Activity activity = this.f47071h.get();
            if (handleInstallApp || activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            activity.finish();
        }

        public b(Activity activity, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47068e = str;
            this.f47069f = str2;
            this.f47070g = str3;
            this.f47071h = new WeakReference<>(activity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1853717189, "Lcom/baidu/swan/game/guide/install/InstallActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1853717189, "Lcom/baidu/swan/game/guide/install/InstallActivity;");
                return;
            }
        }
        sExecutorService = Executors.newSingleThreadExecutor();
    }

    public InstallActivity() {
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
        this.mResumeCount = 0;
        this.mFallbackFinish = true;
    }

    public static boolean handleInstallApp(WeakReference<Activity> weakReference, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, weakReference, str, str2, str3)) == null) ? e.s().t(weakReference.get(), str, str2, str3) : invokeLLLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1345431) {
                if (i3 != -1 || TextUtils.isEmpty(this.downloadPackageName)) {
                    if (i3 == 0) {
                        c.a.p0.f.j.r.b.n().h("installCancel", new c.a.p0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                    } else if (i3 == 1 && intent != null) {
                        c.a.p0.f.j.r.b.n().g("installFailed", new c.a.p0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022), this.downloadUrl);
                    }
                } else if (c.a.p0.f.j.o.a.g(AppRuntime.getAppContext(), this.downloadPackageName) && c.a.p0.f.j.o.a.k(AppRuntime.getAppContext(), this.downloadPackageName)) {
                    c.a.p0.f.j.r.b.n().h("openAtOnce", new c.a.p0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.downloadUrl = extras.getString("key_download_url");
                this.downloadPackageName = extras.getString("key_download_package_name");
                this.mUbcParams = w.d(extras.getString("ubc_params", ""));
                this.mDownloadParams = extras.getString("download_params");
            }
            sExecutorService.execute(new b(this, this.downloadUrl, this.downloadPackageName, this.mDownloadParams, null));
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.mFallbackFinish) {
                int i2 = this.mResumeCount + 1;
                this.mResumeCount = i2;
                if (i2 > 1) {
                    if (!c.a.p0.f.j.o.a.g(AppRuntime.getAppContext(), this.downloadPackageName)) {
                        c.a.p0.f.j.r.b.n().h("installCancel", new c.a.p0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                    }
                    finish();
                }
            }
        }
    }
}
