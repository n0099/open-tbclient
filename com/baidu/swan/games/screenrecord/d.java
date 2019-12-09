package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bCS = null;
    private GameRecorderController bAo;
    private boolean bCT;

    /* loaded from: classes2.dex */
    public interface a {
        void fY(int i);
    }

    private d() {
    }

    public static d XM() {
        if (bCS == null) {
            synchronized (d.class) {
                if (bCS == null) {
                    bCS = new d();
                }
            }
        }
        return bCS;
    }

    public void b(GameRecorderController gameRecorderController) {
        if (this.bAo != null && this.bAo != gameRecorderController) {
            this.bAo.release();
        }
        this.bAo = gameRecorderController;
    }

    @NonNull
    public GameRecorderController XN() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.bAo);
        }
        return this.bAo == null ? GameRecorderController.XL() : this.bAo;
    }

    public void c(GameRecorderController gameRecorderController) {
        if (this.bAo != null && this.bAo == gameRecorderController) {
            this.bAo.release();
            this.bAo = null;
        }
    }

    public boolean XO() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.bCT);
        }
        return this.bCT;
    }

    public void XP() {
        this.bCT = true;
    }

    public void XQ() {
        this.bCT = false;
    }

    public static void a(@NonNull final a aVar) {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null || Ra.getActivity() == null) {
            aVar.fY(2);
        } else {
            Ra.Rf().a(Ra.getActivity(), "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.games.screenrecord.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void B(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.b(a.this);
                    } else {
                        a.this.fY(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final a aVar) {
        boolean z;
        if (com.baidu.swan.apps.an.a.TZ()) {
            z = ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.Jj(), "android.permission.RECORD_AUDIO") == 0;
        } else {
            z = true;
        }
        if (z) {
            aVar.fY(0);
        } else {
            e.LE().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0147a() { // from class: com.baidu.swan.games.screenrecord.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0147a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z2;
                    if (i != 2 || iArr.length <= 0) {
                        a.this.fY(1);
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
                    a.this.fY(z2 ? 0 : 1);
                }
            });
        }
    }
}
