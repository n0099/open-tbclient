package com.baidu.clientupdate.d;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4602a;

    public f(Context context) {
        this.f4602a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f4602a, "手机存储空间不足,建议您释放空间后再下载", 1).show();
    }
}
