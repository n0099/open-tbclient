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
/* loaded from: classes7.dex */
public class j extends c implements a.InterfaceC0468a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cEw;
    private DuMixGameSurfaceView cJF;
    private ImageView cJG;
    private View cJH;
    private ImageView cJI;
    private FrameLayout cJJ;
    private View cJK;
    private com.baidu.swan.games.view.d cJL;
    private com.baidu.swan.games.view.d cJM;
    private TextView cJO;
    private b cJP;
    private a cJQ;
    private GameCloseGuidePopView cJS;
    private View cJU;
    private boolean cJV;
    private OrientationEventListener csF;
    private com.baidu.swan.apps.res.widget.floatlayer.a csI;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cJN = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cwu = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cJR = "landscape";
    private boolean cJT = false;

    public static j aoK() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aVz().a(j.this.cIp, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        al(inflate);
        aoL();
        return inflate;
    }

    public void al(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cJJ = frameLayout;
        this.cJF = com.baidu.swan.games.j.a.aUI().aUK();
        if (this.cJF != null && this.cJF.getParent() == null) {
            frameLayout.addView(this.cJF, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aDX()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cJO = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            aoW();
        }
        av(view);
        this.cJM = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cJL = new com.baidu.swan.games.view.d(this.cJJ);
    }

    private void aoL() {
        if (this.cJF != null) {
            this.cJF.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.aoM()) {
                        com.baidu.swan.apps.ap.e.N(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoM() {
        f afe = afe();
        return afe != null && (afe.aot() instanceof j);
    }

    private void av(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cJG = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cJH = view.findViewById(a.f.titlebar_right_menu_line);
        this.cJI = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cJG.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cJI.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cJH.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.anh();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = UgcConstant.MENU;
                j.this.a(fVar);
            }
        });
        this.cJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aDV()) {
                    if (com.baidu.swan.apps.runtime.e.aGM() != null && com.baidu.swan.apps.p.c.auK().auL()) {
                        j.this.na("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b auF = new com.baidu.swan.apps.p.b().auF();
                    if (auF.isShow()) {
                        com.baidu.swan.apps.p.c.auK().a(j.this.mActivity, auF.getImageUrl(), auF.auJ(), j.this.any());
                        return;
                    }
                    j.this.na("exitButton");
                }
            }
        });
    }

    public boolean na(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                aoO();
            }
            return false;
        }
        this.cJU = com.baidu.swan.games.m.a.aVB().a(this.mActivity, aoN());
        if (this.cJU != null) {
            this.cJJ.addView(this.cJU);
            this.cJV = true;
            com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
            return true;
        }
        if (this.cJS == null) {
            this.cJS = new GameCloseGuidePopView(getContext());
            this.cJS.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void aoZ() {
                    if (j.this.cJS != null) {
                        j.this.cJJ.removeView(j.this.cJS);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apa() {
                    j.this.aoO();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apb() {
                    j.this.aoO();
                }
            });
        }
        this.cJJ.addView(this.cJS);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a any() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void anV() {
                j.this.aoO();
            }
        };
    }

    private GameCloseGuidePopView.a aoN() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void aoZ() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apa() {
                if (j.this.cJU != null) {
                    j.this.cJJ.removeView(j.this.cJU);
                    j.this.cJU = null;
                }
                j.this.aoO();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apb() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoO() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).hl(1);
        ap.aMC().ln(2);
    }

    private void aoP() {
        if (ah.cP(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.avS(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aoP();
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
    public com.baidu.swan.games.u.a.b.a aoQ() {
        return this.cJN;
    }

    @NonNull
    public com.baidu.swan.games.view.b aoR() {
        return this.cwu;
    }

    public com.baidu.swan.games.view.d aoS() {
        return this.cJM;
    }

    public com.baidu.swan.games.view.d aoT() {
        return this.cJL;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cJF != null && this.cJF.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cJF.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cJF.onResume();
            com.baidu.swan.games.audio.b.b.aSl().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).afg()));
            }
            v8Engine.onResume();
            if (this.cJJ != null && this.cJK != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cJJ.removeView(j.this.cJK);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cJL.aXv()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cJL.hI(isLandScape);
                    this.cJM.hI(isLandScape);
                }
                com.baidu.swan.apps.ap.e.N(this.mActivity);
            }
            if (this.csF == null) {
                this.csF = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cJL.aXv()) {
                            if (260 < i && i < 280 && j.this.cJR != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cJR = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cJR);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cJR);
                                }
                            } else if (80 < i && i < 100 && j.this.cJR != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cJR = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cJR);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cJR);
                                }
                            }
                        }
                    }
                };
            }
            if (this.csF.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.csF.enable();
            } else {
                this.csF.disable();
            }
            com.baidu.swan.games.b.d.aRN().startMonitor();
            com.baidu.swan.apps.media.b.fD(true);
            if (this.cJL != null) {
                this.cJL.avj();
            }
            if (this.cJM != null) {
                this.cJM.avj();
            }
            aoP();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cJK == null) {
            this.cJK = new View(this.mActivity);
        }
        this.cJJ.removeView(this.cJK);
        this.cJJ.addView(this.cJK, new FrameLayout.LayoutParams(-1, -1));
        if (this.cJS != null) {
            this.cJJ.removeView(this.cJS);
            this.cJS = null;
        }
        if (this.cJL != null) {
            this.cJL.avi();
        }
        if (this.cJM != null) {
            this.cJM.avi();
        }
        if (this.cJF != null && this.cJF.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cJF.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aUm()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aUh = v8Engine.aUh();
                if (aUh instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aUh).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aSl().pauseAll();
            com.baidu.swan.games.b.d.aRN().aRP();
            com.baidu.swan.apps.media.b.fD(false);
            this.cJF.onPause();
            if (this.csF != null) {
                this.csF.disable();
            }
            if (this.cIs != null && this.cIs.isShowing()) {
                this.cIs.dismiss(false);
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
            alA();
        }
        if (this.cJF != null) {
            this.cJF.setOnSystemUiVisibilityChangeListener(null);
            this.cJF.onDestroy();
        }
        if (this.cJV) {
            this.cJU = null;
            com.baidu.swan.games.m.a.aVB().release();
        }
        if (this.cJL != null) {
            this.cJL.aXy();
        }
        if (this.cJM != null) {
            this.cJM.aXy();
        }
        this.cwu.aiW();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.hz(false);
        com.baidu.swan.games.glsurface.a.b.aVi();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        aiA();
        if (com.baidu.swan.apps.runtime.e.aGN() != null) {
            this.cIs.setScreenOrientation(com.baidu.swan.apps.runtime.e.aGN().aGQ().getOrientation());
        }
        this.cIs.a(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState(), anQ(), this.cIt, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        if (com.baidu.l.a.aac()) {
            return com.baidu.l.a.aac();
        }
        if (com.baidu.swan.apps.runtime.e.aGM() != null && com.baidu.swan.apps.p.c.auK().auL()) {
            return na("backButton");
        }
        com.baidu.swan.apps.p.b auF = new com.baidu.swan.apps.p.b().auF();
        if (auF.isShow()) {
            com.baidu.swan.apps.p.c.auK().a(this.mActivity, auF.getImageUrl(), auF.auJ(), any());
            return true;
        }
        return na("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
        FragmentActivity bca = bca();
        if (bca != null) {
            if (this.cJT) {
                if (this.cIs != null && this.cIs.isShowing()) {
                    this.cIs.dismiss(false);
                }
                this.cIs = null;
                this.cJT = false;
            }
            if (this.cIt == null) {
                this.cIt = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cIs == null) {
                this.cIs = new com.baidu.swan.menu.h(bca, this.mMenu, 0, com.baidu.swan.apps.t.a.avW(), new com.baidu.swan.apps.view.c.b());
                this.cIs.mA(com.baidu.swan.apps.ap.e.aLE());
                this.cJN.b(this.cIs);
                com.baidu.swan.games.q.a ayU = com.baidu.swan.apps.v.f.azg().ayU();
                if (ayU != null) {
                    ayU.a(this.cIs);
                }
                new com.baidu.swan.apps.menu.a(this.cIs, this, this.cIt).aAV();
            }
        }
    }

    public com.baidu.swan.menu.h aoU() {
        return this.cIs;
    }

    public void eV(boolean z) {
        this.cJT = z;
    }

    public boolean aoV() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anl() {
        if (this.cJF != null && this.cJF.getV8Engine() != null) {
            this.cJF.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void aoW() {
        if (this.cEw) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cEw = true;
        this.cJP = new b();
        this.cJP.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void alA() {
        if (!this.cEw) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cEw = false;
        if (this.cJP != null) {
            this.cJP.removeMessages(0);
            this.cJP = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0468a
    public com.baidu.swan.apps.res.widget.floatlayer.a aeZ() {
        if (this.csI == null && this.cJM != null && this.cJM.aXu() != null) {
            this.csI = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cJM.aXu(), 0);
        }
        return this.csI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cJO != null) {
                String valueOf = String.valueOf(j.this.cJF == null ? 0 : j.this.cJF.getFPS());
                j.this.cJO.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cJP.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.aoX()) {
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
        if (!aoX() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cJQ == null) {
                this.cJQ = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cJQ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cJQ != null) {
                this.mAudioManager.abandonAudioFocus(this.cJQ);
                this.mAudioManager = null;
                this.cJQ = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoX() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        boolean booleanValue = aGM != null ? aGM.aHe().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View aoY() {
        return this.mMenu;
    }
}
