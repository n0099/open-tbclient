package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes17.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        this.f1329a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1329a, "手机存储空间不足,建议您释放空间后再下载", 1).show();
    }
}
