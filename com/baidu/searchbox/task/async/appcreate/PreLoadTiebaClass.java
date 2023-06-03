package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.eu4;
import com.baidu.tieba.vi;
import com.baidu.tieba.vw5;
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
        eu4.w();
        ItemCardHelper.i();
        vw5.b();
        vi.A(TbadkCoreApplication.getInst());
    }
}
