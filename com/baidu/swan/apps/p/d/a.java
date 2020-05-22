package com.baidu.swan.apps.p.d;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.swan.apps.w.h;
import com.baidu.swan.apps.w.i;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams cfV = new FrameLayout.LayoutParams(-1, -1);
    private String bZI;
    private int cfS;
    private InterfaceC0363a cfT;
    private b cfU;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* renamed from: com.baidu.swan.apps.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0363a {
        void onCustomViewHidden();
    }

    public a(Context context, String str) {
        this.mContext = context;
        this.bZI = str;
    }

    public void a(View view, int i, @Nullable InterfaceC0363a interfaceC0363a) {
        if (DEBUG) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.mContext;
        SwanAppActivity swanAppActivity = null;
        if (context instanceof Activity) {
            swanAppActivity = (Activity) context;
        }
        if (swanAppActivity != null) {
            if (this.mCustomView != null) {
                if (interfaceC0363a != null) {
                    interfaceC0363a.onCustomViewHidden();
                    this.cfT = interfaceC0363a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, cfV);
            viewGroup.addView(this.mFullscreenContainer, cfV);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.j(true, false);
            }
            this.cfS = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.cfU == null) {
                this.cfU = new b(swanAppActivity, this.bZI);
            }
            i.a(this.cfU);
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mCustomView != null) {
                        a.this.mCustomView.requestFocus();
                    }
                }
            });
        }
    }

    public void hideCustomView() {
        if (this.mCustomView != null) {
            if (DEBUG) {
                Log.i("SwanCustomViewHelper", "hideCustomView");
            }
            Context context = this.mContext;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.b(this.cfU);
                this.cfU = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.cfT != null) {
                    this.cfT.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.cfS);
            }
        }
    }

    @UiThread
    public synchronized void kx(String str) {
        SwanAppComponentContainerView Vl;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aR = com.baidu.swan.apps.component.container.a.aR(this.bZI, str);
        if (aR != null && (("coverView".equals(aR.Vj().bPE) || "coverImage".equals(aR.Vj().bPE)) && this.mFullscreenContainer != null && (Vl = aR.Vl()) != null)) {
            ViewParent parent = Vl.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(Vl);
                this.mFullscreenContainer.addView(Vl);
            }
        }
    }

    @UiThread
    public synchronized void ky(String str) {
        SwanAppComponentContainerView Vl;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aR = com.baidu.swan.apps.component.container.a.aR(this.bZI, str);
        if (aR != null && (("coverView".equals(aR.Vj().bPE) || "coverImage".equals(aR.Vj().bPE)) && (Vl = aR.Vl()) != null)) {
            ViewParent parent = Vl.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(Vl);
                aR.Vg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b implements h {
        private String bZI;
        private Activity mActivity;

        public b(Activity activity, String str) {
            this.mActivity = activity;
            this.bZI = str;
        }

        @Override // com.baidu.swan.apps.w.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.w.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.Tj(), this.bZI)) {
                a.setFullscreen(this.mActivity, true);
                ((ViewGroup) this.mActivity.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // com.baidu.swan.apps.w.h
        public void c(e eVar) {
        }

        @Override // com.baidu.swan.apps.w.h
        public void d(e eVar) {
        }
    }
}
