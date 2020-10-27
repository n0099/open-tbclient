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
    private c cYL;
    private boolean ddD;
    private FrameLayout eiI;
    private SwanVideoView eiP;
    private VideoContainerManager eiQ;
    private int eiR;
    private boolean eiS;
    private j.d eiT;
    private j.b eiU;
    private j.a eiV;
    private j.e eiW;
    private j.f eiX;
    private j.c eiY;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eiZ = 0;

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
        this.cYL = cVar;
        bcA();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eiT = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eiU = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eiV = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eiW = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eiX = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eiY = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bcz().setVideoPath(this.cYL.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void c(FrameLayout frameLayout) {
        this.eiI = frameLayout;
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
        this.cYL = cVar;
        if (z) {
            hW(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cYL == null) {
            return false;
        }
        return (this.cYL.cYP == cVar.cYP && this.cYL.cYX == cVar.cYX && TextUtils.equals(this.cYL.cYS, cVar.cYS) && this.cYL.cZf == cVar.cZf && this.cYL.cZc == cVar.cZc && this.cYL.cZd == cVar.cZd && this.cYL.cZe == cVar.cZe && this.cYL.mDirection == cVar.mDirection && this.cYL.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bcz().setMuted(cVar.cYP);
        bcz().setMediaControllerEnabled(cVar.cYX);
        bcz().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cYS, "cover")) {
            bcz().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cYS, "fill")) {
            bcz().setVideoScalingMode(3);
        } else {
            bcz().setVideoScalingMode(1);
        }
    }

    private void hW(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eiP != null && !z && isPlaying()) {
            this.eiP.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cUQ);
        k(cVar);
        this.cYL = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bcv();
        bcw();
        bcA().dA(cVar.cYQ, cVar.cYS);
    }

    public void j(c cVar) {
        bcA().e(cVar);
        bcy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bct() {
        final Activity activity;
        e aEU = e.aEU();
        if (aEU == null || (activity = aEU.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ab(activity);
                SwanAppComponentContainerView bcp = a.this.bcA().bcp();
                bcp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aZ(bcp);
                d.attachDecor(activity, bcp);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, true, a.this.bcA());
            }
        });
        this.mIsLandscape = true;
        this.eiP.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bcu() {
        Activity activity;
        e aEU = e.aEU();
        if (aEU == null || (activity = aEU.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aZ(a.this.bcA().bcp());
                a.this.bcA().ain();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, false, a.this.bcA());
            }
        });
        this.mIsLandscape = false;
        this.eiP.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cYL != null && cVar != null && !TextUtils.isEmpty(this.cYL.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cYL.mSrc, cVar.mSrc)) {
            this.eiS = true;
        } else {
            this.eiS = false;
        }
    }

    private void bcv() {
        if (this.eiP != null) {
            this.eiP.stopPlayback();
        }
    }

    private void bcw() {
        bcA().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (ayZ()) {
            bcA().bcn();
            reset();
            bcz().bcc();
            i(this.cYL);
            a(this.cYL, false);
            g(this.cYL);
            bcz().start();
            this.eiS = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bcz().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eiS) {
            bcz().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (ayZ()) {
            if (!this.eiS) {
                bcz().seekTo(i);
            } else {
                this.eiR = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bcz().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bcz().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.ddD;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void j(boolean z, int i) {
        if (z) {
            bct();
        } else {
            bcu();
        }
    }

    private void initListener() {
        bcz().setVideoPlayerCallback(new C0556a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eiP == null) {
            return false;
        }
        return this.eiP.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bcu();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void avG() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oJ(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bcy() {
        if (this.eiP != null) {
            d.aZ(this.eiP);
            if (this.eiI != null) {
                this.eiI.addView(this.eiP);
            } else {
                bcA().getVideoHolder().addView(this.eiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bcz() {
        if (this.eiP == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eiP = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eiP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bcA() {
        if (this.cYL == null) {
            com.baidu.swan.apps.component.e.a.bm("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eiQ == null) {
            this.eiQ = new VideoContainerManager(this.mContext, this.cYL);
        }
        return this.eiQ;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bcz().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fj(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bcz().release();
    }

    public void reset() {
        if (this.eiP != null) {
            this.eiP.stopPlayback();
            d.aZ(this.eiP);
            this.eiP = null;
        }
    }

    private boolean ayZ() {
        return (this.cYL == null || TextUtils.isEmpty(this.cYL.mSrc) || TextUtils.isEmpty(this.cYL.cUQ) || TextUtils.isEmpty(this.cYL.cxR)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcB() {
        if (ayZ()) {
            if (this.eiR != 0) {
                bcz().seekTo(this.eiR);
                this.eiR = 0;
            } else if (this.cYL.cYR != 0) {
                this.eiP.seekTo(this.cYL.cYR * 1000);
                this.cYL.cYR = 0;
            } else if (this.eiZ != 0) {
                this.eiP.seekTo(this.eiZ);
                this.eiZ = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0556a extends com.baidu.swan.videoplayer.a.b {
        private C0556a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, "ended", new JSONObject());
            if (a.this.eiV != null) {
                a.this.eiV.b(a.this);
            }
            a.this.ddD = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bcA().bcn();
            a.this.bcA().bco();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.ni(i2));
            if (a.this.eiU != null) {
                a.this.eiU.a(a.this, i, i2);
            }
            a.this.ddD = false;
            int currentPosition = a.this.bcz().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eiZ;
            }
            aVar.eiZ = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bcB();
            a.this.bcx();
            if (a.this.eiT != null) {
                a.this.eiT.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.ddD = false;
            a.this.mIsPaused = false;
            a.this.bcA().bco();
            if (a.this.eiW != null) {
                a.this.eiW.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.ddD = false;
            a.this.mIsPaused = false;
            a.this.bcA().bco();
            if (a.this.eiX != null) {
                a.this.eiX.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void hT(boolean z) {
            if (z) {
                a.this.bct();
            } else {
                a.this.bcu();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eiY != null) {
                a.this.eiY.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cYL.cUQ, a.this.cYL.cxS, "timeupdate", jSONObject);
        }
    }
}
