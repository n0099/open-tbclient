package com.baidu.android.nebula.d;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f554a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f554a.c();
        } catch (IOException e) {
            Log.e("HttpServer", "Serer Loop Excepiton :" + e);
        }
        this.f554a.d();
    }
}
