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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private long eyk;
    private CustomMessageListener eyl = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.bjF();
            }
        }
    };
    private u eyj = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eyl);
        bjF();
        this.eyk = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (bjE() && isShowTime()) {
            bjG();
        }
    }

    private boolean bjE() {
        Date date = new Date();
        return date.getTime() >= this.eyj.getStartDate() && date.getTime() <= this.eyj.bjH();
    }

    private boolean isShowTime() {
        if (y.isEmpty(this.eyj.bjI())) {
            return false;
        }
        Date date = new Date();
        Iterator<w> it = this.eyj.bjI().iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(w wVar) {
        return wVar != null && this.eyk >= wVar.getStartTime() && this.eyk <= wVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjF() {
        this.eyj.parseJson(com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_redpacket_pop", ""));
    }

    private void bjG() {
        if (!au.isEmpty(this.eyj.getUrl())) {
            this.eyk = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong("key_redpacket_pop_last_time", this.eyk);
            TiebaStatic.log(new ar("c13083"));
            String str = this.eyj.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
