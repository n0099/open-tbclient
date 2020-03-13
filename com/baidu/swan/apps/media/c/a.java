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
    private l bEc;
    private String bEd;
    private c bEe;
    private boolean bEf;
    private b bEg;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEe = cVar;
        this.bEd = cVar.bAA;
        Yf();
        Ye();
    }

    private void Ye() {
        if (!TextUtils.isEmpty(this.bEd)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bEc != null) {
            this.bEc.a(cVar, true);
        }
        this.bEe = cVar;
    }

    public void a(b bVar) {
        this.bEg = bVar;
    }

    public c Jg() {
        return this.bEe;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAA);
        if (this.bEc != null) {
            this.bEc.a(cVar);
        }
        this.bEe = cVar;
    }

    public void cK(boolean z) {
        if (this.bEc != null) {
            this.bEc.cK(z);
        }
    }

    public void pause() {
        if (Yg()) {
            Yf().pause();
        }
    }

    public void resume() {
        if (Yg() && !isPlaying() && this.mIsForeground && this.bEc != null) {
            this.bEc.resume();
        }
    }

    public void seekTo(int i) {
        if (Yg() && this.bEc != null) {
            this.bEc.seekTo(i);
        }
    }

    public int getDuration() {
        return Yf().getDuration();
    }

    public int getCurrentPosition() {
        return Yf().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bEc != null && this.bEc.isPlaying();
    }

    public boolean isEnd() {
        return this.bEc != null && this.bEc.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bEc != null) {
            this.bEc.b(frameLayout);
        }
    }

    public void f(boolean z, int i) {
        if (this.bEc != null) {
            this.bEc.f(z, i);
        }
    }

    public void b(b bVar) {
        this.bEg = bVar;
    }

    public l Yf() {
        if (this.bEc == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bEc = com.baidu.swan.apps.w.a.Uj().a(this.mContext, this.bEe);
            this.bEc.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bEg != null) {
                        a.this.bEg.b(lVar);
                    }
                }
            });
            this.bEc.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bEg != null && a.this.bEg.a(lVar, i, i2);
                }
            });
            this.bEc.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bEg != null) {
                        a.this.bEg.a(lVar);
                    }
                }
            });
            this.bEc.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bEc.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bEc.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bEc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bEd;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return this.bEe != null ? this.bEe.bEs : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEe.bin;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEf) {
                Yf().resume();
            }
            Yf().HP();
        } else if (this.bEc != null) {
            this.bEf = Yf().isPlaying();
            Yf().pause();
            Yf().HR();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.bEc != null && this.bEc.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bEc != null) {
            this.bEc.stop();
            this.bEc = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ij(String str) {
        if (this.bEc != null) {
            this.bEc.ij(str);
        }
    }

    public void b(c cVar) {
        if (this.bEc != null) {
            this.bEc.b(cVar);
        }
    }

    public void Vl() {
        if (this.bEc != null) {
            this.bEc.Vl();
        }
    }

    private boolean Yg() {
        return (this.bEe == null || TextUtils.isEmpty(this.bEe.mSrc) || TextUtils.isEmpty(this.bEd) || TextUtils.isEmpty(this.bEe.bim)) ? false : true;
    }

    public void cJ(boolean z) {
        if (this.bEc != null) {
            this.bEc.cJ(z);
        }
    }
}
