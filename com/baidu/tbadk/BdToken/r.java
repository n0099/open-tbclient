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
    private long bAi;
    private CustomMessageListener bAj = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                r.this.ZQ();
            }
        }
    };
    private s bAh = new s();

    public r() {
        MessageManager.getInstance().registerListener(this.bAj);
        ZQ();
        this.bAi = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (ZP() && isShowTime()) {
            showWindow();
        }
    }

    private boolean ZP() {
        Date date = new Date();
        return date.getTime() >= this.bAh.getStartDate() && date.getTime() <= this.bAh.ZR();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.v.aa(this.bAh.ZS())) {
            return false;
        }
        Date date = new Date();
        Iterator<u> it = this.bAh.ZS().iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(u uVar) {
        return uVar != null && this.bAi >= uVar.getStartTime() && this.bAi <= uVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZQ() {
        this.bAh.parseJson(com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!aq.isEmpty(this.bAh.getUrl())) {
            this.bAi = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_redpacket_pop_last_time", this.bAi);
            TiebaStatic.log(new an("c13083"));
            String str = this.bAh.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
