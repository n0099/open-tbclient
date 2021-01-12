package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes8.dex */
public class j extends c implements a.InterfaceC0456a, com.baidu.swan.games.u.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cLz;
    private DuMixGameSurfaceView cQJ;
    private ImageView cQK;
    private View cQL;
    private ImageView cQM;
    private FrameLayout cQN;
    private View cQO;
    private com.baidu.swan.games.view.d cQP;
    private com.baidu.swan.games.view.d cQQ;
    private TextView cQS;
    private b cQT;
    private a cQU;
    private GameCloseGuidePopView cQW;
    private View cQY;
    private boolean cQZ;
    private OrientationEventListener czD;
    private com.baidu.swan.apps.res.widget.floatlayer.a czG;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private View mMenu;
    private com.baidu.swan.games.u.a.b.a cQR = new com.baidu.swan.games.u.a.b.a();
    private com.baidu.swan.games.view.b cDq = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String cQV = "landscape";
    private boolean cQX = false;

    public static j apq() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.m.a.aXf().a(j.this.cPr, j.this.getContext());
            }
        }, "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        ap(inflate);
        apr();
        return inflate;
    }

    public void ap(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.cQN = frameLayout;
        this.cQJ = com.baidu.swan.games.j.a.aWo().aWq();
        if (this.cQJ != null && this.cQJ.getParent() == null) {
            frameLayout.addView(this.cQJ, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aEF()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.cQS = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            apC();
        }
        aC(view);
        this.cQQ = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.cQP = new com.baidu.swan.games.view.d(this.cQN);
    }

    private void apr() {
        if (this.cQJ != null) {
            this.cQJ.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.j.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (j.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + j.this.mIsForeground);
                    }
                    if (j.this.mIsForeground || j.this.aps()) {
                        com.baidu.swan.apps.ao.e.O(j.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aps() {
        f afz = afz();
        return afz != null && (afz.aoY() instanceof j);
    }

    private void aC(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.cQK = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.cQL = view.findViewById(a.f.titlebar_right_menu_line);
        this.cQM = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.cQK.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.cQM.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.cQL.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.cQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.anH();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                j.this.a(fVar);
            }
        });
        this.cQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.DEBUG || !com.baidu.swan.apps.ad.a.a.aED()) {
                    if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.p.c.avq().avr()) {
                        j.this.mp("exitButton");
                        return;
                    }
                    com.baidu.swan.apps.p.b avl = new com.baidu.swan.apps.p.b().avl();
                    if (avl.isShow()) {
                        com.baidu.swan.apps.p.c.avq().a(j.this.mActivity, avl.getImageUrl(), avl.avp(), j.this.anY());
                        return;
                    }
                    j.this.mp("exitButton");
                }
            }
        });
    }

    public boolean mp(String str) {
        String currentDate = com.baidu.swan.games.view.recommend.popview.b.getCurrentDate();
        if (TextUtils.equals(currentDate, com.baidu.swan.games.view.recommend.popview.b.getString("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                apu();
            }
            return false;
        }
        this.cQY = com.baidu.swan.games.m.a.aXh().a(this.mActivity, apt());
        if (this.cQY != null) {
            this.cQN.addView(this.cQY);
            this.cQZ = true;
            com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
            return true;
        }
        if (this.cQW == null) {
            this.cQW = new GameCloseGuidePopView(getContext());
            this.cQW.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.5
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apF() {
                    if (j.this.cQW != null) {
                        j.this.cQN.removeView(j.this.cQW);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apG() {
                    j.this.apu();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void apH() {
                    j.this.apu();
                }
            });
        }
        this.cQN.addView(this.cQW);
        com.baidu.swan.games.view.recommend.popview.b.putString("date", currentDate);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a anY() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.j.6
            @Override // com.baidu.swan.apps.p.c.a
            public void aoA() {
                j.this.apu();
            }
        };
    }

    private GameCloseGuidePopView.a apt() {
        return new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.j.7
            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apF() {
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apG() {
                if (j.this.cQY != null) {
                    j.this.cQN.removeView(j.this.cQY);
                    j.this.cQY = null;
                }
                j.this.apu();
            }

            @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
            public void apH() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apu() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).fW(1);
        ap.aOh().kk(2);
    }

    private void apv() {
        if (ah.dN(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.awy(), a.h.aiapps_game_not_support_split_screen).aHZ();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        apv();
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
    public com.baidu.swan.games.u.a.b.a apw() {
        return this.cQR;
    }

    @NonNull
    public com.baidu.swan.games.view.b apx() {
        return this.cDq;
    }

    public com.baidu.swan.games.view.d apy() {
        return this.cQQ;
    }

    public com.baidu.swan.games.view.d apz() {
        return this.cQP;
    }

    public void resume() {
        requestAudioFocus();
        if (this.cQJ != null && this.cQJ.getV8Engine() != null) {
            final com.baidu.swan.games.f.a v8Engine = this.cQJ.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.cQJ.onResume();
            com.baidu.swan.games.audio.b.b.aTR().onResume();
            com.baidu.swan.games.z.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.p.e(((SwanAppActivity) this.mActivity).afB()));
            }
            v8Engine.onResume();
            if (this.cQN != null && this.cQO != null) {
                ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.cQN.removeView(j.this.cQO);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                if (!this.cQP.aZa()) {
                    this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                    this.cQP.il(isLandScape);
                    this.cQQ.il(isLandScape);
                }
                com.baidu.swan.apps.ao.e.O(this.mActivity);
            }
            if (this.czD == null) {
                this.czD = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.j.9
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (!j.this.cQP.aZa()) {
                            if (260 < i && i < 280 && j.this.cQV != "landscape") {
                                j.this.mActivity.setRequestedOrientation(0);
                                j.this.cQV = "landscape";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cQV);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cQV);
                                }
                            } else if (80 < i && i < 100 && j.this.cQV != "landscapeReverse") {
                                j.this.mActivity.setRequestedOrientation(8);
                                j.this.cQV = "landscapeReverse";
                                com.baidu.swan.games.z.a.b(v8Engine, j.this.cQV);
                                if (j.DEBUG) {
                                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.cQV);
                                }
                            }
                        }
                    }
                };
            }
            if (this.czD.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.czD.enable();
            } else {
                this.czD.disable();
            }
            com.baidu.swan.games.b.d.aTt().startMonitor();
            com.baidu.swan.apps.media.b.fX(true);
            if (this.cQP != null) {
                this.cQP.avP();
            }
            if (this.cQQ != null) {
                this.cQQ.avP();
            }
            apv();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        abandonAudioFocus();
        if (this.cQO == null) {
            this.cQO = new View(this.mActivity);
        }
        this.cQN.removeView(this.cQO);
        this.cQN.addView(this.cQO, new FrameLayout.LayoutParams(-1, -1));
        if (this.cQW != null) {
            this.cQN.removeView(this.cQW);
            this.cQW = null;
        }
        if (this.cQP != null) {
            this.cQP.avO();
        }
        if (this.cQQ != null) {
            this.cQQ.avO();
        }
        if (this.cQJ != null && this.cQJ.getV8Engine() != null) {
            com.baidu.swan.games.f.a v8Engine = this.cQJ.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.aVS()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.z.b.v(v8Engine);
                EventTarget aVN = v8Engine.aVN();
                if (aVN instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) aVN).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.aTR().pauseAll();
            com.baidu.swan.games.b.d.aTt().aTv();
            com.baidu.swan.apps.media.b.fX(false);
            this.cQJ.onPause();
            if (this.czD != null) {
                this.czD.disable();
            }
            if (this.cPu != null && this.cPu.isShowing()) {
                this.cPu.dismiss(false);
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
            amb();
        }
        if (this.cQJ != null) {
            this.cQJ.setOnSystemUiVisibilityChangeListener(null);
            this.cQJ.onDestroy();
        }
        if (this.cQZ) {
            this.cQY = null;
            com.baidu.swan.games.m.a.aXh().release();
        }
        if (this.cQP != null) {
            this.cQP.onPageDestroy();
        }
        if (this.cQQ != null) {
            this.cQQ.onPageDestroy();
        }
        this.cDq.ajv();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.ic(false);
        com.baidu.swan.games.glsurface.a.b.aWO();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
        Context context = getContext();
        if (context instanceof Activity) {
            w.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        aiZ();
        if (com.baidu.swan.apps.runtime.e.aIs() != null) {
            this.cPu.setScreenOrientation(com.baidu.swan.apps.runtime.e.aIs().aIv().getOrientation());
        }
        this.cPu.a(com.baidu.swan.apps.t.a.awU().ahK(), aov(), this.cPv, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        if (com.baidu.k.a.abo()) {
            return com.baidu.k.a.abo();
        }
        if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.p.c.avq().avr()) {
            return mp("backButton");
        }
        com.baidu.swan.apps.p.b avl = new com.baidu.swan.apps.p.b().avl();
        if (avl.isShow()) {
            com.baidu.swan.apps.p.c.avq().a(this.mActivity, avl.getImageUrl(), avl.avp(), anY());
            return true;
        }
        return mp("backButton");
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
        FragmentActivity bdH = bdH();
        if (bdH != null) {
            if (this.cQX) {
                if (this.cPu != null && this.cPu.isShowing()) {
                    this.cPu.dismiss(false);
                }
                this.cPu = null;
                this.cQX = false;
            }
            if (this.cPv == null) {
                this.cPv = new SwanAppMenuHeaderView(getContext());
            }
            if (this.cPu == null) {
                this.cPu = new com.baidu.swan.menu.g(bdH, this.mMenu, 0, com.baidu.swan.apps.t.a.awC(), new com.baidu.swan.apps.view.c.b());
                this.cPu.lB(com.baidu.swan.apps.ao.e.aNj());
                this.cQR.b(this.cPu);
                com.baidu.swan.games.q.a azB = com.baidu.swan.apps.v.f.azN().azB();
                if (azB != null) {
                    azB.a(this.cPu);
                }
                new com.baidu.swan.apps.menu.a(this.cPu, this, this.cPv).aBE();
            }
        }
    }

    public com.baidu.swan.menu.g apA() {
        return this.cPu;
    }

    public void fp(boolean z) {
        this.cQX = z;
    }

    public boolean apB() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anL() {
        if (this.cQJ != null && this.cQJ.getV8Engine() != null) {
            this.cQJ.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void apC() {
        if (this.cLz) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.cLz = true;
        this.cQT = new b();
        this.cQT.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void amb() {
        if (!this.cLz) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.cLz = false;
        if (this.cQT != null) {
            this.cQT.removeMessages(0);
            this.cQT = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0456a
    public com.baidu.swan.apps.res.widget.floatlayer.a afu() {
        if (this.czG == null && this.cQQ != null && this.cQQ.aYZ() != null) {
            this.czG = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.cQQ.aYZ(), 0);
        }
        return this.czG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.cQS != null) {
                String valueOf = String.valueOf(j.this.cQJ == null ? 0 : j.this.cQJ.getFPS());
                j.this.cQS.setText(valueOf);
                if (j.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.cQT.sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!j.this.apD()) {
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
        if (!apD() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cQU == null) {
                this.cQU = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cQU, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cQU != null) {
                this.mAudioManager.abandonAudioFocus(this.cQU);
                this.mAudioManager = null;
                this.cQU = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        boolean booleanValue = aIr != null ? aIr.aIJ().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View apE() {
        return this.mMenu;
    }
}
