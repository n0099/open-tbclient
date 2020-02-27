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
    private ai bEK;
    private c bEL;
    private String bEb;
    private boolean bEd;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEL = cVar;
        this.bEb = cVar.bAy;
        Yg();
        Yc();
    }

    private void Yc() {
        if (!TextUtils.isEmpty(this.bEb)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bEK != null) {
            this.bEK.a(cVar, true);
        }
        this.bEL = cVar;
    }

    public c Yf() {
        return this.bEL;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bAy);
        if (this.bEK != null) {
            this.bEK.a(cVar, this.mContext);
        }
        this.bEL = cVar;
    }

    public ai Yg() {
        if (this.bEK == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bEK = com.baidu.swan.apps.w.a.UN().HO();
        }
        return this.bEK;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WY() {
        return this.bEb;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WZ() {
        return this.bEL != null ? this.bEL.bEq : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEL.bil;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEd) {
                Yg().resume();
            }
            Yg().HN();
        } else if (this.bEK != null) {
            this.bEd = Yg().isPlaying();
            Yg().pause();
            Yg().HP();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bEK != null && this.bEK.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bEK != null) {
            this.bEK.stop();
            this.bEK = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
