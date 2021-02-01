package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class RequestParameters implements IXAdFeedsRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";

    /* renamed from: a  reason: collision with root package name */
    private final String f3230a;

    /* renamed from: b  reason: collision with root package name */
    private int f3231b;
    private boolean c;
    private Map<String, String> d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    protected String mPlacementId;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f3232a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f3233b = new HashMap();
        private int c = 3;
        private boolean d = false;
        private int e = 640;
        private int f = 480;
        private int g = 1;
        private boolean h = false;

        public final Builder setWidth(int i) {
            this.e = i;
            this.h = true;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f = i;
            this.h = true;
            return this;
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i) {
            this.g = i;
            return this;
        }

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.f3233b.put("mpt", String.valueOf(1));
            }
            this.f3233b.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
        }
    }

    private RequestParameters(Builder builder) {
        this.e = 0;
        this.f = 0;
        this.f3230a = builder.f3232a;
        this.f3231b = builder.c;
        this.e = builder.e;
        this.f = builder.f;
        this.h = builder.h;
        this.c = builder.d;
        this.g = builder.g;
        setExtras(builder.f3233b);
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public final String getKeywords() {
        return this.f3230a;
    }

    public int getWidth() {
        return this.e;
    }

    public int getHeight() {
        return this.f;
    }

    public boolean isCustomSize() {
        return this.h;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAdsType() {
        return this.f3231b;
    }

    public void setAdsType(int i) {
        this.f3231b = i;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public boolean isConfirmDownloading() {
        return this.c;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public Map<String, String> getExtras() {
        return this.d;
    }

    public void setExtras(Map<String, String> map) {
        this.d = map;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.f3230a);
        hashMap.put("adsType", Integer.valueOf(this.f3231b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.c));
        HashMap hashMap2 = new HashMap();
        if (this.d != null) {
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAPPConfirmPolicy() {
        return this.g;
    }
}
