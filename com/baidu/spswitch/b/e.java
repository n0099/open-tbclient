package com.baidu.spswitch.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.baidu.spswitch.c;
/* loaded from: classes13.dex */
public class e {
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();
    private static int bal = 0;
    private static int bam = 0;
    private static int ban = 0;
    private static int bao = 0;
    private static int bap = 0;

    /* loaded from: classes13.dex */
    public interface a {
        void onSoftInputShowing(boolean z);
    }

    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
        ViewGroup viewGroup2 = viewGroup == null ? (ViewGroup) activity.findViewById(16908290) : viewGroup;
        b bVar2 = new b(activity, viewGroup2, bVar, aVar);
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(bVar2);
        return bVar2;
    }

    public static void Z(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void a(final View view, long j) {
        view.postDelayed(new Runnable() { // from class: com.baidu.spswitch.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.Z(view);
            }
        }, j);
    }

    public static void aa(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int bi(Context context) {
        if (bal == 0) {
            bal = context.getResources().getDimensionPixelSize(c.a.min_softinput_height);
        }
        return bal;
    }

    public static int bj(Context context) {
        if (bam == 0) {
            bam = context.getResources().getDimensionPixelSize(c.a.max_softinput_height);
        }
        return bam;
    }

    public static int a(Resources resources) {
        if (ban == 0) {
            ban = resources.getDimensionPixelSize(c.a.min_panel_height);
        }
        return ban;
    }

    public static int b(Resources resources) {
        if (bao == 0) {
            bao = resources.getDimensionPixelSize(c.a.max_panel_height);
        }
        return bao;
    }

    public static int bk(Context context) {
        if (bap == 0) {
            bap = d.k(context, a(context.getResources()));
        }
        return bap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context, int i) {
        if (bap != i && i >= 0) {
            bap = i;
            if (DEBUG) {
                Log.d("SoftInputUtil", "save softInput height: " + i);
            }
            return d.j(context, i);
        }
        return false;
    }

    public static int bl(Context context) {
        return Math.min(b(context.getResources()), Math.max(a(context.getResources()), bk(context)));
    }

    /* loaded from: classes13.dex */
    private static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private final com.baidu.spswitch.b baq;
        private final a bar;
        private int bas = 0;
        private boolean bat;
        private int bau;
        private final Activity mActivity;
        private final ViewGroup mContentView;

        public b(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
            this.mActivity = activity;
            this.bar = aVar;
            this.mContentView = viewGroup;
            this.baq = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            View childAt = this.mContentView.getChildAt(0);
            Rect rect = new Rect();
            if (childAt == null) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "SoftInputUtil, user root view not ready so ignore layout changed");
                }
                i = -1;
            } else if (c.bg(this.mContentView.getContext()) || (g.E(this.mActivity) && g.F(this.mActivity))) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "#onGlobalLayout#, displayHeight calc by getWindowVisibleDisplayFrame");
                }
            } else {
                i = childAt.getHeight();
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "#onGlobalLayout#, displayHeight calc by userRootView.getHeight()");
                }
            }
            if (i != -1) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "displayHeight: " + i);
                }
                dQ(i);
                dP(i);
            }
        }

        private void dP(int i) {
            boolean z;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "###### calculateSoftInputShowing ######");
            }
            View view = (View) this.mContentView.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (c.bg(this.mContentView.getContext())) {
                z = height > i;
            } else {
                if (this.bau == 0) {
                    z = this.bat;
                } else {
                    z = i < this.bau - e.bi(getContext());
                }
                this.bau = Math.max(this.bau, height);
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "maxOverlayLayoutHeight: " + this.bau + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.bat);
            }
            if (this.bat != z) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                }
                this.baq.onSoftInputShowing(z);
                if (this.bar != null) {
                    this.bar.onSoftInputShowing(z);
                }
            }
            this.bat = z;
        }

        private void dQ(int i) {
            int abs;
            View view;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "****** calculateSoftInputHeight ******");
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "displayHeight: " + i + ", previousDisplayHeight: " + this.bas);
            }
            if (this.bas == 0) {
                this.bas = i;
                int bl = e.bl(getContext());
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "previous display height = 0, refresh Height : " + bl);
                }
                this.baq.dL(bl);
            }
            if (c.bg(this.mContentView.getContext())) {
                int height = ((View) this.mContentView.getParent()).getHeight() - i;
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i + ", softInputHeight: " + height);
                }
                abs = height;
            } else {
                abs = Math.abs(i - this.bas);
            }
            if (abs <= e.bi(getContext())) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "softInputHeight is invalid, too small. softInputHeight: " + abs);
                }
                if (Math.abs(abs) == f.getStatusBarHeight(this.mContentView.getContext())) {
                    this.bas -= abs;
                    return;
                }
                return;
            }
            Log.d("SoftInputUtil", String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.bas), Integer.valueOf(i), Integer.valueOf(abs)));
            if (e.l(getContext(), abs)) {
                int bl2 = e.bl(getContext());
                if (this.baq.getHeight() != bl2) {
                    if (e.DEBUG) {
                        Log.d("SoftInputUtil", "panel height changed, new height: " + bl2);
                    }
                    this.baq.dL(bl2);
                } else if (e.DEBUG) {
                    Log.d("SoftInputUtil", "panel no need to refresh, panelHeight: " + this.baq.getHeight() + ", validPanelHeight: " + bl2);
                }
            }
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }
    }
}
