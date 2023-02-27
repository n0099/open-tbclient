package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.fa5;
import com.baidu.tieba.gq5;
import com.baidu.tieba.im5;
import com.baidu.tieba.jb5;
import com.baidu.tieba.t9;
import com.baidu.tieba.y95;
/* loaded from: classes2.dex */
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
        gq5.c();
        im5.b().r(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        loadLcsSwitchStratgy();
        TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
        initSettings();
        TbadkCoreApplication.getInst().initSetting();
        long currentTimeMillis = System.currentTimeMillis();
        y95.d().q();
        im5.b().y(System.currentTimeMillis() - currentTimeMillis);
        t9.f().r(20);
        if (ProcessUtils.isMainProcess() && LooperBlockSwitch.getIsOn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            fa5 fa5Var = new fa5();
            fa5Var.e(loadString);
            jb5 a = jb5.a();
            boolean z = true;
            if (fa5Var.b() != 1) {
                z = false;
            }
            a.h(z);
            a.i(fa5Var.c());
            a.j(fa5Var.d() * 1000);
            if (fa5Var.a() != null) {
                a.k(fa5Var.a());
            }
        }
    }
}
