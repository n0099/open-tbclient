package com.baidu.searchbox.launch;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface IExternalTransferSpeedStatsInterface {
    void addEvent(String str);

    void addEvent(String str, String str2);

    void endFlow();

    void resetFlow();

    void setExternalTansferSource(String str);

    void setExternalTransferPage(String str);

    void setValueWithJson(JSONObject jSONObject);
}
