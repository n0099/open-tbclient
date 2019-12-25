package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.w.b.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private l bzh;
    private String bzi;
    private c bzj;
    private boolean bzk;
    private b bzl;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bzj = cVar;
        this.bzi = cVar.bvC;
        Vs();
        Vr();
    }

    private void Vr() {
        if (!TextUtils.isEmpty(this.bzi)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bzh != null) {
            this.bzh.a(cVar, true);
        }
        this.bzj = cVar;
    }

    public void a(b bVar) {
        this.bzl = bVar;
    }

    public c Gt() {
        return this.bzj;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bvC);
        if (this.bzh != null) {
            this.bzh.a(cVar);
        }
        this.bzj = cVar;
    }

    public void cy(boolean z) {
        if (this.bzh != null) {
            this.bzh.cy(z);
        }
    }

    public void pause() {
        if (Vt()) {
            Vs().pause();
        }
    }

    public void resume() {
        if (Vt() && !isPlaying() && this.mIsForeground && this.bzh != null) {
            this.bzh.resume();
        }
    }

    public void seekTo(int i) {
        if (Vt() && this.bzh != null) {
            this.bzh.seekTo(i);
        }
    }

    public int getDuration() {
        return Vs().getDuration();
    }

    public int getCurrentPosition() {
        return Vs().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bzh != null && this.bzh.isPlaying();
    }

    public boolean isEnd() {
        return this.bzh != null && this.bzh.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bzh != null) {
            this.bzh.b(frameLayout);
        }
    }

    public void d(boolean z, int i) {
        if (this.bzh != null) {
            this.bzh.d(z, i);
        }
    }

    public void b(b bVar) {
        this.bzl = bVar;
    }

    public l Vs() {
        if (this.bzh == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bzh = com.baidu.swan.apps.w.a.Rx().a(this.mContext, this.bzj);
            this.bzh.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bzl != null) {
                        a.this.bzl.b(lVar);
                    }
                }
            });
            this.bzh.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bzl != null && a.this.bzl.a(lVar, i, i2);
                }
            });
            this.bzh.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bzl != null) {
                        a.this.bzl.a(lVar);
                    }
                }
            });
            this.bzh.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bzh.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bzh.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bzh;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Un() {
        return this.bzi;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Uo() {
        return this.bzj != null ? this.bzj.bzx : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bzj.bdi;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Up() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cE(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bzk) {
                Vs().resume();
            }
            Vs().Fc();
        } else if (this.bzh != null) {
            this.bzk = Vs().isPlaying();
            Vs().pause();
            Vs().Fe();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cF(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.bzh != null && this.bzh.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bzh != null) {
            this.bzh.stop();
            this.bzh = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void hQ(String str) {
        if (this.bzh != null) {
            this.bzh.hQ(str);
        }
    }

    public void b(c cVar) {
        if (this.bzh != null) {
            this.bzh.b(cVar);
        }
    }

    public void Sz() {
        if (this.bzh != null) {
            this.bzh.Sz();
        }
    }

    private boolean Vt() {
        return (this.bzj == null || TextUtils.isEmpty(this.bzj.mSrc) || TextUtils.isEmpty(this.bzi) || TextUtils.isEmpty(this.bzj.bdh)) ? false : true;
    }

    public void cx(boolean z) {
        if (this.bzh != null) {
            this.bzh.cx(z);
        }
    }
}
