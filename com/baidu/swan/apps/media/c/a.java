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
    private l bEn;
    private String bEo;
    private c bEp;
    private boolean bEq;
    private b bEr;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEp = cVar;
        this.bEo = cVar.bAL;
        Yi();
        Yh();
    }

    private void Yh() {
        if (!TextUtils.isEmpty(this.bEo)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bEn != null) {
            this.bEn.a(cVar, true);
        }
        this.bEp = cVar;
    }

    public void a(b bVar) {
        this.bEr = bVar;
    }

    public c Jj() {
        return this.bEp;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAL);
        if (this.bEn != null) {
            this.bEn.a(cVar);
        }
        this.bEp = cVar;
    }

    public void cL(boolean z) {
        if (this.bEn != null) {
            this.bEn.cL(z);
        }
    }

    public void pause() {
        if (Yj()) {
            Yi().pause();
        }
    }

    public void resume() {
        if (Yj() && !isPlaying() && this.mIsForeground && this.bEn != null) {
            this.bEn.resume();
        }
    }

    public void seekTo(int i) {
        if (Yj() && this.bEn != null) {
            this.bEn.seekTo(i);
        }
    }

    public int getDuration() {
        return Yi().getDuration();
    }

    public int getCurrentPosition() {
        return Yi().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bEn != null && this.bEn.isPlaying();
    }

    public boolean isEnd() {
        return this.bEn != null && this.bEn.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bEn != null) {
            this.bEn.b(frameLayout);
        }
    }

    public void f(boolean z, int i) {
        if (this.bEn != null) {
            this.bEn.f(z, i);
        }
    }

    public void b(b bVar) {
        this.bEr = bVar;
    }

    public l Yi() {
        if (this.bEn == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bEn = com.baidu.swan.apps.w.a.Um().a(this.mContext, this.bEp);
            this.bEn.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bEr != null) {
                        a.this.bEr.b(lVar);
                    }
                }
            });
            this.bEn.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bEr != null && a.this.bEr.a(lVar, i, i2);
                }
            });
            this.bEn.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bEr != null) {
                        a.this.bEr.a(lVar);
                    }
                }
            });
            this.bEn.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bEn.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bEn.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bEn;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xd() {
        return this.bEo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xe() {
        return this.bEp != null ? this.bEp.bED : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEp.biB;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xf() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEq) {
                Yi().resume();
            }
            Yi().HS();
        } else if (this.bEn != null) {
            this.bEq = Yi().isPlaying();
            Yi().pause();
            Yi().HU();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cS(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.bEn != null && this.bEn.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bEn != null) {
            this.bEn.stop();
            this.bEn = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ii(String str) {
        if (this.bEn != null) {
            this.bEn.ii(str);
        }
    }

    public void b(c cVar) {
        if (this.bEn != null) {
            this.bEn.b(cVar);
        }
    }

    public void Vo() {
        if (this.bEn != null) {
            this.bEn.Vo();
        }
    }

    private boolean Yj() {
        return (this.bEp == null || TextUtils.isEmpty(this.bEp.mSrc) || TextUtils.isEmpty(this.bEo) || TextUtils.isEmpty(this.bEp.biA)) ? false : true;
    }

    public void cK(boolean z) {
        if (this.bEn != null) {
            this.bEn.cK(z);
        }
    }
}
