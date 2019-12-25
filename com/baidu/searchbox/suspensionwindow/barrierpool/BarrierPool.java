package com.baidu.searchbox.suspensionwindow.barrierpool;

import android.graphics.Rect;
import android.view.View;
import com.baidu.searchbox.suspensionwindow.R;
import com.baidu.searchbox.suspensionwindow.util.DeviceUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class BarrierPool {
    private static final String TAG = "BarrierPool";
    private final ArrayList<View> mBarriers;
    private int mBottomPadding;
    private Barrier<View> mLeftAvailableBarriers;
    private int mLeftPadding;
    private Barrier<View> mRightAvailableBarriers;
    private int mRightPadding;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mSpacing;
    private int mStatusHeight;
    private View mTarget;
    private int mTopPadding;
    private Rect mValidRect;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface BarrierType {
        public static final int MOTIONLESS = 0;
        public static final int MOVABLE = 1;
        public static final int UNCERTAINTY = 2;
    }

    private BarrierPool() {
        this.mBarriers = new ArrayList<>();
    }

    /* loaded from: classes11.dex */
    static class InstanceHolder {
        static BarrierPool INSTANCE = new BarrierPool();

        InstanceHolder() {
        }
    }

    public static BarrierPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void setTarget(View view) {
        this.mTarget = view;
    }

    public boolean add(View view) {
        return add(0, view);
    }

    public boolean add(int i, View view) {
        return add(i, view, null);
    }

    public boolean add(int i, View view, Rect rect) {
        if (view != null) {
            view.setTag(R.id.tag_barrier_type, Integer.valueOf(i));
            if (rect != null) {
                view.setTag(R.id.tag_barrier_rect, rect);
            }
            view.setTag(R.id.tag_barrier_available_rect_top, null);
            view.setTag(R.id.tag_barrier_available_rect_bottom, null);
        }
        return (this.mBarriers == null || this.mBarriers.contains(view) || !this.mBarriers.add(view)) ? false : true;
    }

    public boolean remove(View view) {
        this.mLeftAvailableBarriers = dequeue(this.mLeftAvailableBarriers, view);
        this.mRightAvailableBarriers = dequeue(this.mRightAvailableBarriers, view);
        return this.mBarriers != null && this.mBarriers.contains(view) && this.mBarriers.remove(view);
    }

    public void clear() {
        this.mLeftAvailableBarriers = null;
        this.mRightAvailableBarriers = null;
        if (this.mBarriers != null) {
            this.mBarriers.clear();
        }
    }

    public ArrayList<View> getBarriers() {
        return this.mBarriers;
    }

    public void setScreenSize(int i, int i2, int i3) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        this.mStatusHeight = i3;
    }

    public void setSpacing(int i) {
        this.mSpacing = Math.max(i, 0);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mLeftPadding = Math.max(i, 0);
        this.mTopPadding = Math.max(i2, 0);
        this.mRightPadding = Math.max(i3, 0);
        this.mBottomPadding = Math.max(i4, 0);
    }

    private void computeBarriersRect() {
        if (this.mBarriers != null && !this.mBarriers.isEmpty()) {
            this.mLeftAvailableBarriers = null;
            this.mRightAvailableBarriers = null;
            Iterator<View> it = this.mBarriers.iterator();
            while (it.hasNext()) {
                View next = it.next();
                Integer num = (Integer) next.getTag(R.id.tag_barrier_type);
                if (num == null || num.intValue() != 0 || next.getTag(R.id.tag_barrier_rect) == null) {
                    int[] iArr = new int[2];
                    next.getLocationOnScreen(iArr);
                    Rect rect = new Rect(iArr[0], iArr[1] - this.mSpacing, next.getWidth() + iArr[0], iArr[1] + next.getHeight() + this.mSpacing);
                    if (Math.min(rect.left - this.mValidRect.left, this.mValidRect.right - rect.right) < this.mTarget.getWidth()) {
                        next.setTag(R.id.tag_barrier_rect, rect);
                        if (rect.centerX() < this.mScreenWidth / 2) {
                            this.mLeftAvailableBarriers = enqueue(this.mLeftAvailableBarriers, new Barrier<>(next));
                        } else if (rect.centerX() > this.mScreenWidth / 2) {
                            this.mRightAvailableBarriers = enqueue(this.mRightAvailableBarriers, new Barrier<>(next));
                        } else {
                            this.mLeftAvailableBarriers = enqueue(this.mLeftAvailableBarriers, new Barrier<>(next));
                            this.mRightAvailableBarriers = enqueue(this.mRightAvailableBarriers, new Barrier<>(next));
                        }
                    }
                }
            }
        }
    }

    private TargetInfo computeAvailableRects(TargetInfo targetInfo) {
        boolean z;
        int i;
        int i2;
        Barrier<View> barrier;
        if (targetInfo == null) {
            View view = this.mTarget;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + width, iArr[1] + height);
            int centerX = rect.centerX();
            int centerY = rect.centerY();
            boolean z2 = centerX < this.mScreenWidth / 2;
            targetInfo = new TargetInfo();
            targetInfo.rect = rect;
            targetInfo.width = width;
            targetInfo.height = height;
            targetInfo.ox = centerX;
            targetInfo.oy = centerY;
            targetInfo.isInLeftScreen = z2;
            z = z2;
            i = height;
            i2 = width;
        } else {
            int i3 = targetInfo.width;
            int i4 = targetInfo.height;
            z = targetInfo.isInLeftScreen;
            i = i4;
            i2 = i3;
        }
        Barrier<View> barrier2 = z ? this.mLeftAvailableBarriers : this.mRightAvailableBarriers;
        if (barrier2 != null) {
            barrier2.item.setTag(R.id.tag_barrier_available_rect_top, null);
            barrier2.item.setTag(R.id.tag_barrier_available_rect_bottom, null);
            Rect rect2 = (Rect) barrier2.item.getTag(R.id.tag_barrier_rect);
            if (rect2.top - this.mValidRect.top >= i) {
                Rect rect3 = new Rect();
                rect3.left = z ? this.mValidRect.left : this.mValidRect.right - i2;
                rect3.top = this.mValidRect.top;
                rect3.right = rect3.left + i2;
                rect3.bottom = rect2.top;
                barrier2.item.setTag(R.id.tag_barrier_available_rect_top, rect3);
                targetInfo.hasAvailableRect = true;
            }
            barrier = barrier2;
        } else {
            targetInfo.hasAvailableRect = true;
            barrier = barrier2;
        }
        while (barrier != null) {
            Rect rect4 = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
            Barrier<View> barrier3 = barrier.next;
            if (barrier3 != null) {
                barrier3.item.setTag(R.id.tag_barrier_available_rect_top, null);
                barrier3.item.setTag(R.id.tag_barrier_available_rect_bottom, null);
                Rect rect5 = (Rect) barrier3.item.getTag(R.id.tag_barrier_rect);
                int i5 = rect5.top - rect4.bottom;
                if (i5 > 0) {
                    if (i5 >= i) {
                        Rect rect6 = new Rect();
                        rect6.left = z ? this.mValidRect.left : this.mValidRect.right - i2;
                        rect6.top = rect4.bottom;
                        rect6.right = rect6.left + i2;
                        rect6.bottom = rect5.top;
                        barrier.item.setTag(R.id.tag_barrier_available_rect_bottom, rect6);
                        barrier3.item.setTag(R.id.tag_barrier_available_rect_top, rect6);
                        targetInfo.hasAvailableRect = true;
                    }
                } else if (i5 < 0) {
                }
            } else if (this.mValidRect.bottom - rect4.bottom >= i) {
                Rect rect7 = new Rect();
                rect7.left = z ? this.mValidRect.left : this.mValidRect.right - i2;
                rect7.top = rect4.bottom;
                rect7.right = rect7.left + i2;
                rect7.bottom = this.mValidRect.bottom;
                barrier.item.setTag(R.id.tag_barrier_available_rect_bottom, rect7);
                targetInfo.hasAvailableRect = true;
            }
            barrier = barrier.next;
        }
        return targetInfo;
    }

    private Rect computeDestinationRect(TargetInfo targetInfo) {
        int i;
        Rect rect = null;
        Rect rect2 = targetInfo.rect;
        int i2 = targetInfo.width;
        int i3 = targetInfo.height;
        int i4 = targetInfo.ox;
        int i5 = targetInfo.oy;
        boolean z = targetInfo.isInLeftScreen;
        Barrier<View> barrier = z ? this.mLeftAvailableBarriers : this.mRightAvailableBarriers;
        while (barrier != null) {
            Rect rect3 = (Rect) barrier.item.getTag(R.id.tag_barrier_available_rect_top);
            if (rect3 != null) {
                rect = rect3;
            }
            Rect rect4 = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
            rect4.centerX();
            int centerY = rect4.centerY();
            rect4.width();
            if (Math.abs(i5 - centerY) < (rect4.height() / 2) + (i3 / 2)) {
                if ((i5 <= centerY) && rect != null) {
                    while (true) {
                        if (barrier == null) {
                            break;
                        }
                        Rect rect5 = (Rect) barrier.item.getTag(R.id.tag_barrier_available_rect_bottom);
                        if (rect5 != null) {
                            if (Math.abs(rect5.top - i5) < Math.abs(rect.bottom - i5)) {
                                return rect5;
                            }
                        } else {
                            barrier = barrier.next;
                        }
                    }
                    rect.top = rect.bottom - i3;
                    return rect;
                }
                while (barrier != null) {
                    Rect rect6 = (Rect) barrier.item.getTag(R.id.tag_barrier_available_rect_bottom);
                    if (rect6 != null) {
                        if (rect == null || Math.abs(rect.bottom - i5) >= Math.abs(rect6.top - i5)) {
                            return rect6;
                        }
                        rect.top = rect.bottom - i3;
                        return rect;
                    }
                    barrier = barrier.next;
                }
                if (rect != null) {
                    rect.top = rect.bottom - i3;
                    return rect;
                }
                return rect2;
            }
            barrier = barrier.next;
        }
        boolean z2 = rect2.top < this.mValidRect.top || rect2.bottom > this.mValidRect.bottom;
        rect2.left = z ? this.mValidRect.left : this.mValidRect.right - i2;
        if (rect2.top < this.mValidRect.top) {
            i = this.mValidRect.top;
        } else {
            i = rect2.bottom > this.mValidRect.bottom ? this.mValidRect.bottom - i3 : rect2.top;
        }
        rect2.top = i;
        rect2.right = rect2.left + i2;
        rect2.bottom = rect2.top + i3;
        if (z2) {
            targetInfo.rect = rect2;
            targetInfo.ox = rect2.centerX();
            targetInfo.oy = rect2.centerY();
            targetInfo.isInLeftScreen = i4 < this.mScreenWidth / 2;
            return computeDestinationRect(targetInfo);
        }
        return rect2;
    }

    public Rect getDestinationRect(View view) {
        TargetInfo targetInfo;
        if (view == null) {
            return null;
        }
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = DeviceUtil.getScreenWidth(view.getContext().getApplicationContext());
        }
        if (this.mScreenHeight == 0) {
            this.mScreenHeight = DeviceUtil.getScreenHeight(view.getContext().getApplicationContext());
        }
        if (this.mStatusHeight == 0) {
            this.mStatusHeight = DeviceUtil.getStatusBarHeight(view.getContext().getApplicationContext());
        }
        if (this.mValidRect == null) {
            this.mValidRect = new Rect();
        }
        this.mValidRect.left = this.mLeftPadding;
        this.mValidRect.top = this.mTopPadding;
        this.mValidRect.right = this.mScreenWidth - this.mRightPadding;
        this.mValidRect.bottom = this.mScreenHeight - this.mBottomPadding;
        setTarget(view);
        remove(view);
        computeBarriersRect();
        TargetInfo computeAvailableRects = computeAvailableRects(null);
        if (computeAvailableRects.hasAvailableRect) {
            targetInfo = computeAvailableRects;
        } else {
            computeAvailableRects.isInLeftScreen = !computeAvailableRects.isInLeftScreen;
            targetInfo = computeAvailableRects(computeAvailableRects);
        }
        Rect computeDestinationRect = computeDestinationRect(targetInfo);
        if (computeDestinationRect != null) {
            computeDestinationRect.top -= this.mStatusHeight;
            computeDestinationRect.bottom -= this.mStatusHeight;
        }
        Integer num = (Integer) view.getTag(R.id.tag_barrier_type);
        add(num != null ? num.intValue() : 0, view);
        return computeDestinationRect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class TargetInfo {
        boolean hasAvailableRect;
        int height;
        boolean isInLeftScreen;
        int ox;
        int oy;
        Rect rect;
        int width;

        TargetInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class Barrier<V extends View> {
        V item;
        Barrier<V> next;

        Barrier(V v) {
            this.item = v;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean equals(Object obj) {
            return this.item == obj;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool$Barrier<android.view.View> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool$Barrier<android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    private Barrier<View> enqueue(Barrier<View> barrier, Barrier<View> barrier2) {
        Barrier barrier3;
        if (barrier == 0 || valueOf(barrier2) < valueOf(barrier)) {
            barrier2.next = barrier;
            return barrier2;
        }
        Barrier barrier4 = barrier;
        while (true) {
            barrier3 = barrier4.next;
            if (barrier3 == null || valueOf(barrier2) < valueOf(barrier3)) {
                break;
            }
            barrier4 = barrier3;
        }
        barrier4.next = barrier2;
        barrier2.next = barrier3;
        return barrier;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool$Barrier<android.view.View>, com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool$Barrier<V extends android.view.View> */
    private Barrier<View> dequeue(Barrier<View> barrier, View view) {
        Barrier<View> barrier2 = null;
        Barrier<View> barrier3 = barrier;
        while (barrier3 != null) {
            if (barrier3.equals(view)) {
                if (barrier2 == null) {
                    return null;
                }
                barrier2.next = barrier3.next;
                return barrier;
            }
            Barrier<View> barrier4 = barrier3;
            barrier3 = barrier3.next;
            barrier2 = barrier4;
        }
        return barrier;
    }

    private int valueOf(Barrier<View> barrier) {
        Rect rect = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
        return rect.bottom + rect.top;
    }
}
