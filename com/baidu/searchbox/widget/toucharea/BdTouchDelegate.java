package com.baidu.searchbox.widget.toucharea;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class BdTouchDelegate extends TouchDelegate {
    private Map<View, ExpandBounds> mDelegateViewExpandMap;

    public BdTouchDelegate(View view, int i, int i2, int i3, int i4) {
        super(null, view);
        this.mDelegateViewExpandMap = new HashMap();
        addExpandChild(view, i, i2, i3, i4);
    }

    public void addExpandChild(View view, int i, int i2, int i3, int i4) {
        this.mDelegateViewExpandMap.put(view, new ExpandBounds(new Rect(), i, i2, i3, i4));
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        initArea();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
            View key = entry.getKey();
            if (key.getVisibility() == 0) {
                ExpandBounds value = entry.getValue();
                switch (motionEvent.getAction()) {
                    case 0:
                        if (value.bounds.contains(rawX, rawY)) {
                            value.isDelegateTarget = true;
                            z4 = true;
                            break;
                        } else {
                            value.isDelegateTarget = false;
                            z4 = false;
                            break;
                        }
                    case 1:
                    case 2:
                        z4 = value.isDelegateTarget;
                        if (z4 && !value.slopBounds.contains(rawX, rawY)) {
                            z3 = false;
                            break;
                        }
                        break;
                    case 3:
                        z4 = value.isDelegateTarget;
                        value.isDelegateTarget = false;
                        break;
                }
                if (z4) {
                    if (z3) {
                        motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                    } else {
                        int i = value.slop;
                        motionEvent.setLocation(-(i * 2), -(i * 2));
                    }
                    z = key.dispatchTouchEvent(motionEvent);
                } else {
                    z = z2;
                }
                if (z) {
                    return z;
                }
                z2 = z;
            }
        }
        return z2;
    }

    private void initArea() {
        for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
            View key = entry.getKey();
            ExpandBounds value = entry.getValue();
            key.getGlobalVisibleRect(value.bounds);
            value.bounds.left -= value.expandLeft;
            value.bounds.right += value.expandRight;
            value.bounds.top -= value.expandTop;
            value.bounds.bottom += value.expandBottom;
            value.slop = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
            value.slopBounds = new Rect(value.bounds);
            value.slopBounds.inset(-value.slop, -value.slop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class ExpandBounds {
        public Rect bounds;
        public int expandBottom;
        public int expandLeft;
        public int expandRight;
        public int expandTop;
        public boolean isDelegateTarget;
        public int slop;
        public Rect slopBounds;

        public ExpandBounds(Rect rect, int i, int i2, int i3, int i4) {
            this.expandLeft = i;
            this.bounds = rect;
            this.expandTop = i2;
            this.expandRight = i3;
            this.expandBottom = i4;
        }
    }
}
