package com.baidu.sapi2.permissions;

import android.app.Activity;
/* loaded from: classes2.dex */
public interface PermissionsCallback {
    AlertDialogInterface getDialog(Activity activity);

    void onFailure();

    void onSuccess();
}
