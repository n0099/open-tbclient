package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j cCf;
    private String cCg;
    private c cCh;
    private boolean cCi;
    private b cCj;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cCh = cVar;
        this.cCg = cVar.cyk;
        atK();
        atJ();
    }

    private void atJ() {
        if (!TextUtils.isEmpty(this.cCg)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cCf != null) {
            this.cCf.a(cVar, true);
        }
        this.cCh = cVar;
    }

    public void a(b bVar) {
        this.cCj = bVar;
    }

    public c abq() {
        return this.cCh;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cyk);
        if (this.cCf != null) {
            this.cCf.a(cVar);
        }
        this.cCh = cVar;
    }

    public void eB(boolean z) {
        if (this.cCf != null) {
            this.cCf.eB(z);
        }
    }

    public void pause() {
        if (atL()) {
            atK().pause();
        }
    }

    public void resume() {
        if (atL() && !isPlaying() && this.mIsForeground && this.cCf != null) {
            this.cCf.resume();
        }
    }

    public void seekTo(int i) {
        if (atL() && this.cCf != null) {
            this.cCf.seekTo(i);
        }
    }

    public int getDuration() {
        return atK().getDuration();
    }

    public int getCurrentPosition() {
        return atK().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cCf != null && this.cCf.isPlaying();
    }

    public boolean isEnd() {
        return this.cCf != null && this.cCf.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cCf != null) {
            this.cCf.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.cCf != null) {
            this.cCf.i(z, i);
        }
    }

    public void b(b bVar) {
        this.cCj = bVar;
    }

    public j atK() {
        if (this.cCf == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cCf = com.baidu.swan.apps.t.a.aoW().a(this.mContext, this.cCh);
            this.cCf.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cCj != null) {
                        a.this.cCj.b(jVar);
                    }
                }
            });
            this.cCf.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cCj != null && a.this.cCj.a(jVar, i, i2);
                }
            });
            this.cCf.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cCj != null) {
                        a.this.cCj.a(jVar);
                    }
                }
            });
            this.cCf.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cCj != null) {
                        a.this.cCj.c(jVar);
                    }
                }
            });
            this.cCf.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cCj != null) {
                        a.this.cCj.d(jVar);
                    }
                }
            });
            this.cCf.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cCj != null) {
                        a.this.cCj.e(jVar);
                    }
                }
            });
        }
        return this.cCf;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cCg;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return this.cCh != null ? this.cCh.cCu : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cCh.caU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cCi) {
                atK().resume();
            }
            atK().onForeground();
        } else if (this.cCf != null) {
            this.cCi = atK().isPlaying();
            atK().pause();
            atK().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cCf != null && this.cCf.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cCf != null) {
            this.cCf.stop();
            this.cCf = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ni(String str) {
        if (this.cCf != null) {
            this.cCf.ni(str);
        }
    }

    public void b(c cVar) {
        if (this.cCf != null) {
            this.cCf.b(cVar);
        }
    }

    public void aqq() {
        if (this.cCf != null) {
            this.cCf.aqq();
        }
    }

    private boolean atL() {
        return (this.cCh == null || TextUtils.isEmpty(this.cCh.mSrc) || TextUtils.isEmpty(this.cCg) || TextUtils.isEmpty(this.cCh.caT)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.cCf != null) {
            this.cCf.mute(z);
        }
    }
}
