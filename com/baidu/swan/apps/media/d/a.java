package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ai;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ai bAE;
    private c bAF;
    private String bzV;
    private boolean bzX;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bAF = cVar;
        this.bzV = cVar.bwp;
        VS();
        VO();
    }

    private void VO() {
        if (!TextUtils.isEmpty(this.bzV)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bAE != null) {
            this.bAE.a(cVar, true);
        }
        this.bAF = cVar;
    }

    public c VR() {
        return this.bAF;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bwp);
        if (this.bAE != null) {
            this.bAE.a(cVar, this.mContext);
        }
        this.bAF = cVar;
    }

    public ai VS() {
        if (this.bAE == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bAE = com.baidu.swan.apps.w.a.Sz().Fz();
        }
        return this.bAE;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UK() {
        return this.bzV;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UL() {
        return this.bAF != null ? this.bAF.bAk : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bAF.bdW;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object UM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cJ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bzX) {
                VS().resume();
            }
            VS().Fy();
        } else if (this.bAE != null) {
            this.bzX = VS().isPlaying();
            VS().pause();
            VS().FA();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bAE != null && this.bAE.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bAE != null) {
            this.bAE.stop();
            this.bAE = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
