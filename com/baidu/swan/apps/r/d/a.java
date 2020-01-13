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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final ViewGroup.LayoutParams bsU = new FrameLayout.LayoutParams(-1, -1);
    private String bnn;
    private int bsS;
    private InterfaceC0266a bsT;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* renamed from: com.baidu.swan.apps.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0266a {
        void onCustomViewHidden();
    }

    public a(Context context, String str) {
        this.mContext = context;
        this.bnn = str;
    }

    public void a(View view, int i, @Nullable InterfaceC0266a interfaceC0266a) {
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
                if (interfaceC0266a != null) {
                    interfaceC0266a.onCustomViewHidden();
                    this.bsT = interfaceC0266a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.mFullscreenContainer.addView(view, bsU);
            viewGroup.addView(this.mFullscreenContainer, bsU);
            this.mCustomView = view;
            setFullscreen(activity, true);
            activity.setRequestedOrientation(i);
            this.bsS = viewGroup.getSystemUiVisibility();
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
                if (this.bsT != null) {
                    this.bsT.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.bsS);
            }
        }
    }

    @UiThread
    public synchronized void hN(String str) {
        SwanAppComponentContainerView It;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aj = com.baidu.swan.apps.component.container.a.aj(this.bnn, str);
        if (aj != null && (("coverView".equals(aj.Ir().bdU) || "coverImage".equals(aj.Ir().bdU)) && this.mFullscreenContainer != null && (It = aj.It()) != null)) {
            ViewParent parent = It.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(It);
                this.mFullscreenContainer.addView(It);
            }
        }
    }

    @UiThread
    public synchronized void hO(String str) {
        SwanAppComponentContainerView It;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aj = com.baidu.swan.apps.component.container.a.aj(this.bnn, str);
        if (aj != null && (("coverView".equals(aj.Ir().bdU) || "coverImage".equals(aj.Ir().bdU)) && (It = aj.It()) != null)) {
            ViewParent parent = It.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(It);
                aj.Io();
            }
        }
    }

    private void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }
}
