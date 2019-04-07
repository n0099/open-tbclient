package com.baidu.swan.apps.aj.f.b;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private Vibrator aUv;
    private long aUw;
    private final a.InterfaceC0108a aUx;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0114a {
        public static final a aUz = new a();
    }

    private a() {
        this.aUw = 0L;
        this.aUx = new a.InterfaceC0108a() { // from class: com.baidu.swan.apps.aj.f.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0108a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aUv != null) {
                    a.this.aUv.vibrate(a.this.aUw);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aUv = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a Lo() {
        return C0114a.aUz;
    }

    public void vibrate(long j) {
        this.aUw = j;
        if (Lp()) {
            this.aUv.vibrate(this.aUw);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e Ea = e.Ea();
        if (Ea != null) {
            Ea.a(700, strArr, this.aUx);
        }
    }

    private boolean Lp() {
        if (com.baidu.swan.apps.an.a.LL()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void Lq() {
        vibrate(15L);
    }

    public void Lr() {
        vibrate(400L);
    }
}
