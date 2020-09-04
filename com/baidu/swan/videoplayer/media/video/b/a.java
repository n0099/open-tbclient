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
/* loaded from: classes9.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c cCl;
    private boolean cHa;
    private FrameLayout dMh;
    private SwanVideoView dMo;
    private VideoContainerManager dMp;
    private int dMq;
    private boolean dMr;
    private j.d dMs;
    private j.b dMt;
    private j.a dMu;
    private j.e dMv;
    private j.f dMw;
    private j.c dMx;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int dMy = 0;

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
        this.cCl = cVar;
        aXn();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.dMs = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.dMt = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.dMu = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.dMv = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.dMw = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.dMx = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aXm().setVideoPath(this.cCl.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(FrameLayout frameLayout) {
        this.dMh = frameLayout;
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
        this.cCl = cVar;
        if (z) {
            hq(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cCl == null) {
            return false;
        }
        return (this.cCl.cCp == cVar.cCp && this.cCl.cCx == cVar.cCx && TextUtils.equals(this.cCl.cCs, cVar.cCs) && this.cCl.cCF == cVar.cCF && this.cCl.cCC == cVar.cCC && this.cCl.cCD == cVar.cCD && this.cCl.cCE == cVar.cCE && this.cCl.mDirection == cVar.mDirection && this.cCl.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        aXm().setMuted(cVar.cCp);
        aXm().setMediaControllerEnabled(cVar.cCx);
        aXm().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cCs, "cover")) {
            aXm().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cCs, "fill")) {
            aXm().setVideoScalingMode(3);
        } else {
            aXm().setVideoScalingMode(1);
        }
    }

    private void hq(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dMo != null && !z && isPlaying()) {
            this.dMo.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cyo);
        k(cVar);
        this.cCl = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aXi();
        aXj();
        aXn().m37do(cVar.cCq, cVar.cCs);
    }

    public void j(c cVar) {
        aXn().e(cVar);
        aXl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXg() {
        final Activity activity;
        e azI = e.azI();
        if (azI == null || (activity = azI.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Y(activity);
                SwanAppComponentContainerView aXc = a.this.aXn().aXc();
                aXc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aV(aXc);
                d.attachDecor(activity, aXc);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, true, a.this.aXn());
            }
        });
        this.mIsLandscape = true;
        this.dMo.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXh() {
        Activity activity;
        e azI = e.azI();
        if (azI == null || (activity = azI.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aV(a.this.aXn().aXc());
                a.this.aXn().acZ();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, false, a.this.aXn());
            }
        });
        this.mIsLandscape = false;
        this.dMo.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cCl != null && cVar != null && !TextUtils.isEmpty(this.cCl.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cCl.mSrc, cVar.mSrc)) {
            this.dMr = true;
        } else {
            this.dMr = false;
        }
    }

    private void aXi() {
        if (this.dMo != null) {
            this.dMo.stopPlayback();
        }
    }

    private void aXj() {
        aXn().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (atL()) {
            aXn().aXa();
            reset();
            aXm().aWP();
            i(this.cCl);
            a(this.cCl, false);
            g(this.cCl);
            aXm().start();
            this.dMr = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        aXm().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.dMr) {
            aXm().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (atL()) {
            if (!this.dMr) {
                aXm().seekTo(i);
            } else {
                this.dMq = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return aXm().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return aXm().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.cHa;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            aXg();
        } else {
            aXh();
        }
    }

    private void initListener() {
        aXm().setVideoPlayerCallback(new C0530a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXk() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.dMo == null) {
            return false;
        }
        return this.dMo.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && aXh();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void aqq() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void nj(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void aXl() {
        if (this.dMo != null) {
            d.aV(this.dMo);
            if (this.dMh != null) {
                this.dMh.addView(this.dMo);
            } else {
                aXn().getVideoHolder().addView(this.dMo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aXm() {
        if (this.dMo == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dMo = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.dMo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aXn() {
        if (this.cCl == null) {
            com.baidu.swan.apps.component.e.a.ba("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.dMp == null) {
            this.dMp = new VideoContainerManager(this.mContext, this.cCl);
        }
        return this.dMp;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        aXm().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void eC(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aXm().release();
    }

    public void reset() {
        if (this.dMo != null) {
            this.dMo.stopPlayback();
            d.aV(this.dMo);
            this.dMo = null;
        }
    }

    private boolean atL() {
        return (this.cCl == null || TextUtils.isEmpty(this.cCl.mSrc) || TextUtils.isEmpty(this.cCl.cyo) || TextUtils.isEmpty(this.cCl.caX)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        if (atL()) {
            if (this.dMq != 0) {
                aXm().seekTo(this.dMq);
                this.dMq = 0;
            } else if (this.cCl.cCr != 0) {
                this.dMo.seekTo(this.cCl.cCr * 1000);
                this.cCl.cCr = 0;
            } else if (this.dMy != 0) {
                this.dMo.seekTo(this.dMy);
                this.dMy = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0530a extends com.baidu.swan.videoplayer.a.b {
        private C0530a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, "ended", new JSONObject());
            if (a.this.dMu != null) {
                a.this.dMu.b(a.this);
            }
            a.this.cHa = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aXn().aXa();
            a.this.aXn().aXb();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.mp(i2));
            if (a.this.dMt != null) {
                a.this.dMt.a(a.this, i, i2);
            }
            a.this.cHa = false;
            int currentPosition = a.this.aXm().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.dMy;
            }
            aVar.dMy = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aXo();
            a.this.aXk();
            if (a.this.dMs != null) {
                a.this.dMs.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cHa = false;
            a.this.mIsPaused = false;
            a.this.aXn().aXb();
            if (a.this.dMv != null) {
                a.this.dMv.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cHa = false;
            a.this.mIsPaused = false;
            a.this.aXn().aXb();
            if (a.this.dMw != null) {
                a.this.dMw.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void hm(boolean z) {
            if (z) {
                a.this.aXg();
            } else {
                a.this.aXh();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.dMx != null) {
                a.this.dMx.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aI(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, "waiting", new JSONObject());
        }

        private void aI(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cCl.cyo, a.this.cCl.caY, "timeupdate", jSONObject);
        }
    }
}
