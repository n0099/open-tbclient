package com.baidu.live.e;

import android.os.Handler;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.d;
import com.baidu.live.data.t;
import com.baidu.live.message.AlaGiftRefreshScoresHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class b extends BdBaseModel {
    private d akq;
    private Handler handler = new Handler();
    private HttpMessageListener akr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.live.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    t ul = alaGiftRefreshScoresHttpResponseMessage.ul();
                    TbadkCoreApplication.getInst().currentAccountTdouNum = ul.mTDouScores;
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = ul.mPetalTotal;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                }
                if (b.this.akq != null) {
                    b.this.handler.post(new Runnable() { // from class: com.baidu.live.e.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.akq.nq();
                        }
                    });
                }
            }
        }
    };

    public void initListener() {
        registerListener(this.akr);
    }

    public void a(d dVar) {
        this.akq = dVar;
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
        MessageManager.getInstance().unRegisterListener(this.akr);
        this.handler.removeCallbacksAndMessages(null);
    }
}
