package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class f extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView ajt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalListView horizontalListView) {
        this.ajt = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.ajt.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.ajt.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.ajt) {
            this.ajt.aje += (int) f;
        }
        this.ajt.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        int i;
        int i2;
        AdapterView.OnItemClickListener onItemClickListener2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.ajt.getChildCount()) {
                View childAt = this.ajt.getChildAt(i6);
                if (a(motionEvent, childAt)) {
                    onItemClickListener = this.ajt.ajk;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.ajt.ajk;
                        HorizontalListView horizontalListView = this.ajt;
                        i3 = this.ajt.ajb;
                        ListAdapter listAdapter = this.ajt.mAdapter;
                        i4 = this.ajt.ajb;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.ajt.ajj;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.ajt.ajj;
                        HorizontalListView horizontalListView2 = this.ajt;
                        i = this.ajt.ajb;
                        ListAdapter listAdapter2 = this.ajt.mAdapter;
                        i2 = this.ajt.ajb;
                        onItemSelectedListener2.onItemSelected(horizontalListView2, childAt, i + 1 + i6, listAdapter2.getItemId(i2 + 1 + i6));
                        return true;
                    }
                    return true;
                }
                i5 = i6 + 1;
            } else {
                return true;
            }
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        int i;
        int i2;
        int childCount = this.ajt.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.ajt.getChildAt(i3);
            if (a(motionEvent, childAt)) {
                onItemLongClickListener = this.ajt.ajl;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.ajt.ajl;
                    HorizontalListView horizontalListView = this.ajt;
                    i = this.ajt.ajb;
                    ListAdapter listAdapter = this.ajt.mAdapter;
                    i2 = this.ajt.ajb;
                    onItemLongClickListener2.onItemLongClick(horizontalListView, childAt, i + 1 + i3, listAdapter.getItemId(i3 + i2 + 1));
                    return;
                }
                return;
            }
        }
    }

    private boolean a(MotionEvent motionEvent, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }
}
