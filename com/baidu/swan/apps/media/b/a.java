package com.baidu.swan.apps.media.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.j;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j cnE;
    private String cnF;
    private c cnG;
    private boolean cnH;
    private b cnI;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cnG = cVar;
        this.cnF = cVar.cjA;
        ajB();
        ajA();
    }

    private void ajA() {
        if (!TextUtils.isEmpty(this.cnF)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cnE != null) {
            this.cnE.a(cVar, true);
        }
        this.cnG = cVar;
    }

    public void a(b bVar) {
        this.cnI = bVar;
    }

    public c Tz() {
        return this.cnG;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cjA);
        if (this.cnE != null) {
            this.cnE.a(cVar);
        }
        this.cnG = cVar;
    }

    public void dX(boolean z) {
        if (this.cnE != null) {
            this.cnE.dX(z);
        }
    }

    public void pause() {
        if (ajC()) {
            ajB().pause();
        }
    }

    public void resume() {
        if (ajC() && !isPlaying() && this.mIsForeground && this.cnE != null) {
            this.cnE.resume();
        }
    }

    public void seekTo(int i) {
        if (ajC() && this.cnE != null) {
            this.cnE.seekTo(i);
        }
    }

    public int getDuration() {
        return ajB().getDuration();
    }

    public int getCurrentPosition() {
        return ajB().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cnE != null && this.cnE.isPlaying();
    }

    public boolean isEnd() {
        return this.cnE != null && this.cnE.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cnE != null) {
            this.cnE.b(frameLayout);
        }
    }

    public void i(boolean z, int i) {
        if (this.cnE != null) {
            this.cnE.i(z, i);
        }
    }

    public void b(b bVar) {
        this.cnI = bVar;
    }

    public j ajB() {
        if (this.cnE == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cnE = com.baidu.swan.apps.u.a.afe().a(this.mContext, this.cnG);
            this.cnE.a(new j.a() { // from class: com.baidu.swan.apps.media.b.a.1
                @Override // com.baidu.swan.apps.u.b.j.a
                public void b(j jVar) {
                    if (a.this.cnI != null) {
                        a.this.cnI.b(jVar);
                    }
                }
            });
            this.cnE.a(new j.b() { // from class: com.baidu.swan.apps.media.b.a.2
                @Override // com.baidu.swan.apps.u.b.j.b
                public boolean a(j jVar, int i, int i2) {
                    return a.this.cnI != null && a.this.cnI.a(jVar, i, i2);
                }
            });
            this.cnE.a(new j.d() { // from class: com.baidu.swan.apps.media.b.a.3
                @Override // com.baidu.swan.apps.u.b.j.d
                public void a(j jVar) {
                    if (a.this.cnI != null) {
                        a.this.cnI.a(jVar);
                    }
                }
            });
            this.cnE.a(new j.e() { // from class: com.baidu.swan.apps.media.b.a.4
                @Override // com.baidu.swan.apps.u.b.j.e
                public void c(j jVar) {
                    if (a.this.cnI != null) {
                        a.this.cnI.c(jVar);
                    }
                }
            });
            this.cnE.a(new j.f() { // from class: com.baidu.swan.apps.media.b.a.5
                @Override // com.baidu.swan.apps.u.b.j.f
                public void d(j jVar) {
                    if (a.this.cnI != null) {
                        a.this.cnI.d(jVar);
                    }
                }
            });
            this.cnE.a(new j.c() { // from class: com.baidu.swan.apps.media.b.a.6
                @Override // com.baidu.swan.apps.u.b.j.c
                public void e(j jVar) {
                    if (a.this.cnI != null) {
                        a.this.cnI.e(jVar);
                    }
                }
            });
        }
        return this.cnE;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aey() {
        return this.cnF;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aih() {
        return this.cnG != null ? this.cnG.cnT : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cnG.bPG;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aii() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ee(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cnH) {
                ajB().resume();
            }
            ajB().Su();
        } else if (this.cnE != null) {
            this.cnH = ajB().isPlaying();
            ajB().pause();
            ajB().Sw();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ef(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.cnE != null && this.cnE.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cnE != null) {
            this.cnE.stop();
            this.cnE = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void kG(String str) {
        if (this.cnE != null) {
            this.cnE.kG(str);
        }
    }

    public void b(c cVar) {
        if (this.cnE != null) {
            this.cnE.b(cVar);
        }
    }

    public void agm() {
        if (this.cnE != null) {
            this.cnE.agm();
        }
    }

    private boolean ajC() {
        return (this.cnG == null || TextUtils.isEmpty(this.cnG.mSrc) || TextUtils.isEmpty(this.cnF) || TextUtils.isEmpty(this.cnG.bPF)) ? false : true;
    }

    public void dW(boolean z) {
        if (this.cnE != null) {
            this.cnE.dW(z);
        }
    }
}
