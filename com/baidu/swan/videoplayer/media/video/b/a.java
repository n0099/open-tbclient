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
/* loaded from: classes15.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c dmt;
    private boolean drl;
    private FrameLayout eAW;
    private SwanVideoView eBd;
    private VideoContainerManager eBe;
    private int eBf;
    private boolean eBg;
    private j.d eBh;
    private j.b eBi;
    private j.a eBj;
    private j.e eBk;
    private j.f eBl;
    private j.c eBm;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eBn = 0;

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
        this.dmt = cVar;
        bgo();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eBh = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eBi = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eBj = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eBk = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eBl = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eBm = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bgn().setVideoPath(this.dmt.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.eAW = frameLayout;
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
        this.dmt = cVar;
        if (z) {
            iQ(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.dmt == null) {
            return false;
        }
        return (this.dmt.mMute == cVar.mMute && this.dmt.dmF == cVar.dmF && TextUtils.equals(this.dmt.dmz, cVar.dmz) && this.dmt.dmN == cVar.dmN && this.dmt.dmK == cVar.dmK && this.dmt.dmL == cVar.dmL && this.dmt.dmM == cVar.dmM && this.dmt.mDirection == cVar.mDirection && this.dmt.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bgn().setMuted(cVar.mMute);
        bgn().setMediaControllerEnabled(cVar.dmF);
        bgn().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.dmz, "cover")) {
            bgn().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.dmz, "fill")) {
            bgn().setVideoScalingMode(3);
        } else {
            bgn().setVideoScalingMode(1);
        }
    }

    private void iQ(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eBd != null && !z && isPlaying()) {
            this.eBd.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.diq);
        k(cVar);
        this.dmt = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bgj();
        bgk();
        bgo().dy(cVar.dmx, cVar.dmz);
    }

    public void j(c cVar) {
        bgo().e(cVar);
        bgm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgh() {
        final Activity activity;
        e aIK = e.aIK();
        if (aIK == null || (activity = aIK.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.W(activity);
                SwanAppComponentContainerView bgd = a.this.bgo().bgd();
                bgd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bk(bgd);
                d.attachDecor(activity, bgd);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, true, a.this.bgo());
            }
        });
        this.mIsLandscape = true;
        this.eBd.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgi() {
        Activity activity;
        e aIK = e.aIK();
        if (aIK == null || (activity = aIK.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bk(a.this.bgo().bgd());
                a.this.bgo().alb();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, false, a.this.bgo());
            }
        });
        this.mIsLandscape = false;
        this.eBd.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.dmt != null && cVar != null && !TextUtils.isEmpty(this.dmt.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.dmt.mSrc, cVar.mSrc)) {
            this.eBg = true;
        } else {
            this.eBg = false;
        }
    }

    private void bgj() {
        if (this.eBd != null) {
            this.eBd.stopPlayback();
        }
    }

    private void bgk() {
        bgo().g(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aBX()) {
            bgo().bgb();
            reset();
            bgn().bfR();
            i(this.dmt);
            a(this.dmt, false);
            g(this.dmt);
            bgn().start();
            this.eBg = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bgn().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eBg) {
            bgn().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aBX()) {
            if (!this.eBg) {
                bgn().seekTo(i);
            } else {
                this.eBf = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bgn().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bgn().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.drl;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            bgh();
        } else {
            bgi();
        }
    }

    private void initListener() {
        bgn().setVideoPlayerCallback(new C0549a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgl() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eBd == null) {
            return false;
        }
        return this.eBd.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bgi();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ayD() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oy(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bgm() {
        if (this.eBd != null) {
            d.bk(this.eBd);
            if (this.eAW != null) {
                this.eAW.addView(this.eBd);
            } else {
                bgo().getVideoHolder().addView(this.eBd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bgn() {
        if (this.eBd == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eBd = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eBd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bgo() {
        if (this.dmt == null) {
            com.baidu.swan.apps.component.e.a.bk("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eBe == null) {
            this.eBe = new VideoContainerManager(this.mContext, this.dmt);
        }
        return this.eBe;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bgn().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fR(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bgn().release();
    }

    public void reset() {
        if (this.eBd != null) {
            this.eBd.stopPlayback();
            d.bk(this.eBd);
            this.eBd = null;
        }
    }

    private boolean aBX() {
        return (this.dmt == null || TextUtils.isEmpty(this.dmt.mSrc) || TextUtils.isEmpty(this.dmt.diq) || TextUtils.isEmpty(this.dmt.cLq)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        if (aBX()) {
            if (this.eBf != 0) {
                bgn().seekTo(this.eBf);
                this.eBf = 0;
            } else if (this.dmt.dmy != 0) {
                this.eBd.seekTo(this.dmt.dmy * 1000);
                this.dmt.dmy = 0;
            } else if (this.eBn != 0) {
                this.eBd.seekTo(this.eBn);
                this.eBn = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C0549a extends com.baidu.swan.videoplayer.a.b {
        private C0549a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, "ended", new JSONObject());
            if (a.this.eBj != null) {
                a.this.eBj.b(a.this);
            }
            a.this.drl = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bgo().bgb();
            a.this.bgo().bgc();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.ms(i2));
            if (a.this.eBi != null) {
                a.this.eBi.a(a.this, i, i2);
            }
            a.this.drl = false;
            int currentPosition = a.this.bgn().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eBn;
            }
            aVar.eBn = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bgp();
            a.this.bgl();
            if (a.this.eBh != null) {
                a.this.eBh.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.drl = false;
            a.this.mIsPaused = false;
            a.this.bgo().bgc();
            if (a.this.eBk != null) {
                a.this.eBk.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.drl = false;
            a.this.mIsPaused = false;
            a.this.bgo().bgc();
            if (a.this.eBl != null) {
                a.this.eBl.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void iN(boolean z) {
            if (z) {
                a.this.bgh();
            } else {
                a.this.bgi();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eBm != null) {
                a.this.eBm.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dmt.diq, a.this.dmt.cLr, "timeupdate", jSONObject);
        }
    }
}
