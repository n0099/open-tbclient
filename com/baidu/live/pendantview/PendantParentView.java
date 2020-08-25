package com.baidu.live.pendantview;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PendantParentView extends LinearLayout {
    private a bgA;
    private Model bgw;
    private PendantPriorityView bgx;
    private PendantPriorityView bgy;
    private a bgz;
    private int leftBottom;
    private int leftTop;
    private int rightBottom;
    private int rightTop;

    /* loaded from: classes7.dex */
    public enum Model {
        VERTICAL,
        VERTICAL_PK,
        HORIZONTAL,
        HORIZONTAL_FULL
    }

    /* loaded from: classes7.dex */
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
        this.bgx = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK) {
            this.bgy = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.bgy = new PendantfixBottomView(getContext());
        } else {
            this.bgy = new PendantPriorityView(getContext());
        }
        addView(this.bgx, getChildLayoutParams());
        addView(this.bgy, getChildLayoutParams());
        this.bgz = new a(getContext(), Position.LEFT);
        this.bgA = new a(getContext(), Position.RIGHT);
        this.bgx.addView(this.bgz, getDividerLayoutParams());
        this.bgy.addView(this.bgA, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.bgw != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.bgw = model;
            ArrayList<View> arrayList = new ArrayList(this.bgx.getChildCount() + this.bgy.getChildCount());
            for (int i = 0; i < this.bgx.getChildCount(); i++) {
                arrayList.add(this.bgx.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bgy.getChildCount(); i2++) {
                arrayList.add(this.bgy.getChildAt(i2));
            }
            this.bgx.removeAllViews();
            this.bgy.removeAllViews();
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
            this.bgA.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bgA.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bgA.setPriority(105);
        }
        this.bgz.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.bgw);
            if (this.bgw == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.bgw == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.bgw == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bgx.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bgy.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.bgx.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bgx.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bgx.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bgx.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bgy.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bgy.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bgy.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bgy.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends PendantChildView {
        private Position bgB;

        public a(Context context, Position position) {
            super(context);
            this.bgB = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bgB;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bgB;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bgB;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bgB;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bgx.setDefaultItemMargin(i);
        this.bgy.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bgy.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bgx.indexOfChild(pendantChildView) != -1) {
                this.bgx.removeView(pendantChildView);
                this.bgx.addView(pendantChildView);
            }
            if (this.bgy.indexOfChild(pendantChildView) != -1) {
                this.bgy.removeView(pendantChildView);
                this.bgy.addView(pendantChildView);
            }
        }
    }
}
