package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CPUAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f3397a;

    private CPUAdRequest(Builder builder) {
        this.f3397a = new HashMap();
        if (builder == null || builder.f3398a == null) {
            return;
        }
        this.f3397a.putAll(builder.f3398a);
    }

    public Map<String, Object> getExtras() {
        return this.f3397a;
    }

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<String, Object> f3398a = new HashMap<>();

        public Builder setListScene(int i) {
            this.f3398a.put("listScene", Integer.valueOf(i));
            return this;
        }

        public Builder setAccessType(int i) {
            this.f3398a.put("accessType", Integer.valueOf(i));
            return this;
        }

        public Builder setDownloadAppConfirmPolicy(int i) {
            this.f3398a.put("downloadAppConfirmPolicy", Integer.valueOf(i));
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.f3398a.put("outerUid", str);
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.f3398a.put("listScene", 6);
            this.f3398a.put("city", str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.f3398a.put(str, str2);
            }
            return this;
        }

        public CPUAdRequest build() {
            return new CPUAdRequest(this);
        }
    }
}
