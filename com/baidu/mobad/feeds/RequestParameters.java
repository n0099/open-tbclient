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
    public final String f8017a;

    /* renamed from: b  reason: collision with root package name */
    public int f8018b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8019c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f8020d;

    /* renamed from: e  reason: collision with root package name */
    public int f8021e;

    /* renamed from: f  reason: collision with root package name */
    public int f8022f;

    /* renamed from: g  reason: collision with root package name */
    public int f8023g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8024h;
    public String mPlacementId;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f8025a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f8026b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public int f8027c = 3;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8028d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f8029e = 640;

        /* renamed from: f  reason: collision with root package name */
        public int f8030f = 480;

        /* renamed from: g  reason: collision with root package name */
        public int f8031g = 1;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8032h = false;

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.f8026b.put("mpt", String.valueOf(1));
            }
            this.f8026b.put(str, str2);
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
            this.f8031g = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f8030f = i;
            this.f8032h = true;
            return this;
        }

        public final Builder setWidth(int i) {
            this.f8029e = i;
            this.f8032h = true;
            return this;
        }
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAPPConfirmPolicy() {
        return this.f8023g;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public int getAdsType() {
        return this.f8018b;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public Map<String, String> getExtras() {
        return this.f8020d;
    }

    public int getHeight() {
        return this.f8022f;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public final String getKeywords() {
        return this.f8017a;
    }

    public int getWidth() {
        return this.f8021e;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public boolean isConfirmDownloading() {
        return this.f8019c;
    }

    public boolean isCustomSize() {
        return this.f8024h;
    }

    public void setAdsType(int i) {
        this.f8018b = i;
    }

    public void setExtras(Map<String, String> map) {
        this.f8020d = map;
    }

    @Override // com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.f8017a);
        hashMap.put("adsType", Integer.valueOf(this.f8018b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f8019c));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.f8020d;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }

    public RequestParameters(Builder builder) {
        this.f8021e = 0;
        this.f8022f = 0;
        this.f8017a = builder.f8025a;
        this.f8018b = builder.f8027c;
        this.f8021e = builder.f8029e;
        this.f8022f = builder.f8030f;
        this.f8024h = builder.f8032h;
        this.f8019c = builder.f8028d;
        this.f8023g = builder.f8031g;
        setExtras(builder.f8026b);
    }
}
