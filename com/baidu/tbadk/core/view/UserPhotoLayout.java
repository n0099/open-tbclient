package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import java.util.List;
/* loaded from: classes.dex */
public class UserPhotoLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private boolean mAutoChangeStyle;
    private aw mChildClickListener;
    private int mChildCount;
    private Context mContext;
    private List<MetaData> mDatas;
    private int mItemSize;
    private int mNormalShowCount;
    private int mPadding;
    private ax mTbRecyclerListener;
    private com.baidu.adp.lib.e.b<HeadImageView> mUserPhotoPool;

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public int getNormalShowCount() {
        return this.mNormalShowCount;
    }

    public void setNormalShowCount(int i) {
        this.mNormalShowCount = i;
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public void setItemSize(int i) {
        this.mItemSize = i;
    }

    public UserPhotoLayout(Context context) {
        this(context, null);
    }

    public UserPhotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUserPhotoPool = null;
        this.mTbRecyclerListener = null;
        this.mItemSize = 0;
        this.mPadding = 5;
        this.mAutoChangeStyle = true;
        this.mNormalShowCount = 6;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
        if (this.mContext instanceof ay) {
            ay ayVar = (ay) this.mContext;
            this.mUserPhotoPool = ayVar.qS();
            if (ayVar.getListView() != null && this.mTbRecyclerListener == null) {
                this.mTbRecyclerListener = new ax(ayVar.qR());
                ayVar.getListView().setRecyclerListener(this.mTbRecyclerListener);
            }
        }
        setOnHierarchyChangeListener(new at(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new av(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new av(this, getChildCount() - 1, null));
    }

    public void setData(List<MetaData> list, boolean z) {
        reset();
        this.mDatas = list;
        if (this.mDatas == null) {
            requestLayout();
            invalidate();
            return;
        }
        this.mChildCount = this.mDatas.size();
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        for (int i = 0; i < this.mChildCount; i++) {
            HeadImageView imageView = getImageView(this.mContext);
            imageView.setAutoChangeStyle(this.mAutoChangeStyle);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView);
            imageView.d(this.mDatas.get(i).getPortrait(), 12, false);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.mChildCount == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension((this.mChildCount * this.mItemSize) + ((this.mChildCount - 1) * this.mPadding), this.mItemSize);
        while (true) {
            int i4 = i3;
            if (i4 < this.mChildCount) {
                measureChild((HeadImageView) getChildAt(i4), this.mItemSize, this.mItemSize);
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mChildCount != 0) {
            for (int i5 = 0; i5 < this.mChildCount; i5++) {
                ((HeadImageView) getChildAt(i5)).layout((this.mPadding * i5) + (this.mItemSize * i5), 0, (this.mPadding * i5) + (this.mItemSize * (i5 + 1)), this.mItemSize);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.mChildCount = getChildCount();
            if (this.mChildCount != 0) {
                long drawingTime = getDrawingTime();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mChildCount) {
                        drawChild(canvas, (HeadImageView) getChildAt(i2), drawingTime);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setOnChildClickListener(aw awVar) {
        this.mChildClickListener = awVar;
    }

    public void reset() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null && (view instanceof UserPhotoLayout)) {
            reset();
        }
    }

    public static com.baidu.adp.lib.e.b<HeadImageView> createUserPhotoPool(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new au(context), i, 0);
    }

    private HeadImageView getImageView(Context context) {
        HeadImageView headImageView = null;
        if (this.mUserPhotoPool != null) {
            headImageView = this.mUserPhotoPool.ea();
        }
        if (headImageView == null || headImageView.getParent() != null) {
            return new HeadImageView(context);
        }
        return headImageView;
    }
}
