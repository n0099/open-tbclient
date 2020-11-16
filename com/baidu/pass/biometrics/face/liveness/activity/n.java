package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.webkit.sdk.PermissionRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.b f2743a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.b bVar) {
        this.b = livenessRecogActivity;
        this.f2743a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewUtility.dismissDialog(this.b, this.f2743a);
        this.b.P.y = true;
        this.b.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
    }
}
