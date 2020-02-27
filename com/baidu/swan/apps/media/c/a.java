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
    private l bEa;
    private String bEb;
    private c bEc;
    private boolean bEd;
    private b bEe;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEc = cVar;
        this.bEb = cVar.bAy;
        Yd();
        Yc();
    }

    private void Yc() {
        if (!TextUtils.isEmpty(this.bEb)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bEa != null) {
            this.bEa.a(cVar, true);
        }
        this.bEc = cVar;
    }

    public void a(b bVar) {
        this.bEe = bVar;
    }

    public c Je() {
        return this.bEc;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAy);
        if (this.bEa != null) {
            this.bEa.a(cVar);
        }
        this.bEc = cVar;
    }

    public void cK(boolean z) {
        if (this.bEa != null) {
            this.bEa.cK(z);
        }
    }

    public void pause() {
        if (Ye()) {
            Yd().pause();
        }
    }

    public void resume() {
        if (Ye() && !isPlaying() && this.mIsForeground && this.bEa != null) {
            this.bEa.resume();
        }
    }

    public void seekTo(int i) {
        if (Ye() && this.bEa != null) {
            this.bEa.seekTo(i);
        }
    }

    public int getDuration() {
        return Yd().getDuration();
    }

    public int getCurrentPosition() {
        return Yd().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bEa != null && this.bEa.isPlaying();
    }

    public boolean isEnd() {
        return this.bEa != null && this.bEa.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bEa != null) {
            this.bEa.b(frameLayout);
        }
    }

    public void f(boolean z, int i) {
        if (this.bEa != null) {
            this.bEa.f(z, i);
        }
    }

    public void b(b bVar) {
        this.bEe = bVar;
    }

    public l Yd() {
        if (this.bEa == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bEa = com.baidu.swan.apps.w.a.Uh().a(this.mContext, this.bEc);
            this.bEa.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bEe != null) {
                        a.this.bEe.b(lVar);
                    }
                }
            });
            this.bEa.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bEe != null && a.this.bEe.a(lVar, i, i2);
                }
            });
            this.bEa.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bEe != null) {
                        a.this.bEe.a(lVar);
                    }
                }
            });
            this.bEa.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bEa.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bEa.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bEa;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WY() {
        return this.bEb;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WZ() {
        return this.bEc != null ? this.bEc.bEq : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEc.bil;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEd) {
                Yd().resume();
            }
            Yd().HN();
        } else if (this.bEa != null) {
            this.bEd = Yd().isPlaying();
            Yd().pause();
            Yd().HP();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.bEa != null && this.bEa.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bEa != null) {
            this.bEa.stop();
            this.bEa = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ij(String str) {
        if (this.bEa != null) {
            this.bEa.ij(str);
        }
    }

    public void b(c cVar) {
        if (this.bEa != null) {
            this.bEa.b(cVar);
        }
    }

    public void Vj() {
        if (this.bEa != null) {
            this.bEa.Vj();
        }
    }

    private boolean Ye() {
        return (this.bEc == null || TextUtils.isEmpty(this.bEc.mSrc) || TextUtils.isEmpty(this.bEb) || TextUtils.isEmpty(this.bEc.bik)) ? false : true;
    }

    public void cJ(boolean z) {
        if (this.bEa != null) {
            this.bEa.cJ(z);
        }
    }
}
