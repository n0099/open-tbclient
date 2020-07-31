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
/* loaded from: classes3.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c cux;
    private FrameLayout dCT;
    private SwanVideoView dDa;
    private VideoContainerManager dDb;
    private int dDc;
    private boolean dDd;
    private boolean dDe;
    private j.d dDf;
    private j.b dDg;
    private j.a dDh;
    private j.e dDi;
    private j.f dDj;
    private j.c dDk;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int dDl = 0;

    @Override // com.baidu.swan.apps.t.b.j
    public void Ua() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void Uc() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.t.b.j
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cux = cVar;
        aOP();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.dDf = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.dDg = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.dDh = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.dDi = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.dDj = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.dDk = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aOO().setVideoPath(this.cux.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(FrameLayout frameLayout) {
        this.dCT = frameLayout;
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
        this.cux = cVar;
        if (z) {
            gV(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cux == null) {
            return false;
        }
        return (this.cux.cuB == cVar.cuB && this.cux.cuJ == cVar.cuJ && TextUtils.equals(this.cux.cuE, cVar.cuE) && this.cux.cuR == cVar.cuR && this.cux.cuO == cVar.cuO && this.cux.cuP == cVar.cuP && this.cux.cuQ == cVar.cuQ && this.cux.mDirection == cVar.mDirection && this.cux.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        aOO().setMuted(cVar.cuB);
        aOO().setMediaControllerEnabled(cVar.cuJ);
        aOO().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cuE, "cover")) {
            aOO().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cuE, "fill")) {
            aOO().setVideoScalingMode(3);
        } else {
            aOO().setVideoScalingMode(1);
        }
    }

    private void gV(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dDa != null && !z && isPlaying()) {
            this.dDa.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cqu);
        k(cVar);
        this.cux = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aOK();
        aOL();
        aOP().cY(cVar.cuC, cVar.cuE);
    }

    public void j(c cVar) {
        aOP().e(cVar);
        aON();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOI() {
        final Activity activity;
        e arv = e.arv();
        if (arv == null || (activity = arv.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Z(activity);
                SwanAppComponentContainerView aOE = a.this.aOP().aOE();
                aOE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aT(aOE);
                d.d(activity, aOE);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, true, a.this.aOP());
            }
        });
        this.mIsLandscape = true;
        this.dDa.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOJ() {
        Activity activity;
        e arv = e.arv();
        if (arv == null || (activity = arv.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aT(a.this.aOP().aOE());
                a.this.aOP().WT();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, false, a.this.aOP());
            }
        });
        this.mIsLandscape = false;
        this.dDa.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cux != null && cVar != null && !TextUtils.isEmpty(this.cux.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cux.mSrc, cVar.mSrc)) {
            this.dDd = true;
        } else {
            this.dDd = false;
        }
    }

    private void aOK() {
        if (this.dDa != null) {
            this.dDa.stopPlayback();
        }
    }

    private void aOL() {
        aOP().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (alY()) {
            aOP().aOC();
            reset();
            aOO().aOr();
            i(this.cux);
            a(this.cux, false);
            g(this.cux);
            aOO().start();
            this.dDd = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        aOO().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.dDd) {
            aOO().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (alY()) {
            if (!this.dDd) {
                aOO().seekTo(i);
            } else {
                this.dDc = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return aOO().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return aOO().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.dDe;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            aOI();
        } else {
            aOJ();
        }
    }

    private void initListener() {
        aOO().setVideoPlayerCallback(new C0484a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOM() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.dDa == null) {
            return false;
        }
        return this.dDa.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && aOJ();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void aiK() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ll(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void aON() {
        if (this.dDa != null) {
            d.aT(this.dDa);
            if (this.dCT != null) {
                this.dCT.addView(this.dDa);
            } else {
                aOP().getVideoHolder().addView(this.dDa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aOO() {
        if (this.dDa == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dDa = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.dDa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aOP() {
        if (this.cux == null) {
            com.baidu.swan.apps.component.e.a.aV("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.dDb == null) {
            this.dDb = new VideoContainerManager(this.mContext, this.cux);
        }
        return this.dDb;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ei(boolean z) {
        aOO().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ej(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aOO().release();
    }

    public void reset() {
        if (this.dDa != null) {
            this.dDa.stopPlayback();
            d.aT(this.dDa);
            this.dDa = null;
        }
    }

    private boolean alY() {
        return (this.cux == null || TextUtils.isEmpty(this.cux.mSrc) || TextUtils.isEmpty(this.cux.cqu) || TextUtils.isEmpty(this.cux.bVl)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOQ() {
        if (alY()) {
            if (this.dDc != 0) {
                aOO().seekTo(this.dDc);
                this.dDc = 0;
            } else if (this.cux.cuD != 0) {
                this.dDa.seekTo(this.cux.cuD * 1000);
                this.cux.cuD = 0;
            } else if (this.dDl != 0) {
                this.dDa.seekTo(this.dDl);
                this.dDl = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0484a extends com.baidu.swan.videoplayer.a.b {
        private C0484a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, "ended", new JSONObject());
            if (a.this.dDh != null) {
                a.this.dDh.b(a.this);
            }
            a.this.dDe = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void f(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aOP().aOC();
            a.this.aOP().aOD();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.kj(i2));
            if (a.this.dDg != null) {
                a.this.dDg.a(a.this, i, i2);
            }
            a.this.dDe = false;
            int currentPosition = a.this.aOO().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.dDl;
            }
            aVar.dDl = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aOQ();
            a.this.aOM();
            if (a.this.dDf != null) {
                a.this.dDf.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dDe = false;
            a.this.mIsPaused = false;
            a.this.aOP().aOD();
            if (a.this.dDi != null) {
                a.this.dDi.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dDe = false;
            a.this.mIsPaused = false;
            a.this.aOP().aOD();
            if (a.this.dDj != null) {
                a.this.dDj.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void gR(boolean z) {
            if (z) {
                a.this.aOI();
            } else {
                a.this.aOJ();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.dDk != null) {
                a.this.dDk.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aB(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, "waiting", new JSONObject());
        }

        private void aB(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cux.cqu, a.this.cux.bVm, "timeupdate", jSONObject);
        }
    }
}
