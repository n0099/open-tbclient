package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class j extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView HO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HorizontalListView horizontalListView) {
        this.HO = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.HO.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.HO.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.HO) {
            this.HO.HD += (int) f;
        }
        this.HO.requestLayout();
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
            if (i6 < this.HO.getChildCount()) {
                View childAt = this.HO.getChildAt(i6);
                if (b(motionEvent, childAt)) {
                    onItemClickListener = this.HO.HJ;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.HO.HJ;
                        HorizontalListView horizontalListView = this.HO;
                        i3 = this.HO.HA;
                        ListAdapter listAdapter = this.HO.mAdapter;
                        i4 = this.HO.HA;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.HO.HI;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.HO.HI;
                        HorizontalListView horizontalListView2 = this.HO;
                        i = this.HO.HA;
                        ListAdapter listAdapter2 = this.HO.mAdapter;
                        i2 = this.HO.HA;
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
        int childCount = this.HO.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.HO.getChildAt(i3);
            if (b(motionEvent, childAt)) {
                onItemLongClickListener = this.HO.HK;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.HO.HK;
                    HorizontalListView horizontalListView = this.HO;
                    i = this.HO.HA;
                    ListAdapter listAdapter = this.HO.mAdapter;
                    i2 = this.HO.HA;
                    onItemLongClickListener2.onItemLongClick(horizontalListView, childAt, i + 1 + i3, listAdapter.getItemId(i3 + i2 + 1));
                    return;
                }
                return;
            }
        }
    }

    private boolean b(MotionEvent motionEvent, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }
}
