package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String doY;
    private ar dpG;
    private c dpH;
    private boolean dpa;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dpH = cVar;
        this.doY = cVar.dkT;
        aFv();
        aFr();
    }

    private void aFr() {
        if (!TextUtils.isEmpty(this.doY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.dpG != null) {
            this.dpG.a(cVar, true);
        }
        this.dpH = cVar;
    }

    public c aFu() {
        return this.dpH;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.dkT);
        if (this.dpG != null) {
            this.dpG.a(cVar, this.mContext);
        }
        this.dpH = cVar;
    }

    public ar aFv() {
        if (this.dpG == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.dpG = com.baidu.swan.apps.t.a.aBm().alA();
        }
        return this.dpG;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azX() {
        return this.doY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aDZ() {
        return this.dpH != null ? this.dpH.dpm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dpH.cNP;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aEa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fZ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dpa) {
                aFv().resume();
            }
            aFv().onForeground();
        } else if (this.dpG != null) {
            this.dpa = aFv().isPlaying();
            aFv().pause();
            aFv().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ga(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.dpG != null && this.dpG.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.dpG != null) {
            this.dpG.stop();
            this.dpG = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
