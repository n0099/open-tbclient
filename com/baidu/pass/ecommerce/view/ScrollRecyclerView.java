package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollRecyclerView extends RecyclerView {
    public final CompositeScrollListener compositeScrollListener;

    /* loaded from: classes3.dex */
    public interface RecyclerViewItemClickListener<T> {
        void onItemClickListener(int i, T t);
    }

    /* loaded from: classes3.dex */
    public static class CompositeScrollListener extends RecyclerView.OnScrollListener {
        public final List<RecyclerView.OnScrollListener> scrollListenerList;

        public CompositeScrollListener() {
            this.scrollListenerList = new ArrayList();
        }

        public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
            if (onScrollListener == null) {
                return;
            }
            for (RecyclerView.OnScrollListener onScrollListener2 : this.scrollListenerList) {
                if (onScrollListener == onScrollListener2) {
                    return;
                }
            }
            this.scrollListenerList.add(onScrollListener);
        }

        public void removeOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
            if (onScrollListener == null) {
                return;
            }
            Iterator<RecyclerView.OnScrollListener> it = this.scrollListenerList.iterator();
            while (it.hasNext()) {
                if (onScrollListener == it.next()) {
                    it.remove();
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.scrollListenerList)) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.scrollListenerList)) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
        }
    }

    public ScrollRecyclerView(@NonNull Context context) {
        super(context);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = ScrollRecyclerView.this.getLayoutParams();
                ViewParent parent = ScrollRecyclerView.this.getParent();
                while (true) {
                    if (parent == null) {
                        break;
                    } else if (parent instanceof ScrollLayout) {
                        ScrollLayout scrollLayout = (ScrollLayout) parent;
                        int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                        if (layoutParams.height == measuredHeight) {
                            return;
                        }
                        layoutParams.height = measuredHeight;
                    } else {
                        parent = parent.getParent();
                    }
                }
                ScrollRecyclerView.this.setLayoutParams(layoutParams);
            }
        });
    }

    public ScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = ScrollRecyclerView.this.getLayoutParams();
                ViewParent parent = ScrollRecyclerView.this.getParent();
                while (true) {
                    if (parent == null) {
                        break;
                    } else if (parent instanceof ScrollLayout) {
                        ScrollLayout scrollLayout = (ScrollLayout) parent;
                        int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                        if (layoutParams.height == measuredHeight) {
                            return;
                        }
                        layoutParams.height = measuredHeight;
                    } else {
                        parent = parent.getParent();
                    }
                }
                ScrollRecyclerView.this.setLayoutParams(layoutParams);
            }
        });
    }

    public ScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = ScrollRecyclerView.this.getLayoutParams();
                ViewParent parent = ScrollRecyclerView.this.getParent();
                while (true) {
                    if (parent == null) {
                        break;
                    } else if (parent instanceof ScrollLayout) {
                        ScrollLayout scrollLayout = (ScrollLayout) parent;
                        int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                        if (layoutParams.height == measuredHeight) {
                            return;
                        }
                        layoutParams.height = measuredHeight;
                    } else {
                        parent = parent.getParent();
                    }
                }
                ScrollRecyclerView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Must be invoked from the main thread.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedRecyclerView(this);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
