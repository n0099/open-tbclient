package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_GRAPH = false;
    public static final boolean DEBUG_LAYOUT = false;
    public static final int MAX_ITERATIONS = 8;
    public static int mycounter;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ConstraintAnchor> horizontalWrapMax;
    public WeakReference<ConstraintAnchor> horizontalWrapMin;
    public BasicMeasure mBasicMeasureSolver;
    public int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    public boolean mHeightMeasuredTooSmall;
    public ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    public boolean mIsRtl;
    public BasicMeasure.Measure mMeasure;
    public BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    public int mOptimizationLevel;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public boolean mSkipSolver;
    public LinearSystem mSystem;
    public ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    public WeakReference<ConstraintAnchor> verticalWrapMax;
    public WeakReference<ConstraintAnchor> verticalWrapMin;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2138220151, "Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2138220151, "Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;");
        }
    }

    public ConstraintWidgetContainer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, constraintWidget) == null) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
            this.mHorizontalChainsSize++;
        }
    }

    private void addMaxWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, constraintAnchor, solverVariable) == null) {
            this.mSystem.addGreaterThan(solverVariable, this.mSystem.createObjectVariable(constraintAnchor), 0, 5);
        }
    }

    private void addMinWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, constraintAnchor, solverVariable) == null) {
            this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
        }
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, constraintWidget) == null) {
            int i2 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mVerticalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
            this.mVerticalChainsSize++;
        }
    }

    private void resetChains() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mHorizontalChainsSize = 0;
            this.mVerticalChainsSize = 0;
        }
    }

    public void addChain(ConstraintWidget constraintWidget, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, constraintWidget, i2) == null) {
            if (i2 == 0) {
                addHorizontalChain(constraintWidget);
            } else if (i2 == 1) {
                addVerticalChain(constraintWidget);
            }
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearSystem)) == null) {
            boolean optimizeFor = optimizeFor(64);
            addToSolver(linearSystem, optimizeFor);
            int size = this.mChildren.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
                constraintWidget.setInBarrier(0, false);
                constraintWidget.setInBarrier(1, false);
                if (constraintWidget instanceof Barrier) {
                    z = true;
                }
            }
            if (z) {
                for (int i3 = 0; i3 < size; i3++) {
                    ConstraintWidget constraintWidget2 = this.mChildren.get(i3);
                    if (constraintWidget2 instanceof Barrier) {
                        ((Barrier) constraintWidget2).markWidgets();
                    }
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget3 = this.mChildren.get(i4);
                if (constraintWidget3.addFirst()) {
                    constraintWidget3.addToSolver(linearSystem, optimizeFor);
                }
            }
            if (LinearSystem.USE_DEPENDENCY_ORDERING) {
                HashSet<ConstraintWidget> hashSet = new HashSet<>();
                for (int i5 = 0; i5 < size; i5++) {
                    ConstraintWidget constraintWidget4 = this.mChildren.get(i5);
                    if (!constraintWidget4.addFirst()) {
                        hashSet.add(constraintWidget4);
                    }
                }
                addChildrenToSolverByDependency(this, linearSystem, hashSet, getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
                Iterator<ConstraintWidget> it = hashSet.iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    Optimizer.checkMatchParent(this, linearSystem, next);
                    next.addToSolver(linearSystem, optimizeFor);
                }
            } else {
                for (int i6 = 0; i6 < size; i6++) {
                    ConstraintWidget constraintWidget5 = this.mChildren.get(i6);
                    if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        }
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        }
                        constraintWidget5.addToSolver(linearSystem, optimizeFor);
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour);
                        }
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour2);
                        }
                    } else {
                        Optimizer.checkMatchParent(this, linearSystem, constraintWidget5);
                        if (!constraintWidget5.addFirst()) {
                            constraintWidget5.addToSolver(linearSystem, optimizeFor);
                        }
                    }
                }
            }
            if (this.mHorizontalChainsSize > 0) {
                Chain.applyChainConstraints(this, linearSystem, null, 0);
            }
            if (this.mVerticalChainsSize > 0) {
                Chain.applyChainConstraints(this, linearSystem, null, 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraintAnchor) == null) {
            WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMax;
            if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) {
                this.horizontalWrapMax = new WeakReference<>(constraintAnchor);
            }
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, constraintAnchor) == null) {
            WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMin;
            if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) {
                this.horizontalWrapMin = new WeakReference<>(constraintAnchor);
            }
        }
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, constraintAnchor) == null) {
            WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMax;
            if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) {
                this.verticalWrapMax = new WeakReference<>(constraintAnchor);
            }
        }
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, constraintAnchor) == null) {
            WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
            if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) {
                this.verticalWrapMin = new WeakReference<>(constraintAnchor);
            }
        }
    }

    public void defineTerminalWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
        }
    }

    public boolean directMeasure(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? this.mDependencyGraph.directMeasure(z) : invokeZ.booleanValue;
    }

    public boolean directMeasureSetup(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) ? this.mDependencyGraph.directMeasureSetup(z) : invokeZ.booleanValue;
    }

    public boolean directMeasureWithOrientation(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? this.mDependencyGraph.directMeasureWithOrientation(z, i2) : invokeCommon.booleanValue;
    }

    public void fillMetrics(Metrics metrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, metrics) == null) {
            this.mMetrics = metrics;
            this.mSystem.fillMetrics(metrics);
        }
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList<Guideline> arrayList = new ArrayList<>();
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
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

    public BasicMeasure.Measurer getMeasurer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mMeasurer : (BasicMeasure.Measurer) invokeV.objValue;
    }

    public int getOptimizationLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mOptimizationLevel : invokeV.intValue;
    }

    public LinearSystem getSystem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSystem : (LinearSystem) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? ConstraintLayout.TAG : (String) invokeV.objValue;
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ArrayList<Guideline> arrayList = new ArrayList<>();
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
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

    public boolean handlesInternalConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void invalidateGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mDependencyGraph.invalidateGraph();
        }
    }

    public void invalidateMeasures() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.mDependencyGraph.invalidateMeasures();
        }
    }

    public boolean isHeightMeasuredTooSmall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mHeightMeasuredTooSmall : invokeV.booleanValue;
    }

    public boolean isRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsRtl : invokeV.booleanValue;
    }

    public boolean isWidthMeasuredTooSmall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mWidthMeasuredTooSmall : invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        ?? r6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.mX = 0;
            this.mY = 0;
            this.mWidthMeasuredTooSmall = false;
            this.mHeightMeasuredTooSmall = false;
            int size = this.mChildren.size();
            int max = Math.max(0, getWidth());
            int max2 = Math.max(0, getHeight());
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
            Metrics metrics = this.mMetrics;
            if (metrics != null) {
                metrics.layouts++;
            }
            if (Optimizer.enabled(this.mOptimizationLevel, 1)) {
                Direct.solvingPass(this, getMeasurer());
                for (int i4 = 0; i4 < size; i4++) {
                    ConstraintWidget constraintWidget = this.mChildren.get(i4);
                    if (constraintWidget.isMeasureRequested() && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInVirtualLayout()) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidget.getDimensionBehaviour(0);
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidget.getDimensionBehaviour(1);
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!(dimensionBehaviour4 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour5 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultHeight != 1)) {
                            measure(constraintWidget, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                    }
                }
            }
            if (size <= 2 || !((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && Optimizer.enabled(this.mOptimizationLevel, 1024) && Grouping.simpleSolvingPass(this, getMeasurer()))) {
                i2 = max2;
                i3 = max;
                z = false;
            } else {
                if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (max < getWidth() && max > 0) {
                        setWidth(max);
                        this.mWidthMeasuredTooSmall = true;
                    } else {
                        max = getWidth();
                    }
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (max2 < getHeight() && max2 > 0) {
                        setHeight(max2);
                        this.mHeightMeasuredTooSmall = true;
                    } else {
                        max2 = getHeight();
                    }
                }
                i2 = max2;
                i3 = max;
                z = true;
            }
            boolean z3 = optimizeFor(64) || optimizeFor(128);
            LinearSystem linearSystem = this.mSystem;
            linearSystem.graphOptimizer = false;
            linearSystem.newgraphOptimizer = false;
            if (this.mOptimizationLevel != 0 && z3) {
                linearSystem.newgraphOptimizer = true;
            }
            ArrayList<ConstraintWidget> arrayList = this.mChildren;
            boolean z4 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            resetChains();
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i5);
                if (constraintWidget2 instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget2).layout();
                }
            }
            boolean optimizeFor = optimizeFor(64);
            boolean z5 = z;
            int i6 = 0;
            boolean z6 = true;
            while (z6) {
                int i7 = i6 + 1;
                try {
                    this.mSystem.reset();
                    resetChains();
                    createObjectVariables(this.mSystem);
                    for (int i8 = 0; i8 < size; i8++) {
                        this.mChildren.get(i8).createObjectVariables(this.mSystem);
                    }
                    z6 = addChildrenToSolver(this.mSystem);
                    if (this.verticalWrapMin != null && this.verticalWrapMin.get() != null) {
                        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));
                        this.verticalWrapMin = null;
                    }
                    if (this.verticalWrapMax != null && this.verticalWrapMax.get() != null) {
                        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));
                        this.verticalWrapMax = null;
                    }
                    if (this.horizontalWrapMin != null && this.horizontalWrapMin.get() != null) {
                        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));
                        this.horizontalWrapMin = null;
                    }
                    if (this.horizontalWrapMax != null && this.horizontalWrapMax.get() != null) {
                        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));
                        this.horizontalWrapMax = null;
                    }
                    if (z6) {
                        this.mSystem.minimize();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("EXCEPTION : " + e2);
                }
                if (z6) {
                    updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                } else {
                    updateFromSolver(this.mSystem, optimizeFor);
                    for (int i9 = 0; i9 < size; i9++) {
                        this.mChildren.get(i9).updateFromSolver(this.mSystem, optimizeFor);
                    }
                }
                if (z4 && i7 < 8 && Optimizer.flags[2]) {
                    int i10 = 0;
                    int i11 = 0;
                    for (int i12 = 0; i12 < size; i12++) {
                        ConstraintWidget constraintWidget3 = this.mChildren.get(i12);
                        i10 = Math.max(i10, constraintWidget3.mX + constraintWidget3.getWidth());
                        i11 = Math.max(i11, constraintWidget3.mY + constraintWidget3.getHeight());
                    }
                    int max3 = Math.max(this.mMinWidth, i10);
                    int max4 = Math.max(this.mMinHeight, i11);
                    if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getWidth() >= max3) {
                        z2 = false;
                    } else {
                        setWidth(max3);
                        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        z2 = true;
                        z5 = true;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < max4) {
                        setHeight(max4);
                        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        z2 = true;
                        z5 = true;
                    }
                } else {
                    z2 = false;
                }
                int max5 = Math.max(this.mMinWidth, getWidth());
                if (max5 > getWidth()) {
                    setWidth(max5);
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    z2 = true;
                    z5 = true;
                }
                int max6 = Math.max(this.mMinHeight, getHeight());
                if (max6 > getHeight()) {
                    setHeight(max6);
                    r6 = 1;
                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                    z2 = true;
                    z5 = true;
                } else {
                    r6 = 1;
                }
                if (!z5) {
                    if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && i3 > 0 && getWidth() > i3) {
                        this.mWidthMeasuredTooSmall = r6;
                        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        setWidth(i3);
                        z2 = true;
                        z5 = true;
                    }
                    if (this.mListDimensionBehaviors[r6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && i2 > 0 && getHeight() > i2) {
                        this.mHeightMeasuredTooSmall = r6;
                        this.mListDimensionBehaviors[r6] = ConstraintWidget.DimensionBehaviour.FIXED;
                        setHeight(i2);
                        z5 = true;
                        z6 = true;
                        i6 = i7;
                    }
                }
                z6 = z2;
                i6 = i7;
            }
            this.mChildren = arrayList;
            if (z5) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                dimensionBehaviourArr2[0] = dimensionBehaviour3;
                dimensionBehaviourArr2[1] = dimensionBehaviour2;
            }
            resetSolverVariables(this.mSystem.getCache());
        }
    }

    public long measure(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)})) == null) {
            this.mPaddingLeft = i9;
            this.mPaddingTop = i10;
            return this.mBasicMeasureSolver.solverMeasure(this, i2, i9, i10, i3, i4, i5, i6, i7, i8);
        }
        return invokeCommon.longValue;
    }

    public boolean optimizeFor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? (this.mOptimizationLevel & i2) == i2 : invokeI.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mSystem.reset();
            this.mPaddingLeft = 0;
            this.mPaddingRight = 0;
            this.mPaddingTop = 0;
            this.mPaddingBottom = 0;
            this.mSkipSolver = false;
            super.reset();
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, measurer) == null) {
            this.mMeasurer = measurer;
            this.mDependencyGraph.setMeasurer(measurer);
        }
    }

    public void setOptimizationLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mOptimizationLevel = i2;
            LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
        }
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i2, i3, i4, i5) == null) {
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
        }
    }

    public void setRtl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mIsRtl = z;
        }
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, linearSystem, zArr) == null) {
            zArr[2] = false;
            boolean optimizeFor = optimizeFor(64);
            updateFromSolver(linearSystem, optimizeFor);
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mChildren.get(i2).updateFromSolver(linearSystem, optimizeFor);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.updateFromRuns(z, z2);
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mChildren.get(i2).updateFromRuns(z, z2);
            }
        }
    }

    public void updateHierarchy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mBasicMeasureSolver.updateHierarchy(this);
        }
    }

    public static boolean measure(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i2) {
        InterceptResult invokeLLLI;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65545, null, constraintWidget, measurer, measure, i2)) == null) {
            if (measurer == null) {
                return false;
            }
            measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
            measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
            measure.horizontalDimension = constraintWidget.getWidth();
            measure.verticalDimension = constraintWidget.getHeight();
            measure.measuredNeedsSolverPass = false;
            measure.measureStrategy = i2;
            boolean z = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z2 = measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
            boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
            if (z && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z3) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z = false;
            }
            if (z2 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z2 = false;
            }
            if (constraintWidget.isResolvedHorizontally()) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                z = false;
            }
            if (constraintWidget.isResolvedVertically()) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                z2 = false;
            }
            if (z3) {
                if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z2) {
                    if (measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                        i4 = measure.verticalDimension;
                    } else {
                        measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.measure(constraintWidget, measure);
                        i4 = measure.measuredHeight;
                    }
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                    int i5 = constraintWidget.mDimensionRatioSide;
                    if (i5 != 0 && i5 != -1) {
                        measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() / i4);
                    } else {
                        measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * i4);
                    }
                }
            }
            if (z4) {
                if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z) {
                    if (measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                        i3 = measure.horizontalDimension;
                    } else {
                        measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.measure(constraintWidget, measure);
                        i3 = measure.measuredWidth;
                    }
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                    int i6 = constraintWidget.mDimensionRatioSide;
                    if (i6 != 0 && i6 != -1) {
                        measure.verticalDimension = (int) (i3 * constraintWidget.getDimensionRatio());
                    } else {
                        measure.verticalDimension = (int) (i3 / constraintWidget.getDimensionRatio());
                    }
                }
            }
            measurer.measure(constraintWidget, measure);
            constraintWidget.setWidth(measure.measuredWidth);
            constraintWidget.setHeight(measure.measuredHeight);
            constraintWidget.setHasBaseline(measure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(measure.measuredBaseline);
            measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
            return measure.measuredNeedsSolverPass;
        }
        return invokeLLLI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintWidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintWidgetContainer(int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintWidgetContainer(String str, int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(str);
    }
}
