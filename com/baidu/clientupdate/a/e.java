package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f4572a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4573b;

    public e(d dVar, byte[] bArr) {
        this.f4573b = dVar;
        this.f4572a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f4573b.a();
            bVar = this.f4573b.f4571d;
            bVar.a(this.f4572a);
        } catch (Exception e2) {
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
        }
    }
}
