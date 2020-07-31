package com.baidu.live.entereffect.c;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.entereffect.c.b;
import com.baidu.live.entereffect.http.EnterEffectDynamicListHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.p;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements b {
    private b.a aHq;
    private HttpMessageListener aHr;

    public void a(b.a aVar) {
        this.aHq = aVar;
    }

    public void bc(boolean z) {
        this.aHr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.live.entereffect.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof EnterEffectDynamicListHttpResponsedMessage) {
                    if (a.this.aHq != null) {
                        a.this.aHq.b(httpResponsedMessage.getError() == 0, ((EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage).getDatas());
                    }
                    a.this.a((EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aHr);
        com.baidu.live.entereffect.http.a aVar = new com.baidu.live.entereffect.http.a(z);
        aVar.addParam("scene_from", p.zw());
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST, z ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", null));
    }

    public void release() {
        this.aHq = null;
        MessageManager.getInstance().unRegisterListener(this.aHr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EnterEffectDynamicListHttpResponsedMessage enterEffectDynamicListHttpResponsedMessage) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (enterEffectDynamicListHttpResponsedMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                jSONObject2.put("result", jSONObject3);
                jSONObject = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject = jSONObject3;
            }
        } else if (enterEffectDynamicListHttpResponsedMessage.getDatas() == null || enterEffectDynamicListHttpResponsedMessage.getDatas().isEmpty()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                jSONObject2.put("result", jSONObject4);
                jSONObject = jSONObject4;
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject = jSONObject4;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST, enterEffectDynamicListHttpResponsedMessage.xQ() ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", null).setContentExt(jSONObject2), enterEffectDynamicListHttpResponsedMessage, true);
        }
    }
}
