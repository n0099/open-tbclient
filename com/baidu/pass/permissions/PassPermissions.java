package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes3.dex */
public class PassPermissions implements com.baidu.pass.a {
    public static final String TAG = "PassPermissions";
    public static PassPermissions a;
    public PermissionsDTO b;
    public PermissionsCallback c;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b = null;
        this.c = null;
        a = null;
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

    public static boolean checkRequestPermission(String str, Context context) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
            if (Build.VERSION.SDK_INT < 23) {
                if (context.checkCallingOrSelfPermission(str) == 0) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean a(String... strArr) {
        for (String str : strArr) {
            if (!checkRequestPermission(str, this.b.context)) {
                return false;
            }
        }
        return true;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        String[] strArr;
        if (permissionsDTO != null && permissionsDTO.context != null && (strArr = permissionsDTO.permissions) != null && strArr.length != 0 && permissionsCallback != null) {
            this.b = permissionsDTO;
            this.c = new PermissionsCallback() { // from class: com.baidu.pass.permissions.PassPermissions.1
                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    PassPermissions.this.a();
                    permissionsCallback.onFailure(i);
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    PassPermissions.this.a();
                    permissionsCallback.onSuccess();
                }
            };
            if (a(permissionsDTO.permissions)) {
                this.c.onSuccess();
                return;
            } else if (Build.VERSION.SDK_INT < 23) {
                this.c.onFailure(-1);
                return;
            } else {
                Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
                Context context = permissionsDTO.context;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                    return;
                }
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                permissionsDTO.context.startActivity(intent);
                return;
            }
        }
        throw new IllegalArgumentException("params is error");
    }
}
