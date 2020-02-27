package com.baidu.searchbox.suspensionwindow.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class PermissionActivity extends Activity {
    private static final int REQUEST_CODE = 101;
    private static List<PermissionListener> mPermissionListenerList;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            requestAlertWindowPermission();
        } else {
            finish();
        }
    }

    @RequiresApi(api = 23)
    private void requestAlertWindowPermission() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 101);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 101) {
            if (PermissionUtil.hasPermission(this)) {
                if (mPermissionListenerList != null && !mPermissionListenerList.isEmpty()) {
                    for (PermissionListener permissionListener : mPermissionListenerList) {
                        permissionListener.onSuccess();
                    }
                    mPermissionListenerList.clear();
                    mPermissionListenerList = null;
                }
            } else if (mPermissionListenerList != null && !mPermissionListenerList.isEmpty()) {
                for (PermissionListener permissionListener2 : mPermissionListenerList) {
                    permissionListener2.onFail();
                }
                mPermissionListenerList.clear();
                mPermissionListenerList = null;
            }
        }
        finish();
    }

    public static synchronized void request(Context context, PermissionListener permissionListener) {
        synchronized (PermissionActivity.class) {
            if (PermissionUtil.hasPermission(context)) {
                permissionListener.onSuccess();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (mPermissionListenerList == null) {
                    mPermissionListenerList = new ArrayList();
                }
                if (!mPermissionListenerList.contains(permissionListener)) {
                    mPermissionListenerList.add(permissionListener);
                }
                Intent intent = new Intent(context, PermissionActivity.class);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } else {
                permissionListener.onFail();
            }
        }
    }
}
