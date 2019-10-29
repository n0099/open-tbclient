package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.v;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private v aWM;
    private String aWN;
    private boolean aWP;
    private b aWQ;
    private Context mContext;
    private c aWO = new c();
    private boolean aLQ = true;

    public a(Context context, String str) {
        this.mContext = context;
        this.aWN = str;
        Mm();
        Mk();
    }

    private void Mk() {
        if (!TextUtils.isEmpty(this.aWN)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.aWM != null) {
            this.aWM.a(cVar, true);
        }
        this.aWO = cVar;
    }

    public void a(b bVar) {
        this.aWQ = bVar;
    }

    public c Ml() {
        return this.aWO;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aUO);
        if (this.aWM != null) {
            this.aWM.a(cVar);
        }
        this.aWO = cVar;
    }

    public void bK(boolean z) {
        if (this.aWM != null) {
            this.aWM.bK(z);
        }
    }

    public void pause() {
        if (Mn()) {
            Mm().pause();
        }
    }

    public void resume() {
        if (Mn() && !isPlaying() && this.aLQ && this.aWM != null) {
            this.aWM.resume();
        }
    }

    public void seekTo(int i) {
        if (Mn() && this.aWM != null) {
            this.aWM.seekTo(i);
        }
    }

    public int getDuration() {
        return Mm().getDuration();
    }

    public int getCurrentPosition() {
        return Mm().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.aWM != null && this.aWM.isPlaying();
    }

    public boolean isEnd() {
        return this.aWM != null && this.aWM.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.aWM != null) {
            this.aWM.b(frameLayout);
        }
    }

    public void setFullScreen(boolean z) {
        if (this.aWM != null) {
            this.aWM.setFullScreen(z);
        }
    }

    public v Mm() {
        if (this.aWM == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.aWM = com.baidu.swan.apps.u.a.Jv().bi(this.mContext);
            this.aWM.a(new v.a() { // from class: com.baidu.swan.apps.media.d.a.1
                @Override // com.baidu.swan.apps.u.b.v.a
                public void a(v vVar) {
                    if (a.this.aWQ != null) {
                        a.this.aWQ.a(vVar);
                    }
                }
            });
            this.aWM.a(new v.b() { // from class: com.baidu.swan.apps.media.d.a.2
                @Override // com.baidu.swan.apps.u.b.v.b
                public boolean a(v vVar, int i, int i2) {
                    return a.this.aWQ != null && a.this.aWQ.a(vVar, i, i2);
                }
            });
            this.aWM.a(new v.c() { // from class: com.baidu.swan.apps.media.d.a.3
                @Override // com.baidu.swan.apps.u.b.v.c
                public void b(v vVar) {
                    if (a.this.aWQ != null) {
                        a.this.aWQ.b(vVar);
                    }
                }
            });
        }
        return this.aWM;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LK() {
        return this.aWN;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.aWO != null ? this.aWO.aXc : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aWO.aXH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        this.aLQ = z;
        if (z) {
            if (this.aWP) {
                Mm().resume();
            }
        } else if (this.aWM != null) {
            this.aWP = Mm().isPlaying();
            Mm().pause();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.aWM != null && this.aWM.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", "onDestroy");
        if (this.aWM != null) {
            this.aWM.stop();
            this.aWM = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void fp(String str) {
        if (this.aWM != null) {
            this.aWM.fp(str);
        }
    }

    public void b(c cVar) {
        if (this.aWM != null) {
            this.aWM.b(cVar);
        }
    }

    public void Kj() {
        if (this.aWM != null) {
            this.aWM.Kj();
        }
    }

    private boolean Mn() {
        return (this.aWO == null || TextUtils.isEmpty(this.aWO.mSrc) || TextUtils.isEmpty(this.aWN) || TextUtils.isEmpty(this.aWO.id)) ? false : true;
    }

    public void bJ(boolean z) {
        if (this.aWM != null) {
            this.aWM.bJ(z);
        }
    }
}
