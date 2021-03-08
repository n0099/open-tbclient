package com.baidu.swan.videoplayer.media.video.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
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
/* loaded from: classes14.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c dnV;
    private boolean dsO;
    private SwanVideoView eCE;
    private VideoContainerManager eCF;
    private int eCG;
    private boolean eCH;
    private j.d eCI;
    private j.b eCJ;
    private j.a eCK;
    private j.e eCL;
    private j.f eCM;
    private j.c eCN;
    private FrameLayout eCx;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eCO = 0;

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
        this.dnV = cVar;
        bgq();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eCI = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eCJ = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eCK = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eCL = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eCM = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eCN = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bgp().setVideoPath(this.dnV.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.eCx = frameLayout;
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
        this.dnV = cVar;
        if (z) {
            iQ(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.dnV == null) {
            return false;
        }
        return (this.dnV.mMute == cVar.mMute && this.dnV.doi == cVar.doi && TextUtils.equals(this.dnV.dob, cVar.dob) && this.dnV.doq == cVar.doq && this.dnV.don == cVar.don && this.dnV.doo == cVar.doo && this.dnV.dop == cVar.dop && this.dnV.mDirection == cVar.mDirection && this.dnV.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bgp().setMuted(cVar.mMute);
        bgp().setMediaControllerEnabled(cVar.doi);
        bgp().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.dob, "cover")) {
            bgp().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.dob, "fill")) {
            bgp().setVideoScalingMode(3);
        } else {
            bgp().setVideoScalingMode(1);
        }
    }

    private void iQ(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eCE != null && !z && isPlaying()) {
            this.eCE.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.djT);
        k(cVar);
        this.dnV = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bgl();
        bgm();
        bgq().dy(cVar.dnZ, cVar.dob);
    }

    public void j(c cVar) {
        bgq().e(cVar);
        bgo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgj() {
        final Activity activity;
        e aIN = e.aIN();
        if (aIN == null || (activity = aIN.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.W(activity);
                SwanAppComponentContainerView bgf = a.this.bgq().bgf();
                bgf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bk(bgf);
                d.attachDecor(activity, bgf);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, true, a.this.bgq());
            }
        });
        this.mIsLandscape = true;
        this.eCE.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgk() {
        Activity activity;
        e aIN = e.aIN();
        if (aIN == null || (activity = aIN.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bk(a.this.bgq().bgf());
                a.this.bgq().ale();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, false, a.this.bgq());
            }
        });
        this.mIsLandscape = false;
        this.eCE.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.dnV != null && cVar != null && !TextUtils.isEmpty(this.dnV.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.dnV.mSrc, cVar.mSrc)) {
            this.eCH = true;
        } else {
            this.eCH = false;
        }
    }

    private void bgl() {
        if (this.eCE != null) {
            this.eCE.stopPlayback();
        }
    }

    private void bgm() {
        bgq().g(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aCa()) {
            bgq().bgd();
            reset();
            bgp().bfT();
            i(this.dnV);
            a(this.dnV, false);
            g(this.dnV);
            bgp().start();
            this.eCH = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bgp().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eCH) {
            bgp().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aCa()) {
            if (!this.eCH) {
                bgp().seekTo(i);
            } else {
                this.eCG = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bgp().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bgp().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.dsO;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            bgj();
        } else {
            bgk();
        }
    }

    private void initListener() {
        bgp().setVideoPlayerCallback(new C0555a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgn() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eCE == null) {
            return false;
        }
        return this.eCE.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bgk();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ayG() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oF(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bgo() {
        if (this.eCE != null) {
            d.bk(this.eCE);
            if (this.eCx != null) {
                this.eCx.addView(this.eCE);
            } else {
                bgq().getVideoHolder().addView(this.eCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bgp() {
        if (this.eCE == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eCE = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bgq() {
        if (this.dnV == null) {
            com.baidu.swan.apps.component.e.a.bk("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eCF == null) {
            this.eCF = new VideoContainerManager(this.mContext, this.dnV);
        }
        return this.eCF;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bgp().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fR(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bgp().release();
    }

    public void reset() {
        if (this.eCE != null) {
            this.eCE.stopPlayback();
            d.bk(this.eCE);
            this.eCE = null;
        }
    }

    private boolean aCa() {
        return (this.dnV == null || TextUtils.isEmpty(this.dnV.mSrc) || TextUtils.isEmpty(this.dnV.djT) || TextUtils.isEmpty(this.dnV.cMQ)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgr() {
        if (aCa()) {
            if (this.eCG != 0) {
                bgp().seekTo(this.eCG);
                this.eCG = 0;
            } else if (this.dnV.doa != 0) {
                this.eCE.seekTo(this.dnV.doa * 1000);
                this.dnV.doa = 0;
            } else if (this.eCO != 0) {
                this.eCE.seekTo(this.eCO);
                this.eCO = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0555a extends com.baidu.swan.videoplayer.a.b {
        private C0555a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, "ended", new JSONObject());
            if (a.this.eCK != null) {
                a.this.eCK.b(a.this);
            }
            a.this.dsO = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bgq().bgd();
            a.this.bgq().bge();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.mt(i2));
            if (a.this.eCJ != null) {
                a.this.eCJ.a(a.this, i, i2);
            }
            a.this.dsO = false;
            int currentPosition = a.this.bgp().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eCO;
            }
            aVar.eCO = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bgr();
            a.this.bgn();
            if (a.this.eCI != null) {
                a.this.eCI.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dsO = false;
            a.this.mIsPaused = false;
            a.this.bgq().bge();
            if (a.this.eCL != null) {
                a.this.eCL.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dsO = false;
            a.this.mIsPaused = false;
            a.this.bgq().bge();
            if (a.this.eCM != null) {
                a.this.eCM.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void iN(boolean z) {
            if (z) {
                a.this.bgj();
            } else {
                a.this.bgk();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eCN != null) {
                a.this.eCN.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aE(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, "waiting", new JSONObject());
        }

        private void aE(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dnV.djT, a.this.dnV.cMR, "timeupdate", jSONObject);
        }
    }
}
