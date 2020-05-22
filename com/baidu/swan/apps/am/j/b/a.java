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
    private long cIg;
    private b cIh;
    private final c.a cIi;

    /* renamed from: com.baidu.swan.apps.am.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0294a {
        public static final a cIk = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.cIg = 0L;
        this.cIi = new c.a() { // from class: com.baidu.swan.apps.am.j.b.a.1
            @Override // com.baidu.swan.apps.ad.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.cIh != null) {
                    a.this.cIh.bu(a.this.cIg);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.cIh = new b(vibrator);
        }
    }

    public static a asy() {
        return C0294a.cIk;
    }

    void bu(long j) {
        this.cIg = j;
        if (this.cIh == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.cIh.bu(this.cIg);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            f ahV = f.ahV();
            if (ahV != null) {
                ahV.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.cIi);
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

    public void asz() {
        bu(15L);
    }

    public void asA() {
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
