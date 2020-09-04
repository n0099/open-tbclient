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
    private OrientationEventListener bRG;
    private com.baidu.swan.apps.res.widget.floatlayer.a bRJ;
    private boolean cdv;
    private DuMixGameSurfaceView ciH;
    private ImageView ciI;
    private View ciJ;
    private ImageView ciK;
    private FrameLayout ciL;
    private View ciM;
    private com.baidu.swan.games.view.d ciN;
    private com.baidu.swan.games.view.d ciO;
    private TextView ciQ;
    private b ciR;
    private a ciS;
    private GameCloseGuidePopView ciU;
    private View ciW;
    private boolean ciX;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a ciP = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bVq = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String ciT = "landscape";
    private boolean ciV = false;

    public static j ahD() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aOt().a(j.this.chq, j.this.getContext());
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
        this.ciL = frameLayout;
        this.ciH = com.baidu.swan.games.j.a.aNC().aNE();
        if (this.ciH != null && this.ciH.getParent() == null) {
            frameLayout.addView(this.ciH, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.awR()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.ciQ = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            ahP();
        }
        an(view);
        this.ciO = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.ciN = new com.baidu.swan.games.view.d(this.ciL);
    }

    private void ahE() {
        if (this.ciH != null) {
            this.ciH.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
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
        this.ciI = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.ciJ = view.findViewById(a.f.titlebar_right_menu_line);
        this.ciK = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.ciI.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.ciK.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.ciJ.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.ciI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.aga();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.ciK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.awP()) {
                    if (com.baidu.swan.apps.runtime.e.azI() != null && com.baidu.swan.apps.p.c.anB().anC()) {
                        j.this.lt("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
                    if (anw.isShow()) {
                        com.baidu.swan.apps.p.c.anB().a(j.this.mActivity, anw.getImageUrl(), anw.anA(), j.this.agr());
                        return;
                    }
                    j.this.lt("exitButton");
                }
            }
        });
    }

    public boolean lt(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                ahH();
            }
            return false;
        }
        this.ciW = com.baidu.swan.games.m.a.aOv().a(this.mActivity, ahG());
        if (this.ciW != null) {
            this.ciL.addView(this.ciW);
            this.ciX = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.ciU == null) {
            this.ciU = new GameCloseGuidePopView(getContext());
            this.ciU.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ahS() {
                    if (j.this.ciU != null) {
                        j.this.ciL.removeView(j.this.ciU);
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
        this.ciL.addView(this.ciU);
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
                if (j.this.ciW != null) {
                    j.this.ciL.removeView(j.this.ciW);
                    j.this.ciW = null;
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
        return this.ciP;
    }

    @NonNull
    public com.baidu.swan.games.view.b ahK() {
        return this.bVq;
    }

    public com.baidu.swan.games.view.d ahL() {
        return this.ciO;
    }

    public com.baidu.swan.games.view.d ahM() {
        return this.ciN;
    }

    public void resume() {
        requestAudioFocus();
        if (this.ciH != null && this.ciH.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.ciH.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.ciH.onResume();
            com.baidu.swan.games.audio.b.b.aLf().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).XZ()));
            }
            v8Engine.onResume();
            if (this.ciL != null && this.ciM != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.ciL.removeView(j.this.ciM);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.ciN.aQo()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.ciN.gP(isLandScape);
                    this.ciO.gP(isLandScape);
                }
                com.baidu.swan.apps.ap.e.L(this.mActivity);
            }
            if (this.bRG == null) {
                this.bRG = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.ciN.aQo()) {
                            if (260 < i && i < 280 && j.this.ciT != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.ciT = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ciT);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ciT);
                                }
                            } else if (80 < i && i < 100 && j.this.ciT != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.ciT = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ciT);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ciT);
                                }
                            }
                        }
                    }
                };
            }
            if (this.bRG.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bRG.enable();
            } else {
                this.bRG.disable();
            }
            com.baidu.swan.games.b.d.aKH().startMonitor();
            com.baidu.swan.apps.media.b.eK(true);
            if (this.ciN != null) {
                this.ciN.aoa();
            }
            if (this.ciO != null) {
                this.ciO.aoa();
            }
            ahI();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.ciM == null) {
            this.ciM = new View(this.mActivity);
        }
        this.ciL.removeView(this.ciM);
        this.ciL.addView(this.ciM, new FrameLayout.LayoutParams(-1, -1));
        if (this.ciU != null) {
            this.ciL.removeView(this.ciU);
            this.ciU = null;
        }
        if (this.ciN != null) {
            this.ciN.anZ();
        }
        if (this.ciO != null) {
            this.ciO.anZ();
        }
        if (this.ciH != null && this.ciH.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.ciH.getV8Engine();
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
            com.baidu.swan.apps.media.b.eK(false);
            this.ciH.onPause();
            if (this.bRG != null) {
                this.bRG.disable();
            }
            if (this.cht != null && this.cht.isShowing()) {
                this.cht.dismiss(false);
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
        if (this.ciH != null) {
            this.ciH.setOnSystemUiVisibilityChangeListener(null);
            this.ciH.onDestroy();
        }
        if (this.ciX) {
            this.ciW = null;
            com.baidu.swan.games.m.a.aOv().release();
        }
        if (this.ciN != null) {
            this.ciN.aQr();
        }
        if (this.ciO != null) {
            this.ciO.aQr();
        }
        this.bVq.abP();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.gG(false);
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
            this.cht.setScreenOrientation(com.baidu.swan.apps.runtime.e.azJ().azM().getOrientation());
        }
        this.cht.a(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ(), this.chu, false);
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
            return lt("backButton");
        }
        com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
        if (anw.isShow()) {
            com.baidu.swan.apps.p.c.anB().a(this.mActivity, anw.getImageUrl(), anw.anA(), agr());
            return true;
        }
        return lt("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (aUT != null) {
            if (this.ciV) {
                if (this.cht != null && this.cht.isShowing()) {
                    this.cht.dismiss(false);
                }
                this.cht = null;
                this.ciV = false;
            }
            if (this.chu == null) {
                this.chu = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cht == null) {
                this.cht = new com.baidu.swan.menu.h(aUT, this.mMenu, 0, com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
                this.cht.lB(com.baidu.swan.apps.ap.e.aEz());
                this.ciP.b(this.cht);
                com.baidu.swan.games.q.a arM = com.baidu.swan.apps.v.f.arY().arM();
                if (arM != null) {
                    arM.a(this.cht);
                }
                new com.baidu.swan.apps.menu.a(this.cht, this, this.chu).atP();
            }
        }
    }

    public com.baidu.swan.menu.h ahN() {
        return this.cht;
    }

    public void ec(boolean z) {
        this.ciV = z;
    }

    public boolean ahO() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        if (this.ciH != null && this.ciH.getV8Engine() != null) {
            this.ciH.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void ahP() {
        if (this.cdv) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cdv = true;
        this.ciR = new b();
        this.ciR.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void aet() {
        if (!this.cdv) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cdv = false;
        if (this.ciR != null) {
            this.ciR.removeMessages(0);
            this.ciR = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0432a
    public com.baidu.swan.apps.res.widget.floatlayer.a XS() {
        if (this.bRJ == null && this.ciO != null && this.ciO.aQn() != null) {
            this.bRJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.ciO.aQn(), 0);
        }
        return this.bRJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.ciQ != null) {
                String valueOf = String.valueOf(j.this.ciH == null ? 0 : j.this.ciH.getFPS());
                j.this.ciQ.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.ciR.sendEmptyMessageDelayed(0, 500L);
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
            if (this.ciS == null) {
                this.ciS = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.ciS, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.ciS != null) {
                this.mAudioManager.abandonAudioFocus(this.ciS);
                this.mAudioManager = null;
                this.ciS = null;
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
