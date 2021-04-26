package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4743a;

    public c(Context context) {
        this.f4743a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f4743a, "SD卡空间不足，将为你下载到手机内存", 0).show();
    }
}
