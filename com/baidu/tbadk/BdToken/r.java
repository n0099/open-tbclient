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
    private long cIO;
    private CustomMessageListener cIP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                r.this.aye();
            }
        }
    };
    private s cIN = new s();

    public r() {
        MessageManager.getInstance().registerListener(this.cIP);
        aye();
        this.cIO = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (ayd() && isShowTime()) {
            ayf();
        }
    }

    private boolean ayd() {
        Date date = new Date();
        return date.getTime() >= this.cIN.getStartDate() && date.getTime() <= this.cIN.ayg();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cIN.ayh())) {
            return false;
        }
        Date date = new Date();
        Iterator<u> it = this.cIN.ayh().iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(u uVar) {
        return uVar != null && this.cIO >= uVar.getStartTime() && this.cIO <= uVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aye() {
        this.cIN.parseJson(com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_redpacket_pop", ""));
    }

    private void ayf() {
        if (!aq.isEmpty(this.cIN.getUrl())) {
            this.cIO = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong("key_redpacket_pop_last_time", this.cIO);
            TiebaStatic.log(new an("c13083"));
            String str = this.cIN.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
