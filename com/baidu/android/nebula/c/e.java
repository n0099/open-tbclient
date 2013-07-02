package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.c();
        } catch (IOException e) {
            Log.e("HttpServer", "Serer Loop Excepiton :" + e);
        }
        this.a.d();
    }
}
