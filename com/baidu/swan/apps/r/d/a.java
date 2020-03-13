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
    private static final ViewGroup.LayoutParams bxg = new FrameLayout.LayoutParams(-1, -1);
    private String bry;
    private int bxe;
    private InterfaceC0276a bxf;
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
        this.bry = str;
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
                    this.bxf = interfaceC0276a;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.mFullscreenContainer.addView(view, bxg);
            viewGroup.addView(this.mFullscreenContainer, bxg);
            this.mCustomView = view;
            setFullscreen(activity, true);
            activity.setRequestedOrientation(i);
            this.bxe = viewGroup.getSystemUiVisibility();
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
                if (this.bxf != null) {
                    this.bxf.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.bxe);
            }
        }
    }

    @UiThread
    public synchronized void ic(String str) {
        SwanAppComponentContainerView KK;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a at = com.baidu.swan.apps.component.container.a.at(this.bry, str);
        if (at != null && (("coverView".equals(at.KI().bil) || "coverImage".equals(at.KI().bil)) && this.mFullscreenContainer != null && (KK = at.KK()) != null)) {
            ViewParent parent = KK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(KK);
                this.mFullscreenContainer.addView(KK);
            }
        }
    }

    @UiThread
    public synchronized void ie(String str) {
        SwanAppComponentContainerView KK;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a at = com.baidu.swan.apps.component.container.a.at(this.bry, str);
        if (at != null && (("coverView".equals(at.KI().bil) || "coverImage".equals(at.KI().bil)) && (KK = at.KK()) != null)) {
            ViewParent parent = KK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(KK);
                at.KF();
            }
        }
    }

    private void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }
}
