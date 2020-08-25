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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ViewGroup.LayoutParams cuf = new FrameLayout.LayoutParams(-1, -1);
    private String cjv;
    private int cuc;
    private a cud;
    private C0408b cue;
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
        this.cjv = str;
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
                    this.cud = aVar;
                    return;
                }
                return;
            }
            this.mOriginalOrientation = swanAppActivity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) swanAppActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new SwanAppInlineFullScreenContainer(swanAppActivity);
            this.mFullscreenContainer.addView(view, cuf);
            viewGroup.addView(this.mFullscreenContainer, cuf);
            this.mCustomView = view;
            setFullscreen(swanAppActivity, true);
            swanAppActivity.setRequestedOrientation(i);
            if (com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState() && (swanAppActivity instanceof SwanAppActivity)) {
                swanAppActivity.k(true, false);
            }
            this.cuc = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.cue == null) {
                this.cue = new C0408b(swanAppActivity, this.cjv);
            }
            i.a(this.cue);
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
                i.b(this.cue);
                this.cue = null;
                setFullscreen(activity, false);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                if (this.cud != null) {
                    this.cud.onCustomViewHidden();
                }
                activity.setRequestedOrientation(this.mOriginalOrientation);
                viewGroup.setSystemUiVisibility(this.cuc);
            }
        }
    }

    @UiThread
    public synchronized void mU(String str) {
        SwanAppComponentContainerView ade;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aZ = com.baidu.swan.apps.component.container.a.aZ(this.cjv, str);
        if (aZ != null && (("coverView".equals(aZ.adc().caS) || "coverImage".equals(aZ.adc().caS)) && this.mFullscreenContainer != null && (ade = aZ.ade()) != null)) {
            ViewParent parent = ade.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(ade);
                this.mFullscreenContainer.addView(ade);
            }
        }
    }

    @UiThread
    public synchronized void mV(String str) {
        SwanAppComponentContainerView ade;
        if (DEBUG) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        com.baidu.swan.apps.component.b.a aZ = com.baidu.swan.apps.component.container.a.aZ(this.cjv, str);
        if (aZ != null && (("coverView".equals(aZ.adc().caS) || "coverImage".equals(aZ.adc().caS)) && (ade = aZ.ade()) != null)) {
            ViewParent parent = ade.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(ade);
                aZ.acZ();
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
    public static class C0408b implements h {
        private String cjv;
        private Activity mActivity;

        public C0408b(Activity activity, String str) {
            this.mActivity = activity;
            this.cjv = str;
        }

        @Override // com.baidu.swan.apps.v.h
        public void a(e eVar) {
        }

        @Override // com.baidu.swan.apps.v.h
        public void b(e eVar) {
            if (TextUtils.equals(eVar.aaU(), this.cjv)) {
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
