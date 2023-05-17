package com.baidu.searchbox.account.result;

import androidx.core.content.FileProvider;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/account/result/BoxLoginHistoryModel;", "", "uid", "", FileProvider.DISPLAYNAME_FIELD, TbEnum.SystemMessage.KEY_USER_NAME, "portrait", SyncAccountUtils.KEY_PORTRAIT_SIGN, Config.TRACE_VISIT_RECENT, "", "loginType", "bduss", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getBduss", "()Ljava/lang/String;", "getDisplayName", "getLoginType", "getPortrait", "getPortraitSign", "getRecent", "()Z", "getUid", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", TTDownloadField.TT_HASHCODE, "", "toString", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoxLoginHistoryModel {
    public final String bduss;
    public final String displayName;
    public final String loginType;
    public final String portrait;
    public final String portraitSign;
    public final boolean recent;
    public final String uid;
    public final String userName;

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.portrait;
    }

    public final String component5() {
        return this.portraitSign;
    }

    public final boolean component6() {
        return this.recent;
    }

    public final String component7() {
        return this.loginType;
    }

    public final String component8() {
        return this.bduss;
    }

    public final BoxLoginHistoryModel copy(String uid, String displayName, String userName, String portrait, String portraitSign, boolean z, String loginType, String bduss) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        Intrinsics.checkNotNullParameter(portraitSign, "portraitSign");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(bduss, "bduss");
        return new BoxLoginHistoryModel(uid, displayName, userName, portrait, portraitSign, z, loginType, bduss);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoxLoginHistoryModel) {
            BoxLoginHistoryModel boxLoginHistoryModel = (BoxLoginHistoryModel) obj;
            return Intrinsics.areEqual(this.uid, boxLoginHistoryModel.uid) && Intrinsics.areEqual(this.displayName, boxLoginHistoryModel.displayName) && Intrinsics.areEqual(this.userName, boxLoginHistoryModel.userName) && Intrinsics.areEqual(this.portrait, boxLoginHistoryModel.portrait) && Intrinsics.areEqual(this.portraitSign, boxLoginHistoryModel.portraitSign) && this.recent == boxLoginHistoryModel.recent && Intrinsics.areEqual(this.loginType, boxLoginHistoryModel.loginType) && Intrinsics.areEqual(this.bduss, boxLoginHistoryModel.bduss);
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.uid.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.portrait.hashCode()) * 31) + this.portraitSign.hashCode()) * 31;
        boolean z = this.recent;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.loginType.hashCode()) * 31) + this.bduss.hashCode();
    }

    public String toString() {
        return "BoxLoginHistoryModel(uid=" + this.uid + ", displayName=" + this.displayName + ", userName=" + this.userName + ", portrait=" + this.portrait + ", portraitSign=" + this.portraitSign + ", recent=" + this.recent + ", loginType=" + this.loginType + ", bduss=" + this.bduss + ')';
    }

    public BoxLoginHistoryModel(String uid, String displayName, String userName, String portrait, String portraitSign, boolean z, String loginType, String bduss) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        Intrinsics.checkNotNullParameter(portraitSign, "portraitSign");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(bduss, "bduss");
        this.uid = uid;
        this.displayName = displayName;
        this.userName = userName;
        this.portrait = portrait;
        this.portraitSign = portraitSign;
        this.recent = z;
        this.loginType = loginType;
        this.bduss = bduss;
    }

    public final String getBduss() {
        return this.bduss;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final String getPortrait() {
        return this.portrait;
    }

    public final String getPortraitSign() {
        return this.portraitSign;
    }

    public final boolean getRecent() {
        return this.recent;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUserName() {
        return this.userName;
    }
}
