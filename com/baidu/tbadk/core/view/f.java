package com.baidu.tbadk.core.view;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class f extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalListView horizontalListView) {
        this.aeH = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.aeH.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.aeH.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.aeH) {
            this.aeH.aer += (int) f;
        }
        this.aeH.requestLayout();
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
            if (i6 < this.aeH.getChildCount()) {
                View childAt = this.aeH.getChildAt(i6);
                if (a(motionEvent, childAt)) {
                    onItemClickListener = this.aeH.aex;
                    if (onItemClickListener != null) {
                        onItemClickListener2 = this.aeH.aex;
                        HorizontalListView horizontalListView = this.aeH;
                        i3 = this.aeH.aeo;
                        ListAdapter listAdapter = this.aeH.mAdapter;
                        i4 = this.aeH.aeo;
                        onItemClickListener2.onItemClick(horizontalListView, childAt, i3 + 1 + i6, listAdapter.getItemId(i4 + 1 + i6));
                    }
                    onItemSelectedListener = this.aeH.aew;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = this.aeH.aew;
                        HorizontalListView horizontalListView2 = this.aeH;
                        i = this.aeH.aeo;
                        ListAdapter listAdapter2 = this.aeH.mAdapter;
                        i2 = this.aeH.aeo;
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
        int childCount = this.aeH.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.aeH.getChildAt(i3);
            if (a(motionEvent, childAt)) {
                onItemLongClickListener = this.aeH.aey;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener2 = this.aeH.aey;
                    HorizontalListView horizontalListView = this.aeH;
                    i = this.aeH.aeo;
                    ListAdapter listAdapter = this.aeH.mAdapter;
                    i2 = this.aeH.aeo;
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
