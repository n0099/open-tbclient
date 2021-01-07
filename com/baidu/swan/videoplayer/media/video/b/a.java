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
/* loaded from: classes3.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c doZ;
    private boolean dtQ;
    private FrameLayout eDB;
    private SwanVideoView eDI;
    private VideoContainerManager eDJ;
    private int eDK;
    private boolean eDL;
    private j.d eDM;
    private j.b eDN;
    private j.a eDO;
    private j.e eDP;
    private j.f eDQ;
    private j.c eDR;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eDS = 0;

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
        this.doZ = cVar;
        bjV();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eDM = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eDN = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eDO = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eDP = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eDQ = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eDR = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bjU().setVideoPath(this.doZ.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.eDB = frameLayout;
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
        this.doZ = cVar;
        if (z) {
            iS(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.doZ == null) {
            return false;
        }
        return (this.doZ.mMute == cVar.mMute && this.doZ.dpk == cVar.dpk && TextUtils.equals(this.doZ.dpf, cVar.dpf) && this.doZ.dpt == cVar.dpt && this.doZ.dpq == cVar.dpq && this.doZ.dpr == cVar.dpr && this.doZ.dps == cVar.dps && this.doZ.mDirection == cVar.mDirection && this.doZ.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bjU().setMuted(cVar.mMute);
        bjU().setMediaControllerEnabled(cVar.dpk);
        bjU().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.dpf, "cover")) {
            bjU().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.dpf, "fill")) {
            bjU().setVideoScalingMode(3);
        } else {
            bjU().setVideoScalingMode(1);
        }
    }

    private void iS(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eDI != null && !z && isPlaying()) {
            this.eDI.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.dkT);
        k(cVar);
        this.doZ = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bjQ();
        bjR();
        bjV().dF(cVar.dpd, cVar.dpf);
    }

    public void j(c cVar) {
        bjV().e(cVar);
        bjT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjO() {
        final Activity activity;
        e aMl = e.aMl();
        if (aMl == null || (activity = aMl.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ac(activity);
                SwanAppComponentContainerView bjK = a.this.bjV().bjK();
                bjK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bo(bjK);
                d.attachDecor(activity, bjK);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, true, a.this.bjV());
            }
        });
        this.mIsLandscape = true;
        this.eDI.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjP() {
        Activity activity;
        e aMl = e.aMl();
        if (aMl == null || (activity = aMl.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bo(a.this.bjV().bjK());
                a.this.bjV().aox();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, false, a.this.bjV());
            }
        });
        this.mIsLandscape = false;
        this.eDI.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.doZ != null && cVar != null && !TextUtils.isEmpty(this.doZ.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.doZ.mSrc, cVar.mSrc)) {
            this.eDL = true;
        } else {
            this.eDL = false;
        }
    }

    private void bjQ() {
        if (this.eDI != null) {
            this.eDI.stopPlayback();
        }
    }

    private void bjR() {
        bjV().g(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aFu()) {
            bjV().bjI();
            reset();
            bjU().bjy();
            i(this.doZ);
            a(this.doZ, false);
            g(this.doZ);
            bjU().start();
            this.eDL = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bjU().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eDL) {
            bjU().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aFu()) {
            if (!this.eDL) {
                bjU().seekTo(i);
            } else {
                this.eDK = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bjU().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bjU().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.dtQ;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            bjO();
        } else {
            bjP();
        }
    }

    private void initListener() {
        bjU().setVideoPlayerCallback(new C0569a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjS() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eDI == null) {
            return false;
        }
        return this.eDI.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bjP();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void aBZ() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pr(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bjT() {
        if (this.eDI != null) {
            d.bo(this.eDI);
            if (this.eDB != null) {
                this.eDB.addView(this.eDI);
            } else {
                bjV().getVideoHolder().addView(this.eDI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bjU() {
        if (this.eDI == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eDI = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eDI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bjV() {
        if (this.doZ == null) {
            com.baidu.swan.apps.component.e.a.br("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eDJ == null) {
            this.eDJ = new VideoContainerManager(this.mContext, this.doZ);
        }
        return this.eDJ;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bjU().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fT(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bjU().release();
    }

    public void reset() {
        if (this.eDI != null) {
            this.eDI.stopPlayback();
            d.bo(this.eDI);
            this.eDI = null;
        }
    }

    private boolean aFu() {
        return (this.doZ == null || TextUtils.isEmpty(this.doZ.mSrc) || TextUtils.isEmpty(this.doZ.dkT) || TextUtils.isEmpty(this.doZ.cNO)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjW() {
        if (aFu()) {
            if (this.eDK != 0) {
                bjU().seekTo(this.eDK);
                this.eDK = 0;
            } else if (this.doZ.dpe != 0) {
                this.eDI.seekTo(this.doZ.dpe * 1000);
                this.doZ.dpe = 0;
            } else if (this.eDS != 0) {
                this.eDI.seekTo(this.eDS);
                this.eDS = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0569a extends com.baidu.swan.videoplayer.a.b {
        private C0569a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, "ended", new JSONObject());
            if (a.this.eDO != null) {
                a.this.eDO.b(a.this);
            }
            a.this.dtQ = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bjV().bjI();
            a.this.bjV().bjJ();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.nV(i2));
            if (a.this.eDN != null) {
                a.this.eDN.a(a.this, i, i2);
            }
            a.this.dtQ = false;
            int currentPosition = a.this.bjU().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eDS;
            }
            aVar.eDS = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bjW();
            a.this.bjS();
            if (a.this.eDM != null) {
                a.this.eDM.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dtQ = false;
            a.this.mIsPaused = false;
            a.this.bjV().bjJ();
            if (a.this.eDP != null) {
                a.this.eDP.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dtQ = false;
            a.this.mIsPaused = false;
            a.this.bjV().bjJ();
            if (a.this.eDQ != null) {
                a.this.eDQ.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void iP(boolean z) {
            if (z) {
                a.this.bjO();
            } else {
                a.this.bjP();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eDR != null) {
                a.this.eDR.e(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void h(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aH(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, "waiting", new JSONObject());
        }

        private void aH(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.doZ.dkT, a.this.doZ.cNP, "timeupdate", jSONObject);
        }
    }
}
