package com.baidu.searchbox.task.async.privacy;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.switchs.FixNpsAnrSwitch;
import com.baidu.tieba.r95;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
/* loaded from: classes4.dex */
public class NightPluginTask extends LaunchTask {
    public BdUniqueId tag = BdUniqueId.gen();
    public final CustomMessageListener mNightInstallListener = new CustomMessageListener(2921608) { // from class: com.baidu.searchbox.task.async.privacy.NightPluginTask.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt == 1) {
                TbadkCoreApplication.getInst().setSkinTypeValue(4);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
            } else if (r95.p().l("key_is_follow_system_mode", false)) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(loadInt)));
        }
    };

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_NightPluginTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        this.mNightInstallListener.setTag(this.tag);
        MessageManager.getInstance().registerListener(this.mNightInstallListener);
        if (PermissionUtil.isBrowseMode()) {
            MessageManager.getInstance().runTask(2001281, String.class);
        } else if (FixNpsAnrSwitch.getIsOn() && xi.q() > 1) {
            yg.a().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.async.privacy.NightPluginTask.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().runTask(2001281, String.class);
                }
            }, 20000L);
        } else {
            MessageManager.getInstance().runTask(2001281, String.class);
        }
    }
}
