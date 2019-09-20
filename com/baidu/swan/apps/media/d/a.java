package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.v;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aDA;
    private b aDB;
    private v aDx;
    private String aDy;
    private c aDz = new c();
    private boolean asA = true;
    private Context mContext;

    public a(Context context, String str) {
        this.mContext = context;
        this.aDy = str;
        Hs();
        Hq();
    }

    private void Hq() {
        if (!TextUtils.isEmpty(this.aDy)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.aDx != null) {
            this.aDx.a(cVar, true);
        }
        this.aDz = cVar;
    }

    public void a(b bVar) {
        this.aDB = bVar;
    }

    public c Hr() {
        return this.aDz;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aBA);
        if (this.aDx != null) {
            this.aDx.a(cVar);
        }
        this.aDz = cVar;
    }

    public void bs(boolean z) {
        if (this.aDx != null) {
            this.aDx.bs(z);
        }
    }

    public void pause() {
        if (Ht()) {
            Hs().pause();
        }
    }

    public void resume() {
        if (Ht() && !isPlaying() && this.asA && this.aDx != null) {
            this.aDx.resume();
        }
    }

    public void seekTo(int i) {
        if (Ht() && this.aDx != null) {
            this.aDx.seekTo(i);
        }
    }

    public int getDuration() {
        return Hs().getDuration();
    }

    public int getCurrentPosition() {
        return Hs().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.aDx != null && this.aDx.isPlaying();
    }

    public boolean isEnd() {
        return this.aDx != null && this.aDx.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.aDx != null) {
            this.aDx.b(frameLayout);
        }
    }

    public void setFullScreen(boolean z) {
        if (this.aDx != null) {
            this.aDx.setFullScreen(z);
        }
    }

    public v Hs() {
        if (this.aDx == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.aDx = com.baidu.swan.apps.u.a.EB().bg(this.mContext);
            this.aDx.a(new v.a() { // from class: com.baidu.swan.apps.media.d.a.1
                @Override // com.baidu.swan.apps.u.b.v.a
                public void a(v vVar) {
                    if (a.this.aDB != null) {
                        a.this.aDB.a(vVar);
                    }
                }
            });
            this.aDx.a(new v.b() { // from class: com.baidu.swan.apps.media.d.a.2
                @Override // com.baidu.swan.apps.u.b.v.b
                public boolean a(v vVar, int i, int i2) {
                    return a.this.aDB != null && a.this.aDB.a(vVar, i, i2);
                }
            });
            this.aDx.a(new v.c() { // from class: com.baidu.swan.apps.media.d.a.3
                @Override // com.baidu.swan.apps.u.b.v.c
                public void b(v vVar) {
                    if (a.this.aDB != null) {
                        a.this.aDB.b(vVar);
                    }
                }
            });
        }
        return this.aDx;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GQ() {
        return this.aDy;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GR() {
        return this.aDz != null ? this.aDz.aDN : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aDz.aEs;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GS() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        this.asA = z;
        if (z) {
            if (this.aDA) {
                Hs().resume();
            }
        } else if (this.aDx != null) {
            this.aDA = Hs().isPlaying();
            Hs().pause();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.aDx != null && this.aDx.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", "onDestroy");
        if (this.aDx != null) {
            this.aDx.stop();
            this.aDx = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void eI(String str) {
        if (this.aDx != null) {
            this.aDx.eI(str);
        }
    }

    public void b(c cVar) {
        if (this.aDx != null) {
            this.aDx.b(cVar);
        }
    }

    public void Fp() {
        if (this.aDx != null) {
            this.aDx.Fp();
        }
    }

    private boolean Ht() {
        return (this.aDz == null || TextUtils.isEmpty(this.aDz.mSrc) || TextUtils.isEmpty(this.aDy) || TextUtils.isEmpty(this.aDz.id)) ? false : true;
    }

    public void br(boolean z) {
        if (this.aDx != null) {
            this.aDx.br(z);
        }
    }
}
