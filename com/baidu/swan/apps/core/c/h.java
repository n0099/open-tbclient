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
    private boolean anr;
    private DuMixGameSurfaceView arg;
    private View arh;
    private ImageView ari;
    private View arj;
    private ImageView ark;
    private FrameLayout arl;
    private View arm;
    private com.baidu.swan.games.view.b arn;
    private com.baidu.swan.games.view.b aro;
    private TextView arq;
    private a arr;
    private com.baidu.swan.games.p.b.a arp = new com.baidu.swan.games.p.b.a();
    private volatile boolean ars = true;

    public static h zf() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        O(inflate);
        zg();
        return inflate;
    }

    public void O(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.arl = frameLayout;
        this.arg = com.baidu.swan.games.glsurface.a.Oq().cw(getContext());
        frameLayout.addView(this.arg, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.arq = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            zl();
        }
        T(view);
        this.aro = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.arn = new com.baidu.swan.games.view.b(this.arl);
    }

    private void zg() {
        this.arg.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.c.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.ars);
                }
                if (h.this.ars || h.this.zh()) {
                    com.baidu.swan.apps.an.b.L(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zh() {
        e uy = uy();
        return uy != null && (uy.yN() instanceof h);
    }

    private void T(View view) {
        this.arh = view.findViewById(a.f.titlebar_right_menu);
        this.ari = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.arj = view.findViewById(a.f.titlebar_right_menu_line);
        this.ark = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.ari.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.ark.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.arj.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.arh.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.ari.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.xW();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.ark.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.Gb()) {
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
    public com.baidu.swan.games.p.b.a zi() {
        return this.arp;
    }

    public com.baidu.swan.games.view.b zj() {
        return this.aro;
    }

    public void resume() {
        bA(this.mActivity);
        if (this.arg != null && this.arg.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arg.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.ars = true;
            this.arg.onResume();
            com.baidu.swan.games.r.a.n(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.l.b(((SwanAppActivity) this.mActivity).uA()));
            }
            v8Engine.onResume();
            if (this.arl != null && this.arm != null) {
                aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.c.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arl.removeView(h.this.arm);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.arn.cB(isLandScape);
                this.aro.cB(isLandScape);
                com.baidu.swan.apps.an.b.L(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bm(true);
            com.baidu.swan.games.view.a.b.Pp();
        }
    }

    public void pause() {
        this.ars = false;
        yo();
        if (this.arm == null) {
            this.arm = new View(this.mActivity);
        }
        this.arl.removeView(this.arm);
        this.arl.addView(this.arm, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.b.Pq();
        if (this.arg != null && this.arg.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arg.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.NX()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.r.a.m(v8Engine);
                EventTarget NT = v8Engine.NT();
                if (NT instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) NT).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.bm(false);
            this.arg.onPause();
            if (this.aqb != null && this.aqb.isShowing()) {
                this.aqb.cM(false);
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
            wV();
        }
        if (this.arg != null) {
            this.arg.setOnSystemUiVisibilityChangeListener(null);
            this.arg.onDestroy();
        }
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.cx(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        Context context = getContext();
        if (context instanceof Activity) {
            o.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        xV();
        this.aqb.a(com.baidu.swan.apps.u.a.CR().Dq(), yr(), ys());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return com.baidu.swan.apps.u.a.Dd().vS();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
        FragmentActivity Sw = Sw();
        if (Sw != null && this.aqb == null) {
            this.aqb = new com.baidu.swan.menu.h(Sw, this.arh, 0, new com.baidu.swan.apps.view.b.b());
            this.aqb.setStatisticSource("tool");
            this.aqb.setMenuSource("swan");
            this.aqb.a(com.baidu.swan.apps.u.a.CA());
            this.aqb.eV(com.baidu.swan.apps.an.b.LN());
            this.arp.a(this.aqb);
            new com.baidu.swan.apps.view.coverview.c.b(this.aqb, this).MS();
        }
    }

    public boolean zk() {
        return !this.ars;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yu() {
        if (this.arg != null && this.arg.getV8Engine() != null) {
            this.arg.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void zl() {
        if (this.anr) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.anr = true;
        this.arr = new a();
        this.arr.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void wV() {
        if (!this.anr) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.anr = false;
        if (this.arr != null) {
            this.arr.removeMessages(0);
            this.arr = null;
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
            if (h.this.arq != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.arq.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.arr.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
