package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes25.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j djX;
    private String djY;
    private c djZ;
    private boolean dka;
    private b dkb;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.djZ = cVar;
        this.djY = cVar.dga;
        aDZ();
        aDY();
    }

    private void aDY() {
        if (!TextUtils.isEmpty(this.djY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.djX != null) {
            this.djX.a(cVar, true);
        }
        this.djZ = cVar;
    }

    public void a(b bVar) {
        this.dkb = bVar;
    }

    public c alF() {
        return this.djZ;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.dga);
        if (this.djX != null) {
            this.djX.a(cVar);
        }
        this.djZ = cVar;
    }

    public void fK(boolean z) {
        if (this.djX != null) {
            this.djX.fK(z);
        }
    }

    public void pause() {
        if (aEa()) {
            aDZ().pause();
        }
    }

    public void resume() {
        if (aEa() && !isPlaying() && this.mIsForeground && this.djX != null) {
            this.djX.resume();
        }
    }

    public void seekTo(int i) {
        if (aEa() && this.djX != null) {
            this.djX.seekTo(i);
        }
    }

    public int getDuration() {
        return aDZ().getDuration();
    }

    public int getCurrentPosition() {
        return aDZ().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.djX != null && this.djX.isPlaying();
    }

    public boolean isEnd() {
        return this.djX != null && this.djX.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.djX != null) {
            this.djX.f(frameLayout);
        }
    }

    public void j(boolean z, int i) {
        if (this.djX != null) {
            this.djX.j(z, i);
        }
    }

    public void b(b bVar) {
        this.dkb = bVar;
    }

    public j aDZ() {
        if (this.djX == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.djX = com.baidu.swan.apps.t.a.azn().a(this.mContext, this.djZ);
            this.djX.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.dkb != null) {
                        a.this.dkb.b(jVar);
                    }
                }
            });
            this.djX.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.dkb != null && a.this.dkb.a(jVar, i, i2);
                }
            });
            this.djX.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.dkb != null) {
                        a.this.dkb.a(jVar);
                    }
                }
            });
            this.djX.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.dkb != null) {
                        a.this.dkb.c(jVar);
                    }
                }
            });
            this.djX.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.dkb != null) {
                        a.this.dkb.d(jVar);
                    }
                }
            });
            this.djX.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.dkb != null) {
                        a.this.dkb.e(jVar);
                    }
                }
            });
        }
        return this.djX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ayG() {
        return this.djY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aCI() {
        return this.djZ != null ? this.djZ.dkm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.djZ.cIW;
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
                aDZ().resume();
            }
            aDZ().onForeground();
        } else if (this.djX != null) {
            this.dka = aDZ().isPlaying();
            aDZ().pause();
            aDZ().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.djX != null && this.djX.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.djX != null) {
            this.djX.stop();
            this.djX = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void py(String str) {
        if (this.djX != null) {
            this.djX.py(str);
        }
    }

    public void b(c cVar) {
        if (this.djX != null) {
            this.djX.b(cVar);
        }
    }

    public void aAH() {
        if (this.djX != null) {
            this.djX.aAH();
        }
    }

    private boolean aEa() {
        return (this.djZ == null || TextUtils.isEmpty(this.djZ.mSrc) || TextUtils.isEmpty(this.djY) || TextUtils.isEmpty(this.djZ.cIV)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.djX != null) {
            this.djX.mute(z);
        }
    }
}
