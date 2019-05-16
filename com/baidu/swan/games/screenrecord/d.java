package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bjK = null;
    private GameRecorderController bhe;
    private boolean bjL;

    /* loaded from: classes2.dex */
    public interface a {
        void eZ(int i);
    }

    private d() {
    }

    public static d Sa() {
        if (bjK == null) {
            synchronized (d.class) {
                if (bjK == null) {
                    bjK = new d();
                }
            }
        }
        return bjK;
    }

    public void b(GameRecorderController gameRecorderController) {
        if (this.bhe != null && this.bhe != gameRecorderController) {
            this.bhe.release();
        }
        this.bhe = gameRecorderController;
    }

    @NonNull
    public GameRecorderController Sb() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.bhe);
        }
        return this.bhe == null ? GameRecorderController.RZ() : this.bhe;
    }

    public void c(GameRecorderController gameRecorderController) {
        if (this.bhe != null && this.bhe == gameRecorderController) {
            this.bhe.release();
            this.bhe = null;
        }
    }

    public boolean Sc() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.bjL);
        }
        return this.bjL;
    }

    public void Sd() {
        this.bjL = true;
    }

    public void Se() {
        this.bjL = false;
    }

    public static void a(@NonNull final a aVar) {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null || Lq.getActivity() == null) {
            aVar.eZ(2);
        } else {
            Lq.Lu().a(Lq.getActivity(), "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.games.screenrecord.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.b(a.this);
                    } else {
                        a.this.eZ(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final a aVar) {
        boolean z;
        if (com.baidu.swan.apps.an.a.Os()) {
            z = ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.DB(), "android.permission.RECORD_AUDIO") == 0;
        } else {
            z = true;
        }
        if (z) {
            aVar.eZ(0);
        } else {
            e.FV().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0109a() { // from class: com.baidu.swan.games.screenrecord.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0109a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z2;
                    if (i != 2 || iArr.length <= 0) {
                        a.this.eZ(1);
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
                    a.this.eZ(z2 ? 0 : 1);
                }
            });
        }
    }
}
