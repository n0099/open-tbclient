package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.h.g.b;
import d.a.c.h.k.c;
/* loaded from: classes.dex */
public class LoadingActivity extends BdBaseActivity<LoadingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoadingActivity f2256a;

        /* renamed from: com.baidu.adp.plugin.proxy.activity.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0022a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Plugin f2257a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f2258b;

            public C0022a(a aVar, Plugin plugin2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, plugin2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2258b = aVar;
                this.f2257a = plugin2;
            }

            @Override // d.a.c.h.k.c
            public void a(Plugin.c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                    Intent intent = new Intent(this.f2258b.f2256a.getIntent());
                    intent.setComponent(new ComponentName(str, this.f2258b.f2256a.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
                    this.f2257a.launchIntent(this.f2258b.f2256a.getPageContext().getContext(), intent);
                    this.f2258b.f2256a.finish();
                }
            }
        }

        public a(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2256a = loadingActivity;
        }

        @Override // d.a.c.h.g.b
        public void a(String str) {
            Plugin plugin2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (plugin2 = PluginCenter.getInstance().getPlugin(str)) == null) {
                return;
            }
            plugin2.asyncInit(str, new C0022a(this, plugin2));
        }

        @Override // d.a.c.h.g.b
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.f2256a.showToast(PluginCenter.getInstance().getCommonErrorShowText());
            }
        }
    }

    public LoadingActivity() {
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

    private void initLoadingView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                LinearLayout linearLayout = new LinearLayout(getPageContext().getPageActivity());
                linearLayout.setGravity(17);
                ProgressBar progressBar = new ProgressBar(getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                linearLayout.addView(progressBar, layoutParams);
                setContentView(linearLayout);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, d.a.c.a.g
    public f<LoadingActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            String stringExtra = getIntent().getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                return;
            }
            initLoadingView(stringExtra);
            PluginPackageManager.O().o0(stringExtra, new a(this));
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
