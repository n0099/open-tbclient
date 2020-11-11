package com.baidu.live.pendantview;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PendantParentView extends LinearLayout {
    private Model bpT;
    private PendantPriorityView bpU;
    private PendantPriorityView bpV;
    private a bpW;
    private a bpX;
    private int leftBottom;
    private int leftTop;
    private int rightBottom;
    private int rightTop;

    /* loaded from: classes4.dex */
    public enum Model {
        VERTICAL,
        VERTICAL_PK,
        HORIZONTAL,
        HORIZONTAL_FULL
    }

    /* loaded from: classes4.dex */
    public enum Position {
        LEFT,
        RIGHT
    }

    public PendantParentView(Context context, Model model) {
        super(context);
        a(model);
    }

    public PendantParentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendantParentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(Model.VERTICAL);
    }

    private void a(Model model) {
        setOrientation(0);
        this.bpU = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK) {
            this.bpV = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.bpV = new PendantfixBottomView(getContext());
        } else {
            this.bpV = new PendantPriorityView(getContext());
        }
        addView(this.bpU, getChildLayoutParams());
        addView(this.bpV, getChildLayoutParams());
        this.bpW = new a(getContext(), Position.LEFT);
        this.bpX = new a(getContext(), Position.RIGHT);
        this.bpU.addView(this.bpW, getDividerLayoutParams());
        this.bpV.addView(this.bpX, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.bpT != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.bpT = model;
            ArrayList<View> arrayList = new ArrayList(this.bpU.getChildCount() + this.bpV.getChildCount());
            for (int i = 0; i < this.bpU.getChildCount(); i++) {
                arrayList.add(this.bpU.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bpV.getChildCount(); i2++) {
                arrayList.add(this.bpV.getChildAt(i2));
            }
            this.bpU.removeAllViews();
            this.bpV.removeAllViews();
            setDividerModel(model);
            for (View view : arrayList) {
                if (view instanceof PendantChildView) {
                    ((PendantChildView) view).setMode(model);
                    a((PendantChildView) view, (LinearLayout.LayoutParams) view.getLayoutParams());
                }
            }
        }
    }

    private void setDividerModel(Model model) {
        if (model == Model.VERTICAL) {
            this.bpX.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bpX.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bpX.setPriority(105);
        }
        this.bpW.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.bpT);
            if (this.bpT == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.bpT == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.bpT == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (pendantChildView.getParent() != null) {
                ((ViewGroup) pendantChildView.getParent()).removeView(pendantChildView);
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bpU.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bpV.addView(pendantChildView, layoutParams);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        setLeftTop(i);
        setLeftBottom(i2);
        setRightTop(i3);
        setRightBottom(i4);
    }

    public void setLeftTop(int i) {
        this.leftTop = i;
        ViewGroup.LayoutParams layoutParams = this.bpU.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bpU.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bpU.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bpU.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bpV.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bpV.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bpV.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bpV.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends PendantChildView {
        private Position bpY;

        public a(Context context, Position position) {
            super(context);
            this.bpY = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bpY;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bpY;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bpY;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bpY;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bpU.setDefaultItemMargin(i);
        this.bpV.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bpV.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bpU.indexOfChild(pendantChildView) != -1) {
                this.bpU.removeView(pendantChildView);
                this.bpU.addView(pendantChildView);
            }
            if (this.bpV.indexOfChild(pendantChildView) != -1) {
                this.bpV.removeView(pendantChildView);
                this.bpV.addView(pendantChildView);
            }
        }
    }
}
