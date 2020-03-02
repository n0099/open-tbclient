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
    private ai bEL;
    private c bEM;
    private String bEc;
    private boolean bEe;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEM = cVar;
        this.bEc = cVar.bAz;
        Yi();
        Ye();
    }

    private void Ye() {
        if (!TextUtils.isEmpty(this.bEc)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bEL != null) {
            this.bEL.a(cVar, true);
        }
        this.bEM = cVar;
    }

    public c Yh() {
        return this.bEM;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bAz);
        if (this.bEL != null) {
            this.bEL.a(cVar, this.mContext);
        }
        this.bEM = cVar;
    }

    public ai Yi() {
        if (this.bEL == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bEL = com.baidu.swan.apps.w.a.UP().HQ();
        }
        return this.bEL;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bEc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return this.bEM != null ? this.bEM.bEr : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEM.bim;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEe) {
                Yi().resume();
            }
            Yi().HP();
        } else if (this.bEL != null) {
            this.bEe = Yi().isPlaying();
            Yi().pause();
            Yi().HR();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bEL != null && this.bEL.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bEL != null) {
            this.bEL.stop();
            this.bEL = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
