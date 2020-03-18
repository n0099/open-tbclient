package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ai;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ai bEX;
    private c bEY;
    private String bEo;
    private boolean bEq;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEY = cVar;
        this.bEo = cVar.bAL;
        Yl();
        Yh();
    }

    private void Yh() {
        if (!TextUtils.isEmpty(this.bEo)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bEX != null) {
            this.bEX.a(cVar, true);
        }
        this.bEY = cVar;
    }

    public c Yk() {
        return this.bEY;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bAL);
        if (this.bEX != null) {
            this.bEX.a(cVar, this.mContext);
        }
        this.bEY = cVar;
    }

    public ai Yl() {
        if (this.bEX == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bEX = com.baidu.swan.apps.w.a.US().HT();
        }
        return this.bEX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xd() {
        return this.bEo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xe() {
        return this.bEY != null ? this.bEY.bED : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEY.biB;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xf() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEq) {
                Yl().resume();
            }
            Yl().HS();
        } else if (this.bEX != null) {
            this.bEq = Yl().isPlaying();
            Yl().pause();
            Yl().HU();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cS(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bEX != null && this.bEX.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bEX != null) {
            this.bEX.stop();
            this.bEX = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
