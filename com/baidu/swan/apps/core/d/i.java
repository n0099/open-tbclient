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
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0313a, com.baidu.swan.games.t.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bJd;
    private DuMixGameSurfaceView bNe;
    private ImageView bNf;
    private View bNg;
    private ImageView bNh;
    private FrameLayout bNi;
    private View bNj;
    private com.baidu.swan.games.view.d bNk;
    private com.baidu.swan.games.view.d bNl;
    private TextView bNn;
    private b bNo;
    private a bNp;
    private GameCloseGuidePopView bNr;
    private boolean bzO;
    private OrientationEventListener bzo;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzr;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a bNm = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b bBK = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bNq = "landscape";
    private boolean bNs = false;

    public static i Wy() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ag(inflate);
        Wz();
        return inflate;
    }

    public void ag(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bNi = frameLayout;
        this.bNe = com.baidu.swan.games.i.a.awo().awq();
        if (this.bNe != null && this.bNe.getParent() == null) {
            frameLayout.addView(this.bNe, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aiz()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bNn = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            WK();
        }
        aj(view);
        this.bNl = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bNk = new com.baidu.swan.games.view.d(this.bNi);
    }

    private void Wz() {
        if (this.bNe != null) {
            this.bNe.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.WA()) {
                        com.baidu.swan.apps.as.c.Q(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WA() {
        e Ou = Ou();
        return Ou != null && (Ou.We() instanceof i);
    }

    private void aj(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.bNf = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.bNg = view.findViewById(a.f.titlebar_right_menu_line);
        this.bNh = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.bNf.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bNh.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.bNg.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.bNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Vl();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.aix()) {
                    if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.q.c.abc().abd()) {
                        i.this.WB();
                        return;
                    }
                    com.baidu.swan.apps.q.b aaX = new com.baidu.swan.apps.q.b().aaX();
                    if (aaX.isShow()) {
                        com.baidu.swan.apps.q.c.abc().a(i.this.mActivity, aaX.getImageUrl(), aaX.abb(), i.this.Vp());
                        return;
                    }
                    i.this.WB();
                }
            }
        });
    }

    public void WB() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            WC();
            return;
        }
        if (this.bNr == null) {
            this.bNr = new GameCloseGuidePopView(getContext());
            this.bNr.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WN() {
                    if (i.this.bNr != null) {
                        i.this.bNi.removeView(i.this.bNr);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WO() {
                    i.this.WC();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void WP() {
                    i.this.WC();
                }
            });
        }
        this.bNi.addView(this.bNr);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Vp() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void VK() {
                i.this.WC();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dW(1);
    }

    private void WD() {
        if (af.cy(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.a.abO(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WD();
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
    public com.baidu.swan.games.t.a.b.a WE() {
        return this.bNm;
    }

    @NonNull
    public com.baidu.swan.games.view.b WF() {
        return this.bBK;
    }

    public com.baidu.swan.games.view.d WG() {
        return this.bNl;
    }

    public com.baidu.swan.games.view.d WH() {
        return this.bNk;
    }

    public void resume() {
        Eb();
        if (this.bNe != null && this.bNe.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.bNe.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.bNe.onResume();
            com.baidu.swan.games.audio.b.b.atS().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).Ow()));
            }
            v8Engine.onResume();
            if (this.bNi != null && this.bNj != null) {
                ai.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bNi.removeView(i.this.bNj);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bNk.fH(isLandScape);
                this.bNl.fH(isLandScape);
                com.baidu.swan.apps.as.c.Q(this.mActivity);
            }
            if (this.bzo == null) {
                this.bzo = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bNq != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bNq = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bNq);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bNq);
                            }
                        } else if (80 < i && i < 100 && i.this.bNq != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bNq = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bNq);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bNq);
                            }
                        }
                    }
                };
            }
            if (this.bzo.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bzo.enable();
            } else {
                this.bzo.disable();
            }
            com.baidu.swan.apps.media.b.dP(true);
            if (this.bNk != null) {
                this.bNk.ayK();
            }
            if (this.bNl != null) {
                this.bNl.ayK();
            }
            WD();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        Ec();
        if (this.bNj == null) {
            this.bNj = new View(this.mActivity);
        }
        this.bNi.removeView(this.bNj);
        this.bNi.addView(this.bNj, new FrameLayout.LayoutParams(-1, -1));
        if (this.bNr != null) {
            this.bNi.removeView(this.bNr);
            this.bNr = null;
        }
        if (this.bNk != null) {
            this.bNk.ayL();
        }
        if (this.bNl != null) {
            this.bNl.ayL();
        }
        if (this.bNe != null && this.bNe.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.bNe.getV8Engine();
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
            this.bNe.onPause();
            if (this.bzo != null) {
                this.bzo.disable();
            }
            if (this.bLS != null && this.bLS.isShowing()) {
                this.bLS.fS(false);
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
            TV();
        }
        if (this.bNe != null) {
            this.bNe.setOnSystemUiVisibilityChangeListener(null);
            this.bNe.onDestroy();
        }
        if (this.bNk != null) {
            this.bNk.ayM();
        }
        if (this.bNl != null) {
            this.bNl.ayM();
        }
        this.bBK.Ry();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.fC(false);
        com.baidu.swan.games.glsurface.a.b.awL();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        QX();
        if (com.baidu.swan.apps.runtime.e.akO() != null) {
            this.bLS.iy(com.baidu.swan.apps.runtime.e.akO().akQ().getOrientation());
        }
        this.bLS.j(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState(), VF());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        return com.baidu.g.a.KK();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QX() {
        FragmentActivity aCO = aCO();
        if (aCO != null) {
            if (this.bNs) {
                if (this.bLS != null && this.bLS.isShowing()) {
                    this.bLS.fS(false);
                }
                this.bLS = null;
                this.bNs = false;
            }
            if (this.bLS == null) {
                this.bLS = new com.baidu.swan.menu.h(aCO, this.mMenu, 0, com.baidu.swan.apps.w.a.abS(), new com.baidu.swan.apps.view.c.b());
                this.bLS.ix(com.baidu.swan.apps.as.c.aoI());
                this.bNm.b(this.bLS);
                com.baidu.swan.games.p.a aez = com.baidu.swan.apps.y.f.aeK().aez();
                if (aez != null) {
                    aez.a(this.bLS);
                }
                new com.baidu.swan.apps.aa.a(this.bLS, this).agt();
            }
        }
    }

    public com.baidu.swan.menu.h WI() {
        return this.bLS;
    }

    public void dt(boolean z) {
        this.bNs = z;
    }

    public boolean WJ() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VI() {
        if (this.bNe != null && this.bNe.getV8Engine() != null) {
            this.bNe.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void WK() {
        if (this.bJd) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bJd = true;
        this.bNo = new b();
        this.bNo.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void TV() {
        if (!this.bJd) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bJd = false;
        if (this.bNo != null) {
            this.bNo.removeMessages(0);
            this.bNo = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0313a
    public com.baidu.swan.apps.res.widget.floatlayer.a Op() {
        if (this.bzr == null && this.bNl != null && this.bNl.ayH() != null) {
            this.bzr = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bNl.ayH(), 0);
        }
        return this.bzr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bNn != null) {
                String valueOf = String.valueOf(i.this.bNe == null ? 0 : i.this.bNe.getFPS());
                i.this.bNn.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bNo.sendEmptyMessageDelayed(0, 500L);
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
                    if (!i.this.WL()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.Ec();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.Ec();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void Eb() {
        if (!WL() && !this.bzO) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bNp == null) {
                this.bNp = new a();
            }
            this.bzO = this.mAudioManager.requestAudioFocus(this.bNp, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void Ec() {
        if (this.bzO) {
            if (this.mAudioManager != null && this.bNp != null) {
                this.mAudioManager.abandonAudioFocus(this.bNp);
                this.mAudioManager = null;
                this.bNp = null;
            }
            this.bzO = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WL() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        boolean booleanValue = akN != null ? akN.ald().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View WM() {
        return this.mMenu;
    }
}
