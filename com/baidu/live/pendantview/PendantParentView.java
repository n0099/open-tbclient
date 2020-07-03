package com.baidu.live.pendantview;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PendantParentView extends LinearLayout {
    private Model bba;
    private int bbb;
    private int bbc;
    private int bbd;
    private int bbe;
    private PendantPriorityView bbf;
    private PendantPriorityView bbg;
    private a bbh;
    private a bbi;

    /* loaded from: classes3.dex */
    public enum Model {
        VERTICAL,
        VERTICAL_PK,
        HORIZONTAL,
        HORIZONTAL_FULL
    }

    /* loaded from: classes3.dex */
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
        this.bbf = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK) {
            this.bbg = new PendantPriorityBottomView(getContext());
        } else {
            this.bbg = new PendantPriorityView(getContext());
        }
        addView(this.bbf, getChildLayoutParams());
        addView(this.bbg, getChildLayoutParams());
        this.bbh = new a(getContext(), Position.LEFT);
        this.bbi = new a(getContext(), Position.RIGHT);
        this.bbf.addView(this.bbh, getDividerLayoutParams());
        this.bbg.addView(this.bbi, getDividerLayoutParams());
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
            ArrayList<View> arrayList = new ArrayList(this.bbf.getChildCount() + this.bbg.getChildCount());
            for (int i = 0; i < this.bbf.getChildCount(); i++) {
                arrayList.add(this.bbf.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bbg.getChildCount(); i2++) {
                arrayList.add(this.bbg.getChildAt(i2));
            }
            this.bbf.removeAllViews();
            this.bbg.removeAllViews();
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
            this.bbi.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bbi.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bbi.setPriority(105);
        }
        this.bbh.setPriority(105);
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
                this.bbf.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bbg.addView(pendantChildView, layoutParams);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        setLeftTop(i);
        setLeftBottom(i2);
        setRightTop(i3);
        setRightBottom(i4);
    }

    public void setLeftTop(int i) {
        this.bbb = i;
        ViewGroup.LayoutParams layoutParams = this.bbf.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bbf.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.bbc = i;
        ViewGroup.LayoutParams layoutParams = this.bbf.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bbf.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.bbd = i;
        ViewGroup.LayoutParams layoutParams = this.bbg.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bbg.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.bbe = i;
        ViewGroup.LayoutParams layoutParams = this.bbg.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bbg.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends PendantChildView {
        private Position bbj;

        public a(Context context, Position position) {
            super(context);
            this.bbj = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bbj;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bbj;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bbj;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bbj;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bbf.setDefaultItemMargin(i);
        this.bbg.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bbg.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bbf.indexOfChild(pendantChildView) != -1) {
                this.bbf.removeView(pendantChildView);
                this.bbf.addView(pendantChildView);
            }
            if (this.bbg.indexOfChild(pendantChildView) != -1) {
                this.bbg.removeView(pendantChildView);
                this.bbg.addView(pendantChildView);
            }
        }
    }
}
