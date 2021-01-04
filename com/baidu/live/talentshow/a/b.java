package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes11.dex */
public class b {
    private boolean bFK = true;
    private PermissionJudgePolicy bFL;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean UM() {
        if (checkPermission()) {
            return true;
        }
        if (this.bFK && this.bFL != null) {
            this.bFL.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bFL == null) {
            this.bFL = new PermissionJudgePolicy();
            this.bFL.clearRequestPermissionList();
            this.bFL.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bFL.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bFL.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bFL.checkPermissionListGranted(this.mActivity);
    }
}
