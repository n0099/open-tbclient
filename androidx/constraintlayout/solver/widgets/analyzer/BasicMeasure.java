package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BasicMeasure {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintWidgetContainer constraintWidgetContainer;
    public Measure mMeasure;
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    /* loaded from: classes.dex */
    public static class Measure {
        public static /* synthetic */ Interceptable $ic = null;
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2135836662, "Landroidx/constraintlayout/solver/widgets/analyzer/BasicMeasure$Measure;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2135836662, "Landroidx/constraintlayout/solver/widgets/analyzer/BasicMeasure$Measure;");
            }
        }

        public Measure() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidgetContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVariableDimensionsWidgets = new ArrayList<>();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, measurer, constraintWidget, i2)) == null) {
            this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
            this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
            this.mMeasure.horizontalDimension = constraintWidget.getWidth();
            this.mMeasure.verticalDimension = constraintWidget.getHeight();
            Measure measure = this.mMeasure;
            measure.measuredNeedsSolverPass = false;
            measure.measureStrategy = i2;
            boolean z = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z2 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
            boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
            if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            measurer.measure(constraintWidget, this.mMeasure);
            constraintWidget.setWidth(this.mMeasure.measuredWidth);
            constraintWidget.setHeight(this.mMeasure.measuredHeight);
            constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
            Measure measure2 = this.mMeasure;
            measure2.measureStrategy = Measure.SELF_DIMENSIONS;
            return measure2.measuredNeedsSolverPass;
        }
        return invokeLLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
        if (r8 != r10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r5.mDimensionRatio <= 0.0f) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, constraintWidgetContainer) == null) {
            int size = constraintWidgetContainer.mChildren.size();
            boolean optimizeFor = constraintWidgetContainer.optimizeFor(64);
            Measurer measurer = constraintWidgetContainer.getMeasurer();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i2);
                if (!(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !constraintWidget.isInVirtualLayout() && (!optimizeFor || (horizontalWidgetRun = constraintWidget.horizontalRun) == null || (verticalWidgetRun = constraintWidget.verticalRun) == null || !horizontalWidgetRun.dimension.resolved || !verticalWidgetRun.dimension.resolved)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                    boolean z = true;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean z2 = dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight != 1;
                    if (!z2 && constraintWidgetContainer.optimizeFor(1) && !(constraintWidget instanceof VirtualLayout)) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour4 && constraintWidget.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour2 != dimensionBehaviour4 && !constraintWidget.isInHorizontalChain()) {
                            z2 = true;
                        }
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour2 == dimensionBehaviour5 && constraintWidget.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour != dimensionBehaviour5 && !constraintWidget.isInHorizontalChain()) {
                            z2 = true;
                        }
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour != dimensionBehaviour6) {
                        }
                    }
                    z = z2;
                    if (!z) {
                        measure(measurer, constraintWidget, Measure.SELF_DIMENSIONS);
                        Metrics metrics = constraintWidgetContainer.mMetrics;
                        if (metrics != null) {
                            metrics.measuredWidgets++;
                        }
                    }
                }
            }
            measurer.didMeasures();
        }
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, this, constraintWidgetContainer, str, i2, i3) == null) {
            int minWidth = constraintWidgetContainer.getMinWidth();
            int minHeight = constraintWidgetContainer.getMinHeight();
            constraintWidgetContainer.setMinWidth(0);
            constraintWidgetContainer.setMinHeight(0);
            constraintWidgetContainer.setWidth(i2);
            constraintWidgetContainer.setHeight(i3);
            constraintWidgetContainer.setMinWidth(minWidth);
            constraintWidgetContainer.setMinHeight(minHeight);
            this.constraintWidgetContainer.layout();
        }
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        InterceptResult invokeCommon;
        boolean z;
        int i11;
        int i12;
        boolean z2;
        boolean z3;
        boolean z4;
        int i13;
        Measurer measurer;
        int i14;
        int i15;
        int i16;
        boolean z5;
        Metrics metrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{constraintWidgetContainer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)})) == null) {
            Measurer measurer2 = constraintWidgetContainer.getMeasurer();
            int size = constraintWidgetContainer.mChildren.size();
            int width = constraintWidgetContainer.getWidth();
            int height = constraintWidgetContainer.getHeight();
            boolean enabled = Optimizer.enabled(i2, 128);
            boolean z6 = enabled || Optimizer.enabled(i2, 64);
            if (z6) {
                for (int i17 = 0; i17 < size; i17++) {
                    ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i17);
                    boolean z7 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                    if ((constraintWidget.isInHorizontalChain() && z7) || ((constraintWidget.isInVerticalChain() && z7) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                        z6 = false;
                        break;
                    }
                }
            }
            if (z6 && (metrics = LinearSystem.sMetrics) != null) {
                metrics.measures++;
            }
            boolean z8 = z6 & ((i5 == 1073741824 && i7 == 1073741824) || enabled);
            if (z8) {
                int min = Math.min(constraintWidgetContainer.getMaxWidth(), i6);
                int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i8);
                if (i5 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                    constraintWidgetContainer.setWidth(min);
                    constraintWidgetContainer.invalidateGraph();
                }
                if (i7 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                    constraintWidgetContainer.setHeight(min2);
                    constraintWidgetContainer.invalidateGraph();
                }
                if (i5 == 1073741824 && i7 == 1073741824) {
                    z = constraintWidgetContainer.directMeasure(enabled);
                    i11 = 2;
                } else {
                    boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                    if (i5 == 1073741824) {
                        directMeasureSetup &= constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    if (i7 == 1073741824) {
                        z = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                        i11++;
                    } else {
                        z = directMeasureSetup;
                    }
                }
                if (z) {
                    constraintWidgetContainer.updateFromRuns(i5 == 1073741824, i7 == 1073741824);
                }
            } else {
                z = false;
                i11 = 0;
            }
            if (z && i11 == 2) {
                return 0L;
            }
            int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
            if (size > 0) {
                measureChildren(constraintWidgetContainer);
            }
            updateHierarchy(constraintWidgetContainer);
            int size2 = this.mVariableDimensionsWidgets.size();
            if (size > 0) {
                solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
            }
            if (size2 > 0) {
                boolean z9 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z10 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                int max = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int max2 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
                int i18 = 0;
                boolean z11 = false;
                while (i18 < size2) {
                    ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i18);
                    if (constraintWidget2 instanceof VirtualLayout) {
                        int width2 = constraintWidget2.getWidth();
                        i14 = optimizationLevel;
                        int height2 = constraintWidget2.getHeight();
                        i15 = width;
                        boolean measure = measure(measurer2, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | z11;
                        Metrics metrics2 = constraintWidgetContainer.mMetrics;
                        i16 = height;
                        if (metrics2 != null) {
                            metrics2.measuredMatchWidgets++;
                        }
                        int width3 = constraintWidget2.getWidth();
                        int height3 = constraintWidget2.getHeight();
                        if (width3 != width2) {
                            constraintWidget2.setWidth(width3);
                            if (z9 && constraintWidget2.getRight() > max) {
                                max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z5 = true;
                        } else {
                            z5 = measure;
                        }
                        if (height3 != height2) {
                            constraintWidget2.setHeight(height3);
                            if (z10 && constraintWidget2.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z5 = true;
                        }
                        z11 = z5 | ((VirtualLayout) constraintWidget2).needSolverPass();
                    } else {
                        i14 = optimizationLevel;
                        i15 = width;
                        i16 = height;
                    }
                    i18++;
                    optimizationLevel = i14;
                    width = i15;
                    height = i16;
                }
                int i19 = optimizationLevel;
                int i20 = width;
                int i21 = height;
                int i22 = 0;
                int i23 = 2;
                while (i22 < i23) {
                    int i24 = 0;
                    while (i24 < size2) {
                        ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i24);
                        if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((z8 && constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                            z4 = z8;
                            i13 = size2;
                            measurer = measurer2;
                        } else {
                            int width4 = constraintWidget3.getWidth();
                            int height4 = constraintWidget3.getHeight();
                            int baselineDistance = constraintWidget3.getBaselineDistance();
                            int i25 = Measure.TRY_GIVEN_DIMENSIONS;
                            z4 = z8;
                            if (i22 == 1) {
                                i25 = Measure.USE_GIVEN_DIMENSIONS;
                            }
                            boolean measure2 = measure(measurer2, constraintWidget3, i25) | z11;
                            Metrics metrics3 = constraintWidgetContainer.mMetrics;
                            i13 = size2;
                            measurer = measurer2;
                            if (metrics3 != null) {
                                metrics3.measuredMatchWidgets++;
                            }
                            int width5 = constraintWidget3.getWidth();
                            int height5 = constraintWidget3.getHeight();
                            if (width5 != width4) {
                                constraintWidget3.setWidth(width5);
                                if (z9 && constraintWidget3.getRight() > max) {
                                    max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                                measure2 = true;
                            }
                            if (height5 != height4) {
                                constraintWidget3.setHeight(height5);
                                if (z10 && constraintWidget3.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                                measure2 = true;
                            }
                            z11 = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? measure2 : true;
                        }
                        i24++;
                        size2 = i13;
                        measurer2 = measurer;
                        z8 = z4;
                    }
                    boolean z12 = z8;
                    int i26 = size2;
                    Measurer measurer3 = measurer2;
                    if (!z11) {
                        break;
                    }
                    solveLinearSystem(constraintWidgetContainer, "intermediate pass", i20, i21);
                    i22++;
                    measurer2 = measurer3;
                    z8 = z12;
                    i23 = 2;
                    z11 = false;
                    size2 = i26;
                }
                if (z11) {
                    solveLinearSystem(constraintWidgetContainer, "2nd pass", i20, i21);
                    if (constraintWidgetContainer.getWidth() < max) {
                        constraintWidgetContainer.setWidth(max);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintWidgetContainer.getHeight() < max2) {
                        constraintWidgetContainer.setHeight(max2);
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (z3) {
                        solveLinearSystem(constraintWidgetContainer, "3rd pass", i20, i21);
                    }
                }
                i12 = i19;
            } else {
                i12 = optimizationLevel;
            }
            constraintWidgetContainer.setOptimizationLevel(i12);
            return 0L;
        }
        return invokeCommon.longValue;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidgetContainer) == null) {
            this.mVariableDimensionsWidgets.clear();
            int size = constraintWidgetContainer.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i2);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mVariableDimensionsWidgets.add(constraintWidget);
                }
            }
            constraintWidgetContainer.invalidateGraph();
        }
    }
}
