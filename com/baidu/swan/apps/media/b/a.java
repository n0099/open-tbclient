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
    private j cCj;
    private String cCk;
    private c cCl;
    private boolean cCm;
    private b cCn;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cCl = cVar;
        this.cCk = cVar.cyo;
        atK();
        atJ();
    }

    private void atJ() {
        if (!TextUtils.isEmpty(this.cCk)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cCj != null) {
            this.cCj.a(cVar, true);
        }
        this.cCl = cVar;
    }

    public void a(b bVar) {
        this.cCn = bVar;
    }

    public c abq() {
        return this.cCl;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cyo);
        if (this.cCj != null) {
            this.cCj.a(cVar);
        }
        this.cCl = cVar;
    }

    public void eC(boolean z) {
        if (this.cCj != null) {
            this.cCj.eC(z);
        }
    }

    public void pause() {
        if (atL()) {
            atK().pause();
        }
    }

    public void resume() {
        if (atL() && !isPlaying() && this.mIsForeground && this.cCj != null) {
            this.cCj.resume();
        }
    }

    public void seekTo(int i) {
        if (atL() && this.cCj != null) {
            this.cCj.seekTo(i);
        }
    }

    public int getDuration() {
        return atK().getDuration();
    }

    public int getCurrentPosition() {
        return atK().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cCj != null && this.cCj.isPlaying();
    }

    public boolean isEnd() {
        return this.cCj != null && this.cCj.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cCj != null) {
            this.cCj.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.cCj != null) {
            this.cCj.i(z, i);
        }
    }

    public void b(b bVar) {
        this.cCn = bVar;
    }

    public j atK() {
        if (this.cCj == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cCj = com.baidu.swan.apps.t.a.aoW().a(this.mContext, this.cCl);
            this.cCj.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cCn != null) {
                        a.this.cCn.b(jVar);
                    }
                }
            });
            this.cCj.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cCn != null && a.this.cCn.a(jVar, i, i2);
                }
            });
            this.cCj.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cCn != null) {
                        a.this.cCn.a(jVar);
                    }
                }
            });
            this.cCj.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cCn != null) {
                        a.this.cCn.c(jVar);
                    }
                }
            });
            this.cCj.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cCn != null) {
                        a.this.cCn.d(jVar);
                    }
                }
            });
            this.cCj.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cCn != null) {
                        a.this.cCn.e(jVar);
                    }
                }
            });
        }
        return this.cCj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cCk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return this.cCl != null ? this.cCl.cCy : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cCl.caY;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cCm) {
                atK().resume();
            }
            atK().onForeground();
        } else if (this.cCj != null) {
            this.cCm = atK().isPlaying();
            atK().pause();
            atK().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eJ(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cCj != null && this.cCj.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cCj != null) {
            this.cCj.stop();
            this.cCj = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void nj(String str) {
        if (this.cCj != null) {
            this.cCj.nj(str);
        }
    }

    public void b(c cVar) {
        if (this.cCj != null) {
            this.cCj.b(cVar);
        }
    }

    public void aqq() {
        if (this.cCj != null) {
            this.cCj.aqq();
        }
    }

    private boolean atL() {
        return (this.cCl == null || TextUtils.isEmpty(this.cCl.mSrc) || TextUtils.isEmpty(this.cCk) || TextUtils.isEmpty(this.cCl.caX)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.cCj != null) {
            this.cCj.mute(z);
        }
    }
}
