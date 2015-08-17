package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class l extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView adW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HorizontalListView horizontalListView) {
        this.adW = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.adW.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.adW.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.adW) {
            this.adW.adI += (int) f;
        }
        this.adW.requestLayout();
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
            if (i6 < this.adW.getChildCount()) {
                View childAt = this.adW.getChildAt(i6);
                if (a(motionEvent, childAt)) {
                    onItemClickListener = this.adW.adO;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.adW.adO;
                        HorizontalListView horizontalListView = this.adW;
                        i3 = this.adW.adF;
                        ListAdapter listAdapter = this.adW.mAdapter;
                        i4 = this.adW.adF;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.adW.adN;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.adW.adN;
                        HorizontalListView horizontalListView2 = this.adW;
                        i = this.adW.adF;
                        ListAdapter listAdapter2 = this.adW.mAdapter;
                        i2 = this.adW.adF;
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
        int childCount = this.adW.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.adW.getChildAt(i3);
            if (a(motionEvent, childAt)) {
                onItemLongClickListener = this.adW.adP;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.adW.adP;
                    HorizontalListView horizontalListView = this.adW;
                    i = this.adW.adF;
                    ListAdapter listAdapter = this.adW.mAdapter;
                    i2 = this.adW.adF;
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
