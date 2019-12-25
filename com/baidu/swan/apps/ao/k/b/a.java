package com.baidu.swan.apps.ao.k.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes9.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long bSE;
    private b bSF;
    private final c.a bSG;

    /* renamed from: com.baidu.swan.apps.ao.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0197a {
        public static final a bSI = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.bSE = 0L;
        this.bSG = new c.a() { // from class: com.baidu.swan.apps.ao.k.b.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.bSF != null) {
                    a.this.bSF.az(a.this.bSE);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.bSF = new b(vibrator);
        }
    }

    public static a adp() {
        return C0197a.bSI;
    }

    void az(long j) {
        this.bSE = j;
        if (this.bSF == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.bSF.az(this.bSE);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f Uf = f.Uf();
            if (Uf != null) {
                Uf.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.bSG);
            }
        }
    }

    private boolean checkVibratePermission() {
        if (com.baidu.swan.apps.as.a.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void adq() {
        az(15L);
    }

    public void adr() {
        az(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void az(long j) {
            try {
                if (com.baidu.swan.apps.as.a.hasOreo()) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.mVibrator.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
