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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final ViewGroup.LayoutParams bsg = new FrameLayout.LayoutParams(-1, -1);
    private String bmz;
    private int bse;
    private InterfaceC0264a bsf;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* renamed from: com.baidu.swan.apps.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0264a {
        void onCustomViewHidden();
    }

    public a(Context context, String str) {
        this.mContext = context;
        this.bmz = str;
    }

    public void a(View view, int i, @Nullable InterfaceC0264a interfaceC0264a) {
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
                if (interfaceC0264a != null) {
                    interfaceC0264a.onCustomViewHidden();
                    this.bsf = interfaceC0264a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.mFullscreenContainer.addView(view, bsg);
            viewGroup.addView(this.mFullscreenContainer, bsg);
            this.mCustomView = view;
            setFullscreen(activity, true);
            activity.setRequestedOrientation(i);
            this.bse = viewGroup.getSystemUiVisibility();
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
                if (this.bsf != null) {
                    this.bsf.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.bse);
            }
        }
    }

    @UiThread
    public synchronized void hK(String str) {
        SwanAppComponentContainerView HX;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a ai = com.baidu.swan.apps.component.container.a.ai(this.bmz, str);
        if (ai != null && (("coverView".equals(ai.HV().bdg) || "coverImage".equals(ai.HV().bdg)) && this.mFullscreenContainer != null && (HX = ai.HX()) != null)) {
            ViewParent parent = HX.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(HX);
                this.mFullscreenContainer.addView(HX);
            }
        }
    }

    @UiThread
    public synchronized void hL(String str) {
        SwanAppComponentContainerView HX;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a ai = com.baidu.swan.apps.component.container.a.ai(this.bmz, str);
        if (ai != null && (("coverView".equals(ai.HV().bdg) || "coverImage".equals(ai.HV().bdg)) && (HX = ai.HX()) != null)) {
            ViewParent parent = HX.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(HX);
                ai.HS();
            }
        }
    }

    private void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }
}
