package com.baidu.live.x;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.o;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bqQ;
    public o bqR;
    private HttpMessageListener bqS = new HttpMessageListener(1021124) { // from class: com.baidu.live.x.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Nq() != null) {
                        c.this.bqR = getQuickGiftHttpResponseMessage.Nq();
                    }
                }
            }
        }
    };

    public static c OX() {
        if (bqQ == null) {
            synchronized (c.class) {
                if (bqQ == null) {
                    bqQ = new c();
                }
            }
        }
        return bqQ;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.bqS);
        this.bqR = new o();
    }

    public void OY() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String QW = p.QW();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                i = 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i = 2;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                i = 3;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                i = 4;
            } else if (TbadkCoreApplication.getInst().isYinbo()) {
                i = 6;
            }
            httpMessage.addParam("from", i);
            httpMessage.addParam("scene_from", QW);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
