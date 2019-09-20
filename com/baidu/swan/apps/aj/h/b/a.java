package com.baidu.swan.apps.aj.h.b;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private Vibrator aYA;
    private long aYB;
    private final a.InterfaceC0120a aYC;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0128a {
        public static final a aYE = new a();
    }

    private a() {
        this.aYB = 0L;
        this.aYC = new a.InterfaceC0120a() { // from class: com.baidu.swan.apps.aj.h.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0120a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aYA != null) {
                    a.this.aYA.vibrate(a.this.aYB);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aYA = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a OK() {
        return C0128a.aYE;
    }

    public void X(long j) {
        this.aYB = j;
        if (OL()) {
            this.aYA.vibrate(this.aYB);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e GJ = e.GJ();
        if (GJ != null) {
            GJ.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.aYC);
        }
    }

    private boolean OL() {
        if (com.baidu.swan.apps.an.a.Pl()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void OM() {
        X(15L);
    }

    public void ON() {
        X(400L);
    }
}
