package com.baidu.searchbox.task.sync.appcreate;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import c.a.d.a.b;
import c.a.t0.s0.l;
import c.a.t0.t.d.d;
import c.a.t0.t.j.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class InitAppSettingTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitAppSettingTask() {
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        AssetManager assets;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            TbadkCoreApplication.getInst().mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
            if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
                if (Build.VERSION.SDK_INT >= 14 && (assets = TbadkCoreApplication.getInst().getContext().getAssets()) != null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = assets.open("webp_test/test.webp");
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (inputStream != null && BitmapFactory.decodeStream(inputStream) != null) {
                        z = true;
                        if (z) {
                            TbadkCoreApplication.getInst().mCapableOfWebp = false;
                            i2 = 6;
                        } else {
                            TbadkCoreApplication.getInst().mCapableOfWebp = true;
                        }
                        TbadkSettings.getInst().saveInt("webp_failure_count", i2);
                        TbadkSettings.getInst().saveBoolean("capable_of_webp_format", TbadkCoreApplication.getInst().mCapableOfWebp);
                    }
                }
                z = false;
                if (z) {
                }
                TbadkSettings.getInst().saveInt("webp_failure_count", i2);
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", TbadkCoreApplication.getInst().mCapableOfWebp);
            } else {
                TbadkCoreApplication.getInst().mCapableOfWebp = TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false);
            }
            l.b().r(System.currentTimeMillis() - currentTimeMillis);
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
            d.d().n();
            l.b().z(System.currentTimeMillis() - currentTimeMillis);
            b.f().q(20);
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
            c.a.t0.t.e.d dVar = new c.a.t0.t.e.d();
            dVar.e(loadString);
            c a = c.a();
            a.g(dVar.b() == 1);
            a.h(dVar.c());
            a.i(dVar.d() * 1000);
            if (dVar.a() != null) {
                a.j(dVar.a());
            }
        }
    }
}
