package com.baidu.tbadk.BdToken;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l {
    private long alh;
    private CustomMessageListener ali = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.vP();
            }
        }
    };
    private m alg = new m();

    public l() {
        MessageManager.getInstance().registerListener(this.ali);
        vP();
        this.alh = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (vN() && vO()) {
            showWindow();
        }
    }

    private boolean vN() {
        Date date = new Date();
        return date.getTime() >= this.alg.vQ() && date.getTime() <= this.alg.vR();
    }

    private boolean vO() {
        if (v.I(this.alg.vS())) {
            return false;
        }
        Date date = new Date();
        Iterator<o> it = this.alg.vS().iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(o oVar) {
        return oVar != null && this.alh >= oVar.getStartTime() && this.alh <= oVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP() {
        this.alg.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ao.isEmpty(this.alg.getUrl())) {
            this.alh = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.alh);
            TiebaStatic.log(new am("c13083"));
            String str = this.alg.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
