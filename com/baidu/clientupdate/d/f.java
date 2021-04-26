package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4746a;

    public f(Context context) {
        this.f4746a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f4746a, "手机存储空间不足,建议您释放空间后再下载", 1).show();
    }
}
