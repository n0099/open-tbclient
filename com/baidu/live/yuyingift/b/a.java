package com.baidu.live.yuyingift.b;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.gift.am;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.r;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static void a(am amVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (amVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                w UO = com.baidu.live.aj.b.UH().UO();
                if (UO != null && UO.aIS != null) {
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, UO.aIS.croom_id);
                }
                jSONObject.put(LogConfig.LOG_GIFT_VALUE, amVar.aUf);
                jSONObject.put(LogConfig.LOG_GIFT_ID, amVar.giftId);
                jSONObject.put("gift_name", amVar.giftName);
                JSONObject jSONObject2 = new JSONObject();
                List<r.a> io2 = r.io(amVar.aVt);
                int i5 = 0;
                int i6 = 0;
                for (r.a aVar : io2) {
                    AlaWheatInfoData iL = com.baidu.live.aj.b.UH().iL(aVar.uk);
                    if (iL != null) {
                        switch (iL.userIdentity) {
                            case 1:
                                i = i4;
                                i2 = i5;
                                i3 = i6;
                                continue;
                                i6 = i3;
                                i5 = i2;
                                i4 = i;
                            case 2:
                                int i7 = i4;
                                i2 = i5;
                                i3 = i6 + 1;
                                i = i7;
                                continue;
                                i6 = i3;
                                i5 = i2;
                                i4 = i;
                            case 3:
                                i = i4 + 1;
                                i2 = i5;
                                i3 = i6;
                                continue;
                                i6 = i3;
                                i5 = i2;
                                i4 = i;
                            case 4:
                                int i8 = i5 + 1;
                                i3 = i6;
                                i = i4;
                                i2 = i8;
                                continue;
                                i6 = i3;
                                i5 = i2;
                                i4 = i;
                        }
                    }
                    i = i4;
                    i2 = i5;
                    i3 = i6;
                    i6 = i3;
                    i5 = i2;
                    i4 = i;
                }
                jSONObject2.put("owner", io2.size());
                jSONObject2.put("accomany", i4);
                jSONObject2.put("host", i6);
                jSONObject2.put("guest", i5);
                jSONObject.put("benefit_info", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "paygift_send").setContentExt(jSONObject));
        }
    }
}
