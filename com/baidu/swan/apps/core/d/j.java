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
/* loaded from: classes3.dex */
public class j extends c implements a.InterfaceC0427a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener bTG;
    private com.baidu.swan.apps.res.widget.floatlayer.a bTJ;
    private boolean cfw;
    private DuMixGameSurfaceView ckI;
    private ImageView ckJ;
    private View ckK;
    private ImageView ckL;
    private FrameLayout ckM;
    private View ckN;
    private com.baidu.swan.games.view.d ckO;
    private com.baidu.swan.games.view.d ckP;
    private TextView ckR;
    private b ckS;
    private a ckT;
    private GameCloseGuidePopView ckV;
    private View ckX;
    private boolean ckY;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a ckQ = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bXr = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String ckU = "landscape";
    private boolean ckW = false;

    public static j ain() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aPe().a(j.this.cjs, j.this.getContext());
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
        aio();
        return inflate;
    }

    public void am(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.ckM = frameLayout;
        this.ckI = com.baidu.swan.games.j.a.aOn().aOp();
        if (this.ckI != null && this.ckI.getParent() == null) {
            frameLayout.addView(this.ckI, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.axA()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.ckR = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            aiz();
        }
        ap(view);
        this.ckP = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.ckO = new com.baidu.swan.games.view.d(this.ckM);
    }

    private void aio() {
        if (this.ckI != null) {
            this.ckI.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.aip()) {
                        com.baidu.swan.apps.ap.e.N(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aip() {
        f YG = YG();
        return YG != null && (YG.ahW() instanceof j);
    }

    private void ap(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.ckJ = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.ckK = view.findViewById(a.f.titlebar_right_menu_line);
        this.ckL = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.ckJ.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.ckL.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.ckK.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.ckJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.agK();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.ckL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.axy()) {
                    if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.p.c.aol().aom()) {
                        j.this.lM("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b aog = new com.baidu.swan.apps.p.b().aog();
                    if (aog.isShow()) {
                        com.baidu.swan.apps.p.c.aol().a(j.this.mActivity, aog.getImageUrl(), aog.aok(), j.this.ahb());
                        return;
                    }
                    j.this.lM("exitButton");
                }
            }
        });
    }

    public boolean lM(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                air();
            }
            return false;
        }
        this.ckX = com.baidu.swan.games.m.a.aPg().a(this.mActivity, aiq());
        if (this.ckX != null) {
            this.ckM.addView(this.ckX);
            this.ckY = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.ckV == null) {
            this.ckV = new GameCloseGuidePopView(getContext());
            this.ckV.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aiC() {
                    if (j.this.ckV != null) {
                        j.this.ckM.removeView(j.this.ckV);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aiD() {
                    j.this.air();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aiE() {
                    j.this.air();
                }
            });
        }
        this.ckM.addView(this.ckV);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a ahb() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void ahy() {
                j.this.air();
            }
        };
    }

    private GameCloseGuidePopView.a aiq() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aiC() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aiD() {
                if (j.this.ckX != null) {
                    j.this.ckM.removeView(j.this.ckX);
                    j.this.ckX = null;
                }
                j.this.air();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aiE() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void air() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).gx(1);
        ap.aGh().kz(2);
    }

    private void ais() {
        if (ah.cJ(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.apu(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ais();
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
    public com.baidu.swan.games.u.a.b.a ait() {
        return this.ckQ;
    }

    @NonNull
    public com.baidu.swan.games.view.b aiu() {
        return this.bXr;
    }

    public com.baidu.swan.games.view.d aiv() {
        return this.ckP;
    }

    public com.baidu.swan.games.view.d aiw() {
        return this.ckO;
    }

    public void resume() {
        requestAudioFocus();
        if (this.ckI != null && this.ckI.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.ckI.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.ckI.onResume();
            com.baidu.swan.games.audio.b.b.aLQ().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).YI()));
            }
            v8Engine.onResume();
            if (this.ckM != null && this.ckN != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.ckM.removeView(j.this.ckN);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.ckO.aRa()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.ckO.gN(isLandScape);
                    this.ckP.gN(isLandScape);
                }
                com.baidu.swan.apps.ap.e.N(this.mActivity);
            }
            if (this.bTG == null) {
                this.bTG = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.ckO.aRa()) {
                            if (260 < i && i < 280 && j.this.ckU != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.ckU = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ckU);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ckU);
                                }
                            } else if (80 < i && i < 100 && j.this.ckU != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.ckU = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ckU);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ckU);
                                }
                            }
                        }
                    }
                };
            }
            if (this.bTG.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bTG.enable();
            } else {
                this.bTG.disable();
            }
            com.baidu.swan.games.b.d.aLs().startMonitor();
            com.baidu.swan.apps.media.b.eI(true);
            if (this.ckO != null) {
                this.ckO.aoK();
            }
            if (this.ckP != null) {
                this.ckP.aoK();
            }
            ais();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.ckN == null) {
            this.ckN = new View(this.mActivity);
        }
        this.ckM.removeView(this.ckN);
        this.ckM.addView(this.ckN, new FrameLayout.LayoutParams(-1, -1));
        if (this.ckV != null) {
            this.ckM.removeView(this.ckV);
            this.ckV = null;
        }
        if (this.ckO != null) {
            this.ckO.aoJ();
        }
        if (this.ckP != null) {
            this.ckP.aoJ();
        }
        if (this.ckI != null && this.ckI.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.ckI.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aNR()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aNM = v8Engine.aNM();
                if (aNM instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aNM).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aLQ().pauseAll();
            com.baidu.swan.games.b.d.aLs().aLu();
            com.baidu.swan.apps.media.b.eI(false);
            this.ckI.onPause();
            if (this.bTG != null) {
                this.bTG.disable();
            }
            if (this.cjv != null && this.cjv.isShowing()) {
                this.cjv.dismiss(false);
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
            afd();
        }
        if (this.ckI != null) {
            this.ckI.setOnSystemUiVisibilityChangeListener(null);
            this.ckI.onDestroy();
        }
        if (this.ckY) {
            this.ckX = null;
            com.baidu.swan.games.m.a.aPg().release();
        }
        if (this.ckO != null) {
            this.ckO.aRd();
        }
        if (this.ckP != null) {
            this.ckP.aRd();
        }
        this.bXr.acy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.gE(false);
        com.baidu.swan.games.glsurface.a.b.aON();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        acc();
        if (com.baidu.swan.apps.runtime.e.aAs() != null) {
            this.cjv.setScreenOrientation(com.baidu.swan.apps.runtime.e.aAs().aAv().getOrientation());
        }
        this.cjv.a(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState(), aht(), this.cjw, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        if (com.baidu.l.a.Uv()) {
            return com.baidu.l.a.Uv();
        }
        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.p.c.aol().aom()) {
            return lM("backButton");
        }
        com.baidu.swan.apps.p.b aog = new com.baidu.swan.apps.p.b().aog();
        if (aog.isShow()) {
            com.baidu.swan.apps.p.c.aol().a(this.mActivity, aog.getImageUrl(), aog.aok(), ahb());
            return true;
        }
        return lM("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
        FragmentActivity aVF = aVF();
        if (aVF != null) {
            if (this.ckW) {
                if (this.cjv != null && this.cjv.isShowing()) {
                    this.cjv.dismiss(false);
                }
                this.cjv = null;
                this.ckW = false;
            }
            if (this.cjw == null) {
                this.cjw = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cjv == null) {
                this.cjv = new com.baidu.swan.menu.h(aVF, this.mMenu, 0, com.baidu.swan.apps.t.a.apy(), new com.baidu.swan.apps.view.c.b());
                this.cjv.lM(com.baidu.swan.apps.ap.e.aFj());
                this.ckQ.b(this.cjv);
                com.baidu.swan.games.q.a asx = com.baidu.swan.apps.v.f.asJ().asx();
                if (asx != null) {
                    asx.a(this.cjv);
                }
                new com.baidu.swan.apps.menu.a(this.cjv, this, this.cjw).auy();
            }
        }
    }

    public com.baidu.swan.menu.h aix() {
        return this.cjv;
    }

    public void ea(boolean z) {
        this.ckW = z;
    }

    public boolean aiy() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void agO() {
        if (this.ckI != null && this.ckI.getV8Engine() != null) {
            this.ckI.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void aiz() {
        if (this.cfw) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cfw = true;
        this.ckS = new b();
        this.ckS.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void afd() {
        if (!this.cfw) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cfw = false;
        if (this.ckS != null) {
            this.ckS.removeMessages(0);
            this.ckS = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0427a
    public com.baidu.swan.apps.res.widget.floatlayer.a YB() {
        if (this.bTJ == null && this.ckP != null && this.ckP.aQZ() != null) {
            this.bTJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.ckP.aQZ(), 0);
        }
        return this.bTJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.ckR != null) {
                String valueOf = String.valueOf(j.this.ckI == null ? 0 : j.this.ckI.getFPS());
                j.this.ckR.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.ckS.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.aiA()) {
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
        if (!aiA() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.ckT == null) {
                this.ckT = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.ckT, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.ckT != null) {
                this.mAudioManager.abandonAudioFocus(this.ckT);
                this.mAudioManager = null;
                this.ckT = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiA() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        boolean booleanValue = aAr != null ? aAr.aAJ().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aiB() {
        return this.mMenu;
    }
}
