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
public class j extends c implements a.InterfaceC0473a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener cEp;
    private com.baidu.swan.apps.res.widget.floatlayer.a cEs;
    private boolean cQl;
    private View cVA;
    private com.baidu.swan.games.view.d cVB;
    private com.baidu.swan.games.view.d cVC;
    private TextView cVE;
    private b cVF;
    private a cVG;
    private GameCloseGuidePopView cVI;
    private View cVK;
    private boolean cVL;
    private DuMixGameSurfaceView cVv;
    private ImageView cVw;
    private View cVx;
    private ImageView cVy;
    private FrameLayout cVz;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cVD = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cIc = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cVH = "landscape";
    private boolean cVJ = false;

    public static j atk() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.baY().a(j.this.cUd, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ap(inflate);
        atl();
        return inflate;
    }

    public void ap(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cVz = frameLayout;
        this.cVv = com.baidu.swan.games.j.a.bah().baj();
        if (this.cVv != null && this.cVv.getParent() == null) {
            frameLayout.addView(this.cVv, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aIy()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cVE = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            atw();
        }
        aC(view);
        this.cVC = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cVB = new com.baidu.swan.games.view.d(this.cVz);
    }

    private void atl() {
        if (this.cVv != null) {
            this.cVv.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.atm()) {
                        com.baidu.swan.apps.ao.e.O(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atm() {
        f ajs = ajs();
        return ajs != null && (ajs.asT() instanceof j);
    }

    private void aC(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cVw = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cVx = view.findViewById(a.f.titlebar_right_menu_line);
        this.cVy = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cVw.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cVy.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cVx.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.arB();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.cVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aIw()) {
                    if (com.baidu.swan.apps.runtime.e.aMk() != null && com.baidu.swan.apps.p.c.azj().azk()) {
                        j.this.nA("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b aze = new com.baidu.swan.apps.p.b().aze();
                    if (aze.isShow()) {
                        com.baidu.swan.apps.p.c.azj().a(j.this.mActivity, aze.getImageUrl(), aze.azi(), j.this.arS());
                        return;
                    }
                    j.this.nA("exitButton");
                }
            }
        });
    }

    public boolean nA(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.b.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.b.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                ato();
            }
            return false;
        }
        this.cVK = com.baidu.swan.games.m.a.bba().a(this.mActivity, atn());
        if (this.cVK != null) {
            this.cVz.addView(this.cVK);
            this.cVL = true;
            com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
            return true;
        }
        if (this.cVI == null) {
            this.cVI = new GameCloseGuidePopView(getContext());
            this.cVI.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void atz() {
                    if (j.this.cVI != null) {
                        j.this.cVz.removeView(j.this.cVI);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void atA() {
                    j.this.ato();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void atB() {
                    j.this.ato();
                }
            });
        }
        this.cVz.addView(this.cVI);
        com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a arS() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void asv() {
                j.this.ato();
            }
        };
    }

    private GameCloseGuidePopView.a atn() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void atz() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void atA() {
                if (j.this.cVK != null) {
                    j.this.cVz.removeView(j.this.cVK);
                    j.this.cVK = null;
                }
                j.this.ato();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void atB() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ato() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).hD(1);
        ap.aSa().lQ(2);
    }

    private void atp() {
        if (ah.dO(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.aAr(), a.h.aiapps_game_not_support_split_screen).aLS();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        atp();
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
    public com.baidu.swan.games.u.a.b.a atq() {
        return this.cVD;
    }

    @NonNull
    public com.baidu.swan.games.view.b atr() {
        return this.cIc;
    }

    public com.baidu.swan.games.view.d ats() {
        return this.cVC;
    }

    public com.baidu.swan.games.view.d att() {
        return this.cVB;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cVv != null && this.cVv.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cVv.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cVv.onResume();
            com.baidu.swan.games.audio.b.b.aXK().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).aju()));
            }
            v8Engine.onResume();
            if (this.cVz != null && this.cVA != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cVz.removeView(j.this.cVA);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cVB.bcT()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cVB.ip(isLandScape);
                    this.cVC.ip(isLandScape);
                }
                com.baidu.swan.apps.ao.e.O(this.mActivity);
            }
            if (this.cEp == null) {
                this.cEp = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cVB.bcT()) {
                            if (260 < i && i < 280 && j.this.cVH != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cVH = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cVH);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cVH);
                                }
                            } else if (80 < i && i < 100 && j.this.cVH != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cVH = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cVH);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cVH);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cEp.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cEp.enable();
            } else {
                this.cEp.disable();
            }
            com.baidu.swan.games.b.d.aXm().startMonitor();
            com.baidu.swan.apps.media.b.gb(true);
            if (this.cVB != null) {
                this.cVB.azI();
            }
            if (this.cVC != null) {
                this.cVC.azI();
            }
            atp();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cVA == null) {
            this.cVA = new View(this.mActivity);
        }
        this.cVz.removeView(this.cVA);
        this.cVz.addView(this.cVA, new FrameLayout.LayoutParams(-1, -1));
        if (this.cVI != null) {
            this.cVz.removeView(this.cVI);
            this.cVI = null;
        }
        if (this.cVB != null) {
            this.cVB.azH();
        }
        if (this.cVC != null) {
            this.cVC.azH();
        }
        if (this.cVv != null && this.cVv.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cVv.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aZL()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aZG = v8Engine.aZG();
                if (aZG instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aZG).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aXK().pauseAll();
            com.baidu.swan.games.b.d.aXm().aXo();
            com.baidu.swan.apps.media.b.gb(false);
            this.cVv.onPause();
            if (this.cEp != null) {
                this.cEp.disable();
            }
            if (this.cUg != null && this.cUg.isShowing()) {
                this.cUg.dismiss(false);
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
            apV();
        }
        if (this.cVv != null) {
            this.cVv.setOnSystemUiVisibilityChangeListener(null);
            this.cVv.onDestroy();
        }
        if (this.cVL) {
            this.cVK = null;
            com.baidu.swan.games.m.a.bba().release();
        }
        if (this.cVB != null) {
            this.cVB.onPageDestroy();
        }
        if (this.cVC != null) {
            this.cVC.onPageDestroy();
        }
        this.cIc.ano();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ig(false);
        com.baidu.swan.games.glsurface.a.b.baH();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arB() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        amS();
        if (com.baidu.swan.apps.runtime.e.aMl() != null) {
            this.cUg.setScreenOrientation(com.baidu.swan.apps.runtime.e.aMl().aMo().getOrientation());
        }
        this.cUg.a(com.baidu.swan.apps.t.a.aAN().alD(), asq(), this.cUh, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amM() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean arC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aml() {
        if (com.baidu.m.a.afg()) {
            return com.baidu.m.a.afg();
        }
        if (com.baidu.swan.apps.runtime.e.aMk() != null && com.baidu.swan.apps.p.c.azj().azk()) {
            return nA("backButton");
        }
        com.baidu.swan.apps.p.b aze = new com.baidu.swan.apps.p.b().aze();
        if (aze.isShow()) {
            com.baidu.swan.apps.p.c.azj().a(this.mActivity, aze.getImageUrl(), aze.azi(), arS());
            return true;
        }
        return nA("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amS() {
        FragmentActivity bhA = bhA();
        if (bhA != null) {
            if (this.cVJ) {
                if (this.cUg != null && this.cUg.isShowing()) {
                    this.cUg.dismiss(false);
                }
                this.cUg = null;
                this.cVJ = false;
            }
            if (this.cUh == null) {
                this.cUh = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cUg == null) {
                this.cUg = new com.baidu.swan.menu.g(bhA, this.mMenu, 0, com.baidu.swan.apps.t.a.aAv(), new com.baidu.swan.apps.view.c.b());
                this.cUg.nh(com.baidu.swan.apps.ao.e.aRc());
                this.cVD.b(this.cUg);
                com.baidu.swan.games.q.a aDu = com.baidu.swan.apps.v.f.aDG().aDu();
                if (aDu != null) {
                    aDu.a(this.cUg);
                }
                new com.baidu.swan.apps.menu.a(this.cUg, this, this.cUh).aFx();
            }
        }
    }

    public com.baidu.swan.menu.g atu() {
        return this.cUg;
    }

    public void ft(boolean z) {
        this.cVJ = z;
    }

    public boolean atv() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void arF() {
        if (this.cVv != null && this.cVv.getV8Engine() != null) {
            this.cVv.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void atw() {
        if (this.cQl) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cQl = true;
        this.cVF = new b();
        this.cVF.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void apV() {
        if (!this.cQl) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cQl = false;
        if (this.cVF != null) {
            this.cVF.removeMessages(0);
            this.cVF = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0473a
    public com.baidu.swan.apps.res.widget.floatlayer.a ajn() {
        if (this.cEs == null && this.cVC != null && this.cVC.bcS() != null) {
            this.cEs = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cVC.bcS(), 0);
        }
        return this.cEs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cVE != null) {
                String valueOf = String.valueOf(j.this.cVv == null ? 0 : j.this.cVv.getFPS());
                j.this.cVE.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cVF.sendEmptyMessageDelayed(0, 500L);
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
                    if (!j.this.atx()) {
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
        if (!atx() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cVG == null) {
                this.cVG = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cVG, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cVG != null) {
                this.mAudioManager.abandonAudioFocus(this.cVG);
                this.mAudioManager = null;
                this.cVG = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atx() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        boolean booleanValue = aMk != null ? aMk.aMC().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aty() {
        return this.mMenu;
    }
}
