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
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0283a, com.baidu.swan.games.t.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener baM;
    private com.baidu.swan.apps.res.widget.floatlayer.a baP;
    private boolean bbm;
    private boolean bkH;
    private DuMixGameSurfaceView boK;
    private ImageView boL;
    private View boM;
    private ImageView boN;
    private FrameLayout boO;
    private View boP;
    private com.baidu.swan.games.view.d boQ;
    private com.baidu.swan.games.view.d boR;
    private TextView boT;
    private b boU;
    private a boV;
    private GameCloseGuidePopView boX;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a boS = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b bdi = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String boW = "landscape";
    private boolean boY = false;

    public static i OG() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        initView(inflate);
        OH();
        return inflate;
    }

    public void initView(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.boO = frameLayout;
        this.boK = com.baidu.swan.games.i.a.anY().aoa();
        if (this.boK != null && this.boK.getParent() == null) {
            frameLayout.addView(this.boK, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aar()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.boT = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            OS();
        }
        ai(view);
        this.boR = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.boQ = new com.baidu.swan.games.view.d(this.boO);
    }

    private void OH() {
        if (this.boK != null) {
            this.boK.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.OI()) {
                        com.baidu.swan.apps.as.c.U(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OI() {
        e GC = GC();
        return GC != null && (GC.On() instanceof i);
    }

    private void ai(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.boL = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.boM = view.findViewById(a.f.titlebar_right_menu_line);
        this.boN = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.boL.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.boN.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.boM.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.boL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Nv();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.boN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.aap()) {
                    if (com.baidu.swan.apps.runtime.e.acF() != null && com.baidu.swan.apps.q.c.Tk().Tl()) {
                        i.this.OJ();
                        return;
                    }
                    com.baidu.swan.apps.q.b Tf = new com.baidu.swan.apps.q.b().Tf();
                    if (Tf.isShow()) {
                        com.baidu.swan.apps.q.c.Tk().a(i.this.mActivity, Tf.getImageUrl(), Tf.Tj(), i.this.Nz());
                        return;
                    }
                    i.this.OJ();
                }
            }
        });
    }

    public void OJ() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            OK();
            return;
        }
        if (this.boX == null) {
            this.boX = new GameCloseGuidePopView(getContext());
            this.boX.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OV() {
                    if (i.this.boX != null) {
                        i.this.boO.removeView(i.this.boX);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OW() {
                    i.this.OK();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OX() {
                    i.this.OK();
                }
            });
        }
        this.boO.addView(this.boX);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Nz() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void NT() {
                i.this.OK();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OK() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dR(1);
    }

    private void OL() {
        if (af.cL(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TW(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OL();
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
    public com.baidu.swan.games.t.a.b.a OM() {
        return this.boS;
    }

    @NonNull
    public com.baidu.swan.games.view.b ON() {
        return this.bdi;
    }

    public com.baidu.swan.games.view.d OO() {
        return this.boR;
    }

    public com.baidu.swan.games.view.d OP() {
        return this.boQ;
    }

    public void resume() {
        HC();
        if (this.boK != null && this.boK.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.boK.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.boK.onResume();
            com.baidu.swan.games.audio.b.b.alB().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).GE()));
            }
            v8Engine.onResume();
            if (this.boO != null && this.boP != null) {
                ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.boO.removeView(i.this.boP);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.boQ.eJ(isLandScape);
                this.boR.eJ(isLandScape);
                com.baidu.swan.apps.as.c.U(this.mActivity);
            }
            if (this.baM == null) {
                this.baM = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.boW != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.boW = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.boW);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.boW);
                            }
                        } else if (80 < i && i < 100 && i.this.boW != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.boW = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.boW);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.boW);
                            }
                        }
                    }
                };
            }
            if (this.baM.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.baM.enable();
            } else {
                this.baM.disable();
            }
            com.baidu.swan.apps.media.b.cS(true);
            if (this.boQ != null) {
                this.boQ.aqv();
            }
            if (this.boR != null) {
                this.boR.aqv();
            }
            OL();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        HD();
        if (this.boP == null) {
            this.boP = new View(this.mActivity);
        }
        this.boO.removeView(this.boP);
        this.boO.addView(this.boP, new FrameLayout.LayoutParams(-1, -1));
        if (this.boX != null) {
            this.boO.removeView(this.boX);
            this.boX = null;
        }
        if (this.boQ != null) {
            this.boQ.aqw();
        }
        if (this.boR != null) {
            this.boR.aqw();
        }
        if (this.boK != null && this.boK.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.boK.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.anB()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget anw = v8Engine.anw();
                if (anw instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) anw).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.alB().pauseAll();
            com.baidu.swan.apps.media.b.cS(false);
            this.boK.onPause();
            if (this.baM != null) {
                this.baM.disable();
            }
            if (this.bnx != null && this.bnx.isShowing()) {
                this.bnx.eU(false);
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
            Me();
        }
        if (this.boK != null) {
            this.boK.setOnSystemUiVisibilityChangeListener(null);
            this.boK.onDestroy();
        }
        if (this.boQ != null) {
            this.boQ.aqx();
        }
        if (this.boR != null) {
            this.boR.aqx();
        }
        this.bdi.JJ();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.eE(false);
        com.baidu.swan.games.glsurface.a.b.aov();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Ji();
        if (com.baidu.swan.apps.runtime.e.acG() != null) {
            this.bnx.ir(com.baidu.swan.apps.runtime.e.acG().acI().getOrientation());
        }
        this.bnx.i(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState(), NO());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        return com.baidu.j.a.Es();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ji() {
        FragmentActivity auA = auA();
        if (auA != null) {
            if (this.boY) {
                if (this.bnx != null && this.bnx.isShowing()) {
                    this.bnx.eU(false);
                }
                this.bnx = null;
                this.boY = false;
            }
            if (this.bnx == null) {
                this.bnx = new com.baidu.swan.menu.h(auA, this.mMenu, 0, com.baidu.swan.apps.w.a.Ua(), new com.baidu.swan.apps.view.c.b());
                this.bnx.iq(com.baidu.swan.apps.as.c.agA());
                this.boS.b(this.bnx);
                com.baidu.swan.games.p.a WH = com.baidu.swan.apps.y.f.WS().WH();
                if (WH != null) {
                    WH.a(this.bnx);
                }
                new com.baidu.swan.apps.aa.a(this.bnx, this).Yk();
            }
        }
    }

    public com.baidu.swan.menu.h OQ() {
        return this.bnx;
    }

    public void cw(boolean z) {
        this.boY = z;
    }

    public boolean OR() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NR() {
        if (this.boK != null && this.boK.getV8Engine() != null) {
            this.boK.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void OS() {
        if (this.bkH) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bkH = true;
        this.boU = new b();
        this.boU.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Me() {
        if (!this.bkH) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bkH = false;
        if (this.boU != null) {
            this.boU.removeMessages(0);
            this.boU = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a Gx() {
        if (this.baP == null && this.boR != null && this.boR.aqs() != null) {
            this.baP = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.boR.aqs(), 0);
        }
        return this.baP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.boT != null) {
                String valueOf = String.valueOf(i.this.boK == null ? 0 : i.this.boK.getFPS());
                i.this.boT.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.boU.sendEmptyMessageDelayed(0, 500L);
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
                    if (!i.this.OT()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.HD();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.HD();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void HC() {
        if (!OT() && !this.bbm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.boV == null) {
                this.boV = new a();
            }
            this.bbm = this.mAudioManager.requestAudioFocus(this.boV, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void HD() {
        if (this.bbm) {
            if (this.mAudioManager != null && this.boV != null) {
                this.mAudioManager.abandonAudioFocus(this.boV);
                this.mAudioManager = null;
                this.boV = null;
            }
            this.bbm = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OT() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        boolean booleanValue = acF != null ? acF.acV().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View OU() {
        return this.mMenu;
    }
}
