package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bkx = null;
    private GameRecorderController bhR;
    private boolean bky;

    /* loaded from: classes2.dex */
    public interface a {
        void fd(int i);
    }

    private d() {
    }

    public static d ST() {
        if (bkx == null) {
            synchronized (d.class) {
                if (bkx == null) {
                    bkx = new d();
                }
            }
        }
        return bkx;
    }

    public void b(GameRecorderController gameRecorderController) {
        if (this.bhR != null && this.bhR != gameRecorderController) {
            this.bhR.release();
        }
        this.bhR = gameRecorderController;
    }

    @NonNull
    public GameRecorderController SU() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.bhR);
        }
        return this.bhR == null ? GameRecorderController.SS() : this.bhR;
    }

    public void c(GameRecorderController gameRecorderController) {
        if (this.bhR != null && this.bhR == gameRecorderController) {
            this.bhR.release();
            this.bhR = null;
        }
    }

    public boolean SV() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.bky);
        }
        return this.bky;
    }

    public void SW() {
        this.bky = true;
    }

    public void SX() {
        this.bky = false;
    }

    public static void a(@NonNull final a aVar) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null || Md.getActivity() == null) {
            aVar.fd(2);
        } else {
            Md.Mh().a(Md.getActivity(), "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.games.screenrecord.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.b(a.this);
                    } else {
                        a.this.fd(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final a aVar) {
        boolean z;
        if (com.baidu.swan.apps.an.a.Ph()) {
            z = ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.Ek(), "android.permission.RECORD_AUDIO") == 0;
        } else {
            z = true;
        }
        if (z) {
            aVar.fd(0);
        } else {
            e.GF().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0106a() { // from class: com.baidu.swan.games.screenrecord.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0106a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z2;
                    if (i != 2 || iArr.length <= 0) {
                        a.this.fd(1);
                        return;
                    }
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z2 = true;
                            break;
                        } else if (iArr[i2] == -1) {
                            z2 = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    a.this.fd(z2 ? 0 : 1);
                }
            });
        }
    }
}
