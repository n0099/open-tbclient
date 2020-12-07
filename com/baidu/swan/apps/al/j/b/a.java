package com.baidu.swan.apps.al.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes25.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long dHm;
    private b dHn;
    private final c.a dHo;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0390a {
        public static final a dHq = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dHm = 0L;
        this.dHo = new c.a() { // from class: com.baidu.swan.apps.al.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dHn != null) {
                    a.this.dHn.cS(a.this.dHm);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dHn = new b(vibrator);
        }
    }

    public static a aOa() {
        return C0390a.dHq;
    }

    void cS(long j) {
        this.dHm = j;
        if (this.dHn == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.dHn.cS(this.dHm);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aJO = d.aJQ().aJO();
            if (aJO != null) {
                aJO.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.dHo);
            }
        }
    }

    private boolean checkVibratePermission() {
        if (com.baidu.swan.apps.ap.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void aOb() {
        cS(15L);
    }

    public void aOc() {
        cS(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void cS(long j) {
            try {
                if (com.baidu.swan.apps.ap.c.hasOreo()) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.mVibrator.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
