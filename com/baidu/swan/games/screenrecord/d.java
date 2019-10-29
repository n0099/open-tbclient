package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bDJ = null;
    private GameRecorderController bBf;
    private boolean bDK;

    /* loaded from: classes2.dex */
    public interface a {
        void fZ(int i);
    }

    private d() {
    }

    public static d XO() {
        if (bDJ == null) {
            synchronized (d.class) {
                if (bDJ == null) {
                    bDJ = new d();
                }
            }
        }
        return bDJ;
    }

    public void b(GameRecorderController gameRecorderController) {
        if (this.bBf != null && this.bBf != gameRecorderController) {
            this.bBf.release();
        }
        this.bBf = gameRecorderController;
    }

    @NonNull
    public GameRecorderController XP() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.bBf);
        }
        return this.bBf == null ? GameRecorderController.XN() : this.bBf;
    }

    public void c(GameRecorderController gameRecorderController) {
        if (this.bBf != null && this.bBf == gameRecorderController) {
            this.bBf.release();
            this.bBf = null;
        }
    }

    public boolean XQ() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.bDK);
        }
        return this.bDK;
    }

    public void XR() {
        this.bDK = true;
    }

    public void XS() {
        this.bDK = false;
    }

    public static void a(@NonNull final a aVar) {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null || QZ.getActivity() == null) {
            aVar.fZ(2);
        } else {
            QZ.Rd().a(QZ.getActivity(), "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.games.screenrecord.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void B(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.b(a.this);
                    } else {
                        a.this.fZ(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final a aVar) {
        boolean z;
        if (com.baidu.swan.apps.an.a.Ub()) {
            z = ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.Ji(), "android.permission.RECORD_AUDIO") == 0;
        } else {
            z = true;
        }
        if (z) {
            aVar.fZ(0);
        } else {
            e.LD().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0152a() { // from class: com.baidu.swan.games.screenrecord.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z2;
                    if (i != 2 || iArr.length <= 0) {
                        a.this.fZ(1);
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
                    a.this.fZ(z2 ? 0 : 1);
                }
            });
        }
    }
}
