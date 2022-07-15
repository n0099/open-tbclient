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
import com.repackage.br3;
import com.repackage.cr3;
import com.repackage.hd3;
import com.repackage.sq3;
import com.repackage.yq3;
import com.sina.weibo.sdk.share.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@SuppressLint({BaseActivity.TAG})
/* loaded from: classes2.dex */
public class InstallActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static ExecutorService g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public String c;
    public String d;
    public JSONObject e;
    public String f;

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
            boolean b = InstallActivity.b(this.d, this.a, this.b, this.c);
            Activity activity = this.d.get();
            if (b || activity == null || activity.isDestroyed() || activity.isFinishing()) {
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
        g = Executors.newSingleThreadExecutor();
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
        this.a = 0;
        this.b = true;
    }

    public static boolean b(WeakReference<Activity> weakReference, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, weakReference, str, str2, str3)) == null) ? sq3.t().u(weakReference.get(), str, str2, str3) : invokeLLLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1345431) {
                if (i2 != -1 || TextUtils.isEmpty(this.d)) {
                    if (i2 == 0) {
                        cr3.n().h("installCancel", new br3(this.e), this.d, this.f, this.c);
                    } else if (i2 == 1 && intent != null) {
                        cr3.n().g("installFailed", new br3(this.e), this.d, this.f, intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022), this.c);
                    }
                } else if (yq3.g(AppRuntime.getAppContext(), this.d) && yq3.k(AppRuntime.getAppContext(), this.d)) {
                    cr3.n().h("openAtOnce", new br3(this.e), this.d, this.f, this.c);
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
                this.c = extras.getString("key_download_url");
                this.d = extras.getString("key_download_package_name");
                this.e = hd3.d(extras.getString("ubc_params", ""));
                this.f = extras.getString("download_params");
            }
            g.execute(new b(this, this.c, this.d, this.f, null));
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.b) {
                int i = this.a + 1;
                this.a = i;
                if (i > 1) {
                    if (!yq3.g(AppRuntime.getAppContext(), this.d)) {
                        cr3.n().h("installCancel", new br3(this.e), this.d, this.f, this.c);
                    }
                    finish();
                }
            }
        }
    }
}
