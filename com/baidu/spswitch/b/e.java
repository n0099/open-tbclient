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
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();
    private static int aVf = 0;
    private static int aVg = 0;
    private static int aVh = 0;
    private static int aVi = 0;
    private static int aVj = 0;

    /* loaded from: classes11.dex */
    public interface a {
        void onSoftInputShowing(boolean z);
    }

    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
        ViewGroup viewGroup2 = viewGroup == null ? (ViewGroup) activity.findViewById(16908290) : viewGroup;
        b bVar2 = new b(activity, viewGroup2, bVar, aVar);
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(bVar2);
        return bVar2;
    }

    public static void V(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void a(final View view, long j) {
        view.postDelayed(new Runnable() { // from class: com.baidu.spswitch.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.V(view);
            }
        }, j);
    }

    public static void W(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int be(Context context) {
        if (aVf == 0) {
            aVf = context.getResources().getDimensionPixelSize(c.a.min_softinput_height);
        }
        return aVf;
    }

    public static int bf(Context context) {
        if (aVg == 0) {
            aVg = context.getResources().getDimensionPixelSize(c.a.max_softinput_height);
        }
        return aVg;
    }

    public static int a(Resources resources) {
        if (aVh == 0) {
            aVh = resources.getDimensionPixelSize(c.a.min_panel_height);
        }
        return aVh;
    }

    public static int b(Resources resources) {
        if (aVi == 0) {
            aVi = resources.getDimensionPixelSize(c.a.max_panel_height);
        }
        return aVi;
    }

    public static int bg(Context context) {
        if (aVj == 0) {
            aVj = d.k(context, a(context.getResources()));
        }
        return aVj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context, int i) {
        if (aVj != i && i >= 0) {
            aVj = i;
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

    /* loaded from: classes11.dex */
    private static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private final com.baidu.spswitch.b aVk;
        private final a aVl;
        private int aVm = 0;
        private boolean aVn;
        private int aVo;
        private final Activity mActivity;
        private final ViewGroup mContentView;

        public b(Activity activity, ViewGroup viewGroup, com.baidu.spswitch.b bVar, a aVar) {
            this.mActivity = activity;
            this.aVl = aVar;
            this.mContentView = viewGroup;
            this.aVk = bVar;
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
            } else if (c.bc(this.mContentView.getContext()) || (g.C(this.mActivity) && g.D(this.mActivity))) {
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
                dz(i);
                dy(i);
            }
        }

        private void dy(int i) {
            boolean z;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "###### calculateSoftInputShowing ######");
            }
            View view = (View) this.mContentView.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (c.bc(this.mContentView.getContext())) {
                z = height > i;
            } else {
                if (this.aVo == 0) {
                    z = this.aVn;
                } else {
                    z = i < this.aVo - e.be(getContext());
                }
                this.aVo = Math.max(this.aVo, height);
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "maxOverlayLayoutHeight: " + this.aVo + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.aVn);
            }
            if (this.aVn != z) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                }
                this.aVk.onSoftInputShowing(z);
                if (this.aVl != null) {
                    this.aVl.onSoftInputShowing(z);
                }
            }
            this.aVn = z;
        }

        private void dz(int i) {
            int abs;
            View view;
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "****** calculateSoftInputHeight ******");
            }
            if (e.DEBUG) {
                Log.d("SoftInputUtil", "displayHeight: " + i + ", previousDisplayHeight: " + this.aVm);
            }
            if (this.aVm == 0) {
                this.aVm = i;
                int bh = e.bh(getContext());
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "previous display height = 0, refresh Height : " + bh);
                }
                this.aVk.du(bh);
            }
            if (c.bc(this.mContentView.getContext())) {
                int height = ((View) this.mContentView.getParent()).getHeight() - i;
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i + ", softInputHeight: " + height);
                }
                abs = height;
            } else {
                abs = Math.abs(i - this.aVm);
            }
            if (abs <= e.be(getContext())) {
                if (e.DEBUG) {
                    Log.d("SoftInputUtil", "softInputHeight is invalid, too small. softInputHeight: " + abs);
                }
                if (Math.abs(abs) == f.getStatusBarHeight(this.mContentView.getContext())) {
                    this.aVm -= abs;
                    return;
                }
                return;
            }
            Log.d("SoftInputUtil", String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.aVm), Integer.valueOf(i), Integer.valueOf(abs)));
            if (e.l(getContext(), abs)) {
                int bh2 = e.bh(getContext());
                if (this.aVk.getHeight() != bh2) {
                    if (e.DEBUG) {
                        Log.d("SoftInputUtil", "panel height changed, new height: " + bh2);
                    }
                    this.aVk.du(bh2);
                } else if (e.DEBUG) {
                    Log.d("SoftInputUtil", "panel no need to refresh, panelHeight: " + this.aVk.getHeight() + ", validPanelHeight: " + bh2);
                }
            }
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }
    }
}
