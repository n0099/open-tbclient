package com.baidu.adp.lib.network.http.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private List<String> Og;
    private long Oh;
    private String mHost;
    private long mStartTime = System.currentTimeMillis();

    public a bL(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.Oh = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            this.mHost = optJSONObject.keys().next();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.mHost);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP)) != null && optJSONArray.length() > 0) {
                this.Og = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.Og.add((String) optJSONArray.get(i2));
                        i = i2 + 1;
                    } else {
                        return this;
                    }
                }
            } else {
                return this;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(long j) {
        this.Oh = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public List<String> me() {
        return this.Og;
    }

    public boolean D(long j) {
        return j - this.mStartTime > this.Oh * 1000;
    }
}
