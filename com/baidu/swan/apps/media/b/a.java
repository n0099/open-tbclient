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
    private j dmr;
    private String dms;
    private c dmt;
    private boolean dmu;
    private b dmv;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dmt = cVar;
        this.dms = cVar.diq;
        aBW();
        aBV();
    }

    private void aBV() {
        if (!TextUtils.isEmpty(this.dms)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.dmr != null) {
            this.dmr.a(cVar, true);
        }
        this.dmt = cVar;
    }

    public void a(b bVar) {
        this.dmv = bVar;
    }

    public c aju() {
        return this.dmt;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.diq);
        if (this.dmr != null) {
            this.dmr.a(cVar);
        }
        this.dmt = cVar;
    }

    public void fR(boolean z) {
        if (this.dmr != null) {
            this.dmr.fR(z);
        }
    }

    public void pause() {
        if (aBX()) {
            aBW().pause();
        }
    }

    public void resume() {
        if (aBX() && !isPlaying() && this.mIsForeground && this.dmr != null) {
            this.dmr.resume();
        }
    }

    public void seekTo(int i) {
        if (aBX() && this.dmr != null) {
            this.dmr.seekTo(i);
        }
    }

    public int getDuration() {
        return aBW().getDuration();
    }

    public int getCurrentPosition() {
        return aBW().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.dmr != null && this.dmr.isPlaying();
    }

    public boolean isEnd() {
        return this.dmr != null && this.dmr.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.dmr != null) {
            this.dmr.f(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.dmr != null) {
            this.dmr.i(z, i);
        }
    }

    public void b(b bVar) {
        this.dmv = bVar;
    }

    public j aBW() {
        if (this.dmr == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dmr = com.baidu.swan.apps.t.a.axj().a(this.mContext, this.dmt);
            this.dmr.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.dmv != null) {
                        a.this.dmv.b(jVar);
                    }
                }
            });
            this.dmr.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.dmv != null && a.this.dmv.a(jVar, i, i2);
                }
            });
            this.dmr.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.dmv != null) {
                        a.this.dmv.a(jVar);
                    }
                }
            });
            this.dmr.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.dmv != null) {
                        a.this.dmv.c(jVar);
                    }
                }
            });
            this.dmr.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.dmv != null) {
                        a.this.dmv.d(jVar);
                    }
                }
            });
            this.dmr.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.dmv != null) {
                        a.this.dmv.e(jVar);
                    }
                }
            });
        }
        return this.dmr;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awC() {
        return this.dms;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAE() {
        return this.dmt != null ? this.dmt.dmG : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dmt.cLr;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAF() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dmu) {
                aBW().resume();
            }
            aBW().onForeground();
        } else if (this.dmr != null) {
            this.dmu = aBW().isPlaying();
            aBW().pause();
            aBW().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.dmr != null && this.dmr.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.dmr != null) {
            this.dmr.stop();
            this.dmr = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oy(String str) {
        if (this.dmr != null) {
            this.dmr.oy(str);
        }
    }

    public void b(c cVar) {
        if (this.dmr != null) {
            this.dmr.b(cVar);
        }
    }

    public void ayD() {
        if (this.dmr != null) {
            this.dmr.ayD();
        }
    }

    private boolean aBX() {
        return (this.dmt == null || TextUtils.isEmpty(this.dmt.mSrc) || TextUtils.isEmpty(this.dms) || TextUtils.isEmpty(this.dmt.cLq)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.dmr != null) {
            this.dmr.mute(z);
        }
    }
}
