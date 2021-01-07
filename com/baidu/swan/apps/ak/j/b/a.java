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
    private long dPQ;
    private b dPR;
    private final c.a dPS;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0382a {
        public static final a dPU = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dPQ = 0L;
        this.dPS = new c.a() { // from class: com.baidu.swan.apps.ak.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dPR != null) {
                    a.this.dPR.cT(a.this.dPQ);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dPR = new b(vibrator);
        }
    }

    public static a aQr() {
        return C0382a.dPU;
    }

    void cT(long j) {
        this.dPQ = j;
        if (this.dPR == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (aQs()) {
            this.dPR.cT(this.dPQ);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aMf = d.aMh().aMf();
            if (aMf != null) {
                aMf.a(700, strArr, this.dPS);
            }
        }
    }

    private boolean aQs() {
        if (com.baidu.swan.apps.ao.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void aQt() {
        cT(15L);
    }

    public void aQu() {
        cT(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private Vibrator dPV;

        b(@NonNull Vibrator vibrator) {
            this.dPV = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void cT(long j) {
            try {
                if (com.baidu.swan.apps.ao.c.hasOreo()) {
                    this.dPV.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.dPV.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
