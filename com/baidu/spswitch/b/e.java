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
/* loaded from: classes12.dex */
public class e {
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();
    private static int aVX = 0;
    private static int aVY = 0;
    private static int aVZ = 0;
    private static int aWa = 0;
    private static int aWb = 0;

    /* loaded from: classes12.dex */
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

    public static int be(Context context) {
        if (aVX == 0) {
            aVX = context.getResources().getDimensionPixelSize(c.a.min_softinput_height);
        }
        return aVX;
    }

    public static int bf(Context context) {
        if (aVY == 0) {
            aVY = context.getResources().getDimensionPixelSize(c.a.max_softinput_height);
        }
        return aVY;
    }

    public static int a(Resources resources) {
        if (aVZ == 0) {
            aVZ = resources.getDimensionPixelSize(c.a.min_panel_height);
        }
        return aVZ;
    }

    public static int b(Resources resources) {
        if (aWa == 0) {
            aWa = resources.getDimensionPixelSize(c.a.max_panel_height);
        }
        return aWa;
    }

    public static int bg(Context context) {
        if (aWb == 0) {
            aWb = d.k(context, a(context.getResources()));
        }
        return aWb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context, int i) {
        if (aWb != i && i >= 0) {
            aWb = i;
            if (DEBUG) {
                Log.d("SoftInputUtil", "save softInput height: " + i);
            }
            return d.j(context, i);
        }
        return false;
    }

    public static int bh(Context context) {
        return Math.min(b(context.getResources()), Math.max(a(context.getResources()), bg(context)));
    }

    /* loaded from: classes12.dex */
    private static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private final com.baidu.spswitch.b aWc;
        private final a aWd;
        private int aWe = 0;
        private boolean aWf;
        private int aWg;
        private final Activity mActivity;
        private final ViewGroup mContentView;

        public b(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
            this.mActivity = activity;
            this.aWd = aVar;
            this.mContentView = viewGroup;
            this.aWc = bVar;
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
            } else if (c.bc(this.mContentView.getContext()) || (g.D(this.mActivity) && g.E(this.mActivity))) {
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
                dA(i);
                dz(i);
            }
        }

        private void dz(int i) {
            boolean z;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "###### calculateSoftInputShowing ######");
            }
            View view = (View) this.mContentView.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (c.bc(this.mContentView.getContext())) {
                z = height > i;
            } else {
                if (this.aWg == 0) {
                    z = this.aWf;
                } else {
                    z = i < this.aWg - e.be(getContext());
                }
                this.aWg = Math.max(this.aWg, height);
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "maxOverlayLayoutHeight: " + this.aWg + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.aWf);
            }
            if (this.aWf != z) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                }
                this.aWc.onSoftInputShowing(z);
                if (this.aWd != null) {
                    this.aWd.onSoftInputShowing(z);
                }
            }
            this.aWf = z;
        }

        private void dA(int i) {
            int abs;
            View view;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "****** calculateSoftInputHeight ******");
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "displayHeight: " + i + ", previousDisplayHeight: " + this.aWe);
            }
            if (this.aWe == 0) {
                this.aWe = i;
                int bh = e.bh(getContext());
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "previous display height = 0, refresh Height : " + bh);
                }
                this.aWc.dv(bh);
            }
            if (c.bc(this.mContentView.getContext())) {
                int height = ((View) this.mContentView.getParent()).getHeight() - i;
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i + ", softInputHeight: " + height);
                }
                abs = height;
            } else {
                abs = Math.abs(i - this.aWe);
            }
            if (abs <= e.be(getContext())) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "softInputHeight is invalid, too small. softInputHeight: " + abs);
                }
                if (Math.abs(abs) == f.getStatusBarHeight(this.mContentView.getContext())) {
                    this.aWe -= abs;
                    return;
                }
                return;
            }
            Log.d("SoftInputUtil", String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.aWe), Integer.valueOf(i), Integer.valueOf(abs)));
            if (e.l(getContext(), abs)) {
                int bh2 = e.bh(getContext());
                if (this.aWc.getHeight() != bh2) {
                    if (e.DEBUG) {
                        Log.d("SoftInputUtil", "panel height changed, new height: " + bh2);
                    }
                    this.aWc.dv(bh2);
                } else if (e.DEBUG) {
                    Log.d("SoftInputUtil", "panel no need to refresh, panelHeight: " + this.aWc.getHeight() + ", validPanelHeight: " + bh2);
                }
            }
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }
    }
}
