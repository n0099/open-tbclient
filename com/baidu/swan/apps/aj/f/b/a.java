package com.baidu.swan.apps.aj.f.b;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private Vibrator aUr;
    private long aUs;
    private final a.InterfaceC0078a aUt;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0084a {
        public static final a aUv = new a();
    }

    private a() {
        this.aUs = 0L;
        this.aUt = new a.InterfaceC0078a() { // from class: com.baidu.swan.apps.aj.f.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0078a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aUr != null) {
                    a.this.aUr.vibrate(a.this.aUs);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aUr = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a Lq() {
        return C0084a.aUv;
    }

    public void vibrate(long j) {
        this.aUs = j;
        if (Lr()) {
            this.aUr.vibrate(this.aUs);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e Ec = e.Ec();
        if (Ec != null) {
            Ec.a(700, strArr, this.aUt);
        }
    }

    private boolean Lr() {
        if (com.baidu.swan.apps.an.a.LN()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void Ls() {
        vibrate(15L);
    }

    public void Lt() {
        vibrate(400L);
    }
}
