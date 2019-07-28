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
public class h extends b implements a.InterfaceC0172a, com.baidu.swan.games.q.a.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aoh;
    private DuMixGameSurfaceView arP;
    private View arQ;
    private ImageView arR;
    private View arS;
    private ImageView arT;
    private FrameLayout arU;
    private View arV;
    private com.baidu.swan.games.view.b arW;
    private com.baidu.swan.games.view.b arX;
    private com.baidu.swan.apps.res.widget.floatlayer.a ark;
    private TextView asa;
    private a asb;
    private com.baidu.swan.games.q.a.b.a arY = new com.baidu.swan.games.q.a.b.a();
    private com.baidu.swan.games.view.recommend.b arZ = new com.baidu.swan.games.view.recommend.b();
    private volatile boolean asc = true;

    public static h AJ() {
        return new h();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(a.g.ai_games_fragment, viewGroup, false);
        Q(inflate);
        AK();
        return inflate;
    }

    public void Q(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a.f.ai_games_layout);
        this.arU = frameLayout;
        this.arP = com.baidu.swan.games.glsurface.a.Sj().bZ(getContext());
        frameLayout.addView(this.arP, 0, new FrameLayout.LayoutParams(-1, -1));
        if (DEBUG) {
            View inflate = ((ViewStub) view.findViewById(a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.asa = (TextView) inflate.findViewById(a.f.ai_games_fps_text);
            }
            AS();
        }
        V(view);
        this.arX = new com.baidu.swan.games.view.b((FrameLayout) view.findViewById(a.f.ai_games_na_layout));
        this.arW = new com.baidu.swan.games.view.b(this.arU);
    }

    private void AK() {
        this.arP.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + h.this.asc);
                }
                if (h.this.asc || h.this.AL()) {
                    com.baidu.swan.apps.an.b.P(h.this.mActivity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AL() {
        e vJ = vJ();
        return vJ != null && (vJ.Ar() instanceof h);
    }

    private void V(View view) {
        this.arQ = view.findViewById(a.f.titlebar_right_menu);
        this.arR = (ImageView) view.findViewById(a.f.titlebar_right_menu_img);
        this.arS = view.findViewById(a.f.titlebar_right_menu_line);
        this.arT = (ImageView) view.findViewById(a.f.titlebar_right_menu_exit);
        this.arR.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_single_menu_white_selector));
        this.arT.setImageDrawable(getResources().getDrawable(a.e.aiapps_action_bar_exit_white_selector));
        this.arS.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        this.arQ.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
        this.arR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.zv();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mValue = "menu";
                h.this.a(fVar);
            }
        });
        this.arT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!h.DEBUG || !com.baidu.swan.apps.ac.a.a.IX()) {
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

    private void AM() {
        if (Build.VERSION.SDK_INT >= 24 && this.mActivity != null && this.mActivity.isInMultiWindowMode()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.Ek(), a.h.aiapps_game_not_support_split_screen).LQ();
            this.mActivity.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AM();
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
    public com.baidu.swan.games.q.a.b.a AN() {
        return this.arY;
    }

    @NonNull
    public com.baidu.swan.games.view.recommend.b AO() {
        return this.arZ;
    }

    public com.baidu.swan.games.view.b AP() {
        return this.arX;
    }

    public com.baidu.swan.games.view.b AQ() {
        return this.arW;
    }

    public void resume() {
        aT(this.mActivity);
        if (this.arP != null && this.arP.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arP.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.asc = true;
            this.arP.onResume();
            com.baidu.swan.games.t.a.z(v8Engine);
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new com.baidu.swan.games.m.b(((SwanAppActivity) this.mActivity).vL()));
            }
            v8Engine.onResume();
            if (this.arU != null && this.arV != null) {
                ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.d.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.arU.removeView(h.this.arV);
                    }
                }, 500L);
            }
            if (this.mActivity != null && (this.mActivity instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) this.mActivity).isLandScape();
                this.mActivity.setRequestedOrientation(isLandScape ? 0 : 1);
                this.arW.cV(isLandScape);
                this.arX.cV(isLandScape);
                com.baidu.swan.apps.an.b.P(this.mActivity);
            }
            com.baidu.swan.apps.media.b.by(true);
            this.arZ.by(true);
            com.baidu.swan.games.view.a.c.TD();
            AM();
        }
    }

    public void pause() {
        this.asc = false;
        zP();
        if (this.arV == null) {
            this.arV = new View(this.mActivity);
        }
        this.arU.removeView(this.arV);
        this.arU.addView(this.arV, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.swan.games.view.a.c.TE();
        if (this.arP != null && this.arP.getV8Engine() != null) {
            com.baidu.swan.games.e.a v8Engine = this.arP.getV8Engine();
            if (DEBUG) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.RL()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                com.baidu.swan.games.t.a.y(v8Engine);
                EventTarget RG = v8Engine.RG();
                if (RG instanceof com.baidu.swan.games.binding.c) {
                    ((com.baidu.swan.games.binding.c) RG).hideKeyboard();
                }
            }
            com.baidu.swan.apps.media.b.by(false);
            this.arZ.by(false);
            this.arP.onPause();
            if (this.aqL != null && this.aqL.isShowing()) {
                this.aqL.di(false);
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
            ys();
        }
        if (this.arP != null) {
            this.arP.setOnSystemUiVisibilityChangeListener(null);
            this.arP.onDestroy();
        }
        this.arZ.destroy();
        com.baidu.swan.apps.media.b.destroy();
        com.baidu.swan.games.glsurface.a.b.cR(false);
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
        Context context = getContext();
        if (context instanceof Activity) {
            p.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
        zu();
        this.aqL.a(com.baidu.swan.apps.u.a.EF().Fe(), zS(), zT());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        return com.baidu.swan.apps.aa.a.Ij();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
        FragmentActivity Xc = Xc();
        if (Xc != null && this.aqL == null) {
            this.aqL = new com.baidu.swan.menu.g(Xc, this.arQ, 0, new com.baidu.swan.apps.view.b.b());
            this.aqL.setStatisticSource("tool");
            this.aqL.setMenuSource("swan");
            this.aqL.a(com.baidu.swan.apps.u.a.Eo());
            this.aqL.fy(com.baidu.swan.apps.an.b.Pj());
            this.arY.a(this.aqL);
            new com.baidu.swan.apps.view.coverview.c.b(this.aqL, this).Qt();
        }
    }

    public boolean AR() {
        return !this.asc;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zV() {
        if (this.arP != null && this.arP.getV8Engine() != null) {
            this.arP.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    private void AS() {
        if (this.aoh) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.aoh = true;
        this.asb = new a();
        this.asb.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    private void ys() {
        if (!this.aoh) {
            if (DEBUG) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.aoh = false;
        if (this.asb != null) {
            this.asb.removeMessages(0);
            this.asb = null;
        }
        if (DEBUG) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0172a
    public com.baidu.swan.apps.res.widget.floatlayer.a vF() {
        if (this.ark == null && this.arX != null && this.arX.Ty() != null) {
            this.ark = new com.baidu.swan.apps.res.widget.floatlayer.a(this, this.arX.Ty(), 0);
        }
        return this.ark;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (h.this.asa != null) {
                String valueOf = String.valueOf(V8Engine.getPreferredFramesPerSecond());
                h.this.asa.setText(valueOf);
                if (h.DEBUG) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            h.this.asb.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
