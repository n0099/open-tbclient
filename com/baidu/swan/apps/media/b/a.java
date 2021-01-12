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
    private j dki;
    private String dkj;
    private c dkk;
    private boolean dkl;
    private b dkm;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dkk = cVar;
        this.dkj = cVar.dge;
        aBz();
        aBy();
    }

    private void aBy() {
        if (!TextUtils.isEmpty(this.dkj)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.dki != null) {
            this.dki.a(cVar, true);
        }
        this.dkk = cVar;
    }

    public void a(b bVar) {
        this.dkm = bVar;
    }

    public c aiW() {
        return this.dkk;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.dge);
        if (this.dki != null) {
            this.dki.a(cVar);
        }
        this.dkk = cVar;
    }

    public void fP(boolean z) {
        if (this.dki != null) {
            this.dki.fP(z);
        }
    }

    public void pause() {
        if (aBA()) {
            aBz().pause();
        }
    }

    public void resume() {
        if (aBA() && !isPlaying() && this.mIsForeground && this.dki != null) {
            this.dki.resume();
        }
    }

    public void seekTo(int i) {
        if (aBA() && this.dki != null) {
            this.dki.seekTo(i);
        }
    }

    public int getDuration() {
        return aBz().getDuration();
    }

    public int getCurrentPosition() {
        return aBz().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.dki != null && this.dki.isPlaying();
    }

    public boolean isEnd() {
        return this.dki != null && this.dki.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.dki != null) {
            this.dki.f(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.dki != null) {
            this.dki.i(z, i);
        }
    }

    public void b(b bVar) {
        this.dkm = bVar;
    }

    public j aBz() {
        if (this.dki == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dki = com.baidu.swan.apps.t.a.awL().a(this.mContext, this.dkk);
            this.dki.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.dkm != null) {
                        a.this.dkm.b(jVar);
                    }
                }
            });
            this.dki.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.dkm != null && a.this.dkm.a(jVar, i, i2);
                }
            });
            this.dki.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.dkm != null) {
                        a.this.dkm.a(jVar);
                    }
                }
            });
            this.dki.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.dkm != null) {
                        a.this.dkm.c(jVar);
                    }
                }
            });
            this.dki.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.dkm != null) {
                        a.this.dkm.d(jVar);
                    }
                }
            });
            this.dki.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.dkm != null) {
                        a.this.dkm.e(jVar);
                    }
                }
            });
        }
        return this.dki;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awe() {
        return this.dkj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAg() {
        return this.dkk != null ? this.dkk.dkw : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dkk.cJd;
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
                aBz().resume();
            }
            aBz().Rf();
        } else if (this.dki != null) {
            this.dkl = aBz().isPlaying();
            aBz().pause();
            aBz().Re();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fW(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.dki != null && this.dki.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.dki != null) {
            this.dki.stop();
            this.dki = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oe(String str) {
        if (this.dki != null) {
            this.dki.oe(str);
        }
    }

    public void b(c cVar) {
        if (this.dki != null) {
            this.dki.b(cVar);
        }
    }

    public void ayf() {
        if (this.dki != null) {
            this.dki.ayf();
        }
    }

    private boolean aBA() {
        return (this.dkk == null || TextUtils.isEmpty(this.dkk.mSrc) || TextUtils.isEmpty(this.dkj) || TextUtils.isEmpty(this.dkk.cJc)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.dki != null) {
            this.dki.mute(z);
        }
    }
}
