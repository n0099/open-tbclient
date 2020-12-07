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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams dbT = new FrameLayout.LayoutParams(-1, -1);
    private String cRq;
    private int dbQ;
    private a dbR;
    private C0456b dbS;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes25.dex */
    public interface a {
        void onCustomViewHidden();
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.cRq = str;
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
                    this.dbR = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, dbT);
            viewGroup.addView(this.mFullscreenContainer, dbT);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.k(true, false);
            }
            this.dbQ = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.dbS == null) {
                this.dbS = new C0456b(swanAppActivity, this.cRq);
            }
            i.a(this.dbS);
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
                i.b(this.dbS);
                this.dbS = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.dbR != null) {
                    this.dbR.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.dbQ);
            }
        }
    }

    @UiThread
    public synchronized void pk(String str) {
        SwanAppComponentContainerView ans;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a br = com.baidu.swan.apps.component.container.a.br(this.cRq, str);
        if (br != null && (("coverView".equals(br.anq().cIU) || "coverImage".equals(br.anq().cIU)) && this.mFullscreenContainer != null && (ans = br.ans()) != null)) {
            ViewParent parent = ans.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(ans);
                this.mFullscreenContainer.addView(ans);
            }
        }
    }

    @UiThread
    public synchronized void pl(String str) {
        SwanAppComponentContainerView ans;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a br = com.baidu.swan.apps.component.container.a.br(this.cRq, str);
        if (br != null && (("coverView".equals(br.anq().cIU) || "coverImage".equals(br.anq().cIU)) && (ans = br.ans()) != null)) {
            ViewParent parent = ans.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(ans);
                br.ann();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.inlinewidget.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0456b implements h {
        private String cRq;
        private Activity mActivity;

        public C0456b(Activity activity, String str) {
            this.mActivity = activity;
            this.cRq = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.alj(), this.cRq)) {
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
