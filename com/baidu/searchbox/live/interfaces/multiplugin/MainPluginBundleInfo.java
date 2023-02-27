package com.baidu.searchbox.live.interfaces.multiplugin;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000Bg\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0003Jp\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001f\u0010\u0003R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\u0003R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b\u0012\u0010\tR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u0013\u0010\tR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b#\u0010\u0003R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b$\u0010\tR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b%\u0010\u0003R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b&\u0010\u0003R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u0006¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/multiplugin/MainPluginBundleInfo;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/Boolean;", "component4", "component5", "component6", "component7", "component8", "packageName", PushService.APP_VERSION_CODE, "needUpdate", "isMainBundle", "isSubBundle", "mainBundle", "subBundle", "ext", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/multiplugin/MainPluginBundleInfo;", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getExt", "Ljava/lang/Boolean;", "getMainBundle", "getNeedUpdate", "getPackageName", "getSubBundle", "Ljava/lang/Integer;", "getVersionCode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MainPluginBundleInfo {
    public final String ext;
    public final Boolean isMainBundle;
    public final Boolean isSubBundle;
    public final String mainBundle;
    public final Boolean needUpdate;
    public final String packageName;
    public final String subBundle;
    public final Integer versionCode;

    public MainPluginBundleInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final String component1() {
        return this.packageName;
    }

    public final Integer component2() {
        return this.versionCode;
    }

    public final Boolean component3() {
        return this.needUpdate;
    }

    public final Boolean component4() {
        return this.isMainBundle;
    }

    public final Boolean component5() {
        return this.isSubBundle;
    }

    public final String component6() {
        return this.mainBundle;
    }

    public final String component7() {
        return this.subBundle;
    }

    public final String component8() {
        return this.ext;
    }

    public final MainPluginBundleInfo copy(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, String str4) {
        return new MainPluginBundleInfo(str, num, bool, bool2, bool3, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MainPluginBundleInfo) {
                MainPluginBundleInfo mainPluginBundleInfo = (MainPluginBundleInfo) obj;
                return Intrinsics.areEqual(this.packageName, mainPluginBundleInfo.packageName) && Intrinsics.areEqual(this.versionCode, mainPluginBundleInfo.versionCode) && Intrinsics.areEqual(this.needUpdate, mainPluginBundleInfo.needUpdate) && Intrinsics.areEqual(this.isMainBundle, mainPluginBundleInfo.isMainBundle) && Intrinsics.areEqual(this.isSubBundle, mainPluginBundleInfo.isSubBundle) && Intrinsics.areEqual(this.mainBundle, mainPluginBundleInfo.mainBundle) && Intrinsics.areEqual(this.subBundle, mainPluginBundleInfo.subBundle) && Intrinsics.areEqual(this.ext, mainPluginBundleInfo.ext);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.packageName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.versionCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.needUpdate;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isMainBundle;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isSubBundle;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str2 = this.mainBundle;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subBundle;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ext;
        return hashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public MainPluginBundleInfo(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, String str4) {
        this.packageName = str;
        this.versionCode = num;
        this.needUpdate = bool;
        this.isMainBundle = bool2;
        this.isSubBundle = bool3;
        this.mainBundle = str2;
        this.subBundle = str3;
        this.ext = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MainPluginBundleInfo(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r8, (i & 128) == 0 ? str4 : "");
        String str5;
        Integer num2;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        String str6;
        String str7;
        if ((i & 1) != 0) {
            str5 = "";
        } else {
            str5 = str;
        }
        if ((i & 2) != 0) {
            num2 = 0;
        } else {
            num2 = num;
        }
        if ((i & 4) != 0) {
            bool4 = Boolean.FALSE;
        } else {
            bool4 = bool;
        }
        if ((i & 8) != 0) {
            bool5 = Boolean.FALSE;
        } else {
            bool5 = bool2;
        }
        if ((i & 16) != 0) {
            bool6 = Boolean.FALSE;
        } else {
            bool6 = bool3;
        }
        if ((i & 32) != 0) {
            str6 = "";
        } else {
            str6 = str2;
        }
        if ((i & 64) != 0) {
            str7 = "";
        } else {
            str7 = str3;
        }
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getMainBundle() {
        return this.mainBundle;
    }

    public final Boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSubBundle() {
        return this.subBundle;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public final Boolean isMainBundle() {
        return this.isMainBundle;
    }

    public final Boolean isSubBundle() {
        return this.isSubBundle;
    }

    public String toString() {
        return "PluginBundleInfo{ packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", needUpdate=" + this.needUpdate + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isMainBundle=" + this.isMainBundle + ", isSubBundle=" + this.isSubBundle + StringUtil.ARRAY_ELEMENT_SEPARATOR + "mainBundle=" + this.mainBundle + ", subBundle=" + this.subBundle + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ext=" + this.ext + " }";
    }
}
