package com.baidu.searchbox.task.sync.appcreate;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz4;
import com.repackage.fy4;
import com.repackage.s85;
import com.repackage.x8;
import com.repackage.zx4;
import java.io.IOException;
import java.io.InputStream;
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        AssetManager assets;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            TbadkCoreApplication.getInst().mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
            if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
                if (Build.VERSION.SDK_INT >= 14 && (assets = TbadkCoreApplication.getInst().getContext().getAssets()) != null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = assets.open("webp_test/test.webp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (inputStream != null && BitmapFactory.decodeStream(inputStream) != null) {
                        z = true;
                        if (z) {
                            TiebaStatic.log("LocalWebpUnSupport");
                            TbadkCoreApplication.getInst().mCapableOfWebp = false;
                            i = 6;
                        } else {
                            TbadkCoreApplication.getInst().mCapableOfWebp = true;
                        }
                        TbadkSettings.getInst().saveInt("webp_failure_count", i);
                        TbadkSettings.getInst().saveBoolean("capable_of_webp_format", TbadkCoreApplication.getInst().mCapableOfWebp);
                    }
                }
                z = false;
                if (z) {
                }
                TbadkSettings.getInst().saveInt("webp_failure_count", i);
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", TbadkCoreApplication.getInst().mCapableOfWebp);
            } else {
                TbadkCoreApplication.getInst().mCapableOfWebp = TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false);
            }
            s85.b().r(System.currentTimeMillis() - currentTimeMillis);
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
            zx4.d().n();
            s85.b().y(System.currentTimeMillis() - currentTimeMillis);
            x8.f().q(20);
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
            fy4 fy4Var = new fy4();
            fy4Var.e(loadString);
            bz4 a = bz4.a();
            a.g(fy4Var.b() == 1);
            a.h(fy4Var.c());
            a.i(fy4Var.d() * 1000);
            if (fy4Var.a() != null) {
                a.j(fy4Var.a());
            }
        }
    }
}
