package com.baidu.searchbox.config.impl;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/config/impl/IFontSizeBusiness;", "", "autoSyncSystemFontSize", "", "getDefaultLevel", "", "isDebug", "", "isNeedDialog", "isNeedToast", "isNewUserInstaller", "isNormalUserInstaller", "isOuterCall", "launchSource", "", "isUpdateUserInstall", "lastOperateFontType", "launchFontSizeStatistic", "setIsActivelySetFont", "isActivelySetFont", "showFontMenu", "context", "Landroid/content/Context;", "showFontSizeMenu", "activity", "Landroid/app/Activity;", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFontSizeBusiness {
    void autoSyncSystemFontSize();

    int getDefaultLevel();

    boolean isDebug();

    boolean isNeedDialog();

    boolean isNeedToast();

    boolean isNewUserInstaller();

    boolean isNormalUserInstaller();

    boolean isOuterCall(String str);

    boolean isUpdateUserInstall();

    int lastOperateFontType();

    void launchFontSizeStatistic();

    void setIsActivelySetFont(boolean z);

    void showFontMenu(Context context);

    void showFontSizeMenu(Activity activity);
}
