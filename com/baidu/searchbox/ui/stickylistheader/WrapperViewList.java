package com.baidu.searchbox.ui.stickylistheader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class WrapperViewList extends ListView {
    public boolean mBlockLayoutChildren;
    public boolean mClippingToPadding;
    public List<View> mFooterViews;
    public LifeCycleListener mLifeCycleListener;
    public Field mSelectorPositionField;
    public Rect mSelectorRect;
    public int mTopClippingLength;

    /* loaded from: classes4.dex */
    public interface LifeCycleListener {
        void onDispatchDrawOccurred(Canvas canvas);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public WrapperViewList(Context context) {
        super(context);
        this.mSelectorRect = new Rect();
        this.mClippingToPadding = true;
        this.mBlockLayoutChildren = false;
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mSelectorRect");
            declaredField.setAccessible(true);
            this.mSelectorRect = (Rect) declaredField.get(this);
            if (Build.VERSION.SDK_INT >= 14) {
                Field declaredField2 = AbsListView.class.getDeclaredField("mSelectorPosition");
                this.mSelectorPositionField = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private void addInternalFooterView(View view2) {
        if (this.mFooterViews == null) {
            this.mFooterViews = new ArrayList();
        }
        this.mFooterViews.add(view2);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view2) {
        super.addFooterView(view2);
        addInternalFooterView(view2);
    }

    public boolean containsFooterView(View view2) {
        List<View> list = this.mFooterViews;
        if (list == null) {
            return false;
        }
        return list.contains(view2);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        positionSelectorRect();
        if (this.mTopClippingLength != 0) {
            canvas.save();
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.top = this.mTopClippingLength;
            canvas.clipRect(clipBounds);
            super.dispatchDraw(canvas);
            canvas.restore();
        } else {
            super.dispatchDraw(canvas);
        }
        this.mLifeCycleListener.onDispatchDrawOccurred(canvas);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view2) {
        if (super.removeFooterView(view2)) {
            this.mFooterViews.remove(view2);
            return true;
        }
        return false;
    }

    public void setBlockLayoutChildren(boolean z) {
        this.mBlockLayoutChildren = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        this.mClippingToPadding = z;
        super.setClipToPadding(z);
    }

    public void setLifeCycleListener(LifeCycleListener lifeCycleListener) {
        this.mLifeCycleListener = lifeCycleListener;
    }

    public void setTopClippingLength(int i) {
        this.mTopClippingLength = i;
    }

    private int getSelectorPosition() {
        Field field = this.mSelectorPositionField;
        if (field == null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i).getBottom() == this.mSelectorRect.bottom) {
                    return i + getFixedFirstVisibleItem();
                }
            }
            return -1;
        }
        try {
            return field.getInt(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void positionSelectorRect() {
        int selectorPosition;
        if (!this.mSelectorRect.isEmpty() && (selectorPosition = getSelectorPosition()) >= 0) {
            View childAt = getChildAt(selectorPosition - getFixedFirstVisibleItem());
            if (childAt instanceof WrapperView) {
                WrapperView wrapperView = (WrapperView) childAt;
                this.mSelectorRect.top = wrapperView.getTop() + wrapperView.mItemTop;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (!this.mBlockLayoutChildren) {
            super.layoutChildren();
        }
    }

    @Override // android.widget.ListView
    public void addFooterView(View view2, Object obj, boolean z) {
        super.addFooterView(view2, obj, z);
        addInternalFooterView(view2);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view2, int i, long j) {
        if (view2 instanceof WrapperView) {
            view2 = ((WrapperView) view2).mItem;
        }
        return super.performItemClick(view2, i, j);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public int getFixedFirstVisibleItem() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (Build.VERSION.SDK_INT >= 11) {
            return firstVisiblePosition;
        }
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            } else if (getChildAt(i).getBottom() >= 0) {
                firstVisiblePosition += i;
                break;
            } else {
                i++;
            }
        }
        if (!this.mClippingToPadding && getPaddingTop() > 0 && firstVisiblePosition > 0 && getChildAt(0).getTop() > 0) {
            return firstVisiblePosition - 1;
        }
        return firstVisiblePosition;
    }
}
