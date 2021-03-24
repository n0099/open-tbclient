package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4600a;

    public d(Context context) {
        this.f4600a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f4600a, "无SD卡，将为你下载到手机内存", 0).show();
    }
}
