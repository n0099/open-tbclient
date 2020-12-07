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
/* loaded from: classes25.dex */
public class j extends c implements a.InterfaceC0480a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cLq;
    private View cQA;
    private ImageView cQB;
    private FrameLayout cQC;
    private View cQD;
    private com.baidu.swan.games.view.d cQE;
    private com.baidu.swan.games.view.d cQF;
    private TextView cQH;
    private b cQI;
    private a cQJ;
    private GameCloseGuidePopView cQL;
    private View cQN;
    private boolean cQO;
    private DuMixGameSurfaceView cQy;
    private ImageView cQz;
    private OrientationEventListener czB;
    private com.baidu.swan.apps.res.widget.floatlayer.a czE;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cQG = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cDm = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cQK = "landscape";
    private boolean cQM = false;

    public static j arS() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aYE().a(j.this.cPi, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        an(inflate);
        arT();
        return inflate;
    }

    public void an(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cQC = frameLayout;
        this.cQy = com.baidu.swan.games.j.a.aXN().aXP();
        if (this.cQy != null && this.cQy.getParent() == null) {
            frameLayout.addView(this.cQy, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aHf()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cQH = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            ase();
        }
        ax(view);
        this.cQF = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cQE = new com.baidu.swan.games.view.d(this.cQC);
    }

    private void arT() {
        if (this.cQy != null) {
            this.cQy.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.arU()) {
                        com.baidu.swan.apps.ap.e.N(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arU() {
        f aim = aim();
        return aim != null && (aim.arB() instanceof j);
    }

    private void ax(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cQz = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cQA = view.findViewById(a.f.titlebar_right_menu_line);
        this.cQB = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cQz.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cQB.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cQA.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.aqp();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.cQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aHd()) {
                    if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.p.c.axS().axT()) {
                        j.this.nH("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b axN = new com.baidu.swan.apps.p.b().axN();
                    if (axN.isShow()) {
                        com.baidu.swan.apps.p.c.axS().a(j.this.mActivity, axN.getImageUrl(), axN.axR(), j.this.aqG());
                        return;
                    }
                    j.this.nH("exitButton");
                }
            }
        });
    }

    public boolean nH(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                arW();
            }
            return false;
        }
        this.cQN = com.baidu.swan.games.m.a.aYG().a(this.mActivity, arV());
        if (this.cQN != null) {
            this.cQC.addView(this.cQN);
            this.cQO = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.cQL == null) {
            this.cQL = new GameCloseGuidePopView(getContext());
            this.cQL.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ash() {
                    if (j.this.cQL != null) {
                        j.this.cQC.removeView(j.this.cQL);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void asi() {
                    j.this.arW();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void asj() {
                    j.this.arW();
                }
            });
        }
        this.cQC.addView(this.cQL);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aqG() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void ard() {
                j.this.arW();
            }
        };
    }

    private GameCloseGuidePopView.a arV() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void ash() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void asi() {
                if (j.this.cQN != null) {
                    j.this.cQC.removeView(j.this.cQN);
                    j.this.cQN = null;
                }
                j.this.arW();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void asj() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).hJ(1);
        ap.aPI().lL(2);
    }

    private void arX() {
        if (ah.dv(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.t(com.baidu.swan.apps.t.a.aza(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        arX();
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
    public com.baidu.swan.games.u.a.b.a arY() {
        return this.cQG;
    }

    @NonNull
    public com.baidu.swan.games.view.b arZ() {
        return this.cDm;
    }

    public com.baidu.swan.games.view.d asa() {
        return this.cQF;
    }

    public com.baidu.swan.games.view.d asb() {
        return this.cQE;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cQy != null && this.cQy.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cQy.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cQy.onResume();
            com.baidu.swan.games.audio.b.b.aVq().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).aio()));
            }
            v8Engine.onResume();
            if (this.cQC != null && this.cQD != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cQC.removeView(j.this.cQD);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cQE.baA()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cQE.hX(isLandScape);
                    this.cQF.hX(isLandScape);
                }
                com.baidu.swan.apps.ap.e.N(this.mActivity);
            }
            if (this.czB == null) {
                this.czB = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cQE.baA()) {
                            if (260 < i && i < 280 && j.this.cQK != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cQK = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cQK);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cQK);
                                }
                            } else if (80 < i && i < 100 && j.this.cQK != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cQK = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cQK);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cQK);
                                }
                            }
                        }
                    }
                };
            }
            if (this.czB.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.czB.enable();
            } else {
                this.czB.disable();
            }
            com.baidu.swan.games.b.d.aUS().startMonitor();
            com.baidu.swan.apps.media.b.fS(true);
            if (this.cQE != null) {
                this.cQE.ayr();
            }
            if (this.cQF != null) {
                this.cQF.ayr();
            }
            arX();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cQD == null) {
            this.cQD = new View(this.mActivity);
        }
        this.cQC.removeView(this.cQD);
        this.cQC.addView(this.cQD, new FrameLayout.LayoutParams(-1, -1));
        if (this.cQL != null) {
            this.cQC.removeView(this.cQL);
            this.cQL = null;
        }
        if (this.cQE != null) {
            this.cQE.ayq();
        }
        if (this.cQF != null) {
            this.cQF.ayq();
        }
        if (this.cQy != null && this.cQy.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cQy.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aXr()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aXm = v8Engine.aXm();
                if (aXm instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aXm).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aVq().pauseAll();
            com.baidu.swan.games.b.d.aUS().aUU();
            com.baidu.swan.apps.media.b.fS(false);
            this.cQy.onPause();
            if (this.czB != null) {
                this.czB.disable();
            }
            if (this.cPl != null && this.cPl.isShowing()) {
                this.cPl.dismiss(false);
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
            aoI();
        }
        if (this.cQy != null) {
            this.cQy.setOnSystemUiVisibilityChangeListener(null);
            this.cQy.onDestroy();
        }
        if (this.cQO) {
            this.cQN = null;
            com.baidu.swan.games.m.a.aYG().release();
        }
        if (this.cQE != null) {
            this.cQE.baD();
        }
        if (this.cQF != null) {
            this.cQF.baD();
        }
        this.cDm.ame();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.hO(false);
        com.baidu.swan.games.glsurface.a.b.aYn();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        alI();
        if (com.baidu.swan.apps.runtime.e.aJV() != null) {
            this.cPl.setScreenOrientation(com.baidu.swan.apps.runtime.e.aJV().aJY().getOrientation());
        }
        this.cPl.a(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState(), aqY(), this.cPm, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        if (com.baidu.m.a.adk()) {
            return com.baidu.m.a.adk();
        }
        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.p.c.axS().axT()) {
            return nH("backButton");
        }
        com.baidu.swan.apps.p.b axN = new com.baidu.swan.apps.p.b().axN();
        if (axN.isShow()) {
            com.baidu.swan.apps.p.c.axS().a(this.mActivity, axN.getImageUrl(), axN.axR(), aqG());
            return true;
        }
        return nH("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
        FragmentActivity bff = bff();
        if (bff != null) {
            if (this.cQM) {
                if (this.cPl != null && this.cPl.isShowing()) {
                    this.cPl.dismiss(false);
                }
                this.cPl = null;
                this.cQM = false;
            }
            if (this.cPm == null) {
                this.cPm = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cPl == null) {
                this.cPl = new com.baidu.swan.menu.h(bff, this.mMenu, 0, com.baidu.swan.apps.t.a.aze(), new com.baidu.swan.apps.view.c.b());
                this.cPl.mY(com.baidu.swan.apps.ap.e.aOL());
                this.cQG.b(this.cPl);
                com.baidu.swan.games.q.a aCd = com.baidu.swan.apps.v.f.aCp().aCd();
                if (aCd != null) {
                    aCd.a(this.cPl);
                }
                new com.baidu.swan.apps.menu.a(this.cPl, this, this.cPm).aEe();
            }
        }
    }

    public com.baidu.swan.menu.h asc() {
        return this.cPl;
    }

    public void fk(boolean z) {
        this.cQM = z;
    }

    public boolean asd() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aqt() {
        if (this.cQy != null && this.cQy.getV8Engine() != null) {
            this.cQy.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void ase() {
        if (this.cLq) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cLq = true;
        this.cQI = new b();
        this.cQI.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void aoI() {
        if (!this.cLq) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cLq = false;
        if (this.cQI != null) {
            this.cQI.removeMessages(0);
            this.cQI = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0480a
    public com.baidu.swan.apps.res.widget.floatlayer.a aih() {
        if (this.czE == null && this.cQF != null && this.cQF.baz() != null) {
            this.czE = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cQF.baz(), 0);
        }
        return this.czE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cQH != null) {
                String valueOf = String.valueOf(j.this.cQy == null ? 0 : j.this.cQy.getFPS());
                j.this.cQH.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cQI.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.asf()) {
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
        if (!asf() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cQJ == null) {
                this.cQJ = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cQJ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cQJ != null) {
                this.mAudioManager.abandonAudioFocus(this.cQJ);
                this.mAudioManager = null;
                this.cQJ = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asf() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        boolean booleanValue = aJU != null ? aJU.aKm().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View asg() {
        return this.mMenu;
    }
}
