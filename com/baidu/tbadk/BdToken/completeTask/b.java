package com.baidu.tbadk.BdToken.completeTask;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.g;
/* loaded from: classes.dex */
public class b {
    private h cFs;
    private a mData;

    public void a(a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == a.cFf) {
                this.cFs = h.b(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData).aCA();
            } else if (this.mData.showType == a.cFg) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.b bVar = new com.baidu.tbadk.core.business.b(currentActivity);
                bVar.a(currentActivity, this.mData);
                bVar.show();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                com.baidu.tbadk.core.business.a.axK().putInt("business_count_hint" + currentAccount + this.mData.activityId, com.baidu.tbadk.core.business.a.axK().getInt("business_count_hint" + currentAccount + this.mData.activityId) - 1);
            } else if (this.mData.showType == a.cFh) {
                if (this.mData.cFl == a.cFj) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !aq.isEmpty(this.mData.url)) {
                        rp(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (this.mData.cFl == a.cFk && !aq.isEmpty(this.mData.url)) {
                    rp(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                }
            } else if (this.mData.showType == a.cFi && !TextUtils.isEmpty(this.mData.message)) {
                CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
                completeTaskToastData.activityId = this.mData.activityId;
                completeTaskToastData.missionId = this.mData.missionId;
                completeTaskToastData.duration = this.mData.duration;
                completeTaskToastData.message = this.mData.message;
                completeTaskToastData.url = this.mData.url;
                completeTaskToastData.pageId = com.baidu.tbadk.BdToken.c.avj().avn();
                CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
                competeTaskEvent.taskToastData = completeTaskToastData;
                g.publishEvent(competeTaskEvent);
                c.au(this.mData.activityId, this.mData.missionId);
            }
        }
    }

    private void rp(String str) {
        Activity currentActivity;
        TbPageContext r;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (r = r(currentActivity)) != null && !StringUtils.isNull(str)) {
            r.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public void clearData() {
        if (this.cFs != null) {
            this.cFs.hide();
            this.cFs = null;
        }
    }

    private TbPageContext r(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
