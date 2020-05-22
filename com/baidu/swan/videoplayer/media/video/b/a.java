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
import com.baidu.swan.apps.u.b.j;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.d;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c cnG;
    private int dsA;
    private boolean dsB;
    private boolean dsC;
    private j.d dsD;
    private j.b dsE;
    private j.a dsF;
    private j.e dsG;
    private j.f dsH;
    private j.c dsI;
    private FrameLayout dsq;
    private SwanVideoView dsy;
    private VideoContainerManager dsz;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int dsJ = 0;

    @Override // com.baidu.swan.apps.u.b.j
    public void Su() {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void Sw() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.j
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cnG = cVar;
        aJV();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.d dVar) {
        this.dsD = dVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.b bVar) {
        this.dsE = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.a aVar) {
        this.dsF = aVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.e eVar) {
        this.dsG = eVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.f fVar) {
        this.dsH = fVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.c cVar) {
        this.dsI = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aJU().setVideoPath(this.cnG.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void b(FrameLayout frameLayout) {
        this.dsq = frameLayout;
    }

    private boolean isLandscape() {
        return this.mIsLandscape;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(c cVar, boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        com.baidu.swan.apps.console.c.d("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (h(cVar)) {
            i(cVar);
        }
        this.cnG = cVar;
        if (z) {
            gv(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cnG == null) {
            return false;
        }
        return (this.cnG.cnK == cVar.cnK && this.cnG.cnS == cVar.cnS && TextUtils.equals(this.cnG.cnN, cVar.cnN) && this.cnG.coa == cVar.coa && this.cnG.cnX == cVar.cnX && this.cnG.cnY == cVar.cnY && this.cnG.cnZ == cVar.cnZ && this.cnG.mDirection == cVar.mDirection && this.cnG.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        aJU().setMuted(cVar.cnK);
        aJU().setMediaControllerEnabled(cVar.cnS);
        aJU().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cnN, "cover")) {
            aJU().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cnN, "fill")) {
            aJU().setVideoScalingMode(3);
        } else {
            aJU().setVideoScalingMode(1);
        }
    }

    private void gv(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dsy != null && !z && isPlaying()) {
            this.dsy.pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cjA);
        k(cVar);
        this.cnG = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aJQ();
        aJR();
        aJV().cT(cVar.cnL, cVar.cnN);
    }

    public void j(c cVar) {
        aJV().e(cVar);
        aJT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJO() {
        final Activity activity;
        e aoF = e.aoF();
        if (aoF == null || (activity = aoF.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Y(activity);
                SwanAppComponentContainerView aJK = a.this.aJV().aJK();
                aJK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aO(aJK);
                d.d(activity, aJK);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, true, a.this.aJV());
            }
        });
        this.mIsLandscape = true;
        this.dsy.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJP() {
        Activity activity;
        e aoF = e.aoF();
        if (aoF == null || (activity = aoF.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aO(a.this.aJV().aJK());
                a.this.aJV().Vg();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, false, a.this.aJV());
            }
        });
        this.mIsLandscape = false;
        this.dsy.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cnG != null && cVar != null && !TextUtils.isEmpty(this.cnG.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cnG.mSrc, cVar.mSrc)) {
            this.dsB = true;
        } else {
            this.dsB = false;
        }
    }

    private void aJQ() {
        if (this.dsy != null) {
            this.dsy.stopPlayback();
        }
    }

    private void aJR() {
        aJV().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (ajC()) {
            aJV().aJI();
            reset();
            aJU().aJx();
            i(this.cnG);
            a(this.cnG, false);
            g(this.cnG);
            aJU().start();
            this.dsB = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void pause() {
        aJU().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void resume() {
        if (this.mIsPaused && !this.dsB) {
            aJU().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void seekTo(int i) {
        if (ajC()) {
            if (!this.dsB) {
                aJU().seekTo(i);
            } else {
                this.dsA = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public int getDuration() {
        return aJU().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public int getCurrentPosition() {
        return aJU().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean isEnd() {
        return this.dsC;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void i(boolean z, int i) {
        if (z) {
            aJO();
        } else {
            aJP();
        }
    }

    private void initListener() {
        aJU().setVideoPlayerCallback(new C0466a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJS() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean isPlaying() {
        if (this.dsy == null) {
            return false;
        }
        return this.dsy.isPlaying();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean onBackPressed() {
        return isLandscape() && aJP();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void agm() {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void kG(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void b(c cVar) {
    }

    private void aJT() {
        if (this.dsy != null) {
            d.aO(this.dsy);
            if (this.dsq != null) {
                this.dsq.addView(this.dsy);
            } else {
                aJV().getVideoHolder().addView(this.dsy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aJU() {
        if (this.dsy == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dsy = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.dsy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aJV() {
        if (this.cnG == null) {
            com.baidu.swan.apps.component.e.a.aS("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.dsz == null) {
            this.dsz = new VideoContainerManager(this.mContext, this.cnG);
        }
        return this.dsz;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void dW(boolean z) {
        aJU().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void dX(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aJU().release();
    }

    public void reset() {
        if (this.dsy != null) {
            this.dsy.stopPlayback();
            d.aO(this.dsy);
            this.dsy = null;
        }
    }

    private boolean ajC() {
        return (this.cnG == null || TextUtils.isEmpty(this.cnG.mSrc) || TextUtils.isEmpty(this.cnG.cjA) || TextUtils.isEmpty(this.cnG.bPF)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJW() {
        if (ajC()) {
            if (this.dsA != 0) {
                aJU().seekTo(this.dsA);
                this.dsA = 0;
            } else if (this.cnG.cnM != 0) {
                this.dsy.seekTo(this.cnG.cnM * 1000);
                this.cnG.cnM = 0;
            } else if (this.dsJ != 0) {
                this.dsy.seekTo(this.dsJ);
                this.dsJ = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0466a extends com.baidu.swan.videoplayer.a.b {
        private C0466a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, "ended", new JSONObject());
            if (a.this.dsF != null) {
                a.this.dsF.b(a.this);
            }
            a.this.dsC = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void f(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aJV().aJI();
            a.this.aJV().aJJ();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.jD(i2));
            if (a.this.dsE != null) {
                a.this.dsE.a(a.this, i, i2);
            }
            a.this.dsC = false;
            int currentPosition = a.this.aJU().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.dsJ;
            }
            aVar.dsJ = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aJW();
            a.this.aJS();
            if (a.this.dsD != null) {
                a.this.dsD.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dsC = false;
            a.this.mIsPaused = false;
            a.this.aJV().aJJ();
            if (a.this.dsG != null) {
                a.this.dsG.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dsC = false;
            a.this.mIsPaused = false;
            a.this.aJV().aJJ();
            if (a.this.dsH != null) {
                a.this.dsH.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void gr(boolean z) {
            if (z) {
                a.this.aJO();
            } else {
                a.this.aJP();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.dsI != null) {
                a.this.dsI.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                az(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, "waiting", new JSONObject());
        }

        private void az(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cnG.cjA, a.this.cnG.bPG, "timeupdate", jSONObject);
        }
    }
}
