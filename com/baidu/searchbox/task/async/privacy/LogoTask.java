package com.baidu.searchbox.task.async.privacy;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.appsearchlib.NASLib;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i5;
import com.baidu.tieba.rp5;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class LogoTask extends LaunchTask {
    public boolean mIsFirstUse = TbadkCoreApplication.getInst().getIsFirstUse();

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "LogoTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    private void startSwitchDebugService() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new i5(TbadkCoreApplication.getInst())));
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        TbadkCoreApplication.getInst().initTrackConfig();
        TbadkCoreApplication.getInst().onLowMemory();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "start");
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2006002, hashMap));
        if (MessageManager.getInstance().findTask(2010002) != null) {
            startSwitchDebugService();
        }
        if (!FileHelper.checkSD()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(2001345) != null) {
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2001345, new IntentConfig(TbadkCoreApplication.getInst())));
        }
        if (this.mIsFirstUse) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            SharedPrefHelper.getInstance().putBoolean("frs_first_in", true);
        }
        if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
            NASLib.onAppStart(TbadkCoreApplication.getInst());
        }
        rp5.a().y(this.mIsFirstUse);
    }
}
