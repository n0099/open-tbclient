package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.webkit.sdk.PermissionRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.b a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.b bVar) {
        this.b = livenessRecogActivity;
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewUtility.dismissDialog(this.b, this.a);
        this.b.P.y = true;
        this.b.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
    }
}
