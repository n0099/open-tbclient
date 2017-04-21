package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class f extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView ajy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalListView horizontalListView) {
        this.ajy = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.ajy.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.ajy.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.ajy) {
            this.ajy.aji += (int) f;
        }
        this.ajy.requestLayout();
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
            if (i6 < this.ajy.getChildCount()) {
                View childAt = this.ajy.getChildAt(i6);
                if (a(motionEvent, childAt)) {
                    onItemClickListener = this.ajy.ajo;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.ajy.ajo;
                        HorizontalListView horizontalListView = this.ajy;
                        i3 = this.ajy.ajf;
                        ListAdapter listAdapter = this.ajy.mAdapter;
                        i4 = this.ajy.ajf;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.ajy.ajn;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.ajy.ajn;
                        HorizontalListView horizontalListView2 = this.ajy;
                        i = this.ajy.ajf;
                        ListAdapter listAdapter2 = this.ajy.mAdapter;
                        i2 = this.ajy.ajf;
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
        int childCount = this.ajy.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.ajy.getChildAt(i3);
            if (a(motionEvent, childAt)) {
                onItemLongClickListener = this.ajy.ajp;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.ajy.ajp;
                    HorizontalListView horizontalListView = this.ajy;
                    i = this.ajy.ajf;
                    ListAdapter listAdapter = this.ajy.mAdapter;
                    i2 = this.ajy.ajf;
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
