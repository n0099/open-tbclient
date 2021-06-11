package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4621a;

    public e(Context context) {
        this.f4621a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f4621a, "文件不可用", 0).show();
    }
}
