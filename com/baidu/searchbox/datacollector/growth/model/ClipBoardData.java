package com.baidu.searchbox.datacollector.growth.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ClipBoardData {
    public String mDownChannel;
    public JSONObject mExtend;
    public String mLaunchChannel;
    public String mSchema;
    public String mSource;

    /* loaded from: classes3.dex */
    public static class Builder {
        public JSONObject extend;
        public String source = "";
        public String launchChannel = "";
        public String downChannel = "";
        public String schema = "";

        public ClipBoardData build() {
            return new ClipBoardData(this);
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
    }

    public ClipBoardData() {
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

    public String getLaunchChanel() {
        return this.mLaunchChannel;
    }

    public String getSchema() {
        return this.mSchema;
    }

    public String getSource() {
        return this.mSource;
    }

    public ClipBoardData(Builder builder) {
        this.mSource = builder.source;
        this.mLaunchChannel = builder.launchChannel;
        this.mDownChannel = builder.downChannel;
        this.mSchema = builder.schema;
        this.mExtend = builder.extend;
    }
}
