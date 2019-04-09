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
    private boolean ans;
    private DuMixGameSurfaceView arh;
    private View ari;
    private ImageView arj;
    private View ark;
    private ImageView arl;
    private FrameLayout arm;
    private View arn;
    private com.baidu.swan.games.view.b aro;
    private com.baidu.swan.games.view.b arp;
    private TextView arr;
    private a ars;
    private com.baidu.swan.games.p.b.a arq = new com.baidu.swan.games.p.b.a();
    private volatile boolean art = true;

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
        this.arm = frameLayout;
        this.arh = com.baidu.swan.games.glsurface.a.Oq().cw(getContext());
        frameLayout.addView(this.arh, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.arr = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            zl();
        }
        T(view);
        this.arp = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.aro = new com.baidu.swan.games.view.b(this.arm);
    }

    private void zg() {
        this.arh.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.c.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.art);
                }
                if (h.this.art || h.this.zh()) {
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
        this.ari = view.findViewById(a.f.titlebar_right_menu);
        this.arj = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.ark = view.findViewById(a.f.titlebar_right_menu_line);
        this.arl = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.arj.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.arl.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.ark.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.ari.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.arj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.xW();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.arl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.h.3
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
        return this.arq;
    }

    public com.baidu.swan.games.view.b zj() {
        return this.arp;
    }

    public void resume() {
        bA(this.mActivity);
        if (this.arh != null && this.arh.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arh.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.art = true;
            this.arh.onResume();
            com.baidu.swan.games.r.a.n(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.l.b(((SwanAppActivity) this.mActivity).uA()));
            }
            v8Engine.onResume();
            if (this.arm != null && this.arn != null) {
                aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.c.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arm.removeView(h.this.arn);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.aro.cB(isLandScape);
                this.arp.cB(isLandScape);
                com.baidu.swan.apps.an.b.L(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bm(true);
            com.baidu.swan.games.view.a.b.Pp();
        }
    }

    public void pause() {
        this.art = false;
        yo();
        if (this.arn == null) {
            this.arn = new View(this.mActivity);
        }
        this.arm.removeView(this.arn);
        this.arm.addView(this.arn, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.b.Pq();
        if (this.arh != null && this.arh.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arh.getV8Engine();
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
            this.arh.onPause();
            if (this.aqc != null && this.aqc.isShowing()) {
                this.aqc.cM(false);
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
        if (this.arh != null) {
            this.arh.setOnSystemUiVisibilityChangeListener(null);
            this.arh.onDestroy();
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
        this.aqc.a(com.baidu.swan.apps.u.a.CR().Dq(), yr(), ys());
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
        if (Sw != null && this.aqc == null) {
            this.aqc = new com.baidu.swan.menu.h(Sw, this.ari, 0, new com.baidu.swan.apps.view.b.b());
            this.aqc.setStatisticSource("tool");
            this.aqc.setMenuSource("swan");
            this.aqc.a(com.baidu.swan.apps.u.a.CA());
            this.aqc.eV(com.baidu.swan.apps.an.b.LN());
            this.arq.a(this.aqc);
            new com.baidu.swan.apps.view.coverview.c.b(this.aqc, this).MS();
        }
    }

    public boolean zk() {
        return !this.art;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yu() {
        if (this.arh != null && this.arh.getV8Engine() != null) {
            this.arh.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void zl() {
        if (this.ans) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.ans = true;
        this.ars = new a();
        this.ars.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void wV() {
        if (!this.ans) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.ans = false;
        if (this.ars != null) {
            this.ars.removeMessages(0);
            this.ars = null;
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
            if (h.this.arr != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.arr.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.ars.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
