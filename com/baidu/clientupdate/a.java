package com.baidu.clientupdate;

import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientUpdater f4554a;

    public a(ClientUpdater clientUpdater) {
        this.f4554a = clientUpdater;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtil.logD("ClientUpdater", "background Check ClientUpdate!");
        this.f4554a.b();
    }
}
