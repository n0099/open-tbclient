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
    private Model bjp;
    private PendantPriorityView bjq;
    private PendantPriorityView bjr;
    private a bjs;
    private a bjt;
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
        this.bjq = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK) {
            this.bjr = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.bjr = new PendantfixBottomView(getContext());
        } else {
            this.bjr = new PendantPriorityView(getContext());
        }
        addView(this.bjq, getChildLayoutParams());
        addView(this.bjr, getChildLayoutParams());
        this.bjs = new a(getContext(), Position.LEFT);
        this.bjt = new a(getContext(), Position.RIGHT);
        this.bjq.addView(this.bjs, getDividerLayoutParams());
        this.bjr.addView(this.bjt, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setModel(Model model) {
        if (this.bjp != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.bjp = model;
            ArrayList<View> arrayList = new ArrayList(this.bjq.getChildCount() + this.bjr.getChildCount());
            for (int i = 0; i < this.bjq.getChildCount(); i++) {
                arrayList.add(this.bjq.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bjr.getChildCount(); i2++) {
                arrayList.add(this.bjr.getChildAt(i2));
            }
            this.bjq.removeAllViews();
            this.bjr.removeAllViews();
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
            this.bjt.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bjt.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bjt.setPriority(105);
        }
        this.bjs.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.bjp);
            if (this.bjp == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.bjp == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.bjp == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bjq.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bjr.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.bjq.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bjq.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bjq.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bjq.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bjr.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bjr.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bjr.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bjr.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends PendantChildView {
        private Position bju;

        public a(Context context, Position position) {
            super(context);
            this.bju = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bju;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bju;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bju;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bju;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bjq.setDefaultItemMargin(i);
        this.bjr.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bjr.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bjq.indexOfChild(pendantChildView) != -1) {
                this.bjq.removeView(pendantChildView);
                this.bjq.addView(pendantChildView);
            }
            if (this.bjr.indexOfChild(pendantChildView) != -1) {
                this.bjr.removeView(pendantChildView);
                this.bjr.addView(pendantChildView);
            }
        }
    }
}
