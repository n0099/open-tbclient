package com.baidu.mobads.g;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* loaded from: classes2.dex */
public class n extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g.c f8295a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f8296c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f8297d;

    public n(g gVar, g.c cVar, Handler handler) {
        this.f8297d = gVar;
        this.f8295a = cVar;
        this.f8296c = handler;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        IXAdLogger iXAdLogger;
        SharedPreferences k;
        try {
            synchronized (g.class) {
                this.f8297d.b(this.f8295a, this.f8296c);
            }
            k = this.f8297d.k();
            SharedPreferences.Editor edit = k.edit();
            edit.putString("previousProxyVersion", this.f8297d.a());
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
                return null;
            }
            edit.commit();
            return null;
        } catch (Throwable th) {
            iXAdLogger = this.f8297d.m;
            iXAdLogger.d("XAdApkLoader", th);
            return null;
        }
    }
}
