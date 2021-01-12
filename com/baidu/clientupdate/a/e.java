package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.util.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f1664a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f1665b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, byte[] bArr) {
        this.f1665b = dVar;
        this.f1664a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f1665b.a();
            bVar = this.f1665b.d;
            bVar.a(this.f1664a);
        } catch (Exception e) {
            LogUtil.logE("LogUtils", Log.getStackTraceString(e));
        }
    }
}
