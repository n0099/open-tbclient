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
/* loaded from: classes3.dex */
public class a implements c {
    private c.a aol;
    private HttpMessageListener aom;
    private HttpMessageListener aon;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.aol = aVar;
    }

    @Override // com.baidu.live.gift.c.c
    public void uS() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("scene_from", q.Bn());
        httpMessage.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.c.c
    public void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        HttpMessage httpMessage = new HttpMessage(1021151);
        httpMessage.addParam("scene_from", q.Bn());
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

    @Override // com.baidu.live.gift.c.c
    public void release() {
        this.aol = null;
        unregisterListener();
    }

    private void registerListener() {
        uT();
        uU();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aom);
        MessageManager.getInstance().unRegisterListener(this.aon);
    }

    private void uT() {
        this.aom = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.aol != null) {
                        a.this.aol.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.uL(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.uM());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aom);
    }

    private void uU() {
        this.aon = new HttpMessageListener(1021151) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.aol != null) {
                        a.this.aol.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.aod, giftPackageConsumeHttpResponsedMessage.aoe);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aon);
    }
}
