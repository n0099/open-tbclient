package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vl;
/* loaded from: classes.dex */
public class ThirdFragmentActivityProxy extends FragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdFragmentActivityProxy() {
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

    @Override // com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy
    public void loadEntityActivity() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mEntity == null && !super.isFinishing()) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_ACTIVITY);
                if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                    Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                    PluginBaseThirdFragmentActivity pluginBaseThirdFragmentActivity = (PluginBaseThirdFragmentActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                    this.mEntity = pluginBaseThirdFragmentActivity;
                    pluginBaseThirdFragmentActivity.setActivityProxy((vl) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                    setTheme(plugin2.getActivityThemeResource());
                } else {
                    PluginBaseThirdFragmentActivity pluginBaseThirdFragmentActivity2 = (PluginBaseThirdFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                    this.mEntity = pluginBaseThirdFragmentActivity2;
                    pluginBaseThirdFragmentActivity2.setActivityProxy((vl) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                }
            } catch (ClassNotFoundException e) {
                BdLog.e(e);
            } catch (IllegalAccessException e2) {
                BdLog.e(e2);
            } catch (InstantiationException e3) {
                BdLog.e(e3);
            } catch (Exception e4) {
                BdLog.e(e4);
            }
        }
    }
}
