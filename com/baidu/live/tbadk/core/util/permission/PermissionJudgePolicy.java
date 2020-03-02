package com.baidu.live.tbadk.core.util.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.k.a;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PermissionJudgePolicy {
    private PermissionDialogClickListener mDialogClickListener;
    private OnPermissionsGrantedListener mOnPermissionsGrantedListener;
    private ArrayList<String> requestPermissionList = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface OnPermissionsGrantedListener {
        void onPermissionsGranted();
    }

    /* loaded from: classes3.dex */
    public interface PermissionDialogClickListener {
        void onDialogCaneled(String str);

        void onDialogComfirmed(String str);
    }

    public void setDialogClickListener(PermissionDialogClickListener permissionDialogClickListener) {
        this.mDialogClickListener = permissionDialogClickListener;
    }

    public void clearRequestPermissionList() {
        if (this.requestPermissionList != null) {
            this.requestPermissionList.clear();
        }
    }

    public void appendRequestPermission(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !checkPermissionGranted(activity, str)) {
            this.requestPermissionList.add(str);
        }
    }

    public boolean startRequestPermission(Activity activity) {
        return startRequestPermission(activity, false, true);
    }

    public boolean startRequestPermission(Activity activity, boolean z, boolean z2) {
        if (!a.Ex()) {
            onPermissionsGranted();
            return false;
        } else if (ListUtils.isEmpty(this.requestPermissionList)) {
            onPermissionsGranted();
            return false;
        } else {
            if (z) {
                Iterator<String> it = this.requestPermissionList.iterator();
                while (it.hasNext()) {
                    if (!checkPermissionForbidden(activity, it.next(), z2)) {
                        return true;
                    }
                }
            }
            startRequestPermissionInternal(activity);
            return true;
        }
    }

    private boolean checkPermissionGranted(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.k.a.a.checkPermissionGranted(activity, str);
    }

    public boolean checkPermissionListGranted(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (this.requestPermissionList == null || this.requestPermissionList.size() <= 0) {
            return true;
        }
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            if (!checkPermissionGranted(activity, it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPermissionForbidden(Activity activity, String str) {
        return checkPermissionForbidden(activity, str, true);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str, boolean z) {
        if (checkPermissionGranted(activity, str)) {
            return true;
        }
        String currentAppType = currentAppType(activity);
        boolean z2 = SharedPrefHelper.getInstance().getBoolean(str, false);
        SharedPrefHelper.getInstance().putBoolean(str, true);
        if (!z2 || com.baidu.k.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        if (!z) {
            goToSettings(activity);
            return false;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(activity);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setTitle(a.i.sdk_request_permission_default_title);
        bdAlertDialog.setMessageId(getPermissionDescriptionId(str), currentAppType, currentAppType);
        bdAlertDialog.setPositiveButton(a.i.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                PermissionJudgePolicy.this.goToSettings(activity);
                if (PermissionJudgePolicy.this.mDialogClickListener != null) {
                    PermissionJudgePolicy.this.mDialogClickListener.onDialogComfirmed(str);
                }
            }
        }).setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (PermissionJudgePolicy.this.mDialogClickListener != null) {
                    PermissionJudgePolicy.this.mDialogClickListener.onDialogCaneled(str);
                }
            }
        }).create(IScrollableHelper.getBbPageContext(activity));
        bdAlertDialog.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSettings(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            activity.startActivity(intent);
        }
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.k.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), RequestResponseCode.REQUEST_PERMISSION_JUDGEMENT);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int getPermissionDescriptionId(String str) {
        if (TextUtils.isEmpty(str)) {
            return a.i.sdk_request_permission_default_text;
        }
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return a.i.sdk_request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return a.i.sdk_request_permission_location;
        }
        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equals(str)) {
            return a.i.sdk_request_permission_camera;
        }
        if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(str)) {
            return a.i.sdk_request_permission_microphone;
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return a.i.sdk_request_permission_contacts;
        }
        if ("android.permission.SEND_SMS".equals(str)) {
            return a.i.sdk_request_permission_sms;
        }
        if ("android.permission.CALL_PHONE".equals(str)) {
            return a.i.sdk_request_permission_cellphone;
        }
        return a.i.sdk_request_permission_default_text;
    }

    private String currentAppType(Activity activity) {
        if (activity != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_hk_text);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_qm_text);
            }
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_bd_text);
            }
            if (TbadkCoreApplication.getInst().isOther() && !TextUtils.isEmpty(TbConfig.getSubappName())) {
                return TbConfig.getSubappName();
            }
            return activity.getResources().getString(a.i.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    public void setOnPermissionsGrantedListener(OnPermissionsGrantedListener onPermissionsGrantedListener) {
        this.mOnPermissionsGrantedListener = onPermissionsGrantedListener;
    }

    public void onPermissionsGranted() {
        if (this.mOnPermissionsGrantedListener != null) {
            this.mOnPermissionsGrantedListener.onPermissionsGranted();
        }
    }
}
