package com.baidu.searchbox.taskmanager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.async.appcreate.InitAbi64WebViewCompatTask;
import com.baidu.searchbox.task.async.appcreate.InitAccountChangeTask;
import com.baidu.searchbox.task.async.appcreate.InitAppSettingTask;
import com.baidu.searchbox.task.async.appcreate.InitArTask;
import com.baidu.searchbox.task.async.appcreate.InitCyberPlayerTask;
import com.baidu.searchbox.task.async.appcreate.InitDiskTask;
import com.baidu.searchbox.task.async.appcreate.InitFHTask;
import com.baidu.searchbox.task.async.appcreate.InitFaceTask;
import com.baidu.searchbox.task.async.appcreate.InitImgLoaderProcTask;
import com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask;
import com.baidu.searchbox.task.async.appcreate.InitLocationTask;
import com.baidu.searchbox.task.async.appcreate.InitPersonalizePageDataTask;
import com.baidu.searchbox.task.async.appcreate.InitPrologueAdTask;
import com.baidu.searchbox.task.async.appcreate.InitSDKAsyncTask;
import com.baidu.searchbox.task.async.appcreate.InitSapiTask;
import com.baidu.searchbox.task.async.appcreate.InitSyncSwitchTask;
import com.baidu.searchbox.task.async.appcreate.InitTbCrashTask;
import com.baidu.searchbox.task.async.appcreate.InitViewConfigTask;
import com.baidu.searchbox.task.async.appcreate.PermissionUtilTask;
import com.baidu.searchbox.task.async.appcreate.PreInitSwanDataTask;
import com.baidu.searchbox.task.async.appcreate.PreLoadBaiduClass;
import com.baidu.searchbox.task.async.appcreate.PreLoadTiebaClass;
import com.baidu.searchbox.task.async.appcreate.WebViewDataDirectorySuffixTask;
import com.baidu.searchbox.task.async.homeready.CheckRepackagingTask;
import com.baidu.searchbox.task.async.homeready.LaunchStatTask;
import com.baidu.searchbox.task.async.homeready.MainTabLoadFinishTask;
import com.baidu.searchbox.task.async.privacy.DeleteApkTask;
import com.baidu.searchbox.task.async.privacy.LaunchWithPrivacyTask;
import com.baidu.searchbox.task.async.privacy.LogoTask;
import com.baidu.searchbox.task.async.privacy.NightPluginTask;
import com.baidu.searchbox.task.sync.appcreate.InitAccountTask;
import com.baidu.searchbox.task.sync.appcreate.InitBDPlayerTask;
import com.baidu.searchbox.task.sync.appcreate.InitBearTask;
import com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask;
import com.baidu.searchbox.task.sync.appcreate.InitCmdRouterAndStaticTask;
import com.baidu.searchbox.task.sync.appcreate.InitDebugTask;
import com.baidu.searchbox.task.sync.appcreate.InitDiskStatTask;
import com.baidu.searchbox.task.sync.appcreate.InitGlobalDataTask;
import com.baidu.searchbox.task.sync.appcreate.InitIMTask;
import com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask;
import com.baidu.searchbox.task.sync.appcreate.InitLokiTask;
import com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask;
import com.baidu.searchbox.task.sync.appcreate.InitMutiProcessManagerTask;
import com.baidu.searchbox.task.sync.appcreate.InitSDKTask;
import com.baidu.searchbox.task.sync.appcreate.InitStatisticTask;
import com.baidu.searchbox.task.sync.appcreate.InitSwanDataTask;
import com.baidu.searchbox.task.sync.appcreate.InitUBCTask;
import com.baidu.searchbox.task.sync.appcreate.InitVersionTask;
import com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask;
import com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask;
import com.baidu.searchbox.task.sync.privacy.SyncAccountTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.LaunchUpNightSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class ApplicationTaskPool extends BaseTaskPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ApplicationTaskPool() {
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

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreateFirst(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 2) {
                arrayList.add(new InitImgLoaderProcTask());
                arrayList.add(new PreLoadTiebaClass());
                arrayList.add(new WebViewDataDirectorySuffixTask());
                arrayList.add(new InitSyncSwitchTask());
                arrayList.add(new InitFHTask());
            } else if (i2 == 1) {
                arrayList.add(new InitVersionTask());
                arrayList.add(new InitGlobalDataTask());
                arrayList.add(new InitLokiTask());
                arrayList.add(new InitPrologueAdTask());
                arrayList.add(new InitCmdRouterAndStaticTask());
                arrayList.add(new InitMutiProcessManagerTask());
                arrayList.add(new InitMessageManagerTask());
                arrayList.add(new InitAccountTask());
                arrayList.add(new InitSDKTask());
                arrayList.add(new InitStatisticTask());
                arrayList.add(new InitDiskStatTask());
                arrayList.add(new InitUBCTask());
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreateSecond(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 2) {
                arrayList.add(new InitPersonalizePageDataTask());
                arrayList.add(new InitSapiTask());
                arrayList.add(new InitSDKAsyncTask());
                arrayList.add(new PreInitSwanDataTask());
                arrayList.add(new PreLoadBaiduClass());
                arrayList.add(new InitLocationTask());
                arrayList.add(new InitDiskTask());
                arrayList.add(new InitFaceTask());
                arrayList.add(new InitLaunchAsyncTask());
                arrayList.add(new PermissionUtilTask());
                arrayList.add(new InitAccountChangeTask());
                arrayList.add(new InitArTask());
                arrayList.add(new InitAbi64WebViewCompatTask());
            } else if (i2 == 1) {
                arrayList.add(new InitAppSettingTask());
                arrayList.add(new InitViewConfigTask());
                arrayList.add(new InitBearTask());
                arrayList.add(new InitCertVerifyTask());
                arrayList.add(new InitLaunchSyncTask());
                arrayList.add(new InitWebsocketBaseTask());
                arrayList.add(new InitIMTask());
                arrayList.add(new InitBDPlayerTask());
                arrayList.add(new InitSwanDataTask());
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    arrayList.add(new InitDebugTask());
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onPrivacyPolicyGranted(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 2) {
                arrayList.add(new LaunchWithPrivacyTask());
                if (LaunchUpNightSwitch.getIsOn()) {
                    arrayList.add(new DeleteApkTask());
                    arrayList.add(new NightPluginTask());
                    arrayList.add(new LogoTask());
                }
            } else if (i2 == 1) {
                arrayList.add(new InitSDKWithPrivacyTask());
                if (LaunchUpNightSwitch.getIsOn()) {
                    arrayList.add(new SyncAccountTask());
                }
            } else if (i2 == 3) {
                arrayList.add(new MainTabLoadFinishTask());
                arrayList.add(new LaunchStatTask());
                arrayList.add(new InitTbCrashTask());
                arrayList.add(new CheckRepackagingTask());
                arrayList.add(new InitCyberPlayerTask());
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
