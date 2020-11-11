package com.baidu.swan.apps.inlinewidget.e;

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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.v.h;
import com.baidu.swan.apps.v.i;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams cWH = new FrameLayout.LayoutParams(-1, -1);
    private String cMh;
    private int cWE;
    private a cWF;
    private C0446b cWG;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void onCustomViewHidden();
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.cMh = str;
    }

    public void a(View view, int i, @Nullable a aVar) {
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
                if (aVar != null) {
                    aVar.onCustomViewHidden();
                    this.cWF = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, cWH);
            viewGroup.addView(this.mFullscreenContainer, cWH);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.k(true, false);
            }
            this.cWE = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.cWG == null) {
                this.cWG = new C0446b(swanAppActivity, this.cMh);
            }
            i.a(this.cWG);
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mCustomView != null) {
                        b.this.mCustomView.requestFocus();
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
                i.b(this.cWG);
                this.cWG = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.cWF != null) {
                    this.cWF.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.cWE);
            }
        }
    }

    @UiThread
    public synchronized void oJ(String str) {
        SwanAppComponentContainerView akS;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bl = com.baidu.swan.apps.component.container.a.bl(this.cMh, str);
        if (bl != null && (("coverView".equals(bl.akQ().cDJ) || "coverImage".equals(bl.akQ().cDJ)) && this.mFullscreenContainer != null && (akS = bl.akS()) != null)) {
            ViewParent parent = akS.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(akS);
                this.mFullscreenContainer.addView(akS);
            }
        }
    }

    @UiThread
    public synchronized void oK(String str) {
        SwanAppComponentContainerView akS;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bl = com.baidu.swan.apps.component.container.a.bl(this.cMh, str);
        if (bl != null && (("coverView".equals(bl.akQ().cDJ) || "coverImage".equals(bl.akQ().cDJ)) && (akS = bl.akS()) != null)) {
            ViewParent parent = akS.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(akS);
                bl.akN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.inlinewidget.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0446b implements h {
        private String cMh;
        private Activity mActivity;

        public C0446b(Activity activity, String str) {
            this.mActivity = activity;
            this.cMh = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.aiJ(), this.cMh)) {
                b.setFullscreen(this.mActivity, true);
                ((ViewGroup) this.mActivity.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // com.baidu.swan.apps.v.h
        public void c(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void d(e eVar) {
        }
    }
}
