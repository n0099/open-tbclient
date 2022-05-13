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
import com.repackage.b9;
import com.repackage.rm;
import com.repackage.yl;
/* loaded from: classes.dex */
public class LoadingActivity extends BdBaseActivity<LoadingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements yl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        /* renamed from: com.baidu.adp.plugin.proxy.activity.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0005a implements rm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Plugin a;
            public final /* synthetic */ a b;

            public C0005a(a aVar, Plugin plugin2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, plugin2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = plugin2;
            }

            @Override // com.repackage.rm
            public void a(Plugin.c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                    Intent intent = new Intent(this.b.a.getIntent());
                    intent.setComponent(new ComponentName(str, this.b.a.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
                    this.a.launchIntent(this.b.a.getPageContext().getContext(), intent);
                    this.b.a.finish();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingActivity;
        }

        @Override // com.repackage.yl
        public void a(String str) {
            Plugin plugin2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (plugin2 = PluginCenter.getInstance().getPlugin(str)) == null) {
                return;
            }
            plugin2.asyncInit(str, new C0005a(this, plugin2));
        }

        @Override // com.repackage.yl
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.a.showToast(PluginCenter.getInstance().getCommonErrorShowText());
            }
        }
    }

    public LoadingActivity() {
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
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.repackage.c9
    public b9<LoadingActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (b9) invokeV.objValue;
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
            PluginPackageManager.p().x(stringExtra, new a(this));
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
