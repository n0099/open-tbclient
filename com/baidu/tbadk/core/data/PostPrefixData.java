package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PostPrefixData implements Serializable {
    private static final long serialVersionUID = 6807267689393049879L;
    private ArrayList<String> prefixs = new ArrayList<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("mode", 0);
            if (optInt == 0) {
                String optString = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString)) {
                    this.prefixs.add(optString);
                }
            } else if (optInt == 1) {
                String optString2 = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString2)) {
                    String optString3 = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString3)) {
                        for (String str : optString3.split(" ")) {
                            this.prefixs.add(optString2.replace("#type#", str));
                        }
                        return;
                    }
                    this.prefixs.add(optString2);
                }
            }
        }
    }

    public ArrayList<String> getPrefixs() {
        return this.prefixs;
    }
}
