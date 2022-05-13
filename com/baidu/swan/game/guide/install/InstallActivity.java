package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fr3;
import com.repackage.lr3;
import com.repackage.or3;
import com.repackage.pr3;
import com.repackage.ud3;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public WeakReference<Activity> d;

        public /* synthetic */ b(Activity activity, String str, String str2, String str3, a aVar) {
            this(activity, str, str2, str3);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
                return;
            }
            boolean handleInstallApp = InstallActivity.handleInstallApp(this.d, this.a, this.b, this.c);
            Activity activity = this.d.get();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = new WeakReference<>(activity);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, weakReference, str, str2, str3)) == null) ? fr3.t().u(weakReference.get(), str, str2, str3) : invokeLLLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1345431) {
                if (i2 != -1 || TextUtils.isEmpty(this.downloadPackageName)) {
                    if (i2 == 0) {
                        pr3.n().h("installCancel", new or3(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                    } else if (i2 == 1 && intent != null) {
                        pr3.n().g("installFailed", new or3(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022), this.downloadUrl);
                    }
                } else if (lr3.g(AppRuntime.getAppContext(), this.downloadPackageName) && lr3.k(AppRuntime.getAppContext(), this.downloadPackageName)) {
                    pr3.n().h("openAtOnce", new or3(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
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
                this.mUbcParams = ud3.d(extras.getString("ubc_params", ""));
                this.mDownloadParams = extras.getString("download_params");
            }
            sExecutorService.execute(new b(this, this.downloadUrl, this.downloadPackageName, this.mDownloadParams, null));
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.mFallbackFinish) {
                int i = this.mResumeCount + 1;
                this.mResumeCount = i;
                if (i > 1) {
                    if (!lr3.g(AppRuntime.getAppContext(), this.downloadPackageName)) {
                        pr3.n().h("installCancel", new or3(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                    }
                    finish();
                }
            }
        }
    }
}
