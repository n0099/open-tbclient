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
    private c dkk;
    private boolean dpa;
    private FrameLayout eyP;
    private SwanVideoView eyW;
    private VideoContainerManager eyX;
    private int eyY;
    private boolean eyZ;
    private j.d eza;
    private j.b ezb;
    private j.a ezc;
    private j.e ezd;
    private j.f eze;
    private j.c ezf;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int ezg = 0;

    @Override // com.baidu.swan.apps.t.b.j
    public void Rf() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void Re() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.t.b.j
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.dkk = cVar;
        bgb();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eza = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.ezb = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.ezc = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.ezd = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eze = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.ezf = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bga().setVideoPath(this.dkk.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.eyP = frameLayout;
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
        this.dkk = cVar;
        if (z) {
            iO(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.dkk == null) {
            return false;
        }
        return (this.dkk.mMute == cVar.mMute && this.dkk.dkv == cVar.dkv && TextUtils.equals(this.dkk.dkq, cVar.dkq) && this.dkk.dkD == cVar.dkD && this.dkk.dkA == cVar.dkA && this.dkk.dkB == cVar.dkB && this.dkk.dkC == cVar.dkC && this.dkk.mDirection == cVar.mDirection && this.dkk.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bga().setMuted(cVar.mMute);
        bga().setMediaControllerEnabled(cVar.dkv);
        bga().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.dkq, "cover")) {
            bga().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.dkq, "fill")) {
            bga().setVideoScalingMode(3);
        } else {
            bga().setVideoScalingMode(1);
        }
    }

    private void iO(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eyW != null && !z && isPlaying()) {
            this.eyW.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.dge);
        k(cVar);
        this.dkk = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bfW();
        bfX();
        bgb().dE(cVar.dko, cVar.dkq);
    }

    public void j(c cVar) {
        bgb().e(cVar);
        bfZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfU() {
        final Activity activity;
        e aIr = e.aIr();
        if (aIr == null || (activity = aIr.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ac(activity);
                SwanAppComponentContainerView bfQ = a.this.bgb().bfQ();
                bfQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bo(bfQ);
                d.attachDecor(activity, bfQ);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, true, a.this.bgb());
            }
        });
        this.mIsLandscape = true;
        this.eyW.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfV() {
        Activity activity;
        e aIr = e.aIr();
        if (aIr == null || (activity = aIr.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bo(a.this.bgb().bfQ());
                a.this.bgb().akD();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, false, a.this.bgb());
            }
        });
        this.mIsLandscape = false;
        this.eyW.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.dkk != null && cVar != null && !TextUtils.isEmpty(this.dkk.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.dkk.mSrc, cVar.mSrc)) {
            this.eyZ = true;
        } else {
            this.eyZ = false;
        }
    }

    private void bfW() {
        if (this.eyW != null) {
            this.eyW.stopPlayback();
        }
    }

    private void bfX() {
        bgb().g(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aBA()) {
            bgb().bfO();
            reset();
            bga().bfE();
            i(this.dkk);
            a(this.dkk, false);
            g(this.dkk);
            bga().start();
            this.eyZ = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bga().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eyZ) {
            bga().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aBA()) {
            if (!this.eyZ) {
                bga().seekTo(i);
            } else {
                this.eyY = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bga().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bga().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.dpa;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void i(boolean z, int i) {
        if (z) {
            bfU();
        } else {
            bfV();
        }
    }

    private void initListener() {
        bga().setVideoPlayerCallback(new C0552a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfY() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eyW == null) {
            return false;
        }
        return this.eyW.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && bfV();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void ayf() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oe(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void bfZ() {
        if (this.eyW != null) {
            d.bo(this.eyW);
            if (this.eyP != null) {
                this.eyP.addView(this.eyW);
            } else {
                bgb().getVideoHolder().addView(this.eyW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bga() {
        if (this.eyW == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eyW = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eyW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bgb() {
        if (this.dkk == null) {
            com.baidu.swan.apps.component.e.a.bq("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eyX == null) {
            this.eyX = new VideoContainerManager(this.mContext, this.dkk);
        }
        return this.eyX;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bga().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fP(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bga().release();
    }

    public void reset() {
        if (this.eyW != null) {
            this.eyW.stopPlayback();
            d.bo(this.eyW);
            this.eyW = null;
        }
    }

    private boolean aBA() {
        return (this.dkk == null || TextUtils.isEmpty(this.dkk.mSrc) || TextUtils.isEmpty(this.dkk.dge) || TextUtils.isEmpty(this.dkk.cJc)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgc() {
        if (aBA()) {
            if (this.eyY != 0) {
                bga().seekTo(this.eyY);
                this.eyY = 0;
            } else if (this.dkk.dkp != 0) {
                this.eyW.seekTo(this.dkk.dkp * 1000);
                this.dkk.dkp = 0;
            } else if (this.ezg != 0) {
                this.eyW.seekTo(this.ezg);
                this.ezg = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0552a extends com.baidu.swan.videoplayer.a.b {
        private C0552a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, "ended", new JSONObject());
            if (a.this.ezc != null) {
                a.this.ezc.b(a.this);
            }
            a.this.dpa = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bgb().bfO();
            a.this.bgb().bfP();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.mp(i2));
            if (a.this.ezb != null) {
                a.this.ezb.a(a.this, i, i2);
            }
            a.this.dpa = false;
            int currentPosition = a.this.bga().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.ezg;
            }
            aVar.ezg = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bgc();
            a.this.bfY();
            if (a.this.eza != null) {
                a.this.eza.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dpa = false;
            a.this.mIsPaused = false;
            a.this.bgb().bfP();
            if (a.this.ezd != null) {
                a.this.ezd.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dpa = false;
            a.this.mIsPaused = false;
            a.this.bgb().bfP();
            if (a.this.eze != null) {
                a.this.eze.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void iL(boolean z) {
            if (z) {
                a.this.bfU();
            } else {
                a.this.bfV();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.ezf != null) {
                a.this.ezf.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dkk.dge, a.this.dkk.cJd, "timeupdate", jSONObject);
        }
    }
}
