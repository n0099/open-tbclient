package com.baidu.live.aa;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.n;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class e {
    private static volatile e bud;
    public n bue;
    private HttpMessageListener bug = new HttpMessageListener(1021124) { // from class: com.baidu.live.aa.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ok() != null) {
                        e.this.bue = getQuickGiftHttpResponseMessage.Ok();
                    }
                }
            }
        }
    };

    public static e Qe() {
        if (bud == null) {
            synchronized (e.class) {
                if (bud == null) {
                    bud = new e();
                }
            }
        }
        return bud;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.bug);
        this.bue = new n();
    }

    public void Qf() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021124);
            int i = 0;
            String UK = p.UK();
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
            httpMessage.addParam("scene_from", UK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
