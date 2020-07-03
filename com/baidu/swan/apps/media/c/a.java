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
    private String css;
    private boolean csu;
    private al cta;
    private c ctb;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.ctb = cVar;
        this.css = cVar.cop;
        akK();
        akG();
    }

    private void akG() {
        if (!TextUtils.isEmpty(this.css)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.cta != null) {
            this.cta.a(cVar, true);
        }
        this.ctb = cVar;
    }

    public c akJ() {
        return this.ctb;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.cop);
        if (this.cta != null) {
            this.cta.a(cVar, this.mContext);
        }
        this.ctb = cVar;
    }

    public al akK() {
        if (this.cta == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cta = com.baidu.swan.apps.u.a.agQ().TB();
        }
        return this.cta;
    }

    @Override // com.baidu.swan.apps.media.a
    public String afE() {
        return this.css;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ajn() {
        return this.ctb != null ? this.ctb.csG : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ctb.bUu;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ajo() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ej(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.csu) {
                akK().resume();
            }
            akK().TA();
        } else if (this.cta != null) {
            this.csu = akK().isPlaying();
            akK().pause();
            akK().TC();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ek(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.cta != null && this.cta.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cta != null) {
            this.cta.stop();
            this.cta = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
