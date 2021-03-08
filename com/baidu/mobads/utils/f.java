package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements IXAdActivityUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f2482a = null;

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

    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public boolean webviewMultiProcess(Activity activity) {
        List<ResolveInfo> queryIntentActivities;
        if (f2482a == null && activity != null && (queryIntentActivities = activity.getPackageManager().queryIntentActivities(new Intent(activity, AppActivity.getActivityClass()), 0)) != null && queryIntentActivities.size() > 0) {
            String str = queryIntentActivities.get(0).activityInfo.processName;
            if (!TextUtils.isEmpty(str) && (str.contains(":") || str.endsWith("webview"))) {
                f2482a = true;
            } else {
                f2482a = false;
            }
        }
        if (f2482a != null) {
            return f2482a.booleanValue();
        }
        return false;
    }
}
