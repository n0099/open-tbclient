package com.baidu.android.nebula.d;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f677a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f677a.c();
        } catch (IOException e) {
            Log.e("HttpServer", "Serer Loop Excepiton :" + e);
        }
        this.f677a.d();
    }
}
