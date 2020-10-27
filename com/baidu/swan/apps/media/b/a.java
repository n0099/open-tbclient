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
    private j cYJ;
    private String cYK;
    private c cYL;
    private boolean cYM;
    private b cYN;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cYL = cVar;
        this.cYK = cVar.cUQ;
        ayY();
        ayX();
    }

    private void ayX() {
        if (!TextUtils.isEmpty(this.cYK)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cYJ != null) {
            this.cYJ.a(cVar, true);
        }
        this.cYL = cVar;
    }

    public void a(b bVar) {
        this.cYN = bVar;
    }

    public c agF() {
        return this.cYL;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cUQ);
        if (this.cYJ != null) {
            this.cYJ.a(cVar);
        }
        this.cYL = cVar;
    }

    public void fj(boolean z) {
        if (this.cYJ != null) {
            this.cYJ.fj(z);
        }
    }

    public void pause() {
        if (ayZ()) {
            ayY().pause();
        }
    }

    public void resume() {
        if (ayZ() && !isPlaying() && this.mIsForeground && this.cYJ != null) {
            this.cYJ.resume();
        }
    }

    public void seekTo(int i) {
        if (ayZ() && this.cYJ != null) {
            this.cYJ.seekTo(i);
        }
    }

    public int getDuration() {
        return ayY().getDuration();
    }

    public int getCurrentPosition() {
        return ayY().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cYJ != null && this.cYJ.isPlaying();
    }

    public boolean isEnd() {
        return this.cYJ != null && this.cYJ.isEnd();
    }

    public void c(FrameLayout frameLayout) {
        if (this.cYJ != null) {
            this.cYJ.c(frameLayout);
        }
    }

    public void j(boolean z, int i) {
        if (this.cYJ != null) {
            this.cYJ.j(z, i);
        }
    }

    public void b(b bVar) {
        this.cYN = bVar;
    }

    public j ayY() {
        if (this.cYJ == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cYJ = com.baidu.swan.apps.t.a.aun().a(this.mContext, this.cYL);
            this.cYJ.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cYN != null) {
                        a.this.cYN.b(jVar);
                    }
                }
            });
            this.cYJ.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cYN != null && a.this.cYN.a(jVar, i, i2);
                }
            });
            this.cYJ.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cYN != null) {
                        a.this.cYN.a(jVar);
                    }
                }
            });
            this.cYJ.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cYN != null) {
                        a.this.cYN.c(jVar);
                    }
                }
            });
            this.cYJ.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cYN != null) {
                        a.this.cYN.d(jVar);
                    }
                }
            });
            this.cYJ.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cYN != null) {
                        a.this.cYN.e(jVar);
                    }
                }
            });
        }
        return this.cYJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atG() {
        return this.cYK;
    }

    @Override // com.baidu.swan.apps.media.a
    public String axH() {
        return this.cYL != null ? this.cYL.cYY : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cYL.cxS;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object axI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fp(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cYM) {
                ayY().resume();
            }
            ayY().onForeground();
        } else if (this.cYJ != null) {
            this.cYM = ayY().isPlaying();
            ayY().pause();
            ayY().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fq(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cYJ != null && this.cYJ.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cYJ != null) {
            this.cYJ.stop();
            this.cYJ = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oJ(String str) {
        if (this.cYJ != null) {
            this.cYJ.oJ(str);
        }
    }

    public void b(c cVar) {
        if (this.cYJ != null) {
            this.cYJ.b(cVar);
        }
    }

    public void avG() {
        if (this.cYJ != null) {
            this.cYJ.avG();
        }
    }

    private boolean ayZ() {
        return (this.cYL == null || TextUtils.isEmpty(this.cYL.mSrc) || TextUtils.isEmpty(this.cYK) || TextUtils.isEmpty(this.cYL.cxR)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.cYJ != null) {
            this.cYJ.mute(z);
        }
    }
}
