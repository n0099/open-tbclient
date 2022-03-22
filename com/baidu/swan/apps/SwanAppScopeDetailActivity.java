package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.e.c;
import c.a.n0.a.f.e.e;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int INVALID_ANIM = 0;
    public static final String TAG = "ScopeDetailActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public int mEnterAnimWhenFinishing;
    public int mExitAnimWhenFinishing;
    public c mNgWebView;
    public String mUrl;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppScopeDetailActivity a;

        public a(SwanAppScopeDetailActivity swanAppScopeDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppScopeDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppScopeDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.n0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppScopeDetailActivity f28716c;

        public b(SwanAppScopeDetailActivity swanAppScopeDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppScopeDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28716c = swanAppScopeDetailActivity;
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ((TextView) this.f28716c.findViewById(R.id.obfuscated_res_0x7f09202b)).setText(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1866372074, "Lcom/baidu/swan/apps/SwanAppScopeDetailActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1866372074, "Lcom/baidu/swan/apps/SwanAppScopeDetailActivity;");
                return;
            }
        }
        DEBUG = c.a.n0.a.a.a;
    }

    public SwanAppScopeDetailActivity() {
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
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f0902ef).setOnClickListener(new a(this));
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [c.a.n0.a.f.e.c] */
    private void initWebView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        e c2 = c.a.n0.a.s0.a.F0().c(this);
        c2.c0(new b(this));
        this.mNgWebView = c2.u();
        c2.loadUrl(this.mUrl);
        c2.l((FrameLayout) findViewById(R.id.obfuscated_res_0x7f09244c), this.mNgWebView.covertToView());
    }

    private void startExitActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.mEnterAnimWhenFinishing == 0 && this.mExitAnimWhenFinishing == 0) {
                return;
            }
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            startExitActivityAnim();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, c.a.n0.r.a.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            setPendingTransition(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010025);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d07e2);
            n0.a(this);
            parseIntent(getIntent());
            initView();
            initWebView();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            c cVar = this.mNgWebView;
            if (cVar != null) {
                cVar.destroy();
                this.mNgWebView = null;
            }
            this.mUrl = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            parseIntent(intent);
        }
    }

    public void parseIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || intent == null) {
            return;
        }
        this.mUrl = v.h(intent, "url");
        if (DEBUG) {
            Log.d(TAG, "mUrl=" + this.mUrl);
        }
    }

    public void setPendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.mEnterAnimWhenFinishing = i;
            this.mExitAnimWhenFinishing = i2;
        }
    }
}
