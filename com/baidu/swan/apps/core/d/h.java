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
public class h extends b implements a.InterfaceC0213a, com.baidu.swan.games.q.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aHW;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKZ;
    private DuMixGameSurfaceView aLE;
    private ImageView aLF;
    private View aLG;
    private ImageView aLH;
    private FrameLayout aLI;
    private View aLJ;
    private com.baidu.swan.games.view.b aLK;
    private com.baidu.swan.games.view.b aLL;
    private TextView aLO;
    private a aLP;
    private View mMenu;
    private com.baidu.swan.games.q.a.b.a aLM = new com.baidu.swan.games.q.a.b.a();
    private com.baidu.swan.games.view.recommend.b aLN = new com.baidu.swan.games.view.recommend.b();
    private volatile boolean aLQ = true;

    public static h FI() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        W(inflate);
        FJ();
        return inflate;
    }

    public void W(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.aLI = frameLayout;
        this.aLE = com.baidu.swan.games.glsurface.a.Xe().bZ(getContext());
        frameLayout.addView(this.aLE, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.aLO = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            FR();
        }
        ab(view);
        this.aLL = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.aLK = new com.baidu.swan.games.view.b(this.aLI);
    }

    private void FJ() {
        this.aLE.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.aLQ);
                }
                if (h.this.aLQ || h.this.FK()) {
                    com.baidu.swan.apps.an.b.O(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK() {
        e AH = AH();
        return AH != null && (AH.Fq() instanceof h);
    }

    private void ab(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.aLF = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.aLG = view.findViewById(a.f.titlebar_right_menu_line);
        this.aLH = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.aLF.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.aLH.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.aLG.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.aLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.Eu();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.aLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.NV()) {
                    if (h.this.mActivity != null) {
                        h.this.mActivity.moveTaskToBack(true);
                    }
                    ((SwanAppActivity) h.this.mActivity).cH(1);
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    h.this.a(fVar);
                }
            }
        });
    }

    private void FL() {
        if (Build.VERSION.SDK_INT >= 24 && this.mActivity != null && this.mActivity.isInMultiWindowMode()) {
            com.baidu.swan.apps.res.widget.b.d.i(com.baidu.swan.apps.u.a.Ji(), a.h.aiapps_game_not_support_split_screen).QN();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FL();
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
    public com.baidu.swan.games.q.a.b.a FM() {
        return this.aLM;
    }

    @NonNull
    public com.baidu.swan.games.view.recommend.b FN() {
        return this.aLN;
    }

    public com.baidu.swan.games.view.b FO() {
        return this.aLL;
    }

    public com.baidu.swan.games.view.b FP() {
        return this.aLK;
    }

    public void resume() {
        aV(this.mActivity);
        if (this.aLE != null && this.aLE.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.aLE.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.aLQ = true;
            this.aLE.onResume();
            com.baidu.swan.games.t.a.z(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.m.b(((SwanAppActivity) this.mActivity).AJ()));
            }
            v8Engine.onResume();
            if (this.aLI != null && this.aLJ != null) {
                ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.aLI.removeView(h.this.aLJ);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.aLK.dm(isLandScape);
                this.aLL.dm(isLandScape);
                com.baidu.swan.apps.an.b.O(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bQ(true);
            this.aLN.bQ(true);
            com.baidu.swan.games.view.a.c.Yy();
            FL();
        }
    }

    public void pause() {
        this.aLQ = false;
        EO();
        if (this.aLJ == null) {
            this.aLJ = new View(this.mActivity);
        }
        this.aLI.removeView(this.aLJ);
        this.aLI.addView(this.aLJ, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.c.Yz();
        if (this.aLE != null && this.aLE.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.aLE.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.WG()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.t.a.y(v8Engine);
                EventTarget WB = v8Engine.WB();
                if (WB instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) WB).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.bQ(false);
            this.aLN.bQ(false);
            this.aLE.onPause();
            if (this.aKz != null && this.aKz.isShowing()) {
                this.aKz.dz(false);
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
            Dr();
        }
        if (this.aLE != null) {
            this.aLE.setOnSystemUiVisibilityChangeListener(null);
            this.aLE.onDestroy();
        }
        this.aLN.destroy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.di(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        Context context = getContext();
        if (context instanceof Activity) {
            p.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Et();
        this.aKz.a(com.baidu.swan.apps.u.a.JD().Kc(), ER(), ES());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        return com.baidu.swan.apps.aa.a.Nh();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
        FragmentActivity abV = abV();
        if (abV != null && this.aKz == null) {
            this.aKz = new com.baidu.swan.menu.g(abV, this.mMenu, 0, new com.baidu.swan.apps.view.b.b());
            this.aKz.setStatisticSource("tool");
            this.aKz.setMenuSource("swan");
            this.aKz.a(com.baidu.swan.apps.u.a.Jm());
            this.aKz.gu(com.baidu.swan.apps.an.b.Ud());
            this.aLM.a(this.aKz);
            new com.baidu.swan.apps.view.coverview.c.b(this.aKz, this).Vn();
        }
    }

    public boolean FQ() {
        return !this.aLQ;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EU() {
        if (this.aLE != null && this.aLE.getV8Engine() != null) {
            this.aLE.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void FR() {
        if (this.aHW) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.aHW = true;
        this.aLP = new a();
        this.aLP.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Dr() {
        if (!this.aHW) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.aHW = false;
        if (this.aLP != null) {
            this.aLP.removeMessages(0);
            this.aLP = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0213a
    public com.baidu.swan.apps.res.widget.floatlayer.a AD() {
        if (this.aKZ == null && this.aLL != null && this.aLL.Yt() != null) {
            this.aKZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.aLL.Yt(), 0);
        }
        return this.aKZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.aLO != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.aLO.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.aLP.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
