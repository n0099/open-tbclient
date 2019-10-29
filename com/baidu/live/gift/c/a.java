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
    private c.a adu;
    private HttpMessageListener adv;
    private HttpMessageListener adw;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.adu = aVar;
    }

    public void ro() {
        HttpMessage httpMessage = new HttpMessage(1021150);
        httpMessage.addParam("scene_from", o.wu());
        httpMessage.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        HttpMessage httpMessage = new HttpMessage(1021151);
        httpMessage.addParam("scene_from", o.wu());
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
        this.adu = null;
        unregisterListener();
    }

    private void registerListener() {
        rp();
        rq();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.adv);
        MessageManager.getInstance().unRegisterListener(this.adw);
    }

    private void rp() {
        this.adv = new HttpMessageListener(1021150) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.adu != null) {
                        a.this.adu.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.qX(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.qY());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adv);
    }

    private void rq() {
        this.adw = new HttpMessageListener(1021151) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.adu != null) {
                        a.this.adu.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.adp, giftPackageConsumeHttpResponsedMessage.adq);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adw);
    }
}
