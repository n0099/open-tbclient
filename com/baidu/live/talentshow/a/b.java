package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class b {
    private boolean bvN = true;
    private PermissionJudgePolicy bvO;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean Rj() {
        if (checkPermission()) {
            return true;
        }
        if (this.bvN && this.bvO != null) {
            this.bvO.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bvO == null) {
            this.bvO = new PermissionJudgePolicy();
            this.bvO.clearRequestPermissionList();
            this.bvO.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bvO.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bvO.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bvO.checkPermissionListGranted(this.mActivity);
    }
}
