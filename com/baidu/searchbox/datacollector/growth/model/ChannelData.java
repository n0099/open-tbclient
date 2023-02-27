package com.baidu.searchbox.datacollector.growth.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChannelData {
    public String mDownChannel;
    public JSONObject mExtend;
    public String mLaunchChannel;
    public String mSchema;
    public String mSource;
    public String mType;

    /* loaded from: classes2.dex */
    public static class Builder {
        public JSONObject extend;
        public String type;
        public String source = "";
        public String launchChannel = "";
        public String downChannel = "";
        public String schema = "";

        public Builder(String str) {
            this.type = str;
        }

        public Builder setDownChannel(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.downChannel = str;
            }
            return this;
        }

        public Builder setExtend(JSONObject jSONObject) {
            this.extend = jSONObject;
            return this;
        }

        public Builder setLaunchChannel(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.launchChannel = str;
            }
            return this;
        }

        public Builder setSchema(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.schema = str;
            }
            return this;
        }

        public Builder setSource(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.source = str;
            }
            return this;
        }

        public ChannelData build() {
            return new ChannelData(this);
        }
    }

    public ChannelData() {
        this.mType = "";
        this.mSource = "";
        this.mLaunchChannel = "";
        this.mDownChannel = "";
        this.mSchema = "";
    }

    public String getDownChannel() {
        return this.mDownChannel;
    }

    public JSONObject getExtend() {
        return this.mExtend;
    }

    public String getLaunchChannel() {
        return this.mLaunchChannel;
    }

    public String getSchema() {
        return this.mSchema;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getType() {
        return this.mType;
    }

    public ChannelData(Builder builder) {
        this.mType = builder.type;
        this.mSource = builder.source;
        this.mLaunchChannel = builder.launchChannel;
        this.mDownChannel = builder.downChannel;
        this.mSchema = builder.schema;
        this.mExtend = builder.extend;
    }
}
