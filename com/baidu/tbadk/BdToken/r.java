package com.baidu.tbadk.BdToken;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r {
    private long bzK;
    private CustomMessageListener bzL = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                r.this.ZM();
            }
        }
    };
    private s bzJ = new s();

    public r() {
        MessageManager.getInstance().registerListener(this.bzL);
        ZM();
        this.bzK = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (ZL() && isShowTime()) {
            showWindow();
        }
    }

    private boolean ZL() {
        Date date = new Date();
        return date.getTime() >= this.bzJ.getStartDate() && date.getTime() <= this.bzJ.ZN();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.v.aa(this.bzJ.ZO())) {
            return false;
        }
        Date date = new Date();
        Iterator<u> it = this.bzJ.ZO().iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(u uVar) {
        return uVar != null && this.bzK >= uVar.getStartTime() && this.bzK <= uVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZM() {
        this.bzJ.parseJson(com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!aq.isEmpty(this.bzJ.getUrl())) {
            this.bzK = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_redpacket_pop_last_time", this.bzK);
            TiebaStatic.log(new an("c13083"));
            String str = this.bzJ.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
