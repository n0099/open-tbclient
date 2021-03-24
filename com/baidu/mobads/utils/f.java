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
/* loaded from: classes2.dex */
public class f implements IXAdActivityUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f8528a;

    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public Boolean isFullScreen(Activity activity) {
        try {
            if (activity != null) {
                return Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
            }
            return Boolean.FALSE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (activity == null) {
            return;
        }
        try {
            new AlertDialog.Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdActivityUtils
    public boolean webviewMultiProcess(Activity activity) {
        List<ResolveInfo> queryIntentActivities;
        if (f8528a == null && activity != null && (queryIntentActivities = activity.getPackageManager().queryIntentActivities(new Intent(activity, AppActivity.getActivityClass()), 0)) != null && queryIntentActivities.size() > 0) {
            String str = queryIntentActivities.get(0).activityInfo.processName;
            if (!TextUtils.isEmpty(str) && (str.contains(":") || str.endsWith("webview"))) {
                f8528a = Boolean.TRUE;
            } else {
                f8528a = Boolean.FALSE;
            }
        }
        Boolean bool = f8528a;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
