package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bg5;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.ns5;
import com.baidu.tieba.qe5;
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
        kw5.c();
        ns5.a().q(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        loadLcsSwitchStratgy();
        TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
        initSettings();
        TbadkCoreApplication.getInst().initSetting();
        long currentTimeMillis = System.currentTimeMillis();
        ke5.d().q();
        ns5.a().x(System.currentTimeMillis() - currentTimeMillis);
        BdActivityStack.getInst().setActivityStackMaxSize(20);
        if (ProcessUtils.isMainProcess()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            qe5 qe5Var = new qe5();
            qe5Var.e(loadString);
            bg5 g = bg5.g();
            boolean z = true;
            if (qe5Var.b() != 1) {
                z = false;
            }
            g.o(z);
            g.p(qe5Var.c());
            g.q(qe5Var.d() * 1000);
            if (qe5Var.a() != null) {
                g.r(qe5Var.a());
            }
        }
    }
}
