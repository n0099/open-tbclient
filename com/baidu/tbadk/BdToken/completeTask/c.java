package com.baidu.tbadk.BdToken.completeTask;

import android.support.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static void aA(int i, int i2) {
        new an("c13317").ag("obj_source", i).ag("obj_type", i2).aUS();
    }

    public static void aB(int i, int i2) {
        new an("c13318").ag("obj_source", i).ag("obj_type", i2).aUS();
    }

    public static JSONObject a(@Nullable JSONObject jSONObject, int i, int i2, String str) {
        if (i != 0 && i2 != 0 && !aq.isEmpty(str)) {
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
