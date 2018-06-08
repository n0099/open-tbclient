package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private long ZV;
    private TbPageContext mPageContext;
    private CustomMessageListener ZW = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                c.this.rE();
            }
        }
    };
    private d ZU = new d();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.ZW);
        rE();
        this.ZV = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (rC() && rD()) {
            showWindow();
        }
    }

    private boolean rC() {
        Date date = new Date();
        return date.getTime() >= this.ZU.rF() && date.getTime() <= this.ZU.rG();
    }

    private boolean rD() {
        if (w.z(this.ZU.rH())) {
            return false;
        }
        Date date = new Date();
        Iterator<e> it = this.ZU.rH().iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(e eVar) {
        return eVar != null && this.ZV >= eVar.getStartTime() && this.ZV <= eVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE() {
        this.ZU.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ao.isEmpty(this.ZU.getUrl())) {
            this.ZV = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.ZV);
            TiebaStatic.log(new am("c13083"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mPageContext.getPageActivity(), "", this.ZU.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ZW);
    }
}
