package com.baidu.mobads.production;

import android.content.Context;
import android.net.Uri;
import dalvik.system.DexClassLoader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3497a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f3498b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar, String str, Uri uri) {
        this.c = bVar;
        this.f3497a = str;
        this.f3498b = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DexClassLoader a2 = a.a(this.c.f);
            com.baidu.mobads.utils.e.a(Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, a2), "boost", new Class[]{Context.class, String.class, Uri.class, Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBoostListener", false, a2)}, new Object[]{this.c.getApplicationContext(), this.f3497a, this.f3498b, null});
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
    }
}
