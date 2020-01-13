package com.baidu.sapi2.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes5.dex */
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

    public PermissionsCallback getPermissionsCallback() {
        return this.c;
    }

    public PermissionsDTO getPermissionsDTO() {
        return this.b;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        String[] strArr;
        if (permissionsDTO != null && permissionsDTO.context != null && (strArr = permissionsDTO.permissions) != null && strArr.length != 0 && permissionsCallback != null) {
            this.b = permissionsDTO;
            this.c = new PermissionsCallback() { // from class: com.baidu.sapi2.permissions.PassPermissions.1
                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public AlertDialogInterface getDialog(Activity activity) {
                    return permissionsCallback.getDialog(activity);
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onFailure() {
                    permissionsCallback.onFailure();
                    PassPermissions.this.a();
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onSuccess() {
                    permissionsCallback.onSuccess();
                    PassPermissions.this.a();
                }
            };
            if (a(permissionsDTO.permissions)) {
                this.c.onSuccess();
                return;
            } else if (Build.VERSION.SDK_INT < 23) {
                this.c.onFailure();
                return;
            } else {
                Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
                Context context = permissionsDTO.context;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                    return;
                }
                intent.setFlags(268435456);
                permissionsDTO.context.startActivity(intent);
                return;
            }
        }
        throw new IllegalArgumentException("params is error");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b = null;
        this.c = null;
        a = null;
    }
}
