package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes9.dex */
public class j extends c implements a.InterfaceC0453a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener cBZ;
    private com.baidu.swan.apps.res.widget.floatlayer.a cCc;
    private boolean cNN;
    private DuMixGameSurfaceView cSW;
    private ImageView cSX;
    private View cSY;
    private ImageView cSZ;
    private FrameLayout cTa;
    private View cTb;
    private com.baidu.swan.games.view.d cTc;
    private com.baidu.swan.games.view.d cTd;
    private TextView cTf;
    private b cTg;
    private a cTh;
    private GameCloseGuidePopView cTj;
    private View cTl;
    private boolean cTm;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cTe = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cFM = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cTi = "landscape";
    private boolean cTk = false;

    public static j apO() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aXr().a(j.this.cRF, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        am(inflate);
        apP();
        return inflate;
    }

    public void am(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cTa = frameLayout;
        this.cSW = com.baidu.swan.games.j.a.aWA().aWC();
        if (this.cSW != null && this.cSW.getParent() == null) {
            frameLayout.addView(this.cSW, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aFa()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cTf = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            aqa();
        }
        ay(view);
        this.cTd = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cTc = new com.baidu.swan.games.view.d(this.cTa);
    }

    private void apP() {
        if (this.cSW != null) {
            this.cSW.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.apQ()) {
                        com.baidu.swan.apps.ao.e.I(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apQ() {
        f afX = afX();
        return afX != null && (afX.apx() instanceof j);
    }

    private void ay(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cSX = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cSY = view.findViewById(a.f.titlebar_right_menu_line);
        this.cSZ = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cSX.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cSZ.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cSY.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.aof();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.cSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aEY()) {
                    if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.p.c.avO().avP()) {
                        j.this.mH("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b avJ = new com.baidu.swan.apps.p.b().avJ();
                    if (avJ.isShow()) {
                        com.baidu.swan.apps.p.c.avO().a(j.this.mActivity, avJ.getImageUrl(), avJ.avN(), j.this.aow());
                        return;
                    }
                    j.this.mH("exitButton");
                }
            }
        });
    }

    public boolean mH(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.b.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.b.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                apS();
            }
            return false;
        }
        this.cTl = com.baidu.swan.games.m.a.aXt().a(this.mActivity, apR());
        if (this.cTl != null) {
            this.cTa.addView(this.cTl);
            this.cTm = true;
            com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
            return true;
        }
        if (this.cTj == null) {
            this.cTj = new GameCloseGuidePopView(getContext());
            this.cTj.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqd() {
                    if (j.this.cTj != null) {
                        j.this.cTa.removeView(j.this.cTj);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqe() {
                    j.this.apS();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqf() {
                    j.this.apS();
                }
            });
        }
        this.cTa.addView(this.cTj);
        com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aow() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void aoY() {
                j.this.apS();
            }
        };
    }

    private GameCloseGuidePopView.a apR() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqd() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqe() {
                if (j.this.cTl != null) {
                    j.this.cTa.removeView(j.this.cTl);
                    j.this.cTl = null;
                }
                j.this.apS();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqf() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apS() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).fZ(1);
        ap.aOA().kn(2);
    }

    private void apT() {
        if (ah.dM(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.awW(), a.h.aiapps_game_not_support_split_screen).aIs();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        apT();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (DEBUG) {
            Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (isAdded()) {
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    @Override // com.baidu.swan.games.u.a.b.b
    @NonNull
    public com.baidu.swan.games.u.a.b.a apU() {
        return this.cTe;
    }

    @NonNull
    public com.baidu.swan.games.view.b apV() {
        return this.cFM;
    }

    public com.baidu.swan.games.view.d apW() {
        return this.cTd;
    }

    public com.baidu.swan.games.view.d apX() {
        return this.cTc;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cSW != null && this.cSW.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cSW.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cSW.onResume();
            com.baidu.swan.games.audio.b.b.aUd().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).afZ()));
            }
            v8Engine.onResume();
            if (this.cTa != null && this.cTb != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cTa.removeView(j.this.cTb);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cTc.aZm()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cTc.in(isLandScape);
                    this.cTd.in(isLandScape);
                }
                com.baidu.swan.apps.ao.e.I(this.mActivity);
            }
            if (this.cBZ == null) {
                this.cBZ = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cTc.aZm()) {
                            if (260 < i && i < 280 && j.this.cTi != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cTi = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cTi);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cTi);
                                }
                            } else if (80 < i && i < 100 && j.this.cTi != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cTi = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cTi);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cTi);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cBZ.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cBZ.enable();
            } else {
                this.cBZ.disable();
            }
            com.baidu.swan.games.b.d.aTF().startMonitor();
            com.baidu.swan.apps.media.b.fZ(true);
            if (this.cTc != null) {
                this.cTc.awn();
            }
            if (this.cTd != null) {
                this.cTd.awn();
            }
            apT();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cTb == null) {
            this.cTb = new View(this.mActivity);
        }
        this.cTa.removeView(this.cTb);
        this.cTa.addView(this.cTb, new FrameLayout.LayoutParams(-1, -1));
        if (this.cTj != null) {
            this.cTa.removeView(this.cTj);
            this.cTj = null;
        }
        if (this.cTc != null) {
            this.cTc.awm();
        }
        if (this.cTd != null) {
            this.cTd.awm();
        }
        if (this.cSW != null && this.cSW.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cSW.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aWe()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aVZ = v8Engine.aVZ();
                if (aVZ instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aVZ).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aUd().pauseAll();
            com.baidu.swan.games.b.d.aTF().aTH();
            com.baidu.swan.apps.media.b.fZ(false);
            this.cSW.onPause();
            if (this.cBZ != null) {
                this.cBZ.disable();
            }
            if (this.cRI != null && this.cRI.isShowing()) {
                this.cRI.dismiss(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onResume() obj: " + this);
        }
        super.onResume();
        if (getUserVisibleHint()) {
            resume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onPause() obj: " + this);
        }
        super.onPause();
        if (getUserVisibleHint()) {
            pause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onDestroy() obj: " + this);
            amz();
        }
        if (this.cSW != null) {
            this.cSW.setOnSystemUiVisibilityChangeListener(null);
            this.cSW.onDestroy();
        }
        if (this.cTm) {
            this.cTl = null;
            com.baidu.swan.games.m.a.aXt().release();
        }
        if (this.cTc != null) {
            this.cTc.onPageDestroy();
        }
        if (this.cTd != null) {
            this.cTd.onPageDestroy();
        }
        this.cFM.ajT();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ie(false);
        com.baidu.swan.games.glsurface.a.b.aXa();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        ajx();
        if (com.baidu.swan.apps.runtime.e.aIL() != null) {
            this.cRI.setScreenOrientation(com.baidu.swan.apps.runtime.e.aIL().aIO().getOrientation());
        }
        this.cRI.a(com.baidu.swan.apps.t.a.axs().aii(), aoT(), this.cRJ, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aog() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        if (com.baidu.k.a.adc()) {
            return com.baidu.k.a.adc();
        }
        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.p.c.avO().avP()) {
            return mH("backButton");
        }
        com.baidu.swan.apps.p.b avJ = new com.baidu.swan.apps.p.b().avJ();
        if (avJ.isShow()) {
            com.baidu.swan.apps.p.c.avO().a(this.mActivity, avJ.getImageUrl(), avJ.avN(), aow());
            return true;
        }
        return mH("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajx() {
        FragmentActivity bdU = bdU();
        if (bdU != null) {
            if (this.cTk) {
                if (this.cRI != null && this.cRI.isShowing()) {
                    this.cRI.dismiss(false);
                }
                this.cRI = null;
                this.cTk = false;
            }
            if (this.cRJ == null) {
                this.cRJ = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cRI == null) {
                this.cRI = new com.baidu.swan.menu.g(bdU, this.mMenu, 0, com.baidu.swan.apps.t.a.axa(), new com.baidu.swan.apps.view.c.b());
                this.cRI.lE(com.baidu.swan.apps.ao.e.aNC());
                this.cTe.b(this.cRI);
                com.baidu.swan.games.q.a azZ = com.baidu.swan.apps.v.f.aAl().azZ();
                if (azZ != null) {
                    azZ.a(this.cRI);
                }
                new com.baidu.swan.apps.menu.a(this.cRI, this, this.cRJ).aCb();
            }
        }
    }

    public com.baidu.swan.menu.g apY() {
        return this.cRI;
    }

    public void fr(boolean z) {
        this.cTk = z;
    }

    public boolean apZ() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aoj() {
        if (this.cSW != null && this.cSW.getV8Engine() != null) {
            this.cSW.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void aqa() {
        if (this.cNN) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cNN = true;
        this.cTg = new b();
        this.cTg.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void amz() {
        if (!this.cNN) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cNN = false;
        if (this.cTg != null) {
            this.cTg.removeMessages(0);
            this.cTg = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0453a
    public com.baidu.swan.apps.res.widget.floatlayer.a afS() {
        if (this.cCc == null && this.cTd != null && this.cTd.aZl() != null) {
            this.cCc = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cTd.aZl(), 0);
        }
        return this.cCc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cTf != null) {
                String valueOf = String.valueOf(j.this.cSW == null ? 0 : j.this.cSW.getFPS());
                j.this.cTf.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cTg.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.aqb()) {
                        switch (i) {
                            case -2:
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                j.this.abandonAudioFocus();
                                return;
                            case -1:
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                j.this.abandonAudioFocus();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void requestAudioFocus() {
        if (!aqb() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cTh == null) {
                this.cTh = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cTh, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cTh != null) {
                this.mAudioManager.abandonAudioFocus(this.cTh);
                this.mAudioManager = null;
                this.cTh = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqb() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        boolean booleanValue = aIK != null ? aIK.aJc().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aqc() {
        return this.mMenu;
    }
}
