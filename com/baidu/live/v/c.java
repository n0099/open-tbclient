package com.baidu.live.v;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.o;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c {
    private static volatile c aYW;
    public o aYX;
    private HttpMessageListener aYY = new HttpMessageListener(1021124) { // from class: com.baidu.live.v.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Fs() != null) {
                        c.this.aYX = getQuickGiftHttpResponseMessage.Fs();
                    }
                }
            }
        }
    };

    public static c Gj() {
        if (aYW == null) {
            synchronized (c.class) {
                if (aYW == null) {
                    aYW = new c();
                }
            }
        }
        return aYW;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.aYY);
        this.aYX = new o();
    }

    public void Gk() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String Id = q.Id();
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
            httpMessage.addParam("scene_from", Id);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
