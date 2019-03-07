package com.baidu.swan.apps.res.widget.loadingview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG & true;
    private static final WeakHashMap<ViewGroup, b> aME = new WeakHashMap<>();

    public static boolean d(Context context, ViewGroup viewGroup) {
        return a(context, viewGroup, "");
    }

    public static boolean a(Context context, ViewGroup viewGroup, String str) {
        if (context == null || viewGroup == null) {
            return false;
        }
        if (g(viewGroup)) {
            return true;
        }
        LoadingView loadingView = new LoadingView(context);
        LoadingView loadingView2 = loadingView.getLoadingView();
        if (loadingView2 == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            loadingView2.setMsg(str);
        }
        ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(loadingView2);
        }
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            viewGroup.addView(loadingView2, layoutParams);
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            viewGroup.addView(loadingView2, layoutParams2);
        } else if (!(viewGroup instanceof FrameLayout)) {
            return false;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            viewGroup.addView(loadingView2, layoutParams3);
        }
        aME.put(viewGroup, loadingView);
        loadingView2.setVisibility(0);
        if (DEBUG) {
            Log.d("LoadingViewHelper", "The count of cached loading views is : " + aME.size());
            Log.d("LoadingViewHelper", "The content of cached views is : " + aME.toString());
        }
        return true;
    }

    private static boolean g(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = aME.get(viewGroup);
        if (bVar2 != null && bVar2.getLoadingView() != null) {
            bVar2.getLoadingView().setVisibility(0);
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(0);
                aME.put(viewGroup, bVar);
                if (DEBUG) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + aME.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + aME.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean h(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = aME.get(viewGroup);
        if (bVar2 != null && bVar2.getLoadingView() != null) {
            bVar2.getLoadingView().setVisibility(8);
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                aME.put(viewGroup, bVar);
                if (DEBUG) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + aME.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + aME.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean i(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = aME.get(viewGroup);
        if (bVar2 != null) {
            View loadingView2 = bVar2.getLoadingView();
            if (loadingView2 != null) {
                if (loadingView2 instanceof BdShimmerView) {
                    ((BdShimmerView) loadingView2).Hd();
                }
                loadingView2.setVisibility(8);
                viewGroup.removeView(loadingView2);
                aME.remove(viewGroup);
                if (DEBUG) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + aME.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + aME.toString());
                }
            }
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                viewGroup.removeView((View) bVar);
                aME.remove(viewGroup);
                if (DEBUG) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + aME.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + aME.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static void IA() {
        for (ViewGroup viewGroup : aME.keySet()) {
            b bVar = aME.get(viewGroup);
            if (bVar != null && bVar.getLoadingView() != null) {
                viewGroup.removeView(bVar.getLoadingView());
            }
        }
        aME.clear();
    }
}
