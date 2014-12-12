package com.baidu.tbadk.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.mvc.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements f {
    private String threadId = "";
    private String Bc = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String Bd = "";
    private boolean Be = false;
    private boolean Bf = false;

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
        if (TextUtils.isEmpty(this.Bc)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.Bc.hashCode();
        }
        if (TextUtils.isEmpty(this.forumName)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.time);
        if (TextUtils.isEmpty(this.Bd)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.Bd.hashCode();
        }
        return (((this.Be ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.Bf ? 1 : 0);
    }

    public boolean d(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.Bd = jSONObject.optString("post_id");
            this.Be = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.Bf = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            if (!TextUtils.isEmpty(string)) {
                this.forumName = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.threadId = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.Bc = string3;
            }
            if (j > 2000) {
                this.time = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject lr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.Bc);
            jSONObject.put("post_id", this.Bd);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.Be);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.Bf);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String ls() {
        return this.Bc;
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

    public void bF(String str) {
        this.Bc = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String lt() {
        return this.Bd;
    }

    public void bG(String str) {
        this.Bd = str;
    }

    public boolean lu() {
        return this.Be;
    }

    public void Z(boolean z) {
        this.Be = z;
    }

    public boolean lv() {
        return this.Bf;
    }

    public void aa(boolean z) {
        this.Bf = z;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String lw() {
        return lr().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean bH(String str) {
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
