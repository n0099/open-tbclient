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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes11.dex */
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0383a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener bLK;
    private com.baidu.swan.apps.res.widget.floatlayer.a bLN;
    private boolean bMm;
    private boolean bWP;
    private DuMixGameSurfaceView cbd;
    private ImageView cbe;
    private View cbf;
    private ImageView cbg;
    private FrameLayout cbh;
    private View cbi;
    private com.baidu.swan.games.view.d cbj;
    private com.baidu.swan.games.view.d cbk;
    private TextView cbm;
    private b cbn;
    private a cbo;
    private GameCloseGuidePopView cbq;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cbl = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bOV = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cbp = "landscape";
    private boolean cbr = false;

    public static i aap() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aBX().a(i.this.bZM, i.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ag(inflate);
        aaq();
        return inflate;
    }

    public void ag(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cbh = frameLayout;
        this.cbd = com.baidu.swan.games.j.a.aBj().aBl();
        if (this.cbd != null && this.cbd.getParent() == null) {
            frameLayout.addView(this.cbd, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.af.a.a.anl()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cbm = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            aaB();
        }
        aj(view);
        this.cbk = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cbj = new com.baidu.swan.games.view.d(this.cbh);
    }

    private void aaq() {
        if (this.cbd != null) {
            this.cbd.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.aar()) {
                        com.baidu.swan.apps.aq.d.O(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aar() {
        e RN = RN();
        return RN != null && (RN.ZV() instanceof i);
    }

    private void aj(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cbe = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cbf = view.findViewById(a.f.titlebar_right_menu_line);
        this.cbg = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cbe.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cbg.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cbf.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.YV();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.cbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.af.a.a.anj()) {
                    if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.o.c.afi().afj()) {
                        i.this.aas();
                        return;
                    }
                    com.baidu.swan.apps.o.b afd = new com.baidu.swan.apps.o.b().afd();
                    if (afd.isShow()) {
                        com.baidu.swan.apps.o.c.afi().a(i.this.mActivity, afd.getImageUrl(), afd.afh(), i.this.Zd());
                        return;
                    }
                    i.this.aas();
                }
            }
        });
    }

    public void aas() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            aat();
            return;
        }
        if (this.cbq == null) {
            this.cbq = new GameCloseGuidePopView(getContext());
            this.cbq.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aaE() {
                    if (i.this.cbq != null) {
                        i.this.cbh.removeView(i.this.cbq);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aaF() {
                    i.this.aat();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aaG() {
                    i.this.aat();
                }
            });
        }
        this.cbh.addView(this.cbq);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Zd() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.6
            @Override // com.baidu.swan.apps.o.c.a
            public void ZB() {
                i.this.aat();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aat() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).ep(1);
        an.ave().hV(2);
    }

    private void aau() {
        if (ag.cz(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.afX(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aau();
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

    @Override // com.baidu.swan.games.u.a.b.b
    @NonNull
    public com.baidu.swan.games.u.a.b.a aav() {
        return this.cbl;
    }

    @NonNull
    public com.baidu.swan.games.view.b aaw() {
        return this.bOV;
    }

    public com.baidu.swan.games.view.d aax() {
        return this.cbk;
    }

    public com.baidu.swan.games.view.d aay() {
        return this.cbj;
    }

    public void resume() {
        Gz();
        if (this.cbd != null && this.cbd.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cbd.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cbd.onResume();
            com.baidu.swan.games.audio.b.b.ayL().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).RP()));
            }
            v8Engine.onResume();
            if (this.cbh != null && this.cbi != null) {
                aj.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.cbh.removeView(i.this.cbi);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.cbj.fX(isLandScape);
                this.cbk.fX(isLandScape);
                com.baidu.swan.apps.aq.d.O(this.mActivity);
            }
            if (this.bLK == null) {
                this.bLK = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.8
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.cbp != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.cbp = "landscape";
                            com.baidu.swan.games.z.a.b(v8Engine, i.this.cbp);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.cbp);
                            }
                        } else if (80 < i && i < 100 && i.this.cbp != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.cbp = "landscapeReverse";
                            com.baidu.swan.games.z.a.b(v8Engine, i.this.cbp);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.cbp);
                            }
                        }
                    }
                };
            }
            if (this.bLK.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bLK.enable();
            } else {
                this.bLK.disable();
            }
            com.baidu.swan.games.b.d.ayn().startMonitor();
            com.baidu.swan.apps.media.b.el(true);
            if (this.cbj != null) {
                this.cbj.aDI();
            }
            if (this.cbk != null) {
                this.cbk.aDI();
            }
            aau();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        GA();
        if (this.cbi == null) {
            this.cbi = new View(this.mActivity);
        }
        this.cbh.removeView(this.cbi);
        this.cbh.addView(this.cbi, new FrameLayout.LayoutParams(-1, -1));
        if (this.cbq != null) {
            this.cbh.removeView(this.cbq);
            this.cbq = null;
        }
        if (this.cbj != null) {
            this.cbj.aDJ();
        }
        if (this.cbk != null) {
            this.cbk.aDJ();
        }
        if (this.cbd != null && this.cbd.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cbd.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aAM()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aAH = v8Engine.aAH();
                if (aAH instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aAH).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.ayL().pauseAll();
            com.baidu.swan.games.b.d.ayn().ayp();
            com.baidu.swan.apps.media.b.el(false);
            this.cbd.onPause();
            if (this.bLK != null) {
                this.bLK.disable();
            }
            if (this.bZP != null && this.bZP.isShowing()) {
                this.bZP.gi(false);
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
            XH();
        }
        if (this.cbd != null) {
            this.cbd.setOnSystemUiVisibilityChangeListener(null);
            this.cbd.onDestroy();
        }
        if (this.cbj != null) {
            this.cbj.aDK();
        }
        if (this.cbk != null) {
            this.cbk.aDK();
        }
        this.bOV.Ve();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.fS(false);
        com.baidu.swan.games.glsurface.a.b.aBG();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
        Context context = getContext();
        if (context instanceof Activity) {
            u.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        UI();
        if (com.baidu.swan.apps.runtime.e.apN() != null) {
            this.bZP.jc(com.baidu.swan.apps.runtime.e.apN().apQ().getOrientation());
        }
        this.bZP.n(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), Zv());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return com.baidu.g.a.NM();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
        FragmentActivity aIB = aIB();
        if (aIB != null) {
            if (this.cbr) {
                if (this.bZP != null && this.bZP.isShowing()) {
                    this.bZP.gi(false);
                }
                this.bZP = null;
                this.cbr = false;
            }
            if (this.bZP == null) {
                this.bZP = new com.baidu.swan.menu.h(aIB, this.mMenu, 0, com.baidu.swan.apps.u.a.agb(), new com.baidu.swan.apps.view.c.b());
                this.bZP.jb(com.baidu.swan.apps.aq.d.aun());
                this.cbl.b(this.bZP);
                com.baidu.swan.games.q.a aiP = com.baidu.swan.apps.w.f.ajb().aiP();
                if (aiP != null) {
                    aiP.a(this.bZP);
                }
                new com.baidu.swan.apps.y.a(this.bZP, this).akM();
            }
        }
    }

    public com.baidu.swan.menu.h aaz() {
        return this.bZP;
    }

    public void dN(boolean z) {
        this.cbr = z;
    }

    public boolean aaA() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Zy() {
        if (this.cbd != null && this.cbd.getV8Engine() != null) {
            this.cbd.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void aaB() {
        if (this.bWP) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bWP = true;
        this.cbn = new b();
        this.cbn.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void XH() {
        if (!this.bWP) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bWP = false;
        if (this.cbn != null) {
            this.cbn.removeMessages(0);
            this.cbn = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0383a
    public com.baidu.swan.apps.res.widget.floatlayer.a RI() {
        if (this.bLN == null && this.cbk != null && this.cbk.aDF() != null) {
            this.bLN = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cbk.aDF(), 0);
        }
        return this.bLN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.cbm != null) {
                String valueOf = String.valueOf(i.this.cbd == null ? 0 : i.this.cbd.getFPS());
                i.this.cbm.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.cbn.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!i.this.aaC()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.GA();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.GA();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void Gz() {
        if (!aaC() && !this.bMm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cbo == null) {
                this.cbo = new a();
            }
            this.bMm = this.mAudioManager.requestAudioFocus(this.cbo, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void GA() {
        if (this.bMm) {
            if (this.mAudioManager != null && this.cbo != null) {
                this.mAudioManager.abandonAudioFocus(this.cbo);
                this.mAudioManager = null;
                this.cbo = null;
            }
            this.bMm = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaC() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        boolean booleanValue = apM != null ? apM.aqe().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aaD() {
        return this.mMenu;
    }
}
