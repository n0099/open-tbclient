package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes3.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j cEj;
    private String cEk;
    private c cEl;
    private boolean cEm;
    private b cEn;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cEl = cVar;
        this.cEk = cVar.cAp;
        aut();
        aus();
    }

    private void aus() {
        if (!TextUtils.isEmpty(this.cEk)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cEj != null) {
            this.cEj.a(cVar, true);
        }
        this.cEl = cVar;
    }

    public void a(b bVar) {
        this.cEn = bVar;
    }

    public c abZ() {
        return this.cEl;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cAp);
        if (this.cEj != null) {
            this.cEj.a(cVar);
        }
        this.cEl = cVar;
    }

    public void eA(boolean z) {
        if (this.cEj != null) {
            this.cEj.eA(z);
        }
    }

    public void pause() {
        if (auu()) {
            aut().pause();
        }
    }

    public void resume() {
        if (auu() && !isPlaying() && this.mIsForeground && this.cEj != null) {
            this.cEj.resume();
        }
    }

    public void seekTo(int i) {
        if (auu() && this.cEj != null) {
            this.cEj.seekTo(i);
        }
    }

    public int getDuration() {
        return aut().getDuration();
    }

    public int getCurrentPosition() {
        return aut().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cEj != null && this.cEj.isPlaying();
    }

    public boolean isEnd() {
        return this.cEj != null && this.cEj.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cEj != null) {
            this.cEj.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.cEj != null) {
            this.cEj.i(z, i);
        }
    }

    public void b(b bVar) {
        this.cEn = bVar;
    }

    public j aut() {
        if (this.cEj == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cEj = com.baidu.swan.apps.t.a.apH().a(this.mContext, this.cEl);
            this.cEj.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cEn != null) {
                        a.this.cEn.b(jVar);
                    }
                }
            });
            this.cEj.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cEn != null && a.this.cEn.a(jVar, i, i2);
                }
            });
            this.cEj.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cEn != null) {
                        a.this.cEn.a(jVar);
                    }
                }
            });
            this.cEj.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cEn != null) {
                        a.this.cEn.c(jVar);
                    }
                }
            });
            this.cEj.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cEn != null) {
                        a.this.cEn.d(jVar);
                    }
                }
            });
            this.cEj.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cEn != null) {
                        a.this.cEn.e(jVar);
                    }
                }
            });
        }
        return this.cEj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aoZ() {
        return this.cEk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atc() {
        return this.cEl != null ? this.cEl.cEy : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cEl.cda;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object atd() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eG(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cEm) {
                aut().resume();
            }
            aut().onForeground();
        } else if (this.cEj != null) {
            this.cEm = aut().isPlaying();
            aut().pause();
            aut().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cEj != null && this.cEj.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cEj != null) {
            this.cEj.stop();
            this.cEj = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void nC(String str) {
        if (this.cEj != null) {
            this.cEj.nC(str);
        }
    }

    public void b(c cVar) {
        if (this.cEj != null) {
            this.cEj.b(cVar);
        }
    }

    public void ara() {
        if (this.cEj != null) {
            this.cEj.ara();
        }
    }

    private boolean auu() {
        return (this.cEl == null || TextUtils.isEmpty(this.cEl.mSrc) || TextUtils.isEmpty(this.cEk) || TextUtils.isEmpty(this.cEl.ccZ)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.cEj != null) {
            this.cEj.mute(z);
        }
    }
}
