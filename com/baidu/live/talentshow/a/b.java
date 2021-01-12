package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes10.dex */
public class b {
    private boolean bAY = true;
    private PermissionJudgePolicy bAZ;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean QR() {
        if (checkPermission()) {
            return true;
        }
        if (this.bAY && this.bAZ != null) {
            this.bAZ.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bAZ == null) {
            this.bAZ = new PermissionJudgePolicy();
            this.bAZ.clearRequestPermissionList();
            this.bAZ.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bAZ.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bAZ.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bAZ.checkPermissionListGranted(this.mActivity);
    }
}
