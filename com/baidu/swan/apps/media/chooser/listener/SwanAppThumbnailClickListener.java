package com.baidu.swan.apps.media.chooser.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public abstract class SwanAppThumbnailClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetectorCompat f11996a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f11997b;

    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildViewUnder = SwanAppThumbnailClickListener.this.f11997b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                SwanAppThumbnailClickListener.this.c(SwanAppThumbnailClickListener.this.f11997b.getChildViewHolder(findChildViewUnder));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View findChildViewUnder = SwanAppThumbnailClickListener.this.f11997b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                SwanAppThumbnailClickListener.this.b(SwanAppThumbnailClickListener.this.f11997b.getChildViewHolder(findChildViewUnder));
                return true;
            }
            return true;
        }
    }

    public SwanAppThumbnailClickListener(RecyclerView recyclerView) {
        this.f11997b = recyclerView;
        this.f11996a = new GestureDetectorCompat(recyclerView.getContext(), new b());
    }

    public abstract void b(RecyclerView.ViewHolder viewHolder);

    public abstract void c(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f11996a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f11996a.onTouchEvent(motionEvent);
    }
}
