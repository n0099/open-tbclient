package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f4577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4578b;

    public e(d dVar, byte[] bArr) {
        this.f4578b = dVar;
        this.f4577a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        super.run();
        try {
            this.f4578b.a();
            bVar = this.f4578b.f4576d;
            bVar.a(this.f4577a);
        } catch (Exception e2) {
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
        }
    }
}
