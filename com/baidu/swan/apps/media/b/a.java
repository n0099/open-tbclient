package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j csr;
    private String css;
    private c cst;
    private boolean csu;
    private b csv;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cst = cVar;
        this.css = cVar.cop;
        akH();
        akG();
    }

    private void akG() {
        if (!TextUtils.isEmpty(this.css)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.csr != null) {
            this.csr.a(cVar, true);
        }
        this.cst = cVar;
    }

    public void a(b bVar) {
        this.csv = bVar;
    }

    public c UF() {
        return this.cst;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cop);
        if (this.csr != null) {
            this.csr.a(cVar);
        }
        this.cst = cVar;
    }

    public void ec(boolean z) {
        if (this.csr != null) {
            this.csr.ec(z);
        }
    }

    public void pause() {
        if (akI()) {
            akH().pause();
        }
    }

    public void resume() {
        if (akI() && !isPlaying() && this.mIsForeground && this.csr != null) {
            this.csr.resume();
        }
    }

    public void seekTo(int i) {
        if (akI() && this.csr != null) {
            this.csr.seekTo(i);
        }
    }

    public int getDuration() {
        return akH().getDuration();
    }

    public int getCurrentPosition() {
        return akH().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.csr != null && this.csr.isPlaying();
    }

    public boolean isEnd() {
        return this.csr != null && this.csr.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.csr != null) {
            this.csr.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.csr != null) {
            this.csr.i(z, i);
        }
    }

    public void b(b bVar) {
        this.csv = bVar;
    }

    public j akH() {
        if (this.csr == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.csr = com.baidu.swan.apps.u.a.agk().a(this.mContext, this.cst);
            this.csr.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.u.b.j.a
                public void b(j jVar) {
                    if (a.this.csv != null) {
                        a.this.csv.b(jVar);
                    }
                }
            });
            this.csr.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.u.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.csv != null && a.this.csv.a(jVar, i, i2);
                }
            });
            this.csr.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.u.b.j.d
                public void a(j jVar) {
                    if (a.this.csv != null) {
                        a.this.csv.a(jVar);
                    }
                }
            });
            this.csr.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.u.b.j.e
                public void c(j jVar) {
                    if (a.this.csv != null) {
                        a.this.csv.c(jVar);
                    }
                }
            });
            this.csr.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.u.b.j.f
                public void d(j jVar) {
                    if (a.this.csv != null) {
                        a.this.csv.d(jVar);
                    }
                }
            });
            this.csr.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.u.b.j.c
                public void e(j jVar) {
                    if (a.this.csv != null) {
                        a.this.csv.e(jVar);
                    }
                }
            });
        }
        return this.csr;
    }

    @Override // com.baidu.swan.apps.media.a
    public String afE() {
        return this.css;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ajn() {
        return this.cst != null ? this.cst.csG : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cst.bUu;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ajo() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ej(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.csu) {
                akH().resume();
            }
            akH().TA();
        } else if (this.csr != null) {
            this.csu = akH().isPlaying();
            akH().pause();
            akH().TC();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ek(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.csr != null && this.csr.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.csr != null) {
            this.csr.stop();
            this.csr = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void kO(String str) {
        if (this.csr != null) {
            this.csr.kO(str);
        }
    }

    public void b(c cVar) {
        if (this.csr != null) {
            this.csr.b(cVar);
        }
    }

    public void ahs() {
        if (this.csr != null) {
            this.csr.ahs();
        }
    }

    private boolean akI() {
        return (this.cst == null || TextUtils.isEmpty(this.cst.mSrc) || TextUtils.isEmpty(this.css) || TextUtils.isEmpty(this.cst.bUt)) ? false : true;
    }

    public void eb(boolean z) {
        if (this.csr != null) {
            this.csr.eb(z);
        }
    }
}
