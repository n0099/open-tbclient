package com.baidu.searchbox.taskmanager;

import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.async.appcreate.InitAbi64WebViewCompatTask;
import com.baidu.searchbox.task.async.appcreate.InitAccountChangeTask;
import com.baidu.searchbox.task.async.appcreate.InitArTask;
import com.baidu.searchbox.task.async.appcreate.InitDiskTask;
import com.baidu.searchbox.task.async.appcreate.InitEmotionsTask;
import com.baidu.searchbox.task.async.appcreate.InitFHTask;
import com.baidu.searchbox.task.async.appcreate.InitFaceTask;
import com.baidu.searchbox.task.async.appcreate.InitImgLoaderProcTask;
import com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask;
import com.baidu.searchbox.task.async.appcreate.InitLocationTask;
import com.baidu.searchbox.task.async.appcreate.InitPersonalizePageDataTask;
import com.baidu.searchbox.task.async.appcreate.InitSDKAsyncTask;
import com.baidu.searchbox.task.async.appcreate.InitSapiTask;
import com.baidu.searchbox.task.async.appcreate.InitSwanAppTask;
import com.baidu.searchbox.task.async.appcreate.InitSyncSwitchTask;
import com.baidu.searchbox.task.async.appcreate.PermissionUtilTask;
import com.baidu.searchbox.task.async.appcreate.PreInitSwanDataTask;
import com.baidu.searchbox.task.async.appcreate.PreLoadBaiduClass;
import com.baidu.searchbox.task.async.appcreate.PreLoadTiebaClass;
import com.baidu.searchbox.task.async.appcreate.WebViewDataDirectorySuffixTask;
import com.baidu.searchbox.task.async.homeready.ApplicationAsyncTask;
import com.baidu.searchbox.task.async.homeready.GetYYCloudTask;
import com.baidu.searchbox.task.async.homeready.InitCookieTask;
import com.baidu.searchbox.task.async.homeready.InitCyberPlayerTask;
import com.baidu.searchbox.task.async.homeready.InitMaintabFragmentTask;
import com.baidu.searchbox.task.async.homeready.InitSDKIdleTask;
import com.baidu.searchbox.task.async.homeready.InitUnionIDTask;
import com.baidu.searchbox.task.async.homeready.LaunchStatTask;
import com.baidu.searchbox.task.async.homeready.MainTabLoadFinishTask;
import com.baidu.searchbox.task.async.homeready.MaintabAsyncInitTask;
import com.baidu.searchbox.task.async.privacy.AsyncTaskCollector;
import com.baidu.searchbox.task.async.privacy.DeleteApkTask;
import com.baidu.searchbox.task.async.privacy.LaunchWithPrivacyTask;
import com.baidu.searchbox.task.async.privacy.LogoTask;
import com.baidu.searchbox.task.async.privacy.NightPluginTask;
import com.baidu.searchbox.task.sync.appcreate.InitAccountTask;
import com.baidu.searchbox.task.sync.appcreate.InitAdvertDbTask;
import com.baidu.searchbox.task.sync.appcreate.InitAppSettingTask;
import com.baidu.searchbox.task.sync.appcreate.InitAutoRestartDownloadTask;
import com.baidu.searchbox.task.sync.appcreate.InitBDPlayerTask;
import com.baidu.searchbox.task.sync.appcreate.InitBearTask;
import com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask;
import com.baidu.searchbox.task.sync.appcreate.InitCmdRouterAndStaticTask;
import com.baidu.searchbox.task.sync.appcreate.InitDebugTask;
import com.baidu.searchbox.task.sync.appcreate.InitDiskStatTask;
import com.baidu.searchbox.task.sync.appcreate.InitFlutterNpsPluginTask;
import com.baidu.searchbox.task.sync.appcreate.InitGlobalDataTask;
import com.baidu.searchbox.task.sync.appcreate.InitIMSdkTask;
import com.baidu.searchbox.task.sync.appcreate.InitIMTask;
import com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask;
import com.baidu.searchbox.task.sync.appcreate.InitLokiTask;
import com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask;
import com.baidu.searchbox.task.sync.appcreate.InitMutiProcessManagerTask;
import com.baidu.searchbox.task.sync.appcreate.InitPbNetRequestTask;
import com.baidu.searchbox.task.sync.appcreate.InitPrologueAdTask;
import com.baidu.searchbox.task.sync.appcreate.InitSDKTask;
import com.baidu.searchbox.task.sync.appcreate.InitSdkNpsPluginTask;
import com.baidu.searchbox.task.sync.appcreate.InitStatisticTask;
import com.baidu.searchbox.task.sync.appcreate.InitSwanDataTask;
import com.baidu.searchbox.task.sync.appcreate.InitUBCTask;
import com.baidu.searchbox.task.sync.appcreate.InitVersionTask;
import com.baidu.searchbox.task.sync.appcreate.InitViewConfigTask;
import com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask;
import com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask;
import com.baidu.searchbox.task.view.appcreate.InitMonitorTask;
import com.baidu.searchbox.task.view.appcreate.InitWebViewTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PBTaskPool extends BaseTaskPool {
    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> viewOnActivity() {
        return new ArrayList();
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> viewOnAppCreateView() {
        return new ArrayList();
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreateFirst(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            arrayList.add(new InitImgLoaderProcTask());
            arrayList.add(new PreLoadTiebaClass());
            arrayList.add(new WebViewDataDirectorySuffixTask());
            arrayList.add(new InitSyncSwitchTask());
            arrayList.add(new InitFHTask());
            arrayList.add(new InitMutiProcessManagerTask());
        } else if (i == 1) {
            arrayList.add(new InitVersionTask());
            arrayList.add(new InitGlobalDataTask());
            arrayList.add(new InitLokiTask());
            arrayList.add(new InitCmdRouterAndStaticTask());
            arrayList.add(new InitMessageManagerTask());
            arrayList.add(new InitAccountTask());
            arrayList.add(new InitSDKTask());
            arrayList.add(new InitStatisticTask());
            arrayList.add(new InitUBCTask());
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreateSecond(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            arrayList.add(new InitPbNetRequestTask());
            arrayList.add(new InitPersonalizePageDataTask());
            arrayList.add(new InitSapiTask());
            arrayList.add(new InitSDKAsyncTask());
            arrayList.add(new InitFaceTask());
            arrayList.add(new PreInitSwanDataTask());
            arrayList.add(new PreLoadBaiduClass());
            arrayList.add(new InitLocationTask());
            arrayList.add(new InitDiskTask());
            arrayList.add(new InitLaunchAsyncTask());
            arrayList.add(new PermissionUtilTask());
            arrayList.add(new InitAccountChangeTask());
            arrayList.add(new InitArTask());
            arrayList.add(new InitAbi64WebViewCompatTask());
            arrayList.add(new ApplicationAsyncTask());
        } else if (i == 1) {
            arrayList.add(new InitAppSettingTask());
            arrayList.add(new InitViewConfigTask());
            arrayList.add(new InitCertVerifyTask());
            arrayList.add(new InitLaunchSyncTask());
            arrayList.add(new InitWebsocketBaseTask());
            arrayList.add(new InitIMTask());
            arrayList.add(new InitBDPlayerTask());
            arrayList.add(new InitSwanDataTask());
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                arrayList.add(new InitDebugTask());
            }
            arrayList.add(new InitWebViewTask());
        } else if (i == 3) {
            arrayList.add(new InitEmotionsTask());
            arrayList.add(new InitDiskStatTask());
            arrayList.add(new InitFlutterNpsPluginTask());
            arrayList.add(new InitMonitorTask());
            arrayList.add(new InitSdkNpsPluginTask());
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onPrivacyPolicyGranted(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            arrayList.add(new LaunchWithPrivacyTask());
            arrayList.add(new DeleteApkTask());
            arrayList.add(new LogoTask());
            arrayList.add(new InitAdvertDbTask());
            arrayList.addAll(new AsyncTaskCollector().asyncList());
        } else if (i == 1) {
            arrayList.add(new InitSDKWithPrivacyTask());
        } else if (i == 3) {
            arrayList.add(new MainTabLoadFinishTask());
            arrayList.add(new GetYYCloudTask());
            arrayList.add(new InitCookieTask());
            arrayList.add(new InitMaintabFragmentTask());
            arrayList.add(new InitIMSdkTask());
            arrayList.add(new InitUnionIDTask());
            arrayList.add(new MaintabAsyncInitTask());
            arrayList.add(new LaunchStatTask());
            arrayList.add(new InitSDKIdleTask());
            arrayList.add(new NightPluginTask());
            arrayList.add(new InitCyberPlayerTask());
            arrayList.add(new InitSwanAppTask());
            arrayList.add(new InitPrologueAdTask());
            arrayList.add(new InitBearTask());
            arrayList.add(new InitAutoRestartDownloadTask());
        }
        return arrayList;
    }
}
