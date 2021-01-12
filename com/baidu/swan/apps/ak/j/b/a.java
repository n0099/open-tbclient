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
    private long dLe;
    private b dLf;
    private final c.a dLg;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0365a {
        public static final a dLi = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dLe = 0L;
        this.dLg = new c.a() { // from class: com.baidu.swan.apps.ak.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dLf != null) {
                    a.this.dLf.cT(a.this.dLe);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dLf = new b(vibrator);
        }
    }

    public static a aMx() {
        return C0365a.dLi;
    }

    void cT(long j) {
        this.dLe = j;
        if (this.dLf == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (aMy()) {
            this.dLf.cT(this.dLe);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aIl = d.aIn().aIl();
            if (aIl != null) {
                aIl.a(700, strArr, this.dLg);
            }
        }
    }

    private boolean aMy() {
        if (com.baidu.swan.apps.ao.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void aMz() {
        cT(15L);
    }

    public void aMA() {
        cT(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private Vibrator dLj;

        b(@NonNull Vibrator vibrator) {
            this.dLj = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void cT(long j) {
            try {
                if (com.baidu.swan.apps.ao.c.hasOreo()) {
                    this.dLj.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.dLj.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
