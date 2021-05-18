package com.baidu.mobads.container;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.container.config.AppCommonConfig;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.gray.CloudControlConfig;
import com.baidu.mobads.container.preload.XAdMaterialsLoader;
import com.baidu.mobads.container.util.APKInstallReceiver;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AllInOneXAdContainerFactory implements IXAdContainerFactory {
    public static final String TAG = "AllInOneXAdContainerFactory";
    public static final String TASK_MODULE_PERMISSION = "permission_module";
    public Context mAppCxt;

    public AllInOneXAdContainerFactory(Context context) {
        this.mAppCxt = context.getApplicationContext();
        try {
            AppConfigImp.getInstance().setAppContext(this.mAppCxt);
            registerPackageChangeReciver(this.mAppCxt);
            XAdMaterialsLoader.getInstance().startLoadRemoteSetting(this.mAppCxt);
        } catch (Throwable unused) {
        }
    }

    private void registerPackageChangeReciver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        context.getApplicationContext().registerReceiver(new APKInstallReceiver(), intentFilter);
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public Object getRemoteParam(String str, Object... objArr) {
        try {
            if ("encodedSn".equals(str)) {
                return DeviceUtils.getInstance().getEncodedSN((Context) objArr[0]);
            }
            if ("encodedCUID".equals(str)) {
                return DeviceUtils.getInstance().getEncodedCUID((Context) objArr[0]);
            }
            if ("appsid".equals(str)) {
                return DeviceUtils.getInstance().getAppId(this.mAppCxt);
            }
            if ("appContext".equals(str)) {
                return AppConfigImp.getInstance().getAppContext();
            }
            if ("baidu_cloudConfig".equals(str)) {
                return CloudControlConfig.getInstance(this.mAppCxt).getValueForKey((String) objArr[0]);
            }
            if ("appCommonConfig".equals(str)) {
                return AppCommonConfig.getInstance().getValueForKey((String) objArr[0]);
            }
            return null;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(TAG, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public double getRemoteVersion() {
        return XAdSDKRemoteVersion.getVersion();
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initCommonModuleObj(Object obj) {
        AppConfigImp.getInstance().setModuleObj((ICommonModuleObj) obj);
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initConfig(JSONObject jSONObject) {
        AppConfigImp.getInstance().initSDK(jSONObject);
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void onTaskDistribute(String str, JSONObject jSONObject) {
        if ("permission_module".equals(str)) {
            PermissionUtils.setPermissionInfo(jSONObject);
        }
    }
}
