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
    private long eHy;
    private CustomMessageListener eHz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.OH();
            }
        }
    };
    private u eHx = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eHz);
        OH();
        this.eHy = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (blV() && isShowTime()) {
            blW();
        }
    }

    private boolean blV() {
        Date date = new Date();
        return date.getTime() >= this.eHx.getStartDate() && date.getTime() <= this.eHx.blX();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.eHx.blY())) {
            return false;
        }
        Date date = new Date();
        Iterator<w> it = this.eHx.blY().iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(w wVar) {
        return wVar != null && this.eHy >= wVar.getStartTime() && this.eHy <= wVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        this.eHx.parseJson(com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_redpacket_pop", ""));
    }

    private void blW() {
        if (!at.isEmpty(this.eHx.getUrl())) {
            this.eHy = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.bvr().putLong("key_redpacket_pop_last_time", this.eHy);
            TiebaStatic.log(new aq("c13083"));
            String str = this.eHx.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
