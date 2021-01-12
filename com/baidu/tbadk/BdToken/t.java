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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private long eCN;
    private CustomMessageListener eCO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.KM();
            }
        }
    };
    private u eCM = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eCO);
        KM();
        this.eCN = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (bib() && isShowTime()) {
            bic();
        }
    }

    private boolean bib() {
        Date date = new Date();
        return date.getTime() >= this.eCM.getStartDate() && date.getTime() <= this.eCM.bid();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.eCM.bie())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.eCM.bie().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(x xVar) {
        return xVar != null && this.eCN >= xVar.getStartTime() && this.eCN <= xVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        this.eCM.parseJson(com.baidu.tbadk.core.sharedPref.b.brx().getString("key_redpacket_pop", ""));
    }

    private void bic() {
        if (!at.isEmpty(this.eCM.getUrl())) {
            this.eCN = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_redpacket_pop_last_time", this.eCN);
            TiebaStatic.log(new aq("c13083"));
            String str = this.eCM.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
