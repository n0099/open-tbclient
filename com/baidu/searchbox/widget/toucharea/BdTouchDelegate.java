package com.baidu.searchbox.widget.toucharea;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class BdTouchDelegate extends TouchDelegate {
    public Map<View, ExpandBounds> mDelegateViewExpandMap;

    /* loaded from: classes4.dex */
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

    public BdTouchDelegate(View view2, int i, int i2, int i3, int i4) {
        super(null, view2);
        this.mDelegateViewExpandMap = new HashMap();
        addExpandChild(view2, i, i2, i3, i4);
    }

    public void addExpandChild(View view2, int i, int i2, int i3, int i4) {
        this.mDelegateViewExpandMap.put(view2, new ExpandBounds(new Rect(), i, i2, i3, i4));
    }

    private void initArea() {
        for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
            View key = entry.getKey();
            ExpandBounds value = entry.getValue();
            key.getGlobalVisibleRect(value.bounds);
            Rect rect = value.bounds;
            rect.left -= value.expandLeft;
            rect.right += value.expandRight;
            rect.top -= value.expandTop;
            rect.bottom += value.expandBottom;
            value.slop = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
            Rect rect2 = new Rect(value.bounds);
            value.slopBounds = rect2;
            int i = value.slop;
            rect2.inset(-i, -i);
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        initArea();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
            View key = entry.getKey();
            if (key.getVisibility() == 0 && key.getWidth() != 0 && key.getHeight() != 0) {
                ExpandBounds value = entry.getValue();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 && action != 2) {
                        if (action == 3) {
                            z2 = value.isDelegateTarget;
                            value.isDelegateTarget = false;
                        }
                    } else {
                        z2 = value.isDelegateTarget;
                        if (z2 && !value.slopBounds.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    }
                } else if (value.bounds.contains(rawX, rawY)) {
                    value.isDelegateTarget = true;
                    z2 = true;
                } else {
                    value.isDelegateTarget = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                    } else {
                        float f = -(value.slop * 2);
                        motionEvent.setLocation(f, f);
                    }
                    z = key.dispatchTouchEvent(motionEvent);
                }
                if (z) {
                    break;
                }
            }
        }
        return z;
    }
}
