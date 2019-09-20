package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bkV = null;
    private GameRecorderController bir;
    private boolean bkW;

    /* loaded from: classes2.dex */
    public interface a {
        void fe(int i);
    }

    private d() {
    }

    public static d SX() {
        if (bkV == null) {
            synchronized (d.class) {
                if (bkV == null) {
                    bkV = new d();
                }
            }
        }
        return bkV;
    }

    public void b(GameRecorderController gameRecorderController) {
        if (this.bir != null && this.bir != gameRecorderController) {
            this.bir.release();
        }
        this.bir = gameRecorderController;
    }

    @NonNull
    public GameRecorderController SY() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.bir);
        }
        return this.bir == null ? GameRecorderController.SW() : this.bir;
    }

    public void c(GameRecorderController gameRecorderController) {
        if (this.bir != null && this.bir == gameRecorderController) {
            this.bir.release();
            this.bir = null;
        }
    }

    public boolean SZ() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.bkW);
        }
        return this.bkW;
    }

    public void Ta() {
        this.bkW = true;
    }

    public void Tb() {
        this.bkW = false;
    }

    public static void a(@NonNull final a aVar) {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null || Mh.getActivity() == null) {
            aVar.fe(2);
        } else {
            Mh.Ml().a(Mh.getActivity(), "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.games.screenrecord.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.b(a.this);
                    } else {
                        a.this.fe(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final a aVar) {
        boolean z;
        if (com.baidu.swan.apps.an.a.Pl()) {
            z = ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.Eo(), "android.permission.RECORD_AUDIO") == 0;
        } else {
            z = true;
        }
        if (z) {
            aVar.fe(0);
        } else {
            e.GJ().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0120a() { // from class: com.baidu.swan.games.screenrecord.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0120a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z2;
                    if (i != 2 || iArr.length <= 0) {
                        a.this.fe(1);
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
                    a.this.fe(z2 ? 0 : 1);
                }
            });
        }
    }
}
