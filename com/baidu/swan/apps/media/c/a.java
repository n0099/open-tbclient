package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String deH;
    private boolean deJ;
    private ar dfp;
    private c dfq;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dfq = cVar;
        this.deH = cVar.daK;
        aBB();
        aBx();
    }

    private void aBx() {
        if (!TextUtils.isEmpty(this.deH)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.dfp != null) {
            this.dfp.a(cVar, true);
        }
        this.dfq = cVar;
    }

    public c aBA() {
        return this.dfq;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.daK);
        if (this.dfp != null) {
            this.dfp.a(cVar, this.mContext);
        }
        this.dfq = cVar;
    }

    public ar aBB() {
        if (this.dfp == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.dfp = com.baidu.swan.apps.t.a.axv().ahS();
        }
        return this.dfp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awg() {
        return this.deH;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAh() {
        return this.dfq != null ? this.dfq.deV : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dfq.cDL;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAi() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fy(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.deJ) {
                aBB().resume();
            }
            aBB().onForeground();
        } else if (this.dfp != null) {
            this.deJ = aBB().isPlaying();
            aBB().pause();
            aBB().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fz(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.dfp != null && this.dfp.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.dfp != null) {
            this.dfp.stop();
            this.dfp = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
