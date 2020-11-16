package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String dcY;
    private ar ddH;
    private c ddI;
    private boolean dda;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.ddI = cVar;
        this.dcY = cVar.cZa;
        aAT();
        aAP();
    }

    private void aAP() {
        if (!TextUtils.isEmpty(this.dcY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.ddH != null) {
            this.ddH.a(cVar, true);
        }
        this.ddI = cVar;
    }

    public c aAS() {
        return this.ddI;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.cZa);
        if (this.ddH != null) {
            this.ddH.a(cVar, this.mContext);
        }
        this.ddI = cVar;
    }

    public ar aAT() {
        if (this.ddH == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.ddH = com.baidu.swan.apps.t.a.awN().ahk();
        }
        return this.ddH;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avy() {
        return this.dcY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azz() {
        return this.ddI != null ? this.ddI.ddm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ddI.cCb;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object azA() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fB(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dda) {
                aAT().resume();
            }
            aAT().onForeground();
        } else if (this.ddH != null) {
            this.dda = aAT().isPlaying();
            aAT().pause();
            aAT().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fC(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.ddH != null && this.ddH.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.ddH != null) {
            this.ddH.stop();
            this.ddH = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
