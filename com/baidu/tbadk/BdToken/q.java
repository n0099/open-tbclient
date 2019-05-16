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
public class q {
    private long byN;
    private CustomMessageListener byO = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                q.this.YO();
            }
        }
    };
    private r byM = new r();

    public q() {
        MessageManager.getInstance().registerListener(this.byO);
        YO();
        this.byN = com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (YN() && isShowTime()) {
            showWindow();
        }
    }

    private boolean YN() {
        Date date = new Date();
        return date.getTime() >= this.byM.getStartDate() && date.getTime() <= this.byM.YP();
    }

    private boolean isShowTime() {
        if (v.aa(this.byM.YQ())) {
            return false;
        }
        Date date = new Date();
        Iterator<t> it = this.byM.YQ().iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(t tVar) {
        return tVar != null && this.byN >= tVar.getStartTime() && this.byN <= tVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YO() {
        this.byM.parseJson(com.baidu.tbadk.core.sharedPref.b.agM().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ap.isEmpty(this.byM.getUrl())) {
            this.byN = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_redpacket_pop_last_time", this.byN);
            TiebaStatic.log(new am("c13083"));
            String str = this.byM.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
            }
        }
    }
}
