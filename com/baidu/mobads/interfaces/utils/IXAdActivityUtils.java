package com.baidu.mobads.interfaces.utils;

import android.app.Activity;
import android.content.DialogInterface;
/* loaded from: classes5.dex */
public interface IXAdActivityUtils {
    Boolean isFullScreen(Activity activity);

    void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2);

    boolean webviewMultiProcess(Activity activity);
}
