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
public class h extends b implements a.InterfaceC0208a, com.baidu.swan.games.q.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aHE;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKH;
    private DuMixGameSurfaceView aLm;
    private ImageView aLn;
    private View aLo;
    private ImageView aLp;
    private FrameLayout aLq;
    private View aLr;
    private com.baidu.swan.games.view.b aLs;
    private com.baidu.swan.games.view.b aLt;
    private TextView aLw;
    private a aLx;
    private View mMenu;
    private com.baidu.swan.games.q.a.b.a aLu = new com.baidu.swan.games.q.a.b.a();
    private com.baidu.swan.games.view.recommend.b aLv = new com.baidu.swan.games.view.recommend.b();
    private volatile boolean aLy = true;

    public static h FJ() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        W(inflate);
        FK();
        return inflate;
    }

    public void W(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.aLq = frameLayout;
        this.aLm = com.baidu.swan.games.glsurface.a.Xc().bZ(getContext());
        frameLayout.addView(this.aLm, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.aLw = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            FS();
        }
        ab(view);
        this.aLt = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.aLs = new com.baidu.swan.games.view.b(this.aLq);
    }

    private void FK() {
        this.aLm.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.aLy);
                }
                if (h.this.aLy || h.this.FL()) {
                    com.baidu.swan.apps.an.b.O(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FL() {
        e AI = AI();
        return AI != null && (AI.Fr() instanceof h);
    }

    private void ab(View view) {
        this.mMenu = view.findViewById(a.f.titlebar_right_menu);
        this.aLn = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.aLo = view.findViewById(a.f.titlebar_right_menu_line);
        this.aLp = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.aLn.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.aLp.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.aLo.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.mMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.aLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.Ev();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.aLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.NW()) {
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

    private void FM() {
        if (Build.VERSION.SDK_INT >= 24 && this.mActivity != null && this.mActivity.isInMultiWindowMode()) {
            com.baidu.swan.apps.res.widget.b.d.i(com.baidu.swan.apps.u.a.Jj(), a.h.aiapps_game_not_support_split_screen).QO();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FM();
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
    public com.baidu.swan.games.q.a.b.a FN() {
        return this.aLu;
    }

    @NonNull
    public com.baidu.swan.games.view.recommend.b FO() {
        return this.aLv;
    }

    public com.baidu.swan.games.view.b FP() {
        return this.aLt;
    }

    public com.baidu.swan.games.view.b FQ() {
        return this.aLs;
    }

    public void resume() {
        aV(this.mActivity);
        if (this.aLm != null && this.aLm.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.aLm.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.aLy = true;
            this.aLm.onResume();
            com.baidu.swan.games.t.a.z(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.m.b(((SwanAppActivity) this.mActivity).AK()));
            }
            v8Engine.onResume();
            if (this.aLq != null && this.aLr != null) {
                ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.aLq.removeView(h.this.aLr);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.aLs.dm(isLandScape);
                this.aLt.dm(isLandScape);
                com.baidu.swan.apps.an.b.O(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bQ(true);
            this.aLv.bQ(true);
            com.baidu.swan.games.view.a.c.Yw();
            FM();
        }
    }

    public void pause() {
        this.aLy = false;
        EP();
        if (this.aLr == null) {
            this.aLr = new View(this.mActivity);
        }
        this.aLq.removeView(this.aLr);
        this.aLq.addView(this.aLr, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.c.Yx();
        if (this.aLm != null && this.aLm.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.aLm.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.WE()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.t.a.y(v8Engine);
                EventTarget Wz = v8Engine.Wz();
                if (Wz instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) Wz).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.bQ(false);
            this.aLv.bQ(false);
            this.aLm.onPause();
            if (this.aKh != null && this.aKh.isShowing()) {
                this.aKh.dz(false);
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
            Ds();
        }
        if (this.aLm != null) {
            this.aLm.setOnSystemUiVisibilityChangeListener(null);
            this.aLm.onDestroy();
        }
        this.aLv.destroy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.di(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
        Context context = getContext();
        if (context instanceof Activity) {
            p.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        Eu();
        this.aKh.a(com.baidu.swan.apps.u.a.JE().Kd(), ES(), ET());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        return com.baidu.swan.apps.aa.a.Ni();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        FragmentActivity abT = abT();
        if (abT != null && this.aKh == null) {
            this.aKh = new com.baidu.swan.menu.g(abT, this.mMenu, 0, new com.baidu.swan.apps.view.b.b());
            this.aKh.setStatisticSource("tool");
            this.aKh.setMenuSource("swan");
            this.aKh.a(com.baidu.swan.apps.u.a.Jn());
            this.aKh.gt(com.baidu.swan.apps.an.b.Ub());
            this.aLu.a(this.aKh);
            new com.baidu.swan.apps.view.coverview.c.b(this.aKh, this).Vl();
        }
    }

    public boolean FR() {
        return !this.aLy;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EV() {
        if (this.aLm != null && this.aLm.getV8Engine() != null) {
            this.aLm.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void FS() {
        if (this.aHE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.aHE = true;
        this.aLx = new a();
        this.aLx.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void Ds() {
        if (!this.aHE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.aHE = false;
        if (this.aLx != null) {
            this.aLx.removeMessages(0);
            this.aLx = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0208a
    public com.baidu.swan.apps.res.widget.floatlayer.a AE() {
        if (this.aKH == null && this.aLt != null && this.aLt.Yr() != null) {
            this.aKH = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.aLt.Yr(), 0);
        }
        return this.aKH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.aLw != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.aLw.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.aLx.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
