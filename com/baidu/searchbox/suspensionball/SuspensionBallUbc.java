package com.baidu.searchbox.suspensionball;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.ubc.Flow;
import com.baidu.ubc.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SuspensionBallUbc {
    private static final String FROM_VALUE = "tool";
    private static final String KEY_EXT = "ext";
    private static final String KEY_FROM = "from";
    private static final String KEY_INTERVAL_TIME = "interval_time";
    private static final String KEY_PAGE = "page";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VALUE = "value";
    public static final String SOURCE_DRAG = "drag";
    public static final String SOURCE_MENU = "menu";
    public static final String TYPE_HAVE_CLICK = "have_click";
    public static final String TYPE_NO_CLICK = "no_click";
    private static final String UBC_EVENT_ID = "992";
    private static final String UBC_TIME_ID = "993";
    private static final String VALUE_ADD_FLOATWINDOW = "add_floatwindow_clk";
    private static final String VALUE_ADD_TO_CANCEL = "add_to_cancel";
    private static final String VALUE_ADD_TO_CLICK = "add_to_clk";
    private static final String VALUE_CANCEL_FLOATWINDOW = "cancel_floatwindow_clk";
    public static final String VALUE_DT = "dt";
    private static final String VALUE_FLOATWINDOW = "floatwindow";
    private static final String VALUE_FLOATWINDOW_CLICK = "floatwindow_clk";
    private static final String VALUE_FLOATWINDOW_DRAG = "floatwindow_drag";
    private static final String VALUE_FLOATWINDOW_SHOW = "floatwindow_show";
    public static final String VALUE_OTHER = "other";
    public static final String VALUE_VIDEO = "video";

    public static void createSuspensionBall(String str, String str2) {
        ubcClickEvent(VALUE_ADD_FLOATWINDOW, str, null, str2);
    }

    public static void cancelSuspensionBall(String str, String str2) {
        String str3 = "";
        SuspensionBallEntity entityByKey = SuspensionBallManager.getInstance().getEntityByKey(str);
        if (entityByKey != null) {
            timeAddToCancel(System.currentTimeMillis() - entityByKey.createTime);
            if (entityByKey.clickTimes > 0) {
                str3 = TYPE_HAVE_CLICK;
            } else {
                str3 = TYPE_NO_CLICK;
            }
        }
        ubcClickEvent(VALUE_CANCEL_FLOATWINDOW, null, str3, str2);
    }

    public static void dragSuspensionBall(String str) {
        ubcClickEvent(VALUE_FLOATWINDOW_DRAG, null, str, null);
    }

    public static void clickSuspensionBall(String str) {
        ubcClickEvent(VALUE_FLOATWINDOW_CLICK, str, null, null);
    }

    private static void ubcClickEvent(String str, String str2, String str3, String str4) {
        aa aaVar = (aa) c.a(aa.SERVICE_REFERENCE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", FROM_VALUE);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("value", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("page", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("type", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("source", str4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aaVar.onEvent(UBC_EVENT_ID, jSONObject);
    }

    public static void timeAddToClick(long j) {
        ubcTimeEvent(VALUE_ADD_TO_CLICK, j);
    }

    private static void timeAddToCancel(long j) {
        ubcTimeEvent(VALUE_ADD_TO_CANCEL, j);
    }

    private static void ubcTimeEvent(String str, long j) {
        aa aaVar = (aa) c.a(aa.SERVICE_REFERENCE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", FROM_VALUE);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("value", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_INTERVAL_TIME, j / 1000);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aaVar.onEvent(UBC_TIME_ID, jSONObject);
    }

    public static Flow startPageShow(String str) {
        return startUbcFlow(VALUE_FLOATWINDOW_SHOW, str);
    }

    public static void endUbcFlow(Flow flow) {
        ((aa) c.a(aa.SERVICE_REFERENCE)).flowEnd(flow);
    }

    public static Flow startSuspensionBallShow() {
        return startUbcFlow(VALUE_FLOATWINDOW, null);
    }

    private static Flow startUbcFlow(String str, String str2) {
        aa aaVar = (aa) c.a(aa.SERVICE_REFERENCE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", FROM_VALUE);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("value", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("page", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aaVar.beginFlow(UBC_TIME_ID, jSONObject);
    }
}
