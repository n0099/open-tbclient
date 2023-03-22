package com.baidu.live.feed.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes2.dex */
public class LoadRecyclerView extends RecyclerView {
    public b a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public RecyclerView.LayoutManager g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public RecyclerView.OnScrollListener l;

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public final void init() {
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.OnScrollListener {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            int i3;
            super.onScrollStateChanged(recyclerView, i);
            if (LoadRecyclerView.this.g.isSmoothScrolling()) {
                LoadRecyclerView.this.k = true;
            }
            if (i != 0 || LoadRecyclerView.this.g.getChildCount() == 0) {
                return;
            }
            if (LoadRecyclerView.this.g instanceof LinearLayoutManager) {
                i2 = ((LinearLayoutManager) LoadRecyclerView.this.g).findLastVisibleItemPosition();
            } else if (LoadRecyclerView.this.g instanceof StaggeredGridLayoutManager) {
                int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) LoadRecyclerView.this.g).findLastVisibleItemPositions(null);
                i2 = Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
            } else {
                i2 = 0;
            }
            if (LoadRecyclerView.this.g instanceof LinearLayoutManager) {
                i3 = ((LinearLayoutManager) LoadRecyclerView.this.g).findFirstVisibleItemPosition();
            } else if (LoadRecyclerView.this.g instanceof StaggeredGridLayoutManager) {
                int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) LoadRecyclerView.this.g).findFirstVisibleItemPositions(null);
                i3 = Math.min(findFirstVisibleItemPositions[0], findFirstVisibleItemPositions[1]);
            } else {
                i3 = 0;
            }
            if (this.a && i2 + LoadRecyclerView.this.f == LoadRecyclerView.this.g.getItemCount() - 1) {
                LoadRecyclerView.this.g();
            } else if (i3 == 0) {
                LoadRecyclerView.this.h();
            }
            LoadRecyclerView.this.k = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            boolean z;
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            this.a = z;
        }
    }

    public LoadRecyclerView(Context context) {
        super(context);
        this.f = 0;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.l = new a();
        init();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.g = layoutManager;
        super.setLayoutManager(layoutManager);
    }

    public void setOnLoadListener(b bVar) {
        this.a = bVar;
    }

    public void setPreloadLocation(int i) {
        this.f = i + 1;
    }

    public LoadRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.l = new a();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float abs = Math.abs(this.b - motionEvent.getX());
                float abs2 = Math.abs(this.c - motionEvent.getY());
                if (abs2 > abs && abs2 >= this.j) {
                    if (motionEvent.getY() > this.c && this.d == 0) {
                        h();
                    } else if (motionEvent.getY() < this.c && this.e == this.g.getItemCount() - 1) {
                        g();
                    }
                }
            }
        } else {
            this.c = motionEvent.getY();
            this.b = motionEvent.getX();
            RecyclerView.LayoutManager layoutManager = this.g;
            if (layoutManager instanceof LinearLayoutManager) {
                this.d = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                this.e = ((LinearLayoutManager) this.g).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
                this.d = Math.min(findFirstVisibleItemPositions[0], findFirstVisibleItemPositions[1]);
                int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) this.g).findLastVisibleItemPositions(null);
                this.e = Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void f() {
        this.i = false;
    }

    public final void g() {
        if (!this.i) {
            this.i = true;
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(this.k);
            }
        }
    }

    public final void h() {
        if (!this.h) {
            this.h = true;
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(this.k);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnScrollListener(this.l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeOnScrollListener(this.l);
        super.onDetachedFromWindow();
    }
}
