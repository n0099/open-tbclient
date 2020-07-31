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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.g;
/* loaded from: classes.dex */
public class b {
    private h dHN;
    private a mData;

    public void a(a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == a.dHA) {
                this.dHN = h.b(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData).aYX();
            } else if (this.mData.showType == a.dHB) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.b bVar = new com.baidu.tbadk.core.business.b(currentActivity);
                bVar.a(currentActivity, this.mData);
                bVar.show();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                com.baidu.tbadk.core.business.a.aTH().putInt("business_count_hint" + currentAccount + this.mData.activityId, com.baidu.tbadk.core.business.a.aTH().getInt("business_count_hint" + currentAccount + this.mData.activityId) - 1);
            } else if (this.mData.showType == a.dHC) {
                if (this.mData.dHG == a.dHE) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !as.isEmpty(this.mData.url)) {
                        vK(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (this.mData.dHG == a.dHF && !as.isEmpty(this.mData.url)) {
                    vK(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                }
            } else if (this.mData.showType == a.dHD && !TextUtils.isEmpty(this.mData.message)) {
                CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
                completeTaskToastData.activityId = this.mData.activityId;
                completeTaskToastData.missionId = this.mData.missionId;
                completeTaskToastData.duration = this.mData.duration;
                completeTaskToastData.message = this.mData.message;
                completeTaskToastData.url = this.mData.url;
                completeTaskToastData.pageId = com.baidu.tbadk.BdToken.c.aQc().aQl();
                CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
                competeTaskEvent.taskToastData = completeTaskToastData;
                g.publishEvent(competeTaskEvent);
                c.aC(this.mData.activityId, this.mData.missionId);
            }
        }
    }

    private void vK(String str) {
        Activity currentActivity;
        TbPageContext o;
        if (!as.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (o = o(currentActivity)) != null && !StringUtils.isNull(str)) {
            o.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public void clearData() {
        if (this.dHN != null) {
            this.dHN.hide();
            this.dHN = null;
        }
    }

    private TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
