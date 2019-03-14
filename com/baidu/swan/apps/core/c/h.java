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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class h extends b implements com.baidu.swan.games.p.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean ann;
    private DuMixGameSurfaceView arc;
    private View ard;
    private ImageView are;
    private View arf;
    private ImageView arg;
    private FrameLayout arh;
    private View ari;
    private com.baidu.swan.games.view.b arj;
    private com.baidu.swan.games.view.b ark;
    private TextView arm;
    private a arn;
    private com.baidu.swan.games.p.b.a arl = new com.baidu.swan.games.p.b.a();
    private volatile boolean aro = true;

    public static h zg() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        O(inflate);
        zh();
        return inflate;
    }

    public void O(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.arh = frameLayout;
        this.arc = com.baidu.swan.games.glsurface.a.Os().cw(getContext());
        frameLayout.addView(this.arc, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.arm = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            zm();
        }
        T(view);
        this.ark = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.arj = new com.baidu.swan.games.view.b(this.arh);
    }

    private void zh() {
        this.arc.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.c.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.aro);
                }
                if (h.this.aro || h.this.zi()) {
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
        this.ard = view.findViewById(a.f.titlebar_right_menu);
        this.are = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.arf = view.findViewById(a.f.titlebar_right_menu_line);
        this.arg = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.are.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.arg.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.arf.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.ard.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.are.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.xX();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.arg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.3
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
        return this.arl;
    }

    public com.baidu.swan.games.view.b zk() {
        return this.ark;
    }

    public void resume() {
        bA(this.mActivity);
        if (this.arc != null && this.arc.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arc.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.aro = true;
            this.arc.onResume();
            com.baidu.swan.games.r.a.n(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.l.b(((SwanAppActivity) this.mActivity).uB()));
            }
            v8Engine.onResume();
            if (this.arh != null && this.ari != null) {
                aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.c.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arh.removeView(h.this.ari);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.arj.cB(isLandScape);
                this.ark.cB(isLandScape);
                com.baidu.swan.apps.an.b.L(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bm(true);
            com.baidu.swan.games.view.a.b.Pr();
        }
    }

    public void pause() {
        this.aro = false;
        yp();
        if (this.ari == null) {
            this.ari = new View(this.mActivity);
        }
        this.arh.removeView(this.ari);
        this.arh.addView(this.ari, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.b.Ps();
        if (this.arc != null && this.arc.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arc.getV8Engine();
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
            this.arc.onPause();
            if (this.apX != null && this.apX.isShowing()) {
                this.apX.cM(false);
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
        if (this.arc != null) {
            this.arc.setOnSystemUiVisibilityChangeListener(null);
            this.arc.onDestroy();
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
        this.apX.a(com.baidu.swan.apps.u.a.CT().Ds(), ys(), yt());
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
        if (Sy != null && this.apX == null) {
            this.apX = new com.baidu.swan.menu.h(Sy, this.ard, 0, new com.baidu.swan.apps.view.b.b());
            this.apX.setStatisticSource("tool");
            this.apX.setMenuSource("swan");
            this.apX.a(com.baidu.swan.apps.u.a.CC());
            this.apX.eW(com.baidu.swan.apps.an.b.LP());
            this.arl.a(this.apX);
            new com.baidu.swan.apps.view.coverview.c.b(this.apX, this).MU();
        }
    }

    public boolean zl() {
        return !this.aro;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yv() {
        if (this.arc != null && this.arc.getV8Engine() != null) {
            this.arc.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void zm() {
        if (this.ann) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.ann = true;
        this.arn = new a();
        this.arn.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void wW() {
        if (!this.ann) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.ann = false;
        if (this.arn != null) {
            this.arn.removeMessages(0);
            this.arn = null;
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
            if (h.this.arm != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.arm.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.arn.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
