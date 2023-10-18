package com.baidu.searchbox.live.interfaces.mix;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "", "clickFrom", "Ljava/lang/String;", "getClickFrom", "()Ljava/lang/String;", "setClickFrom", "(Ljava/lang/String;)V", "", "clickTime", "Ljava/lang/Long;", "getClickTime", "()Ljava/lang/Long;", "setClickTime", "(Ljava/lang/Long;)V", "", "firstJump", "I", "getFirstJump", "()I", "setFirstJump", "(I)V", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class BasePlaySourceInfo {
    public Long clickTime = 0L;
    public String clickFrom = "";
    public int firstJump = 2;

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final Long getClickTime() {
        return this.clickTime;
    }

    public final int getFirstJump() {
        return this.firstJump;
    }

    public final void setClickFrom(String str) {
        this.clickFrom = str;
    }

    public final void setClickTime(Long l) {
        this.clickTime = l;
    }

    public final void setFirstJump(int i) {
        this.firstJump = i;
    }
}
