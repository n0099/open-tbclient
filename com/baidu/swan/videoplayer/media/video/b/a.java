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
/* loaded from: classes12.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c deI;
    private boolean djz;
    private FrameLayout eoC;
    private SwanVideoView eoJ;
    private VideoContainerManager eoK;
    private int eoL;
    private boolean eoM;
    private j.d eoN;
    private j.b eoO;
    private j.a eoP;
    private j.e eoQ;
    private j.f eoR;
    private j.c eoS;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eoT = 0;

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
        this.deI = cVar;
        bfa();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eoN = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eoO = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eoP = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eoQ = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eoR = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eoS = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        beZ().setVideoPath(this.deI.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.eoC = frameLayout;
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
        this.deI = cVar;
        if (z) {
            m36if(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.deI == null) {
            return false;
        }
        return (this.deI.deM == cVar.deM && this.deI.deU == cVar.deU && TextUtils.equals(this.deI.deP, cVar.deP) && this.deI.dfc == cVar.dfc && this.deI.deZ == cVar.deZ && this.deI.dfa == cVar.dfa && this.deI.dfb == cVar.dfb && this.deI.mDirection == cVar.mDirection && this.deI.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        beZ().setMuted(cVar.deM);
        beZ().setMediaControllerEnabled(cVar.deU);
        beZ().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.deP, "cover")) {
            beZ().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.deP, "fill")) {
            beZ().setVideoScalingMode(3);
        } else {
            beZ().setVideoScalingMode(1);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m36if(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eoJ != null && !z && isPlaying()) {
            this.eoJ.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.daK);
        k(cVar);
        this.deI = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        beV();
        beW();
        bfa().dA(cVar.deN, cVar.deP);
    }

    public void j(c cVar) {
        bfa().e(cVar);
        beY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beT() {
        final Activity activity;
        e aHu = e.aHu();
        if (aHu == null || (activity = aHu.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ab(activity);
                SwanAppComponentContainerView beP = a.this.bfa().beP();
                beP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bd(beP);
                d.attachDecor(activity, beP);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, true, a.this.bfa());
            }
        });
        this.mIsLandscape = true;
        this.eoJ.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beU() {
        Activity activity;
        e aHu = e.aHu();
        if (aHu == null || (activity = aHu.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bd(a.this.bfa().beP());
                a.this.bfa().akN();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, false, a.this.bfa());
            }
        });
        this.mIsLandscape = false;
        this.eoJ.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.deI != null && cVar != null && !TextUtils.isEmpty(this.deI.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.deI.mSrc, cVar.mSrc)) {
            this.eoM = true;
        } else {
            this.eoM = false;
        }
    }

    private void beV() {
        if (this.eoJ != null) {
            this.eoJ.stopPlayback();
        }
    }

    private void beW() {
        bfa().f(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aBz()) {
            bfa().beN();
            reset();
            beZ().beC();
            i(this.deI);
            a(this.deI, false);
            g(this.deI);
            beZ().start();
            this.eoM = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        beZ().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eoM) {
            beZ().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aBz()) {
            if (!this.eoM) {
                beZ().seekTo(i);
            } else {
                this.eoL = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return beZ().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return beZ().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.djz;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void j(boolean z, int i) {
        if (z) {
            beT();
        } else {
            beU();
        }
    }

    private void initListener() {
        beZ().setVideoPlayerCallback(new C0568a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beX() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eoJ == null) {
            return false;
        }
        return this.eoJ.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && beU();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ayg() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oX(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void beY() {
        if (this.eoJ != null) {
            d.bd(this.eoJ);
            if (this.eoC != null) {
                this.eoC.addView(this.eoJ);
            } else {
                bfa().getVideoHolder().addView(this.eoJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView beZ() {
        if (this.eoJ == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eoJ = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eoJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bfa() {
        if (this.deI == null) {
            com.baidu.swan.apps.component.e.a.bm("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eoK == null) {
            this.eoK = new VideoContainerManager(this.mContext, this.deI);
        }
        return this.eoK;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        beZ().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fs(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        beZ().release();
    }

    public void reset() {
        if (this.eoJ != null) {
            this.eoJ.stopPlayback();
            d.bd(this.eoJ);
            this.eoJ = null;
        }
    }

    private boolean aBz() {
        return (this.deI == null || TextUtils.isEmpty(this.deI.mSrc) || TextUtils.isEmpty(this.deI.daK) || TextUtils.isEmpty(this.deI.cDK)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfb() {
        if (aBz()) {
            if (this.eoL != 0) {
                beZ().seekTo(this.eoL);
                this.eoL = 0;
            } else if (this.deI.deO != 0) {
                this.eoJ.seekTo(this.deI.deO * 1000);
                this.deI.deO = 0;
            } else if (this.eoT != 0) {
                this.eoJ.seekTo(this.eoT);
                this.eoT = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0568a extends com.baidu.swan.videoplayer.a.b {
        private C0568a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, "ended", new JSONObject());
            if (a.this.eoP != null) {
                a.this.eoP.b(a.this);
            }
            a.this.djz = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bfa().beN();
            a.this.bfa().beO();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.ns(i2));
            if (a.this.eoO != null) {
                a.this.eoO.a(a.this, i, i2);
            }
            a.this.djz = false;
            int currentPosition = a.this.beZ().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eoT;
            }
            aVar.eoT = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bfb();
            a.this.beX();
            if (a.this.eoN != null) {
                a.this.eoN.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.djz = false;
            a.this.mIsPaused = false;
            a.this.bfa().beO();
            if (a.this.eoQ != null) {
                a.this.eoQ.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.djz = false;
            a.this.mIsPaused = false;
            a.this.bfa().beO();
            if (a.this.eoR != null) {
                a.this.eoR.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void ic(boolean z) {
            if (z) {
                a.this.beT();
            } else {
                a.this.beU();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eoS != null) {
                a.this.eoS.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.deI.daK, a.this.deI.cDL, "timeupdate", jSONObject);
        }
    }
}
