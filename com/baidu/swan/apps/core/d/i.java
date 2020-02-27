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
    private OrientationEventListener baL;
    private com.baidu.swan.apps.res.widget.floatlayer.a baO;
    private boolean bbl;
    private boolean bkG;
    private DuMixGameSurfaceView boJ;
    private ImageView boK;
    private View boL;
    private ImageView boM;
    private FrameLayout boN;
    private View boO;
    private com.baidu.swan.games.view.d boP;
    private com.baidu.swan.games.view.d boQ;
    private TextView boS;
    private b boT;
    private a boU;
    private GameCloseGuidePopView boW;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a boR = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b bdh = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String boV = "landscape";
    private boolean boX = false;

    public static i OE() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        initView(inflate);
        OF();
        return inflate;
    }

    public void initView(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.boN = frameLayout;
        this.boJ = com.baidu.swan.games.i.a.anW().anY();
        if (this.boJ != null && this.boJ.getParent() == null) {
            frameLayout.addView(this.boJ, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aap()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.boS = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            OQ();
        }
        ai(view);
        this.boQ = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.boP = new com.baidu.swan.games.view.d(this.boN);
    }

    private void OF() {
        if (this.boJ != null) {
            this.boJ.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.OG()) {
                        com.baidu.swan.apps.as.c.U(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OG() {
        e GA = GA();
        return GA != null && (GA.Ol() instanceof i);
    }

    private void ai(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.boK = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.boL = view.findViewById(a.f.titlebar_right_menu_line);
        this.boM = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.boK.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.boM.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.boL.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.boK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Nt();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.boM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.aan()) {
                    if (com.baidu.swan.apps.runtime.e.acD() != null && com.baidu.swan.apps.q.c.Ti().Tj()) {
                        i.this.OH();
                        return;
                    }
                    com.baidu.swan.apps.q.b Td = new com.baidu.swan.apps.q.b().Td();
                    if (Td.isShow()) {
                        com.baidu.swan.apps.q.c.Ti().a(i.this.mActivity, Td.getImageUrl(), Td.Th(), i.this.Nx());
                        return;
                    }
                    i.this.OH();
                }
            }
        });
    }

    public void OH() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            OI();
            return;
        }
        if (this.boW == null) {
            this.boW = new GameCloseGuidePopView(getContext());
            this.boW.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OT() {
                    if (i.this.boW != null) {
                        i.this.boN.removeView(i.this.boW);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OU() {
                    i.this.OI();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OV() {
                    i.this.OI();
                }
            });
        }
        this.boN.addView(this.boW);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Nx() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void NR() {
                i.this.OI();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dR(1);
    }

    private void OJ() {
        if (af.cL(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TU(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OJ();
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
    public com.baidu.swan.games.t.a.b.a OK() {
        return this.boR;
    }

    @NonNull
    public com.baidu.swan.games.view.b OL() {
        return this.bdh;
    }

    public com.baidu.swan.games.view.d OM() {
        return this.boQ;
    }

    public com.baidu.swan.games.view.d ON() {
        return this.boP;
    }

    public void resume() {
        HA();
        if (this.boJ != null && this.boJ.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.boJ.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.boJ.onResume();
            com.baidu.swan.games.audio.b.b.alz().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).GC()));
            }
            v8Engine.onResume();
            if (this.boN != null && this.boO != null) {
                ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.boN.removeView(i.this.boO);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.boP.eJ(isLandScape);
                this.boQ.eJ(isLandScape);
                com.baidu.swan.apps.as.c.U(this.mActivity);
            }
            if (this.baL == null) {
                this.baL = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.boV != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.boV = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.boV);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.boV);
                            }
                        } else if (80 < i && i < 100 && i.this.boV != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.boV = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.boV);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.boV);
                            }
                        }
                    }
                };
            }
            if (this.baL.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.baL.enable();
            } else {
                this.baL.disable();
            }
            com.baidu.swan.apps.media.b.cS(true);
            if (this.boP != null) {
                this.boP.aqt();
            }
            if (this.boQ != null) {
                this.boQ.aqt();
            }
            OJ();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        HB();
        if (this.boO == null) {
            this.boO = new View(this.mActivity);
        }
        this.boN.removeView(this.boO);
        this.boN.addView(this.boO, new FrameLayout.LayoutParams(-1, -1));
        if (this.boW != null) {
            this.boN.removeView(this.boW);
            this.boW = null;
        }
        if (this.boP != null) {
            this.boP.aqu();
        }
        if (this.boQ != null) {
            this.boQ.aqu();
        }
        if (this.boJ != null && this.boJ.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.boJ.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.anz()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget anu = v8Engine.anu();
                if (anu instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) anu).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.alz().pauseAll();
            com.baidu.swan.apps.media.b.cS(false);
            this.boJ.onPause();
            if (this.baL != null) {
                this.baL.disable();
            }
            if (this.bnw != null && this.bnw.isShowing()) {
                this.bnw.eU(false);
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
            Mc();
        }
        if (this.boJ != null) {
            this.boJ.setOnSystemUiVisibilityChangeListener(null);
            this.boJ.onDestroy();
        }
        if (this.boP != null) {
            this.boP.aqv();
        }
        if (this.boQ != null) {
            this.boQ.aqv();
        }
        this.bdh.JH();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.eE(false);
        com.baidu.swan.games.glsurface.a.b.aot();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Jg();
        if (com.baidu.swan.apps.runtime.e.acE() != null) {
            this.bnw.ir(com.baidu.swan.apps.runtime.e.acE().acG().getOrientation());
        }
        this.bnw.i(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState(), NM());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        return com.baidu.j.a.Eq();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
        FragmentActivity auy = auy();
        if (auy != null) {
            if (this.boX) {
                if (this.bnw != null && this.bnw.isShowing()) {
                    this.bnw.eU(false);
                }
                this.bnw = null;
                this.boX = false;
            }
            if (this.bnw == null) {
                this.bnw = new com.baidu.swan.menu.h(auy, this.mMenu, 0, com.baidu.swan.apps.w.a.TY(), new com.baidu.swan.apps.view.c.b());
                this.bnw.iq(com.baidu.swan.apps.as.c.agy());
                this.boR.b(this.bnw);
                com.baidu.swan.games.p.a WF = com.baidu.swan.apps.y.f.WQ().WF();
                if (WF != null) {
                    WF.a(this.bnw);
                }
                new com.baidu.swan.apps.aa.a(this.bnw, this).Yi();
            }
        }
    }

    public com.baidu.swan.menu.h OO() {
        return this.bnw;
    }

    public void cw(boolean z) {
        this.boX = z;
    }

    public boolean OP() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NP() {
        if (this.boJ != null && this.boJ.getV8Engine() != null) {
            this.boJ.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void OQ() {
        if (this.bkG) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bkG = true;
        this.boT = new b();
        this.boT.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Mc() {
        if (!this.bkG) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bkG = false;
        if (this.boT != null) {
            this.boT.removeMessages(0);
            this.boT = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a Gv() {
        if (this.baO == null && this.boQ != null && this.boQ.aqq() != null) {
            this.baO = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.boQ.aqq(), 0);
        }
        return this.baO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.boS != null) {
                String valueOf = String.valueOf(i.this.boJ == null ? 0 : i.this.boJ.getFPS());
                i.this.boS.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.boT.sendEmptyMessageDelayed(0, 500L);
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
                    if (!i.this.OR()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.HB();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.HB();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void HA() {
        if (!OR() && !this.bbl) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.boU == null) {
                this.boU = new a();
            }
            this.bbl = this.mAudioManager.requestAudioFocus(this.boU, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void HB() {
        if (this.bbl) {
            if (this.mAudioManager != null && this.boU != null) {
                this.mAudioManager.abandonAudioFocus(this.boU);
                this.mAudioManager = null;
                this.boU = null;
            }
            this.bbl = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OR() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        boolean booleanValue = acD != null ? acD.acT().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View OS() {
        return this.mMenu;
    }
}
