package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes4.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.f1367a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1367a, "文件不可用", 0).show();
    }
}
