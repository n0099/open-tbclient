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
/* loaded from: classes8.dex */
public class j extends c implements a.InterfaceC0459a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.res.widget.floatlayer.a cDC;
    private OrientationEventListener cDz;
    private boolean cPn;
    private FrameLayout cUA;
    private View cUB;
    private com.baidu.swan.games.view.d cUC;
    private com.baidu.swan.games.view.d cUD;
    private TextView cUF;
    private b cUG;
    private a cUH;
    private GameCloseGuidePopView cUJ;
    private View cUL;
    private boolean cUM;
    private DuMixGameSurfaceView cUw;
    private ImageView cUx;
    private View cUy;
    private ImageView cUz;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cUE = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cHm = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cUI = "landscape";
    private boolean cUK = false;

    public static j apR() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aXu().a(j.this.cTf, j.this.getContext());
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
        apS();
        return inflate;
    }

    public void am(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cUA = frameLayout;
        this.cUw = com.baidu.swan.games.j.a.aWD().aWF();
        if (this.cUw != null && this.cUw.getParent() == null) {
            frameLayout.addView(this.cUw, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aFd()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cUF = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            aqd();
        }
        ay(view);
        this.cUD = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cUC = new com.baidu.swan.games.view.d(this.cUA);
    }

    private void apS() {
        if (this.cUw != null) {
            this.cUw.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.apT()) {
                        com.baidu.swan.apps.ao.e.I(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apT() {
        f aga = aga();
        return aga != null && (aga.apA() instanceof j);
    }

    private void ay(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cUx = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cUy = view.findViewById(a.f.titlebar_right_menu_line);
        this.cUz = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cUx.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cUz.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cUy.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.aoi();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.cUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aFb()) {
                    if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.p.c.avR().avS()) {
                        j.this.mO("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b avM = new com.baidu.swan.apps.p.b().avM();
                    if (avM.isShow()) {
                        com.baidu.swan.apps.p.c.avR().a(j.this.mActivity, avM.getImageUrl(), avM.avQ(), j.this.aoz());
                        return;
                    }
                    j.this.mO("exitButton");
                }
            }
        });
    }

    public boolean mO(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.b.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.b.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                apV();
            }
            return false;
        }
        this.cUL = com.baidu.swan.games.m.a.aXw().a(this.mActivity, apU());
        if (this.cUL != null) {
            this.cUA.addView(this.cUL);
            this.cUM = true;
            com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
            return true;
        }
        if (this.cUJ == null) {
            this.cUJ = new GameCloseGuidePopView(getContext());
            this.cUJ.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqg() {
                    if (j.this.cUJ != null) {
                        j.this.cUA.removeView(j.this.cUJ);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqh() {
                    j.this.apV();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aqi() {
                    j.this.apV();
                }
            });
        }
        this.cUA.addView(this.cUJ);
        com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aoz() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void apb() {
                j.this.apV();
            }
        };
    }

    private GameCloseGuidePopView.a apU() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqg() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqh() {
                if (j.this.cUL != null) {
                    j.this.cUA.removeView(j.this.cUL);
                    j.this.cUL = null;
                }
                j.this.apV();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aqi() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apV() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).ga(1);
        ap.aOD().ko(2);
    }

    private void apW() {
        if (ah.dL(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.awZ(), a.h.aiapps_game_not_support_split_screen).aIv();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        apW();
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
    public com.baidu.swan.games.u.a.b.a apX() {
        return this.cUE;
    }

    @NonNull
    public com.baidu.swan.games.view.b apY() {
        return this.cHm;
    }

    public com.baidu.swan.games.view.d apZ() {
        return this.cUD;
    }

    public com.baidu.swan.games.view.d aqa() {
        return this.cUC;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cUw != null && this.cUw.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cUw.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cUw.onResume();
            com.baidu.swan.games.audio.b.b.aUg().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).agc()));
            }
            v8Engine.onResume();
            if (this.cUA != null && this.cUB != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cUA.removeView(j.this.cUB);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cUC.aZp()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cUC.in(isLandScape);
                    this.cUD.in(isLandScape);
                }
                com.baidu.swan.apps.ao.e.I(this.mActivity);
            }
            if (this.cDz == null) {
                this.cDz = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cUC.aZp()) {
                            if (260 < i && i < 280 && j.this.cUI != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cUI = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cUI);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cUI);
                                }
                            } else if (80 < i && i < 100 && j.this.cUI != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cUI = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cUI);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cUI);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cDz.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cDz.enable();
            } else {
                this.cDz.disable();
            }
            com.baidu.swan.games.b.d.aTI().startMonitor();
            com.baidu.swan.apps.media.b.fZ(true);
            if (this.cUC != null) {
                this.cUC.awq();
            }
            if (this.cUD != null) {
                this.cUD.awq();
            }
            apW();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cUB == null) {
            this.cUB = new View(this.mActivity);
        }
        this.cUA.removeView(this.cUB);
        this.cUA.addView(this.cUB, new FrameLayout.LayoutParams(-1, -1));
        if (this.cUJ != null) {
            this.cUA.removeView(this.cUJ);
            this.cUJ = null;
        }
        if (this.cUC != null) {
            this.cUC.awp();
        }
        if (this.cUD != null) {
            this.cUD.awp();
        }
        if (this.cUw != null && this.cUw.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cUw.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aWh()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aWc = v8Engine.aWc();
                if (aWc instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aWc).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aUg().pauseAll();
            com.baidu.swan.games.b.d.aTI().aTK();
            com.baidu.swan.apps.media.b.fZ(false);
            this.cUw.onPause();
            if (this.cDz != null) {
                this.cDz.disable();
            }
            if (this.cTi != null && this.cTi.isShowing()) {
                this.cTi.dismiss(false);
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
            amC();
        }
        if (this.cUw != null) {
            this.cUw.setOnSystemUiVisibilityChangeListener(null);
            this.cUw.onDestroy();
        }
        if (this.cUM) {
            this.cUL = null;
            com.baidu.swan.games.m.a.aXw().release();
        }
        if (this.cUC != null) {
            this.cUC.onPageDestroy();
        }
        if (this.cUD != null) {
            this.cUD.onPageDestroy();
        }
        this.cHm.ajW();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ie(false);
        com.baidu.swan.games.glsurface.a.b.aXd();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        ajA();
        if (com.baidu.swan.apps.runtime.e.aIO() != null) {
            this.cTi.setScreenOrientation(com.baidu.swan.apps.runtime.e.aIO().aIR().getOrientation());
        }
        this.cTi.a(com.baidu.swan.apps.t.a.axv().ail(), aoW(), this.cTj, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        if (com.baidu.k.a.adf()) {
            return com.baidu.k.a.adf();
        }
        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.p.c.avR().avS()) {
            return mO("backButton");
        }
        com.baidu.swan.apps.p.b avM = new com.baidu.swan.apps.p.b().avM();
        if (avM.isShow()) {
            com.baidu.swan.apps.p.c.avR().a(this.mActivity, avM.getImageUrl(), avM.avQ(), aoz());
            return true;
        }
        return mO("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
        FragmentActivity bdW = bdW();
        if (bdW != null) {
            if (this.cUK) {
                if (this.cTi != null && this.cTi.isShowing()) {
                    this.cTi.dismiss(false);
                }
                this.cTi = null;
                this.cUK = false;
            }
            if (this.cTj == null) {
                this.cTj = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cTi == null) {
                this.cTi = new com.baidu.swan.menu.g(bdW, this.mMenu, 0, com.baidu.swan.apps.t.a.axd(), new com.baidu.swan.apps.view.c.b());
                this.cTi.lF(com.baidu.swan.apps.ao.e.aNF());
                this.cUE.b(this.cTi);
                com.baidu.swan.games.q.a aAc = com.baidu.swan.apps.v.f.aAo().aAc();
                if (aAc != null) {
                    aAc.a(this.cTi);
                }
                new com.baidu.swan.apps.menu.a(this.cTi, this, this.cTj).aCe();
            }
        }
    }

    public com.baidu.swan.menu.g aqb() {
        return this.cTi;
    }

    public void fr(boolean z) {
        this.cUK = z;
    }

    public boolean aqc() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aom() {
        if (this.cUw != null && this.cUw.getV8Engine() != null) {
            this.cUw.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void aqd() {
        if (this.cPn) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cPn = true;
        this.cUG = new b();
        this.cUG.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void amC() {
        if (!this.cPn) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cPn = false;
        if (this.cUG != null) {
            this.cUG.removeMessages(0);
            this.cUG = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0459a
    public com.baidu.swan.apps.res.widget.floatlayer.a afV() {
        if (this.cDC == null && this.cUD != null && this.cUD.aZo() != null) {
            this.cDC = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cUD.aZo(), 0);
        }
        return this.cDC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cUF != null) {
                String valueOf = String.valueOf(j.this.cUw == null ? 0 : j.this.cUw.getFPS());
                j.this.cUF.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cUG.sendEmptyMessageDelayed(0, 500L);
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
                    if (!j.this.aqe()) {
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
        if (!aqe() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cUH == null) {
                this.cUH = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cUH, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cUH != null) {
                this.mAudioManager.abandonAudioFocus(this.cUH);
                this.mAudioManager = null;
                this.cUH = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqe() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        boolean booleanValue = aIN != null ? aIN.aJf().c("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aqf() {
        return this.mMenu;
    }
}
