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
    private static final ViewGroup.LayoutParams bVy = new FrameLayout.LayoutParams(-1, -1);
    private String bPR;
    private int bVw;
    private InterfaceC0306a bVx;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* renamed from: com.baidu.swan.apps.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0306a {
        void onCustomViewHidden();
    }

    public a(Context context, String str) {
        this.mContext = context;
        this.bPR = str;
    }

    public void a(View view, int i, @Nullable InterfaceC0306a interfaceC0306a) {
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
                if (interfaceC0306a != null) {
                    interfaceC0306a.onCustomViewHidden();
                    this.bVx = interfaceC0306a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.mFullscreenContainer.addView(view, bVy);
            viewGroup.addView(this.mFullscreenContainer, bVy);
            this.mCustomView = view;
            setFullscreen(activity, true);
            activity.setRequestedOrientation(i);
            this.bVw = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.d.a.1
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
                if (this.bVx != null) {
                    this.bVx.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.bVw);
            }
        }
    }

    @UiThread
    public synchronized void jp(String str) {
        SwanAppComponentContainerView SB;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aB = com.baidu.swan.apps.component.container.a.aB(this.bPR, str);
        if (aB != null && (("coverView".equals(aB.Sz().bGH) || "coverImage".equals(aB.Sz().bGH)) && this.mFullscreenContainer != null && (SB = aB.SB()) != null)) {
            ViewParent parent = SB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(SB);
                this.mFullscreenContainer.addView(SB);
            }
        }
    }

    @UiThread
    public synchronized void jq(String str) {
        SwanAppComponentContainerView SB;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aB = com.baidu.swan.apps.component.container.a.aB(this.bPR, str);
        if (aB != null && (("coverView".equals(aB.Sz().bGH) || "coverImage".equals(aB.Sz().bGH)) && (SB = aB.SB()) != null)) {
            ViewParent parent = SB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(SB);
                aB.Sw();
            }
        }
    }

    private void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }
}
