package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String dnU;
    private boolean dnW;
    private ar doE;
    private c doF;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.doF = cVar;
        this.dnU = cVar.djT;
        aCc();
        aBY();
    }

    private void aBY() {
        if (!TextUtils.isEmpty(this.dnU)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.doE != null) {
            this.doE.a(cVar, true);
        }
        this.doF = cVar;
    }

    public c aCb() {
        return this.doF;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.djT);
        if (this.doE != null) {
            this.doE.a(cVar, this.mContext);
        }
        this.doF = cVar;
    }

    public ar aCc() {
        if (this.doE == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.doE = com.baidu.swan.apps.t.a.axU().aii();
        }
        return this.doE;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awF() {
        return this.dnU;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAH() {
        return this.doF != null ? this.doF.doj : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.doF.cMR;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dnW) {
                aCc().resume();
            }
            aCc().onForeground();
        } else if (this.doE != null) {
            this.dnW = aCc().isPlaying();
            aCc().pause();
            aCc().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.doE != null && this.doE.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.doE != null) {
            this.doE.stop();
            this.doE = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
