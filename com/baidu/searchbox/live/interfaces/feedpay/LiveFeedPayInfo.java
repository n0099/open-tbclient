package com.baidu.searchbox.live.interfaces.feedpay;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b \u0018\u0000 -:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0003\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR$\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006."}, d2 = {"Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "", "isValid", "()Z", "", "business", "Ljava/lang/String;", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "couponID", "getCouponID", "setCouponID", "", "currentPrice", "I", "getCurrentPrice", "()I", "setCurrentPrice", "(I)V", "cutPrice", "getCutPrice", "setCutPrice", "ext", "getExt", "setExt", "from", "getFrom", "setFrom", "isFree", "Z", "setFree", "(Z)V", "originPrice", "getOriginPrice", "setOriginPrice", "resId", "getResId", "setResId", "source", "getSource", "setSource", "<init>", "()V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LiveFeedPayInfo {
    public static final Companion Companion = new Companion(null);
    public String business;
    public String couponID;
    public int currentPrice;
    public int cutPrice;
    public String ext;
    public String from;
    public boolean isFree;
    public int originPrice;
    public String resId;
    public String source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo$Companion;", "", "resId", "", "isFree", "source", "from", "ext", "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "with", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveFeedPayInfo with(String str, boolean z, String str2, String str3, String str4) {
            LiveFeedPayInfo liveFeedPayInfo = new LiveFeedPayInfo();
            liveFeedPayInfo.setResId(str);
            liveFeedPayInfo.setFree(z);
            liveFeedPayInfo.setSource(str2);
            liveFeedPayInfo.setFrom(str3);
            liveFeedPayInfo.setExt(str4);
            return liveFeedPayInfo;
        }
    }

    public final String getBusiness() {
        return this.business;
    }

    public final String getCouponID() {
        return this.couponID;
    }

    public final int getCurrentPrice() {
        return this.currentPrice;
    }

    public final int getCutPrice() {
        return this.cutPrice;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getOriginPrice() {
        return this.originPrice;
    }

    public final String getResId() {
        return this.resId;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean isFree() {
        return this.isFree;
    }

    public final boolean isValid() {
        int i;
        int i2;
        if (!TextUtils.isEmpty(this.resId) && (i = this.currentPrice) >= 0 && (i2 = this.originPrice) >= 0 && i <= i2) {
            return true;
        }
        return false;
    }

    public final void setBusiness(String str) {
        this.business = str;
    }

    public final void setCouponID(String str) {
        this.couponID = str;
    }

    public final void setCurrentPrice(int i) {
        this.currentPrice = i;
    }

    public final void setCutPrice(int i) {
        this.cutPrice = i;
    }

    public final void setExt(String str) {
        this.ext = str;
    }

    public final void setFree(boolean z) {
        this.isFree = z;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final void setOriginPrice(int i) {
        this.originPrice = i;
    }

    public final void setResId(String str) {
        this.resId = str;
    }

    public final void setSource(String str) {
        this.source = str;
    }
}
