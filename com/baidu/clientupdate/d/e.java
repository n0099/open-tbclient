package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes5.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.f1727a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1727a, "文件不可用", 0).show();
    }
}
