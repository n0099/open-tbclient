package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CPUAdRequest {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f8367a;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, Object> f8368a = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.f8368a.put(str, str2);
            }
            return this;
        }

        public CPUAdRequest build() {
            return new CPUAdRequest(this);
        }

        public Builder setAccessType(int i) {
            this.f8368a.put("accessType", Integer.valueOf(i));
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.f8368a.put("listScene", 6);
            this.f8368a.put("city", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.f8368a.put("outerUid", str);
            return this;
        }

        public Builder setDownloadAppConfirmPolicy(int i) {
            this.f8368a.put("downloadAppConfirmPolicy", Integer.valueOf(i));
            return this;
        }

        public Builder setListScene(int i) {
            this.f8368a.put("listScene", Integer.valueOf(i));
            return this;
        }
    }

    public Map<String, Object> getExtras() {
        return this.f8367a;
    }

    public CPUAdRequest(Builder builder) {
        this.f8367a = new HashMap();
        if (builder == null || builder.f8368a == null) {
            return;
        }
        this.f8367a.putAll(builder.f8368a);
    }
}
