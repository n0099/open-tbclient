package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes17.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.f1328a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1328a, "文件不可用", 0).show();
    }
}
