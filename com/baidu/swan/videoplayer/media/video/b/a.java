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
/* loaded from: classes6.dex */
public class a implements j {
    private static final boolean DEBUG = b.DEBUG;
    private c dcZ;
    private boolean dhP;
    private FrameLayout emS;
    private SwanVideoView emZ;
    private VideoContainerManager ena;
    private int enb;
    private boolean enc;
    private j.d ene;
    private j.b enf;
    private j.a eng;
    private j.e enh;
    private j.f eni;
    private j.c enj;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int enk = 0;

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
        this.dcZ = cVar;
        bet();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.ene = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.enf = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eng = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.enh = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eni = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.enj = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bes().setVideoPath(this.dcZ.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void f(FrameLayout frameLayout) {
        this.emS = frameLayout;
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
        this.dcZ = cVar;
        if (z) {
            ii(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.dcZ == null) {
            return false;
        }
        return (this.dcZ.ddd == cVar.ddd && this.dcZ.ddl == cVar.ddl && TextUtils.equals(this.dcZ.ddg, cVar.ddg) && this.dcZ.ddt == cVar.ddt && this.dcZ.ddq == cVar.ddq && this.dcZ.ddr == cVar.ddr && this.dcZ.dds == cVar.dds && this.dcZ.mDirection == cVar.mDirection && this.dcZ.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        bes().setMuted(cVar.ddd);
        bes().setMediaControllerEnabled(cVar.ddl);
        bes().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.ddg, "cover")) {
            bes().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.ddg, "fill")) {
            bes().setVideoScalingMode(3);
        } else {
            bes().setVideoScalingMode(1);
        }
    }

    private void ii(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.emZ != null && !z && isPlaying()) {
            this.emZ.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cZa);
        k(cVar);
        this.dcZ = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        beo();
        bep();
        bet().dz(cVar.dde, cVar.ddg);
    }

    public void j(c cVar) {
        bet().e(cVar);
        ber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bem() {
        final Activity activity;
        e aGM = e.aGM();
        if (aGM == null || (activity = aGM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.aa(activity);
                SwanAppComponentContainerView bei = a.this.bet().bei();
                bei.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.bd(bei);
                d.attachDecor(activity, bei);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, true, a.this.bet());
            }
        });
        this.mIsLandscape = true;
        this.emZ.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ben() {
        Activity activity;
        e aGM = e.aGM();
        if (aGM == null || (activity = aGM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.bd(a.this.bet().bei());
                a.this.bet().akf();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, false, a.this.bet());
            }
        });
        this.mIsLandscape = false;
        this.emZ.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.dcZ != null && cVar != null && !TextUtils.isEmpty(this.dcZ.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.dcZ.mSrc, cVar.mSrc)) {
            this.enc = true;
        } else {
            this.enc = false;
        }
    }

    private void beo() {
        if (this.emZ != null) {
            this.emZ.stopPlayback();
        }
    }

    private void bep() {
        bet().f(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (aAR()) {
            bet().beg();
            reset();
            bes().bdV();
            i(this.dcZ);
            a(this.dcZ, false);
            g(this.dcZ);
            bes().start();
            this.enc = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        bes().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.enc) {
            bes().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (aAR()) {
            if (!this.enc) {
                bes().seekTo(i);
            } else {
                this.enb = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return bes().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return bes().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.dhP;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void j(boolean z, int i) {
        if (z) {
            bem();
        } else {
            ben();
        }
    }

    private void initListener() {
        bes().setVideoPlayerCallback(new C0566a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.emZ == null) {
            return false;
        }
        return this.emZ.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && ben();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void axy() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oR(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void ber() {
        if (this.emZ != null) {
            d.bd(this.emZ);
            if (this.emS != null) {
                this.emS.addView(this.emZ);
            } else {
                bet().getVideoHolder().addView(this.emZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bes() {
        if (this.emZ == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.emZ = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.emZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bet() {
        if (this.dcZ == null) {
            com.baidu.swan.apps.component.e.a.bl("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.ena == null) {
            this.ena = new VideoContainerManager(this.mContext, this.dcZ);
        }
        return this.ena;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        bes().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void fv(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bes().release();
    }

    public void reset() {
        if (this.emZ != null) {
            this.emZ.stopPlayback();
            d.bd(this.emZ);
            this.emZ = null;
        }
    }

    private boolean aAR() {
        return (this.dcZ == null || TextUtils.isEmpty(this.dcZ.mSrc) || TextUtils.isEmpty(this.dcZ.cZa) || TextUtils.isEmpty(this.dcZ.cCa)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beu() {
        if (aAR()) {
            if (this.enb != 0) {
                bes().seekTo(this.enb);
                this.enb = 0;
            } else if (this.dcZ.ddf != 0) {
                this.emZ.seekTo(this.dcZ.ddf * 1000);
                this.dcZ.ddf = 0;
            } else if (this.enk != 0) {
                this.emZ.seekTo(this.enk);
                this.enk = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0566a extends com.baidu.swan.videoplayer.a.b {
        private C0566a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, "ended", new JSONObject());
            if (a.this.eng != null) {
                a.this.eng.b(a.this);
            }
            a.this.dhP = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bet().beg();
            a.this.bet().beh();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.no(i2));
            if (a.this.enf != null) {
                a.this.enf.a(a.this, i, i2);
            }
            a.this.dhP = false;
            int currentPosition = a.this.bes().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.enk;
            }
            aVar.enk = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.beu();
            a.this.beq();
            if (a.this.ene != null) {
                a.this.ene.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dhP = false;
            a.this.mIsPaused = false;
            a.this.bet().beh();
            if (a.this.enh != null) {
                a.this.enh.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.dhP = false;
            a.this.mIsPaused = false;
            a.this.bet().beh();
            if (a.this.eni != null) {
                a.this.eni.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        /* renamed from: if */
        public void mo36if(boolean z) {
            if (z) {
                a.this.bem();
            } else {
                a.this.ben();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.enj != null) {
                a.this.enj.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.dcZ.cZa, a.this.dcZ.cCb, "timeupdate", jSONObject);
        }
    }
}
