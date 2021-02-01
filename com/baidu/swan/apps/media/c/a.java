package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.media.a {
    private String dms;
    private boolean dmu;
    private ar dna;
    private c dnb;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dnb = cVar;
        this.dms = cVar.diq;
        aBZ();
        aBV();
    }

    private void aBV() {
        if (!TextUtils.isEmpty(this.dms)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.dna != null) {
            this.dna.a(cVar, true);
        }
        this.dnb = cVar;
    }

    public c aBY() {
        return this.dnb;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.diq);
        if (this.dna != null) {
            this.dna.a(cVar, this.mContext);
        }
        this.dnb = cVar;
    }

    public ar aBZ() {
        if (this.dna == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.dna = com.baidu.swan.apps.t.a.axR().aif();
        }
        return this.dna;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awC() {
        return this.dms;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAE() {
        return this.dnb != null ? this.dnb.dmG : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dnb.cLr;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAF() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dmu) {
                aBZ().resume();
            }
            aBZ().onForeground();
        } else if (this.dna != null) {
            this.dmu = aBZ().isPlaying();
            aBZ().pause();
            aBZ().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.dna != null && this.dna.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.dna != null) {
            this.dna.stop();
            this.dna = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
