package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nd5;
import com.repackage.py4;
import com.repackage.s95;
import com.repackage.wy4;
import com.repackage.wz4;
import com.repackage.z8;
/* loaded from: classes2.dex */
public class InitAppSettingTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitAppSettingTask() {
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

    private void initSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            TbadkCoreApplication.getInst().mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
            nd5.c();
            s95.b().r(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            loadLcsSwitchStratgy();
            TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
            initSettings();
            TbadkCoreApplication.getInst().initSetting();
            long currentTimeMillis = System.currentTimeMillis();
            py4.d().o();
            s95.b().y(System.currentTimeMillis() - currentTimeMillis);
            z8.g().r(20);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitAppSetting" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void loadLcsSwitchStratgy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
            if (TextUtils.isEmpty(loadString)) {
                return;
            }
            wy4 wy4Var = new wy4();
            wy4Var.e(loadString);
            wz4 a = wz4.a();
            a.g(wy4Var.b() == 1);
            a.h(wy4Var.c());
            a.i(wy4Var.d() * 1000);
            if (wy4Var.a() != null) {
                a.j(wy4Var.a());
            }
        }
    }
}
