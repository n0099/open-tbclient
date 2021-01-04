package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.webkit.sdk.PermissionRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.b f4060a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4061b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.b bVar) {
        this.f4061b = livenessRecogActivity;
        this.f4060a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewUtility.dismissDialog(this.f4061b, this.f4060a);
        this.f4061b.P.y = true;
        this.f4061b.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
    }
}
