package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes5.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f1724a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1724a, "SD卡空间不足，将为你下载到手机内存", 0).show();
    }
}
