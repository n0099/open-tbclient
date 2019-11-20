package com.baidu.live.l;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.l;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.o;
/* loaded from: classes6.dex */
public class c {
    private static volatile c akE;
    private HttpMessageListener akC = new HttpMessageListener(1021124) { // from class: com.baidu.live.l.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.us() != null) {
                        c.this.akF = getQuickGiftHttpResponseMessage.us();
                    }
                }
            }
        }
    };
    public l akF;

    public static c uH() {
        if (akE == null) {
            synchronized (c.class) {
                if (akE == null) {
                    akE = new c();
                }
            }
        }
        return akE;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.akC);
        this.akF = new l();
    }

    public void uI() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String wv = o.wv();
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
            httpMessage.addParam("scene_from", wv);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
