package com.baidu.searchbox.live.interfaces.address;

import com.baidu.sapi2.activity.AccountToolsActivity;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000B9\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenBean;", "Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenPageName;", "openPageName", "Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenPageName;", "getOpenPageName", "()Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenPageName;", "setOpenPageName", "(Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenPageName;)V", "", "selectAddedAddress", "Z", "getSelectAddedAddress", "()Z", "setSelectAddedAddress", "(Z)V", AccountToolsActivity.EXTRA_SWEEP_LIGHT_LOADING, "getSweepLightLoading", "setSweepLightLoading", "", "tplse", "Ljava/lang/String;", "getTplse", "()Ljava/lang/String;", "setTplse", "(Ljava/lang/String;)V", "tplt", "getTplt", "setTplt", "Lcom/baidu/searchbox/live/interfaces/address/LiveAddressType;", "type", "Lcom/baidu/searchbox/live/interfaces/address/LiveAddressType;", "getType", "()Lcom/baidu/searchbox/live/interfaces/address/LiveAddressType;", "setType", "(Lcom/baidu/searchbox/live/interfaces/address/LiveAddressType;)V", "<init>", "(Lcom/baidu/searchbox/live/interfaces/address/LiveAddressType;Lcom/baidu/searchbox/live/interfaces/address/LiveAddressOpenPageName;ZZLjava/lang/String;Ljava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveAddressOpenBean {
    public LiveAddressOpenPageName openPageName;
    public boolean selectAddedAddress;
    public boolean sweepLightLoading;
    public String tplse;
    public String tplt;
    public LiveAddressType type;

    public LiveAddressOpenBean(LiveAddressType liveAddressType, LiveAddressOpenPageName liveAddressOpenPageName, boolean z, boolean z2, String str, String str2) {
        this.type = liveAddressType;
        this.openPageName = liveAddressOpenPageName;
        this.selectAddedAddress = z;
        this.sweepLightLoading = z2;
        this.tplse = str;
        this.tplt = str2;
    }

    public final LiveAddressOpenPageName getOpenPageName() {
        return this.openPageName;
    }

    public final boolean getSelectAddedAddress() {
        return this.selectAddedAddress;
    }

    public final boolean getSweepLightLoading() {
        return this.sweepLightLoading;
    }

    public final String getTplse() {
        return this.tplse;
    }

    public final String getTplt() {
        return this.tplt;
    }

    public final LiveAddressType getType() {
        return this.type;
    }

    public final void setOpenPageName(LiveAddressOpenPageName liveAddressOpenPageName) {
        this.openPageName = liveAddressOpenPageName;
    }

    public final void setSelectAddedAddress(boolean z) {
        this.selectAddedAddress = z;
    }

    public final void setSweepLightLoading(boolean z) {
        this.sweepLightLoading = z;
    }

    public final void setTplse(String str) {
        this.tplse = str;
    }

    public final void setTplt(String str) {
        this.tplt = str;
    }

    public final void setType(LiveAddressType liveAddressType) {
        this.type = liveAddressType;
    }
}
