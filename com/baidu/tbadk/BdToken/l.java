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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l {
    private long brV;
    private CustomMessageListener brW = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.Uu();
            }
        }
    };
    private m brU = new m();

    public l() {
        MessageManager.getInstance().registerListener(this.brW);
        Uu();
        this.brV = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (Us() && Ut()) {
            showWindow();
        }
    }

    private boolean Us() {
        Date date = new Date();
        return date.getTime() >= this.brU.Uv() && date.getTime() <= this.brU.Uw();
    }

    private boolean Ut() {
        if (v.T(this.brU.Ux())) {
            return false;
        }
        Date date = new Date();
        Iterator<p> it = this.brU.Ux().iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(p pVar) {
        return pVar != null && this.brV >= pVar.getStartTime() && this.brV <= pVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        this.brU.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ap.isEmpty(this.brU.getUrl())) {
            this.brV = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.brV);
            TiebaStatic.log(new am("c13083"));
            String str = this.brU.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
