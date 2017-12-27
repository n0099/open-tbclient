package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
public class LinearSnapHelper extends SnapHelper {
    private OrientationHelper Qi;
    private OrientationHelper Qj;

    @Override // android.support.v7.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, a(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // android.support.v7.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        PointF computeScrollVectorForPosition;
        int i3;
        int i4;
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (itemCount = layoutManager.getItemCount()) != 0 && (findSnapView = findSnapView(layoutManager)) != null && (position = layoutManager.getPosition(findSnapView)) != -1 && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) != null) {
            if (layoutManager.canScrollHorizontally()) {
                i3 = a(layoutManager, b(layoutManager), i, 0);
                if (computeScrollVectorForPosition.x < 0.0f) {
                    i3 = -i3;
                }
            } else {
                i3 = 0;
            }
            if (layoutManager.canScrollVertically()) {
                i4 = a(layoutManager, a(layoutManager), 0, i2);
                if (computeScrollVectorForPosition.y < 0.0f) {
                    i4 = -i4;
                }
            } else {
                i4 = 0;
            }
            if (!layoutManager.canScrollVertically()) {
                i4 = i3;
            }
            if (i4 == 0) {
                return -1;
            }
            int i5 = position + i4;
            if (i5 < 0) {
                i5 = 0;
            }
            if (i5 >= itemCount) {
                return itemCount - 1;
            }
            return i5;
        }
        return -1;
    }

    @Override // android.support.v7.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, a(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, b(layoutManager));
        }
        return null;
    }

    private int a(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        int end;
        int decoratedMeasurement = (orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view);
        if (layoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        return decoratedMeasurement - end;
    }

    private int a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        float b = b(layoutManager, orientationHelper);
        if (b <= 0.0f) {
            return 0;
        }
        int i3 = Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1];
        if (i3 > 0) {
            return (int) Math.floor(i3 / b);
        }
        return (int) Math.ceil(i3 / b);
    }

    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int end;
        View view;
        View view2 = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            if (layoutManager.getClipToPadding()) {
                end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                end = orientationHelper.getEnd() / 2;
            }
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = layoutManager.getChildAt(i2);
                int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - end);
                if (abs < i) {
                    view = childAt;
                } else {
                    abs = i;
                    view = view2;
                }
                i2++;
                view2 = view;
                i = abs;
            }
        }
        return view2;
    }

    private float b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i;
        View view;
        View view2;
        View view3 = null;
        int i2 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        int i3 = 0;
        View view4 = null;
        int i4 = Integer.MIN_VALUE;
        while (i3 < childCount) {
            View childAt = layoutManager.getChildAt(i3);
            int position = layoutManager.getPosition(childAt);
            if (position == -1) {
                i = i2;
                view = view3;
                view2 = view4;
            } else {
                if (position < i2) {
                    i2 = position;
                    view4 = childAt;
                }
                if (position > i4) {
                    i4 = position;
                    view2 = view4;
                    i = i2;
                    view = childAt;
                } else {
                    i = i2;
                    view = view3;
                    view2 = view4;
                }
            }
            i3++;
            view4 = view2;
            view3 = view;
            i2 = i;
        }
        if (view4 == null || view3 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.getDecoratedEnd(view4), orientationHelper.getDecoratedEnd(view3)) - Math.min(orientationHelper.getDecoratedStart(view4), orientationHelper.getDecoratedStart(view3));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i4 - i2) + 1);
    }

    private OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        if (this.Qi == null || this.Qi.mLayoutManager != layoutManager) {
            this.Qi = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.Qi;
    }

    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (this.Qj == null || this.Qj.mLayoutManager != layoutManager) {
            this.Qj = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.Qj;
    }
}
