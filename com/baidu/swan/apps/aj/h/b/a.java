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
    private Vibrator bqL;
    private long bqM;
    private final a.InterfaceC0152a bqN;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0160a {
        public static final a bqP = new a();
    }

    private a() {
        this.bqM = 0L;
        this.bqN = new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.aj.h.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.bqL != null) {
                    a.this.bqL.vibrate(a.this.bqM);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.bqL = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a Ty() {
        return C0160a.bqP;
    }

    public void ap(long j) {
        this.bqM = j;
        if (Tz()) {
            this.bqL.vibrate(this.bqM);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e LE = e.LE();
        if (LE != null) {
            LE.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.bqN);
        }
    }

    private boolean Tz() {
        if (com.baidu.swan.apps.an.a.TZ()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void TA() {
        ap(15L);
    }

    public void TB() {
        ap(400L);
    }
}
