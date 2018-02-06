package com.baidu.sapi2.biometrics.liveness.livenessrouter;

import com.baidu.fsg.base.router.RouterProvider;
/* loaded from: classes2.dex */
public class a extends RouterProvider {
    @Override // com.baidu.fsg.base.router.RouterProvider
    protected void registerActions() {
        registerAction("startLivenessRecognize", new b());
    }
}
