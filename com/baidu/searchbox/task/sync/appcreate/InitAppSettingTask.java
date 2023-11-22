package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ac5;
import com.baidu.tieba.fa5;
import com.baidu.tieba.jp5;
import com.baidu.tieba.kt5;
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
        kt5.c();
        jp5.a().q(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        loadLcsSwitchStratgy();
        TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
        DefaultLog.getInstance().i(LaunchTask.TAG, "InitAppSettingTask 初始化贴吧数据 视频浏览时自动播放开关的状态默认状态（wifi下自动播放）");
        initSettings();
        TbadkCoreApplication.getInst().initSetting();
        long currentTimeMillis = System.currentTimeMillis();
        aa5.e().r();
        jp5.a().x(System.currentTimeMillis() - currentTimeMillis);
        BdActivityStack.getInst().setActivityStackMaxSize(20);
        if (ProcessUtils.isMainProcess()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            fa5 fa5Var = new fa5();
            fa5Var.e(loadString);
            ac5 g = ac5.g();
            boolean z = true;
            if (fa5Var.b() != 1) {
                z = false;
            }
            g.p(z);
            g.q(fa5Var.c());
            g.r(fa5Var.d() * 1000);
            if (fa5Var.a() != null) {
                g.s(fa5Var.a());
            }
        }
    }
}
