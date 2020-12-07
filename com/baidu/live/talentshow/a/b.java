package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class b {
    private boolean bAX = true;
    private PermissionJudgePolicy bAY;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean TH() {
        if (checkPermission()) {
            return true;
        }
        if (this.bAX && this.bAY != null) {
            this.bAY.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bAY == null) {
            this.bAY = new PermissionJudgePolicy();
            this.bAY.clearRequestPermissionList();
            this.bAY.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bAY.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bAY.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bAY.checkPermissionListGranted(this.mActivity);
    }
}
