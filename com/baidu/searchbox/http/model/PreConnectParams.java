package com.baidu.searchbox.http.model;

import java.util.List;
/* loaded from: classes3.dex */
public class PreConnectParams {
    public int mPreConnectDelayTimeMs;
    public List<String> mPreConnectDelayUrlsWithNum;
    public boolean mPreConnectEnabled;
    public List<String> mPreConnectNoDelayUrlsWithNum;
    public int mPreConnectPeriodTimeMs;
    public List<String> mPreConnectUrlsAllowlist;
    public int maxPreConnectNum;
    public int maxSingleHostPreConnectNum;

    /* loaded from: classes3.dex */
    public static class Builder {
        public boolean mPreConnectEnabled = false;
        public int maxPreConnectNum = -1;
        public int maxSingleHostPreConnectNum = -1;
        public int mPreConnectDelayTimeMs = -1;
        public int mPreConnectPeriodTimeMs = -1;
        public List<String> mPreConnectUrlsAllowlist = null;
        public List<String> mPreConnectUrlsWithNum = null;
        public List<String> mPreConnectNoDelayUrlsWithNum = null;

        public PreConnectParams build() {
            return new PreConnectParams(this);
        }

        public Builder setMaxPreConnectNum(int i) {
            this.maxPreConnectNum = i;
            return this;
        }

        public Builder setMaxSingleHostPreConnectNum(int i) {
            this.maxSingleHostPreConnectNum = i;
            return this;
        }

        public Builder setPreConnectDelayTimeMs(int i) {
            this.mPreConnectDelayTimeMs = i;
            return this;
        }

        public Builder setPreConnectDelayUrlsWithNum(List<String> list) {
            this.mPreConnectUrlsWithNum = list;
            return this;
        }

        public Builder setPreConnectEnabled(boolean z) {
            this.mPreConnectEnabled = z;
            return this;
        }

        public Builder setPreConnectNoDelayUrlsWithNum(List<String> list) {
            this.mPreConnectNoDelayUrlsWithNum = list;
            return this;
        }

        public Builder setPreConnectPeriodTimeMs(int i) {
            this.mPreConnectPeriodTimeMs = i;
            return this;
        }

        public Builder setPreConnectUrlsAllowlist(List<String> list) {
            this.mPreConnectUrlsAllowlist = list;
            return this;
        }
    }

    public PreConnectParams(Builder builder) {
        this.mPreConnectEnabled = false;
        this.maxPreConnectNum = -1;
        this.maxSingleHostPreConnectNum = -1;
        this.mPreConnectDelayTimeMs = -1;
        this.mPreConnectPeriodTimeMs = -1;
        this.mPreConnectUrlsAllowlist = null;
        this.mPreConnectDelayUrlsWithNum = null;
        this.mPreConnectNoDelayUrlsWithNum = null;
        this.mPreConnectEnabled = builder.mPreConnectEnabled;
        this.maxPreConnectNum = builder.maxPreConnectNum;
        this.maxSingleHostPreConnectNum = builder.maxSingleHostPreConnectNum;
        this.mPreConnectDelayTimeMs = builder.mPreConnectDelayTimeMs;
        this.mPreConnectPeriodTimeMs = builder.mPreConnectPeriodTimeMs;
        this.mPreConnectUrlsAllowlist = builder.mPreConnectUrlsAllowlist;
        this.mPreConnectDelayUrlsWithNum = builder.mPreConnectUrlsWithNum;
        this.mPreConnectNoDelayUrlsWithNum = builder.mPreConnectNoDelayUrlsWithNum;
    }

    public int getMaxPreConnectNum() {
        return this.maxPreConnectNum;
    }

    public int getMaxSingleHostPreConnectNum() {
        return this.maxSingleHostPreConnectNum;
    }

    public int getPreConnectDelayTimeMs() {
        return this.mPreConnectDelayTimeMs;
    }

    public List<String> getPreConnectDelayUrlsWithNum() {
        return this.mPreConnectDelayUrlsWithNum;
    }

    public boolean getPreConnectEnabled() {
        return this.mPreConnectEnabled;
    }

    public List<String> getPreConnectNoDelayUrlsWithNum() {
        return this.mPreConnectNoDelayUrlsWithNum;
    }

    public int getPreConnectPeriodTimeMs() {
        return this.mPreConnectPeriodTimeMs;
    }

    public List<String> getPreConnectUrlsAllowlist() {
        return this.mPreConnectUrlsAllowlist;
    }
}
