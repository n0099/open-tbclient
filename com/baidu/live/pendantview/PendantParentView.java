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
    private Model bba;
    private PendantPriorityView bbb;
    private PendantPriorityView bbc;
    private a bbd;
    private a bbe;
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
        this.bbb = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK) {
            this.bbc = new PendantPriorityBottomView(getContext());
        } else {
            this.bbc = new PendantPriorityView(getContext());
        }
        addView(this.bbb, getChildLayoutParams());
        addView(this.bbc, getChildLayoutParams());
        this.bbd = new a(getContext(), Position.LEFT);
        this.bbe = new a(getContext(), Position.RIGHT);
        this.bbb.addView(this.bbd, getDividerLayoutParams());
        this.bbc.addView(this.bbe, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.bba != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.bba = model;
            ArrayList<View> arrayList = new ArrayList(this.bbb.getChildCount() + this.bbc.getChildCount());
            for (int i = 0; i < this.bbb.getChildCount(); i++) {
                arrayList.add(this.bbb.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bbc.getChildCount(); i2++) {
                arrayList.add(this.bbc.getChildAt(i2));
            }
            this.bbb.removeAllViews();
            this.bbc.removeAllViews();
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
            this.bbe.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bbe.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bbe.setPriority(105);
        }
        this.bbd.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.bba);
            if (this.bba == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.bba == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.bba == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bbb.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bbc.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.bbb.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bbb.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bbb.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bbb.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bbc.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bbc.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bbc.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bbc.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends PendantChildView {
        private Position bbf;

        public a(Context context, Position position) {
            super(context);
            this.bbf = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bbf;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bbf;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bbf;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bbf;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bbb.setDefaultItemMargin(i);
        this.bbc.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bbc.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bbb.indexOfChild(pendantChildView) != -1) {
                this.bbb.removeView(pendantChildView);
                this.bbb.addView(pendantChildView);
            }
            if (this.bbc.indexOfChild(pendantChildView) != -1) {
                this.bbc.removeView(pendantChildView);
                this.bbc.addView(pendantChildView);
            }
        }
    }
}
