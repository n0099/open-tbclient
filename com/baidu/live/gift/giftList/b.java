package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.p;
import com.baidu.live.utils.s;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a aZK;
    private HttpMessageListener aZL;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void n(ArrayList<com.baidu.live.gift.c> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.live.gift.c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.aRO != null) {
                        com.baidu.live.gift.c cVar = new com.baidu.live.gift.c();
                        cVar.aRR = s.hZ(bVar.aRO.zipName);
                        cVar.upZipDirPath = s.ia(bVar.aRO.zipName);
                        cVar.aRQ = bVar;
                        arrayList.add(cVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public b(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.aZL = new HttpMessageListener(1021089) { // from class: com.baidu.live.gift.giftList.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDynamicGiftListHttpResponseMessage)) {
                    AlaDynamicGiftListHttpResponseMessage alaDynamicGiftListHttpResponseMessage = (AlaDynamicGiftListHttpResponseMessage) httpResponsedMessage;
                    ArrayList<com.baidu.live.gift.b> If = alaDynamicGiftListHttpResponseMessage.If();
                    ArrayList<com.baidu.live.gift.c> arrayList = new ArrayList<>();
                    if (If != null) {
                        b.this.d(arrayList, If);
                    }
                    if (b.this.aZK != null) {
                        b.this.aZK.n(arrayList);
                    }
                    b.this.a(alaDynamicGiftListHttpResponseMessage);
                }
            }
        };
        registerListener(this.aZL);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        com.baidu.live.gift.giftList.a aVar = new com.baidu.live.gift.giftList.a(this.isHost);
        aVar.addParam("need_dynamic_gift", "1");
        aVar.addParam("need_sticker_gift", "0");
        aVar.addParam("scene_from", p.QW());
        sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, "dynamic_list", this.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", ""));
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aZL);
    }

    public void a(a aVar) {
        this.aZK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaDynamicGiftListHttpResponseMessage alaDynamicGiftListHttpResponseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        if (alaDynamicGiftListHttpResponseMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                jSONObject.put("result", jSONObject3);
                jSONObject2 = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject2 = jSONObject3;
            }
        } else if (alaDynamicGiftListHttpResponseMessage.If() == null || alaDynamicGiftListHttpResponseMessage.If().isEmpty()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                jSONObject.put("result", jSONObject4);
                jSONObject2 = jSONObject4;
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject2 = jSONObject4;
            }
        }
        if (jSONObject2 != null) {
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, "dynamic_list", alaDynamicGiftListHttpResponseMessage.EH() ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "").setContentExt(jSONObject), alaDynamicGiftListHttpResponseMessage, true);
        }
    }
}
