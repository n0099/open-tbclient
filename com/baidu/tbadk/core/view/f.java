package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class f extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView abR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalListView horizontalListView) {
        this.abR = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.abR.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.abR.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.abR) {
            this.abR.abB += (int) f;
        }
        this.abR.requestLayout();
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
            if (i6 < this.abR.getChildCount()) {
                View childAt = this.abR.getChildAt(i6);
                if (a(motionEvent, childAt)) {
                    onItemClickListener = this.abR.abH;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.abR.abH;
                        HorizontalListView horizontalListView = this.abR;
                        i3 = this.abR.aby;
                        ListAdapter listAdapter = this.abR.mAdapter;
                        i4 = this.abR.aby;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.abR.abG;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.abR.abG;
                        HorizontalListView horizontalListView2 = this.abR;
                        i = this.abR.aby;
                        ListAdapter listAdapter2 = this.abR.mAdapter;
                        i2 = this.abR.aby;
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
        int childCount = this.abR.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.abR.getChildAt(i3);
            if (a(motionEvent, childAt)) {
                onItemLongClickListener = this.abR.abI;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.abR.abI;
                    HorizontalListView horizontalListView = this.abR;
                    i = this.abR.aby;
                    ListAdapter listAdapter = this.abR.mAdapter;
                    i2 = this.abR.aby;
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
