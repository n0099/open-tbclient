package com.baidu.ala.gift;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class AlaRefreshScoreModel extends BdBaseModel {
    private HttpMessageListener mRefreshScoresListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.ala.gift.AlaRefreshScoreModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
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
                statsItem.append("workflow", "synctdou");
                statsItem.append("eventType", "syncfail");
                statsItem.append("response_code", Integer.valueOf(httpResponsedMessage.getStatusCode()));
                statsItem.append(AlaRecorderLog.KEY_ERROR_MSG, httpResponsedMessage.getErrorString());
                statsItem.append("error_code", Integer.valueOf(httpResponsedMessage.getError()));
                statsItem.append("response_content", contentStr);
                statsItem.append("uid", TbadkCoreApplication.getCurrentAccount());
                BdStatisticsManager.getInstance().debug("tiebalive", statsItem);
            }
        }
    };

    public void initListener() {
        registerListener(this.mRefreshScoresListener);
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

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mRefreshScoresListener);
    }
}
