package com.baidu.live.j;

import android.os.Handler;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.message.AlaGiftRefreshScoresHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class c extends BdBaseModel {
    private com.baidu.live.d asL;
    private Handler handler = new Handler();
    private HttpMessageListener asM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.live.j.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    x wy = alaGiftRefreshScoresHttpResponseMessage.wy();
                    TbadkCoreApplication.getInst().currentAccountTdouNum = wy.mTDouScores;
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = wy.mPetalTotal;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                }
                if (c.this.asL != null) {
                    c.this.handler.post(new Runnable() { // from class: com.baidu.live.j.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.asL.oK();
                        }
                    });
                }
            }
        }
    };

    public void initListener() {
        registerListener(this.asM);
    }

    public void a(com.baidu.live.d dVar) {
        this.asL = dVar;
    }

    public boolean refreshCurUserScores() {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.asM);
        this.handler.removeCallbacksAndMessages(null);
    }
}
