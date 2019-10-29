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
    private Vibrator brC;
    private long brD;
    private final a.InterfaceC0152a brE;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0160a {
        public static final a brG = new a();
    }

    private a() {
        this.brD = 0L;
        this.brE = new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.aj.h.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.brC != null) {
                    a.this.brC.vibrate(a.this.brD);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.brC = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a TA() {
        return C0160a.brG;
    }

    public void aq(long j) {
        this.brD = j;
        if (TB()) {
            this.brC.vibrate(this.brD);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e LD = e.LD();
        if (LD != null) {
            LD.a(CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, strArr, this.brE);
        }
    }

    private boolean TB() {
        if (com.baidu.swan.apps.an.a.Ub()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void TC() {
        aq(15L);
    }

    public void TD() {
        aq(400L);
    }
}
