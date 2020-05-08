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
    private l cdc;
    private String cdd;
    private c cde;
    private boolean cdf;
    private b cdg;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cde = cVar;
        this.cdd = cVar.bYY;
        agn();
        agm();
    }

    private void agm() {
        if (!TextUtils.isEmpty(this.cdd)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.cdc != null) {
            this.cdc.a(cVar, true);
        }
        this.cde = cVar;
    }

    public void a(b bVar) {
        this.cdg = bVar;
    }

    public c QU() {
        return this.cde;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bYY);
        if (this.cdc != null) {
            this.cdc.a(cVar);
        }
        this.cde = cVar;
    }

    public void dH(boolean z) {
        if (this.cdc != null) {
            this.cdc.dH(z);
        }
    }

    public void pause() {
        if (ago()) {
            agn().pause();
        }
    }

    public void resume() {
        if (ago() && !isPlaying() && this.mIsForeground && this.cdc != null) {
            this.cdc.resume();
        }
    }

    public void seekTo(int i) {
        if (ago() && this.cdc != null) {
            this.cdc.seekTo(i);
        }
    }

    public int getDuration() {
        return agn().getDuration();
    }

    public int getCurrentPosition() {
        return agn().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.cdc != null && this.cdc.isPlaying();
    }

    public boolean isEnd() {
        return this.cdc != null && this.cdc.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.cdc != null) {
            this.cdc.b(frameLayout);
        }
    }

    public void g(boolean z, int i) {
        if (this.cdc != null) {
            this.cdc.g(z, i);
        }
    }

    public void b(b bVar) {
        this.cdg = bVar;
    }

    public l agn() {
        if (this.cdc == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.cdc = com.baidu.swan.apps.w.a.aca().a(this.mContext, this.cde);
            this.cdc.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.cdg != null) {
                        a.this.cdg.b(lVar);
                    }
                }
            });
            this.cdc.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.cdg != null && a.this.cdg.a(lVar, i, i2);
                }
            });
            this.cdc.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.cdg != null) {
                        a.this.cdg.a(lVar);
                    }
                }
            });
            this.cdc.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.cdc.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.cdc.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.cdc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeS() {
        return this.cdd;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.cde != null ? this.cde.cds : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cde.bGO;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeU() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.cdf) {
                agn().resume();
            }
            agn().PD();
        } else if (this.cdc != null) {
            this.cdf = agn().isPlaying();
            agn().pause();
            agn().PF();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.cdc != null && this.cdc.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.cdc != null) {
            this.cdc.stop();
            this.cdc = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void jv(String str) {
        if (this.cdc != null) {
            this.cdc.jv(str);
        }
    }

    public void b(c cVar) {
        if (this.cdc != null) {
            this.cdc.b(cVar);
        }
    }

    public void adc() {
        if (this.cdc != null) {
            this.cdc.adc();
        }
    }

    private boolean ago() {
        return (this.cde == null || TextUtils.isEmpty(this.cde.mSrc) || TextUtils.isEmpty(this.cdd) || TextUtils.isEmpty(this.cde.bGN)) ? false : true;
    }

    public void dG(boolean z) {
        if (this.cdc != null) {
            this.cdc.dG(z);
        }
    }
}
