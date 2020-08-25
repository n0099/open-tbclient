package com.baidu.android.ext.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.ui.BdShimmerView;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class LoadingViewHelper {
    private static final WeakHashMap<ViewGroup, LoadingViewHolder> CACHE_VIEWS = new WeakHashMap<>();
    private static final boolean DEBUG = false;
    private static final String TAG = "LoadingViewHelper";

    private LoadingViewHelper() {
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup) {
        return showLoadingView(context, viewGroup, "");
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, String str) {
        if (context == null || viewGroup == null) {
            return false;
        }
        if (showCachedLoadingView(viewGroup)) {
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
        CACHE_VIEWS.put(viewGroup, loadingView);
        loadingView2.setVisibility(0);
        return true;
    }

    public static boolean showShimmerLoadingView(Context context, ViewGroup viewGroup) {
        return showShimmerLoadingView(context, viewGroup, 0);
    }

    public static boolean showShimmerLoadingView(Context context, ViewGroup viewGroup, int i) {
        if (context == null || viewGroup == null) {
            return false;
        }
        if (showCachedLoadingView(viewGroup)) {
            return true;
        }
        BdShimmerView bdShimmerView = new BdShimmerView(context);
        BdShimmerView loadingView = bdShimmerView.getLoadingView();
        if (loadingView == null) {
            return false;
        }
        loadingView.setType(i);
        ViewGroup viewGroup2 = (ViewGroup) loadingView.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(loadingView);
        }
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            viewGroup.addView(loadingView, layoutParams);
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            viewGroup.addView(loadingView, layoutParams2);
        } else if (!(viewGroup instanceof FrameLayout)) {
            return false;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            viewGroup.addView(loadingView, layoutParams3);
        }
        CACHE_VIEWS.put(viewGroup, bdShimmerView);
        loadingView.setVisibility(0);
        loadingView.startShimmerAnimation();
        return true;
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        return showLoadingView(context, viewGroup, layoutParams, "");
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str) {
        if (context == null || viewGroup == null || layoutParams == null) {
            return false;
        }
        if (showCachedLoadingView(viewGroup)) {
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
        if ((viewGroup instanceof RelativeLayout) && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            viewGroup.addView(loadingView2, layoutParams);
        } else if ((viewGroup instanceof LinearLayout) && (layoutParams instanceof LinearLayout.LayoutParams)) {
            viewGroup.addView(loadingView2, layoutParams);
        } else if (!(viewGroup instanceof FrameLayout) || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            return false;
        } else {
            viewGroup.addView(loadingView2, layoutParams);
        }
        CACHE_VIEWS.put(viewGroup, loadingView);
        loadingView2.setVisibility(0);
        return true;
    }

    private static boolean showCachedLoadingView(ViewGroup viewGroup) {
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
        if (loadingViewHolder2 != null && loadingViewHolder2.getLoadingView() != null) {
            loadingViewHolder2.getLoadingView().setVisibility(0);
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(0);
                CACHE_VIEWS.put(viewGroup, loadingViewHolder);
                return true;
            }
        }
        return false;
    }

    public static boolean dismissLoadingView(ViewGroup viewGroup) {
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
        if (loadingViewHolder2 != null && loadingViewHolder2.getLoadingView() != null) {
            loadingViewHolder2.getLoadingView().setVisibility(8);
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                CACHE_VIEWS.put(viewGroup, loadingViewHolder);
                return true;
            }
        }
        return false;
    }

    public static boolean removeLoadingView(ViewGroup viewGroup) {
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
        if (loadingViewHolder2 != null) {
            View loadingView2 = loadingViewHolder2.getLoadingView();
            if (loadingView2 != null) {
                if (loadingView2 instanceof BdShimmerView) {
                    ((BdShimmerView) loadingView2).stopShimmerAnimation();
                }
                loadingView2.setVisibility(8);
                viewGroup.removeView(loadingView2);
                CACHE_VIEWS.remove(viewGroup);
            }
            return true;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                viewGroup.removeView((View) loadingViewHolder);
                CACHE_VIEWS.remove(viewGroup);
                return true;
            }
        }
        return false;
    }

    public static void clearCachedLoadingViews() {
        for (ViewGroup viewGroup : CACHE_VIEWS.keySet()) {
            LoadingViewHolder loadingViewHolder = CACHE_VIEWS.get(viewGroup);
            if (loadingViewHolder != null && loadingViewHolder.getLoadingView() != null) {
                viewGroup.removeView(loadingViewHolder.getLoadingView());
            }
        }
        CACHE_VIEWS.clear();
    }
}
