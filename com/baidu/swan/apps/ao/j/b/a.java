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
    private long cvY;
    private b cvZ;
    private final c.a cwa;

    /* renamed from: com.baidu.swan.apps.ao.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0239a {
        public static final a cwc = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.cvY = 0L;
        this.cwa = new c.a() { // from class: com.baidu.swan.apps.ao.j.b.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.cvZ != null) {
                    a.this.cvZ.bl(a.this.cvY);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.cvZ = new b(vibrator);
        }
    }

    public static a aog() {
        return C0239a.cwc;
    }

    void bl(long j) {
        this.cvY = j;
        if (this.cvZ == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.cvZ.bl(this.cvY);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f aeK = f.aeK();
            if (aeK != null) {
                aeK.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.cwa);
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

    public void aoh() {
        bl(15L);
    }

    public void aoi() {
        bl(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void bl(long j) {
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
