package com.baidu.searchbox.task.view.mainactivity;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.cn5;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
/* loaded from: classes4.dex */
public class InitAdCardViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitAdCardView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
        if (mainActivity instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) mainActivity).getPageContext();
        } else {
            tbPageContext = null;
        }
        if (tbPageContext == null) {
            return;
        }
        try {
            AdCardSinglePicView adCardSinglePicView = new AdCardSinglePicView(tbPageContext);
            adCardSinglePicView.f0();
            cn5.e().a(1101, adCardSinglePicView);
        } catch (Exception e) {
            BdLog.e(e);
        }
        try {
            AdCardMultiPicView adCardMultiPicView = new AdCardMultiPicView(tbPageContext);
            adCardMultiPicView.f0();
            cn5.e().a(1102, adCardMultiPicView);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        try {
            AdCardVideoView adCardVideoView = new AdCardVideoView(tbPageContext, 2);
            adCardVideoView.f0();
            cn5.e().a(PackageInfo.CODE_HOST_VERSION, adCardVideoView);
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }
}
