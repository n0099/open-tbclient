package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionRequestDialog;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.i0.r.s.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PermissionJudgePolicy {
    public static final int EMPTY_REQUEST_CODE = -1;
    public static final ArrayList<String> NEED_EXTRA_DIALOG_PERMISSIONS = new ArrayList<>(Arrays.asList(PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_COARSE_LOCATION"));
    public PermissionDialogClickListener mDialogClickListener;
    public IExtraDialogCloseCallback mIExtraDialogCloseCallback;
    public ISystemPermissionDialogShowCallBack mISystemPermissionDialogShowCallBack;
    public List<String> mNeedExtraDialogPermissionList;
    public OnPermissionsGrantedListener mOnPermissionsGrantedListener;
    public PermissionRequestDialog mPermissionRequestDialog;
    public int mRequestCode = -1;
    public EXTRA_DIALOG_REFUSE_POLICY mExtraDialogRefusePolicy = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
    public PermissionRequestDialog.OnClickCallback mExtraDialogRejectAllCallback = new PermissionRequestDialog.OnClickCallback() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
        @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
        public void onClickClose(Activity activity, String str) {
            if (PermissionJudgePolicy.this.mPermissionRequestDialog == null) {
                return;
            }
            PermissionJudgePolicy.this.mPermissionRequestDialog.dismiss();
            if (PermissionJudgePolicy.this.mIExtraDialogCloseCallback != null) {
                PermissionJudgePolicy.this.mIExtraDialogCloseCallback.onClose();
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
        public void onClickContinue(Activity activity, String str) {
            if (PermissionJudgePolicy.this.mPermissionRequestDialog == null) {
                return;
            }
            PermissionJudgePolicy.this.mNeedExtraDialogPermissionList.remove(str);
            if (!ListUtils.isEmpty(PermissionJudgePolicy.this.mNeedExtraDialogPermissionList)) {
                PermissionJudgePolicy.this.processExtraPermissionDialog(activity);
                return;
            }
            PermissionJudgePolicy.this.mPermissionRequestDialog.dismiss();
            PermissionJudgePolicy permissionJudgePolicy = PermissionJudgePolicy.this;
            permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
        }
    };
    public PermissionRequestDialog.OnClickCallback mExtraDialogRefuseOneByOneCallback = new PermissionRequestDialog.OnClickCallback() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
        @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
        public void onClickClose(Activity activity, String str) {
            PermissionJudgePolicy.this.requestPermissionList.remove(str);
            PermissionJudgePolicy.this.mNeedExtraDialogPermissionList.remove(str);
            if (!ListUtils.isEmpty(PermissionJudgePolicy.this.mNeedExtraDialogPermissionList)) {
                PermissionJudgePolicy.this.processExtraPermissionDialog(activity);
                return;
            }
            PermissionJudgePolicy.this.mPermissionRequestDialog.dismiss();
            PermissionJudgePolicy permissionJudgePolicy = PermissionJudgePolicy.this;
            permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
        public void onClickContinue(Activity activity, String str) {
            PermissionJudgePolicy.this.mNeedExtraDialogPermissionList.remove(str);
            if (!ListUtils.isEmpty(PermissionJudgePolicy.this.mNeedExtraDialogPermissionList)) {
                PermissionJudgePolicy.this.processExtraPermissionDialog(activity);
                return;
            }
            PermissionJudgePolicy.this.mPermissionRequestDialog.dismiss();
            PermissionJudgePolicy permissionJudgePolicy = PermissionJudgePolicy.this;
            permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
        }
    };
    public ArrayList<String> requestPermissionList = new ArrayList<>();

    /* loaded from: classes3.dex */
    public enum EXTRA_DIALOG_REFUSE_POLICY {
        Reject_all,
        Refuse_one_by_one
    }

    /* loaded from: classes3.dex */
    public interface IExtraDialogCloseCallback {
        void onClose();
    }

    /* loaded from: classes3.dex */
    public interface ISystemPermissionDialogShowCallBack {
        void onShow();
    }

    /* loaded from: classes3.dex */
    public interface OnPermissionsGrantedListener {
        void onPermissionsGranted();
    }

    /* loaded from: classes3.dex */
    public interface PermissionDialogClickListener {
        void onDialogCaneled(String str);

        void onDialogComfirmed(String str);
    }

    private List<String> getNeedExtraDialogPermissionList() {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (NEED_EXTRA_DIALOG_PERMISSIONS.contains(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private f getPageContext(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        return null;
    }

    private int getPermissionDescriptionId(String str) {
        if (TextUtils.isEmpty(str)) {
            return R.string.request_permission_default_text;
        }
        if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equals(str)) {
            return R.string.request_permission_default_text;
        }
        if (!"android.permission.ACCESS_FINE_LOCATION".equals(str) && !"android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equals(str)) {
                return R.string.request_permission_camera;
            }
            if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(str)) {
                return R.string.request_permission_microphone;
            }
            if ("android.permission.READ_PHONE_STATE".equals(str)) {
                return R.string.request_permission_contacts;
            }
            if ("android.permission.SEND_SMS".equals(str)) {
                return R.string.request_permission_sms;
            }
            if ("android.permission.CALL_PHONE".equals(str)) {
                return R.string.request_permission_cellphone;
            }
            return R.string.request_permission_default_text;
        }
        return R.string.request_permission_location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processExtraPermissionDialog(Activity activity) {
        if (getPageContext(activity) == null || ListUtils.isEmpty(this.mNeedExtraDialogPermissionList)) {
            return;
        }
        if (this.mPermissionRequestDialog == null) {
            PermissionRequestDialog permissionRequestDialog = new PermissionRequestDialog(activity);
            this.mPermissionRequestDialog = permissionRequestDialog;
            if (this.mExtraDialogRefusePolicy == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                permissionRequestDialog.setOnClickCallback(this.mExtraDialogRefuseOneByOneCallback);
            } else {
                permissionRequestDialog.setOnClickCallback(this.mExtraDialogRejectAllCallback);
            }
        }
        this.mPermissionRequestDialog.setRequestPermission(this.mNeedExtraDialogPermissionList.get(0));
        this.mPermissionRequestDialog.create(getPageContext(activity));
        this.mPermissionRequestDialog.onChangeSkinType();
        this.mPermissionRequestDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRequestPermissionForSystem(Activity activity, int i2) {
        if (ListUtils.isEmpty(this.requestPermissionList)) {
            return;
        }
        ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack = this.mISystemPermissionDialogShowCallBack;
        if (iSystemPermissionDialogShowCallBack != null) {
            iSystemPermissionDialogShowCallBack.onShow();
        }
        if (i2 == -1) {
            startRequestPermissionInternal(activity);
        } else {
            startRequestPermissionInternal(activity, i2);
        }
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            ActivityCompat.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), 25040);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void appendRequestPermission(Activity activity, String str) {
        if (TextUtils.isEmpty(str) || checkPermissionGranted(activity, str)) {
            return;
        }
        this.requestPermissionList.add(str);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        a aVar = new a(activity);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setTitle(R.string.request_permission_default_title);
        aVar.setMessageId(getPermissionDescriptionId(str));
        aVar.setPositiveButton(R.string.isopen, new a.e() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
            @Override // d.a.i0.r.s.a.e
            public void onClick(a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (PermissionJudgePolicy.this.mDialogClickListener != null) {
                    PermissionJudgePolicy.this.mDialogClickListener.onDialogComfirmed(str);
                }
            }
        }).setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
            @Override // d.a.i0.r.s.a.e
            public void onClick(a aVar2) {
                aVar2.dismiss();
                if (PermissionJudgePolicy.this.mDialogClickListener != null) {
                    PermissionJudgePolicy.this.mDialogClickListener.onDialogCaneled(str);
                }
            }
        }).create(j.a(activity));
        aVar.show();
        return false;
    }

    public boolean checkPermissionGranted(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return ContextCompat.checkPermissionGranted(activity, str);
    }

    public void clearRequestPermissionList() {
        ArrayList<String> arrayList = this.requestPermissionList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void onPermissionsGranted() {
        OnPermissionsGrantedListener onPermissionsGrantedListener = this.mOnPermissionsGrantedListener;
        if (onPermissionsGrantedListener != null) {
            onPermissionsGrantedListener.onPermissionsGranted();
        }
    }

    public void setDialogClickListener(PermissionDialogClickListener permissionDialogClickListener) {
        this.mDialogClickListener = permissionDialogClickListener;
    }

    public void setOnPermissionsGrantedListener(OnPermissionsGrantedListener onPermissionsGrantedListener) {
        this.mOnPermissionsGrantedListener = onPermissionsGrantedListener;
    }

    public boolean startRequestPermission(Activity activity) {
        return startRequestPermission(activity, -1);
    }

    public boolean startRequestPermission(Activity activity, int i2) {
        return startRequestPermission(activity, i2, EXTRA_DIALOG_REFUSE_POLICY.Reject_all, null);
    }

    public boolean startRequestPermission(Activity activity, int i2, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy, IExtraDialogCloseCallback iExtraDialogCloseCallback, ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack) {
        this.mISystemPermissionDialogShowCallBack = iSystemPermissionDialogShowCallBack;
        return startRequestPermission(activity, i2, extra_dialog_refuse_policy, iExtraDialogCloseCallback);
    }

    private void startRequestPermissionInternal(Activity activity, int i2) {
        if (activity == null) {
            return;
        }
        try {
            ActivityCompat.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean startRequestPermission(Activity activity, int i2, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy, IExtraDialogCloseCallback iExtraDialogCloseCallback) {
        this.mRequestCode = i2;
        this.mExtraDialogRefusePolicy = extra_dialog_refuse_policy;
        this.mIExtraDialogCloseCallback = iExtraDialogCloseCallback;
        if (!ApiUtil.shouldCheckPermission()) {
            onPermissionsGranted();
            return false;
        } else if (ListUtils.isEmpty(this.requestPermissionList)) {
            onPermissionsGranted();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            this.mNeedExtraDialogPermissionList = getNeedExtraDialogPermissionList();
            if (getPageContext(activity) != null && !ListUtils.isEmpty(this.mNeedExtraDialogPermissionList)) {
                processExtraPermissionDialog(activity);
                return true;
            }
            startRequestPermissionForSystem(activity, this.mRequestCode);
            return true;
        }
    }
}
