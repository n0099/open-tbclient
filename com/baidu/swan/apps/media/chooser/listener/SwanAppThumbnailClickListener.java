package com.baidu.swan.apps.media.chooser.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public abstract class SwanAppThumbnailClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetectorCompat f12004a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f12005b;

    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildViewUnder = SwanAppThumbnailClickListener.this.f12005b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                SwanAppThumbnailClickListener.this.c(SwanAppThumbnailClickListener.this.f12005b.getChildViewHolder(findChildViewUnder));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View findChildViewUnder = SwanAppThumbnailClickListener.this.f12005b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                SwanAppThumbnailClickListener.this.b(SwanAppThumbnailClickListener.this.f12005b.getChildViewHolder(findChildViewUnder));
                return true;
            }
            return true;
        }
    }

    public SwanAppThumbnailClickListener(RecyclerView recyclerView) {
        this.f12005b = recyclerView;
        this.f12004a = new GestureDetectorCompat(recyclerView.getContext(), new b());
    }

    public abstract void b(RecyclerView.ViewHolder viewHolder);

    public abstract void c(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f12004a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f12004a.onTouchEvent(motionEvent);
    }
}
