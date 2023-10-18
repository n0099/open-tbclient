package com.baidu.searchbox.player.model;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/model/AuthStrategyModel;", "", "uaCode", "", "refererCode", "tokenCode", "modeCode", "(IIII)V", "getModeCode", "()I", "getRefererCode", "getTokenCode", "getUaCode", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "toString", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthStrategyModel {
    public final int modeCode;
    public final int refererCode;
    public final int tokenCode;
    public final int uaCode;

    public static /* synthetic */ AuthStrategyModel copy$default(AuthStrategyModel authStrategyModel, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = authStrategyModel.uaCode;
        }
        if ((i5 & 2) != 0) {
            i2 = authStrategyModel.refererCode;
        }
        if ((i5 & 4) != 0) {
            i3 = authStrategyModel.tokenCode;
        }
        if ((i5 & 8) != 0) {
            i4 = authStrategyModel.modeCode;
        }
        return authStrategyModel.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.uaCode;
    }

    public final int component2() {
        return this.refererCode;
    }

    public final int component3() {
        return this.tokenCode;
    }

    public final int component4() {
        return this.modeCode;
    }

    public final AuthStrategyModel copy(int i, int i2, int i3, int i4) {
        return new AuthStrategyModel(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthStrategyModel) {
            AuthStrategyModel authStrategyModel = (AuthStrategyModel) obj;
            return this.uaCode == authStrategyModel.uaCode && this.refererCode == authStrategyModel.refererCode && this.tokenCode == authStrategyModel.tokenCode && this.modeCode == authStrategyModel.modeCode;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.uaCode * 31) + this.refererCode) * 31) + this.tokenCode) * 31) + this.modeCode;
    }

    public String toString() {
        return "AuthStrategyModel(uaCode=" + this.uaCode + ", refererCode=" + this.refererCode + ", tokenCode=" + this.tokenCode + ", modeCode=" + this.modeCode + ')';
    }

    public AuthStrategyModel(int i, int i2, int i3, int i4) {
        this.uaCode = i;
        this.refererCode = i2;
        this.tokenCode = i3;
        this.modeCode = i4;
    }

    public final int getModeCode() {
        return this.modeCode;
    }

    public final int getRefererCode() {
        return this.refererCode;
    }

    public final int getTokenCode() {
        return this.tokenCode;
    }

    public final int getUaCode() {
        return this.uaCode;
    }
}
