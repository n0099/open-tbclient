package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String cYK;
    private boolean cYM;
    private ar cZs;
    private c cZt;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cZt = cVar;
        this.cYK = cVar.cUQ;
        azb();
        ayX();
    }

    private void ayX() {
        if (!TextUtils.isEmpty(this.cYK)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cZs != null) {
            this.cZs.a(cVar, true);
        }
        this.cZt = cVar;
    }

    public c aza() {
        return this.cZt;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cUQ);
        if (this.cZs != null) {
            this.cZs.a(cVar, this.mContext);
        }
        this.cZt = cVar;
    }

    public ar azb() {
        if (this.cZs == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cZs = com.baidu.swan.apps.t.a.auV().afs();
        }
        return this.cZs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atG() {
        return this.cYK;
    }

    @Override // com.baidu.swan.apps.media.a
    public String axH() {
        return this.cZt != null ? this.cZt.cYY : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cZt.cxS;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object axI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fp(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cYM) {
                azb().resume();
            }
            azb().onForeground();
        } else if (this.cZs != null) {
            this.cYM = azb().isPlaying();
            azb().pause();
            azb().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fq(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cZs != null && this.cZs.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cZs != null) {
            this.cZs.stop();
            this.cZs = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
