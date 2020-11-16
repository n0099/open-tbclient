package com.baidu.fsg.face.liveness.livenessrouter;

import com.baidu.fsg.base.router.RouterProvider;
/* loaded from: classes16.dex */
public class a extends RouterProvider {
    @Override // com.baidu.fsg.base.router.RouterProvider
    protected void registerActions() {
        registerAction("startLivenessRecognize", new b());
    }
}
