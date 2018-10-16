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
import com.baidu.tbadk.core.util.v;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private long ahe;
    private TbPageContext mPageContext;
    private CustomMessageListener ahf = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                c.this.uC();
            }
        }
    };
    private d ahd = new d();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.ahf);
        uC();
        this.ahe = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_redpacket_pop_last_time", 0L);
    }

    public void check() {
        if (uA() && uB()) {
            showWindow();
        }
    }

    private boolean uA() {
        Date date = new Date();
        return date.getTime() >= this.ahd.uD() && date.getTime() <= this.ahd.uE();
    }

    private boolean uB() {
        if (v.J(this.ahd.uF())) {
            return false;
        }
        Date date = new Date();
        Iterator<e> it = this.ahd.uF().iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (date.getTime() >= next.getStartTime() && date.getTime() <= next.getEndTime() && !a(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(e eVar) {
        return eVar != null && this.ahe >= eVar.getStartTime() && this.ahe <= eVar.getEndTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        this.ahd.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_redpacket_pop", ""));
    }

    private void showWindow() {
        if (!ao.isEmpty(this.ahd.getUrl())) {
            this.ahe = System.currentTimeMillis();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_redpacket_pop_last_time", this.ahe);
            TiebaStatic.log(new am("c13083"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mPageContext.getPageActivity(), "", this.ahd.getUrl() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ahf);
    }
}
