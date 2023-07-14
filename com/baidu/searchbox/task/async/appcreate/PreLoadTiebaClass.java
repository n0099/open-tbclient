package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.bu4;
import com.baidu.tieba.ly5;
import com.baidu.tieba.yi;
/* loaded from: classes4.dex */
public class PreLoadTiebaClass extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "PreLoadTiebaClass";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        TbConfig.getVersion();
        RomTypeUtil.check("EMUI");
        try {
            Class.forName("com.baidu.tieba.im.memorycache.ImMemoryCacheRegister");
        } catch (ClassNotFoundException unused) {
        }
        bu4.w();
        ItemCardHelper.i();
        ly5.b();
        yi.B(TbadkCoreApplication.getInst());
    }
}
