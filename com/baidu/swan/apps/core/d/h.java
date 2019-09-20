package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class h extends b implements a.InterfaceC0181a, com.baidu.swan.games.q.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aoF;
    private com.baidu.swan.apps.res.widget.floatlayer.a arI;
    private DuMixGameSurfaceView asn;
    private View aso;
    private ImageView asp;
    private View asq;
    private ImageView asr;
    private FrameLayout ass;
    private View ast;
    private com.baidu.swan.games.view.b asu;
    private com.baidu.swan.games.view.b asv;
    private TextView asy;
    private a asz;
    private com.baidu.swan.games.q.a.b.a asw = new com.baidu.swan.games.q.a.b.a();
    private com.baidu.swan.games.view.recommend.b asx = new com.baidu.swan.games.view.recommend.b();
    private volatile boolean asA = true;

    public static h AN() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        Q(inflate);
        AO();
        return inflate;
    }

    public void Q(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.ass = frameLayout;
        this.asn = com.baidu.swan.games.glsurface.a.Sn().bZ(getContext());
        frameLayout.addView(this.asn, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.asy = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            AW();
        }
        V(view);
        this.asv = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.asu = new com.baidu.swan.games.view.b(this.ass);
    }

    private void AO() {
        this.asn.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.asA);
                }
                if (h.this.asA || h.this.AP()) {
                    com.baidu.swan.apps.an.b.P(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AP() {
        e vN = vN();
        return vN != null && (vN.Av() instanceof h);
    }

    private void V(View view) {
        this.aso = view.findViewById(a.f.titlebar_right_menu);
        this.asp = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.asq = view.findViewById(a.f.titlebar_right_menu_line);
        this.asr = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.asp.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.asr.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.asq.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.aso.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.asp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.zz();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.asr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.Jb()) {
                    if (h.this.mActivity != null) {
                        h.this.mActivity.moveTaskToBack(true);
                    }
                    ((SwanAppActivity) h.this.mActivity).bL(1);
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    h.this.a(fVar);
                }
            }
        });
    }

    private void AQ() {
        if (Build.VERSION.SDK_INT >= 24 && this.mActivity != null && this.mActivity.isInMultiWindowMode()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.Eo(), a.h.aiapps_game_not_support_split_screen).LU();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AQ();
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

    @Override // com.baidu.swan.games.q.a.b.b
    @NonNull
    public com.baidu.swan.games.q.a.b.a AR() {
        return this.asw;
    }

    @NonNull
    public com.baidu.swan.games.view.recommend.b AS() {
        return this.asx;
    }

    public com.baidu.swan.games.view.b AT() {
        return this.asv;
    }

    public com.baidu.swan.games.view.b AU() {
        return this.asu;
    }

    public void resume() {
        aT(this.mActivity);
        if (this.asn != null && this.asn.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.asn.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.asA = true;
            this.asn.onResume();
            com.baidu.swan.games.t.a.z(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.m.b(((SwanAppActivity) this.mActivity).vP()));
            }
            v8Engine.onResume();
            if (this.ass != null && this.ast != null) {
                ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.ass.removeView(h.this.ast);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.asu.cV(isLandScape);
                this.asv.cV(isLandScape);
                com.baidu.swan.apps.an.b.P(this.mActivity);
            }
            com.baidu.swan.apps.media.b.by(true);
            this.asx.by(true);
            com.baidu.swan.games.view.a.c.TH();
            AQ();
        }
    }

    public void pause() {
        this.asA = false;
        zT();
        if (this.ast == null) {
            this.ast = new View(this.mActivity);
        }
        this.ass.removeView(this.ast);
        this.ass.addView(this.ast, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.c.TI();
        if (this.asn != null && this.asn.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.asn.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.RP()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.t.a.y(v8Engine);
                EventTarget RK = v8Engine.RK();
                if (RK instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) RK).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.by(false);
            this.asx.by(false);
            this.asn.onPause();
            if (this.arj != null && this.arj.isShowing()) {
                this.arj.di(false);
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
            yw();
        }
        if (this.asn != null) {
            this.asn.setOnSystemUiVisibilityChangeListener(null);
            this.asn.onDestroy();
        }
        this.asx.destroy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.cR(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
        Context context = getContext();
        if (context instanceof Activity) {
            p.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        zy();
        this.arj.a(com.baidu.swan.apps.u.a.EJ().Fi(), zW(), zX());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zA() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        return com.baidu.swan.apps.aa.a.In();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zy() {
        FragmentActivity Xg = Xg();
        if (Xg != null && this.arj == null) {
            this.arj = new com.baidu.swan.menu.g(Xg, this.aso, 0, new com.baidu.swan.apps.view.b.b());
            this.arj.setStatisticSource("tool");
            this.arj.setMenuSource("swan");
            this.arj.a(com.baidu.swan.apps.u.a.Es());
            this.arj.fz(com.baidu.swan.apps.an.b.Pn());
            this.asw.a(this.arj);
            new com.baidu.swan.apps.view.coverview.c.b(this.arj, this).Qx();
        }
    }

    public boolean AV() {
        return !this.asA;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zZ() {
        if (this.asn != null && this.asn.getV8Engine() != null) {
            this.asn.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void AW() {
        if (this.aoF) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.aoF = true;
        this.asz = new a();
        this.asz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void yw() {
        if (!this.aoF) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.aoF = false;
        if (this.asz != null) {
            this.asz.removeMessages(0);
            this.asz = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0181a
    public com.baidu.swan.apps.res.widget.floatlayer.a vJ() {
        if (this.arI == null && this.asv != null && this.asv.TC() != null) {
            this.arI = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.asv.TC(), 0);
        }
        return this.arI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.asy != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.asy.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.asz.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
