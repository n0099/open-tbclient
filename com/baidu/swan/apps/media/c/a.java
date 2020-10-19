package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private ar cQW;
    private c cQX;
    private String cQo;
    private boolean cQq;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cQX = cVar;
        this.cQo = cVar.cMu;
        axh();
        axd();
    }

    private void axd() {
        if (!TextUtils.isEmpty(this.cQo)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cQW != null) {
            this.cQW.a(cVar, true);
        }
        this.cQX = cVar;
    }

    public c axg() {
        return this.cQX;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cMu);
        if (this.cQW != null) {
            this.cQW.a(cVar, this.mContext);
        }
        this.cQX = cVar;
    }

    public ar axh() {
        if (this.cQW == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cQW = com.baidu.swan.apps.t.a.atb().ady();
        }
        return this.cQW;
    }

    @Override // com.baidu.swan.apps.media.a
    public String arL() {
        return this.cQo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avN() {
        return this.cQX != null ? this.cQX.cQC : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cQX.cpq;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object avO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fc(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cQq) {
                axh().resume();
            }
            axh().onForeground();
        } else if (this.cQW != null) {
            this.cQq = axh().isPlaying();
            axh().pause();
            axh().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fd(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cQW != null && this.cQW.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cQW != null) {
            this.cQW.stop();
            this.cQW = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
