package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes11.dex */
public class b {
    private boolean bEE = true;
    private PermissionJudgePolicy bEF;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean SB() {
        if (checkPermission()) {
            return true;
        }
        if (this.bEE && this.bEF != null) {
            this.bEF.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bEF == null) {
            this.bEF = new PermissionJudgePolicy();
            this.bEF.clearRequestPermissionList();
            this.bEF.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bEF.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bEF.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bEF.checkPermissionListGranted(this.mActivity);
    }
}
