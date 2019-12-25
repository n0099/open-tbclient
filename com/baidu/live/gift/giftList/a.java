package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.p;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BdBaseModel {
    private InterfaceC0080a ajL;
    private HttpMessageListener ajM;

    /* renamed from: com.baidu.live.gift.giftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0080a {
        void h(ArrayList<c> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.ads != null) {
                        c cVar = new c();
                        cVar.upZipDirPath = com.baidu.live.gift.b.a.dr(bVar.ads.zipName);
                        cVar.adu = bVar;
                        arrayList.add(cVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public a(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.ajM = new HttpMessageListener(1021089) { // from class: com.baidu.live.gift.giftList.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDynamicGiftListHttpResponseMessage)) {
                    ArrayList<com.baidu.live.gift.b> sG = ((AlaDynamicGiftListHttpResponseMessage) httpResponsedMessage).sG();
                    ArrayList<c> arrayList = new ArrayList<>();
                    if (sG != null) {
                        a.this.d(arrayList, sG);
                    }
                    if (a.this.ajL != null) {
                        a.this.ajL.h(arrayList);
                    }
                }
            }
        };
        registerListener(this.ajM);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        HttpMessage httpMessage = new HttpMessage(1021089);
        httpMessage.addParam("need_dynamic_gift", "1");
        httpMessage.addParam("need_sticker_gift", "0");
        httpMessage.addParam("scene_from", p.yv());
        sendMessage(httpMessage);
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ajM);
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.ajL = interfaceC0080a;
    }
}
