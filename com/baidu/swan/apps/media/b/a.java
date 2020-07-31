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
    private j cuv;
    private String cuw;
    private c cux;
    private boolean cuy;
    private b cuz;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cux = cVar;
        this.cuw = cVar.cqu;
        alX();
        alW();
    }

    private void alW() {
        if (!TextUtils.isEmpty(this.cuw)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cuv != null) {
            this.cuv.a(cVar, true);
        }
        this.cux = cVar;
    }

    public void a(b bVar) {
        this.cuz = bVar;
    }

    public c Vk() {
        return this.cux;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.i("video", "Open Player " + cVar.cqu);
        if (this.cuv != null) {
            this.cuv.a(cVar);
        }
        this.cux = cVar;
    }

    public void ej(boolean z) {
        if (this.cuv != null) {
            this.cuv.ej(z);
        }
    }

    public void pause() {
        if (alY()) {
            alX().pause();
        }
    }

    public void resume() {
        if (alY() && !isPlaying() && this.mIsForeground && this.cuv != null) {
            this.cuv.resume();
        }
    }

    public void seekTo(int i) {
        if (alY() && this.cuv != null) {
            this.cuv.seekTo(i);
        }
    }

    public int getDuration() {
        return alX().getDuration();
    }

    public int getCurrentPosition() {
        return alX().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cuv != null && this.cuv.isPlaying();
    }

    public boolean isEnd() {
        return this.cuv != null && this.cuv.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cuv != null) {
            this.cuv.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.cuv != null) {
            this.cuv.i(z, i);
        }
    }

    public void b(b bVar) {
        this.cuz = bVar;
    }

    public j alX() {
        if (this.cuv == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cuv = com.baidu.swan.apps.t.a.ahw().a(this.mContext, this.cux);
            this.cuv.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.t.b.j.a
                public void b(j jVar) {
                    if (a.this.cuz != null) {
                        a.this.cuz.b(jVar);
                    }
                }
            });
            this.cuv.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.t.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cuz != null && a.this.cuz.a(jVar, i, i2);
                }
            });
            this.cuv.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.t.b.j.d
                public void a(j jVar) {
                    if (a.this.cuz != null) {
                        a.this.cuz.a(jVar);
                    }
                }
            });
            this.cuv.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.t.b.j.e
                public void c(j jVar) {
                    if (a.this.cuz != null) {
                        a.this.cuz.c(jVar);
                    }
                }
            });
            this.cuv.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.t.b.j.f
                public void d(j jVar) {
                    if (a.this.cuz != null) {
                        a.this.cuz.d(jVar);
                    }
                }
            });
            this.cuv.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.t.b.j.c
                public void e(j jVar) {
                    if (a.this.cuz != null) {
                        a.this.cuz.e(jVar);
                    }
                }
            });
        }
        return this.cuv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String agP() {
        return this.cuw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String akD() {
        return this.cux != null ? this.cux.cuK : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cux.bVm;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object akE() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void er(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cuy) {
                alX().resume();
            }
            alX().Ua();
        } else if (this.cuv != null) {
            this.cuy = alX().isPlaying();
            alX().pause();
            alX().Uc();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void es(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.i("video", "onBackPressed");
        return this.cuv != null && this.cuv.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.i("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cuv != null) {
            this.cuv.stop();
            this.cuv = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ll(String str) {
        if (this.cuv != null) {
            this.cuv.ll(str);
        }
    }

    public void b(c cVar) {
        if (this.cuv != null) {
            this.cuv.b(cVar);
        }
    }

    public void aiK() {
        if (this.cuv != null) {
            this.cuv.aiK();
        }
    }

    private boolean alY() {
        return (this.cux == null || TextUtils.isEmpty(this.cux.mSrc) || TextUtils.isEmpty(this.cuw) || TextUtils.isEmpty(this.cux.bVl)) ? false : true;
    }

    public void ei(boolean z) {
        if (this.cuv != null) {
            this.cuv.ei(z);
        }
    }
}
