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
public class j extends c implements a.InterfaceC0444a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OrientationEventListener cfU;
    private com.baidu.swan.apps.res.widget.floatlayer.a cfX;
    private boolean crN;
    private DuMixGameSurfaceView cxa;
    private ImageView cxb;
    private View cxc;
    private ImageView cxd;
    private FrameLayout cxe;
    private View cxf;
    private com.baidu.swan.games.view.d cxg;
    private com.baidu.swan.games.view.d cxh;
    private TextView cxj;
    private b cxk;
    private a cxl;
    private GameCloseGuidePopView cxn;
    private View cxp;
    private boolean cxq;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cxi = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cjG = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cxm = "landscape";
    private boolean cxo = false;

    public static j akY() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aRN().a(j.this.cvK, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        an(inflate);
        akZ();
        return inflate;
    }

    public void an(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cxe = frameLayout;
        this.cxa = com.baidu.swan.games.j.a.aQW().aQY();
        if (this.cxa != null && this.cxa.getParent() == null) {
            frameLayout.addView(this.cxa, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aAl()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cxj = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            alk();
        }
        aq(view);
        this.cxh = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cxg = new com.baidu.swan.games.view.d(this.cxe);
    }

    private void akZ() {
        if (this.cxa != null) {
            this.cxa.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.ala()) {
                        com.baidu.swan.apps.ap.e.O(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ala() {
        f abs = abs();
        return abs != null && (abs.akH() instanceof j);
    }

    private void aq(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cxb = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cxc = view.findViewById(a.f.titlebar_right_menu_line);
        this.cxd = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cxb.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cxd.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cxc.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.ajv();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.cxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aAj()) {
                    if (com.baidu.swan.apps.runtime.e.aDa() != null && com.baidu.swan.apps.p.c.aqX().aqY()) {
                        j.this.my("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b aqS = new com.baidu.swan.apps.p.b().aqS();
                    if (aqS.isShow()) {
                        com.baidu.swan.apps.p.c.aqX().a(j.this.mActivity, aqS.getImageUrl(), aqS.aqW(), j.this.ajM());
                        return;
                    }
                    j.this.my("exitButton");
                }
            }
        });
    }

    public boolean my(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                alc();
            }
            return false;
        }
        this.cxp = com.baidu.swan.games.m.a.aRP().a(this.mActivity, alb());
        if (this.cxp != null) {
            this.cxe.addView(this.cxp);
            this.cxq = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.cxn == null) {
            this.cxn = new GameCloseGuidePopView(getContext());
            this.cxn.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aln() {
                    if (j.this.cxn != null) {
                        j.this.cxe.removeView(j.this.cxn);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void alo() {
                    j.this.alc();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void alp() {
                    j.this.alc();
                }
            });
        }
        this.cxe.addView(this.cxn);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a ajM() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void akj() {
                j.this.alc();
            }
        };
    }

    private GameCloseGuidePopView.a alb() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aln() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void alo() {
                if (j.this.cxp != null) {
                    j.this.cxe.removeView(j.this.cxp);
                    j.this.cxp = null;
                }
                j.this.alc();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void alp() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alc() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).gU(1);
        ap.aIQ().kW(2);
    }

    private void ald() {
        if (ah.cP(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.asf(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ald();
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
    public com.baidu.swan.games.u.a.b.a ale() {
        return this.cxi;
    }

    @NonNull
    public com.baidu.swan.games.view.b alf() {
        return this.cjG;
    }

    public com.baidu.swan.games.view.d alg() {
        return this.cxh;
    }

    public com.baidu.swan.games.view.d alh() {
        return this.cxg;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cxa != null && this.cxa.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cxa.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cxa.onResume();
            com.baidu.swan.games.audio.b.b.aOz().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).abu()));
            }
            v8Engine.onResume();
            if (this.cxe != null && this.cxf != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cxe.removeView(j.this.cxf);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cxg.aTJ()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cxg.hj(isLandScape);
                    this.cxh.hj(isLandScape);
                }
                com.baidu.swan.apps.ap.e.O(this.mActivity);
            }
            if (this.cfU == null) {
                this.cfU = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cxg.aTJ()) {
                            if (260 < i && i < 280 && j.this.cxm != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cxm = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cxm);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cxm);
                                }
                            } else if (80 < i && i < 100 && j.this.cxm != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cxm = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cxm);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cxm);
                                }
                            }
                        }
                    }
                };
            }
            if (this.cfU.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.cfU.enable();
            } else {
                this.cfU.disable();
            }
            com.baidu.swan.games.b.d.aOb().startMonitor();
            com.baidu.swan.apps.media.b.fe(true);
            if (this.cxg != null) {
                this.cxg.arw();
            }
            if (this.cxh != null) {
                this.cxh.arw();
            }
            ald();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cxf == null) {
            this.cxf = new View(this.mActivity);
        }
        this.cxe.removeView(this.cxf);
        this.cxe.addView(this.cxf, new FrameLayout.LayoutParams(-1, -1));
        if (this.cxn != null) {
            this.cxe.removeView(this.cxn);
            this.cxn = null;
        }
        if (this.cxg != null) {
            this.cxg.arv();
        }
        if (this.cxh != null) {
            this.cxh.arv();
        }
        if (this.cxa != null && this.cxa.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cxa.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aQA()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aQv = v8Engine.aQv();
                if (aQv instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aQv).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aOz().pauseAll();
            com.baidu.swan.games.b.d.aOb().aOd();
            com.baidu.swan.apps.media.b.fe(false);
            this.cxa.onPause();
            if (this.cfU != null) {
                this.cfU.disable();
            }
            if (this.cvN != null && this.cvN.isShowing()) {
                this.cvN.dismiss(false);
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
            ahO();
        }
        if (this.cxa != null) {
            this.cxa.setOnSystemUiVisibilityChangeListener(null);
            this.cxa.onDestroy();
        }
        if (this.cxq) {
            this.cxp = null;
            com.baidu.swan.games.m.a.aRP().release();
        }
        if (this.cxg != null) {
            this.cxg.aTM();
        }
        if (this.cxh != null) {
            this.cxh.aTM();
        }
        this.cjG.afk();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ha(false);
        com.baidu.swan.games.glsurface.a.b.aRw();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        aeO();
        if (com.baidu.swan.apps.runtime.e.aDb() != null) {
            this.cvN.setScreenOrientation(com.baidu.swan.apps.runtime.e.aDb().aDe().getOrientation());
        }
        this.cvN.a(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState(), ake(), this.cvO, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        if (com.baidu.l.a.Ws()) {
            return com.baidu.l.a.Ws();
        }
        if (com.baidu.swan.apps.runtime.e.aDa() != null && com.baidu.swan.apps.p.c.aqX().aqY()) {
            return my("backButton");
        }
        com.baidu.swan.apps.p.b aqS = new com.baidu.swan.apps.p.b().aqS();
        if (aqS.isShow()) {
            com.baidu.swan.apps.p.c.aqX().a(this.mActivity, aqS.getImageUrl(), aqS.aqW(), ajM());
            return true;
        }
        return my("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
        FragmentActivity aYo = aYo();
        if (aYo != null) {
            if (this.cxo) {
                if (this.cvN != null && this.cvN.isShowing()) {
                    this.cvN.dismiss(false);
                }
                this.cvN = null;
                this.cxo = false;
            }
            if (this.cvO == null) {
                this.cvO = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cvN == null) {
                this.cvN = new com.baidu.swan.menu.h(aYo, this.mMenu, 0, com.baidu.swan.apps.t.a.asj(), new com.baidu.swan.apps.view.c.b());
                this.cvN.mj(com.baidu.swan.apps.ap.e.aHS());
                this.cxi.b(this.cvN);
                com.baidu.swan.games.q.a avi = com.baidu.swan.apps.v.f.avu().avi();
                if (avi != null) {
                    avi.a(this.cvN);
                }
                new com.baidu.swan.apps.menu.a(this.cvN, this, this.cvO).axj();
            }
        }
    }

    public com.baidu.swan.menu.h ali() {
        return this.cvN;
    }

    public void ew(boolean z) {
        this.cxo = z;
    }

    public boolean alj() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ajz() {
        if (this.cxa != null && this.cxa.getV8Engine() != null) {
            this.cxa.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void alk() {
        if (this.crN) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.crN = true;
        this.cxk = new b();
        this.cxk.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void ahO() {
        if (!this.crN) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.crN = false;
        if (this.cxk != null) {
            this.cxk.removeMessages(0);
            this.cxk = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0444a
    public com.baidu.swan.apps.res.widget.floatlayer.a abn() {
        if (this.cfX == null && this.cxh != null && this.cxh.aTI() != null) {
            this.cfX = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cxh.aTI(), 0);
        }
        return this.cfX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cxj != null) {
                String valueOf = String.valueOf(j.this.cxa == null ? 0 : j.this.cxa.getFPS());
                j.this.cxj.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cxk.sendEmptyMessageDelayed(0, 500L);
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
                    if (!j.this.all()) {
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
        if (!all() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cxl == null) {
                this.cxl = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cxl, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cxl != null) {
                this.mAudioManager.abandonAudioFocus(this.cxl);
                this.mAudioManager = null;
                this.cxl = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean all() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        boolean booleanValue = aDa != null ? aDa.aDs().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View alm() {
        return this.mMenu;
    }
}
