package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.util.LogUtil;
/* loaded from: classes2.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f4576a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4577b;

    public e(d dVar, byte[] bArr) {
        this.f4577b = dVar;
        this.f4576a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f4577b.a();
            bVar = this.f4577b.f4575d;
            bVar.a(this.f4576a);
        } catch (Exception e2) {
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
        }
    }
}
