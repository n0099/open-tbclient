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
/* loaded from: classes8.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long dOJ;
    private b dOK;
    private final c.a dOL;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0368a {
        public static final a dON = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dOJ = 0L;
        this.dOL = new c.a() { // from class: com.baidu.swan.apps.ak.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dOK != null) {
                    a.this.dOK.cZ(a.this.dOJ);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dOK = new b(vibrator);
        }
    }

    public static a aMT() {
        return C0368a.dON;
    }

    void cZ(long j) {
        this.dOJ = j;
        if (this.dOK == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (aMU()) {
            this.dOK.cZ(this.dOJ);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aIH = d.aIJ().aIH();
            if (aIH != null) {
                aIH.a(700, strArr, this.dOL);
            }
        }
    }

    private boolean aMU() {
        if (com.baidu.swan.apps.ao.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void aMV() {
        cZ(15L);
    }

    public void aMW() {
        cZ(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private Vibrator dOO;

        b(@NonNull Vibrator vibrator) {
            this.dOO = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void cZ(long j) {
            try {
                if (com.baidu.swan.apps.ao.c.hasOreo()) {
                    this.dOO.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.dOO.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
