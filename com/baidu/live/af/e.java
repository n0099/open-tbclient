package com.baidu.live.af;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.o;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class e {
    private static volatile e bCl;
    public o bCm;
    private HttpMessageListener bCn = new HttpMessageListener(1021124) { // from class: com.baidu.live.af.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.QT() != null) {
                        e.this.bCm = getQuickGiftHttpResponseMessage.QT();
                    }
                }
            }
        }
    };

    public static e ST() {
        if (bCl == null) {
            synchronized (e.class) {
                if (bCl == null) {
                    bCl = new e();
                }
            }
        }
        return bCl;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.bCn);
        this.bCm = new o();
    }

    public void SU() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String XF = q.XF();
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
            httpMessage.addParam("scene_from", XF);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
