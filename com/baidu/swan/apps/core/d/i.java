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
public class i extends com.baidu.swan.apps.core.d.b implements a.InterfaceC0377a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener bGW;
    private com.baidu.swan.apps.res.widget.floatlayer.a bGZ;
    private boolean bHy;
    private boolean bSb;
    private a bWA;
    private GameCloseGuidePopView bWC;
    private DuMixGameSurfaceView bWp;
    private ImageView bWq;
    private View bWr;
    private ImageView bWs;
    private FrameLayout bWt;
    private View bWu;
    private com.baidu.swan.games.view.d bWv;
    private com.baidu.swan.games.view.d bWw;
    private TextView bWy;
    private b bWz;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a bWx = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b bKh = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bWB = "landscape";
    private boolean bWD = false;

    public static i Zj() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aAR().a(i.this.bUY, i.this.getContext());
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
        Zk();
        return inflate;
    }

    public void ag(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bWt = frameLayout;
        this.bWp = com.baidu.swan.games.j.a.aAd().aAf();
        if (this.bWp != null && this.bWp.getParent() == null) {
            frameLayout.addView(this.bWp, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.af.a.a.amf()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bWy = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            Zv();
        }
        aj(view);
        this.bWw = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bWv = new com.baidu.swan.games.view.d(this.bWt);
    }

    private void Zk() {
        if (this.bWp != null) {
            this.bWp.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.Zl()) {
                        com.baidu.swan.apps.aq.d.O(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zl() {
        e QH = QH();
        return QH != null && (QH.YP() instanceof i);
    }

    private void aj(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.bWq = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.bWr = view.findViewById(a.f.titlebar_right_menu_line);
        this.bWs = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.bWq.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bWs.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.bWr.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.bWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.XP();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.af.a.a.amd()) {
                    if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.o.c.aec().aed()) {
                        i.this.Zm();
                        return;
                    }
                    com.baidu.swan.apps.o.b adX = new com.baidu.swan.apps.o.b().adX();
                    if (adX.isShow()) {
                        com.baidu.swan.apps.o.c.aec().a(i.this.mActivity, adX.getImageUrl(), adX.aeb(), i.this.XX());
                        return;
                    }
                    i.this.Zm();
                }
            }
        });
    }

    public void Zm() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            Zn();
            return;
        }
        if (this.bWC == null) {
            this.bWC = new GameCloseGuidePopView(getContext());
            this.bWC.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Zy() {
                    if (i.this.bWC != null) {
                        i.this.bWt.removeView(i.this.bWC);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Zz() {
                    i.this.Zn();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void ZA() {
                    i.this.Zn();
                }
            });
        }
        this.bWt.addView(this.bWC);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a XX() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.6
            @Override // com.baidu.swan.apps.o.c.a
            public void Yv() {
                i.this.Zn();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zn() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).ee(1);
        an.atY().hK(2);
    }

    private void Zo() {
        if (ag.cy(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.aeR(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Zo();
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
    public com.baidu.swan.games.u.a.b.a Zp() {
        return this.bWx;
    }

    @NonNull
    public com.baidu.swan.games.view.b Zq() {
        return this.bKh;
    }

    public com.baidu.swan.games.view.d Zr() {
        return this.bWw;
    }

    public com.baidu.swan.games.view.d Zs() {
        return this.bWv;
    }

    public void resume() {
        FQ();
        if (this.bWp != null && this.bWp.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.bWp.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.bWp.onResume();
            com.baidu.swan.games.audio.b.b.axF().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).QJ()));
            }
            v8Engine.onResume();
            if (this.bWt != null && this.bWu != null) {
                aj.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bWt.removeView(i.this.bWu);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bWv.fS(isLandScape);
                this.bWw.fS(isLandScape);
                com.baidu.swan.apps.aq.d.O(this.mActivity);
            }
            if (this.bGW == null) {
                this.bGW = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.8
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bWB != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bWB = "landscape";
                            com.baidu.swan.games.z.a.b(v8Engine, i.this.bWB);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bWB);
                            }
                        } else if (80 < i && i < 100 && i.this.bWB != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bWB = "landscapeReverse";
                            com.baidu.swan.games.z.a.b(v8Engine, i.this.bWB);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bWB);
                            }
                        }
                    }
                };
            }
            if (this.bGW.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bGW.enable();
            } else {
                this.bGW.disable();
            }
            com.baidu.swan.games.b.d.axh().startMonitor();
            com.baidu.swan.apps.media.b.eg(true);
            if (this.bWv != null) {
                this.bWv.aCC();
            }
            if (this.bWw != null) {
                this.bWw.aCC();
            }
            Zo();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        FR();
        if (this.bWu == null) {
            this.bWu = new View(this.mActivity);
        }
        this.bWt.removeView(this.bWu);
        this.bWt.addView(this.bWu, new FrameLayout.LayoutParams(-1, -1));
        if (this.bWC != null) {
            this.bWt.removeView(this.bWC);
            this.bWC = null;
        }
        if (this.bWv != null) {
            this.bWv.aCD();
        }
        if (this.bWw != null) {
            this.bWw.aCD();
        }
        if (this.bWp != null && this.bWp.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.bWp.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.azG()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget azB = v8Engine.azB();
                if (azB instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) azB).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.axF().pauseAll();
            com.baidu.swan.games.b.d.axh().axj();
            com.baidu.swan.apps.media.b.eg(false);
            this.bWp.onPause();
            if (this.bGW != null) {
                this.bGW.disable();
            }
            if (this.bVb != null && this.bVb.isShowing()) {
                this.bVb.gd(false);
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
            WB();
        }
        if (this.bWp != null) {
            this.bWp.setOnSystemUiVisibilityChangeListener(null);
            this.bWp.onDestroy();
        }
        if (this.bWv != null) {
            this.bWv.aCE();
        }
        if (this.bWw != null) {
            this.bWw.aCE();
        }
        this.bKh.TY();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.fN(false);
        com.baidu.swan.games.glsurface.a.b.aAA();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
        Context context = getContext();
        if (context instanceof Activity) {
            u.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        TC();
        if (com.baidu.swan.apps.runtime.e.aoG() != null) {
            this.bVb.iR(com.baidu.swan.apps.runtime.e.aoG().aoJ().getOrientation());
        }
        this.bVb.n(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState(), Yp());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        return com.baidu.g.a.MD();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
        FragmentActivity aHv = aHv();
        if (aHv != null) {
            if (this.bWD) {
                if (this.bVb != null && this.bVb.isShowing()) {
                    this.bVb.gd(false);
                }
                this.bVb = null;
                this.bWD = false;
            }
            if (this.bVb == null) {
                this.bVb = new com.baidu.swan.menu.h(aHv, this.mMenu, 0, com.baidu.swan.apps.u.a.aeV(), new com.baidu.swan.apps.view.c.b());
                this.bVb.iQ(com.baidu.swan.apps.aq.d.ath());
                this.bWx.b(this.bVb);
                com.baidu.swan.games.q.a ahJ = com.baidu.swan.apps.w.f.ahV().ahJ();
                if (ahJ != null) {
                    ahJ.a(this.bVb);
                }
                new com.baidu.swan.apps.y.a(this.bVb, this).ajG();
            }
        }
    }

    public com.baidu.swan.menu.h Zt() {
        return this.bVb;
    }

    public void dI(boolean z) {
        this.bWD = z;
    }

    public boolean Zu() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Ys() {
        if (this.bWp != null && this.bWp.getV8Engine() != null) {
            this.bWp.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void Zv() {
        if (this.bSb) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bSb = true;
        this.bWz = new b();
        this.bWz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void WB() {
        if (!this.bSb) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bSb = false;
        if (this.bWz != null) {
            this.bWz.removeMessages(0);
            this.bWz = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0377a
    public com.baidu.swan.apps.res.widget.floatlayer.a QC() {
        if (this.bGZ == null && this.bWw != null && this.bWw.aCz() != null) {
            this.bGZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bWw.aCz(), 0);
        }
        return this.bGZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bWy != null) {
                String valueOf = String.valueOf(i.this.bWp == null ? 0 : i.this.bWp.getFPS());
                i.this.bWy.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bWz.sendEmptyMessageDelayed(0, 500L);
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
                    if (!i.this.Zw()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.FR();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.FR();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void FQ() {
        if (!Zw() && !this.bHy) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bWA == null) {
                this.bWA = new a();
            }
            this.bHy = this.mAudioManager.requestAudioFocus(this.bWA, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void FR() {
        if (this.bHy) {
            if (this.mAudioManager != null && this.bWA != null) {
                this.mAudioManager.abandonAudioFocus(this.bWA);
                this.mAudioManager = null;
                this.bWA = null;
            }
            this.bHy = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zw() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        boolean booleanValue = aoF != null ? aoF.aoX().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View Zx() {
        return this.mMenu;
    }
}
