package com.baidu.searchbox.datacollector.growth.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActiveData {
    public String mChannel;
    public JSONObject mExtend;
    public String mType;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String channel;
        public JSONObject extend;
        public String type = "active";

        public Builder(String str) {
            this.channel = str;
        }

        public Builder setExtend(JSONObject jSONObject) {
            this.extend = jSONObject;
            return this;
        }

        public Builder setType(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.type = str;
            }
            return this;
        }

        public ActiveData build() {
            return new ActiveData(this);
        }
    }

    public ActiveData() {
        this.mType = "";
        this.mChannel = "";
    }

    public String getChannel() {
        return this.mChannel;
    }

    public JSONObject getExtend() {
        return this.mExtend;
    }

    public String getType() {
        return this.mType;
    }

    public ActiveData(Builder builder) {
        this.mType = builder.type;
        this.mChannel = builder.channel;
        this.mExtend = builder.extend;
    }
}
