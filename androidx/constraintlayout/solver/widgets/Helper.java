package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public void add(ConstraintWidget constraintWidget) {
        int i2 = this.mWidgetsCount + 1;
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        if (i2 > constraintWidgetArr.length) {
            this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i3 = this.mWidgetsCount;
        constraintWidgetArr2[i3] = constraintWidget;
        this.mWidgetsCount = i3 + 1;
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
    }
}
