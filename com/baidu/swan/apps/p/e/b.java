package com.baidu.swan.apps.p.e;

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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.v.h;
import com.baidu.swan.apps.v.i;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams cmO = new FrameLayout.LayoutParams(-1, -1);
    private String cgh;
    private int cmL;
    private a cmM;
    private C0372b cmN;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes7.dex */
    public interface a {
        void onCustomViewHidden();
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.cgh = str;
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
                    this.cmM = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, cmO);
            viewGroup.addView(this.mFullscreenContainer, cmO);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.j(true, false);
            }
            this.cmL = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.cmN == null) {
                this.cmN = new C0372b(swanAppActivity, this.cgh);
            }
            i.a(this.cmN);
            al.p(new Runnable() { // from class: com.baidu.swan.apps.p.e.b.1
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
                i.b(this.cmN);
                this.cmN = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.cmM != null) {
                    this.cmM.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.cmL);
            }
        }
    }

    @UiThread
    public synchronized void lc(String str) {
        SwanAppComponentContainerView WY;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aU = com.baidu.swan.apps.component.container.a.aU(this.cgh, str);
        if (aU != null && (("coverView".equals(aU.WW().bVk) || "coverImage".equals(aU.WW().bVk)) && this.mFullscreenContainer != null && (WY = aU.WY()) != null)) {
            ViewParent parent = WY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(WY);
                this.mFullscreenContainer.addView(WY);
            }
        }
    }

    @UiThread
    public synchronized void ld(String str) {
        SwanAppComponentContainerView WY;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aU = com.baidu.swan.apps.component.container.a.aU(this.cgh, str);
        if (aU != null && (("coverView".equals(aU.WW().bVk) || "coverImage".equals(aU.WW().bVk)) && (WY = aU.WY()) != null)) {
            ViewParent parent = WY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(WY);
                aU.WT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.p.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0372b implements h {
        private String cgh;
        private Activity mActivity;

        public C0372b(Activity activity, String str) {
            this.mActivity = activity;
            this.cgh = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.UR(), this.cgh)) {
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
