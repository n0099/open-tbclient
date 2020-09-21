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
/* loaded from: classes25.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c cEl;
    private boolean cJa;
    private j.c dOA;
    private FrameLayout dOk;
    private SwanVideoView dOr;
    private VideoContainerManager dOs;
    private int dOt;
    private boolean dOu;
    private j.d dOv;
    private j.b dOw;
    private j.a dOx;
    private j.e dOy;
    private j.f dOz;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int dOB = 0;

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
        this.cEl = cVar;
        aXZ();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.dOv = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.dOw = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.dOx = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.dOy = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.dOz = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.dOA = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aXY().setVideoPath(this.cEl.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(FrameLayout frameLayout) {
        this.dOk = frameLayout;
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
        this.cEl = cVar;
        if (z) {
            ho(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cEl == null) {
            return false;
        }
        return (this.cEl.cEp == cVar.cEp && this.cEl.cEx == cVar.cEx && TextUtils.equals(this.cEl.cEs, cVar.cEs) && this.cEl.cEF == cVar.cEF && this.cEl.cEC == cVar.cEC && this.cEl.cED == cVar.cED && this.cEl.cEE == cVar.cEE && this.cEl.mDirection == cVar.mDirection && this.cEl.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        aXY().setMuted(cVar.cEp);
        aXY().setMediaControllerEnabled(cVar.cEx);
        aXY().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cEs, "cover")) {
            aXY().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cEs, "fill")) {
            aXY().setVideoScalingMode(3);
        } else {
            aXY().setVideoScalingMode(1);
        }
    }

    private void ho(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dOr != null && !z && isPlaying()) {
            this.dOr.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cAp);
        k(cVar);
        this.cEl = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aXU();
        aXV();
        aXZ().m36do(cVar.cEq, cVar.cEs);
    }

    public void j(c cVar) {
        aXZ().e(cVar);
        aXX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXS() {
        final Activity activity;
        e aAr = e.aAr();
        if (aAr == null || (activity = aAr.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.aa(activity);
                SwanAppComponentContainerView aXO = a.this.aXZ().aXO();
                aXO.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aX(aXO);
                d.attachDecor(activity, aXO);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, true, a.this.aXZ());
            }
        });
        this.mIsLandscape = true;
        this.dOr.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXT() {
        Activity activity;
        e aAr = e.aAr();
        if (aAr == null || (activity = aAr.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aX(a.this.aXZ().aXO());
                a.this.aXZ().adI();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, false, a.this.aXZ());
            }
        });
        this.mIsLandscape = false;
        this.dOr.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cEl != null && cVar != null && !TextUtils.isEmpty(this.cEl.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cEl.mSrc, cVar.mSrc)) {
            this.dOu = true;
        } else {
            this.dOu = false;
        }
    }

    private void aXU() {
        if (this.dOr != null) {
            this.dOr.stopPlayback();
        }
    }

    private void aXV() {
        aXZ().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (auu()) {
            aXZ().aXM();
            reset();
            aXY().aXB();
            i(this.cEl);
            a(this.cEl, false);
            g(this.cEl);
            aXY().start();
            this.dOu = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        aXY().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.dOu) {
            aXY().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (auu()) {
            if (!this.dOu) {
                aXY().seekTo(i);
            } else {
                this.dOt = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return aXY().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return aXY().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.cJa;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            aXS();
        } else {
            aXT();
        }
    }

    private void initListener() {
        aXY().setVideoPlayerCallback(new C0525a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXW() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.dOr == null) {
            return false;
        }
        return this.dOr.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && aXT();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ara() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void nC(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void aXX() {
        if (this.dOr != null) {
            d.aX(this.dOr);
            if (this.dOk != null) {
                this.dOk.addView(this.dOr);
            } else {
                aXZ().getVideoHolder().addView(this.dOr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aXY() {
        if (this.dOr == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dOr = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.dOr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aXZ() {
        if (this.cEl == null) {
            com.baidu.swan.apps.component.e.a.ba("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.dOs == null) {
            this.dOs = new VideoContainerManager(this.mContext, this.cEl);
        }
        return this.dOs;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        aXY().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void eA(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aXY().release();
    }

    public void reset() {
        if (this.dOr != null) {
            this.dOr.stopPlayback();
            d.aX(this.dOr);
            this.dOr = null;
        }
    }

    private boolean auu() {
        return (this.cEl == null || TextUtils.isEmpty(this.cEl.mSrc) || TextUtils.isEmpty(this.cEl.cAp) || TextUtils.isEmpty(this.cEl.ccZ)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYa() {
        if (auu()) {
            if (this.dOt != 0) {
                aXY().seekTo(this.dOt);
                this.dOt = 0;
            } else if (this.cEl.cEr != 0) {
                this.dOr.seekTo(this.cEl.cEr * 1000);
                this.cEl.cEr = 0;
            } else if (this.dOB != 0) {
                this.dOr.seekTo(this.dOB);
                this.dOB = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0525a extends com.baidu.swan.videoplayer.a.b {
        private C0525a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, "ended", new JSONObject());
            if (a.this.dOx != null) {
                a.this.dOx.b(a.this);
            }
            a.this.cJa = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aXZ().aXM();
            a.this.aXZ().aXN();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.mA(i2));
            if (a.this.dOw != null) {
                a.this.dOw.a(a.this, i, i2);
            }
            a.this.cJa = false;
            int currentPosition = a.this.aXY().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.dOB;
            }
            aVar.dOB = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aYa();
            a.this.aXW();
            if (a.this.dOv != null) {
                a.this.dOv.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cJa = false;
            a.this.mIsPaused = false;
            a.this.aXZ().aXN();
            if (a.this.dOy != null) {
                a.this.dOy.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cJa = false;
            a.this.mIsPaused = false;
            a.this.aXZ().aXN();
            if (a.this.dOz != null) {
                a.this.dOz.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void hk(boolean z) {
            if (z) {
                a.this.aXS();
            } else {
                a.this.aXT();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.dOA != null) {
                a.this.dOA.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cEl.cAp, a.this.cEl.cda, "timeupdate", jSONObject);
        }
    }
}
