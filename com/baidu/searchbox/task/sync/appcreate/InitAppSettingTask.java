package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ey5;
import com.baidu.tieba.gu5;
import com.baidu.tieba.h9;
import com.baidu.tieba.kh5;
import com.baidu.tieba.pf5;
import com.baidu.tieba.xf5;
/* loaded from: classes4.dex */
public class InitAppSettingTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitAppSetting";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initSettings() {
        long currentTimeMillis = System.currentTimeMillis();
        TbadkCoreApplication.getInst().mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
        ey5.c();
        gu5.b().r(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        loadLcsSwitchStratgy();
        TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
        initSettings();
        TbadkCoreApplication.getInst().initSetting();
        long currentTimeMillis = System.currentTimeMillis();
        pf5.d().q();
        gu5.b().y(System.currentTimeMillis() - currentTimeMillis);
        h9.f().r(20);
        if (ProcessUtils.isMainProcess()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            xf5 xf5Var = new xf5();
            xf5Var.e(loadString);
            kh5 a = kh5.a();
            boolean z = true;
            if (xf5Var.b() != 1) {
                z = false;
            }
            a.i(z);
            a.j(xf5Var.c());
            a.k(xf5Var.d() * 1000);
            if (xf5Var.a() != null) {
                a.l(xf5Var.a());
            }
        }
    }
}
