package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes3.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.f1675a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1675a, "文件不可用", 0).show();
    }
}
