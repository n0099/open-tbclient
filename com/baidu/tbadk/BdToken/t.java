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
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private long eEU;
    private CustomMessageListener eEV = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.Mk();
            }
        }
    };
    private u eET = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eEV);
        Mk();
        this.eEU = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (bio() && isShowTime()) {
            bip();
        }
    }

    private boolean bio() {
        Date date = new Date();
        return date.getTime() >= this.eET.getStartDate() && date.getTime() <= this.eET.biq();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eET.bir())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.eET.bir().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(x xVar) {
        return xVar != null && this.eEU >= xVar.getStartTime() && this.eEU <= xVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        this.eET.parseJson(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_redpacket_pop", ""));
    }

    private void bip() {
        if (!au.isEmpty(this.eET.getUrl())) {
            this.eEU = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_redpacket_pop_last_time", this.eEU);
            TiebaStatic.log(new ar("c13083"));
            String str = this.eET.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
