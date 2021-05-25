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
    public static PassPermissions f9200a;

    /* renamed from: b  reason: collision with root package name */
    public PermissionsDTO f9201b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsCallback f9202c;

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
            if (f9200a == null) {
                f9200a = new PassPermissions();
            }
            passPermissions = f9200a;
        }
        return passPermissions;
    }

    public PermissionsCallback getPermissionsCallback() {
        return this.f9202c;
    }

    public PermissionsDTO getPermissionsDTO() {
        return this.f9201b;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        String[] strArr;
        if (permissionsDTO != null && permissionsDTO.context != null && (strArr = permissionsDTO.permissions) != null && strArr.length != 0 && permissionsCallback != null) {
            this.f9201b = permissionsDTO;
            this.f9202c = new PermissionsCallback() { // from class: com.baidu.pass.permissions.PassPermissions.1
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
                this.f9202c.onSuccess();
                return;
            } else if (Build.VERSION.SDK_INT < 23) {
                this.f9202c.onFailure(-1);
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
            if (!checkRequestPermission(str, this.f9201b.context)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f9201b = null;
        this.f9202c = null;
        f9200a = null;
    }
}
