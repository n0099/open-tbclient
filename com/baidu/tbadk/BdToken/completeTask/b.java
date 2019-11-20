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
/* loaded from: classes.dex */
public class b {
    private h bSI;
    private a mData;

    public void a(a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == a.bSv) {
                this.bSI = h.b(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData).akX();
            } else if (this.mData.showType == a.bSw) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.b bVar = new com.baidu.tbadk.core.business.b(currentActivity);
                bVar.a(currentActivity, this.mData);
                bVar.show();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                com.baidu.tbadk.core.business.a.agA().putInt("business_count_hint" + currentAccount + this.mData.activityId, com.baidu.tbadk.core.business.a.agA().getInt("business_count_hint" + currentAccount + this.mData.activityId) - 1);
            } else if (this.mData.showType == a.bSx) {
                if (this.mData.bSB == a.bSz) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !aq.isEmpty(this.mData.url)) {
                        lY(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (this.mData.bSB == a.bSA && !aq.isEmpty(this.mData.url)) {
                    lY(this.mData.url + "?page_type=open_full_screen_opacity_web_page");
                }
            } else if (this.mData.showType == a.bSy && !TextUtils.isEmpty(this.mData.message)) {
                CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
                completeTaskToastData.activityId = this.mData.activityId;
                completeTaskToastData.missionId = this.mData.missionId;
                completeTaskToastData.duration = this.mData.duration;
                completeTaskToastData.message = this.mData.message;
                completeTaskToastData.url = this.mData.url;
                completeTaskToastData.pageId = com.baidu.tbadk.BdToken.c.adX().aeb();
                com.baidu.tbadk.n.b.b("broadcast_type_mission_completed", completeTaskToastData);
                c.V(this.mData.activityId, this.mData.missionId);
            }
        }
    }

    private void lY(String str) {
        Activity currentActivity;
        TbPageContext X;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (X = X(currentActivity)) != null && !StringUtils.isNull(str)) {
            X.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public void clearData() {
        if (this.bSI != null) {
            this.bSI.hide();
            this.bSI = null;
        }
    }

    private TbPageContext X(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
