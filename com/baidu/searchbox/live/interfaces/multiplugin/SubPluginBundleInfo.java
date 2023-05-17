package com.baidu.searchbox.live.interfaces.multiplugin;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J4\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0003¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "packageName", "minVersion", "maxVersion", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/Integer;", "getMaxVersion", "getMinVersion", "Ljava/lang/String;", "getPackageName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class SubPluginBundleInfo {
    public final Integer maxVersion;
    public final Integer minVersion;
    public final String packageName;

    public static /* synthetic */ SubPluginBundleInfo copy$default(SubPluginBundleInfo subPluginBundleInfo, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subPluginBundleInfo.packageName;
        }
        if ((i & 2) != 0) {
            num = subPluginBundleInfo.minVersion;
        }
        if ((i & 4) != 0) {
            num2 = subPluginBundleInfo.maxVersion;
        }
        return subPluginBundleInfo.copy(str, num, num2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final Integer component2() {
        return this.minVersion;
    }

    public final Integer component3() {
        return this.maxVersion;
    }

    public final SubPluginBundleInfo copy(String str, Integer num, Integer num2) {
        return new SubPluginBundleInfo(str, num, num2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubPluginBundleInfo) {
                SubPluginBundleInfo subPluginBundleInfo = (SubPluginBundleInfo) obj;
                return Intrinsics.areEqual(this.packageName, subPluginBundleInfo.packageName) && Intrinsics.areEqual(this.minVersion, subPluginBundleInfo.minVersion) && Intrinsics.areEqual(this.maxVersion, subPluginBundleInfo.maxVersion);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.packageName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.minVersion;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.maxVersion;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public SubPluginBundleInfo(String str, Integer num, Integer num2) {
        this.packageName = str;
        this.minVersion = num;
        this.maxVersion = num2;
    }

    public /* synthetic */ SubPluginBundleInfo(String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2);
    }

    public final Integer getMaxVersion() {
        return this.maxVersion;
    }

    public final Integer getMinVersion() {
        return this.minVersion;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public String toString() {
        return "SubBundleInfo{ packageName=" + this.packageName + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + " }";
    }
}
