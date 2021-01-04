package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class PendantParentView extends LinearLayout {
    private Model byd;
    private PendantPriorityView bye;
    private PendantPriorityView byf;
    private a byg;
    private a byh;
    private int leftBottom;
    private int leftTop;
    private int rightBottom;
    private int rightTop;

    /* loaded from: classes11.dex */
    public enum Model {
        VERTICAL,
        VERTICAL_PK,
        VERTICAL_BB_CHATING,
        HORIZONTAL,
        HORIZONTAL_FULL
    }

    /* loaded from: classes11.dex */
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
        this.bye = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK || model == Model.VERTICAL_BB_CHATING) {
            this.byf = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.byf = new PendantfixBottomView(getContext());
        } else {
            this.byf = new PendantPriorityView(getContext());
        }
        addView(this.bye, getChildLayoutParams());
        addView(this.byf, getChildLayoutParams());
        this.byg = new a(getContext(), Position.LEFT);
        this.byh = new a(getContext(), Position.RIGHT);
        this.bye.addView(this.byg, getDividerLayoutParams());
        this.byf.addView(this.byh, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.byd != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.byd = model;
            ArrayList<View> arrayList = new ArrayList(this.bye.getChildCount() + this.byf.getChildCount());
            for (int i = 0; i < this.bye.getChildCount(); i++) {
                arrayList.add(this.bye.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.byf.getChildCount(); i2++) {
                arrayList.add(this.byf.getChildAt(i2));
            }
            this.bye.removeAllViews();
            this.byf.removeAllViews();
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
        if (model == Model.VERTICAL || model == Model.VERTICAL_BB_CHATING) {
            this.byh.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.byh.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.byh.setPriority(105);
        }
        this.byg.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.byd);
            if (this.byd == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.byd == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.byd == Model.VERTICAL_BB_CHATING) {
                horizontalFullPosition = pendantChildView.getVerticalBBChattingPosition();
            } else if (this.byd == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (pendantChildView.getParent() != null) {
                ((ViewGroup) pendantChildView.getParent()).removeView(pendantChildView);
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bye.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.byf.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.bye.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bye.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bye.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bye.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.byf.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.byf.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.byf.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.byf.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends PendantChildView {
        private Position byi;

        public a(Context context, Position position) {
            super(context);
            this.byi = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.byi;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.byi;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalBBChattingPosition() {
            return this.byi;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.byi;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.byi;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bye.setDefaultItemMargin(i);
        this.byf.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.byf.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bye.indexOfChild(pendantChildView) != -1) {
                this.bye.removeView(pendantChildView);
                this.bye.addView(pendantChildView);
            }
            if (this.byf.indexOfChild(pendantChildView) != -1) {
                this.byf.removeView(pendantChildView);
                this.byf.addView(pendantChildView);
            }
        }
    }
}
