package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
/* loaded from: classes8.dex */
public class c implements IXAdActivityUtils {
    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public Boolean isFullScreen(Activity activity) {
        boolean z;
        try {
            if (activity != null) {
                z = Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (activity != null) {
            try {
                new AlertDialog.Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }
}
