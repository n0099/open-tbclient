package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ai;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ai bzR;
    private c bzS;
    private String bzi;
    private boolean bzk;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bzS = cVar;
        this.bzi = cVar.bvC;
        Vv();
        Vr();
    }

    private void Vr() {
        if (!TextUtils.isEmpty(this.bzi)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bzR != null) {
            this.bzR.a(cVar, true);
        }
        this.bzS = cVar;
    }

    public c Vu() {
        return this.bzS;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bvC);
        if (this.bzR != null) {
            this.bzR.a(cVar, this.mContext);
        }
        this.bzS = cVar;
    }

    public ai Vv() {
        if (this.bzR == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bzR = com.baidu.swan.apps.w.a.Sd().Fd();
        }
        return this.bzR;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Un() {
        return this.bzi;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Uo() {
        return this.bzS != null ? this.bzS.bzx : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bzS.bdi;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Up() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cE(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bzk) {
                Vv().resume();
            }
            Vv().Fc();
        } else if (this.bzR != null) {
            this.bzk = Vv().isPlaying();
            Vv().pause();
            Vv().Fe();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cF(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bzR != null && this.bzR.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bzR != null) {
            this.bzR.stop();
            this.bzR = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
