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
    private j cQn;
    private String cQo;
    private c cQp;
    private boolean cQq;
    private b cQr;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cQp = cVar;
        this.cQo = cVar.cMu;
        axe();
        axd();
    }

    private void axd() {
        if (!TextUtils.isEmpty(this.cQo)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cQn != null) {
            this.cQn.a(cVar, true);
        }
        this.cQp = cVar;
    }

    public void a(b bVar) {
        this.cQr = bVar;
    }

    public c aeL() {
        return this.cQp;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cMu);
        if (this.cQn != null) {
            this.cQn.a(cVar);
        }
        this.cQp = cVar;
    }

    public void eW(boolean z) {
        if (this.cQn != null) {
            this.cQn.eW(z);
        }
    }

    public void pause() {
        if (axf()) {
            axe().pause();
        }
    }

    public void resume() {
        if (axf() && !isPlaying() && this.mIsForeground && this.cQn != null) {
            this.cQn.resume();
        }
    }

    public void seekTo(int i) {
        if (axf() && this.cQn != null) {
            this.cQn.seekTo(i);
        }
    }

    public int getDuration() {
        return axe().getDuration();
    }

    public int getCurrentPosition() {
        return axe().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cQn != null && this.cQn.isPlaying();
    }

    public boolean isEnd() {
        return this.cQn != null && this.cQn.isEnd();
    }

    public void c(FrameLayout frameLayout) {
        if (this.cQn != null) {
            this.cQn.c(frameLayout);
        }
    }

    public void j(boolean z, int i) {
        if (this.cQn != null) {
            this.cQn.j(z, i);
        }
    }

    public void b(b bVar) {
        this.cQr = bVar;
    }

    public j axe() {
        if (this.cQn == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cQn = com.baidu.swan.apps.t.a.ast().a(this.mContext, this.cQp);
            this.cQn.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cQr != null) {
                        a.this.cQr.b(jVar);
                    }
                }
            });
            this.cQn.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cQr != null && a.this.cQr.a(jVar, i, i2);
                }
            });
            this.cQn.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cQr != null) {
                        a.this.cQr.a(jVar);
                    }
                }
            });
            this.cQn.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cQr != null) {
                        a.this.cQr.c(jVar);
                    }
                }
            });
            this.cQn.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cQr != null) {
                        a.this.cQr.d(jVar);
                    }
                }
            });
            this.cQn.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cQr != null) {
                        a.this.cQr.e(jVar);
                    }
                }
            });
        }
        return this.cQn;
    }

    @Override // com.baidu.swan.apps.media.a
    public String arL() {
        return this.cQo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avN() {
        return this.cQp != null ? this.cQp.cQC : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cQp.cpq;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object avO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fc(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cQq) {
                axe().resume();
            }
            axe().onForeground();
        } else if (this.cQn != null) {
            this.cQq = axe().isPlaying();
            axe().pause();
            axe().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fd(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cQn != null && this.cQn.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cQn != null) {
            this.cQn.stop();
            this.cQn = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oq(String str) {
        if (this.cQn != null) {
            this.cQn.oq(str);
        }
    }

    public void b(c cVar) {
        if (this.cQn != null) {
            this.cQn.b(cVar);
        }
    }

    public void atM() {
        if (this.cQn != null) {
            this.cQn.atM();
        }
    }

    private boolean axf() {
        return (this.cQp == null || TextUtils.isEmpty(this.cQp.mSrc) || TextUtils.isEmpty(this.cQo) || TextUtils.isEmpty(this.cQp.cpp)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.cQn != null) {
            this.cQn.mute(z);
        }
    }
}
