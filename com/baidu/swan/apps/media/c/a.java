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
    private l bEb;
    private String bEc;
    private c bEd;
    private boolean bEe;
    private b bEf;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEd = cVar;
        this.bEc = cVar.bAz;
        Yf();
        Ye();
    }

    private void Ye() {
        if (!TextUtils.isEmpty(this.bEc)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bEb != null) {
            this.bEb.a(cVar, true);
        }
        this.bEd = cVar;
    }

    public void a(b bVar) {
        this.bEf = bVar;
    }

    public c Jg() {
        return this.bEd;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAz);
        if (this.bEb != null) {
            this.bEb.a(cVar);
        }
        this.bEd = cVar;
    }

    public void cK(boolean z) {
        if (this.bEb != null) {
            this.bEb.cK(z);
        }
    }

    public void pause() {
        if (Yg()) {
            Yf().pause();
        }
    }

    public void resume() {
        if (Yg() && !isPlaying() && this.mIsForeground && this.bEb != null) {
            this.bEb.resume();
        }
    }

    public void seekTo(int i) {
        if (Yg() && this.bEb != null) {
            this.bEb.seekTo(i);
        }
    }

    public int getDuration() {
        return Yf().getDuration();
    }

    public int getCurrentPosition() {
        return Yf().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bEb != null && this.bEb.isPlaying();
    }

    public boolean isEnd() {
        return this.bEb != null && this.bEb.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bEb != null) {
            this.bEb.b(frameLayout);
        }
    }

    public void f(boolean z, int i) {
        if (this.bEb != null) {
            this.bEb.f(z, i);
        }
    }

    public void b(b bVar) {
        this.bEf = bVar;
    }

    public l Yf() {
        if (this.bEb == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bEb = com.baidu.swan.apps.w.a.Uj().a(this.mContext, this.bEd);
            this.bEb.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bEf != null) {
                        a.this.bEf.b(lVar);
                    }
                }
            });
            this.bEb.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bEf != null && a.this.bEf.a(lVar, i, i2);
                }
            });
            this.bEb.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bEf != null) {
                        a.this.bEf.a(lVar);
                    }
                }
            });
            this.bEb.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bEb.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bEb.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bEb;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bEc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return this.bEd != null ? this.bEd.bEr : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bEd.bim;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bEe) {
                Yf().resume();
            }
            Yf().HP();
        } else if (this.bEb != null) {
            this.bEe = Yf().isPlaying();
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
        return this.bEb != null && this.bEb.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bEb != null) {
            this.bEb.stop();
            this.bEb = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void ij(String str) {
        if (this.bEb != null) {
            this.bEb.ij(str);
        }
    }

    public void b(c cVar) {
        if (this.bEb != null) {
            this.bEb.b(cVar);
        }
    }

    public void Vl() {
        if (this.bEb != null) {
            this.bEb.Vl();
        }
    }

    private boolean Yg() {
        return (this.bEd == null || TextUtils.isEmpty(this.bEd.mSrc) || TextUtils.isEmpty(this.bEc) || TextUtils.isEmpty(this.bEd.bil)) ? false : true;
    }

    public void cJ(boolean z) {
        if (this.bEb != null) {
            this.bEb.cJ(z);
        }
    }
}
