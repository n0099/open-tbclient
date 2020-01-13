package com.baidu.live.s;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.n;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.q;
/* loaded from: classes2.dex */
public class c {
    private static volatile c atu;
    private HttpMessageListener ats = new HttpMessageListener(1021124) { // from class: com.baidu.live.s.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.wE() != null) {
                        c.this.atv = getQuickGiftHttpResponseMessage.wE();
                    }
                }
            }
        }
    };
    public n atv;

    public static c wW() {
        if (atu == null) {
            synchronized (c.class) {
                if (atu == null) {
                    atu = new c();
                }
            }
        }
        return atu;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.ats);
        this.atv = new n();
    }

    public void wX() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String yO = q.yO();
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
            httpMessage.addParam("scene_from", yO);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
