package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j dnT;
    private String dnU;
    private c dnV;
    private boolean dnW;
    private b dnX;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dnV = cVar;
        this.dnU = cVar.djT;
        aBZ();
        aBY();
    }

    private void aBY() {
        if (!TextUtils.isEmpty(this.dnU)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.dnT != null) {
            this.dnT.a(cVar, true);
        }
        this.dnV = cVar;
    }

    public void a(b bVar) {
        this.dnX = bVar;
    }

    public c ajx() {
        return this.dnV;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.djT);
        if (this.dnT != null) {
            this.dnT.a(cVar);
        }
        this.dnV = cVar;
    }

    public void fR(boolean z) {
        if (this.dnT != null) {
            this.dnT.fR(z);
        }
    }

    public void pause() {
        if (aCa()) {
            aBZ().pause();
        }
    }

    public void resume() {
        if (aCa() && !isPlaying() && this.mIsForeground && this.dnT != null) {
            this.dnT.resume();
        }
    }

    public void seekTo(int i) {
        if (aCa() && this.dnT != null) {
            this.dnT.seekTo(i);
        }
    }

    public int getDuration() {
        return aBZ().getDuration();
    }

    public int getCurrentPosition() {
        return aBZ().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.dnT != null && this.dnT.isPlaying();
    }

    public boolean isEnd() {
        return this.dnT != null && this.dnT.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.dnT != null) {
            this.dnT.f(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.dnT != null) {
            this.dnT.i(z, i);
        }
    }

    public void b(b bVar) {
        this.dnX = bVar;
    }

    public j aBZ() {
        if (this.dnT == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dnT = com.baidu.swan.apps.t.a.axm().a(this.mContext, this.dnV);
            this.dnT.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.dnX != null) {
                        a.this.dnX.b(jVar);
                    }
                }
            });
            this.dnT.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.dnX != null && a.this.dnX.a(jVar, i, i2);
                }
            });
            this.dnT.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.dnX != null) {
                        a.this.dnX.a(jVar);
                    }
                }
            });
            this.dnT.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.dnX != null) {
                        a.this.dnX.c(jVar);
                    }
                }
            });
            this.dnT.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.dnX != null) {
                        a.this.dnX.d(jVar);
                    }
                }
            });
            this.dnT.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.dnX != null) {
                        a.this.dnX.e(jVar);
                    }
                }
            });
        }
        return this.dnT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awF() {
        return this.dnU;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAH() {
        return this.dnV != null ? this.dnV.doj : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dnV.cMR;
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
                aBZ().resume();
            }
            aBZ().onForeground();
        } else if (this.dnT != null) {
            this.dnW = aBZ().isPlaying();
            aBZ().pause();
            aBZ().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.dnT != null && this.dnT.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.dnT != null) {
            this.dnT.stop();
            this.dnT = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oF(String str) {
        if (this.dnT != null) {
            this.dnT.oF(str);
        }
    }

    public void b(c cVar) {
        if (this.dnT != null) {
            this.dnT.b(cVar);
        }
    }

    public void ayG() {
        if (this.dnT != null) {
            this.dnT.ayG();
        }
    }

    private boolean aCa() {
        return (this.dnV == null || TextUtils.isEmpty(this.dnV.mSrc) || TextUtils.isEmpty(this.dnU) || TextUtils.isEmpty(this.dnV.cMQ)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.dnT != null) {
            this.dnT.mute(z);
        }
    }
}
