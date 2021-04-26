package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
/* loaded from: classes.dex */
public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    public ContentAlignment mAlignment;

    /* loaded from: classes.dex */
    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public ConstraintHorizontalLayout() {
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        if (this.mChildren.size() != 0) {
            int i2 = 0;
            int size = this.mChildren.size();
            ConstraintWidget constraintWidget = this;
            while (i2 < size) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                if (constraintWidget != this) {
                    constraintWidget2.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.RIGHT);
                    constraintWidget.connect(ConstraintAnchor.Type.RIGHT, constraintWidget2, ConstraintAnchor.Type.LEFT);
                } else {
                    ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                    if (this.mAlignment == ContentAlignment.END) {
                        strength = ConstraintAnchor.Strength.WEAK;
                    }
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget2.connect(type, constraintWidget, type, 0, strength);
                }
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                constraintWidget2.connect(type2, this, type2);
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget2.connect(type3, this, type3);
                i2++;
                constraintWidget = constraintWidget2;
            }
            if (constraintWidget != this) {
                ConstraintAnchor.Strength strength2 = ConstraintAnchor.Strength.STRONG;
                if (this.mAlignment == ContentAlignment.BEGIN) {
                    strength2 = ConstraintAnchor.Strength.WEAK;
                }
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.connect(type4, this, type4, 0, strength2);
            }
        }
        super.addToSolver(linearSystem);
    }

    public ConstraintHorizontalLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i2, int i3) {
        super(i2, i3);
        this.mAlignment = ContentAlignment.MIDDLE;
    }
}
