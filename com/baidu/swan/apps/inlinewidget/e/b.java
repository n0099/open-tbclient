package com.baidu.swan.apps.inlinewidget.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.v.h;
import com.baidu.swan.apps.v.i;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams dgO = new FrameLayout.LayoutParams(-1, -1);
    private String cWn;
    private int dgL;
    private a dgM;
    private C0448b dgN;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes9.dex */
    public interface a {
        void onCustomViewHidden();
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.cWn = str;
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
                    this.dgM = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, dgO);
            viewGroup.addView(this.mFullscreenContainer, dgO);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.aAN().alD() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.k(true, false);
            }
            this.dgL = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.dgN == null) {
                this.dgN = new C0448b(swanAppActivity, this.cWn);
            }
            i.a(this.dgN);
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.e.b.1
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
                i.b(this.dgN);
                this.dgN = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.dgM != null) {
                    this.dgM.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.dgL);
            }
        }
    }

    @UiThread
    public synchronized void pd(String str) {
        SwanAppComponentContainerView aoB;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bq = com.baidu.swan.apps.component.container.a.bq(this.cWn, str);
        if (bq != null && (("coverView".equals(bq.aoz().cNN) || "coverImage".equals(bq.aoz().cNN)) && this.mFullscreenContainer != null && (aoB = bq.aoB()) != null)) {
            ViewParent parent = aoB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(aoB);
                this.mFullscreenContainer.addView(aoB);
            }
        }
    }

    @UiThread
    public synchronized void pe(String str) {
        SwanAppComponentContainerView aoB;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bq = com.baidu.swan.apps.component.container.a.bq(this.cWn, str);
        if (bq != null && (("coverView".equals(bq.aoz().cNN) || "coverImage".equals(bq.aoz().cNN)) && (aoB = bq.aoB()) != null)) {
            ViewParent parent = aoB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(aoB);
                bq.aow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.inlinewidget.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0448b implements h {
        private String cWn;
        private Activity mActivity;

        public C0448b(Activity activity, String str) {
            this.mActivity = activity;
            this.cWn = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.amt(), this.cWn)) {
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
