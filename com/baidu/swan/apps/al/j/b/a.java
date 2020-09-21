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
/* loaded from: classes3.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean DEBUG;
    private long dbt;
    private b dbu;
    private final c.a dbv;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0337a {
        public static final a dbx = new a();
    }

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    private a() {
        this.dbt = 0L;
        this.dbv = new c.a() { // from class: com.baidu.swan.apps.al.j.b.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.dbu != null) {
                    a.this.dbu.bN(a.this.dbt);
                }
            }
        };
        if (!$assertionsDisabled && AppRuntime.getAppContext() == null) {
            throw new AssertionError();
        }
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.dbu = new b(vibrator);
        }
    }

    public static a aEy() {
        return C0337a.dbx;
    }

    void bN(long j) {
        this.dbt = j;
        if (this.dbu == null) {
            if (DEBUG) {
                throw new RuntimeException("not support vibration");
            }
        } else if (checkVibratePermission()) {
            this.dbu.bN(this.dbt);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity aAl = d.aAn().aAl();
            if (aAl != null) {
                aAl.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.dbv);
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

    public void aEz() {
        bN(15L);
    }

    public void aEA() {
        bN(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private Vibrator mVibrator;

        b(@NonNull Vibrator vibrator) {
            this.mVibrator = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        void bN(long j) {
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
