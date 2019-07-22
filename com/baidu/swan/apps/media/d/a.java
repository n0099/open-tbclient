package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.v;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private v aCZ;
    private String aDa;
    private boolean aDc;
    private b aDd;
    private Context mContext;
    private c aDb = new c();
    private boolean asc = true;

    public a(Context context, String str) {
        this.mContext = context;
        this.aDa = str;
        Ho();
        Hm();
    }

    private void Hm() {
        if (!TextUtils.isEmpty(this.aDa)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.aCZ != null) {
            this.aCZ.a(cVar, true);
        }
        this.aDb = cVar;
    }

    public void a(b bVar) {
        this.aDd = bVar;
    }

    public c Hn() {
        return this.aDb;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aBc);
        if (this.aCZ != null) {
            this.aCZ.a(cVar);
        }
        this.aDb = cVar;
    }

    public void bs(boolean z) {
        if (this.aCZ != null) {
            this.aCZ.bs(z);
        }
    }

    public void pause() {
        if (Hp()) {
            Ho().pause();
        }
    }

    public void resume() {
        if (Hp() && !isPlaying() && this.asc && this.aCZ != null) {
            this.aCZ.resume();
        }
    }

    public void seekTo(int i) {
        if (Hp() && this.aCZ != null) {
            this.aCZ.seekTo(i);
        }
    }

    public int getDuration() {
        return Ho().getDuration();
    }

    public int getCurrentPosition() {
        return Ho().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.aCZ != null && this.aCZ.isPlaying();
    }

    public boolean isEnd() {
        return this.aCZ != null && this.aCZ.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.aCZ != null) {
            this.aCZ.b(frameLayout);
        }
    }

    public void setFullScreen(boolean z) {
        if (this.aCZ != null) {
            this.aCZ.setFullScreen(z);
        }
    }

    public v Ho() {
        if (this.aCZ == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.aCZ = com.baidu.swan.apps.u.a.Ex().bg(this.mContext);
            this.aCZ.a(new v.a() { // from class: com.baidu.swan.apps.media.d.a.1
                @Override // com.baidu.swan.apps.u.b.v.a
                public void a(v vVar) {
                    if (a.this.aDd != null) {
                        a.this.aDd.a(vVar);
                    }
                }
            });
            this.aCZ.a(new v.b() { // from class: com.baidu.swan.apps.media.d.a.2
                @Override // com.baidu.swan.apps.u.b.v.b
                public boolean a(v vVar, int i, int i2) {
                    return a.this.aDd != null && a.this.aDd.a(vVar, i, i2);
                }
            });
            this.aCZ.a(new v.c() { // from class: com.baidu.swan.apps.media.d.a.3
                @Override // com.baidu.swan.apps.u.b.v.c
                public void b(v vVar) {
                    if (a.this.aDd != null) {
                        a.this.aDd.b(vVar);
                    }
                }
            });
        }
        return this.aCZ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GM() {
        return this.aDa;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GN() {
        return this.aDb != null ? this.aDb.aDp : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aDb.aDU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        this.asc = z;
        if (z) {
            if (this.aDc) {
                Ho().resume();
            }
        } else if (this.aCZ != null) {
            this.aDc = Ho().isPlaying();
            Ho().pause();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.aCZ != null && this.aCZ.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", "onDestroy");
        if (this.aCZ != null) {
            this.aCZ.stop();
            this.aCZ = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void eG(String str) {
        if (this.aCZ != null) {
            this.aCZ.eG(str);
        }
    }

    public void b(c cVar) {
        if (this.aCZ != null) {
            this.aCZ.b(cVar);
        }
    }

    public void Fl() {
        if (this.aCZ != null) {
            this.aCZ.Fl();
        }
    }

    private boolean Hp() {
        return (this.aDb == null || TextUtils.isEmpty(this.aDb.mSrc) || TextUtils.isEmpty(this.aDa) || TextUtils.isEmpty(this.aDb.id)) ? false : true;
    }

    public void br(boolean z) {
        if (this.aCZ != null) {
            this.aCZ.br(z);
        }
    }
}
