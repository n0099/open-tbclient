package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes3.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        this.f1676a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1676a, "手机存储空间不足,建议您释放空间后再下载", 1).show();
    }
}
