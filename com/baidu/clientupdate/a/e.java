package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f4718a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4719b;

    public e(d dVar, byte[] bArr) {
        this.f4719b = dVar;
        this.f4718a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f4719b.a();
            bVar = this.f4719b.f4717d;
            bVar.a(this.f4718a);
        } catch (Exception e2) {
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
        }
    }
}
