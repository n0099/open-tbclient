package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.an;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String cuw;
    private boolean cuy;
    private an cve;
    private c cvf;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cvf = cVar;
        this.cuw = cVar.cqu;
        ama();
        alW();
    }

    private void alW() {
        if (!TextUtils.isEmpty(this.cuw)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cve != null) {
            this.cve.a(cVar, true);
        }
        this.cvf = cVar;
    }

    public c alZ() {
        return this.cvf;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cqu);
        if (this.cve != null) {
            this.cve.a(cVar, this.mContext);
        }
        this.cvf = cVar;
    }

    public an ama() {
        if (this.cve == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cve = com.baidu.swan.apps.t.a.aid().Ub();
        }
        return this.cve;
    }

    @Override // com.baidu.swan.apps.media.a
    public String agP() {
        return this.cuw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String akD() {
        return this.cvf != null ? this.cvf.cuK : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cvf.bVm;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object akE() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void er(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cuy) {
                ama().resume();
            }
            ama().Ua();
        } else if (this.cve != null) {
            this.cuy = ama().isPlaying();
            ama().pause();
            ama().Uc();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void es(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cve != null && this.cve.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cve != null) {
            this.cve.stop();
            this.cve = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
