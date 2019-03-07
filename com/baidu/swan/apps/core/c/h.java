package com.baidu.swan.apps.core.c;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class h extends b implements com.baidu.swan.games.p.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private boolean anm;
    private DuMixGameSurfaceView arb;
    private View arc;
    private ImageView ard;
    private View are;
    private ImageView arf;
    private FrameLayout arg;
    private View arh;
    private com.baidu.swan.games.view.b ari;
    private com.baidu.swan.games.view.b arj;
    private TextView arl;
    private a arm;
    private com.baidu.swan.games.p.b.a ark = new com.baidu.swan.games.p.b.a();
    private volatile boolean arn = true;

    public static h zg() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(b.g.ai_games_fragment, viewGroup, false);
        O(inflate);
        zh();
        return inflate;
    }

    public void O(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(b.f.ai_games_layout);
        this.arg = frameLayout;
        this.arb = com.baidu.swan.games.glsurface.a.Os().cw(getContext());
        frameLayout.addView(this.arb, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(b.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.arl = (TextView) inflate.findViewById(b.f.ai_games_fps_text);
            }
            zm();
        }
        T(view);
        this.arj = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(b.f.ai_games_na_layout));
        this.ari = new com.baidu.swan.games.view.b(this.arg);
    }

    private void zh() {
        this.arb.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.c.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.arn);
                }
                if (h.this.arn || h.this.zi()) {
                    com.baidu.swan.apps.an.b.L(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zi() {
        e uz = uz();
        return uz != null && (uz.yO() instanceof h);
    }

    private void T(View view) {
        this.arc = view.findViewById(b.f.titlebar_right_menu);
        this.ard = (ImageView) view.findViewById(b.f.titlebar_right_menu_img);
        this.are = view.findViewById(b.f.titlebar_right_menu_line);
        this.arf = (ImageView) view.findViewById(b.f.titlebar_right_menu_exit);
        this.ard.setImageDrawable(getResources().getDrawable(b.e.aiapps_action_bar_single_menu_white_selector));
        this.arf.setImageDrawable(getResources().getDrawable(b.e.aiapps_action_bar_exit_white_selector));
        this.are.setBackgroundResource(b.c.aiapps_action_bar_menu_line_white);
        this.arc.setBackgroundResource(b.e.aiapps_action_bar_right_menu_bg_solid);
        this.ard.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.xX();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.arf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.Gd()) {
                    if (h.this.mActivity != null) {
                        h.this.mActivity.moveTaskToBack(true);
                    }
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    h.this.a(fVar);
                }
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
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

    @Override // com.baidu.swan.games.p.b.b
    @NonNull
    public com.baidu.swan.games.p.b.a zj() {
        return this.ark;
    }

    public com.baidu.swan.games.view.b zk() {
        return this.arj;
    }

    public void resume() {
        bA(this.mActivity);
        if (this.arb != null && this.arb.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arb.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.arn = true;
            this.arb.onResume();
            com.baidu.swan.games.r.a.n(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.l.b(((SwanAppActivity) this.mActivity).uB()));
            }
            v8Engine.onResume();
            if (this.arg != null && this.arh != null) {
                aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.c.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arg.removeView(h.this.arh);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.ari.cB(isLandScape);
                this.arj.cB(isLandScape);
                com.baidu.swan.apps.an.b.L(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bm(true);
            com.baidu.swan.games.view.a.b.Pr();
        }
    }

    public void pause() {
        this.arn = false;
        yp();
        if (this.arh == null) {
            this.arh = new View(this.mActivity);
        }
        this.arg.removeView(this.arh);
        this.arg.addView(this.arh, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.b.Ps();
        if (this.arb != null && this.arb.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arb.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.NZ()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.r.a.m(v8Engine);
                EventTarget NV = v8Engine.NV();
                if (NV instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) NV).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.bm(false);
            this.arb.onPause();
            if (this.apW != null && this.apW.isShowing()) {
                this.apW.cM(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
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
            wW();
        }
        if (this.arb != null) {
            this.arb.setOnSystemUiVisibilityChangeListener(null);
            this.arb.onDestroy();
        }
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.cx(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
        Context context = getContext();
        if (context instanceof Activity) {
            o.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        xW();
        this.apW.a(com.baidu.swan.apps.u.a.CT().Ds(), ys(), yt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return com.baidu.swan.apps.u.a.Df().vT();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        FragmentActivity Sy = Sy();
        if (Sy != null && this.apW == null) {
            this.apW = new com.baidu.swan.menu.h(Sy, this.arc, 0, new com.baidu.swan.apps.view.b.b());
            this.apW.setStatisticSource("tool");
            this.apW.setMenuSource("swan");
            this.apW.a(com.baidu.swan.apps.u.a.CC());
            this.apW.eW(com.baidu.swan.apps.an.b.LP());
            this.ark.a(this.apW);
            new com.baidu.swan.apps.view.coverview.c.b(this.apW, this).MU();
        }
    }

    public boolean zl() {
        return !this.arn;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yv() {
        if (this.arb != null && this.arb.getV8Engine() != null) {
            this.arb.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void zm() {
        if (this.anm) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.anm = true;
        this.arm = new a();
        this.arm.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void wW() {
        if (!this.anm) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.anm = false;
        if (this.arm != null) {
            this.arm.removeMessages(0);
            this.arm = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.arl != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.arl.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.arm.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
