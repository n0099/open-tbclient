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
    private long erh;
    private CustomMessageListener eri = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.bgA();
            }
        }
    };
    private u erg = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eri);
        bgA();
        this.erh = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (bgz() && isShowTime()) {
            bgB();
        }
    }

    private boolean bgz() {
        Date date = new Date();
        return date.getTime() >= this.erg.getStartDate() && date.getTime() <= this.erg.bgC();
    }

    private boolean isShowTime() {
        if (y.isEmpty(this.erg.bgD())) {
            return false;
        }
        Date date = new Date();
        Iterator<w> it = this.erg.bgD().iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(w wVar) {
        return wVar != null && this.erh >= wVar.getStartTime() && this.erh <= wVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgA() {
        this.erg.parseJson(com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_redpacket_pop", ""));
    }

    private void bgB() {
        if (!au.isEmpty(this.erg.getUrl())) {
            this.erh = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong("key_redpacket_pop_last_time", this.erh);
            TiebaStatic.log(new ar("c13083"));
            String str = this.erg.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
