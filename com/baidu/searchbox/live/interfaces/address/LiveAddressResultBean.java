package com.baidu.searchbox.live.interfaces.address;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u0000BS\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007R$\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/address/LiveAddressResultBean;", "", "addrId", "Ljava/lang/String;", "getAddrId", "()Ljava/lang/String;", "setAddrId", "(Ljava/lang/String;)V", "addrInfo", "getAddrInfo", "setAddrInfo", "addrRegion", "getAddrRegion", "setAddrRegion", "isDefault", "setDefault", "mobile", "getMobile", "setMobile", "name", "getName", "setName", "tag", "getTag", "setTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveAddressResultBean {
    public String addrId;
    public String addrInfo;
    public String addrRegion;
    public String isDefault;
    public String mobile;
    public String name;
    public String tag;

    public LiveAddressResultBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.addrId = "";
        this.name = "";
        this.mobile = "";
        this.addrRegion = "";
        this.addrInfo = "";
        this.tag = "";
        this.isDefault = "";
        this.addrId = str;
        this.name = str2;
        this.mobile = str3;
        this.addrRegion = str4;
        this.addrInfo = str5;
        this.tag = str6;
        this.isDefault = str7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LiveAddressResultBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, r8, r9);
        String str8;
        String str9;
        if ((i & 32) != 0) {
            str8 = "";
        } else {
            str8 = str6;
        }
        if ((i & 64) != 0) {
            str9 = "";
        } else {
            str9 = str7;
        }
    }

    public final String getAddrId() {
        return this.addrId;
    }

    public final String getAddrInfo() {
        return this.addrInfo;
    }

    public final String getAddrRegion() {
        return this.addrRegion;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String isDefault() {
        return this.isDefault;
    }

    public final void setAddrId(String str) {
        this.addrId = str;
    }

    public final void setAddrInfo(String str) {
        this.addrInfo = str;
    }

    public final void setAddrRegion(String str) {
        this.addrRegion = str;
    }

    public final void setDefault(String str) {
        this.isDefault = str;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }
}
