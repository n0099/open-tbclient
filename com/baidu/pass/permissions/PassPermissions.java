package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes2.dex */
public class PassPermissions implements com.baidu.pass.a {
    public static final String TAG = "PassPermissions";

    /* renamed from: a  reason: collision with root package name */
    public static PassPermissions f9679a;

    /* renamed from: b  reason: collision with root package name */
    public PermissionsDTO f9680b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsCallback f9681c;

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

    public static synchronized PassPermissions getInstance() {
        PassPermissions passPermissions;
        synchronized (PassPermissions.class) {
            if (f9679a == null) {
                f9679a = new PassPermissions();
            }
            passPermissions = f9679a;
        }
        return passPermissions;
    }

    public PermissionsCallback getPermissionsCallback() {
        return this.f9681c;
    }

    public PermissionsDTO getPermissionsDTO() {
        return this.f9680b;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        String[] strArr;
        if (permissionsDTO != null && permissionsDTO.context != null && (strArr = permissionsDTO.permissions) != null && strArr.length != 0 && permissionsCallback != null) {
            this.f9680b = permissionsDTO;
            this.f9681c = new PermissionsCallback() { // from class: com.baidu.pass.permissions.PassPermissions.1
                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i2) {
                    PassPermissions.this.a();
                    permissionsCallback.onFailure(i2);
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    PassPermissions.this.a();
                    permissionsCallback.onSuccess();
                }
            };
            if (a(permissionsDTO.permissions)) {
                this.f9681c.onSuccess();
                return;
            } else if (Build.VERSION.SDK_INT < 23) {
                this.f9681c.onFailure(-1);
                return;
            } else {
                Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
                Context context = permissionsDTO.context;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                    return;
                }
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                permissionsDTO.context.startActivity(intent);
                return;
            }
        }
        throw new IllegalArgumentException("params is error");
    }

    public boolean a(String... strArr) {
        for (String str : strArr) {
            if (!checkRequestPermission(str, this.f9680b.context)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f9680b = null;
        this.f9681c = null;
        f9679a = null;
    }
}
