package com.baidu.tbadk.BdToken.completeTask;

import android.support.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static void aC(int i, int i2) {
        new ap("c13317").ah("obj_source", i).ah("obj_type", i2).baO();
    }

    public static void aD(int i, int i2) {
        new ap("c13318").ah("obj_source", i).ah("obj_type", i2).baO();
    }

    public static JSONObject a(@Nullable JSONObject jSONObject, int i, int i2, String str) {
        if (i != 0 && i2 != 0 && !as.isEmpty(str)) {
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
