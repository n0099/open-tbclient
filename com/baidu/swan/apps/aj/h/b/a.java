package com.baidu.swan.apps.aj.h.b;

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
    private Vibrator aYc;
    private long aYd;
    private final a.InterfaceC0111a aYe;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0119a {
        public static final a aYg = new a();
    }

    private a() {
        this.aYd = 0L;
        this.aYe = new a.InterfaceC0111a() { // from class: com.baidu.swan.apps.aj.h.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0111a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aYc != null) {
                    a.this.aYc.vibrate(a.this.aYd);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aYc = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a OG() {
        return C0119a.aYg;
    }

    public void X(long j) {
        this.aYd = j;
        if (OH()) {
            this.aYc.vibrate(this.aYd);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e GF = e.GF();
        if (GF != null) {
            GF.a(700, strArr, this.aYe);
        }
    }

    private boolean OH() {
        if (com.baidu.swan.apps.an.a.Ph()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void OI() {
        X(15L);
    }

    public void OJ() {
        X(400L);
    }
}
