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
/* loaded from: classes8.dex */
public class j extends c implements a.InterfaceC0432a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener bRC;
    private com.baidu.swan.apps.res.widget.floatlayer.a bRF;
    private boolean cdr;
    private DuMixGameSurfaceView ciD;
    private ImageView ciE;
    private View ciF;
    private ImageView ciG;
    private FrameLayout ciH;
    private View ciI;
    private com.baidu.swan.games.view.d ciJ;
    private com.baidu.swan.games.view.d ciK;
    private TextView ciM;
    private b ciN;
    private a ciO;
    private GameCloseGuidePopView ciQ;
    private View ciS;
    private boolean ciT;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a ciL = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bVm = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String ciP = "landscape";
    private boolean ciR = false;

    public static j ahD() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aOt().a(j.this.chm, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ak(inflate);
        ahE();
        return inflate;
    }

    public void ak(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.ciH = frameLayout;
        this.ciD = com.baidu.swan.games.j.a.aNC().aNE();
        if (this.ciD != null && this.ciD.getParent() == null) {
            frameLayout.addView(this.ciD, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.awR()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.ciM = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            ahP();
        }
        an(view);
        this.ciK = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.ciJ = new com.baidu.swan.games.view.d(this.ciH);
    }

    private void ahE() {
        if (this.ciD != null) {
            this.ciD.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.ahF()) {
                        com.baidu.swan.apps.ap.e.L(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahF() {
        f XX = XX();
        return XX != null && (XX.ahm() instanceof j);
    }

    private void an(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.ciE = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.ciF = view.findViewById(a.f.titlebar_right_menu_line);
        this.ciG = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.ciE.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.ciG.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.ciF.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.ciE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.aga();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.ciG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.awP()) {
                    if (com.baidu.swan.apps.runtime.e.azI() != null && com.baidu.swan.apps.p.c.anB().anC()) {
                        j.this.ls("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
                    if (anw.isShow()) {
                        com.baidu.swan.apps.p.c.anB().a(j.this.mActivity, anw.getImageUrl(), anw.anA(), j.this.agr());
                        return;
                    }
                    j.this.ls("exitButton");
                }
            }
        });
    }

    public boolean ls(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                ahH();
            }
            return false;
        }
        this.ciS = com.baidu.swan.games.m.a.aOv().a(this.mActivity, ahG());
        if (this.ciS != null) {
            this.ciH.addView(this.ciS);
            this.ciT = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.ciQ == null) {
            this.ciQ = new GameCloseGuidePopView(getContext());
            this.ciQ.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ahS() {
                    if (j.this.ciQ != null) {
                        j.this.ciH.removeView(j.this.ciQ);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ahT() {
                    j.this.ahH();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ahU() {
                    j.this.ahH();
                }
            });
        }
        this.ciH.addView(this.ciQ);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a agr() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void agO() {
                j.this.ahH();
            }
        };
    }

    private GameCloseGuidePopView.a ahG() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void ahS() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void ahT() {
                if (j.this.ciS != null) {
                    j.this.ciH.removeView(j.this.ciS);
                    j.this.ciS = null;
                }
                j.this.ahH();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void ahU() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahH() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).gn(1);
        ap.aFx().ko(2);
    }

    private void ahI() {
        if (ah.cK(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.aoJ(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ahI();
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
    public com.baidu.swan.games.u.a.b.a ahJ() {
        return this.ciL;
    }

    @NonNull
    public com.baidu.swan.games.view.b ahK() {
        return this.bVm;
    }

    public com.baidu.swan.games.view.d ahL() {
        return this.ciK;
    }

    public com.baidu.swan.games.view.d ahM() {
        return this.ciJ;
    }

    public void resume() {
        requestAudioFocus();
        if (this.ciD != null && this.ciD.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.ciD.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.ciD.onResume();
            com.baidu.swan.games.audio.b.b.aLf().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).XZ()));
            }
            v8Engine.onResume();
            if (this.ciH != null && this.ciI != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.ciH.removeView(j.this.ciI);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.ciJ.aQo()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.ciJ.gO(isLandScape);
                    this.ciK.gO(isLandScape);
                }
                com.baidu.swan.apps.ap.e.L(this.mActivity);
            }
            if (this.bRC == null) {
                this.bRC = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.ciJ.aQo()) {
                            if (260 < i && i < 280 && j.this.ciP != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.ciP = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ciP);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ciP);
                                }
                            } else if (80 < i && i < 100 && j.this.ciP != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.ciP = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ciP);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ciP);
                                }
                            }
                        }
                    }
                };
            }
            if (this.bRC.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bRC.enable();
            } else {
                this.bRC.disable();
            }
            com.baidu.swan.games.b.d.aKH().startMonitor();
            com.baidu.swan.apps.media.b.eJ(true);
            if (this.ciJ != null) {
                this.ciJ.aoa();
            }
            if (this.ciK != null) {
                this.ciK.aoa();
            }
            ahI();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.ciI == null) {
            this.ciI = new View(this.mActivity);
        }
        this.ciH.removeView(this.ciI);
        this.ciH.addView(this.ciI, new FrameLayout.LayoutParams(-1, -1));
        if (this.ciQ != null) {
            this.ciH.removeView(this.ciQ);
            this.ciQ = null;
        }
        if (this.ciJ != null) {
            this.ciJ.anZ();
        }
        if (this.ciK != null) {
            this.ciK.anZ();
        }
        if (this.ciD != null && this.ciD.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.ciD.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aNg()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aNb = v8Engine.aNb();
                if (aNb instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aNb).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aLf().pauseAll();
            com.baidu.swan.games.b.d.aKH().aKJ();
            com.baidu.swan.apps.media.b.eJ(false);
            this.ciD.onPause();
            if (this.bRC != null) {
                this.bRC.disable();
            }
            if (this.chp != null && this.chp.isShowing()) {
                this.chp.dismiss(false);
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
            aet();
        }
        if (this.ciD != null) {
            this.ciD.setOnSystemUiVisibilityChangeListener(null);
            this.ciD.onDestroy();
        }
        if (this.ciT) {
            this.ciS = null;
            com.baidu.swan.games.m.a.aOv().release();
        }
        if (this.ciJ != null) {
            this.ciJ.aQr();
        }
        if (this.ciK != null) {
            this.ciK.aQr();
        }
        this.bVm.abP();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.gF(false);
        com.baidu.swan.games.glsurface.a.b.aOc();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        abt();
        if (com.baidu.swan.apps.runtime.e.azJ() != null) {
            this.chp.setScreenOrientation(com.baidu.swan.apps.runtime.e.azJ().azM().getOrientation());
        }
        this.chp.a(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ(), this.chq, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if (com.baidu.l.a.TM()) {
            return com.baidu.l.a.TM();
        }
        if (com.baidu.swan.apps.runtime.e.azI() != null && com.baidu.swan.apps.p.c.anB().anC()) {
            return ls("backButton");
        }
        com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
        if (anw.isShow()) {
            com.baidu.swan.apps.p.c.anB().a(this.mActivity, anw.getImageUrl(), anw.anA(), agr());
            return true;
        }
        return ls("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (aUT != null) {
            if (this.ciR) {
                if (this.chp != null && this.chp.isShowing()) {
                    this.chp.dismiss(false);
                }
                this.chp = null;
                this.ciR = false;
            }
            if (this.chq == null) {
                this.chq = new SwanAppMenuHeaderView(getContext());
            }
            if (this.chp == null) {
                this.chp = new com.baidu.swan.menu.h(aUT, this.mMenu, 0, com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
                this.chp.lB(com.baidu.swan.apps.ap.e.aEz());
                this.ciL.b(this.chp);
                com.baidu.swan.games.q.a arM = com.baidu.swan.apps.v.f.arY().arM();
                if (arM != null) {
                    arM.a(this.chp);
                }
                new com.baidu.swan.apps.menu.a(this.chp, this, this.chq).atP();
            }
        }
    }

    public com.baidu.swan.menu.h ahN() {
        return this.chp;
    }

    public void eb(boolean z) {
        this.ciR = z;
    }

    public boolean ahO() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        if (this.ciD != null && this.ciD.getV8Engine() != null) {
            this.ciD.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void ahP() {
        if (this.cdr) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cdr = true;
        this.ciN = new b();
        this.ciN.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void aet() {
        if (!this.cdr) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cdr = false;
        if (this.ciN != null) {
            this.ciN.removeMessages(0);
            this.ciN = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0432a
    public com.baidu.swan.apps.res.widget.floatlayer.a XS() {
        if (this.bRF == null && this.ciK != null && this.ciK.aQn() != null) {
            this.bRF = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.ciK.aQn(), 0);
        }
        return this.bRF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.ciM != null) {
                String valueOf = String.valueOf(j.this.ciD == null ? 0 : j.this.ciD.getFPS());
                j.this.ciM.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.ciN.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.ahQ()) {
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
        if (!ahQ() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.ciO == null) {
                this.ciO = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.ciO, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.ciO != null) {
                this.mAudioManager.abandonAudioFocus(this.ciO);
                this.mAudioManager = null;
                this.ciO = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahQ() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        boolean booleanValue = azI != null ? azI.aAa().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View ahR() {
        return this.mMenu;
    }
}
