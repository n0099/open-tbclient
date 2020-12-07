package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes25.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String djY;
    private ar dkG;
    private c dkH;
    private boolean dka;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dkH = cVar;
        this.djY = cVar.dga;
        aEc();
        aDY();
    }

    private void aDY() {
        if (!TextUtils.isEmpty(this.djY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.dkG != null) {
            this.dkG.a(cVar, true);
        }
        this.dkH = cVar;
    }

    public c aEb() {
        return this.dkH;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.dga);
        if (this.dkG != null) {
            this.dkG.a(cVar, this.mContext);
        }
        this.dkH = cVar;
    }

    public ar aEc() {
        if (this.dkG == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.dkG = com.baidu.swan.apps.t.a.azV().aks();
        }
        return this.dkG;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ayG() {
        return this.djY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aCI() {
        return this.dkH != null ? this.dkH.dkm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dkH.cIW;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aCJ() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dka) {
                aEc().resume();
            }
            aEc().onForeground();
        } else if (this.dkG != null) {
            this.dka = aEc().isPlaying();
            aEc().pause();
            aEc().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.dkG != null && this.dkG.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.dkG != null) {
            this.dkG.stop();
            this.dkG = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
