package com.baidu.live.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class QuickImInputData implements Serializable {
    public List<String> originTexts;
    public List<String> sortedTexts;

    public void parseJson(JSONArray jSONArray) {
        int length;
        if (this.originTexts != null) {
            this.originTexts.clear();
        }
        if (this.sortedTexts != null) {
            this.sortedTexts.clear();
        }
        if (jSONArray != null && (length = jSONArray.length()) != 0) {
            if (this.originTexts == null) {
                this.originTexts = new ArrayList();
            }
            for (int i = 0; i < length; i++) {
                this.originTexts.add(jSONArray.optString(i));
            }
            if (this.sortedTexts == null) {
                this.sortedTexts = new ArrayList();
            }
            this.sortedTexts.addAll(this.originTexts);
        }
    }
}
