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
import com.repackage.d85;
import com.repackage.ex4;
import com.repackage.ky4;
import com.repackage.lx4;
import com.repackage.x8;
import com.repackage.xb5;
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
            xb5.c();
            d85.b().r(System.currentTimeMillis() - currentTimeMillis);
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
            ex4.d().o();
            d85.b().y(System.currentTimeMillis() - currentTimeMillis);
            x8.g().r(20);
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
            lx4 lx4Var = new lx4();
            lx4Var.e(loadString);
            ky4 a = ky4.a();
            a.g(lx4Var.b() == 1);
            a.h(lx4Var.c());
            a.i(lx4Var.d() * 1000);
            if (lx4Var.a() != null) {
                a.j(lx4Var.a());
            }
        }
    }
}
