package com.baidu.live.yuyingift.b;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.gift.an;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.s;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static String p(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return AlaStaticKeys.ALA_STATIC_VALUE_ICON;
        }
        if (strArr.length == 1) {
            return "mic";
        }
        return "dating";
    }

    public static void q(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "allmic_clk").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void r(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gifthead_clk").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void s(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gift_clk").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void YV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftsend_clk").setContentExt("", "giftpanel", jSONObject));
    }

    public static void YW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "combosend_show").setContentExt("", "giftpanel", jSONObject));
    }

    public static void YX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "combosend_clk").setContentExt("", "giftpanel", jSONObject));
    }

    public static void YY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "multiple_show").setContentExt("", "giftpanel", jSONObject));
    }

    public static void YZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "multiple_clk").setContentExt("", "giftpanel", jSONObject));
    }

    public static void t(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "rechargebtn_clk").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void u(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "infocardbtn_clk").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void v(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void a(String[] strArr, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
            jSONObject.put("tabid", str);
            jSONObject.put("tabname", str2);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftpanel_show").setContentExt(p(strArr), "giftpanel", jSONObject));
    }

    public static void a(an anVar) {
        int i;
        if (anVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                ab Yt = com.baidu.live.ao.a.Ym().Yt();
                if (Yt != null && Yt.aKu != null) {
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
                }
                if (com.baidu.live.ao.a.Ym().Yt() != null && com.baidu.live.ao.a.Ym().Yt().aKy != null) {
                    int roomMode = com.baidu.live.ao.a.Ym().Yt().aKy.getRoomMode();
                    if (roomMode == 0) {
                        jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                    } else if (roomMode == 1) {
                        jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                    } else if (roomMode == 2) {
                        jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                    }
                }
                jSONObject.put(LogConfig.LOG_GIFT_VALUE, anVar.aYo);
                jSONObject.put(LogConfig.LOG_GIFT_ID, anVar.giftId);
                jSONObject.put("gift_name", anVar.giftName);
                JSONObject jSONObject2 = new JSONObject();
                List<s.a> il = s.il(anVar.aZM);
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (s.a aVar : il) {
                    AlaWheatInfoData iQ = com.baidu.live.ao.a.Ym().iQ(aVar.uk);
                    if (iQ != null) {
                        switch (iQ.userIdentity) {
                            case 1:
                                i = i2;
                                continue;
                                i2 = i;
                            case 2:
                                i4++;
                                i = i2;
                                continue;
                                i2 = i;
                            case 3:
                                i = i2 + 1;
                                continue;
                                i2 = i;
                            case 4:
                                i3++;
                                i = i2;
                                continue;
                                i2 = i;
                        }
                    }
                    i = i2;
                    i2 = i;
                }
                jSONObject2.put("owner", il.size());
                jSONObject2.put("accomany", i2);
                jSONObject2.put("host", i4);
                jSONObject2.put("guest", i3);
                jSONObject.put("benefit_info", jSONObject2);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "paygift_send").setContentExt(jSONObject));
        }
    }
}
