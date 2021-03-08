package com.baidu.live.talentshow.a;

import android.app.Activity;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes10.dex */
public class b {
    private boolean bGe = true;
    private PermissionJudgePolicy bGf;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public boolean SE() {
        if (checkPermission()) {
            return true;
        }
        if (this.bGe && this.bGf != null) {
            this.bGf.startRequestPermission(this.mActivity, true, true);
        }
        return false;
    }

    private boolean checkPermission() {
        if (this.bGf == null) {
            this.bGf = new PermissionJudgePolicy();
            this.bGf.clearRequestPermissionList();
            this.bGf.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.bGf.appendRequestPermission(this.mActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            this.bGf.appendRequestPermission(this.mActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.bGf.checkPermissionListGranted(this.mActivity);
    }
}
