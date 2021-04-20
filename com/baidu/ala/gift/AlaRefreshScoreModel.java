package com.baidu.ala.gift;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import d.b.c.e.n.a;
/* loaded from: classes.dex */
public class AlaRefreshScoreModel extends BdBaseModel {
    public HttpMessageListener mRefreshScoresListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.ala.gift.AlaRefreshScoreModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                return;
            }
            AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
            if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                AlaUserScoreData scoresData = alaGiftRefreshScoresHttpResponseMessage.getScoresData();
                TbadkCoreApplication.getInst().currentAccountTdouNum = scoresData.mTDouScores;
                TbadkCoreApplication.getInst().currentAccountFlowerNum = scoresData.mPetalTotal;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                return;
            }
            String contentStr = alaGiftRefreshScoresHttpResponseMessage.getContentStr();
            if (contentStr != null && contentStr.length() > 200) {
                contentStr = contentStr.substring(0, 200);
            }
            a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "synctdou");
            statsItem.b("eventType", "syncfail");
            statsItem.c("response_code", Integer.valueOf(httpResponsedMessage.getStatusCode()));
            statsItem.b("error_msg", httpResponsedMessage.getErrorString());
            statsItem.c("error_code", Integer.valueOf(httpResponsedMessage.getError()));
            statsItem.b("response_content", contentStr);
            statsItem.b("uid", TbadkCoreApplication.getCurrentAccount());
            BdStatisticsManager.getInstance().debug("tiebalive", statsItem);
        }
    };

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void initListener() {
        registerListener(this.mRefreshScoresListener);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mRefreshScoresListener);
    }

    public boolean refreshCurUserScores() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getCurrentTbs());
            sendMessage(httpMessage);
            return true;
        }
        return false;
    }
}
