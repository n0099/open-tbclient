package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.al;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cnF;
    private boolean cnH;
    private al con;
    private c coo;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.coo = cVar;
        this.cnF = cVar.cjA;
        ajE();
        ajA();
    }

    private void ajA() {
        if (!TextUtils.isEmpty(this.cnF)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.con != null) {
            this.con.a(cVar, true);
        }
        this.coo = cVar;
    }

    public c ajD() {
        return this.coo;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.cjA);
        if (this.con != null) {
            this.con.a(cVar, this.mContext);
        }
        this.coo = cVar;
    }

    public al ajE() {
        if (this.con == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.con = com.baidu.swan.apps.u.a.afK().Sv();
        }
        return this.con;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aey() {
        return this.cnF;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aih() {
        return this.coo != null ? this.coo.cnT : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.coo.bPG;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aii() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ee(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cnH) {
                ajE().resume();
            }
            ajE().Su();
        } else if (this.con != null) {
            this.cnH = ajE().isPlaying();
            ajE().pause();
            ajE().Sw();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ef(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.con != null && this.con.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.con != null) {
            this.con.stop();
            this.con = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
