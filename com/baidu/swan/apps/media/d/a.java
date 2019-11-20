package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.v;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private v aWu;
    private String aWv;
    private boolean aWx;
    private b aWy;
    private Context mContext;
    private c aWw = new c();
    private boolean aLy = true;

    public a(Context context, String str) {
        this.mContext = context;
        this.aWv = str;
        Mn();
        Ml();
    }

    private void Ml() {
        if (!TextUtils.isEmpty(this.aWv)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.aWu != null) {
            this.aWu.a(cVar, true);
        }
        this.aWw = cVar;
    }

    public void a(b bVar) {
        this.aWy = bVar;
    }

    public c Mm() {
        return this.aWw;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aUw);
        if (this.aWu != null) {
            this.aWu.a(cVar);
        }
        this.aWw = cVar;
    }

    public void bK(boolean z) {
        if (this.aWu != null) {
            this.aWu.bK(z);
        }
    }

    public void pause() {
        if (Mo()) {
            Mn().pause();
        }
    }

    public void resume() {
        if (Mo() && !isPlaying() && this.aLy && this.aWu != null) {
            this.aWu.resume();
        }
    }

    public void seekTo(int i) {
        if (Mo() && this.aWu != null) {
            this.aWu.seekTo(i);
        }
    }

    public int getDuration() {
        return Mn().getDuration();
    }

    public int getCurrentPosition() {
        return Mn().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.aWu != null && this.aWu.isPlaying();
    }

    public boolean isEnd() {
        return this.aWu != null && this.aWu.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.aWu != null) {
            this.aWu.b(frameLayout);
        }
    }

    public void setFullScreen(boolean z) {
        if (this.aWu != null) {
            this.aWu.setFullScreen(z);
        }
    }

    public v Mn() {
        if (this.aWu == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.aWu = com.baidu.swan.apps.u.a.Jw().bi(this.mContext);
            this.aWu.a(new v.a() { // from class: com.baidu.swan.apps.media.d.a.1
                @Override // com.baidu.swan.apps.u.b.v.a
                public void a(v vVar) {
                    if (a.this.aWy != null) {
                        a.this.aWy.a(vVar);
                    }
                }
            });
            this.aWu.a(new v.b() { // from class: com.baidu.swan.apps.media.d.a.2
                @Override // com.baidu.swan.apps.u.b.v.b
                public boolean a(v vVar, int i, int i2) {
                    return a.this.aWy != null && a.this.aWy.a(vVar, i, i2);
                }
            });
            this.aWu.a(new v.c() { // from class: com.baidu.swan.apps.media.d.a.3
                @Override // com.baidu.swan.apps.u.b.v.c
                public void b(v vVar) {
                    if (a.this.aWy != null) {
                        a.this.aWy.b(vVar);
                    }
                }
            });
        }
        return this.aWu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.aWv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LM() {
        return this.aWw != null ? this.aWw.aWK : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aWw.aXp;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LN() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        this.aLy = z;
        if (z) {
            if (this.aWx) {
                Mn().resume();
            }
        } else if (this.aWu != null) {
            this.aWx = Mn().isPlaying();
            Mn().pause();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.aWu != null && this.aWu.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", "onDestroy");
        if (this.aWu != null) {
            this.aWu.stop();
            this.aWu = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void fp(String str) {
        if (this.aWu != null) {
            this.aWu.fp(str);
        }
    }

    public void b(c cVar) {
        if (this.aWu != null) {
            this.aWu.b(cVar);
        }
    }

    public void Kk() {
        if (this.aWu != null) {
            this.aWu.Kk();
        }
    }

    private boolean Mo() {
        return (this.aWw == null || TextUtils.isEmpty(this.aWw.mSrc) || TextUtils.isEmpty(this.aWv) || TextUtils.isEmpty(this.aWw.id)) ? false : true;
    }

    public void bJ(boolean z) {
        if (this.aWu != null) {
            this.aWu.bJ(z);
        }
    }
}
