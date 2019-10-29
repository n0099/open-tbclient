package com.baidu.tbadk.BdToken;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r {
    private long bSO;
    private CustomMessageListener bSP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                r.this.aeF();
            }
        }
    };
    private s bSN = new s();

    public r() {
        MessageManager.getInstance().registerListener(this.bSP);
        aeF();
        this.bSO = com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (aeE() && isShowTime()) {
            aeG();
        }
    }

    private boolean aeE() {
        Date date = new Date();
        return date.getTime() >= this.bSN.getStartDate() && date.getTime() <= this.bSN.aeH();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.bSN.aeI())) {
            return false;
        }
        Date date = new Date();
        Iterator<u> it = this.bSN.aeI().iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(u uVar) {
        return uVar != null && this.bSO >= uVar.getStartTime() && this.bSO <= uVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeF() {
        this.bSN.parseJson(com.baidu.tbadk.core.sharedPref.b.alR().getString("key_redpacket_pop", ""));
    }

    private void aeG() {
        if (!aq.isEmpty(this.bSN.getUrl())) {
            this.bSO = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.alR().putLong("key_redpacket_pop_last_time", this.bSO);
            TiebaStatic.log(new an("c13083"));
            String str = this.bSN.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
