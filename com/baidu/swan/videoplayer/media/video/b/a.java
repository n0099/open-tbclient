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
    private c cQp;
    private boolean cVd;
    private j.f eaA;
    private j.c eaB;
    private FrameLayout eal;
    private SwanVideoView eas;
    private VideoContainerManager eat;
    private int eau;
    private boolean eav;
    private j.d eaw;
    private j.b eax;
    private j.a eay;
    private j.e eaz;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eaC = 0;

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
        this.cQp = cVar;
        baH();
        return this;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.d dVar) {
        this.eaw = dVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.b bVar) {
        this.eax = bVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.a aVar) {
        this.eay = aVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.e eVar) {
        this.eaz = eVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.f fVar) {
        this.eaA = fVar;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(j.c cVar) {
        this.eaB = cVar;
    }

    private void g(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        baG().setVideoPath(this.cQp.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void c(FrameLayout frameLayout) {
        this.eal = frameLayout;
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
        this.cQp = cVar;
        if (z) {
            hJ(cVar.isVisible());
        }
        j(cVar);
    }

    private boolean h(c cVar) {
        if (this.cQp == null) {
            return false;
        }
        return (this.cQp.cQt == cVar.cQt && this.cQp.cQB == cVar.cQB && TextUtils.equals(this.cQp.cQw, cVar.cQw) && this.cQp.cQJ == cVar.cQJ && this.cQp.cQG == cVar.cQG && this.cQp.cQH == cVar.cQH && this.cQp.cQI == cVar.cQI && this.cQp.mDirection == cVar.mDirection && this.cQp.mLoop == cVar.mLoop) ? false : true;
    }

    private void i(c cVar) {
        baG().setMuted(cVar.cQt);
        baG().setMediaControllerEnabled(cVar.cQB);
        baG().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cQw, "cover")) {
            baG().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cQw, "fill")) {
            baG().setVideoScalingMode(3);
        } else {
            baG().setVideoScalingMode(1);
        }
    }

    private void hJ(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eas != null && !z && isPlaying()) {
            this.eas.pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.cMu);
        k(cVar);
        this.cQp = cVar;
        j(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        baC();
        baD();
        baH().dt(cVar.cQu, cVar.cQw);
    }

    public void j(c cVar) {
        baH().e(cVar);
        baF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baA() {
        final Activity activity;
        e aDa = e.aDa();
        if (aDa == null || (activity = aDa.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ab(activity);
                SwanAppComponentContainerView baw = a.this.baH().baw();
                baw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                d.aY(baw);
                d.attachDecor(activity, baw);
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, true, a.this.baH());
            }
        });
        this.mIsLandscape = true;
        this.eas.setIsLandscape(this.mIsLandscape);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baB() {
        Activity activity;
        e aDa = e.aDa();
        if (aDa == null || (activity = aDa.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                d.aY(a.this.baH().baw());
                a.this.baH().agt();
                com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, false, a.this.baH());
            }
        });
        this.mIsLandscape = false;
        this.eas.setIsLandscape(this.mIsLandscape);
        return true;
    }

    private void k(c cVar) {
        if (this.cQp != null && cVar != null && !TextUtils.isEmpty(this.cQp.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cQp.mSrc, cVar.mSrc)) {
            this.eav = true;
        } else {
            this.eav = false;
        }
    }

    private void baC() {
        if (this.eas != null) {
            this.eas.stopPlayback();
        }
    }

    private void baD() {
        baH().e(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.media.video.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (axf()) {
            baH().bau();
            reset();
            baG().baj();
            i(this.cQp);
            a(this.cQp, false);
            g(this.cQp);
            baG().start();
            this.eav = false;
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void pause() {
        baG().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void resume() {
        if (this.mIsPaused && !this.eav) {
            baG().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void seekTo(int i) {
        if (axf()) {
            if (!this.eav) {
                baG().seekTo(i);
            } else {
                this.eau = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getDuration() {
        return baG().getDuration();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public int getCurrentPosition() {
        return baG().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isEnd() {
        return this.cVd;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void j(boolean z, int i) {
        if (z) {
            baA();
        } else {
            baB();
        }
    }

    private void initListener() {
        baG().setVideoPlayerCallback(new C0542a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baE() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean isPlaying() {
        if (this.eas == null) {
            return false;
        }
        return this.eas.isPlaying();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public boolean onBackPressed() {
        return isLandscape() && baB();
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void atM() {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void oq(String str) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void b(c cVar) {
    }

    private void baF() {
        if (this.eas != null) {
            d.aY(this.eas);
            if (this.eal != null) {
                this.eal.addView(this.eas);
            } else {
                baH().getVideoHolder().addView(this.eas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView baG() {
        if (this.eas == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eas = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager baH() {
        if (this.cQp == null) {
            com.baidu.swan.apps.component.e.a.bf("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eat == null) {
            this.eat = new VideoContainerManager(this.mContext, this.cQp);
        }
        return this.eat;
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void mute(boolean z) {
        baG().setMuted(z);
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void eW(boolean z) {
    }

    @Override // com.baidu.swan.apps.t.b.j
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        baG().release();
    }

    public void reset() {
        if (this.eas != null) {
            this.eas.stopPlayback();
            d.aY(this.eas);
            this.eas = null;
        }
    }

    private boolean axf() {
        return (this.cQp == null || TextUtils.isEmpty(this.cQp.mSrc) || TextUtils.isEmpty(this.cQp.cMu) || TextUtils.isEmpty(this.cQp.cpp)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baI() {
        if (axf()) {
            if (this.eau != 0) {
                baG().seekTo(this.eau);
                this.eau = 0;
            } else if (this.cQp.cQv != 0) {
                this.eas.seekTo(this.cQp.cQv * 1000);
                this.cQp.cQv = 0;
            } else if (this.eaC != 0) {
                this.eas.seekTo(this.eaC);
                this.eaC = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.videoplayer.media.video.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0542a extends com.baidu.swan.videoplayer.a.b {
        private C0542a() {
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, "ended", new JSONObject());
            if (a.this.eay != null) {
                a.this.eay.b(a.this);
            }
            a.this.cVd = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onError(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.baH().bau();
            a.this.baH().bav();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, BdStatsConstant.StatsType.ERROR, com.baidu.swan.videoplayer.media.a.a.a.mX(i2));
            if (a.this.eax != null) {
                a.this.eax.a(a.this, i, i2);
            }
            a.this.cVd = false;
            int currentPosition = a.this.baG().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eaC;
            }
            aVar.eaC = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.baI();
            a.this.baE();
            if (a.this.eaw != null) {
                a.this.eaw.a(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onResume() {
            super.onResume();
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cVd = false;
            a.this.mIsPaused = false;
            a.this.baH().bav();
            if (a.this.eaz != null) {
                a.this.eaz.c(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onStart() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new JSONObject());
            a.this.cVd = false;
            a.this.mIsPaused = false;
            a.this.baH().bav();
            if (a.this.eaA != null) {
                a.this.eaA.d(a.this);
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void hG(boolean z) {
            if (z) {
                a.this.baA();
            } else {
                a.this.baB();
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b, com.baidu.swan.videoplayer.a.a
        public void onPause() {
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, "pause", new JSONObject());
            com.baidu.swan.apps.console.c.d("video", "onPaused call back");
            a.this.mIsPaused = true;
            if (a.this.eaB != null) {
                a.this.eaB.e(a.this);
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, "waiting", new JSONObject());
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
            com.baidu.swan.videoplayer.media.video.a.a.a(a.this.cQp.cMu, a.this.cQp.cpq, "timeupdate", jSONObject);
        }
    }
}
