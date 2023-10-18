package com.baidu.searchbox.dyesdk.data;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/dyesdk/data/RawDyeInfo;", "", "bizName", "", "nodeName", "rawDyeString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizName", "()Ljava/lang/String;", "getNodeName", "getRawDyeString", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "", "toString", "lib-dye-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RawDyeInfo {
    public final String bizName;
    public final String nodeName;
    public final String rawDyeString;

    public static /* synthetic */ RawDyeInfo copy$default(RawDyeInfo rawDyeInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rawDyeInfo.bizName;
        }
        if ((i & 2) != 0) {
            str2 = rawDyeInfo.nodeName;
        }
        if ((i & 4) != 0) {
            str3 = rawDyeInfo.rawDyeString;
        }
        return rawDyeInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.bizName;
    }

    public final String component2() {
        return this.nodeName;
    }

    public final String component3() {
        return this.rawDyeString;
    }

    public final RawDyeInfo copy(String bizName, String nodeName, String rawDyeString) {
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(rawDyeString, "rawDyeString");
        return new RawDyeInfo(bizName, nodeName, rawDyeString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RawDyeInfo) {
            RawDyeInfo rawDyeInfo = (RawDyeInfo) obj;
            return Intrinsics.areEqual(this.bizName, rawDyeInfo.bizName) && Intrinsics.areEqual(this.nodeName, rawDyeInfo.nodeName) && Intrinsics.areEqual(this.rawDyeString, rawDyeInfo.rawDyeString);
        }
        return false;
    }

    public int hashCode() {
        return (((this.bizName.hashCode() * 31) + this.nodeName.hashCode()) * 31) + this.rawDyeString.hashCode();
    }

    public String toString() {
        return "RawDyeInfo(bizName=" + this.bizName + ", nodeName=" + this.nodeName + ", rawDyeString=" + this.rawDyeString + ')';
    }

    public RawDyeInfo(String bizName, String nodeName, String rawDyeString) {
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(rawDyeString, "rawDyeString");
        this.bizName = bizName;
        this.nodeName = nodeName;
        this.rawDyeString = rawDyeString;
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public final String getRawDyeString() {
        return this.rawDyeString;
    }
}
