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
/* loaded from: classes11.dex */
public class PendantParentView extends LinearLayout {
    private Model bwT;
    private PendantPriorityView bwU;
    private PendantPriorityView bwV;
    private a bwW;
    private a bwX;
    private List<PendantChildView> bwY;
    private boolean bwZ;
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
        this.bwZ = false;
        a(model);
    }

    public PendantParentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendantParentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwZ = false;
        a(Model.VERTICAL);
    }

    private void a(Model model) {
        this.bwY = new ArrayList();
        setOrientation(0);
        this.bwU = new PendantPriorityView(getContext());
        if (model == Model.VERTICAL || model == Model.VERTICAL_PK || model == Model.VERTICAL_BB_CHATING) {
            this.bwV = new PendantPriorityBottomView(getContext());
        } else if (model == Model.HORIZONTAL) {
            this.bwV = new PendantfixBottomView(getContext());
        } else {
            this.bwV = new PendantPriorityView(getContext());
        }
        addView(this.bwU, getChildLayoutParams());
        addView(this.bwV, getChildLayoutParams());
        this.bwW = new a(getContext(), Position.LEFT);
        this.bwX = new a(getContext(), Position.RIGHT);
        this.bwU.addView(this.bwW, getDividerLayoutParams());
        this.bwV.addView(this.bwX, getDividerLayoutParams());
        setModel(model);
    }

    private LinearLayout.LayoutParams getChildLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void setIsAudioRoom(boolean z) {
        this.bwZ = z;
    }

    public void setModel(Model model) {
        if (this.bwT != model) {
            Log.i("setModel", model.toString() + "   ---------");
            this.bwT = model;
            ArrayList<View> arrayList = new ArrayList(this.bwU.getChildCount() + this.bwV.getChildCount());
            for (int i = 0; i < this.bwU.getChildCount(); i++) {
                arrayList.add(this.bwU.getChildAt(i));
            }
            for (int i2 = 0; i2 < this.bwV.getChildCount(); i2++) {
                arrayList.add(this.bwV.getChildAt(i2));
            }
            if (!ListUtils.isEmpty(this.bwY)) {
                for (int i3 = 0; i3 < this.bwY.size(); i3++) {
                    arrayList.add(this.bwY.get(i3));
                }
            }
            this.bwU.removeAllViews();
            this.bwV.removeAllViews();
            setDividerModel(model);
            for (View view : arrayList) {
                if (view instanceof PendantChildView) {
                    ((PendantChildView) view).setMode(model);
                    a((PendantChildView) view, (LinearLayout.LayoutParams) view.getLayoutParams());
                }
            }
            if (this.bwY != null) {
                this.bwY.clear();
            }
            Pc();
        }
    }

    private void setDividerModel(Model model) {
        if (model == Model.VERTICAL || model == Model.VERTICAL_BB_CHATING) {
            this.bwX.setPriority(90);
        } else if (model == Model.VERTICAL_PK) {
            this.bwX.setPriority(100);
        } else if (model == Model.HORIZONTAL || model == Model.HORIZONTAL_FULL) {
            this.bwX.setPriority(105);
        }
        this.bwW.setPriority(105);
    }

    public void a(PendantChildView pendantChildView, LinearLayout.LayoutParams layoutParams) {
        Position horizontalFullPosition;
        if (pendantChildView != null && layoutParams != null) {
            pendantChildView.setMode(this.bwT);
            if (this.bwT == Model.VERTICAL) {
                horizontalFullPosition = pendantChildView.getVerticalPosition();
            } else if (this.bwT == Model.VERTICAL_PK) {
                horizontalFullPosition = pendantChildView.getVerticalPkPosition();
            } else if (this.bwT == Model.VERTICAL_BB_CHATING) {
                horizontalFullPosition = pendantChildView.getVerticalBBChattingPosition();
            } else if (this.bwT == Model.HORIZONTAL) {
                horizontalFullPosition = pendantChildView.getHorizontalPosition();
            } else {
                horizontalFullPosition = pendantChildView.getHorizontalFullPosition();
            }
            if (pendantChildView.getParent() != null) {
                ((ViewGroup) pendantChildView.getParent()).removeView(pendantChildView);
            }
            if (horizontalFullPosition == Position.LEFT) {
                layoutParams.gravity = GravityCompat.START;
                this.bwU.addView(pendantChildView, layoutParams);
                return;
            }
            layoutParams.gravity = GravityCompat.END;
            this.bwV.addView(pendantChildView, layoutParams);
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
        ViewGroup.LayoutParams layoutParams = this.bwU.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bwU.setLayoutParams(layoutParams);
    }

    public void setLeftBottom(int i) {
        this.leftBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bwU.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bwU.setLayoutParams(layoutParams);
    }

    public void setRightTop(int i) {
        this.rightTop = i;
        ViewGroup.LayoutParams layoutParams = this.bwV.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
        }
        this.bwV.setLayoutParams(layoutParams);
    }

    public void setRightBottom(int i) {
        this.rightBottom = i;
        ViewGroup.LayoutParams layoutParams = this.bwV.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
        }
        this.bwV.setLayoutParams(layoutParams);
    }

    public void Pc() {
        if (this.bwZ) {
            if (Pe() && this.bwV != null) {
                if (getRightChildCount() > 2) {
                    this.bwY.clear();
                    boolean z = false;
                    for (int i = 0; i < this.bwV.getChildCount(); i++) {
                        if (this.bwY != null) {
                            View childAt = this.bwV.getChildAt(i);
                            if (childAt instanceof PendantChildView) {
                                PendantChildView pendantChildView = (PendantChildView) childAt;
                                if (pendantChildView.getPriority() != 100 && pendantChildView.getPriority() != 10 && pendantChildView.getPriority() > 0) {
                                    this.bwY.add(pendantChildView);
                                } else if (pendantChildView.getPriority() == 10 && pendantChildView.getChildCount() > 0) {
                                    z = true;
                                }
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.bwY)) {
                        int i2 = z ? 1 : 2;
                        if (this.bwY.size() > i2) {
                            for (int i3 = 0; i3 < i2; i3++) {
                                this.bwY.remove(0);
                            }
                            for (PendantChildView pendantChildView2 : this.bwY) {
                                this.bwV.removeView(pendantChildView2);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                Pd();
                return;
            }
            Pd();
        }
    }

    private void Pd() {
        if (!ListUtils.isEmpty(this.bwY) && this.bwV != null) {
            for (PendantChildView pendantChildView : this.bwY) {
                if (this.bwV.indexOfChild(pendantChildView) < 0) {
                    this.bwV.addView(pendantChildView, 0, pendantChildView.getLayoutParams());
                }
            }
            this.bwY.clear();
        }
    }

    private boolean Pe() {
        if (this.bwV != null) {
            for (int i = 0; i < this.bwV.getChildCount(); i++) {
                View childAt = this.bwV.getChildAt(i);
                if ((childAt instanceof PendantChildView) && ((PendantChildView) childAt).getPriority() == 100) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int getRightChildCount() {
        if (this.bwV != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.bwV.getChildCount(); i2++) {
                View childAt = this.bwV.getChildAt(i2);
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
    /* loaded from: classes11.dex */
    public static class a extends PendantChildView {
        private Position bxa;

        public a(Context context, Position position) {
            super(context);
            this.bxa = position;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPosition() {
            return this.bxa;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalPkPosition() {
            return this.bxa;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getVerticalBBChattingPosition() {
            return this.bxa;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalPosition() {
            return this.bxa;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public Position getHorizontalFullPosition() {
            return this.bxa;
        }

        @Override // com.baidu.live.pendantview.PendantChildView
        public int getPriority() {
            return this.priority;
        }
    }

    public void setDefaultItemMargin(int i) {
        this.bwU.setDefaultItemMargin(i);
        this.bwV.setDefaultItemMargin(i);
    }

    public int getRightViewHeight() {
        return this.bwV.getHeight();
    }

    public LinearLayout.LayoutParams getDividerLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void a(PendantChildView pendantChildView) {
        if (pendantChildView != null) {
            if (this.bwU.indexOfChild(pendantChildView) != -1) {
                this.bwU.removeView(pendantChildView);
                this.bwU.addView(pendantChildView);
            }
            if (this.bwV.indexOfChild(pendantChildView) != -1) {
                this.bwV.removeView(pendantChildView);
                this.bwV.addView(pendantChildView);
            }
        }
    }
}
