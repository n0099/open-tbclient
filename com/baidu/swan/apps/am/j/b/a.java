package com.baidu.swan.apps.am.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ac.c;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes7.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long cQl;
    private b cQm;
    private final c.a cQn;

    /* renamed from: com.baidu.swan.apps.am.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0300a {
        public static final a cQp = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.cQl = 0L;
        this.cQn = new c.a() { // from class: com.baidu.swan.apps.am.j.b.a.1
            @Override // com.baidu.swan.apps.ac.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.cQm != null) {
                    a.this.cQm.bH(a.this.cQl);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.cQm = new b(vibrator);
        }
    }

    public static a avF() {
        return C0300a.cQp;
    }

    void bH(long j) {
        this.cQl = j;
        if (this.cQm == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.cQm.bH(this.cQl);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity arp = d.arr().arp();
            if (arp != null) {
                arp.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.cQn);
            }
        }
    }

    private boolean checkVibratePermission() {
        if (com.baidu.swan.apps.aq.c.hasMarshMallow()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ActivityCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void avG() {
        bH(15L);
    }

    public void avH() {
        bH(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void bH(long j) {
            try {
                if (com.baidu.swan.apps.aq.c.hasOreo()) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.mVibrator.vibrate(j);
                }
            } catch (Exception e) {
            }
        }
    }
}
