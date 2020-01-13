package com.baidu.swan.apps.media.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.swan.apps.w.b.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private l bzU;
    private String bzV;
    private c bzW;
    private boolean bzX;
    private b bzY;
    private Context mContext;
    private boolean mIsForeground = true;

    public a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bzW = cVar;
        this.bzV = cVar.bwp;
        VP();
        VO();
    }

    private void VO() {
        if (!TextUtils.isEmpty(this.bzV)) {
            com.baidu.swan.apps.media.b.a(this);
        }
    }

    public void c(c cVar) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        if (this.bzU != null) {
            this.bzU.a(cVar, true);
        }
        this.bzW = cVar;
    }

    public void a(b bVar) {
        this.bzY = bVar;
    }

    public c GP() {
        return this.bzW;
    }

    public void d(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bwp);
        if (this.bzU != null) {
            this.bzU.a(cVar);
        }
        this.bzW = cVar;
    }

    public void cD(boolean z) {
        if (this.bzU != null) {
            this.bzU.cD(z);
        }
    }

    public void pause() {
        if (VQ()) {
            VP().pause();
        }
    }

    public void resume() {
        if (VQ() && !isPlaying() && this.mIsForeground && this.bzU != null) {
            this.bzU.resume();
        }
    }

    public void seekTo(int i) {
        if (VQ() && this.bzU != null) {
            this.bzU.seekTo(i);
        }
    }

    public int getDuration() {
        return VP().getDuration();
    }

    public int getCurrentPosition() {
        return VP().getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.bzU != null && this.bzU.isPlaying();
    }

    public boolean isEnd() {
        return this.bzU != null && this.bzU.isEnd();
    }

    public void b(FrameLayout frameLayout) {
        if (this.bzU != null) {
            this.bzU.b(frameLayout);
        }
    }

    public void e(boolean z, int i) {
        if (this.bzU != null) {
            this.bzU.e(z, i);
        }
    }

    public void b(b bVar) {
        this.bzY = bVar;
    }

    public l VP() {
        if (this.bzU == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.bzU = com.baidu.swan.apps.w.a.RT().a(this.mContext, this.bzW);
            this.bzU.a(new l.a() { // from class: com.baidu.swan.apps.media.c.a.1
                @Override // com.baidu.swan.apps.w.b.l.a
                public void b(l lVar) {
                    if (a.this.bzY != null) {
                        a.this.bzY.b(lVar);
                    }
                }
            });
            this.bzU.a(new l.b() { // from class: com.baidu.swan.apps.media.c.a.2
                @Override // com.baidu.swan.apps.w.b.l.b
                public boolean a(l lVar, int i, int i2) {
                    return a.this.bzY != null && a.this.bzY.a(lVar, i, i2);
                }
            });
            this.bzU.a(new l.d() { // from class: com.baidu.swan.apps.media.c.a.3
                @Override // com.baidu.swan.apps.w.b.l.d
                public void a(l lVar) {
                    if (a.this.bzY != null) {
                        a.this.bzY.a(lVar);
                    }
                }
            });
            this.bzU.a(new l.e() { // from class: com.baidu.swan.apps.media.c.a.4
            });
            this.bzU.a(new l.f() { // from class: com.baidu.swan.apps.media.c.a.5
            });
            this.bzU.a(new l.c() { // from class: com.baidu.swan.apps.media.c.a.6
            });
        }
        return this.bzU;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UK() {
        return this.bzV;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UL() {
        return this.bzW != null ? this.bzW.bAk : "";
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bzW.bdW;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object UM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cJ(boolean z) {
        this.mIsForeground = z;
        if (z) {
            if (this.bzX) {
                VP().resume();
            }
            VP().Fy();
        } else if (this.bzU != null) {
            this.bzX = VP().isPlaying();
            VP().pause();
            VP().FA();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        com.baidu.swan.apps.console.c.d("video", "onBackPressed");
        return this.bzU != null && this.bzU.onBackPressed();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.console.c.d("video", MissionEvent.MESSAGE_DESTROY);
        if (this.bzU != null) {
            this.bzU.stop();
            this.bzU = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    public void hT(String str) {
        if (this.bzU != null) {
            this.bzU.hT(str);
        }
    }

    public void b(c cVar) {
        if (this.bzU != null) {
            this.bzU.b(cVar);
        }
    }

    public void SV() {
        if (this.bzU != null) {
            this.bzU.SV();
        }
    }

    private boolean VQ() {
        return (this.bzW == null || TextUtils.isEmpty(this.bzW.mSrc) || TextUtils.isEmpty(this.bzV) || TextUtils.isEmpty(this.bzW.bdV)) ? false : true;
    }

    public void cC(boolean z) {
        if (this.bzU != null) {
            this.bzU.cC(z);
        }
    }
}
