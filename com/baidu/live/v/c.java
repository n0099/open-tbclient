package com.baidu.live.v;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.o;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.p;
/* loaded from: classes3.dex */
public class c {
    private static volatile c bec;
    public o bed;
    private HttpMessageListener bee = new HttpMessageListener(1021124) { // from class: com.baidu.live.v.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Gc() != null) {
                        c.this.bed = getQuickGiftHttpResponseMessage.Gc();
                    }
                }
            }
        }
    };

    public static c Hr() {
        if (bec == null) {
            synchronized (c.class) {
                if (bec == null) {
                    bec = new c();
                }
            }
        }
        return bec;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.bee);
        this.bed = new o();
    }

    public void Hs() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String Jq = p.Jq();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                i = 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i = 2;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                i = 3;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                i = 4;
            }
            httpMessage.addParam("from", i);
            httpMessage.addParam("scene_from", Jq);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
