package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public ArrayList<Guideline> mHorizontalGuidelines;
    public ArrayList<HorizontalSlice> mHorizontalSlices;
    public int mNumCols;
    public int mNumRows;
    public int mPadding;
    public boolean mVerticalGrowth;
    public ArrayList<Guideline> mVerticalGuidelines;
    public ArrayList<VerticalSlice> mVerticalSlices;
    public LinearSystem system;

    /* loaded from: classes.dex */
    public class HorizontalSlice {
        public ConstraintWidget bottom;
        public int padding;
        public ConstraintWidget top;

        public HorizontalSlice() {
        }
    }

    /* loaded from: classes.dex */
    public class VerticalSlice {
        public int alignment = 1;
        public ConstraintWidget left;
        public int padding;
        public ConstraintWidget right;

        public VerticalSlice() {
        }
    }

    public ConstraintTableLayout() {
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }

    private void setChildrenConnections() {
        int size = this.mChildren.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            int containerItemSkip = i + constraintWidget.getContainerItemSkip();
            int i3 = this.mNumCols;
            int i4 = containerItemSkip % i3;
            HorizontalSlice horizontalSlice = this.mHorizontalSlices.get(containerItemSkip / i3);
            VerticalSlice verticalSlice = this.mVerticalSlices.get(i4);
            ConstraintWidget constraintWidget2 = verticalSlice.left;
            ConstraintWidget constraintWidget3 = verticalSlice.right;
            ConstraintWidget constraintWidget4 = horizontalSlice.top;
            ConstraintWidget constraintWidget5 = horizontalSlice.bottom;
            constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
            if (constraintWidget3 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
            } else {
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mPadding);
            }
            int i5 = verticalSlice.alignment;
            if (i5 == 1) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
            } else if (i5 == 2) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
            } else if (i5 == 3) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            }
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            if (constraintWidget5 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            } else {
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
            }
            i = containerItemSkip + 1;
        }
    }

    private void setHorizontalSlices() {
        this.mHorizontalSlices.clear();
        float f2 = 100.0f / this.mNumRows;
        ConstraintWidget constraintWidget = this;
        float f3 = f2;
        for (int i = 0; i < this.mNumRows; i++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice();
            horizontalSlice.top = constraintWidget;
            if (i < this.mNumRows - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(0);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                horizontalSlice.bottom = guideline;
                this.mHorizontalGuidelines.add(guideline);
            } else {
                horizontalSlice.bottom = this;
            }
            constraintWidget = horizontalSlice.bottom;
            this.mHorizontalSlices.add(horizontalSlice);
        }
        updateDebugSolverNames();
    }

    private void setVerticalSlices() {
        this.mVerticalSlices.clear();
        float f2 = 100.0f / this.mNumCols;
        ConstraintWidget constraintWidget = this;
        float f3 = f2;
        for (int i = 0; i < this.mNumCols; i++) {
            VerticalSlice verticalSlice = new VerticalSlice();
            verticalSlice.left = constraintWidget;
            if (i < this.mNumCols - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(1);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                verticalSlice.right = guideline;
                this.mVerticalGuidelines.add(guideline);
            } else {
                verticalSlice.right = this;
            }
            constraintWidget = verticalSlice.right;
            this.mVerticalSlices.add(verticalSlice);
        }
        updateDebugSolverNames();
    }

    private void updateDebugSolverNames() {
        if (this.system == null) {
            return;
        }
        int size = this.mVerticalGuidelines.size();
        for (int i = 0; i < size; i++) {
            LinearSystem linearSystem = this.system;
            this.mVerticalGuidelines.get(i).setDebugSolverName(linearSystem, getDebugName() + ".VG" + i);
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            LinearSystem linearSystem2 = this.system;
            this.mHorizontalGuidelines.get(i2).setDebugSolverName(linearSystem2, getDebugName() + ".HG" + i2);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        int size = this.mChildren.size();
        if (size == 0) {
            return;
        }
        setTableDimensions();
        if (linearSystem == this.mSystem) {
            int size2 = this.mVerticalGuidelines.size();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= size2) {
                    break;
                }
                Guideline guideline = this.mVerticalGuidelines.get(i);
                if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = false;
                }
                guideline.setPositionRelaxed(z);
                guideline.addToSolver(linearSystem);
                i++;
            }
            int size3 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size3; i2++) {
                Guideline guideline2 = this.mHorizontalGuidelines.get(i2);
                guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                guideline2.addToSolver(linearSystem);
            }
            for (int i3 = 0; i3 < size; i3++) {
                this.mChildren.get(i3).addToSolver(linearSystem);
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.mVerticalGuidelines.size();
        for (int i = 0; i < size; i++) {
            this.mVerticalGuidelines.get(i).inferRelativePercentPosition();
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mHorizontalGuidelines.get(i2).inferRelativePercentPosition();
        }
    }

    public void cycleColumnAlignment(int i) {
        VerticalSlice verticalSlice = this.mVerticalSlices.get(i);
        int i2 = verticalSlice.alignment;
        if (i2 == 0) {
            verticalSlice.alignment = 2;
        } else if (i2 == 1) {
            verticalSlice.alignment = 0;
        } else if (i2 == 2) {
            verticalSlice.alignment = 1;
        }
        setChildrenConnections();
    }

    public String getColumnAlignmentRepresentation(int i) {
        int i2 = this.mVerticalSlices.get(i).alignment;
        return i2 == 1 ? "L" : i2 == 0 ? "C" : i2 == 3 ? "F" : i2 == 2 ? "R" : "!";
    }

    public String getColumnsAlignmentRepresentation() {
        int size = this.mVerticalSlices.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            int i2 = this.mVerticalSlices.get(i).alignment;
            if (i2 == 1) {
                str = str + "L";
            } else if (i2 == 0) {
                str = str + "C";
            } else if (i2 == 3) {
                str = str + "F";
            } else if (i2 == 2) {
                str = str + "R";
            }
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.mHorizontalGuidelines;
    }

    public int getNumCols() {
        return this.mNumCols;
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public int getPadding() {
        return this.mPadding;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintTableLayout";
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.mVerticalGuidelines;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public boolean handlesInternalConstraints() {
        return true;
    }

    public boolean isVerticalGrowth() {
        return this.mVerticalGrowth;
    }

    public void setColumnAlignment(int i, int i2) {
        if (i < this.mVerticalSlices.size()) {
            this.mVerticalSlices.get(i).alignment = i2;
            setChildrenConnections();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.system = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        updateDebugSolverNames();
    }

    public void setNumCols(int i) {
        if (!this.mVerticalGrowth || this.mNumCols == i) {
            return;
        }
        this.mNumCols = i;
        setVerticalSlices();
        setTableDimensions();
    }

    public void setNumRows(int i) {
        if (this.mVerticalGrowth || this.mNumCols == i) {
            return;
        }
        this.mNumRows = i;
        setHorizontalSlices();
        setTableDimensions();
    }

    public void setPadding(int i) {
        if (i > 1) {
            this.mPadding = i;
        }
    }

    public void setTableDimensions() {
        int size = this.mChildren.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mChildren.get(i2).getContainerItemSkip();
        }
        int i3 = size + i;
        if (this.mVerticalGrowth) {
            if (this.mNumCols == 0) {
                setNumCols(1);
            }
            int i4 = this.mNumCols;
            int i5 = i3 / i4;
            if (i4 * i5 < i3) {
                i5++;
            }
            if (this.mNumRows == i5 && this.mVerticalGuidelines.size() == this.mNumCols - 1) {
                return;
            }
            this.mNumRows = i5;
            setHorizontalSlices();
        } else {
            if (this.mNumRows == 0) {
                setNumRows(1);
            }
            int i6 = this.mNumRows;
            int i7 = i3 / i6;
            if (i6 * i7 < i3) {
                i7++;
            }
            if (this.mNumCols == i7 && this.mHorizontalGuidelines.size() == this.mNumRows - 1) {
                return;
            }
            this.mNumCols = i7;
            setVerticalSlices();
        }
        setChildrenConnections();
    }

    public void setVerticalGrowth(boolean z) {
        this.mVerticalGrowth = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        super.updateFromSolver(linearSystem);
        if (linearSystem == this.mSystem) {
            int size = this.mVerticalGuidelines.size();
            for (int i = 0; i < size; i++) {
                this.mVerticalGuidelines.get(i).updateFromSolver(linearSystem);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mHorizontalGuidelines.get(i2).updateFromSolver(linearSystem);
            }
        }
    }

    public void setColumnAlignment(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 'L') {
                setColumnAlignment(i, 1);
            } else if (charAt == 'C') {
                setColumnAlignment(i, 0);
            } else if (charAt == 'F') {
                setColumnAlignment(i, 3);
            } else if (charAt == 'R') {
                setColumnAlignment(i, 2);
            } else {
                setColumnAlignment(i, 0);
            }
        }
    }

    public ConstraintTableLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }

    public ConstraintTableLayout(int i, int i2) {
        super(i, i2);
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }
}
