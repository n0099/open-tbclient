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
import com.baidu.live.utils.q;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements b {
    private b.a aWD;
    private HttpMessageListener aWE;

    public void a(b.a aVar) {
        this.aWD = aVar;
    }

    public void e(boolean z, String str) {
        if (this.aWE == null) {
            this.aWE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.live.entereffect.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage instanceof EnterEffectDynamicListHttpResponsedMessage) {
                        if (a.this.aWD != null) {
                            EnterEffectDynamicListHttpResponsedMessage enterEffectDynamicListHttpResponsedMessage = (EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage;
                            String str2 = null;
                            if (enterEffectDynamicListHttpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.entereffect.http.a) {
                                str2 = ((com.baidu.live.entereffect.http.a) enterEffectDynamicListHttpResponsedMessage.getOrginalMessage()).getId();
                            }
                            a.this.aWD.a(httpResponsedMessage.getError() == 0, enterEffectDynamicListHttpResponsedMessage.getDatas(), str2);
                        }
                        a.this.a((EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aWE);
        com.baidu.live.entereffect.http.a aVar = new com.baidu.live.entereffect.http.a(z, str);
        aVar.addParam("scene_from", q.Ia());
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST, z ? "author_liveroom" : "liveroom", ""));
    }

    public void release() {
        this.aWD = null;
        MessageManager.getInstance().unRegisterListener(this.aWE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EnterEffectDynamicListHttpResponsedMessage enterEffectDynamicListHttpResponsedMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        if (enterEffectDynamicListHttpResponsedMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                jSONObject.put("result", jSONObject3);
                jSONObject2 = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject2 = jSONObject3;
            }
        } else if (enterEffectDynamicListHttpResponsedMessage.getDatas() == null || enterEffectDynamicListHttpResponsedMessage.getDatas().isEmpty()) {
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
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST, enterEffectDynamicListHttpResponsedMessage.FS() ? "author_liveroom" : "liveroom", "").setContentExt(jSONObject), enterEffectDynamicListHttpResponsedMessage, true);
        }
    }
}
