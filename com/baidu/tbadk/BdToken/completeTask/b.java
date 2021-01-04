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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.g;
/* loaded from: classes.dex */
public class b {
    private h eIw;
    private a mData;

    public void a(a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == a.eHZ) {
                this.eIw = h.b(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData).bum();
            } else if (this.mData.showType == a.eIa) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.c cVar = new com.baidu.tbadk.core.business.c(currentActivity);
                cVar.a(currentActivity, this.mData);
                cVar.show();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                com.baidu.tbadk.core.business.b.boI().putInt("business_count_hint" + currentAccount + this.mData.activityId, com.baidu.tbadk.core.business.b.boI().getInt("business_count_hint" + currentAccount + this.mData.activityId) - 1);
            } else if (this.mData.showType == a.eIb) {
                if (this.mData.eIg == a.eIe) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !at.isEmpty(this.mData.url)) {
                        dealJump(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (this.mData.eIg == a.eIf && !at.isEmpty(this.mData.url)) {
                    dealJump(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                }
            } else if (this.mData.showType == a.eIc && !TextUtils.isEmpty(this.mData.message)) {
                CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
                completeTaskToastData.activityId = this.mData.activityId;
                completeTaskToastData.missionId = this.mData.missionId;
                completeTaskToastData.duration = this.mData.duration;
                completeTaskToastData.message = this.mData.message;
                completeTaskToastData.url = this.mData.url;
                completeTaskToastData.pageId = com.baidu.tbadk.BdToken.c.bkT().bld();
                CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
                competeTaskEvent.taskToastData = completeTaskToastData;
                g.publishEvent(competeTaskEvent);
                c.aI(this.mData.activityId, this.mData.missionId);
            }
        }
    }

    private void dealJump(String str) {
        Activity currentActivity;
        TbPageContext currentActivityPageContext;
        if (!at.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (currentActivityPageContext = getCurrentActivityPageContext(currentActivity)) != null && !StringUtils.isNull(str)) {
            currentActivityPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public void clearData() {
        if (this.eIw != null) {
            this.eIw.hide();
            this.eIw = null;
        }
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
