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
    private long brW;
    private CustomMessageListener brX = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.Uu();
            }
        }
    };
    private m brV = new m();

    public l() {
        MessageManager.getInstance().registerListener(this.brX);
        Uu();
        this.brW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (Us() && Ut()) {
            showWindow();
        }
    }

    private boolean Us() {
        Date date = new Date();
        return date.getTime() >= this.brV.Uv() && date.getTime() <= this.brV.Uw();
    }

    private boolean Ut() {
        if (v.T(this.brV.Ux())) {
            return false;
        }
        Date date = new Date();
        Iterator<p> it = this.brV.Ux().iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(p pVar) {
        return pVar != null && this.brW >= pVar.getStartTime() && this.brW <= pVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        this.brV.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ap.isEmpty(this.brV.getUrl())) {
            this.brW = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.brW);
            TiebaStatic.log(new am("c13083"));
            String str = this.brV.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
