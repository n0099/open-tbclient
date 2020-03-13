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
    private long bWW;
    private b bWX;
    private final c.a bWY;

    /* renamed from: com.baidu.swan.apps.ao.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0209a {
        public static final a bXa = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.bWW = 0L;
        this.bWY = new c.a() { // from class: com.baidu.swan.apps.ao.j.b.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.bWX != null) {
                    a.this.bWX.aG(a.this.bWW);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.bWX = new b(vibrator);
        }
    }

    public static a afY() {
        return C0209a.bXa;
    }

    void aG(long j) {
        this.bWW = j;
        if (this.bWX == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.bWX.aG(this.bWW);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f WS = f.WS();
            if (WS != null) {
                WS.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.bWY);
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

    public void afZ() {
        aG(15L);
    }

    public void aga() {
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
