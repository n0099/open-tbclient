package com.baidu.searchbox.live.interfaces.payment;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R\"\u00104\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\u0005\"\u0004\b6\u0010\u0007R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/payment/PayResultInfo;", "", PayUiEventContent.AMOUNT, "J", "getAmount", "()J", "setAmount", "(J)V", "", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", "appid", "I", "getAppid", "()I", "setAppid", "(I)V", "currencyAmount", "getCurrencyAmount", "setCurrencyAmount", "currencyType", "getCurrencyType", "setCurrencyType", "expand", "Ljava/lang/String;", "getExpand", "()Ljava/lang/String;", "setExpand", "(Ljava/lang/String;)V", "", "extraParams", "getExtraParams", "setExtraParams", "orderId", "getOrderId", "setOrderId", "", "pollingTimeout", "Z", "getPollingTimeout", "()Z", "setPollingTimeout", "(Z)V", "status", "getStatus", "setStatus", "uid", "getUid", "setUid", "usedChannel", "getUsedChannel", "setUsedChannel", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PayResultInfo {
    public long amount;
    public Map<String, String> appClientExpand;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public Map<String, ? extends Object> extraParams;
    public String orderId;
    public boolean pollingTimeout;
    public int status;
    public long uid;
    public int usedChannel;

    public final long getAmount() {
        return this.amount;
    }

    public final Map<String, String> getAppClientExpand() {
        return this.appClientExpand;
    }

    public final int getAppid() {
        return this.appid;
    }

    public final long getCurrencyAmount() {
        return this.currencyAmount;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final String getExpand() {
        return this.expand;
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final boolean getPollingTimeout() {
        return this.pollingTimeout;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int getUsedChannel() {
        return this.usedChannel;
    }

    public final void setAmount(long j) {
        this.amount = j;
    }

    public final void setAppClientExpand(Map<String, String> map) {
        this.appClientExpand = map;
    }

    public final void setAppid(int i) {
        this.appid = i;
    }

    public final void setCurrencyAmount(long j) {
        this.currencyAmount = j;
    }

    public final void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public final void setExpand(String str) {
        this.expand = str;
    }

    public final void setExtraParams(Map<String, ? extends Object> map) {
        this.extraParams = map;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPollingTimeout(boolean z) {
        this.pollingTimeout = z;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void setUsedChannel(int i) {
        this.usedChannel = i;
    }
}
