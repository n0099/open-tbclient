package com.baidu.sapi2.permissions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes4.dex */
public class PermissionsHelperActivity extends Activity {
    private static final int a = 8000;
    private static final int b = 8001;
    private PermissionsDTO c;
    private PermissionsCallback d;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.d.onSuccess();
                finish();
                return;
            }
            requestPermissions(this.c.permissions, b);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = PassPermissions.getInstance().getPermissionsDTO();
        this.d = PassPermissions.getInstance().getPermissionsCallback();
        requestPermissions(this.c.permissions, b);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == b) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i2] == 0) {
                    Log.i(Log.TAG, "Permission check result is permission granted");
                    i2++;
                } else {
                    AlertDialogInterface dialog = this.d.getDialog(this);
                    if (!TextUtils.isEmpty(this.c.dialogMsg) && dialog != null) {
                        dialog.setTitleText(this.c.dialogTitle);
                        dialog.setMessageText(this.c.dialogMsg);
                        dialog.setNegativeBtn(PayHelper.STATUS_CANCEL_DESC, new View.OnClickListener() { // from class: com.baidu.sapi2.permissions.PermissionsHelperActivity.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PermissionsHelperActivity.this.d.onFailure();
                                PermissionsHelperActivity.this.finish();
                            }
                        });
                        final String str = strArr[i2];
                        dialog.setPositiveBtn("去允许", new View.OnClickListener() { // from class: com.baidu.sapi2.permissions.PermissionsHelperActivity.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PermissionsHelperActivity.this.shouldShowRequestPermissionRationale(str)) {
                                    PermissionsHelperActivity permissionsHelperActivity = PermissionsHelperActivity.this;
                                    permissionsHelperActivity.requestPermissions(permissionsHelperActivity.c.permissions, PermissionsHelperActivity.b);
                                    return;
                                }
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", PermissionsHelperActivity.this.getPackageName(), null));
                                PermissionsHelperActivity.this.startActivityForResult(intent, 8000);
                            }
                        });
                        dialog.setCancel(false);
                        dialog.showDialog();
                    } else {
                        this.d.onFailure();
                        finish();
                        return;
                    }
                }
            }
            if (z) {
                this.d.onSuccess();
                finish();
            }
        }
    }
}
