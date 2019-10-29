package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.o;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BdBaseModel {
    private InterfaceC0066a ace;
    private HttpMessageListener acf;

    /* renamed from: com.baidu.live.gift.giftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0066a {
        void h(ArrayList<com.baidu.live.gift.c> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<com.baidu.live.gift.c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.Wk != null) {
                        com.baidu.live.gift.c cVar = new com.baidu.live.gift.c();
                        cVar.upZipDirPath = com.baidu.live.gift.b.a.cz(bVar.Wk.zipName);
                        cVar.Wm = bVar;
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
        this.acf = new HttpMessageListener(1021089) { // from class: com.baidu.live.gift.giftList.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDynamicGiftListHttpResponseMessage)) {
                    ArrayList<com.baidu.live.gift.b> qW = ((AlaDynamicGiftListHttpResponseMessage) httpResponsedMessage).qW();
                    ArrayList<com.baidu.live.gift.c> arrayList = new ArrayList<>();
                    if (qW != null) {
                        a.this.c(arrayList, qW);
                    }
                    if (a.this.ace != null) {
                        a.this.ace.h(arrayList);
                    }
                }
            }
        };
        registerListener(this.acf);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        HttpMessage httpMessage = new HttpMessage(1021089);
        httpMessage.addParam("need_dynamic_gift", "1");
        httpMessage.addParam("need_sticker_gift", "0");
        httpMessage.addParam("scene_from", o.wu());
        sendMessage(httpMessage);
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.acf);
    }

    public void a(InterfaceC0066a interfaceC0066a) {
        this.ace = interfaceC0066a;
    }
}
