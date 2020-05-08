package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.gift.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.q;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private InterfaceC0134a aFp;
    private HttpMessageListener aFq;

    /* renamed from: com.baidu.live.gift.giftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0134a {
        void i(ArrayList<c> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.ayq != null) {
                        c cVar = new c();
                        cVar.ayt = com.baidu.live.gift.b.a.eu(bVar.ayq.zipName);
                        cVar.upZipDirPath = com.baidu.live.gift.b.a.ew(bVar.ayq.zipName);
                        cVar.ays = bVar;
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
        this.aFq = new HttpMessageListener(1021089) { // from class: com.baidu.live.gift.giftList.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDynamicGiftListHttpResponseMessage)) {
                    ArrayList<com.baidu.live.gift.b> yO = ((AlaDynamicGiftListHttpResponseMessage) httpResponsedMessage).yO();
                    ArrayList<c> arrayList = new ArrayList<>();
                    if (yO != null) {
                        a.this.d(arrayList, yO);
                    }
                    if (a.this.aFp != null) {
                        a.this.aFp.i(arrayList);
                    }
                }
            }
        };
        registerListener(this.aFq);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        HttpMessage httpMessage = new HttpMessage(1021089);
        httpMessage.addParam("need_dynamic_gift", "1");
        httpMessage.addParam("need_sticker_gift", "0");
        httpMessage.addParam("scene_from", q.Gk());
        sendMessage(httpMessage);
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFq);
    }

    public void a(InterfaceC0134a interfaceC0134a) {
        this.aFp = interfaceC0134a;
    }
}
