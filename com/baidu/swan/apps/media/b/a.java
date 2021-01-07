package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j doX;
    private String doY;
    private c doZ;
    private boolean dpa;
    private b dpb;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.doZ = cVar;
        this.doY = cVar.dkT;
        aFt();
        aFs();
    }

    private void aFs() {
        if (!TextUtils.isEmpty(this.doY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.doX != null) {
            this.doX.a(cVar, true);
        }
        this.doZ = cVar;
    }

    public void a(b bVar) {
        this.dpb = bVar;
    }

    public c amQ() {
        return this.doZ;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.dkT);
        if (this.doX != null) {
            this.doX.a(cVar);
        }
        this.doZ = cVar;
    }

    public void fT(boolean z) {
        if (this.doX != null) {
            this.doX.fT(z);
        }
    }

    public void pause() {
        if (aFu()) {
            aFt().pause();
        }
    }

    public void resume() {
        if (aFu() && !isPlaying() && this.mIsForeground && this.doX != null) {
            this.doX.resume();
        }
    }

    public void seekTo(int i) {
        if (aFu() && this.doX != null) {
            this.doX.seekTo(i);
        }
    }

    public int getDuration() {
        return aFt().getDuration();
    }

    public int getCurrentPosition() {
        return aFt().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.doX != null && this.doX.isPlaying();
    }

    public boolean isEnd() {
        return this.doX != null && this.doX.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.doX != null) {
            this.doX.f(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.doX != null) {
            this.doX.i(z, i);
        }
    }

    public void b(b bVar) {
        this.dpb = bVar;
    }

    public j aFt() {
        if (this.doX == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.doX = com.baidu.swan.apps.t.a.aAF().a(this.mContext, this.doZ);
            this.doX.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.dpb != null) {
                        a.this.dpb.b(jVar);
                    }
                }
            });
            this.doX.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.dpb != null && a.this.dpb.a(jVar, i, i2);
                }
            });
            this.doX.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.dpb != null) {
                        a.this.dpb.a(jVar);
                    }
                }
            });
            this.doX.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.dpb != null) {
                        a.this.dpb.c(jVar);
                    }
                }
            });
            this.doX.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.dpb != null) {
                        a.this.dpb.d(jVar);
                    }
                }
            });
            this.doX.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.dpb != null) {
                        a.this.dpb.e(jVar);
                    }
                }
            });
        }
        return this.doX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azY() {
        return this.doY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aEa() {
        return this.doZ != null ? this.doZ.dpm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.doZ.cNP;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aEb() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fZ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dpa) {
                aFt().resume();
            }
            aFt().onForeground();
        } else if (this.doX != null) {
            this.dpa = aFt().isPlaying();
            aFt().pause();
            aFt().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ga(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.doX != null && this.doX.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.doX != null) {
            this.doX.stop();
            this.doX = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void pr(String str) {
        if (this.doX != null) {
            this.doX.pr(str);
        }
    }

    public void b(c cVar) {
        if (this.doX != null) {
            this.doX.b(cVar);
        }
    }

    public void aBZ() {
        if (this.doX != null) {
            this.doX.aBZ();
        }
    }

    private boolean aFu() {
        return (this.doZ == null || TextUtils.isEmpty(this.doZ.mSrc) || TextUtils.isEmpty(this.doY) || TextUtils.isEmpty(this.doZ.cNO)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.doX != null) {
            this.doX.mute(z);
        }
    }
}
