package com.baidu.live.gift.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.http.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.utils.o;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes6.dex */
public class a implements c {
    private c.a adb;
    private HttpMessageListener adc;
    private HttpMessageListener ade;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.adb = aVar;
    }

    public void rp() {
        HttpMessage httpMessage = new HttpMessage(1021150);
        httpMessage.addParam("scene_from", o.wv());
        httpMessage.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        HttpMessage httpMessage = new HttpMessage(1021151);
        httpMessage.addParam("scene_from", o.wv());
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
        this.adb = null;
        unregisterListener();
    }

    private void registerListener() {
        rq();
        rr();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.adc);
        MessageManager.getInstance().unRegisterListener(this.ade);
    }

    private void rq() {
        this.adc = new HttpMessageListener(1021150) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.adb != null) {
                        a.this.adb.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.qY(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.qZ());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adc);
    }

    private void rr() {
        this.ade = new HttpMessageListener(1021151) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.adb != null) {
                        a.this.adb.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.acW, giftPackageConsumeHttpResponsedMessage.acX);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ade);
    }
}
