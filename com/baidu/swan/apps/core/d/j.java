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
public class j extends c implements a.InterfaceC0470a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cGg;
    private a cLA;
    private GameCloseGuidePopView cLC;
    private View cLE;
    private boolean cLF;
    private DuMixGameSurfaceView cLp;
    private ImageView cLq;
    private View cLr;
    private ImageView cLs;
    private FrameLayout cLt;
    private View cLu;
    private com.baidu.swan.games.view.d cLv;
    private com.baidu.swan.games.view.d cLw;
    private TextView cLy;
    private b cLz;
    private OrientationEventListener cus;
    private com.baidu.swan.apps.res.widget.floatlayer.a cuw;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cLx = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cye = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cLB = "landscape";
    private boolean cLD = false;

    public static j apt() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aWh().a(j.this.cJZ, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        al(inflate);
        apu();
        return inflate;
    }

    public void al(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cLt = frameLayout;
        this.cLp = com.baidu.swan.games.j.a.aVq().aVs();
        if (this.cLp != null && this.cLp.getParent() == null) {
            frameLayout.addView(this.cLp, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aEF()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cLy = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            apF();
        }
        av(view);
        this.cLw = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cLv = new com.baidu.swan.games.view.d(this.cLt);
    }

    private void apu() {
        if (this.cLp != null) {
            this.cLp.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.apv()) {
                        com.baidu.swan.apps.ap.e.O(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apv() {
        f afM = afM();
        return afM != null && (afM.apb() instanceof j);
    }

    private void av(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cLq = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cLr = view.findViewById(a.f.titlebar_right_menu_line);
        this.cLs = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cLq.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cLs.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cLr.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.anP();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.cLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aED()) {
                    if (com.baidu.swan.apps.runtime.e.aHu() != null && com.baidu.swan.apps.p.c.avs().avt()) {
                        j.this.ng("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b avn = new com.baidu.swan.apps.p.b().avn();
                    if (avn.isShow()) {
                        com.baidu.swan.apps.p.c.avs().a(j.this.mActivity, avn.getImageUrl(), avn.avr(), j.this.aog());
                        return;
                    }
                    j.this.ng("exitButton");
                }
            }
        });
    }

    public boolean ng(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                apx();
            }
            return false;
        }
        this.cLE = com.baidu.swan.games.m.a.aWj().a(this.mActivity, apw());
        if (this.cLE != null) {
            this.cLt.addView(this.cLE);
            this.cLF = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.cLC == null) {
            this.cLC = new GameCloseGuidePopView(getContext());
            this.cLC.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apI() {
                    if (j.this.cLC != null) {
                        j.this.cLt.removeView(j.this.cLC);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apJ() {
                    j.this.apx();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apK() {
                    j.this.apx();
                }
            });
        }
        this.cLt.addView(this.cLC);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aog() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void aoD() {
                j.this.apx();
            }
        };
    }

    private GameCloseGuidePopView.a apw() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apI() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apJ() {
                if (j.this.cLE != null) {
                    j.this.cLt.removeView(j.this.cLE);
                    j.this.cLE = null;
                }
                j.this.apx();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apK() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).hp(1);
        ap.aNk().lr(2);
    }

    private void apy() {
        if (ah.cP(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.awA(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        apy();
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
    public com.baidu.swan.games.u.a.b.a apz() {
        return this.cLx;
    }

    @NonNull
    public com.baidu.swan.games.view.b apA() {
        return this.cye;
    }

    public com.baidu.swan.games.view.d apB() {
        return this.cLw;
    }

    public com.baidu.swan.games.view.d apC() {
        return this.cLv;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cLp != null && this.cLp.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cLp.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cLp.onResume();
            com.baidu.swan.games.audio.b.b.aST().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).afO()));
            }
            v8Engine.onResume();
            if (this.cLt != null && this.cLu != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cLt.removeView(j.this.cLu);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cLv.aYd()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cLv.hF(isLandScape);
                    this.cLw.hF(isLandScape);
                }
                com.baidu.swan.apps.ap.e.O(this.mActivity);
            }
            if (this.cus == null) {
                this.cus = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cLv.aYd()) {
                            if (260 < i && i < 280 && j.this.cLB != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cLB = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cLB);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cLB);
                                }
                            } else if (80 < i && i < 100 && j.this.cLB != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cLB = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cLB);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cLB);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cus.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cus.enable();
            } else {
                this.cus.disable();
            }
            com.baidu.swan.games.b.d.aSv().startMonitor();
            com.baidu.swan.apps.media.b.fA(true);
            if (this.cLv != null) {
                this.cLv.avR();
            }
            if (this.cLw != null) {
                this.cLw.avR();
            }
            apy();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cLu == null) {
            this.cLu = new View(this.mActivity);
        }
        this.cLt.removeView(this.cLu);
        this.cLt.addView(this.cLu, new FrameLayout.LayoutParams(-1, -1));
        if (this.cLC != null) {
            this.cLt.removeView(this.cLC);
            this.cLC = null;
        }
        if (this.cLv != null) {
            this.cLv.avQ();
        }
        if (this.cLw != null) {
            this.cLw.avQ();
        }
        if (this.cLp != null && this.cLp.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cLp.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aUU()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aUP = v8Engine.aUP();
                if (aUP instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aUP).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aST().pauseAll();
            com.baidu.swan.games.b.d.aSv().aSx();
            com.baidu.swan.apps.media.b.fA(false);
            this.cLp.onPause();
            if (this.cus != null) {
                this.cus.disable();
            }
            if (this.cKc != null && this.cKc.isShowing()) {
                this.cKc.dismiss(false);
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
            ami();
        }
        if (this.cLp != null) {
            this.cLp.setOnSystemUiVisibilityChangeListener(null);
            this.cLp.onDestroy();
        }
        if (this.cLF) {
            this.cLE = null;
            com.baidu.swan.games.m.a.aWj().release();
        }
        if (this.cLv != null) {
            this.cLv.aYg();
        }
        if (this.cLw != null) {
            this.cLw.aYg();
        }
        this.cye.ajE();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.hw(false);
        com.baidu.swan.games.glsurface.a.b.aVQ();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        aji();
        if (com.baidu.swan.apps.runtime.e.aHv() != null) {
            this.cKc.setScreenOrientation(com.baidu.swan.apps.runtime.e.aHv().aHy().getOrientation());
        }
        this.cKc.a(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState(), aoy(), this.cKd, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        if (com.baidu.l.a.aaL()) {
            return com.baidu.l.a.aaL();
        }
        if (com.baidu.swan.apps.runtime.e.aHu() != null && com.baidu.swan.apps.p.c.avs().avt()) {
            return ng("backButton");
        }
        com.baidu.swan.apps.p.b avn = new com.baidu.swan.apps.p.b().avn();
        if (avn.isShow()) {
            com.baidu.swan.apps.p.c.avs().a(this.mActivity, avn.getImageUrl(), avn.avr(), aog());
            return true;
        }
        return ng("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
        FragmentActivity bcH = bcH();
        if (bcH != null) {
            if (this.cLD) {
                if (this.cKc != null && this.cKc.isShowing()) {
                    this.cKc.dismiss(false);
                }
                this.cKc = null;
                this.cLD = false;
            }
            if (this.cKd == null) {
                this.cKd = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cKc == null) {
                this.cKc = new com.baidu.swan.menu.h(bcH, this.mMenu, 0, com.baidu.swan.apps.t.a.awE(), new com.baidu.swan.apps.view.c.b());
                this.cKc.mE(com.baidu.swan.apps.ap.e.aMm());
                this.cLx.b(this.cKc);
                com.baidu.swan.games.q.a azC = com.baidu.swan.apps.v.f.azO().azC();
                if (azC != null) {
                    azC.a(this.cKc);
                }
                new com.baidu.swan.apps.menu.a(this.cKc, this, this.cKd).aBD();
            }
        }
    }

    public com.baidu.swan.menu.h apD() {
        return this.cKc;
    }

    public void eS(boolean z) {
        this.cLD = z;
    }

    public boolean apE() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anT() {
        if (this.cLp != null && this.cLp.getV8Engine() != null) {
            this.cLp.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void apF() {
        if (this.cGg) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cGg = true;
        this.cLz = new b();
        this.cLz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void ami() {
        if (!this.cGg) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cGg = false;
        if (this.cLz != null) {
            this.cLz.removeMessages(0);
            this.cLz = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0470a
    public com.baidu.swan.apps.res.widget.floatlayer.a afH() {
        if (this.cuw == null && this.cLw != null && this.cLw.aYc() != null) {
            this.cuw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cLw.aYc(), 0);
        }
        return this.cuw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cLy != null) {
                String valueOf = String.valueOf(j.this.cLp == null ? 0 : j.this.cLp.getFPS());
                j.this.cLy.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cLz.sendEmptyMessageDelayed(0, 500L);
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
                    if (!j.this.apG()) {
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
        if (!apG() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cLA == null) {
                this.cLA = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cLA, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cLA != null) {
                this.mAudioManager.abandonAudioFocus(this.cLA);
                this.mAudioManager = null;
                this.cLA = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apG() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        boolean booleanValue = aHu != null ? aHu.aHM().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View apH() {
        return this.mMenu;
    }
}
