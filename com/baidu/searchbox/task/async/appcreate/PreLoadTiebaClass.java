package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.hx5;
import com.baidu.tieba.iu4;
import com.baidu.tieba.xi;
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
        iu4.w();
        ItemCardHelper.i();
        hx5.b();
        xi.A(TbadkCoreApplication.getInst());
    }
}
