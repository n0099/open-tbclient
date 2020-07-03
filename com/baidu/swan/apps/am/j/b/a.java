package com.baidu.swan.apps.am.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long cMQ;
    private b cMR;
    private final c.a cMS;

    /* renamed from: com.baidu.swan.apps.am.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0300a {
        public static final a cMU = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.cMQ = 0L;
        this.cMS = new c.a() { // from class: com.baidu.swan.apps.am.j.b.a.1
            @Override // com.baidu.swan.apps.ad.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.cMR != null) {
                    a.this.cMR.bu(a.this.cMQ);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.cMR = new b(vibrator);
        }
    }

    public static a atE() {
        return C0300a.cMU;
    }

    void bu(long j) {
        this.cMQ = j;
        if (this.cMR == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.cMR.bu(this.cMQ);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f ajb = f.ajb();
            if (ajb != null) {
                ajb.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.cMS);
            }
        }
    }

    private boolean checkVibratePermission() {
        if (com.baidu.swan.apps.aq.b.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void atF() {
        bu(15L);
    }

    public void atG() {
        bu(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void bu(long j) {
            try {
                if (com.baidu.swan.apps.aq.b.hasOreo()) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.mVibrator.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
