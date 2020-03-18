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
    private static int bay = 0;
    private static int baz = 0;
    private static int baA = 0;
    private static int baB = 0;
    private static int baC = 0;

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

    public static int bh(Context context) {
        if (bay == 0) {
            bay = context.getResources().getDimensionPixelSize(c.a.min_softinput_height);
        }
        return bay;
    }

    public static int bi(Context context) {
        if (baz == 0) {
            baz = context.getResources().getDimensionPixelSize(c.a.max_softinput_height);
        }
        return baz;
    }

    public static int a(Resources resources) {
        if (baA == 0) {
            baA = resources.getDimensionPixelSize(c.a.min_panel_height);
        }
        return baA;
    }

    public static int b(Resources resources) {
        if (baB == 0) {
            baB = resources.getDimensionPixelSize(c.a.max_panel_height);
        }
        return baB;
    }

    public static int bj(Context context) {
        if (baC == 0) {
            baC = d.k(context, a(context.getResources()));
        }
        return baC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context, int i) {
        if (baC != i && i >= 0) {
            baC = i;
            if (DEBUG) {
                Log.d("SoftInputUtil", "save softInput height: " + i);
            }
            return d.j(context, i);
        }
        return false;
    }

    public static int bk(Context context) {
        return Math.min(b(context.getResources()), Math.max(a(context.getResources()), bj(context)));
    }

    /* loaded from: classes13.dex */
    private static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private final com.baidu.spswitch.b baD;
        private final a baE;
        private int baF = 0;
        private boolean baG;
        private int baH;
        private final Activity mActivity;
        private final ViewGroup mContentView;

        public b(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
            this.mActivity = activity;
            this.baE = aVar;
            this.mContentView = viewGroup;
            this.baD = bVar;
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
            } else if (c.bf(this.mContentView.getContext()) || (g.E(this.mActivity) && g.F(this.mActivity))) {
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
            if (c.bf(this.mContentView.getContext())) {
                z = height > i;
            } else {
                if (this.baH == 0) {
                    z = this.baG;
                } else {
                    z = i < this.baH - e.bh(getContext());
                }
                this.baH = Math.max(this.baH, height);
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "maxOverlayLayoutHeight: " + this.baH + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.baG);
            }
            if (this.baG != z) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                }
                this.baD.onSoftInputShowing(z);
                if (this.baE != null) {
                    this.baE.onSoftInputShowing(z);
                }
            }
            this.baG = z;
        }

        private void dQ(int i) {
            int abs;
            View view;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "****** calculateSoftInputHeight ******");
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "displayHeight: " + i + ", previousDisplayHeight: " + this.baF);
            }
            if (this.baF == 0) {
                this.baF = i;
                int bk = e.bk(getContext());
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "previous display height = 0, refresh Height : " + bk);
                }
                this.baD.dL(bk);
            }
            if (c.bf(this.mContentView.getContext())) {
                int height = ((View) this.mContentView.getParent()).getHeight() - i;
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i + ", softInputHeight: " + height);
                }
                abs = height;
            } else {
                abs = Math.abs(i - this.baF);
            }
            if (abs <= e.bh(getContext())) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "softInputHeight is invalid, too small. softInputHeight: " + abs);
                }
                if (Math.abs(abs) == f.getStatusBarHeight(this.mContentView.getContext())) {
                    this.baF -= abs;
                    return;
                }
                return;
            }
            Log.d("SoftInputUtil", String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.baF), Integer.valueOf(i), Integer.valueOf(abs)));
            if (e.l(getContext(), abs)) {
                int bk2 = e.bk(getContext());
                if (this.baD.getHeight() != bk2) {
                    if (e.DEBUG) {
                        Log.d("SoftInputUtil", "panel height changed, new height: " + bk2);
                    }
                    this.baD.dL(bk2);
                } else if (e.DEBUG) {
                    Log.d("SoftInputUtil", "panel no need to refresh, panelHeight: " + this.baD.getHeight() + ", validPanelHeight: " + bk2);
                }
            }
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }
    }
}
