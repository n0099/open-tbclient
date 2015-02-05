package com.baidu.tbadk.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.mvc.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements f {
    private String threadId = "";
    private String AZ = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String Ba = "";
    private boolean Bb = false;
    private boolean Bc = false;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return (this.threadId == null || bVar.threadId == null || !this.threadId.equals(bVar.threadId)) ? false : true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        if (TextUtils.isEmpty(this.threadId)) {
            hashCode = 120;
        } else {
            hashCode = this.threadId.hashCode() + 119;
        }
        if (TextUtils.isEmpty(this.AZ)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.AZ.hashCode();
        }
        if (TextUtils.isEmpty(this.forumName)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.time);
        if (TextUtils.isEmpty(this.Ba)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.Ba.hashCode();
        }
        return (((this.Bb ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.Bc ? 1 : 0);
    }

    public boolean d(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.Ba = jSONObject.optString("post_id");
            this.Bb = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.Bc = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            if (!TextUtils.isEmpty(string)) {
                this.forumName = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.threadId = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.AZ = string3;
            }
            if (j > 2000) {
                this.time = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject lk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.AZ);
            jSONObject.put("post_id", this.Ba);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.Bb);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.Bc);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String ll() {
        return this.AZ;
    }

    public String getForumName() {
        return this.forumName;
    }

    public long getTime() {
        return this.time;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void bA(String str) {
        this.AZ = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String lm() {
        return this.Ba;
    }

    public void bB(String str) {
        this.Ba = str;
    }

    public boolean ln() {
        return this.Bb;
    }

    public void Z(boolean z) {
        this.Bb = z;
    }

    public boolean lo() {
        return this.Bc;
    }

    public void aa(boolean z) {
        this.Bc = z;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String lp() {
        return lk().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean bC(String str) {
        if (str != null) {
            try {
                return d(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
