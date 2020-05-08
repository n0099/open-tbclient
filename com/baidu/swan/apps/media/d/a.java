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
    private ai cdM;
    private c cdN;
    private String cdd;
    private boolean cdf;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cdN = cVar;
        this.cdd = cVar.bYY;
        agq();
        agm();
    }

    private void agm() {
        if (!TextUtils.isEmpty(this.cdd)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.cdM != null) {
            this.cdM.a(cVar, true);
        }
        this.cdN = cVar;
    }

    public c agp() {
        return this.cdN;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bYY);
        if (this.cdM != null) {
            this.cdM.a(cVar, this.mContext);
        }
        this.cdN = cVar;
    }

    public ai agq() {
        if (this.cdM == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cdM = com.baidu.swan.apps.w.a.acG().PE();
        }
        return this.cdM;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeS() {
        return this.cdd;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.cdN != null ? this.cdN.cds : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cdN.bGO;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeU() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cdf) {
                agq().resume();
            }
            agq().PD();
        } else if (this.cdM != null) {
            this.cdf = agq().isPlaying();
            agq().pause();
            agq().PF();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.cdM != null && this.cdM.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cdM != null) {
            this.cdM.stop();
            this.cdM = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
