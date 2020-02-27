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
/* loaded from: classes11.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long bWU;
    private b bWV;
    private final c.a bWW;

    /* renamed from: com.baidu.swan.apps.ao.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0209a {
        public static final a bWY = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.bWU = 0L;
        this.bWW = new c.a() { // from class: com.baidu.swan.apps.ao.j.b.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.bWV != null) {
                    a.this.bWV.aG(a.this.bWU);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.bWV = new b(vibrator);
        }
    }

    public static a afW() {
        return C0209a.bWY;
    }

    void aG(long j) {
        this.bWU = j;
        if (this.bWV == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.bWV.aG(this.bWU);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f WQ = f.WQ();
            if (WQ != null) {
                WQ.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.bWW);
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

    public void afX() {
        aG(15L);
    }

    public void afY() {
        aG(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void aG(long j) {
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
