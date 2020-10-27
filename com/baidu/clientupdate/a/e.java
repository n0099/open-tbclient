package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.util.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f1317a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, byte[] bArr) {
        this.b = dVar;
        this.f1317a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.b.a();
            bVar = this.b.d;
            bVar.a(this.f1317a);
        } catch (Exception e) {
            LogUtil.logE("LogUtils", Log.getStackTraceString(e));
        }
    }
}
