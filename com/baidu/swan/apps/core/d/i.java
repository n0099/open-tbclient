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
/* loaded from: classes9.dex */
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0271a, com.baidu.swan.games.t.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener aVI;
    private com.baidu.swan.apps.res.widget.floatlayer.a aVL;
    private boolean aWi;
    private boolean bfE;
    private DuMixGameSurfaceView bjK;
    private ImageView bjL;
    private View bjM;
    private ImageView bjN;
    private FrameLayout bjO;
    private View bjP;
    private com.baidu.swan.games.view.d bjQ;
    private com.baidu.swan.games.view.d bjR;
    private TextView bjT;
    private b bjU;
    private a bjV;
    private GameCloseGuidePopView bjX;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a bjS = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b aYf = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bjW = "landscape";
    private boolean bjY = false;

    public static i LU() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        initView(inflate);
        LV();
        return inflate;
    }

    public void initView(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bjO = frameLayout;
        this.bjK = com.baidu.swan.games.i.a.alq().als();
        if (this.bjK != null && this.bjK.getParent() == null) {
            frameLayout.addView(this.bjK, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.XE()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bjT = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            Mg();
        }
        ae(view);
        this.bjR = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bjQ = new com.baidu.swan.games.view.d(this.bjO);
    }

    private void LV() {
        if (this.bjK != null) {
            this.bjK.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.LW()) {
                        com.baidu.swan.apps.as.c.S(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LW() {
        e DP = DP();
        return DP != null && (DP.LB() instanceof i);
    }

    private void ae(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.bjL = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.bjM = view.findViewById(a.f.titlebar_right_menu_line);
        this.bjN = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.bjL.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bjN.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.bjM.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.bjL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.KI();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bjN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.XC()) {
                    if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.q.c.Qy().Qz()) {
                        i.this.LX();
                        return;
                    }
                    com.baidu.swan.apps.q.b Qt = new com.baidu.swan.apps.q.b().Qt();
                    if (Qt.isShow()) {
                        com.baidu.swan.apps.q.c.Qy().a(i.this.mActivity, Qt.getImageUrl(), Qt.Qx(), i.this.KN());
                        return;
                    }
                    i.this.LX();
                }
            }
        });
    }

    public void LX() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            LY();
            return;
        }
        if (this.bjX == null) {
            this.bjX = new GameCloseGuidePopView(getContext());
            this.bjX.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Mj() {
                    if (i.this.bjX != null) {
                        i.this.bjO.removeView(i.this.bjX);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Mk() {
                    i.this.LY();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Ml() {
                    i.this.LY();
                }
            });
        }
        this.bjO.addView(this.bjX);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a KN() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void Lh() {
                i.this.LY();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LY() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dA(1);
    }

    private void LZ() {
        if (af.cH(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.Rk(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LZ();
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
    public com.baidu.swan.games.t.a.b.a Ma() {
        return this.bjS;
    }

    @NonNull
    public com.baidu.swan.games.view.b Mb() {
        return this.aYf;
    }

    public com.baidu.swan.games.view.d Mc() {
        return this.bjR;
    }

    public com.baidu.swan.games.view.d Md() {
        return this.bjQ;
    }

    public void resume() {
        EP();
        if (this.bjK != null && this.bjK.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.bjK.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.bjK.onResume();
            com.baidu.swan.games.audio.b.b.aiS().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).DR()));
            }
            v8Engine.onResume();
            if (this.bjO != null && this.bjP != null) {
                ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bjO.removeView(i.this.bjP);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bjQ.ex(isLandScape);
                this.bjR.ex(isLandScape);
                com.baidu.swan.apps.as.c.S(this.mActivity);
            }
            if (this.aVI == null) {
                this.aVI = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bjW != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bjW = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bjW);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bjW);
                            }
                        } else if (80 < i && i < 100 && i.this.bjW != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bjW = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bjW);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bjW);
                            }
                        }
                    }
                };
            }
            if (this.aVI.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.aVI.enable();
            } else {
                this.aVI.disable();
            }
            com.baidu.swan.apps.media.b.cG(true);
            if (this.bjQ != null) {
                this.bjQ.anM();
            }
            if (this.bjR != null) {
                this.bjR.anM();
            }
            LZ();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        EQ();
        if (this.bjP == null) {
            this.bjP = new View(this.mActivity);
        }
        this.bjO.removeView(this.bjP);
        this.bjO.addView(this.bjP, new FrameLayout.LayoutParams(-1, -1));
        if (this.bjX != null) {
            this.bjO.removeView(this.bjX);
            this.bjX = null;
        }
        if (this.bjQ != null) {
            this.bjQ.anN();
        }
        if (this.bjR != null) {
            this.bjR.anN();
        }
        if (this.bjK != null && this.bjK.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.bjK.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.akT()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget akN = v8Engine.akN();
                if (akN instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) akN).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aiS().pauseAll();
            com.baidu.swan.apps.media.b.cG(false);
            this.bjK.onPause();
            if (this.aVI != null) {
                this.aVI.disable();
            }
            if (this.bix != null && this.bix.isShowing()) {
                this.bix.eI(false);
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
            Jr();
        }
        if (this.bjK != null) {
            this.bjK.setOnSystemUiVisibilityChangeListener(null);
            this.bjK.onDestroy();
        }
        if (this.bjQ != null) {
            this.bjQ.anO();
        }
        if (this.bjR != null) {
            this.bjR.anO();
        }
        this.aYf.GW();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.es(false);
        com.baidu.swan.games.glsurface.a.b.alN();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KI() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Gv();
        if (com.baidu.swan.apps.runtime.e.ZT() != null) {
            this.bix.ia(com.baidu.swan.apps.runtime.e.ZT().ZV().getOrientation());
        }
        this.bix.g(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState(), Lc());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean KJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean FX() {
        return com.baidu.j.a.By();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Gv() {
        FragmentActivity arR = arR();
        if (arR != null) {
            if (this.bjY) {
                if (this.bix != null && this.bix.isShowing()) {
                    this.bix.eI(false);
                }
                this.bix = null;
                this.bjY = false;
            }
            if (this.bix == null) {
                this.bix = new com.baidu.swan.menu.h(arR, this.mMenu, 0, com.baidu.swan.apps.w.a.Ro(), new com.baidu.swan.apps.view.c.b());
                this.bix.hZ(com.baidu.swan.apps.as.c.adR());
                this.bjS.b(this.bix);
                com.baidu.swan.games.p.a TU = com.baidu.swan.apps.y.f.Uf().TU();
                if (TU != null) {
                    TU.a(this.bix);
                }
                new com.baidu.swan.apps.aa.a(this.bix, this).Vx();
            }
        }
    }

    public com.baidu.swan.menu.h Me() {
        return this.bix;
    }

    public void ck(boolean z) {
        this.bjY = z;
    }

    public boolean Mf() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Lf() {
        if (this.bjK != null && this.bjK.getV8Engine() != null) {
            this.bjK.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void Mg() {
        if (this.bfE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bfE = true;
        this.bjU = new b();
        this.bjU.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Jr() {
        if (!this.bfE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bfE = false;
        if (this.bjU != null) {
            this.bjU.removeMessages(0);
            this.bjU = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0271a
    public com.baidu.swan.apps.res.widget.floatlayer.a DK() {
        if (this.aVL == null && this.bjR != null && this.bjR.anJ() != null) {
            this.aVL = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bjR.anJ(), 0);
        }
        return this.aVL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bjT != null) {
                String valueOf = String.valueOf(i.this.bjK == null ? 0 : i.this.bjK.getFPS());
                i.this.bjT.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bjU.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!i.this.Mh()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.EQ();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.EQ();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void EP() {
        if (!Mh() && !this.aWi) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bjV == null) {
                this.bjV = new a();
            }
            this.aWi = this.mAudioManager.requestAudioFocus(this.bjV, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void EQ() {
        if (this.aWi) {
            if (this.mAudioManager != null && this.bjV != null) {
                this.mAudioManager.abandonAudioFocus(this.bjV);
                this.mAudioManager = null;
                this.bjV = null;
            }
            this.aWi = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mh() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        boolean booleanValue = ZS != null ? ZS.aai().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View Mi() {
        return this.mMenu;
    }
}
