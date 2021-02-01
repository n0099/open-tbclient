package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes3.dex */
final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f1674a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f1674a, "无SD卡，将为你下载到手机内存", 0).show();
    }
}
