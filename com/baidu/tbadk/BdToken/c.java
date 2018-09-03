package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private long ZD;
    private TbPageContext mPageContext;
    private CustomMessageListener ZE = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                c.this.rm();
            }
        }
    };
    private d ZC = new d();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.ZE);
        rm();
        this.ZD = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (rk() && rl()) {
            showWindow();
        }
    }

    private boolean rk() {
        Date date = new Date();
        return date.getTime() >= this.ZC.rn() && date.getTime() <= this.ZC.ro();
    }

    private boolean rl() {
        if (w.z(this.ZC.rp())) {
            return false;
        }
        Date date = new Date();
        Iterator<e> it = this.ZC.rp().iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(e eVar) {
        return eVar != null && this.ZD >= eVar.getStartTime() && this.ZD <= eVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm() {
        this.ZC.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ap.isEmpty(this.ZC.getUrl())) {
            this.ZD = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.ZD);
            TiebaStatic.log(new an("c13083"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mPageContext.getPageActivity(), "", this.ZC.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ZE);
    }
}
