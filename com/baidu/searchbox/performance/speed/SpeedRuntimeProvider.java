package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.wl1;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class SpeedRuntimeProvider extends wl1<ISpeedContext> {
    public static final String MAIN_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.MainTabActivity";
    public static final String SCHEMA_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.SchemaRouteActivity";
    public static final String SPLASH_ACTIVITY_NAME = "com.baidu.tieba.LogoActivity";

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.wl1
    public ISpeedContext createService() throws ServiceNotFoundException {
        return new ISpeedContext() { // from class: com.baidu.searchbox.performance.speed.SpeedRuntimeProvider.1
            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void checkSendStatisticData() {
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public String getVersionName() {
                return "1.0";
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean hasSkin() {
                return false;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainLine() {
                return true;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchData(HashMap<String, String> hashMap) {
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchTime(boolean z, long j) {
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainActivity(Activity activity) {
                return SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(activity.getClass().getName());
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isPushDispatchActivity(Activity activity) {
                return "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(activity.getClass().getName());
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSchemeDispatchActivity(Activity activity) {
                return "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(activity.getClass().getName());
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSplashActivity(Activity activity) {
                return SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(activity.getClass().getName());
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isAdShowing() {
                return MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isAgreePrivacyPolicy() {
                return PermissionUtil.isAgreePrivacyPolicy();
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainProcess() {
                return TbadkCoreApplication.getInst().isMainProcess(false);
            }
        };
    }
}
