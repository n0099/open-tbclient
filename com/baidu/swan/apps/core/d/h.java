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
public class h extends b implements a.InterfaceC0170a, com.baidu.swan.games.q.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean anE;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqH;
    private DuMixGameSurfaceView arm;
    private View arn;
    private ImageView aro;
    private View arp;
    private ImageView arq;
    private FrameLayout arr;
    private View ars;
    private com.baidu.swan.games.view.b art;
    private com.baidu.swan.games.view.b aru;
    private TextView arx;
    private a ary;
    private com.baidu.swan.games.q.a.b.a arv = new com.baidu.swan.games.q.a.b.a();
    private com.baidu.swan.games.view.recommend.b arw = new com.baidu.swan.games.view.recommend.b();
    private volatile boolean arz = true;

    public static h Ac() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        O(inflate);
        Ad();
        return inflate;
    }

    public void O(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.arr = frameLayout;
        this.arm = com.baidu.swan.games.glsurface.a.Rq().bZ(getContext());
        frameLayout.addView(this.arm, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.arx = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            Al();
        }
        T(view);
        this.aru = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.art = new com.baidu.swan.games.view.b(this.arr);
    }

    private void Ad() {
        this.arm.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.arz);
                }
                if (h.this.arz || h.this.Ae()) {
                    com.baidu.swan.apps.an.b.M(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ae() {
        e vi = vi();
        return vi != null && (vi.zK() instanceof h);
    }

    private void T(View view) {
        this.arn = view.findViewById(a.f.titlebar_right_menu);
        this.aro = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.arp = view.findViewById(a.f.titlebar_right_menu_line);
        this.arq = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.aro.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.arq.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.arp.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.arn.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.aro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.yO();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.arq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.Ik()) {
                    if (h.this.mActivity != null) {
                        h.this.mActivity.moveTaskToBack(true);
                    }
                    ((SwanAppActivity) h.this.mActivity).bK(1);
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    h.this.a(fVar);
                }
            }
        });
    }

    private void Af() {
        if (Build.VERSION.SDK_INT >= 24 && this.mActivity != null && this.mActivity.isInMultiWindowMode()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.DB(), a.h.aiapps_game_not_support_split_screen).Ld();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Af();
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
    public com.baidu.swan.games.q.a.b.a Ag() {
        return this.arv;
    }

    @NonNull
    public com.baidu.swan.games.view.recommend.b Ah() {
        return this.arw;
    }

    public com.baidu.swan.games.view.b Ai() {
        return this.aru;
    }

    public com.baidu.swan.games.view.b Aj() {
        return this.art;
    }

    public void resume() {
        aT(this.mActivity);
        if (this.arm != null && this.arm.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arm.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.arz = true;
            this.arm.onResume();
            com.baidu.swan.games.t.a.z(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.m.b(((SwanAppActivity) this.mActivity).vk()));
            }
            v8Engine.onResume();
            if (this.arr != null && this.ars != null) {
                ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arr.removeView(h.this.ars);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.art.cS(isLandScape);
                this.aru.cS(isLandScape);
                com.baidu.swan.apps.an.b.M(this.mActivity);
            }
            com.baidu.swan.apps.media.b.bv(true);
            this.arw.bv(true);
            com.baidu.swan.games.view.a.c.SK();
            Af();
        }
    }

    public void pause() {
        this.arz = false;
        zi();
        if (this.ars == null) {
            this.ars = new View(this.mActivity);
        }
        this.arr.removeView(this.ars);
        this.arr.addView(this.ars, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.c.SL();
        if (this.arm != null && this.arm.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arm.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.QS()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.t.a.y(v8Engine);
                EventTarget QN = v8Engine.QN();
                if (QN instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) QN).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.bv(false);
            this.arw.bv(false);
            this.arm.onPause();
            if (this.aqi != null && this.aqi.isShowing()) {
                this.aqi.dd(false);
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
            xN();
        }
        if (this.arm != null) {
            this.arm.setOnSystemUiVisibilityChangeListener(null);
            this.arm.onDestroy();
        }
        this.arw.destroy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.cO(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
        Context context = getContext();
        if (context instanceof Activity) {
            p.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        yN();
        this.aqi.a(com.baidu.swan.apps.u.a.DW().Ev(), zl(), zm());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        return com.baidu.swan.apps.aa.a.Hx();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
        FragmentActivity Wi = Wi();
        if (Wi != null && this.aqi == null) {
            this.aqi = new com.baidu.swan.menu.g(Wi, this.arn, 0, new com.baidu.swan.apps.view.b.b());
            this.aqi.setStatisticSource("tool");
            this.aqi.setMenuSource("swan");
            this.aqi.a(com.baidu.swan.apps.u.a.DF());
            this.aqi.fu(com.baidu.swan.apps.an.b.Ou());
            this.arv.a(this.aqi);
            new com.baidu.swan.apps.view.coverview.c.b(this.aqi, this).PB();
        }
    }

    public boolean Ak() {
        return !this.arz;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zo() {
        if (this.arm != null && this.arm.getV8Engine() != null) {
            this.arm.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void Al() {
        if (this.anE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.anE = true;
        this.ary = new a();
        this.ary.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void xN() {
        if (!this.anE) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.anE = false;
        if (this.ary != null) {
            this.ary.removeMessages(0);
            this.ary = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0170a
    public com.baidu.swan.apps.res.widget.floatlayer.a ve() {
        if (this.aqH == null && this.aru != null && this.aru.SF() != null) {
            this.aqH = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.aru.SF(), 0);
        }
        return this.aqH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.arx != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.arx.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.ary.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
