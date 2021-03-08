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
    private long eGv;
    private CustomMessageListener eGw = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                t.this.Mn();
            }
        }
    };
    private u eGu = new u();

    public t() {
        MessageManager.getInstance().registerListener(this.eGw);
        Mn();
        this.eGv = com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (biq() && isShowTime()) {
            bir();
        }
    }

    private boolean biq() {
        Date date = new Date();
        return date.getTime() >= this.eGu.getStartDate() && date.getTime() <= this.eGu.bis();
    }

    private boolean isShowTime() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eGu.bit())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.eGu.bit().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(x xVar) {
        return xVar != null && this.eGv >= xVar.getStartTime() && this.eGv <= xVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        this.eGu.parseJson(com.baidu.tbadk.core.sharedPref.b.brR().getString("key_redpacket_pop", ""));
    }

    private void bir() {
        if (!au.isEmpty(this.eGu.getUrl())) {
            this.eGv = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.brR().putLong("key_redpacket_pop_last_time", this.eGv);
            TiebaStatic.log(new ar("c13083"));
            String str = this.eGu.getUrl() + "?page_type=open_full_screen_opacity_web_page";
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
