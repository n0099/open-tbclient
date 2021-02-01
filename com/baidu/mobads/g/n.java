package com.baidu.mobads.g;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class n extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g.c f3353a;
    final /* synthetic */ Handler c;
    final /* synthetic */ g d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar, g.c cVar, Handler handler) {
        this.d = gVar;
        this.f3353a = cVar;
        this.c = handler;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, IF, IGET, INVOKE, INVOKE, CONST_STR, IGET, INVOKE, INVOKE, SGET, IGET, INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.baidu.mobads.f.a
    protected Object a() {
        IXAdLogger iXAdLogger;
        SharedPreferences k;
        IXAdLogger iXAdLogger2;
        IXAdLogger iXAdLogger3;
        SharedPreferences k2;
        try {
            synchronized (g.class) {
                this.d.b(this.f3353a, this.c);
            }
            try {
                return null;
            } catch (Throwable th) {
                return null;
            }
        } catch (Throwable th2) {
            try {
                iXAdLogger2 = this.d.m;
                iXAdLogger2.d("XAdApkLoader", "Load APK Failed: " + th2.toString());
                this.d.b(false);
                try {
                    k2 = this.d.k();
                    SharedPreferences.Editor edit = k2.edit();
                    edit.putString("previousProxyVersion", this.d.a());
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                    } else {
                        edit.commit();
                    }
                    return null;
                } catch (Throwable th3) {
                    iXAdLogger3 = this.d.m;
                    iXAdLogger3.d("XAdApkLoader", th3);
                    return null;
                }
            } finally {
                try {
                    k = this.d.k();
                    SharedPreferences.Editor edit2 = k.edit();
                    edit2.putString("previousProxyVersion", this.d.a());
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit2.apply();
                    } else {
                        edit2.commit();
                    }
                } catch (Throwable th4) {
                    iXAdLogger = this.d.m;
                    iXAdLogger.d("XAdApkLoader", th4);
                }
            }
        }
    }
}
