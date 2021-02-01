package com.baidu.live.utils;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    public static void c(int i, long j, long j2) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_SCROLL_SWITCH, UbcStatConstant.ContentType.UBC_TYPE_SCROLL_PAGE, "liveroom", UbcStatConstant.Value.EFFECT_SWITCH_ROOM);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("select_pos", i);
            jSONObject2.put("room_id", j);
            jSONObject2.put("live_id", j2);
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void ic(String str) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_SCROLL_SWITCH, UbcStatConstant.ContentType.UBC_TYPE_SCROLL_PAGE, "liveroom", UbcStatConstant.Value.EFFECT_SWITCH_ROOM_EXCEP);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", str);
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void e(HttpResponsedMessage httpResponsedMessage) {
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_SCROLL_SWITCH, UbcStatConstant.ContentType.UBC_TYPE_SCROLL_PAGE, "liveroom", UbcStatConstant.Value.EFFECT_GET_LIVES_ERROR), httpResponsedMessage, true);
    }

    public static void f(HttpResponsedMessage httpResponsedMessage) {
        List<Long> ids;
        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
        if ((orginalMessage instanceof com.baidu.live.liveroom.messages.a) && (ids = ((com.baidu.live.liveroom.messages.a) orginalMessage).getIds()) != null && ids.size() > 1 && (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage)) {
            List<Long> closedIds = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getClosedIds();
            if (!ListUtils.isEmpty(closedIds) && closedIds.size() > ids.size() / 2) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_SCROLL_SWITCH, UbcStatConstant.ContentType.UBC_TYPE_GET_LIVE_STATUS, "liveroom", UbcStatConstant.Value.EFFECT_GET_LIVE_STATUS_EXCEP), httpResponsedMessage, true);
            }
        }
    }

    public static void a(String str, String str2, long j, boolean z) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, z ? "author_liveroom" : "liveroom", UbcStatConstant.Value.GIFT_DELETE);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put(DpStatConstants.KEY_USER_ID, str2);
            jSONObject2.put("msg_id", j);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void a(int i, String str, String str2, String str3, long j, boolean z) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, z ? "author_liveroom" : "liveroom", UbcStatConstant.Value.BIG_GIFT_PLAY_ERROR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str2);
            jSONObject2.put("send_userid", str3);
            jSONObject2.put("msg_id", j);
            jSONObject2.put("error_code", i);
            jSONObject2.put("error_msg", str);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void b(String str, String str2, long j, boolean z) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, z ? "author_liveroom" : "liveroom", UbcStatConstant.Value.BIG_GIFT_TO_SMALL_GIFT);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put("send_userid", str2);
            jSONObject2.put("msg_id", j);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void c(String str, String str2, long j, boolean z) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, z ? "author_liveroom" : "liveroom", UbcStatConstant.Value.BIG_GIFT_SHOWING);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put("send_userid", str2);
            jSONObject2.put("msg_id", j);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void d(String str, String str2, long j, boolean z) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, z ? "author_liveroom" : "liveroom", UbcStatConstant.Value.BIG_GIFT_DATA_ERROR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put("send_userid", str2);
            jSONObject2.put("msg_id", j);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void e(String str, String str2, long j) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, "liveroom", UbcStatConstant.Value.BIG_GIFT_DOWNLOADING);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put("send_userid", str2);
            jSONObject2.put("msg_id", j);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void a(String str, long j, long j2, long j3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_SHOW, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW, "liveroom", UbcStatConstant.Value.BIG_GIFT_SPIT);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject2.put("gift_count", j);
            jSONObject2.put("send_userid", j2);
            jSONObject2.put("msg_id", j3);
            jSONObject.put(UbcStatConstant.DebugContentValue.GIFT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void F(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_EFFECT, UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT, "liveroom", UbcStatConstant.Value.EFFECT_ARCHIVE_ERROR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("identifier", str);
            jSONObject2.put("down_url", str2);
            jSONObject2.put(BdStatsConstant.StatsType.ERROR, str3);
            jSONObject.put(UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    public static void G(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_EFFECT, UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT, "liveroom", UbcStatConstant.Value.EFFECT_FILE_ERROR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("identifier", str);
            jSONObject2.put("down_url", str2);
            jSONObject2.put(BdStatsConstant.StatsType.ERROR, str3);
            jSONObject.put(UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
