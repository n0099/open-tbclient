package com.baidu.live.gift.c;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.http.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.utils.q;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes2.dex */
public class a implements c {
    private c.a alN;
    private HttpMessageListener alO;
    private HttpMessageListener alP;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.alN = aVar;
    }

    public void tv() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("scene_from", q.yO());
        httpMessage.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        HttpMessage httpMessage = new HttpMessage(1021151);
        httpMessage.addParam("scene_from", q.yO());
        httpMessage.addParam(LegoListActivityConfig.ITEM_ID, str);
        httpMessage.addParam("item_type", str2);
        httpMessage.addParam("platform", "2");
        httpMessage.addParam("benefit_uid", str3);
        httpMessage.addParam("live_id", str4);
        httpMessage.addParam("consume_amount", i);
        httpMessage.addParam("is_combo", i2);
        httpMessage.addParam("attach", str5);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void release() {
        this.alN = null;
        unregisterListener();
    }

    private void registerListener() {
        tw();
        tx();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.alO);
        MessageManager.getInstance().unRegisterListener(this.alP);
    }

    private void tw() {
        this.alO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.alN != null) {
                        a.this.alN.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.tp(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.tq());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alO);
    }

    private void tx() {
        this.alP = new HttpMessageListener(1021151) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.alN != null) {
                        a.this.alN.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.alG, giftPackageConsumeHttpResponsedMessage.alH);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alP);
    }
}
