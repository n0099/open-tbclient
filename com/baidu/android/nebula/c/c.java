package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f541a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f541a.c();
        } catch (IOException e) {
            Log.e("HttpServer", "Serer Loop Excepiton :" + e);
        }
        this.f541a.d();
    }
}
