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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private long dBh;
    private CustomMessageListener dBi = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.aNp();
            }
        }
    };
    private u dBg = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.dBi);
        aNp();
        this.dBh = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (aNo() && isShowTime()) {
            aNq();
        }
    }

    private boolean aNo() {
        Date date = new Date();
        return date.getTime() >= this.dBg.getStartDate() && date.getTime() <= this.dBg.aNr();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.w.isEmpty(this.dBg.aNs())) {
            return false;
        }
        Date date = new Date();
        Iterator<w> it = this.dBg.aNs().iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(w wVar) {
        return wVar != null && this.dBh >= wVar.getStartTime() && this.dBh <= wVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNp() {
        this.dBg.parseJson(com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_redpacket_pop", ""));
    }

    private void aNq() {
        if (!ar.isEmpty(this.dBg.getUrl())) {
            this.dBh = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong("key_redpacket_pop_last_time", this.dBh);
            TiebaStatic.log(new ao("c13083"));
            String str = this.dBg.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
