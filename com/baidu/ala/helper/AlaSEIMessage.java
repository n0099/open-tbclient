package com.baidu.ala.helper;

import com.baidu.android.imsdk.db.TableDefine;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaSEIMessage {
    public static String buildBackgroundMessage(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject3.put("content_type", "stream_bg");
            jSONObject3.put("text", "主播暂时离开，请稍候");
            jSONObject3.put("has_sei", "1");
            jSONObject3.put("num", "1");
            jSONObject4.put("content", jSONObject3);
            jSONObject4.put("msg_type", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            jSONObject4.put("room_id", str);
            jSONObject4.put("user_id", str2);
            jSONObject2.put("service_info", jSONObject4);
            jSONObject2.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "10013");
            jSONObject.put("type", 107);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String buildForegroundMessage(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject3.put("content_type", "stream_fg");
            jSONObject3.put("text", "");
            jSONObject3.put("has_sei", "1");
            jSONObject3.put("num", "1");
            jSONObject4.put("content", jSONObject3);
            jSONObject4.put("msg_type", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            jSONObject4.put("room_id", str);
            jSONObject4.put("user_id", str2);
            jSONObject2.put("service_info", jSONObject4);
            jSONObject2.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "10013");
            jSONObject.put("type", 107);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
