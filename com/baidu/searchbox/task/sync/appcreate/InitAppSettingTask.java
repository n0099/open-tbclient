package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dp5;
import com.baidu.tieba.fl5;
import com.baidu.tieba.k85;
import com.baidu.tieba.r85;
import com.baidu.tieba.v95;
import com.baidu.tieba.w8;
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
        dp5.c();
        fl5.b().r(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        loadLcsSwitchStratgy();
        TbadkCoreApplication.getInst().initVideoAutoPlay(TbadkSettings.getInst().loadInt("video_auto_play_new", -1));
        initSettings();
        TbadkCoreApplication.getInst().initSetting();
        long currentTimeMillis = System.currentTimeMillis();
        k85.d().q();
        fl5.b().y(System.currentTimeMillis() - currentTimeMillis);
        w8.f().r(20);
        if (ProcessUtils.isMainProcess()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            r85 r85Var = new r85();
            r85Var.e(loadString);
            v95 a = v95.a();
            boolean z = true;
            if (r85Var.b() != 1) {
                z = false;
            }
            a.h(z);
            a.i(r85Var.c());
            a.j(r85Var.d() * 1000);
            if (r85Var.a() != null) {
                a.k(r85Var.a());
            }
        }
    }
}
