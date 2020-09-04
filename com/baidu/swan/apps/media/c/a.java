package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private ar cCS;
    private c cCT;
    private String cCk;
    private boolean cCm;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cCT = cVar;
        this.cCk = cVar.cyo;
        atN();
        atJ();
    }

    private void atJ() {
        if (!TextUtils.isEmpty(this.cCk)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.cCS != null) {
            this.cCS.a(cVar, true);
        }
        this.cCT = cVar;
    }

    public c atM() {
        return this.cCT;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cyo);
        if (this.cCS != null) {
            this.cCS.a(cVar, this.mContext);
        }
        this.cCT = cVar;
    }

    public ar atN() {
        if (this.cCS == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.cCS = com.baidu.swan.apps.t.a.apF().aad();
        }
        return this.cCS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cCk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return this.cCT != null ? this.cCT.cCy : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cCT.caY;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cCm) {
                atN().resume();
            }
            atN().onForeground();
        } else if (this.cCS != null) {
            this.cCm = atN().isPlaying();
            atN().pause();
            atN().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eJ(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.cCS != null && this.cCS.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.cCS != null) {
            this.cCS.stop();
            this.cCS = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
