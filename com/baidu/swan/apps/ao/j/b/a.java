package com.baidu.swan.apps.ao.j.b;

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
/* loaded from: classes10.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long bSQ;
    private b bSR;
    private final c.a bSS;

    /* renamed from: com.baidu.swan.apps.ao.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0199a {
        public static final a bSU = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.bSQ = 0L;
        this.bSS = new c.a() { // from class: com.baidu.swan.apps.ao.j.b.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.bSR != null) {
                    a.this.bSR.aC(a.this.bSQ);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.bSR = new b(vibrator);
        }
    }

    public static a adI() {
        return C0199a.bSU;
    }

    void aC(long j) {
        this.bSQ = j;
        if (this.bSR == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.bSR.aC(this.bSQ);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f UC = f.UC();
            if (UC != null) {
                UC.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.bSS);
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

    public void adJ() {
        aC(15L);
    }

    public void adK() {
        aC(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void aC(long j) {
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
