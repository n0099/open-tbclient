package com.baidu.searchbox.config.impl;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/config/impl/DefaultFontSizeBusiness;", "Lcom/baidu/searchbox/config/impl/IFontSizeBusiness;", "()V", "autoSyncSystemFontSize", "", "getDefaultLevel", "", "isDebug", "", "isNeedDialog", "isNeedToast", "isNewUserInstaller", "isNormalUserInstaller", "isOuterCall", "launchSource", "", "isUpdateUserInstall", "lastOperateFontType", "launchFontSizeStatistic", "setIsActivelySetFont", "isActivelySetFont", "showFontMenu", "context", "Landroid/content/Context;", "showFontSizeMenu", "activity", "Landroid/app/Activity;", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultFontSizeBusiness implements IFontSizeBusiness {
    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public void autoSyncSystemFontSize() {
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public int getDefaultLevel() {
        return 1;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isNeedDialog() {
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isNeedToast() {
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isNewUserInstaller() {
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isNormalUserInstaller() {
        return true;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isOuterCall(String launchSource) {
        Intrinsics.checkNotNullParameter(launchSource, "launchSource");
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public boolean isUpdateUserInstall() {
        return false;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public int lastOperateFontType() {
        return 0;
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public void launchFontSizeStatistic() {
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public void setIsActivelySetFont(boolean z) {
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public void showFontMenu(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.searchbox.config.impl.IFontSizeBusiness
    public void showFontSizeMenu(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
