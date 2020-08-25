package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private ar cCO;
    private c cCP;
    private String cCg;
    private boolean cCi;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cCP = cVar;
        this.cCg = cVar.cyk;
        atN();
        atJ();
    }

    private void atJ() {
        if (!TextUtils.isEmpty(this.cCg)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cCO != null) {
            this.cCO.a(cVar, true);
        }
        this.cCP = cVar;
    }

    public c atM() {
        return this.cCP;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cyk);
        if (this.cCO != null) {
            this.cCO.a(cVar, this.mContext);
        }
        this.cCP = cVar;
    }

    public ar atN() {
        if (this.cCO == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cCO = com.baidu.swan.apps.t.a.apF().aad();
        }
        return this.cCO;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cCg;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return this.cCP != null ? this.cCP.cCu : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cCP.caU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cCi) {
                atN().resume();
            }
            atN().onForeground();
        } else if (this.cCO != null) {
            this.cCi = atN().isPlaying();
            atN().pause();
            atN().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cCO != null && this.cCO.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cCO != null) {
            this.cCO.stop();
            this.cCO = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
