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
/* loaded from: classes10.dex */
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0273a, com.baidu.swan.games.t.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener aWA;
    private com.baidu.swan.apps.res.widget.floatlayer.a aWD;
    private boolean aXa;
    private boolean bgu;
    private ImageView bkA;
    private View bkB;
    private ImageView bkC;
    private FrameLayout bkD;
    private View bkE;
    private com.baidu.swan.games.view.d bkF;
    private com.baidu.swan.games.view.d bkG;
    private TextView bkI;
    private b bkJ;
    private a bkK;
    private GameCloseGuidePopView bkM;
    private DuMixGameSurfaceView bkz;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a bkH = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b aYX = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bkL = "landscape";
    private boolean bkN = false;

    public static i Mq() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        initView(inflate);
        Mr();
        return inflate;
    }

    public void initView(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bkD = frameLayout;
        this.bkz = com.baidu.swan.games.i.a.alJ().alL();
        if (this.bkz != null && this.bkz.getParent() == null) {
            frameLayout.addView(this.bkz, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.Yb()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bkI = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            MC();
        }
        ai(view);
        this.bkG = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bkF = new com.baidu.swan.games.view.d(this.bkD);
    }

    private void Mr() {
        if (this.bkz != null) {
            this.bkz.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.Ms()) {
                        com.baidu.swan.apps.as.c.T(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ms() {
        e El = El();
        return El != null && (El.LX() instanceof i);
    }

    private void ai(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.bkA = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.bkB = view.findViewById(a.f.titlebar_right_menu_line);
        this.bkC = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.bkA.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bkC.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.bkB.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.bkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Le();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.XZ()) {
                    if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.q.c.QU().QV()) {
                        i.this.Mt();
                        return;
                    }
                    com.baidu.swan.apps.q.b QP = new com.baidu.swan.apps.q.b().QP();
                    if (QP.isShow()) {
                        com.baidu.swan.apps.q.c.QU().a(i.this.mActivity, QP.getImageUrl(), QP.QT(), i.this.Lj());
                        return;
                    }
                    i.this.Mt();
                }
            }
        });
    }

    public void Mt() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            Mu();
            return;
        }
        if (this.bkM == null) {
            this.bkM = new GameCloseGuidePopView(getContext());
            this.bkM.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void MF() {
                    if (i.this.bkM != null) {
                        i.this.bkD.removeView(i.this.bkM);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void MG() {
                    i.this.Mu();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void MH() {
                    i.this.Mu();
                }
            });
        }
        this.bkD.addView(this.bkM);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Lj() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void LD() {
                i.this.Mu();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dB(1);
    }

    private void Mv() {
        if (af.cH(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.RG(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Mv();
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
    public com.baidu.swan.games.t.a.b.a Mw() {
        return this.bkH;
    }

    @NonNull
    public com.baidu.swan.games.view.b Mx() {
        return this.aYX;
    }

    public com.baidu.swan.games.view.d My() {
        return this.bkG;
    }

    public com.baidu.swan.games.view.d Mz() {
        return this.bkF;
    }

    public void resume() {
        Fl();
        if (this.bkz != null && this.bkz.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.bkz.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.bkz.onResume();
            com.baidu.swan.games.audio.b.b.ajl().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).En()));
            }
            v8Engine.onResume();
            if (this.bkD != null && this.bkE != null) {
                ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bkD.removeView(i.this.bkE);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bkF.eC(isLandScape);
                this.bkG.eC(isLandScape);
                com.baidu.swan.apps.as.c.T(this.mActivity);
            }
            if (this.aWA == null) {
                this.aWA = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bkL != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bkL = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bkL);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bkL);
                            }
                        } else if (80 < i && i < 100 && i.this.bkL != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bkL = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bkL);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bkL);
                            }
                        }
                    }
                };
            }
            if (this.aWA.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.aWA.enable();
            } else {
                this.aWA.disable();
            }
            com.baidu.swan.apps.media.b.cL(true);
            if (this.bkF != null) {
                this.bkF.aof();
            }
            if (this.bkG != null) {
                this.bkG.aof();
            }
            Mv();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        Fm();
        if (this.bkE == null) {
            this.bkE = new View(this.mActivity);
        }
        this.bkD.removeView(this.bkE);
        this.bkD.addView(this.bkE, new FrameLayout.LayoutParams(-1, -1));
        if (this.bkM != null) {
            this.bkD.removeView(this.bkM);
            this.bkM = null;
        }
        if (this.bkF != null) {
            this.bkF.aog();
        }
        if (this.bkG != null) {
            this.bkG.aog();
        }
        if (this.bkz != null && this.bkz.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.bkz.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.alm()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget alg = v8Engine.alg();
                if (alg instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) alg).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.ajl().pauseAll();
            com.baidu.swan.apps.media.b.cL(false);
            this.bkz.onPause();
            if (this.aWA != null) {
                this.aWA.disable();
            }
            if (this.bjm != null && this.bjm.isShowing()) {
                this.bjm.eN(false);
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
            JN();
        }
        if (this.bkz != null) {
            this.bkz.setOnSystemUiVisibilityChangeListener(null);
            this.bkz.onDestroy();
        }
        if (this.bkF != null) {
            this.bkF.aoh();
        }
        if (this.bkG != null) {
            this.bkG.aoh();
        }
        this.aYX.Hs();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ex(false);
        com.baidu.swan.games.glsurface.a.b.amg();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        GR();
        if (com.baidu.swan.apps.runtime.e.aaq() != null) {
            this.bjm.ia(com.baidu.swan.apps.runtime.e.aaq().aas().getOrientation());
        }
        this.bjm.h(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState(), Ly());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        return com.baidu.j.a.BU();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
        FragmentActivity ask = ask();
        if (ask != null) {
            if (this.bkN) {
                if (this.bjm != null && this.bjm.isShowing()) {
                    this.bjm.eN(false);
                }
                this.bjm = null;
                this.bkN = false;
            }
            if (this.bjm == null) {
                this.bjm = new com.baidu.swan.menu.h(ask, this.mMenu, 0, com.baidu.swan.apps.w.a.RK(), new com.baidu.swan.apps.view.c.b());
                this.bjm.hZ(com.baidu.swan.apps.as.c.aek());
                this.bkH.b(this.bjm);
                com.baidu.swan.games.p.a Ur = com.baidu.swan.apps.y.f.UC().Ur();
                if (Ur != null) {
                    Ur.a(this.bjm);
                }
                new com.baidu.swan.apps.aa.a(this.bjm, this).VU();
            }
        }
    }

    public com.baidu.swan.menu.h MA() {
        return this.bjm;
    }

    public void cp(boolean z) {
        this.bkN = z;
    }

    public boolean MB() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void LB() {
        if (this.bkz != null && this.bkz.getV8Engine() != null) {
            this.bkz.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void MC() {
        if (this.bgu) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bgu = true;
        this.bkJ = new b();
        this.bkJ.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void JN() {
        if (!this.bgu) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bgu = false;
        if (this.bkJ != null) {
            this.bkJ.removeMessages(0);
            this.bkJ = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0273a
    public com.baidu.swan.apps.res.widget.floatlayer.a Eg() {
        if (this.aWD == null && this.bkG != null && this.bkG.aoc() != null) {
            this.aWD = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bkG.aoc(), 0);
        }
        return this.aWD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bkI != null) {
                String valueOf = String.valueOf(i.this.bkz == null ? 0 : i.this.bkz.getFPS());
                i.this.bkI.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bkJ.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!i.this.MD()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.Fm();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.Fm();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void Fl() {
        if (!MD() && !this.aXa) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bkK == null) {
                this.bkK = new a();
            }
            this.aXa = this.mAudioManager.requestAudioFocus(this.bkK, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void Fm() {
        if (this.aXa) {
            if (this.mAudioManager != null && this.bkK != null) {
                this.mAudioManager.abandonAudioFocus(this.bkK);
                this.mAudioManager = null;
                this.bkK = null;
            }
            this.aXa = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MD() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        boolean booleanValue = aap != null ? aap.aaF().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View ME() {
        return this.mMenu;
    }
}
