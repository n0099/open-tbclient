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
    private Vibrator aUs;
    private long aUt;
    private final a.InterfaceC0108a aUu;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0114a {
        public static final a aUw = new a();
    }

    private a() {
        this.aUt = 0L;
        this.aUu = new a.InterfaceC0108a() { // from class: com.baidu.swan.apps.aj.f.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0108a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aUs != null) {
                    a.this.aUs.vibrate(a.this.aUt);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aUs = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a Lq() {
        return C0114a.aUw;
    }

    public void vibrate(long j) {
        this.aUt = j;
        if (Lr()) {
            this.aUs.vibrate(this.aUt);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e Ec = e.Ec();
        if (Ec != null) {
            Ec.a(700, strArr, this.aUu);
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
