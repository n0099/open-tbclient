package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.t.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j dcX;
    private String dcY;
    private c dcZ;
    private boolean dda;
    private b ddb;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dcZ = cVar;
        this.dcY = cVar.cZa;
        aAQ();
        aAP();
    }

    private void aAP() {
        if (!TextUtils.isEmpty(this.dcY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.dcX != null) {
            this.dcX.a(cVar, true);
        }
        this.dcZ = cVar;
    }

    public void a(b bVar) {
        this.ddb = bVar;
    }

    public c aix() {
        return this.dcZ;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cZa);
        if (this.dcX != null) {
            this.dcX.a(cVar);
        }
        this.dcZ = cVar;
    }

    public void fv(boolean z) {
        if (this.dcX != null) {
            this.dcX.fv(z);
        }
    }

    public void pause() {
        if (aAR()) {
            aAQ().pause();
        }
    }

    public void resume() {
        if (aAR() && !isPlaying() && this.mIsForeground && this.dcX != null) {
            this.dcX.resume();
        }
    }

    public void seekTo(int i) {
        if (aAR() && this.dcX != null) {
            this.dcX.seekTo(i);
        }
    }

    public int getDuration() {
        return aAQ().getDuration();
    }

    public int getCurrentPosition() {
        return aAQ().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.dcX != null && this.dcX.isPlaying();
    }

    public boolean isEnd() {
        return this.dcX != null && this.dcX.isEnd();
    }

    public void f(FrameLayout frameLayout) {
        if (this.dcX != null) {
            this.dcX.f(frameLayout);
        }
    }

    public void j(boolean z, int i) {
        if (this.dcX != null) {
            this.dcX.j(z, i);
        }
    }

    public void b(b bVar) {
        this.ddb = bVar;
    }

    public j aAQ() {
        if (this.dcX == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dcX = com.baidu.swan.apps.t.a.awf().a(this.mContext, this.dcZ);
            this.dcX.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.ddb != null) {
                        a.this.ddb.b(jVar);
                    }
                }
            });
            this.dcX.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.ddb != null && a.this.ddb.a(jVar, i, i2);
                }
            });
            this.dcX.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.ddb != null) {
                        a.this.ddb.a(jVar);
                    }
                }
            });
            this.dcX.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.ddb != null) {
                        a.this.ddb.c(jVar);
                    }
                }
            });
            this.dcX.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.ddb != null) {
                        a.this.ddb.d(jVar);
                    }
                }
            });
            this.dcX.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.ddb != null) {
                        a.this.ddb.e(jVar);
                    }
                }
            });
        }
        return this.dcX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avy() {
        return this.dcY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azz() {
        return this.dcZ != null ? this.dcZ.ddm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dcZ.cCb;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object azA() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fB(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.dda) {
                aAQ().resume();
            }
            aAQ().onForeground();
        } else if (this.dcX != null) {
            this.dda = aAQ().isPlaying();
            aAQ().pause();
            aAQ().onBackground();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fC(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.dcX != null && this.dcX.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.dcX != null) {
            this.dcX.stop();
            this.dcX = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void oR(String str) {
        if (this.dcX != null) {
            this.dcX.oR(str);
        }
    }

    public void b(c cVar) {
        if (this.dcX != null) {
            this.dcX.b(cVar);
        }
    }

    public void axy() {
        if (this.dcX != null) {
            this.dcX.axy();
        }
    }

    private boolean aAR() {
        return (this.dcZ == null || TextUtils.isEmpty(this.dcZ.mSrc) || TextUtils.isEmpty(this.dcY) || TextUtils.isEmpty(this.dcZ.cCa)) ? false : true;
    }

    public void mute(boolean z) {
        if (this.dcX != null) {
            this.dcX.mute(z);
        }
    }
}
