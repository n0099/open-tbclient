package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.w.b.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private l ccW;
    private String ccX;
    private c ccY;
    private boolean ccZ;
    private b cda;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.ccY = cVar;
        this.ccX = cVar.bYS;
        ago();
        agn();
    }

    private void agn() {
        if (!TextUtils.isEmpty(this.ccX)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.ccW != null) {
            this.ccW.a(cVar, true);
        }
        this.ccY = cVar;
    }

    public void a(b bVar) {
        this.cda = bVar;
    }

    public c QV() {
        return this.ccY;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bYS);
        if (this.ccW != null) {
            this.ccW.a(cVar);
        }
        this.ccY = cVar;
    }

    public void dH(boolean z) {
        if (this.ccW != null) {
            this.ccW.dH(z);
        }
    }

    public void pause() {
        if (agp()) {
            ago().pause();
        }
    }

    public void resume() {
        if (agp() && !isPlaying() && this.mIsForeground && this.ccW != null) {
            this.ccW.resume();
        }
    }

    public void seekTo(int i) {
        if (agp() && this.ccW != null) {
            this.ccW.seekTo(i);
        }
    }

    public int getDuration() {
        return ago().getDuration();
    }

    public int getCurrentPosition() {
        return ago().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.ccW != null && this.ccW.isPlaying();
    }

    public boolean isEnd() {
        return this.ccW != null && this.ccW.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.ccW != null) {
            this.ccW.b(frameLayout);
        }
    }

    public void g(boolean z, int i) {
        if (this.ccW != null) {
            this.ccW.g(z, i);
        }
    }

    public void b(b bVar) {
        this.cda = bVar;
    }

    public l ago() {
        if (this.ccW == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.ccW = com.baidu.swan.apps.w.a.acb().a(this.mContext, this.ccY);
            this.ccW.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.cda != null) {
                        a.this.cda.b(lVar);
                    }
                }
            });
            this.ccW.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.cda != null && a.this.cda.a(lVar, i, i2);
                }
            });
            this.ccW.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.cda != null) {
                        a.this.cda.a(lVar);
                    }
                }
            });
            this.ccW.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.ccW.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.ccW.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.ccW;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.ccX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeU() {
        return this.ccY != null ? this.ccY.cdm : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ccY.bGJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeV() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.ccZ) {
                ago().resume();
            }
            ago().PE();
        } else if (this.ccW != null) {
            this.ccZ = ago().isPlaying();
            ago().pause();
            ago().PG();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.ccW != null && this.ccW.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.ccW != null) {
            this.ccW.stop();
            this.ccW = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void jv(String str) {
        if (this.ccW != null) {
            this.ccW.jv(str);
        }
    }

    public void b(c cVar) {
        if (this.ccW != null) {
            this.ccW.b(cVar);
        }
    }

    public void add() {
        if (this.ccW != null) {
            this.ccW.add();
        }
    }

    private boolean agp() {
        return (this.ccY == null || TextUtils.isEmpty(this.ccY.mSrc) || TextUtils.isEmpty(this.ccX) || TextUtils.isEmpty(this.ccY.bGI)) ? false : true;
    }

    public void dG(boolean z) {
        if (this.ccW != null) {
            this.ccW.dG(z);
        }
    }
}
