package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.t;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes11.dex */
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0334a, com.baidu.swan.games.t.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bJi;
    private DuMixGameSurfaceView bNj;
    private ImageView bNk;
    private View bNl;
    private ImageView bNm;
    private FrameLayout bNn;
    private View bNo;
    private com.baidu.swan.games.view.d bNp;
    private com.baidu.swan.games.view.d bNq;
    private TextView bNs;
    private b bNt;
    private a bNu;
    private GameCloseGuidePopView bNw;
    private boolean bzT;
    private OrientationEventListener bzt;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzw;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a bNr = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b bBP = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bNv = "landscape";
    private boolean bNx = false;

    public static i Wx() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ag(inflate);
        Wy();
        return inflate;
    }

    public void ag(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bNn = frameLayout;
        this.bNj = com.baidu.swan.games.i.a.awo().awq();
        if (this.bNj != null && this.bNj.getParent() == null) {
            frameLayout.addView(this.bNj, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aiy()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bNs = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            WJ();
        }
        aj(view);
        this.bNq = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bNp = new com.baidu.swan.games.view.d(this.bNn);
    }

    private void Wy() {
        if (this.bNj != null) {
            this.bNj.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.Wz()) {
                        com.baidu.swan.apps.as.c.Q(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wz() {
        e Ot = Ot();
        return Ot != null && (Ot.Wd() instanceof i);
    }

    private void aj(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.bNk = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.bNl = view.findViewById(a.f.titlebar_right_menu_line);
        this.bNm = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.bNk.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bNm.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.bNl.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.bNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Vk();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.aiw()) {
                    if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.q.c.abb().abc()) {
                        i.this.WA();
                        return;
                    }
                    com.baidu.swan.apps.q.b aaW = new com.baidu.swan.apps.q.b().aaW();
                    if (aaW.isShow()) {
                        com.baidu.swan.apps.q.c.abb().a(i.this.mActivity, aaW.getImageUrl(), aaW.aba(), i.this.Vo());
                        return;
                    }
                    i.this.WA();
                }
            }
        });
    }

    public void WA() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            WB();
            return;
        }
        if (this.bNw == null) {
            this.bNw = new GameCloseGuidePopView(getContext());
            this.bNw.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WM() {
                    if (i.this.bNw != null) {
                        i.this.bNn.removeView(i.this.bNw);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WN() {
                    i.this.WB();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WO() {
                    i.this.WB();
                }
            });
        }
        this.bNn.addView(this.bNw);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Vo() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void VJ() {
                i.this.WB();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WB() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dW(1);
    }

    private void WC() {
        if (af.cm(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.a.abN(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WC();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
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

    @Override // com.baidu.swan.games.t.a.b.b
    @NonNull
    public com.baidu.swan.games.t.a.b.a WD() {
        return this.bNr;
    }

    @NonNull
    public com.baidu.swan.games.view.b WE() {
        return this.bBP;
    }

    public com.baidu.swan.games.view.d WF() {
        return this.bNq;
    }

    public com.baidu.swan.games.view.d WG() {
        return this.bNp;
    }

    public void resume() {
        Ea();
        if (this.bNj != null && this.bNj.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.bNj.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.bNj.onResume();
            com.baidu.swan.games.audio.b.b.atS().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).Ov()));
            }
            v8Engine.onResume();
            if (this.bNn != null && this.bNo != null) {
                ai.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bNn.removeView(i.this.bNo);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bNp.fH(isLandScape);
                this.bNq.fH(isLandScape);
                com.baidu.swan.apps.as.c.Q(this.mActivity);
            }
            if (this.bzt == null) {
                this.bzt = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bNv != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bNv = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bNv);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bNv);
                            }
                        } else if (80 < i && i < 100 && i.this.bNv != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bNv = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bNv);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bNv);
                            }
                        }
                    }
                };
            }
            if (this.bzt.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bzt.enable();
            } else {
                this.bzt.disable();
            }
            com.baidu.swan.apps.media.b.dP(true);
            if (this.bNp != null) {
                this.bNp.ayK();
            }
            if (this.bNq != null) {
                this.bNq.ayK();
            }
            WC();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        Eb();
        if (this.bNo == null) {
            this.bNo = new View(this.mActivity);
        }
        this.bNn.removeView(this.bNo);
        this.bNn.addView(this.bNo, new FrameLayout.LayoutParams(-1, -1));
        if (this.bNw != null) {
            this.bNn.removeView(this.bNw);
            this.bNw = null;
        }
        if (this.bNp != null) {
            this.bNp.ayL();
        }
        if (this.bNq != null) {
            this.bNq.ayL();
        }
        if (this.bNj != null && this.bNj.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.bNj.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.avR()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget avM = v8Engine.avM();
                if (avM instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) avM).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.atS().pauseAll();
            com.baidu.swan.apps.media.b.dP(false);
            this.bNj.onPause();
            if (this.bzt != null) {
                this.bzt.disable();
            }
            if (this.bLX != null && this.bLX.isShowing()) {
                this.bLX.fS(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
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
            TU();
        }
        if (this.bNj != null) {
            this.bNj.setOnSystemUiVisibilityChangeListener(null);
            this.bNj.onDestroy();
        }
        if (this.bNp != null) {
            this.bNp.ayM();
        }
        if (this.bNq != null) {
            this.bNq.ayM();
        }
        this.bBP.Rx();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.fC(false);
        com.baidu.swan.games.glsurface.a.b.awL();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        QW();
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            this.bLX.iy(com.baidu.swan.apps.runtime.e.akN().akP().getOrientation());
        }
        this.bLX.j(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState(), VE());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        return com.baidu.g.a.KJ();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
        FragmentActivity aCO = aCO();
        if (aCO != null) {
            if (this.bNx) {
                if (this.bLX != null && this.bLX.isShowing()) {
                    this.bLX.fS(false);
                }
                this.bLX = null;
                this.bNx = false;
            }
            if (this.bLX == null) {
                this.bLX = new com.baidu.swan.menu.h(aCO, this.mMenu, 0, com.baidu.swan.apps.w.a.abR(), new com.baidu.swan.apps.view.c.b());
                this.bLX.ix(com.baidu.swan.apps.as.c.aoH());
                this.bNr.b(this.bLX);
                com.baidu.swan.games.p.a aey = com.baidu.swan.apps.y.f.aeJ().aey();
                if (aey != null) {
                    aey.a(this.bLX);
                }
                new com.baidu.swan.apps.aa.a(this.bLX, this).ags();
            }
        }
    }

    public com.baidu.swan.menu.h WH() {
        return this.bLX;
    }

    public void dt(boolean z) {
        this.bNx = z;
    }

    public boolean WI() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VH() {
        if (this.bNj != null && this.bNj.getV8Engine() != null) {
            this.bNj.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void WJ() {
        if (this.bJi) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bJi = true;
        this.bNt = new b();
        this.bNt.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void TU() {
        if (!this.bJi) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bJi = false;
        if (this.bNt != null) {
            this.bNt.removeMessages(0);
            this.bNt = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0334a
    public com.baidu.swan.apps.res.widget.floatlayer.a Oo() {
        if (this.bzw == null && this.bNq != null && this.bNq.ayH() != null) {
            this.bzw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bNq.ayH(), 0);
        }
        return this.bzw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bNs != null) {
                String valueOf = String.valueOf(i.this.bNj == null ? 0 : i.this.bNj.getFPS());
                i.this.bNs.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bNt.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!i.this.WK()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.Eb();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.Eb();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void Ea() {
        if (!WK() && !this.bzT) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bNu == null) {
                this.bNu = new a();
            }
            this.bzT = this.mAudioManager.requestAudioFocus(this.bNu, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void Eb() {
        if (this.bzT) {
            if (this.mAudioManager != null && this.bNu != null) {
                this.mAudioManager.abandonAudioFocus(this.bNu);
                this.mAudioManager = null;
                this.bNu = null;
            }
            this.bzT = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WK() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        boolean booleanValue = akM != null ? akM.alc().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View WL() {
        return this.mMenu;
    }
}
