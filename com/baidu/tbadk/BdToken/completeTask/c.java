package com.baidu.tbadk.BdToken.completeTask;

import android.support.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static void aJ(int i, int i2) {
        new aq("c13317").al("obj_source", i).al("obj_type", i2).brk();
    }

    public static void aK(int i, int i2) {
        new aq("c13318").al("obj_source", i).al("obj_type", i2).brk();
    }

    public static JSONObject a(@Nullable JSONObject jSONObject, int i, int i2, String str) {
        if (i != 0 && i2 != 0 && !at.isEmpty(str)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2, str);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONObject;
    }
}
