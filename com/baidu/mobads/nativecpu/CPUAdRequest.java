package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class CPUAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f2422a;

    private CPUAdRequest(Builder builder) {
        this.f2422a = new HashMap();
        if (builder == null || builder.f2423a == null) {
            return;
        }
        this.f2422a.putAll(builder.f2423a);
    }

    public Map<String, Object> getExtras() {
        return this.f2422a;
    }

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<String, Object> f2423a = new HashMap<>();

        public Builder setListScene(int i) {
            this.f2423a.put("listScene", Integer.valueOf(i));
            return this;
        }

        public Builder setAccessType(int i) {
            this.f2423a.put("accessType", Integer.valueOf(i));
            return this;
        }

        public Builder setDownloadAppConfirmPolicy(int i) {
            this.f2423a.put("downloadAppConfirmPolicy", Integer.valueOf(i));
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.f2423a.put("outerUid", str);
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.f2423a.put("listScene", 6);
            this.f2423a.put("city", str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.f2423a.put(str, str2);
            }
            return this;
        }

        public CPUAdRequest build() {
            return new CPUAdRequest(this);
        }
    }
}
