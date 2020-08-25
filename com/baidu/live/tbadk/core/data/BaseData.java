package com.baidu.live.tbadk.core.data;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseData {
    public abstract void parserJson(JSONObject jSONObject);

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
