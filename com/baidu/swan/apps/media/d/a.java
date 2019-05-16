package com.baidu.swan.apps.media.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.u.b.v;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private v aCr;
    private String aCs;
    private boolean aCu;
    private b aCv;
    private Context mContext;
    private c aCt = new c();
    private boolean arz = true;

    public a(Context context, String str) {
        this.mContext = context;
        this.aCs = str;
        GE();
        GC();
    }

    private void GC() {
        if (!TextUtils.isEmpty(this.aCs)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.aCr != null) {
            this.aCr.a(cVar, true);
        }
        this.aCt = cVar;
    }

    public void a(b bVar) {
        this.aCv = bVar;
    }

    public c GD() {
        return this.aCt;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aAu);
        if (this.aCr != null) {
            this.aCr.a(cVar);
        }
        this.aCt = cVar;
    }

    public void bp(boolean z) {
        if (this.aCr != null) {
            this.aCr.bp(z);
        }
    }

    public void pause() {
        if (GF()) {
            GE().pause();
        }
    }

    public void resume() {
        if (GF() && !isPlaying() && this.arz && this.aCr != null) {
            this.aCr.resume();
        }
    }

    public void seekTo(int i) {
        if (GF() && this.aCr != null) {
            this.aCr.seekTo(i);
        }
    }

    public int getDuration() {
        return GE().getDuration();
    }

    public int getCurrentPosition() {
        return GE().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.aCr != null && this.aCr.isPlaying();
    }

    public boolean isEnd() {
        return this.aCr != null && this.aCr.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.aCr != null) {
            this.aCr.b(frameLayout);
        }
    }

    public void setFullScreen(boolean z) {
        if (this.aCr != null) {
            this.aCr.setFullScreen(z);
        }
    }

    public v GE() {
        if (this.aCr == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.aCr = com.baidu.swan.apps.u.a.DO().bg(this.mContext);
            this.aCr.a(new v.a() { // from class: com.baidu.swan.apps.media.d.a.1
                @Override // com.baidu.swan.apps.u.b.v.a
                public void a(v vVar) {
                    if (a.this.aCv != null) {
                        a.this.aCv.a(vVar);
                    }
                }
            });
            this.aCr.a(new v.b() { // from class: com.baidu.swan.apps.media.d.a.2
                @Override // com.baidu.swan.apps.u.b.v.b
                public boolean a(v vVar, int i, int i2) {
                    return a.this.aCv != null && a.this.aCv.a(vVar, i, i2);
                }
            });
            this.aCr.a(new v.c() { // from class: com.baidu.swan.apps.media.d.a.3
                @Override // com.baidu.swan.apps.u.b.v.c
                public void b(v vVar) {
                    if (a.this.aCv != null) {
                        a.this.aCv.b(vVar);
                    }
                }
            });
        }
        return this.aCr;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.aCs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gd() {
        return this.aCt != null ? this.aCt.aCH : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aCt.aDm;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ge() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bt(boolean z) {
        this.arz = z;
        if (z) {
            if (this.aCu) {
                GE().resume();
            }
        } else if (this.aCr != null) {
            this.aCu = GE().isPlaying();
            GE().pause();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.aCr != null && this.aCr.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", "onDestroy");
        if (this.aCr != null) {
            this.aCr.stop();
            this.aCr = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void eC(String str) {
        if (this.aCr != null) {
            this.aCr.eC(str);
        }
    }

    public void b(c cVar) {
        if (this.aCr != null) {
            this.aCr.b(cVar);
        }
    }

    public void EC() {
        if (this.aCr != null) {
            this.aCr.EC();
        }
    }

    private boolean GF() {
        return (this.aCt == null || TextUtils.isEmpty(this.aCt.mSrc) || TextUtils.isEmpty(this.aCs) || TextUtils.isEmpty(this.aCt.id)) ? false : true;
    }

    public void bo(boolean z) {
        if (this.aCr != null) {
            this.aCr.bo(z);
        }
    }
}
