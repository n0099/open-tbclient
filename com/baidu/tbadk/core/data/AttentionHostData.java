package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AttentionHostData implements Serializable {
    private static final long serialVersionUID = -2696089215466586871L;
    public boolean isAttention;
    public boolean isGod;
    public int likeStatus;
    public String portrait;
    public String uid;

    public void parserWithMetaData(MetaData metaData) {
        if (metaData != null) {
            this.isAttention = metaData.hadConcerned();
            this.uid = metaData.getUserId();
            this.portrait = metaData.getPortrait();
            this.likeStatus = metaData.getLikeStatus();
            this.isGod = metaData.isGod();
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_attention", this.isAttention);
            jSONObject.put("uid", this.uid);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("like_status", this.likeStatus);
            jSONObject.put("is_god", this.isGod);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public void parserWithJsonString(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    this.isAttention = jSONObject.optBoolean("is_attention", false);
                    this.uid = jSONObject.optString("uid");
                    this.portrait = jSONObject.optString("portrait");
                    this.likeStatus = jSONObject.optInt("like_status", 0);
                    this.isGod = jSONObject.optBoolean("is_god", false);
                }
            } catch (Throwable th) {
            }
        }
    }
}
