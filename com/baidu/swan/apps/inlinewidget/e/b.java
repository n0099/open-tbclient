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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams dbZ = new FrameLayout.LayoutParams(-1, -1);
    private String cRB;
    private int dbW;
    private a dbX;
    private C0431b dbY;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void onCustomViewHidden();
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.cRB = str;
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
                    this.dbX = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, dbZ);
            viewGroup.addView(this.mFullscreenContainer, dbZ);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.awU().ahK() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.k(true, false);
            }
            this.dbW = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.dbY == null) {
                this.dbY = new C0431b(swanAppActivity, this.cRB);
            }
            i.a(this.dbY);
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
                i.b(this.dbY);
                this.dbY = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.dbX != null) {
                    this.dbX.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.dbW);
            }
        }
    }

    @UiThread
    public synchronized void nQ(String str) {
        SwanAppComponentContainerView akI;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bp = com.baidu.swan.apps.component.container.a.bp(this.cRB, str);
        if (bp != null && (("coverView".equals(bp.akG().cJb) || "coverImage".equals(bp.akG().cJb)) && this.mFullscreenContainer != null && (akI = bp.akI()) != null)) {
            ViewParent parent = akI.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(akI);
                this.mFullscreenContainer.addView(akI);
            }
        }
    }

    @UiThread
    public synchronized void nR(String str) {
        SwanAppComponentContainerView akI;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a bp = com.baidu.swan.apps.component.container.a.bp(this.cRB, str);
        if (bp != null && (("coverView".equals(bp.akG().cJb) || "coverImage".equals(bp.akG().cJb)) && (akI = bp.akI()) != null)) {
            ViewParent parent = akI.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(akI);
                bp.akD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.inlinewidget.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0431b implements h {
        private String cRB;
        private Activity mActivity;

        public C0431b(Activity activity, String str) {
            this.mActivity = activity;
            this.cRB = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.aiA(), this.cRB)) {
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
