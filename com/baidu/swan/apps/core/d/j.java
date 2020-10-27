package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class j extends c implements a.InterfaceC0458a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cAn;
    private FrameLayout cFA;
    private View cFB;
    private com.baidu.swan.games.view.d cFC;
    private com.baidu.swan.games.view.d cFD;
    private TextView cFF;
    private b cFG;
    private a cFH;
    private GameCloseGuidePopView cFJ;
    private View cFL;
    private boolean cFM;
    private DuMixGameSurfaceView cFw;
    private ImageView cFx;
    private View cFy;
    private ImageView cFz;
    private OrientationEventListener cou;
    private com.baidu.swan.apps.res.widget.floatlayer.a cox;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cFE = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b csh = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cFI = "landscape";
    private boolean cFK = false;

    public static j amS() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aTH().a(j.this.cEg, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ah(inflate);
        amT();
        return inflate;
    }

    public void ah(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cFA = frameLayout;
        this.cFw = com.baidu.swan.games.j.a.aSQ().aSS();
        if (this.cFw != null && this.cFw.getParent() == null) {
            frameLayout.addView(this.cFw, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aCf()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cFF = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            ane();
        }
        ar(view);
        this.cFD = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cFC = new com.baidu.swan.games.view.d(this.cFA);
    }

    private void amT() {
        if (this.cFw != null) {
            this.cFw.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.amU()) {
                        com.baidu.swan.apps.ap.e.O(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amU() {
        f adm = adm();
        return adm != null && (adm.amB() instanceof j);
    }

    private void ar(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cFx = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cFy = view.findViewById(a.f.titlebar_right_menu_line);
        this.cFz = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cFx.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cFz.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cFy.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.alp();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.cFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aCd()) {
                    if (com.baidu.swan.apps.runtime.e.aEU() != null && com.baidu.swan.apps.p.c.asS().asT()) {
                        j.this.mR("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b asN = new com.baidu.swan.apps.p.b().asN();
                    if (asN.isShow()) {
                        com.baidu.swan.apps.p.c.asS().a(j.this.mActivity, asN.getImageUrl(), asN.asR(), j.this.alG());
                        return;
                    }
                    j.this.mR("exitButton");
                }
            }
        });
    }

    public boolean mR(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                amW();
            }
            return false;
        }
        this.cFL = com.baidu.swan.games.m.a.aTJ().a(this.mActivity, amV());
        if (this.cFL != null) {
            this.cFA.addView(this.cFL);
            this.cFM = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.cFJ == null) {
            this.cFJ = new GameCloseGuidePopView(getContext());
            this.cFJ.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void anh() {
                    if (j.this.cFJ != null) {
                        j.this.cFA.removeView(j.this.cFJ);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ani() {
                    j.this.amW();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void anj() {
                    j.this.amW();
                }
            });
        }
        this.cFA.addView(this.cFJ);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a alG() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void amd() {
                j.this.amW();
            }
        };
    }

    private GameCloseGuidePopView.a amV() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void anh() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void ani() {
                if (j.this.cFL != null) {
                    j.this.cFA.removeView(j.this.cFL);
                    j.this.cFL = null;
                }
                j.this.amW();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void anj() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amW() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).hf(1);
        ap.aKK().lh(2);
    }

    private void amX() {
        if (ah.cP(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.aua(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        amX();
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
    public com.baidu.swan.games.u.a.b.a amY() {
        return this.cFE;
    }

    @NonNull
    public com.baidu.swan.games.view.b amZ() {
        return this.csh;
    }

    public com.baidu.swan.games.view.d ana() {
        return this.cFD;
    }

    public com.baidu.swan.games.view.d anb() {
        return this.cFC;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cFw != null && this.cFw.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cFw.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cFw.onResume();
            com.baidu.swan.games.audio.b.b.aQt().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).ado()));
            }
            v8Engine.onResume();
            if (this.cFA != null && this.cFB != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cFA.removeView(j.this.cFB);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cFC.aVD()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cFC.hw(isLandScape);
                    this.cFD.hw(isLandScape);
                }
                com.baidu.swan.apps.ap.e.O(this.mActivity);
            }
            if (this.cou == null) {
                this.cou = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cFC.aVD()) {
                            if (260 < i && i < 280 && j.this.cFI != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cFI = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cFI);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cFI);
                                }
                            } else if (80 < i && i < 100 && j.this.cFI != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cFI = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cFI);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cFI);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cou.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cou.enable();
            } else {
                this.cou.disable();
            }
            com.baidu.swan.games.b.d.aPV().startMonitor();
            com.baidu.swan.apps.media.b.fr(true);
            if (this.cFC != null) {
                this.cFC.atr();
            }
            if (this.cFD != null) {
                this.cFD.atr();
            }
            amX();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cFB == null) {
            this.cFB = new View(this.mActivity);
        }
        this.cFA.removeView(this.cFB);
        this.cFA.addView(this.cFB, new FrameLayout.LayoutParams(-1, -1));
        if (this.cFJ != null) {
            this.cFA.removeView(this.cFJ);
            this.cFJ = null;
        }
        if (this.cFC != null) {
            this.cFC.atq();
        }
        if (this.cFD != null) {
            this.cFD.atq();
        }
        if (this.cFw != null && this.cFw.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cFw.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aSu()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aSp = v8Engine.aSp();
                if (aSp instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aSp).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aQt().pauseAll();
            com.baidu.swan.games.b.d.aPV().aPX();
            com.baidu.swan.apps.media.b.fr(false);
            this.cFw.onPause();
            if (this.cou != null) {
                this.cou.disable();
            }
            if (this.cEj != null && this.cEj.isShowing()) {
                this.cEj.dismiss(false);
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
            ajI();
        }
        if (this.cFw != null) {
            this.cFw.setOnSystemUiVisibilityChangeListener(null);
            this.cFw.onDestroy();
        }
        if (this.cFM) {
            this.cFL = null;
            com.baidu.swan.games.m.a.aTJ().release();
        }
        if (this.cFC != null) {
            this.cFC.aVG();
        }
        if (this.cFD != null) {
            this.cFD.aVG();
        }
        this.csh.ahe();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.hn(false);
        com.baidu.swan.games.glsurface.a.b.aTq();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        agI();
        if (com.baidu.swan.apps.runtime.e.aEV() != null) {
            this.cEj.setScreenOrientation(com.baidu.swan.apps.runtime.e.aEV().aEY().getOrientation());
        }
        this.cEj.a(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState(), alY(), this.cEk, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        if (com.baidu.l.a.Ym()) {
            return com.baidu.l.a.Ym();
        }
        if (com.baidu.swan.apps.runtime.e.aEU() != null && com.baidu.swan.apps.p.c.asS().asT()) {
            return mR("backButton");
        }
        com.baidu.swan.apps.p.b asN = new com.baidu.swan.apps.p.b().asN();
        if (asN.isShow()) {
            com.baidu.swan.apps.p.c.asS().a(this.mActivity, asN.getImageUrl(), asN.asR(), alG());
            return true;
        }
        return mR("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
        FragmentActivity bah = bah();
        if (bah != null) {
            if (this.cFK) {
                if (this.cEj != null && this.cEj.isShowing()) {
                    this.cEj.dismiss(false);
                }
                this.cEj = null;
                this.cFK = false;
            }
            if (this.cEk == null) {
                this.cEk = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cEj == null) {
                this.cEj = new com.baidu.swan.menu.h(bah, this.mMenu, 0, com.baidu.swan.apps.t.a.aue(), new com.baidu.swan.apps.view.c.b());
                this.cEj.mu(com.baidu.swan.apps.ap.e.aJM());
                this.cFE.b(this.cEj);
                com.baidu.swan.games.q.a axc = com.baidu.swan.apps.v.f.axo().axc();
                if (axc != null) {
                    axc.a(this.cEj);
                }
                new com.baidu.swan.apps.menu.a(this.cEj, this, this.cEk).azd();
            }
        }
    }

    public com.baidu.swan.menu.h anc() {
        return this.cEj;
    }

    public void eJ(boolean z) {
        this.cFK = z;
    }

    public boolean and() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void alt() {
        if (this.cFw != null && this.cFw.getV8Engine() != null) {
            this.cFw.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void ane() {
        if (this.cAn) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cAn = true;
        this.cFG = new b();
        this.cFG.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void ajI() {
        if (!this.cAn) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cAn = false;
        if (this.cFG != null) {
            this.cFG.removeMessages(0);
            this.cFG = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0458a
    public com.baidu.swan.apps.res.widget.floatlayer.a adh() {
        if (this.cox == null && this.cFD != null && this.cFD.aVC() != null) {
            this.cox = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cFD.aVC(), 0);
        }
        return this.cox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cFF != null) {
                String valueOf = String.valueOf(j.this.cFw == null ? 0 : j.this.cFw.getFPS());
                j.this.cFF.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cFG.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.anf()) {
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
        if (!anf() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cFH == null) {
                this.cFH = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cFH, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cFH != null) {
                this.mAudioManager.abandonAudioFocus(this.cFH);
                this.mAudioManager = null;
                this.cFH = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anf() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        boolean booleanValue = aEU != null ? aEU.aFm().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View ang() {
        return this.mMenu;
    }
}
