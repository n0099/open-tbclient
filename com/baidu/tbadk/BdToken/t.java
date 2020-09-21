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
import com.baidu.tbadk.core.util.y;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private long dSv;
    private CustomMessageListener dSw = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.bag();
            }
        }
    };
    private u dSu = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.dSw);
        bag();
        this.dSv = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (baf() && isShowTime()) {
            bah();
        }
    }

    private boolean baf() {
        Date date = new Date();
        return date.getTime() >= this.dSu.getStartDate() && date.getTime() <= this.dSu.bai();
    }

    private boolean isShowTime() {
        if (y.isEmpty(this.dSu.baj())) {
            return false;
        }
        Date date = new Date();
        Iterator<w> it = this.dSu.baj().iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(w wVar) {
        return wVar != null && this.dSv >= wVar.getStartTime() && this.dSv <= wVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        this.dSu.parseJson(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_redpacket_pop", ""));
    }

    private void bah() {
        if (!at.isEmpty(this.dSu.getUrl())) {
            this.dSv = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("key_redpacket_pop_last_time", this.dSv);
            TiebaStatic.log(new aq("c13083"));
            String str = this.dSu.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
