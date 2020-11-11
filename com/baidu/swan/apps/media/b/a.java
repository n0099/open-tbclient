package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j deG;
    private String deH;
    private c deI;
    private boolean deJ;
    private b deK;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.deI = cVar;
        this.deH = cVar.daK;
        aBy();
        aBx();
    }

    private void aBx() {
        if (!TextUtils.isEmpty(this.deH)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.deG != null) {
            this.deG.a(cVar, true);
        }
        this.deI = cVar;
    }

    public void a(b bVar) {
        this.deK = bVar;
    }

    public c ajf() {
        return this.deI;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.daK);
        if (this.deG != null) {
            this.deG.a(cVar);
        }
        this.deI = cVar;
    }

    public void fs(boolean z) {
        if (this.deG != null) {
            this.deG.fs(z);
        }
    }

    public void pause() {
        if (aBz()) {
            aBy().pause();
        }
    }

    public void resume() {
        if (aBz() && !isPlaying() && this.mIsForeground && this.deG != null) {
            this.deG.resume();
        }
    }

    public void seekTo(int i) {
        if (aBz() && this.deG != null) {
            this.deG.seekTo(i);
        }
    }

    public int getDuration() {
        return aBy().getDuration();
    }

    public int getCurrentPosition() {
        return aBy().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.deG != null && this.deG.isPlaying();
    }

    public boolean isEnd() {
        return this.deG != null && this.deG.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.deG != null) {
            this.deG.f(frameLayout);
        }
    }

    public void j(boolean z, int i) {
        if (this.deG != null) {
            this.deG.j(z, i);
        }
    }

    public void b(b bVar) {
        this.deK = bVar;
    }

    public j aBy() {
        if (this.deG == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.deG = com.baidu.swan.apps.t.a.awN().a(this.mContext, this.deI);
            this.deG.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.deK != null) {
                        a.this.deK.b(jVar);
                    }
                }
            });
            this.deG.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.deK != null && a.this.deK.a(jVar, i, i2);
                }
            });
            this.deG.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.deK != null) {
                        a.this.deK.a(jVar);
                    }
                }
            });
            this.deG.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.deK != null) {
                        a.this.deK.c(jVar);
                    }
                }
            });
            this.deG.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.deK != null) {
                        a.this.deK.d(jVar);
                    }
                }
            });
            this.deG.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.deK != null) {
                        a.this.deK.e(jVar);
                    }
                }
            });
        }
        return this.deG;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awg() {
        return this.deH;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAh() {
        return this.deI != null ? this.deI.deV : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.deI.cDL;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAi() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fy(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.deJ) {
                aBy().resume();
            }
            aBy().onForeground();
        } else if (this.deG != null) {
            this.deJ = aBy().isPlaying();
            aBy().pause();
            aBy().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fz(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.deG != null && this.deG.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.deG != null) {
            this.deG.stop();
            this.deG = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oX(String str) {
        if (this.deG != null) {
            this.deG.oX(str);
        }
    }

    public void b(c cVar) {
        if (this.deG != null) {
            this.deG.b(cVar);
        }
    }

    public void ayg() {
        if (this.deG != null) {
            this.deG.ayg();
        }
    }

    private boolean aBz() {
        return (this.deI == null || TextUtils.isEmpty(this.deI.mSrc) || TextUtils.isEmpty(this.deH) || TextUtils.isEmpty(this.deI.cDK)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.deG != null) {
            this.deG.mute(z);
        }
    }
}
