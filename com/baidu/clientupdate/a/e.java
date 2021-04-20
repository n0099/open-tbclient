package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f4612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4613b;

    public e(d dVar, byte[] bArr) {
        this.f4613b = dVar;
        this.f4612a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f4613b.a();
            bVar = this.f4613b.f4611d;
            bVar.a(this.f4612a);
        } catch (Exception e2) {
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
        }
    }
}
