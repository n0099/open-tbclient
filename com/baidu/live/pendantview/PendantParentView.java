package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class PendantParentView extends LinearLayout {
    private Model byt;
    private PendantPriorityView byu;
    private PendantPriorityView byv;
    private a byw;
    private a byx;
    private List<PendantChildView> byy;
    private boolean byz;
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
        this.byz = false;
        a(model);
    }

    public PendantParentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendantParentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byz = false;
        a(Model.VERTICAL);
    }

    private void a(Model model) {
        this.byy = new ArrayList();
        setOrientation(0);
        this.byu = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK || model == Model.VERTICAL_BB_CHATING) {
            this.byv = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.byv = new PendantfixBottomView(getContext());
        } else {
            this.byv = new PendantPriorityView(getContext());
        }
        addView(this.byu, getChildLayoutParams());
        addView(this.byv, getChildLayoutParams());
        this.byw = new a(getContext(), Position.LEFT);
        this.byx = new a(getContext(), Position.RIGHT);
        this.byu.addView(this.byw, getDividerLayoutParams());
        this.byv.addView(this.byx, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setIsAudioRoom(boolean z) {
        this.byz = z;
    }

    public void setModel(Model model) {
        if (this.byt != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.byt = model;
            ArrayList<View> arrayList = new ArrayList(this.byu.getChildCount() + this.byv.getChildCount());
            for (int i = 0; i < this.byu.getChildCount(); i++) {
                arrayList.add(this.byu.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.byv.getChildCount(); i2++) {
                arrayList.add(this.byv.getChildAt(i2));
            }
            if (!ListUtils.isEmpty(this.byy)) {
                for (int i3 = 0; i3 < this.byy.size(); i3++) {
                    arrayList.add(this.byy.get(i3));
                }
            }
            this.byu.removeAllViews();
            this.byv.removeAllViews();
            setDividerModel(model);
            for (View view : arrayList) {
                if (view instanceof PendantChildView) {
                    ((PendantChildView) view).setMode(model);
                    a((PendantChildView) view, (LinearLayout.LayoutParams) view.getLayoutParams());
                }
            }
            if (this.byy != null) {
                this.byy.clear();
            }
            Pf();
        }
    }

    private void setDividerModel(Model model) {
        if (model == Model.VERTICAL || model == Model.VERTICAL_BB_CHATING) {
            this.byx.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.byx.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.byx.setPriority(105);
        }
        this.byw.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.byt);
            if (this.byt == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.byt == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.byt == Model.VERTICAL_BB_CHATING) {
                horizontalFullPosition = pendantChildView.getVerticalBBChattingPosition();
            } else if (this.byt == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (pendantChildView.getParent() != null) {
                ((ViewGroup) pendantChildView.getParent()).removeView(pendantChildView);
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.byu.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.byv.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.byu.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.byu.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.byu.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.byu.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.byv.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.byv.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.byv.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.byv.setLayoutParams(layoutParams);
    }

    public void Pf() {
        if (this.byz) {
            if (Ph() && this.byv != null) {
                if (getRightChildCount() > 2) {
                    this.byy.clear();
                    boolean z = false;
                    for (int i = 0; i < this.byv.getChildCount(); i++) {
                        if (this.byy != null) {
                            View childAt = this.byv.getChildAt(i);
                            if (childAt instanceof PendantChildView) {
                                PendantChildView pendantChildView = (PendantChildView) childAt;
                                if (pendantChildView.getPriority() != 100 && pendantChildView.getPriority() != 10 && pendantChildView.getPriority() > 0) {
                                    this.byy.add(pendantChildView);
                                } else if (pendantChildView.getPriority() == 10 && pendantChildView.getChildCount() > 0) {
                                    z = true;
                                }
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.byy)) {
                        int i2 = z ? 1 : 2;
                        if (this.byy.size() > i2) {
                            for (int i3 = 0; i3 < i2; i3++) {
                                this.byy.remove(0);
                            }
                            for (PendantChildView pendantChildView2 : this.byy) {
                                this.byv.removeView(pendantChildView2);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                Pg();
                return;
            }
            Pg();
        }
    }

    private void Pg() {
        if (!ListUtils.isEmpty(this.byy) && this.byv != null) {
            for (PendantChildView pendantChildView : this.byy) {
                if (this.byv.indexOfChild(pendantChildView) < 0) {
                    this.byv.addView(pendantChildView, 0, pendantChildView.getLayoutParams());
                }
            }
            this.byy.clear();
        }
    }

    private boolean Ph() {
        if (this.byv != null) {
            for (int i = 0; i < this.byv.getChildCount(); i++) {
                View childAt = this.byv.getChildAt(i);
                if ((childAt instanceof PendantChildView) && ((PendantChildView) childAt).getPriority() == 100) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int getRightChildCount() {
        if (this.byv != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.byv.getChildCount(); i2++) {
                View childAt = this.byv.getChildAt(i2);
                if (childAt instanceof PendantChildView) {
                    PendantChildView pendantChildView = (PendantChildView) childAt;
                    if (pendantChildView.getPriority() == 10 && pendantChildView.getChildCount() > 0) {
                        i++;
                    } else if (pendantChildView.getPriority() != 100 && pendantChildView.getPriority() > 0) {
                        i++;
                    }
                }
            }
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends PendantChildView {
        private Position byA;

        public a(Context context, Position position) {
            super(context);
            this.byA = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.byA;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.byA;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalBBChattingPosition() {
            return this.byA;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.byA;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.byA;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.byu.setDefaultItemMargin(i);
        this.byv.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.byv.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.byu.indexOfChild(pendantChildView) != -1) {
                this.byu.removeView(pendantChildView);
                this.byu.addView(pendantChildView);
            }
            if (this.byv.indexOfChild(pendantChildView) != -1) {
                this.byv.removeView(pendantChildView);
                this.byv.addView(pendantChildView);
            }
        }
    }
}
