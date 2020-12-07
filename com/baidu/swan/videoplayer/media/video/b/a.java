package com.baidu.swan.videoplayer.media.video.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.media.b.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.t.b.j;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.d;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c djZ;
    private boolean doR;
    private FrameLayout etU;
    private SwanVideoView eub;
    private VideoContainerManager euc;
    private int eud;
    private boolean eue;
    private j.d euf;
    private j.b eug;
    private j.a euh;
    private j.e eui;
    private j.f euj;
    private j.c euk;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eul = 0;

    @Override // com.baidu.swan.apps.t.b.j
    public void onForeground() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void onBackground() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.t.b.j
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.djZ = cVar;
        bhy();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.euf = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eug = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.euh = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eui = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.euj = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.euk = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bhx().setVideoPath(this.djZ.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.etU = frameLayout;
    }

    private boolean isLandscape() {
        return this.mIsLandscape;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar, boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        com.baidu.swan.apps.console.c.d("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (h(cVar)) {
            i(cVar);
        }
        this.djZ = cVar;
        if (z) {
            ix(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.djZ == null) {
            return false;
        }
        return (this.djZ.dkd == cVar.dkd && this.djZ.dkl == cVar.dkl && TextUtils.equals(this.djZ.dkg, cVar.dkg) && this.djZ.dkt == cVar.dkt && this.djZ.dkq == cVar.dkq && this.djZ.dkr == cVar.dkr && this.djZ.dks == cVar.dks && this.djZ.mDirection == cVar.mDirection && this.djZ.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bhx().setMuted(cVar.dkd);
        bhx().setMediaControllerEnabled(cVar.dkl);
        bhx().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.dkg, "cover")) {
            bhx().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.dkg, "fill")) {
            bhx().setVideoScalingMode(3);
        } else {
            bhx().setVideoScalingMode(1);
        }
    }

    private void ix(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eub != null && !z && isPlaying()) {
            this.eub.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.dga);
        k(cVar);
        this.djZ = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bht();
        bhu();
        bhy().dG(cVar.dke, cVar.dkg);
    }

    public void j(c cVar) {
        bhy().e(cVar);
        bhw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhr() {
        final Activity activity;
        e aJU = e.aJU();
        if (aJU == null || (activity = aJU.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.aa(activity);
                SwanAppComponentContainerView bhn = a.this.bhy().bhn();
                bhn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bf(bhn);
                d.attachDecor(activity, bhn);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, true, a.this.bhy());
            }
        });
        this.mIsLandscape = true;
        this.eub.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhs() {
        Activity activity;
        e aJU = e.aJU();
        if (aJU == null || (activity = aJU.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bf(a.this.bhy().bhn());
                a.this.bhy().ann();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, false, a.this.bhy());
            }
        });
        this.mIsLandscape = false;
        this.eub.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.djZ != null && cVar != null && !TextUtils.isEmpty(this.djZ.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.djZ.mSrc, cVar.mSrc)) {
            this.eue = true;
        } else {
            this.eue = false;
        }
    }

    private void bht() {
        if (this.eub != null) {
            this.eub.stopPlayback();
        }
    }

    private void bhu() {
        bhy().f(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aEa()) {
            bhy().bhl();
            reset();
            bhx().bha();
            i(this.djZ);
            a(this.djZ, false);
            g(this.djZ);
            bhx().start();
            this.eue = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bhx().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eue) {
            bhx().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aEa()) {
            if (!this.eue) {
                bhx().seekTo(i);
            } else {
                this.eud = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bhx().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bhx().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.doR;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void j(boolean z, int i) {
        if (z) {
            bhr();
        } else {
            bhs();
        }
    }

    private void initListener() {
        bhx().setVideoPlayerCallback(new C0578a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhv() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eub == null) {
            return false;
        }
        return this.eub.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bhs();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void aAH() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void py(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bhw() {
        if (this.eub != null) {
            d.bf(this.eub);
            if (this.etU != null) {
                this.etU.addView(this.eub);
            } else {
                bhy().getVideoHolder().addView(this.eub);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bhx() {
        if (this.eub == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eub = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eub;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bhy() {
        if (this.djZ == null) {
            com.baidu.swan.apps.component.e.a.bs("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.euc == null) {
            this.euc = new VideoContainerManager(this.mContext, this.djZ);
        }
        return this.euc;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bhx().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fK(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bhx().release();
    }

    public void reset() {
        if (this.eub != null) {
            this.eub.stopPlayback();
            d.bf(this.eub);
            this.eub = null;
        }
    }

    private boolean aEa() {
        return (this.djZ == null || TextUtils.isEmpty(this.djZ.mSrc) || TextUtils.isEmpty(this.djZ.dga) || TextUtils.isEmpty(this.djZ.cIV)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhz() {
        if (aEa()) {
            if (this.eud != 0) {
                bhx().seekTo(this.eud);
                this.eud = 0;
            } else if (this.djZ.dkf != 0) {
                this.eub.seekTo(this.djZ.dkf * 1000);
                this.djZ.dkf = 0;
            } else if (this.eul != 0) {
                this.eub.seekTo(this.eul);
                this.eul = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0578a extends com.baidu.swan.videoplayer.a.b {
        private C0578a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, "ended", new JSONObject());
            if (a.this.euh != null) {
                a.this.euh.b(a.this);
            }
            a.this.doR = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bhy().bhl();
            a.this.bhy().bhm();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.nM(i2));
            if (a.this.eug != null) {
                a.this.eug.a(a.this, i, i2);
            }
            a.this.doR = false;
            int currentPosition = a.this.bhx().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eul;
            }
            aVar.eul = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bhz();
            a.this.bhv();
            if (a.this.euf != null) {
                a.this.euf.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.doR = false;
            a.this.mIsPaused = false;
            a.this.bhy().bhm();
            if (a.this.eui != null) {
                a.this.eui.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.doR = false;
            a.this.mIsPaused = false;
            a.this.bhy().bhm();
            if (a.this.euj != null) {
                a.this.euj.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void iu(boolean z) {
            if (z) {
                a.this.bhr();
            } else {
                a.this.bhs();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.euk != null) {
                a.this.euk.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aK(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, "waiting", new JSONObject());
        }

        private void aK(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.djZ.dga, a.this.djZ.cIW, "timeupdate", jSONObject);
        }
    }
}
