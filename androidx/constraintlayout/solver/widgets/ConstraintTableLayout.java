package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintWidget bottom;
        public int padding;
        public final /* synthetic */ ConstraintTableLayout this$0;
        public ConstraintWidget top;

        public HorizontalSlice(ConstraintTableLayout constraintTableLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constraintTableLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constraintTableLayout;
        }
    }

    /* loaded from: classes.dex */
    public class VerticalSlice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int alignment;
        public ConstraintWidget left;
        public int padding;
        public ConstraintWidget right;
        public final /* synthetic */ ConstraintTableLayout this$0;

        public VerticalSlice(ConstraintTableLayout constraintTableLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constraintTableLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constraintTableLayout;
            this.alignment = 1;
        }
    }

    public ConstraintTableLayout() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int size = this.mChildren.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i3);
                int containerItemSkip = i2 + constraintWidget.getContainerItemSkip();
                int i4 = this.mNumCols;
                int i5 = containerItemSkip % i4;
                HorizontalSlice horizontalSlice = this.mHorizontalSlices.get(containerItemSkip / i4);
                VerticalSlice verticalSlice = this.mVerticalSlices.get(i5);
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
                int i6 = verticalSlice.alignment;
                if (i6 == 1) {
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
                } else if (i6 == 2) {
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
                } else if (i6 == 3) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                }
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
                if (constraintWidget5 instanceof Guideline) {
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
                } else {
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
                }
                i2 = containerItemSkip + 1;
            }
        }
    }

    private void setHorizontalSlices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.mHorizontalSlices.clear();
            float f2 = 100.0f / this.mNumRows;
            ConstraintWidget constraintWidget = this;
            float f3 = f2;
            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                HorizontalSlice horizontalSlice = new HorizontalSlice(this);
                horizontalSlice.top = constraintWidget;
                if (i2 < this.mNumRows - 1) {
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
    }

    private void setVerticalSlices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mVerticalSlices.clear();
            float f2 = 100.0f / this.mNumCols;
            ConstraintWidget constraintWidget = this;
            float f3 = f2;
            for (int i2 = 0; i2 < this.mNumCols; i2++) {
                VerticalSlice verticalSlice = new VerticalSlice(this);
                verticalSlice.left = constraintWidget;
                if (i2 < this.mNumCols - 1) {
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
    }

    private void updateDebugSolverNames() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.system == null) {
            return;
        }
        int size = this.mVerticalGuidelines.size();
        for (int i2 = 0; i2 < size; i2++) {
            LinearSystem linearSystem = this.system;
            this.mVerticalGuidelines.get(i2).setDebugSolverName(linearSystem, getDebugName() + ".VG" + i2);
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i3 = 0; i3 < size2; i3++) {
            LinearSystem linearSystem2 = this.system;
            this.mHorizontalGuidelines.get(i3).setDebugSolverName(linearSystem2, getDebugName() + ".HG" + i3);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearSystem) == null) {
            super.addToSolver(linearSystem);
            int size = this.mChildren.size();
            if (size == 0) {
                return;
            }
            setTableDimensions();
            if (linearSystem == this.mSystem) {
                int size2 = this.mVerticalGuidelines.size();
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= size2) {
                        break;
                    }
                    Guideline guideline = this.mVerticalGuidelines.get(i2);
                    if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z = false;
                    }
                    guideline.setPositionRelaxed(z);
                    guideline.addToSolver(linearSystem);
                    i2++;
                }
                int size3 = this.mHorizontalGuidelines.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Guideline guideline2 = this.mHorizontalGuidelines.get(i3);
                    guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    guideline2.addToSolver(linearSystem);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    this.mChildren.get(i4).addToSolver(linearSystem);
                }
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int size = this.mVerticalGuidelines.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mVerticalGuidelines.get(i2).inferRelativePercentPosition();
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.mHorizontalGuidelines.get(i3).inferRelativePercentPosition();
            }
        }
    }

    public void cycleColumnAlignment(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            VerticalSlice verticalSlice = this.mVerticalSlices.get(i2);
            int i3 = verticalSlice.alignment;
            if (i3 == 0) {
                verticalSlice.alignment = 2;
            } else if (i3 == 1) {
                verticalSlice.alignment = 0;
            } else if (i3 == 2) {
                verticalSlice.alignment = 1;
            }
            setChildrenConnections();
        }
    }

    public String getColumnAlignmentRepresentation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.mVerticalSlices.get(i2).alignment;
            return i3 == 1 ? "L" : i3 == 0 ? "C" : i3 == 3 ? "F" : i3 == 2 ? "R" : "!";
        }
        return (String) invokeI.objValue;
    }

    public String getColumnsAlignmentRepresentation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int size = this.mVerticalSlices.size();
            String str = "";
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = this.mVerticalSlices.get(i2).alignment;
                if (i3 == 1) {
                    str = str + "L";
                } else if (i3 == 0) {
                    str = str + "C";
                } else if (i3 == 3) {
                    str = str + "F";
                } else if (i3 == 2) {
                    str = str + "R";
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getHorizontalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mHorizontalGuidelines : (ArrayList) invokeV.objValue;
    }

    public int getNumCols() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNumCols : invokeV.intValue;
    }

    public int getNumRows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mNumRows : invokeV.intValue;
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPadding : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "ConstraintTableLayout" : (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getVerticalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVerticalGuidelines : (ArrayList) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public boolean handlesInternalConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalGrowth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVerticalGrowth : invokeV.booleanValue;
    }

    public void setColumnAlignment(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || i2 >= this.mVerticalSlices.size()) {
            return;
        }
        this.mVerticalSlices.get(i2).alignment = i3;
        setChildrenConnections();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, linearSystem, str) == null) {
            this.system = linearSystem;
            super.setDebugSolverName(linearSystem, str);
            updateDebugSolverNames();
        }
    }

    public void setNumCols(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && this.mVerticalGrowth && this.mNumCols != i2) {
            this.mNumCols = i2;
            setVerticalSlices();
            setTableDimensions();
        }
    }

    public void setNumRows(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.mVerticalGrowth || this.mNumCols == i2) {
            return;
        }
        this.mNumRows = i2;
        setHorizontalSlices();
        setTableDimensions();
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= 1) {
            return;
        }
        this.mPadding = i2;
    }

    public void setTableDimensions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int size = this.mChildren.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += this.mChildren.get(i3).getContainerItemSkip();
            }
            int i4 = size + i2;
            if (this.mVerticalGrowth) {
                if (this.mNumCols == 0) {
                    setNumCols(1);
                }
                int i5 = this.mNumCols;
                int i6 = i4 / i5;
                if (i5 * i6 < i4) {
                    i6++;
                }
                if (this.mNumRows == i6 && this.mVerticalGuidelines.size() == this.mNumCols - 1) {
                    return;
                }
                this.mNumRows = i6;
                setHorizontalSlices();
            } else {
                if (this.mNumRows == 0) {
                    setNumRows(1);
                }
                int i7 = this.mNumRows;
                int i8 = i4 / i7;
                if (i7 * i8 < i4) {
                    i8++;
                }
                if (this.mNumCols == i8 && this.mHorizontalGuidelines.size() == this.mNumRows - 1) {
                    return;
                }
                this.mNumCols = i8;
                setVerticalSlices();
            }
            setChildrenConnections();
        }
    }

    public void setVerticalGrowth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mVerticalGrowth = z;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, linearSystem) == null) {
            super.updateFromSolver(linearSystem);
            if (linearSystem == this.mSystem) {
                int size = this.mVerticalGuidelines.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.mVerticalGuidelines.get(i2).updateFromSolver(linearSystem);
                }
                int size2 = this.mHorizontalGuidelines.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.mHorizontalGuidelines.get(i3).updateFromSolver(linearSystem);
                }
            }
        }
    }

    public void setColumnAlignment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == 'L') {
                    setColumnAlignment(i2, 1);
                } else if (charAt == 'C') {
                    setColumnAlignment(i2, 0);
                } else if (charAt == 'F') {
                    setColumnAlignment(i2, 3);
                } else if (charAt == 'R') {
                    setColumnAlignment(i2, 2);
                } else {
                    setColumnAlignment(i2, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTableLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTableLayout(int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
