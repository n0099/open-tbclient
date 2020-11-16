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
/* loaded from: classes7.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long dAo;
    private b dAp;
    private final c.a dAq;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0378a {
        public static final a dAs = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dAo = 0L;
        this.dAq = new c.a() { // from class: com.baidu.swan.apps.al.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dAp != null) {
                    a.this.dAp.ct(a.this.dAo);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dAp = new b(vibrator);
        }
    }

    public static a aKT() {
        return C0378a.dAs;
    }

    void ct(long j) {
        this.dAo = j;
        if (this.dAp == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.dAp.ct(this.dAo);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aGG = d.aGI().aGG();
            if (aGG != null) {
                aGG.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.dAq);
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

    public void aKU() {
        ct(15L);
    }

    public void aKV() {
        ct(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void ct(long j) {
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
