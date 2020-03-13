package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ai;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ai bEM;
    private c bEN;
    private String bEd;
    private boolean bEf;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEN = cVar;
        this.bEd = cVar.bAA;
        Yi();
        Ye();
    }

    private void Ye() {
        if (!TextUtils.isEmpty(this.bEd)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void a(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVrVideoPlayer", "update 接口");
        }
        if (this.bEM != null) {
            this.bEM.a(cVar, true);
        }
        this.bEN = cVar;
    }

    public c Yh() {
        return this.bEN;
    }

    public void b(c cVar) {
        com.baidu.swan.apps.console.c.d("VrVideo", "Open Player " + cVar.bAA);
        if (this.bEM != null) {
            this.bEM.a(cVar, this.mContext);
        }
        this.bEN = cVar;
    }

    public ai Yi() {
        if (this.bEM == null) {
            com.baidu.swan.apps.console.c.i("VrVideo", "create player");
            this.bEM = com.baidu.swan.apps.w.a.UP().HQ();
        }
        return this.bEM;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bEd;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return this.bEN != null ? this.bEN.bEs : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEN.bin;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEf) {
                Yi().resume();
            }
            Yi().HP();
        } else if (this.bEM != null) {
            this.bEf = Yi().isPlaying();
            Yi().pause();
            Yi().HR();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("VrVideo", "onBackPressed");
        return this.bEM != null && this.bEM.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("VrVideo", MissionEvent.MESSAGE_DESTROY);
        if (this.bEM != null) {
            this.bEM.stop();
            this.bEM = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }
}
