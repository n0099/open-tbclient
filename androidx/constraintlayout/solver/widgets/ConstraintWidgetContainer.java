package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_GRAPH = false;
    public static final boolean DEBUG_LAYOUT = false;
    public static final int MAX_ITERATIONS = 8;
    public static final boolean USE_SNAPSHOT = true;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDebugSolverPassCount;
    public boolean mGroupsWrapOptimized;
    public boolean mHeightMeasuredTooSmall;
    public ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    public boolean mIsRtl;
    public int mOptimizationLevel;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public boolean mSkipSolver;
    public Snapshot mSnapshot;
    public LinearSystem mSystem;
    public ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    public boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, constraintWidget) == null) {
            int i = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
            this.mHorizontalChainsSize++;
        }
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, constraintWidget) == null) {
            int i = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mVerticalChainsArray;
            if (i >= chainHeadArr.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
            this.mVerticalChainsSize++;
        }
    }

    private void resetChains() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mHorizontalChainsSize = 0;
            this.mVerticalChainsSize = 0;
        }
    }

    public void addChain(ConstraintWidget constraintWidget, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, constraintWidget, i) == null) {
            if (i == 0) {
                addHorizontalChain(constraintWidget);
            } else if (i == 1) {
                addVerticalChain(constraintWidget);
            }
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearSystem)) == null) {
            addToSolver(linearSystem);
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget.addToSolver(linearSystem);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                    constraintWidget.addToSolver(linearSystem);
                }
            }
            if (this.mHorizontalChainsSize > 0) {
                Chain.applyChainConstraints(this, linearSystem, 0);
            }
            if (this.mVerticalChainsSize > 0) {
                Chain.applyChainConstraints(this, linearSystem, 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.analyze(i);
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mChildren.get(i2).analyze(i);
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metrics) == null) {
            this.mSystem.fillMetrics(metrics);
        }
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<Guideline> arrayList = new ArrayList<>();
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof Guideline) {
                    Guideline guideline = (Guideline) constraintWidget;
                    if (guideline.getOrientation() == 0) {
                        arrayList.add(guideline);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getOptimizationLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mOptimizationLevel : invokeV.intValue;
    }

    public LinearSystem getSystem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSystem : (LinearSystem) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ConstraintLayout.TAG : (String) invokeV.objValue;
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<Guideline> arrayList = new ArrayList<>();
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof Guideline) {
                    Guideline guideline = (Guideline) constraintWidget;
                    if (guideline.getOrientation() == 1) {
                        arrayList.add(guideline);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mWidgetGroups : (List) invokeV.objValue;
    }

    public boolean handlesInternalConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHeightMeasuredTooSmall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mHeightMeasuredTooSmall : invokeV.booleanValue;
    }

    public boolean isRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsRtl : invokeV.booleanValue;
    }

    public boolean isWidthMeasuredTooSmall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mWidthMeasuredTooSmall : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01de  */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layout() {
        int i;
        int i2;
        char c2;
        int i3;
        boolean z;
        int max;
        int max2;
        ?? r8;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int i4 = this.mX;
            int i5 = this.mY;
            int max3 = Math.max(0, getWidth());
            int max4 = Math.max(0, getHeight());
            this.mWidthMeasuredTooSmall = false;
            this.mHeightMeasuredTooSmall = false;
            if (this.mParent != null) {
                if (this.mSnapshot == null) {
                    this.mSnapshot = new Snapshot(this);
                }
                this.mSnapshot.updateFrom(this);
                setX(this.mPaddingLeft);
                setY(this.mPaddingTop);
                resetAnchors();
                resetSolverVariables(this.mSystem.getCache());
            } else {
                this.mX = 0;
                this.mY = 0;
            }
            int i6 = 32;
            if (this.mOptimizationLevel != 0) {
                if (!optimizeFor(8)) {
                    optimizeReset();
                }
                if (!optimizeFor(32)) {
                    optimize();
                }
                this.mSystem.graphOptimizer = true;
            } else {
                this.mSystem.graphOptimizer = false;
            }
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[1];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
            resetChains();
            if (this.mWidgetGroups.size() == 0) {
                this.mWidgetGroups.clear();
                this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
            }
            int size = this.mWidgetGroups.size();
            ArrayList<ConstraintWidget> arrayList = this.mChildren;
            boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z4 = false;
            int i7 = 0;
            while (i7 < size && !this.mSkipSolver) {
                if (this.mWidgetGroups.get(i7).mSkipSolver) {
                    i = size;
                } else {
                    if (optimizeFor(i6)) {
                        if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED && getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                            this.mChildren = (ArrayList) this.mWidgetGroups.get(i7).getWidgetsToSolve();
                        } else {
                            this.mChildren = (ArrayList) this.mWidgetGroups.get(i7).mConstrainedGroup;
                        }
                    }
                    resetChains();
                    int size2 = this.mChildren.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        ConstraintWidget constraintWidget = this.mChildren.get(i8);
                        if (constraintWidget instanceof WidgetContainer) {
                            ((WidgetContainer) constraintWidget).layout();
                        }
                    }
                    boolean z5 = z4;
                    int i9 = 0;
                    boolean z6 = true;
                    while (z6) {
                        boolean z7 = z5;
                        int i10 = i9 + 1;
                        try {
                            this.mSystem.reset();
                            resetChains();
                            createObjectVariables(this.mSystem);
                            int i11 = 0;
                            while (i11 < size2) {
                                boolean z8 = z6;
                                try {
                                    this.mChildren.get(i11).createObjectVariables(this.mSystem);
                                    i11++;
                                    z6 = z8;
                                } catch (Exception e2) {
                                    e = e2;
                                    z6 = z8;
                                    e.printStackTrace();
                                    PrintStream printStream = System.out;
                                    boolean z9 = z6;
                                    StringBuilder sb = new StringBuilder();
                                    i2 = size;
                                    sb.append("EXCEPTION : ");
                                    sb.append(e);
                                    printStream.println(sb.toString());
                                    z6 = z9;
                                    if (z6) {
                                    }
                                    c2 = 2;
                                    if (z3) {
                                    }
                                    i3 = i10;
                                    z = false;
                                    max = Math.max(this.mMinWidth, getWidth());
                                    if (max > getWidth()) {
                                    }
                                    max2 = Math.max(this.mMinHeight, getHeight());
                                    if (max2 <= getHeight()) {
                                    }
                                    if (!z2) {
                                    }
                                    z6 = z;
                                    z5 = z2;
                                    i9 = i3;
                                    size = i2;
                                }
                            }
                            z6 = addChildrenToSolver(this.mSystem);
                            if (z6) {
                                try {
                                    this.mSystem.minimize();
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    PrintStream printStream2 = System.out;
                                    boolean z92 = z6;
                                    StringBuilder sb2 = new StringBuilder();
                                    i2 = size;
                                    sb2.append("EXCEPTION : ");
                                    sb2.append(e);
                                    printStream2.println(sb2.toString());
                                    z6 = z92;
                                    if (z6) {
                                    }
                                    c2 = 2;
                                    if (z3) {
                                    }
                                    i3 = i10;
                                    z = false;
                                    max = Math.max(this.mMinWidth, getWidth());
                                    if (max > getWidth()) {
                                    }
                                    max2 = Math.max(this.mMinHeight, getHeight());
                                    if (max2 <= getHeight()) {
                                    }
                                    if (!z2) {
                                    }
                                    z6 = z;
                                    z5 = z2;
                                    i9 = i3;
                                    size = i2;
                                }
                            }
                            i2 = size;
                        } catch (Exception e4) {
                            e = e4;
                        }
                        if (z6) {
                            updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                        } else {
                            updateFromSolver(this.mSystem);
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    break;
                                }
                                ConstraintWidget constraintWidget2 = this.mChildren.get(i12);
                                if (constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getWidth() < constraintWidget2.getWrapWidth()) {
                                    Optimizer.flags[2] = true;
                                    break;
                                } else if (constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getHeight() < constraintWidget2.getWrapHeight()) {
                                    c2 = 2;
                                    Optimizer.flags[2] = true;
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            if (z3 || i10 >= 8 || !Optimizer.flags[c2]) {
                                i3 = i10;
                                z = false;
                            } else {
                                int i13 = 0;
                                int i14 = 0;
                                int i15 = 0;
                                while (i13 < size2) {
                                    ConstraintWidget constraintWidget3 = this.mChildren.get(i13);
                                    i14 = Math.max(i14, constraintWidget3.mX + constraintWidget3.getWidth());
                                    i15 = Math.max(i15, constraintWidget3.mY + constraintWidget3.getHeight());
                                    i13++;
                                    i10 = i10;
                                }
                                i3 = i10;
                                int max5 = Math.max(this.mMinWidth, i14);
                                int max6 = Math.max(this.mMinHeight, i15);
                                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getWidth() >= max5) {
                                    z = false;
                                } else {
                                    setWidth(max5);
                                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                    z = true;
                                    z7 = true;
                                }
                                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < max6) {
                                    setHeight(max6);
                                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                    z = true;
                                    z7 = true;
                                }
                            }
                            max = Math.max(this.mMinWidth, getWidth());
                            if (max > getWidth()) {
                                setWidth(max);
                                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z = true;
                                z7 = true;
                            }
                            max2 = Math.max(this.mMinHeight, getHeight());
                            if (max2 <= getHeight()) {
                                setHeight(max2);
                                r8 = 1;
                                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z = true;
                                z2 = true;
                            } else {
                                r8 = 1;
                                z2 = z7;
                            }
                            if (!z2) {
                                if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max3 > 0 && getWidth() > max3) {
                                    this.mWidthMeasuredTooSmall = r8;
                                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    setWidth(max3);
                                    z = true;
                                    z2 = true;
                                }
                                if (this.mListDimensionBehaviors[r8] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max4 > 0 && getHeight() > max4) {
                                    this.mHeightMeasuredTooSmall = r8;
                                    this.mListDimensionBehaviors[r8] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    setHeight(max4);
                                    z5 = true;
                                    z6 = true;
                                    i9 = i3;
                                    size = i2;
                                }
                            }
                            z6 = z;
                            z5 = z2;
                            i9 = i3;
                            size = i2;
                        }
                        c2 = 2;
                        if (z3) {
                        }
                        i3 = i10;
                        z = false;
                        max = Math.max(this.mMinWidth, getWidth());
                        if (max > getWidth()) {
                        }
                        max2 = Math.max(this.mMinHeight, getHeight());
                        if (max2 <= getHeight()) {
                        }
                        if (!z2) {
                        }
                        z6 = z;
                        z5 = z2;
                        i9 = i3;
                        size = i2;
                    }
                    i = size;
                    this.mWidgetGroups.get(i7).updateUnresolvedWidgets();
                    z4 = z5;
                }
                i7++;
                size = i;
                i6 = 32;
            }
            this.mChildren = arrayList;
            if (this.mParent != null) {
                int max7 = Math.max(this.mMinWidth, getWidth());
                int max8 = Math.max(this.mMinHeight, getHeight());
                this.mSnapshot.applyTo(this);
                setWidth(max7 + this.mPaddingLeft + this.mPaddingRight);
                setHeight(max8 + this.mPaddingTop + this.mPaddingBottom);
            } else {
                this.mX = i4;
                this.mY = i5;
            }
            if (z4) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                dimensionBehaviourArr2[0] = dimensionBehaviour2;
                dimensionBehaviourArr2[1] = dimensionBehaviour;
            }
            resetSolverVariables(this.mSystem.getCache());
            if (this == getRootConstraintContainer()) {
                updateDrawPosition();
            }
        }
    }

    public void optimize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!optimizeFor(8)) {
                analyze(this.mOptimizationLevel);
            }
            solveGraph();
        }
    }

    public boolean optimizeFor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? (this.mOptimizationLevel & i) == i : invokeI.booleanValue;
    }

    public void optimizeForDimensions(int i, int i2) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (resolutionDimension2 = this.mResolutionWidth) != null) {
                resolutionDimension2.resolve(i);
            }
            if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (resolutionDimension = this.mResolutionHeight) == null) {
                return;
            }
            resolutionDimension.resolve(i2);
        }
    }

    public void optimizeReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            int size = this.mChildren.size();
            resetResolutionNodes();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).resetResolutionNodes();
            }
        }
    }

    public void preOptimize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            optimizeReset();
            analyze(this.mOptimizationLevel);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mSystem.reset();
            this.mPaddingLeft = 0;
            this.mPaddingRight = 0;
            this.mPaddingTop = 0;
            this.mPaddingBottom = 0;
            this.mWidgetGroups.clear();
            this.mSkipSolver = false;
            super.reset();
        }
    }

    public void resetGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
            ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
            resolutionNode.invalidateAnchors();
            resolutionNode2.invalidateAnchors();
            resolutionNode.resolve(null, 0.0f);
            resolutionNode2.resolve(null, 0.0f);
        }
    }

    public void setOptimizationLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.mOptimizationLevel = i;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) {
            this.mPaddingLeft = i;
            this.mPaddingTop = i2;
            this.mPaddingRight = i3;
            this.mPaddingBottom = i4;
        }
    }

    public void setRtl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mIsRtl = z;
        }
    }

    public void solveGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
            ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
            resolutionNode.resolve(null, 0.0f);
            resolutionNode2.resolve(null, 0.0f);
        }
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, linearSystem, zArr) == null) {
            zArr[2] = false;
            updateFromSolver(linearSystem);
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.updateFromSolver(linearSystem);
                if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                    zArr[2] = true;
                }
                if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                    zArr[2] = true;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }
}
