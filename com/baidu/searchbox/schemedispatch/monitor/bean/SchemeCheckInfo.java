package com.baidu.searchbox.schemedispatch.monitor.bean;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0010J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/monitor/bean/SchemeCheckInfo;", "Lcom/baidu/searchbox/NoProGuard;", "scheme", "", "noAlert", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNoAlert", "()Ljava/lang/String;", "getScheme", "getTitle", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "notAlert", "toString", "lib-security-openapp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SchemeCheckInfo implements NoProGuard {
    public final String noAlert;
    public final String scheme;
    public final String title;

    public static /* synthetic */ SchemeCheckInfo copy$default(SchemeCheckInfo schemeCheckInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schemeCheckInfo.scheme;
        }
        if ((i & 2) != 0) {
            str2 = schemeCheckInfo.noAlert;
        }
        if ((i & 4) != 0) {
            str3 = schemeCheckInfo.title;
        }
        return schemeCheckInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.scheme;
    }

    public final String component2() {
        return this.noAlert;
    }

    public final String component3() {
        return this.title;
    }

    public final SchemeCheckInfo copy(String scheme, String noAlert, String str) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(noAlert, "noAlert");
        return new SchemeCheckInfo(scheme, noAlert, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SchemeCheckInfo) {
            SchemeCheckInfo schemeCheckInfo = (SchemeCheckInfo) obj;
            return Intrinsics.areEqual(this.scheme, schemeCheckInfo.scheme) && Intrinsics.areEqual(this.noAlert, schemeCheckInfo.noAlert) && Intrinsics.areEqual(this.title, schemeCheckInfo.title);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.scheme.hashCode() * 31) + this.noAlert.hashCode()) * 31;
        String str = this.title;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SchemeCheckInfo(scheme=" + this.scheme + ", noAlert=" + this.noAlert + ", title=" + this.title + ')';
    }

    public SchemeCheckInfo(String scheme, String noAlert, String str) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(noAlert, "noAlert");
        this.scheme = scheme;
        this.noAlert = noAlert;
        this.title = str;
    }

    public final String getNoAlert() {
        return this.noAlert;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean notAlert() {
        return Intrinsics.areEqual(this.noAlert, "1");
    }
}
