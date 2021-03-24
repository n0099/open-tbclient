package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
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
    public final String f8016a;

    /* renamed from: b  reason: collision with root package name */
    public int f8017b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8018c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f8019d;

    /* renamed from: e  reason: collision with root package name */
    public int f8020e;

    /* renamed from: f  reason: collision with root package name */
    public int f8021f;

    /* renamed from: g  reason: collision with root package name */
    public int f8022g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8023h;
    public String mPlacementId;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f8024a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f8025b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public int f8026c = 3;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8027d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f8028e = 640;

        /* renamed from: f  reason: collision with root package name */
        public int f8029f = 480;

        /* renamed from: g  reason: collision with root package name */
        public int f8030g = 1;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8031h = false;

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.f8025b.put("mpt", String.valueOf(1));
            }
            this.f8025b.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
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
            this.f8030g = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f8029f = i;
            this.f8031h = true;
            return this;
        }

        public final Builder setWidth(int i) {
            this.f8028e = i;
            this.f8031h = true;
            return this;
        }
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAPPConfirmPolicy() {
        return this.f8022g;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAdsType() {
        return this.f8017b;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public Map<String, String> getExtras() {
        return this.f8019d;
    }

    public int getHeight() {
        return this.f8021f;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public final String getKeywords() {
        return this.f8016a;
    }

    public int getWidth() {
        return this.f8020e;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public boolean isConfirmDownloading() {
        return this.f8018c;
    }

    public boolean isCustomSize() {
        return this.f8023h;
    }

    public void setAdsType(int i) {
        this.f8017b = i;
    }

    public void setExtras(Map<String, String> map) {
        this.f8019d = map;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.f8016a);
        hashMap.put("adsType", Integer.valueOf(this.f8017b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f8018c));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.f8019d;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }

    public RequestParameters(Builder builder) {
        this.f8020e = 0;
        this.f8021f = 0;
        this.f8016a = builder.f8024a;
        this.f8017b = builder.f8026c;
        this.f8020e = builder.f8028e;
        this.f8021f = builder.f8029f;
        this.f8023h = builder.f8031h;
        this.f8018c = builder.f8027d;
        this.f8022g = builder.f8030g;
        setExtras(builder.f8025b);
    }
}
