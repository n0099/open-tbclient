package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes3.dex */
public class a implements com.baidu.swan.apps.media.a {
    private ar cES;
    private c cET;
    private String cEk;
    private boolean cEm;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cET = cVar;
        this.cEk = cVar.cAp;
        auw();
        aus();
    }

    private void aus() {
        if (!TextUtils.isEmpty(this.cEk)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cES != null) {
            this.cES.a(cVar, true);
        }
        this.cET = cVar;
    }

    public c auv() {
        return this.cET;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cAp);
        if (this.cES != null) {
            this.cES.a(cVar, this.mContext);
        }
        this.cET = cVar;
    }

    public ar auw() {
        if (this.cES == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cES = com.baidu.swan.apps.t.a.aqp().aaM();
        }
        return this.cES;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aoZ() {
        return this.cEk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atc() {
        return this.cET != null ? this.cET.cEy : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cET.cda;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object atd() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eG(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cEm) {
                auw().resume();
            }
            auw().onForeground();
        } else if (this.cES != null) {
            this.cEm = auw().isPlaying();
            auw().pause();
            auw().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cES != null && this.cES.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cES != null) {
            this.cES.stop();
            this.cES = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
