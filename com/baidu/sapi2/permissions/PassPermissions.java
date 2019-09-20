package com.baidu.sapi2.permissions;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public class PassPermissions {
    private static PassPermissions a;
    private PermissionsDTO b;
    private PermissionsCallback c;

    private PassPermissions() {
    }

    public static synchronized PassPermissions getInstance() {
        PassPermissions passPermissions;
        synchronized (PassPermissions.class) {
            if (a == null) {
                a = new PassPermissions();
            }
            passPermissions = a;
        }
        return passPermissions;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        if (permissionsDTO == null || permissionsDTO.context == null || permissionsDTO.permissions == null || permissionsDTO.permissions.length == 0 || permissionsCallback == null) {
            throw new IllegalArgumentException("params is error");
        }
        this.b = permissionsDTO;
        this.c = new PermissionsCallback() { // from class: com.baidu.sapi2.permissions.PassPermissions.1
            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onSuccess() {
                permissionsCallback.onSuccess();
                PassPermissions.this.a();
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onFailure() {
                permissionsCallback.onFailure();
                PassPermissions.this.a();
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public AlertDialogInterface getDialog(Activity activity) {
                return permissionsCallback.getDialog(activity);
            }
        };
        if (a(permissionsDTO.permissions)) {
            this.c.onSuccess();
        } else if (Build.VERSION.SDK_INT < 23) {
            this.c.onFailure();
        } else {
            Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
            if (permissionsDTO.context instanceof Activity) {
                permissionsDTO.context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            permissionsDTO.context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String... strArr) {
        for (String str : strArr) {
            if (!SapiUtils.checkRequestPermission(str, this.b.context)) {
                return false;
            }
        }
        return true;
    }

    public PermissionsDTO getPermissionsDTO() {
        return this.b;
    }

    public PermissionsCallback getPermissionsCallback() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b = null;
        this.c = null;
        a = null;
    }
}
