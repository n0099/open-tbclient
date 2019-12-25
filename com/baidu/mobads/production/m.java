package com.baidu.mobads.production;

import android.content.Context;
import android.net.Uri;
import dalvik.system.DexClassLoader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Uri b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar, String str, Uri uri) {
        this.c = bVar;
        this.a = str;
        this.b = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DexClassLoader a = a.a(this.c.f);
            com.baidu.mobads.utils.e.a(Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, a), "boost", new Class[]{Context.class, String.class, Uri.class, Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBoostListener", false, a)}, new Object[]{this.c.getApplicationContext(), this.a, this.b, null});
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
    }
}
