package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class b {
    private boolean bxy = true;
    private PermissionJudgePolicy bxz;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean RS() {
        if (checkPermission()) {
            return true;
        }
        if (this.bxy && this.bxz != null) {
            this.bxz.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bxz == null) {
            this.bxz = new PermissionJudgePolicy();
            this.bxz.clearRequestPermissionList();
            this.bxz.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bxz.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bxz.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bxz.checkPermissionListGranted(this.mActivity);
    }
}
