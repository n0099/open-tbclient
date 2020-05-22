package com.baidu.live.gift.b;

import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static void ao(String str, String str2) {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(str, str2, "liveroom", null));
    }

    public static void a(HttpResponsedMessage httpResponsedMessage, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene_from", str3);
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str4);
            jSONObject2.put("gift_count", str5);
            jSONObject2.put("tdou_left", str6);
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(str, str2, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, z);
    }
}
