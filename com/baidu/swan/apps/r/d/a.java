package com.baidu.swan.apps.r.d;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final ViewGroup.LayoutParams bxs = new FrameLayout.LayoutParams(-1, -1);
    private String brK;
    private int bxq;
    private InterfaceC0276a bxr;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* renamed from: com.baidu.swan.apps.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0276a {
        void onCustomViewHidden();
    }

    public a(Context context, String str) {
        this.mContext = context;
        this.brK = str;
    }

    public void a(View view, int i, @Nullable InterfaceC0276a interfaceC0276a) {
        if (DEBUG) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.mContext;
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            if (this.mCustomView != null) {
                if (interfaceC0276a != null) {
                    interfaceC0276a.onCustomViewHidden();
                    this.bxr = interfaceC0276a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.mFullscreenContainer.addView(view, bxs);
            viewGroup.addView(this.mFullscreenContainer, bxs);
            this.mCustomView = view;
            setFullscreen(activity, true);
            activity.setRequestedOrientation(i);
            this.bxq = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.d.a.1
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
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.bxr != null) {
                    this.bxr.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.bxq);
            }
        }
    }

    @UiThread
    public synchronized void ib(String str) {
        SwanAppComponentContainerView KN;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a as = com.baidu.swan.apps.component.container.a.as(this.brK, str);
        if (as != null && (("coverView".equals(as.KL().biz) || "coverImage".equals(as.KL().biz)) && this.mFullscreenContainer != null && (KN = as.KN()) != null)) {
            ViewParent parent = KN.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(KN);
                this.mFullscreenContainer.addView(KN);
            }
        }
    }

    @UiThread
    public synchronized void ic(String str) {
        SwanAppComponentContainerView KN;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a as = com.baidu.swan.apps.component.container.a.as(this.brK, str);
        if (as != null && (("coverView".equals(as.KL().biz) || "coverImage".equals(as.KL().biz)) && (KN = as.KN()) != null)) {
            ViewParent parent = KN.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(KN);
                as.KI();
            }
        }
    }

    private void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }
}
