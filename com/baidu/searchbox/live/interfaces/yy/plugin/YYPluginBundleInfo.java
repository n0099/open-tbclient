package com.baidu.searchbox.live.interfaces.yy.plugin;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000B-\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u0003J:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0003R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0003R\u0019\u0010\f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "component4", "packageName", PushService.APP_VERSION_CODE, "needUpdate", "ext", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;IZLjava/lang/String;)Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "", "other", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "Ljava/lang/String;", "getExt", "Z", "getNeedUpdate", "getPackageName", "I", "getVersionCode", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class YYPluginBundleInfo {
    public final String ext;
    public final boolean needUpdate;
    public final String packageName;
    public final int versionCode;

    public static /* synthetic */ YYPluginBundleInfo copy$default(YYPluginBundleInfo yYPluginBundleInfo, String str, int i, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYPluginBundleInfo.packageName;
        }
        if ((i2 & 2) != 0) {
            i = yYPluginBundleInfo.versionCode;
        }
        if ((i2 & 4) != 0) {
            z = yYPluginBundleInfo.needUpdate;
        }
        if ((i2 & 8) != 0) {
            str2 = yYPluginBundleInfo.ext;
        }
        return yYPluginBundleInfo.copy(str, i, z, str2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final int component2() {
        return this.versionCode;
    }

    public final boolean component3() {
        return this.needUpdate;
    }

    public final String component4() {
        return this.ext;
    }

    public final YYPluginBundleInfo copy(String str, int i, boolean z, String str2) {
        return new YYPluginBundleInfo(str, i, z, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof YYPluginBundleInfo) {
                YYPluginBundleInfo yYPluginBundleInfo = (YYPluginBundleInfo) obj;
                return Intrinsics.areEqual(this.packageName, yYPluginBundleInfo.packageName) && this.versionCode == yYPluginBundleInfo.versionCode && this.needUpdate == yYPluginBundleInfo.needUpdate && Intrinsics.areEqual(this.ext, yYPluginBundleInfo.ext);
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.packageName;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.versionCode) * 31;
        boolean z = this.needUpdate;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str2 = this.ext;
        return i2 + (str2 != null ? str2.hashCode() : 0);
    }

    public YYPluginBundleInfo(String str, int i, boolean z, String str2) {
        this.packageName = str;
        this.versionCode = i;
        this.needUpdate = z;
        this.ext = str2;
    }

    public /* synthetic */ YYPluginBundleInfo(String str, int i, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, str2);
    }

    public final String getExt() {
        return this.ext;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public String toString() {
        return "YYPluginBundleInfo { packageName=" + this.packageName + " versionCode=" + this.versionCode + " needUpdate=" + this.needUpdate + " ext=" + this.ext + " }";
    }
}
