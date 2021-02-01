package com.baidu.swan.apps.ak.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes9.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long dNi;
    private b dNj;
    private final c.a dNk;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0362a {
        public static final a dNm = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dNi = 0L;
        this.dNk = new c.a() { // from class: com.baidu.swan.apps.ak.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dNj != null) {
                    a.this.dNj.cZ(a.this.dNi);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dNj = new b(vibrator);
        }
    }

    public static a aMQ() {
        return C0362a.dNm;
    }

    void cZ(long j) {
        this.dNi = j;
        if (this.dNj == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (aMR()) {
            this.dNj.cZ(this.dNi);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aIE = d.aIG().aIE();
            if (aIE != null) {
                aIE.a(700, strArr, this.dNk);
            }
        }
    }

    private boolean aMR() {
        if (com.baidu.swan.apps.ao.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void aMS() {
        cZ(15L);
    }

    public void aMT() {
        cZ(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private Vibrator dNn;

        b(@NonNull Vibrator vibrator) {
            this.dNn = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void cZ(long j) {
            try {
                if (com.baidu.swan.apps.ao.c.hasOreo()) {
                    this.dNn.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.dNn.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
