package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
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
