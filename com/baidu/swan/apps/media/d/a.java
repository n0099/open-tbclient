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
    private String ccX;
    private boolean ccZ;
    private ai cdG;
    private c cdH;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cdH = cVar;
        this.ccX = cVar.bYS;
        agr();
        agn();
    }

    private void agn() {
        if (!TextUtils.isEmpty(this.ccX)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.cdG != null) {
            this.cdG.a(cVar, true);
        }
        this.cdH = cVar;
    }

    public c agq() {
        return this.cdH;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bYS);
        if (this.cdG != null) {
            this.cdG.a(cVar, this.mContext);
        }
        this.cdH = cVar;
    }

    public ai agr() {
        if (this.cdG == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cdG = com.baidu.swan.apps.w.a.acH().PF();
        }
        return this.cdG;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.ccX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeU() {
        return this.cdH != null ? this.cdH.cdm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cdH.bGJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeV() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.ccZ) {
                agr().resume();
            }
            agr().PE();
        } else if (this.cdG != null) {
            this.ccZ = agr().isPlaying();
            agr().pause();
            agr().PG();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.cdG != null && this.cdG.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cdG != null) {
            this.cdG.stop();
            this.cdG = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
