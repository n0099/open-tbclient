package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i, int i2) {
        super(i, i2);
        this.mChildren = new ArrayList<>();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent(null);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget constraintWidget;
        ConstraintWidget parent = getParent();
        if (!(this instanceof ConstraintWidgetContainer)) {
            constraintWidgetContainer = null;
            constraintWidget = parent;
        } else {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
            constraintWidget = parent;
        }
        while (constraintWidget != null) {
            ConstraintWidget parent2 = constraintWidget.getParent();
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
                constraintWidget = parent2;
            } else {
                constraintWidget = parent2;
            }
        }
        return constraintWidgetContainer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public ConstraintWidget findWidget(float f, float f2) {
        WidgetContainer widgetContainer = null;
        int drawX = getDrawX();
        int drawY = getDrawY();
        int width = getWidth() + drawX;
        int height = getHeight() + drawY;
        if (f >= drawX && f <= width && f2 >= drawY && f2 <= height) {
            widgetContainer = this;
        }
        int size = this.mChildren.size();
        WidgetContainer widgetContainer2 = widgetContainer;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof WidgetContainer) {
                ConstraintWidget findWidget = ((WidgetContainer) constraintWidget).findWidget(f, f2);
                if (findWidget == null) {
                    findWidget = widgetContainer2;
                }
                widgetContainer2 = findWidget;
            } else {
                int drawX2 = constraintWidget.getDrawX();
                int drawY2 = constraintWidget.getDrawY();
                int width2 = constraintWidget.getWidth() + drawX2;
                int height2 = constraintWidget.getHeight() + drawY2;
                if (f >= drawX2 && f <= width2 && f2 >= drawY2 && f2 <= height2) {
                    widgetContainer2 = constraintWidget;
                }
            }
        }
        return widgetContainer2;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i, int i2, int i3, int i4) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i, i2, i3, i4);
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.intersects(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        int i = Integer.MAX_VALUE;
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        while (i2 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i2);
            if (constraintWidget.getX() < i5) {
                i5 = constraintWidget.getX();
            }
            if (constraintWidget.getY() < i) {
                i = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > i4) {
                i4 = constraintWidget.getRight();
            }
            i2++;
            i3 = constraintWidget.getBottom() > i3 ? constraintWidget.getBottom() : i3;
        }
        rectangle.setBounds(i5, i, i4 - i5, i3 - i);
        return rectangle;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).setOffset(getRootX(), getRootY());
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        super.updateDrawPosition();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }

    public void layout() {
        updateDrawPosition();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetSolverVariables(cache);
        }
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }
}
