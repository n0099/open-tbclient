package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private ar dkQ;
    private c dkR;
    private String dkj;
    private boolean dkl;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dkR = cVar;
        this.dkj = cVar.dge;
        aBC();
        aBy();
    }

    private void aBy() {
        if (!TextUtils.isEmpty(this.dkj)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "update 接口");
        if (this.dkQ != null) {
            this.dkQ.a(cVar, true);
        }
        this.dkR = cVar;
    }

    public c aBB() {
        return this.dkR;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.i("VrVideo", "Open Player " + cVar.dge);
        if (this.dkQ != null) {
            this.dkQ.a(cVar, this.mContext);
        }
        this.dkR = cVar;
    }

    public ar aBC() {
        if (this.dkQ == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.dkQ = com.baidu.swan.apps.t.a.axt().ahH();
        }
        return this.dkQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awe() {
        return this.dkj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAg() {
        return this.dkR != null ? this.dkR.dkw : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dkR.cJd;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAh() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fV(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dkl) {
                aBC().resume();
            }
            aBC().Rf();
        } else if (this.dkQ != null) {
            this.dkl = aBC().isPlaying();
            aBC().pause();
            aBC().Re();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fW(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("VrVideo", "onBackPressed");
        return this.dkQ != null && this.dkQ.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.dkQ != null) {
            this.dkQ.stop();
            this.dkQ = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
