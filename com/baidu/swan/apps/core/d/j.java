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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes7.dex */
public class j extends c implements a.InterfaceC0386a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener bMg;
    private com.baidu.swan.apps.res.widget.floatlayer.a bMj;
    private boolean bNb;
    private boolean bXH;
    private DuMixGameSurfaceView ccG;
    private ImageView ccH;
    private View ccI;
    private ImageView ccJ;
    private FrameLayout ccK;
    private View ccL;
    private com.baidu.swan.games.view.d ccM;
    private com.baidu.swan.games.view.d ccN;
    private TextView ccP;
    private b ccQ;
    private a ccR;
    private GameCloseGuidePopView ccT;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a ccO = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bPM = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String ccS = "landscape";
    private boolean ccU = false;

    public static j abr() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aFE().a(j.this.cbr, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        aj(inflate);
        abs();
        return inflate;
    }

    public void aj(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.ccK = frameLayout;
        this.ccG = com.baidu.swan.games.j.a.aEO().aEQ();
        if (this.ccG != null && this.ccG.getParent() == null) {
            frameLayout.addView(this.ccG, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ae.a.a.aoU()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.ccP = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            abD();
        }
        am(view);
        this.ccN = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.ccM = new com.baidu.swan.games.view.d(this.ccK);
    }

    private void abs() {
        if (this.ccG != null) {
            this.ccG.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.abt()) {
                        com.baidu.swan.apps.aq.e.N(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abt() {
        f Sc = Sc();
        return Sc != null && (Sc.aaZ() instanceof j);
    }

    private void am(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.ccH = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.ccI = view.findViewById(a.f.titlebar_right_menu_line);
        this.ccJ = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.ccH.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.ccJ.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.ccI.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.ZQ();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.ccJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ae.a.a.aoS()) {
                    if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.o.c.agt().agu()) {
                        j.this.abu();
                        return;
                    }
                    com.baidu.swan.apps.o.b ago = new com.baidu.swan.apps.o.b().ago();
                    if (ago.isShow()) {
                        com.baidu.swan.apps.o.c.agt().a(j.this.mActivity, ago.getImageUrl(), ago.ags(), j.this.aah());
                        return;
                    }
                    j.this.abu();
                }
            }
        });
    }

    public void abu() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            abv();
            return;
        }
        if (this.ccT == null) {
            this.ccT = new GameCloseGuidePopView(getContext());
            this.ccT.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void abG() {
                    if (j.this.ccT != null) {
                        j.this.ccK.removeView(j.this.ccT);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void abH() {
                    j.this.abv();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void abI() {
                    j.this.abv();
                }
            });
        }
        this.ccK.addView(this.ccT);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aah() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.o.c.a
            public void aaE() {
                j.this.abv();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).eq(1);
        aq.axo().ig(2);
    }

    private void abw() {
        if (ai.cD(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.ahj(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        abw();
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
    public com.baidu.swan.games.u.a.b.a abx() {
        return this.ccO;
    }

    @NonNull
    public com.baidu.swan.games.view.b aby() {
        return this.bPM;
    }

    public com.baidu.swan.games.view.d abz() {
        return this.ccN;
    }

    public com.baidu.swan.games.view.d abA() {
        return this.ccM;
    }

    public void resume() {
        Gu();
        if (this.ccG != null && this.ccG.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.ccG.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.ccG.onResume();
            com.baidu.swan.games.audio.b.b.aCq().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).Se()));
            }
            v8Engine.onResume();
            if (this.ccK != null && this.ccL != null) {
                al.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.7
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.ccK.removeView(j.this.ccL);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.ccM.aHw()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.ccM.gs(isLandScape);
                    this.ccN.gs(isLandScape);
                }
                com.baidu.swan.apps.aq.e.N(this.mActivity);
            }
            if (this.bMg == null) {
                this.bMg = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.ccM.aHw()) {
                            if (260 < i && i < 280 && j.this.ccS != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.ccS = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ccS);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ccS);
                                }
                            } else if (80 < i && i < 100 && j.this.ccS != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.ccS = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.ccS);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.ccS);
                                }
                            }
                        }
                    }
                };
            }
            if (this.bMg.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bMg.enable();
            } else {
                this.bMg.disable();
            }
            com.baidu.swan.games.b.d.aBS().startMonitor();
            com.baidu.swan.apps.media.b.et(true);
            if (this.ccM != null) {
                this.ccM.aHz();
            }
            if (this.ccN != null) {
                this.ccN.aHz();
            }
            abw();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        Gv();
        if (this.ccL == null) {
            this.ccL = new View(this.mActivity);
        }
        this.ccK.removeView(this.ccL);
        this.ccK.addView(this.ccL, new FrameLayout.LayoutParams(-1, -1));
        if (this.ccT != null) {
            this.ccK.removeView(this.ccT);
            this.ccT = null;
        }
        if (this.ccM != null) {
            this.ccM.aHA();
        }
        if (this.ccN != null) {
            this.ccN.aHA();
        }
        if (this.ccG != null && this.ccG.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.ccG.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aEr()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aEm = v8Engine.aEm();
                if (aEm instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aEm).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aCq().pauseAll();
            com.baidu.swan.games.b.d.aBS().aBU();
            com.baidu.swan.apps.media.b.et(false);
            this.ccG.onPause();
            if (this.bMg != null) {
                this.bMg.disable();
            }
            if (this.cbu != null && this.cbu.isShowing()) {
                this.cbu.gE(false);
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
            Yn();
        }
        if (this.ccG != null) {
            this.ccG.setOnSystemUiVisibilityChangeListener(null);
            this.ccG.onDestroy();
        }
        if (this.ccM != null) {
            this.ccM.aHB();
        }
        if (this.ccN != null) {
            this.ccN.aHB();
        }
        this.bPM.VJ();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.gj(false);
        com.baidu.swan.games.glsurface.a.b.aFn();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Vn();
        if (com.baidu.swan.apps.runtime.e.arw() != null) {
            this.cbu.jt(com.baidu.swan.apps.runtime.e.arw().arz().getOrientation());
        }
        this.cbu.a(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), aaz(), this.cbv, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return com.baidu.h.a.NS();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
        FragmentActivity aMt = aMt();
        if (aMt != null) {
            if (this.ccU) {
                if (this.cbu != null && this.cbu.isShowing()) {
                    this.cbu.gE(false);
                }
                this.cbu = null;
                this.ccU = false;
            }
            if (this.cbv == null) {
                this.cbv = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cbu == null) {
                this.cbu = new com.baidu.swan.menu.h(aMt, this.mMenu, 0, com.baidu.swan.apps.t.a.ahn(), new com.baidu.swan.apps.view.c.b());
                this.cbu.js(com.baidu.swan.apps.aq.e.awp());
                this.ccO.b(this.cbu);
                com.baidu.swan.games.q.a akf = com.baidu.swan.apps.v.f.akr().akf();
                if (akf != null) {
                    akf.a(this.cbu);
                }
                new com.baidu.swan.apps.x.a(this.cbu, this, this.cbv).amc();
            }
        }
    }

    public com.baidu.swan.menu.h abB() {
        return this.cbu;
    }

    public void dR(boolean z) {
        this.ccU = z;
    }

    public boolean abC() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ZU() {
        if (this.ccG != null && this.ccG.getV8Engine() != null) {
            this.ccG.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void abD() {
        if (this.bXH) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bXH = true;
        this.ccQ = new b();
        this.ccQ.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Yn() {
        if (!this.bXH) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bXH = false;
        if (this.ccQ != null) {
            this.ccQ.removeMessages(0);
            this.ccQ = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0386a
    public com.baidu.swan.apps.res.widget.floatlayer.a RX() {
        if (this.bMj == null && this.ccN != null && this.ccN.aHv() != null) {
            this.bMj = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.ccN.aHv(), 0);
        }
        return this.bMj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.ccP != null) {
                String valueOf = String.valueOf(j.this.ccG == null ? 0 : j.this.ccG.getFPS());
                j.this.ccP.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.ccQ.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.abE()) {
                        switch (i) {
                            case -2:
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                j.this.Gv();
                                return;
                            case -1:
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                j.this.Gv();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void Gu() {
        if (!abE() && !this.bNb) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.ccR == null) {
                this.ccR = new a();
            }
            this.bNb = this.mAudioManager.requestAudioFocus(this.ccR, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void Gv() {
        if (this.bNb) {
            if (this.mAudioManager != null && this.ccR != null) {
                this.mAudioManager.abandonAudioFocus(this.ccR);
                this.mAudioManager = null;
                this.ccR = null;
            }
            this.bNb = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abE() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        boolean booleanValue = arv != null ? arv.arN().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View abF() {
        return this.mMenu;
    }
}
