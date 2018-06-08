package com.baidu.location.e;

import com.baidu.ar.paddle.PaddleController;
import com.baidu.location.e.m;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
enum o extends m.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.e.m.b
    List<String> a(JSONObject jSONObject, String str, int i) {
        JSONArray jSONArray;
        Iterator<String> keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (keys.hasNext()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            String next = keys.next();
            m.b.b(stringBuffer, next, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (JSONException e) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.has(TimeDisplaySetting.START_SHOW_TIME) ? jSONObject2.getString(TimeDisplaySetting.START_SHOW_TIME) : null;
                        Double valueOf = jSONObject2.has(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X1) ? Double.valueOf(jSONObject2.getDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X1)) : null;
                        Double valueOf2 = jSONObject2.has(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y1) ? Double.valueOf(jSONObject2.getDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y1)) : null;
                        Double valueOf3 = jSONObject2.has(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X2) ? Double.valueOf(jSONObject2.getDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X2)) : null;
                        Double valueOf4 = jSONObject2.has(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y2) ? Double.valueOf(jSONObject2.getDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y2)) : null;
                        if (string != null && valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                            if (stringBuffer2.length() > 0) {
                                stringBuffer2.append(",");
                            }
                            stringBuffer2.append("(NULL,\"").append(next).append("\",\"").append(string).append("\",").append(valueOf).append(",").append(valueOf2).append(",").append(valueOf3).append(",").append(valueOf4).append(")");
                        }
                    } catch (JSONException e2) {
                    }
                    if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", Integer.valueOf(i)));
        return arrayList;
    }
}
