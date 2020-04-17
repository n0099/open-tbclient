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
    private InterfaceC0113a aFj;
    private HttpMessageListener aFk;

    /* renamed from: com.baidu.live.gift.giftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0113a {
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
                    if (bVar != null && bVar.ayk != null) {
                        c cVar = new c();
                        cVar.ayn = com.baidu.live.gift.b.a.eu(bVar.ayk.zipName);
                        cVar.upZipDirPath = com.baidu.live.gift.b.a.ew(bVar.ayk.zipName);
                        cVar.aym = bVar;
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
        this.aFk = new HttpMessageListener(1021089) { // from class: com.baidu.live.gift.giftList.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDynamicGiftListHttpResponseMessage)) {
                    ArrayList<com.baidu.live.gift.b> yP = ((AlaDynamicGiftListHttpResponseMessage) httpResponsedMessage).yP();
                    ArrayList<c> arrayList = new ArrayList<>();
                    if (yP != null) {
                        a.this.d(arrayList, yP);
                    }
                    if (a.this.aFj != null) {
                        a.this.aFj.i(arrayList);
                    }
                }
            }
        };
        registerListener(this.aFk);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        HttpMessage httpMessage = new HttpMessage(1021089);
        httpMessage.addParam("need_dynamic_gift", "1");
        httpMessage.addParam("need_sticker_gift", "0");
        httpMessage.addParam("scene_from", q.Gl());
        sendMessage(httpMessage);
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFk);
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.aFj = interfaceC0113a;
    }
}
