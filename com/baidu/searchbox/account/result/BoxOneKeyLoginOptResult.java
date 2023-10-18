package com.baidu.searchbox.account.result;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/account/result/BoxOneKeyLoginOptResult;", "", "code", "", "subCode", "operateType", "", "securityPhone", "(IILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getOperateType", "()Ljava/lang/String;", "setOperateType", "(Ljava/lang/String;)V", "getSecurityPhone", "setSecurityPhone", "getSubCode", "setSubCode", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "toString", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoxOneKeyLoginOptResult {
    public int code;
    public String operateType;
    public String securityPhone;
    public int subCode;

    public static /* synthetic */ BoxOneKeyLoginOptResult copy$default(BoxOneKeyLoginOptResult boxOneKeyLoginOptResult, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = boxOneKeyLoginOptResult.code;
        }
        if ((i3 & 2) != 0) {
            i2 = boxOneKeyLoginOptResult.subCode;
        }
        if ((i3 & 4) != 0) {
            str = boxOneKeyLoginOptResult.operateType;
        }
        if ((i3 & 8) != 0) {
            str2 = boxOneKeyLoginOptResult.securityPhone;
        }
        return boxOneKeyLoginOptResult.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.code;
    }

    public final int component2() {
        return this.subCode;
    }

    public final String component3() {
        return this.operateType;
    }

    public final String component4() {
        return this.securityPhone;
    }

    public final BoxOneKeyLoginOptResult copy(int i, int i2, String operateType, String securityPhone) {
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(securityPhone, "securityPhone");
        return new BoxOneKeyLoginOptResult(i, i2, operateType, securityPhone);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoxOneKeyLoginOptResult) {
            BoxOneKeyLoginOptResult boxOneKeyLoginOptResult = (BoxOneKeyLoginOptResult) obj;
            return this.code == boxOneKeyLoginOptResult.code && this.subCode == boxOneKeyLoginOptResult.subCode && Intrinsics.areEqual(this.operateType, boxOneKeyLoginOptResult.operateType) && Intrinsics.areEqual(this.securityPhone, boxOneKeyLoginOptResult.securityPhone);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.subCode) * 31) + this.operateType.hashCode()) * 31) + this.securityPhone.hashCode();
    }

    public String toString() {
        return "BoxOneKeyLoginOptResult(code=" + this.code + ", subCode=" + this.subCode + ", operateType=" + this.operateType + ", securityPhone=" + this.securityPhone + ')';
    }

    public BoxOneKeyLoginOptResult(int i, int i2, String operateType, String securityPhone) {
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(securityPhone, "securityPhone");
        this.code = i;
        this.subCode = i2;
        this.operateType = operateType;
        this.securityPhone = securityPhone;
    }

    public /* synthetic */ BoxOneKeyLoginOptResult(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getOperateType() {
        return this.operateType;
    }

    public final String getSecurityPhone() {
        return this.securityPhone;
    }

    public final int getSubCode() {
        return this.subCode;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setOperateType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.operateType = str;
    }

    public final void setSecurityPhone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.securityPhone = str;
    }

    public final void setSubCode(int i) {
        this.subCode = i;
    }
}
