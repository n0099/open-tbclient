package com.baidu.clientupdate;

import com.baidu.util.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClientUpdater f1312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ClientUpdater clientUpdater) {
        this.f1312a = clientUpdater;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtil.logD("ClientUpdater", "background Check ClientUpdate!");
        this.f1312a.b();
    }
}
