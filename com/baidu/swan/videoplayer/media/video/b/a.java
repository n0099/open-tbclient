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
    private c cst;
    private FrameLayout dxb;
    private SwanVideoView dxi;
    private VideoContainerManager dxj;
    private int dxk;
    private boolean dxl;
    private boolean dxm;
    private j.d dxn;
    private j.b dxo;
    private j.a dxp;
    private j.e dxq;
    private j.f dxr;
    private j.c dxs;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int dxt = 0;

    @Override // com.baidu.swan.apps.u.b.j
    public void TA() {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void TC() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.j
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cst = cVar;
        aLb();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.d dVar) {
        this.dxn = dVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.b bVar) {
        this.dxo = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.a aVar) {
        this.dxp = aVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.e eVar) {
        this.dxq = eVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.f fVar) {
        this.dxr = fVar;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(j.c cVar) {
        this.dxs = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aLa().setVideoPath(this.cst.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void b(FrameLayout frameLayout) {
        this.dxb = frameLayout;
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
        this.cst = cVar;
        if (z) {
            gA(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cst == null) {
            return false;
        }
        return (this.cst.csx == cVar.csx && this.cst.csF == cVar.csF && TextUtils.equals(this.cst.csA, cVar.csA) && this.cst.csN == cVar.csN && this.cst.csK == cVar.csK && this.cst.csL == cVar.csL && this.cst.csM == cVar.csM && this.cst.mDirection == cVar.mDirection && this.cst.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        aLa().setMuted(cVar.csx);
        aLa().setMediaControllerEnabled(cVar.csF);
        aLa().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.csA, "cover")) {
            aLa().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.csA, "fill")) {
            aLa().setVideoScalingMode(3);
        } else {
            aLa().setVideoScalingMode(1);
        }
    }

    private void gA(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dxi != null && !z && isPlaying()) {
            this.dxi.pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cop);
        k(cVar);
        this.cst = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aKW();
        aKX();
        aLb().cV(cVar.csy, cVar.csA);
    }

    public void j(c cVar) {
        aLb().e(cVar);
        aKZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKU() {
        final Activity activity;
        e apM = e.apM();
        if (apM == null || (activity = apM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Y(activity);
                SwanAppComponentContainerView aKQ = a.this.aLb().aKQ();
                aKQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aO(aKQ);
                d.d(activity, aKQ);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, true, a.this.aLb());
            }
        });
        this.mIsLandscape = true;
        this.dxi.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKV() {
        Activity activity;
        e apM = e.apM();
        if (apM == null || (activity = apM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aO(a.this.aLb().aKQ());
                a.this.aLb().Wm();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, false, a.this.aLb());
            }
        });
        this.mIsLandscape = false;
        this.dxi.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cst != null && cVar != null && !TextUtils.isEmpty(this.cst.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cst.mSrc, cVar.mSrc)) {
            this.dxl = true;
        } else {
            this.dxl = false;
        }
    }

    private void aKW() {
        if (this.dxi != null) {
            this.dxi.stopPlayback();
        }
    }

    private void aKX() {
        aLb().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (akI()) {
            aLb().aKO();
            reset();
            aLa().aKD();
            i(this.cst);
            a(this.cst, false);
            g(this.cst);
            aLa().start();
            this.dxl = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void pause() {
        aLa().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void resume() {
        if (this.mIsPaused && !this.dxl) {
            aLa().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void seekTo(int i) {
        if (akI()) {
            if (!this.dxl) {
                aLa().seekTo(i);
            } else {
                this.dxk = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public int getDuration() {
        return aLa().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public int getCurrentPosition() {
        return aLa().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean isEnd() {
        return this.dxm;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void i(boolean z, int i) {
        if (z) {
            aKU();
        } else {
            aKV();
        }
    }

    private void initListener() {
        aLa().setVideoPlayerCallback(new C0472a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKY() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean isPlaying() {
        if (this.dxi == null) {
            return false;
        }
        return this.dxi.isPlaying();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public boolean onBackPressed() {
        return isLandscape() && aKV();
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void ahs() {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void kO(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void b(c cVar) {
    }

    private void aKZ() {
        if (this.dxi != null) {
            d.aO(this.dxi);
            if (this.dxb != null) {
                this.dxb.addView(this.dxi);
            } else {
                aLb().getVideoHolder().addView(this.dxi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aLa() {
        if (this.dxi == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dxi = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.dxi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aLb() {
        if (this.cst == null) {
            com.baidu.swan.apps.component.e.a.aU("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.dxj == null) {
            this.dxj = new VideoContainerManager(this.mContext, this.cst);
        }
        return this.dxj;
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void eb(boolean z) {
        aLa().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void ec(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aLa().release();
    }

    public void reset() {
        if (this.dxi != null) {
            this.dxi.stopPlayback();
            d.aO(this.dxi);
            this.dxi = null;
        }
    }

    private boolean akI() {
        return (this.cst == null || TextUtils.isEmpty(this.cst.mSrc) || TextUtils.isEmpty(this.cst.cop) || TextUtils.isEmpty(this.cst.bUt)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLc() {
        if (akI()) {
            if (this.dxk != 0) {
                aLa().seekTo(this.dxk);
                this.dxk = 0;
            } else if (this.cst.csz != 0) {
                this.dxi.seekTo(this.cst.csz * 1000);
                this.cst.csz = 0;
            } else if (this.dxt != 0) {
                this.dxi.seekTo(this.dxt);
                this.dxt = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0472a extends com.baidu.swan.videoplayer.a.b {
        private C0472a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, "ended", new JSONObject());
            if (a.this.dxp != null) {
                a.this.dxp.b(a.this);
            }
            a.this.dxm = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void f(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aLb().aKO();
            a.this.aLb().aKP();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.jQ(i2));
            if (a.this.dxo != null) {
                a.this.dxo.a(a.this, i, i2);
            }
            a.this.dxm = false;
            int currentPosition = a.this.aLa().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.dxt;
            }
            aVar.dxt = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aLc();
            a.this.aKY();
            if (a.this.dxn != null) {
                a.this.dxn.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dxm = false;
            a.this.mIsPaused = false;
            a.this.aLb().aKP();
            if (a.this.dxq != null) {
                a.this.dxq.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dxm = false;
            a.this.mIsPaused = false;
            a.this.aLb().aKP();
            if (a.this.dxr != null) {
                a.this.dxr.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void gw(boolean z) {
            if (z) {
                a.this.aKU();
            } else {
                a.this.aKV();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.dxs != null) {
                a.this.dxs.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cst.cop, a.this.cst.bUu, "timeupdate", jSONObject);
        }
    }
}
