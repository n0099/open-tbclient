package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class PendantParentView extends LinearLayout {
    private Model btq;
    private PendantPriorityView btr;
    private PendantPriorityView bts;
    private a btt;
    private a btu;
    private int leftBottom;
    private int leftTop;
    private int rightBottom;
    private int rightTop;

    /* loaded from: classes10.dex */
    public enum Model {
        VERTICAL,
        VERTICAL_PK,
        VERTICAL_BB_CHATING,
        HORIZONTAL,
        HORIZONTAL_FULL
    }

    /* loaded from: classes10.dex */
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
        this.btr = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK || model == Model.VERTICAL_BB_CHATING) {
            this.bts = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.bts = new PendantfixBottomView(getContext());
        } else {
            this.bts = new PendantPriorityView(getContext());
        }
        addView(this.btr, getChildLayoutParams());
        addView(this.bts, getChildLayoutParams());
        this.btt = new a(getContext(), Position.LEFT);
        this.btu = new a(getContext(), Position.RIGHT);
        this.btr.addView(this.btt, getDividerLayoutParams());
        this.bts.addView(this.btu, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.btq != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.btq = model;
            ArrayList<View> arrayList = new ArrayList(this.btr.getChildCount() + this.bts.getChildCount());
            for (int i = 0; i < this.btr.getChildCount(); i++) {
                arrayList.add(this.btr.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bts.getChildCount(); i2++) {
                arrayList.add(this.bts.getChildAt(i2));
            }
            this.btr.removeAllViews();
            this.bts.removeAllViews();
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
            this.btu.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.btu.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.btu.setPriority(105);
        }
        this.btt.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.btq);
            if (this.btq == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.btq == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.btq == Model.VERTICAL_BB_CHATING) {
                horizontalFullPosition = pendantChildView.getVerticalBBChattingPosition();
            } else if (this.btq == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (pendantChildView.getParent() != null) {
                ((ViewGroup) pendantChildView.getParent()).removeView(pendantChildView);
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.btr.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bts.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.btr.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.btr.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.btr.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.btr.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bts.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bts.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bts.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bts.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends PendantChildView {
        private Position btv;

        public a(Context context, Position position) {
            super(context);
            this.btv = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.btv;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.btv;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalBBChattingPosition() {
            return this.btv;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.btv;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.btv;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.btr.setDefaultItemMargin(i);
        this.bts.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bts.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.btr.indexOfChild(pendantChildView) != -1) {
                this.btr.removeView(pendantChildView);
                this.btr.addView(pendantChildView);
            }
            if (this.bts.indexOfChild(pendantChildView) != -1) {
                this.bts.removeView(pendantChildView);
                this.bts.addView(pendantChildView);
            }
        }
    }
}
