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
    private boolean bbA;
    private OrientationEventListener bba;
    private com.baidu.swan.apps.res.widget.floatlayer.a bbd;
    private boolean bkV;
    private DuMixGameSurfaceView boX;
    private ImageView boY;
    private View boZ;
    private ImageView bpa;
    private FrameLayout bpb;
    private View bpc;
    private com.baidu.swan.games.view.d bpd;
    private com.baidu.swan.games.view.d bpe;
    private TextView bpg;
    private b bph;
    private a bpi;
    private GameCloseGuidePopView bpk;
    private AudioManager mAudioManager;
    private View mMenu;
    private com.baidu.swan.games.t.a.b.a bpf = new com.baidu.swan.games.t.a.b.a();
    private com.baidu.swan.games.view.b bdw = new com.baidu.swan.games.view.b();
    private volatile boolean mIsForeground = true;
    private String bpj = "landscape";
    private boolean bpl = false;

    public static i OJ() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        initView(inflate);
        OK();
        return inflate;
    }

    public void initView(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.bpb = frameLayout;
        this.boX = com.baidu.swan.games.i.a.aob().aod();
        if (this.boX != null && this.boX.getParent() == null) {
            frameLayout.addView(this.boX, 0, new FrameLayout.LayoutParams(-1, -1));
            if (DEBUG) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aau()) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.bpg = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            OV();
        }
        ai(view);
        this.bpe = new com.baidu.swan.games.view.d((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.bpd = new com.baidu.swan.games.view.d(this.bpb);
    }

    private void OK() {
        if (this.boX != null) {
            this.boX.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.i.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i.DEBUG) {
                        Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + i.this.mIsForeground);
                    }
                    if (i.this.mIsForeground || i.this.OL()) {
                        com.baidu.swan.apps.as.c.U(i.this.mActivity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OL() {
        e GH = GH();
        return GH != null && (GH.Oq() instanceof i);
    }

    private void ai(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.boY = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.boZ = view.findViewById(a.f.titlebar_right_menu_line);
        this.bpa = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.boY.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.bpa.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.boZ.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.boY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.Ny();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                i.this.a(fVar);
            }
        });
        this.bpa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!i.DEBUG || !com.baidu.swan.apps.ah.a.a.aas()) {
                    if (com.baidu.swan.apps.runtime.e.acI() != null && com.baidu.swan.apps.q.c.Tn().To()) {
                        i.this.OM();
                        return;
                    }
                    com.baidu.swan.apps.q.b Ti = new com.baidu.swan.apps.q.b().Ti();
                    if (Ti.isShow()) {
                        com.baidu.swan.apps.q.c.Tn().a(i.this.mActivity, Ti.getImageUrl(), Ti.Tm(), i.this.NC());
                        return;
                    }
                    i.this.OM();
                }
            }
        });
    }

    public void OM() {
        String currentDate = com.baidu.swan.games.view.recommend.popview.c.getCurrentDate();
        if (currentDate.equals(com.baidu.swan.games.view.recommend.popview.c.getString("date"))) {
            ON();
            return;
        }
        if (this.bpk == null) {
            this.bpk = new GameCloseGuidePopView(getContext());
            this.bpk.setOnClickListener(new GameCloseGuidePopView.a() { // from class: com.baidu.swan.apps.core.d.i.4
                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OY() {
                    if (i.this.bpk != null) {
                        i.this.bpb.removeView(i.this.bpk);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void OZ() {
                    i.this.ON();
                }

                @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.a
                public void Pa() {
                    i.this.ON();
                }
            });
        }
        this.bpb.addView(this.bpk);
        com.baidu.swan.games.view.recommend.popview.c.putString("date", currentDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a NC() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.i.5
            @Override // com.baidu.swan.apps.q.c.a
            public void NW() {
                i.this.ON();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
        ((SwanAppActivity) this.mActivity).dR(1);
    }

    private void OO() {
        if (af.cK(this.mActivity)) {
            com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_game_not_support_split_screen).showToast();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OO();
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
    public com.baidu.swan.games.t.a.b.a OP() {
        return this.bpf;
    }

    @NonNull
    public com.baidu.swan.games.view.b OQ() {
        return this.bdw;
    }

    public com.baidu.swan.games.view.d OR() {
        return this.bpe;
    }

    public com.baidu.swan.games.view.d OS() {
        return this.bpd;
    }

    public void resume() {
        zg();
        if (this.boX != null && this.boX.getV8Engine() != null) {
            final com.baidu.swan.games.e.a v8Engine = this.boX.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.mIsForeground = true;
            this.boX.onResume();
            com.baidu.swan.games.audio.b.b.alE().onResume();
            com.baidu.swan.games.y.b.w(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.o.e(((SwanAppActivity) this.mActivity).GJ()));
            }
            v8Engine.onResume();
            if (this.bpb != null && this.bpc != null) {
                ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.i.6
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bpb.removeView(i.this.bpc);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.bpd.eK(isLandScape);
                this.bpe.eK(isLandScape);
                com.baidu.swan.apps.as.c.U(this.mActivity);
            }
            if (this.bba == null) {
                this.bba = new OrientationEventListener(this.mActivity, 3) { // from class: com.baidu.swan.apps.core.d.i.7
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (260 < i && i < 280 && i.this.bpj != "landscape") {
                            i.this.mActivity.setRequestedOrientation(0);
                            i.this.bpj = "landscape";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bpj);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bpj);
                            }
                        } else if (80 < i && i < 100 && i.this.bpj != "landscapeReverse") {
                            i.this.mActivity.setRequestedOrientation(8);
                            i.this.bpj = "landscapeReverse";
                            com.baidu.swan.games.y.a.b(v8Engine, i.this.bpj);
                            if (i.DEBUG) {
                                Log.d("SwanGameFragment", "onOrientationChanged: " + i.this.bpj);
                            }
                        }
                    }
                };
            }
            if (this.bba.canDetectOrientation() && this.mActivity != null && ((SwanAppActivity) this.mActivity).isLandScape()) {
                this.bba.enable();
            } else {
                this.bba.disable();
            }
            com.baidu.swan.apps.media.b.cT(true);
            if (this.bpd != null) {
                this.bpd.aqy();
            }
            if (this.bpe != null) {
                this.bpe.aqy();
            }
            OO();
        }
    }

    public void pause() {
        this.mIsForeground = false;
        zh();
        if (this.bpc == null) {
            this.bpc = new View(this.mActivity);
        }
        this.bpb.removeView(this.bpc);
        this.bpb.addView(this.bpc, new FrameLayout.LayoutParams(-1, -1));
        if (this.bpk != null) {
            this.bpb.removeView(this.bpk);
            this.bpk = null;
        }
        if (this.bpd != null) {
            this.bpd.aqz();
        }
        if (this.bpe != null) {
            this.bpe.aqz();
        }
        if (this.boX != null && this.boX.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.boX.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.anE()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.y.b.v(v8Engine);
                EventTarget anz = v8Engine.anz();
                if (anz instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) anz).hideKeyboard();
                }
            }
            com.baidu.swan.games.audio.b.b.alE().pauseAll();
            com.baidu.swan.apps.media.b.cT(false);
            this.boX.onPause();
            if (this.bba != null) {
                this.bba.disable();
            }
            if (this.bnL != null && this.bnL.isShowing()) {
                this.bnL.eV(false);
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
            Mh();
        }
        if (this.boX != null) {
            this.boX.setOnSystemUiVisibilityChangeListener(null);
            this.boX.onDestroy();
        }
        if (this.bpd != null) {
            this.bpd.aqA();
        }
        if (this.bpe != null) {
            this.bpe.aqA();
        }
        this.bdw.JM();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.eF(false);
        com.baidu.swan.games.glsurface.a.b.aoy();
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
        Context context = getContext();
        if (context instanceof Activity) {
            t.forceHiddenSoftInput(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Jl();
        if (com.baidu.swan.apps.runtime.e.acJ() != null) {
            this.bnL.ir(com.baidu.swan.apps.runtime.e.acJ().acL().getOrientation());
        }
        this.bnL.i(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState(), NR());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        return com.baidu.j.a.Ez();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
        FragmentActivity auD = auD();
        if (auD != null) {
            if (this.bpl) {
                if (this.bnL != null && this.bnL.isShowing()) {
                    this.bnL.eV(false);
                }
                this.bnL = null;
                this.bpl = false;
            }
            if (this.bnL == null) {
                this.bnL = new com.baidu.swan.menu.h(auD, this.mMenu, 0, com.baidu.swan.apps.w.a.Ud(), new com.baidu.swan.apps.view.c.b());
                this.bnL.iq(com.baidu.swan.apps.as.c.agD());
                this.bpf.b(this.bnL);
                com.baidu.swan.games.p.a WK = com.baidu.swan.apps.y.f.WV().WK();
                if (WK != null) {
                    WK.a(this.bnL);
                }
                new com.baidu.swan.apps.aa.a(this.bnL, this).Yn();
            }
        }
    }

    public com.baidu.swan.menu.h OT() {
        return this.bnL;
    }

    public void cx(boolean z) {
        this.bpl = z;
    }

    public boolean OU() {
        return !this.mIsForeground;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NU() {
        if (this.boX != null && this.boX.getV8Engine() != null) {
            this.boX.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void OV() {
        if (this.bkV) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.bkV = true;
        this.bph = new b();
        this.bph.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Mh() {
        if (!this.bkV) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.bkV = false;
        if (this.bph != null) {
            this.bph.removeMessages(0);
            this.bph = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a GC() {
        if (this.bbd == null && this.bpe != null && this.bpe.aqv() != null) {
            this.bbd = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.bpe.aqv(), 0);
        }
        return this.bbd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (i.this.bpg != null) {
                String valueOf = String.valueOf(i.this.boX == null ? 0 : i.this.boX.getFPS());
                i.this.bpg.setText(valueOf);
                if (i.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            i.this.bph.sendEmptyMessageDelayed(0, 500L);
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
                    if (!i.this.OW()) {
                        switch (i) {
                            case -2:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                i.this.zh();
                                return;
                            case -1:
                                if (i.DEBUG) {
                                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                i.this.zh();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    private void zg() {
        if (!OW() && !this.bbA) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bpi == null) {
                this.bpi = new a();
            }
            this.bbA = this.mAudioManager.requestAudioFocus(this.bpi, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void zh() {
        if (this.bbA) {
            if (this.mAudioManager != null && this.bpi != null) {
                this.mAudioManager.abandonAudioFocus(this.bpi);
                this.mAudioManager = null;
                this.bpi = null;
            }
            this.bbA = false;
            if (DEBUG) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OW() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        boolean booleanValue = acI != null ? acI.acY().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public View OX() {
        return this.mMenu;
    }
}
