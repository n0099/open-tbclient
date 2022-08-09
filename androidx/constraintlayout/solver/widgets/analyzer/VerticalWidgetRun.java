package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DependencyNode baseline;
    public DimensionDependency baselineDimension;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1895981096, "Landroidx/constraintlayout/solver/widgets/analyzer/VerticalWidgetRun$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1895981096, "Landroidx/constraintlayout/solver/widgets/analyzer/VerticalWidgetRun$1;");
                    return;
                }
            }
            int[] iArr = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ConstraintWidget) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.baselineDimension = null;
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        dependencyNode.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget.measured) {
                this.dimension.resolve(constraintWidget.getHeight());
            }
            if (!this.dimension.resolved) {
                this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
                if (this.widget.hasBaseline()) {
                    this.baselineDimension = new BaselineDimensionDependency(this);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.widget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                        int height = (parent2.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                        addTarget(this.start, parent2.verticalRun.start, this.widget.mTop.getMargin());
                        addTarget(this.end, parent2.verticalRun.end, -this.widget.mBottom.getMargin());
                        this.dimension.resolve(height);
                        return;
                    } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                        this.dimension.resolve(this.widget.getHeight());
                    }
                }
            } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.widget.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                addTarget(this.start, parent.verticalRun.start, this.widget.mTop.getMargin());
                addTarget(this.end, parent.verticalRun.end, -this.widget.mBottom.getMargin());
                return;
            }
            if (this.dimension.resolved) {
                ConstraintWidget constraintWidget2 = this.widget;
                if (constraintWidget2.measured) {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                    if (constraintAnchorArr[2].mTarget != null && constraintAnchorArr[3].mTarget != null) {
                        if (constraintWidget2.isInVerticalChain()) {
                            this.start.margin = this.widget.mListAnchors[2].getMargin();
                            this.end.margin = -this.widget.mListAnchors[3].getMargin();
                        } else {
                            DependencyNode target = getTarget(this.widget.mListAnchors[2]);
                            if (target != null) {
                                addTarget(this.start, target, this.widget.mListAnchors[2].getMargin());
                            }
                            DependencyNode target2 = getTarget(this.widget.mListAnchors[3]);
                            if (target2 != null) {
                                addTarget(this.end, target2, -this.widget.mListAnchors[3].getMargin());
                            }
                            this.start.delegateToWidgetRun = true;
                            this.end.delegateToWidgetRun = true;
                        }
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    ConstraintWidget constraintWidget3 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget3.mListAnchors;
                    if (constraintAnchorArr2[2].mTarget != null) {
                        DependencyNode target3 = getTarget(constraintAnchorArr2[2]);
                        if (target3 != null) {
                            addTarget(this.start, target3, this.widget.mListAnchors[2].getMargin());
                            addTarget(this.end, this.start, this.dimension.value);
                            if (this.widget.hasBaseline()) {
                                addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[3].mTarget != null) {
                        DependencyNode target4 = getTarget(constraintAnchorArr2[3]);
                        if (target4 != null) {
                            addTarget(this.end, target4, -this.widget.mListAnchors[3].getMargin());
                            addTarget(this.start, this.end, -this.dimension.value);
                        }
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[4].mTarget != null) {
                        DependencyNode target5 = getTarget(constraintAnchorArr2[4]);
                        if (target5 != null) {
                            addTarget(this.baseline, target5, 0);
                            addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if ((constraintWidget3 instanceof Helper) || constraintWidget3.getParent() == null || this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                        return;
                    } else {
                        addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                }
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget4 = this.widget;
                int i = constraintWidget4.mMatchConstraintDefaultHeight;
                if (i != 2) {
                    if (i == 3 && !constraintWidget4.isInVerticalChain()) {
                        ConstraintWidget constraintWidget5 = this.widget;
                        if (constraintWidget5.mMatchConstraintDefaultWidth != 3) {
                            DimensionDependency dimensionDependency = constraintWidget5.horizontalRun.dimension;
                            this.dimension.targets.add(dimensionDependency);
                            dimensionDependency.dependencies.add(this.dimension);
                            DimensionDependency dimensionDependency2 = this.dimension;
                            dimensionDependency2.delegateToWidgetRun = true;
                            dimensionDependency2.dependencies.add(this.start);
                            this.dimension.dependencies.add(this.end);
                        }
                    }
                } else {
                    ConstraintWidget parent3 = constraintWidget4.getParent();
                    if (parent3 != null) {
                        DimensionDependency dimensionDependency3 = parent3.verticalRun.dimension;
                        this.dimension.targets.add(dimensionDependency3);
                        dimensionDependency3.dependencies.add(this.dimension);
                        DimensionDependency dimensionDependency4 = this.dimension;
                        dimensionDependency4.delegateToWidgetRun = true;
                        dimensionDependency4.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                }
            } else {
                this.dimension.addDependency(this);
            }
            ConstraintWidget constraintWidget6 = this.widget;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget6.mListAnchors;
            if (constraintAnchorArr3[2].mTarget != null && constraintAnchorArr3[3].mTarget != null) {
                if (constraintWidget6.isInVerticalChain()) {
                    this.start.margin = this.widget.mListAnchors[2].getMargin();
                    this.end.margin = -this.widget.mListAnchors[3].getMargin();
                } else {
                    DependencyNode target6 = getTarget(this.widget.mListAnchors[2]);
                    DependencyNode target7 = getTarget(this.widget.mListAnchors[3]);
                    target6.addDependency(this);
                    target7.addDependency(this);
                    this.mRunType = WidgetRun.RunType.CENTER;
                }
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
            } else {
                ConstraintWidget constraintWidget7 = this.widget;
                ConstraintAnchor[] constraintAnchorArr4 = constraintWidget7.mListAnchors;
                if (constraintAnchorArr4[2].mTarget != null) {
                    DependencyNode target8 = getTarget(constraintAnchorArr4[2]);
                    if (target8 != null) {
                        addTarget(this.start, target8, this.widget.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, 1, this.dimension);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, 1, this.baselineDimension);
                        }
                        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f) {
                            HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                            if (horizontalWidgetRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                horizontalWidgetRun.dimension.dependencies.add(this.dimension);
                                this.dimension.targets.add(this.widget.horizontalRun.dimension);
                                this.dimension.updateDelegate = this;
                            }
                        }
                    }
                } else if (constraintAnchorArr4[3].mTarget != null) {
                    DependencyNode target9 = getTarget(constraintAnchorArr4[3]);
                    if (target9 != null) {
                        addTarget(this.end, target9, -this.widget.mListAnchors[3].getMargin());
                        addTarget(this.start, this.end, -1, this.dimension);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, 1, this.baselineDimension);
                        }
                    }
                } else if (constraintAnchorArr4[4].mTarget != null) {
                    DependencyNode target10 = getTarget(constraintAnchorArr4[4]);
                    if (target10 != null) {
                        addTarget(this.baseline, target10, 0);
                        addTarget(this.start, this.baseline, -1, this.baselineDimension);
                        addTarget(this.end, this.start, 1, this.dimension);
                    }
                } else if (!(constraintWidget7 instanceof Helper) && constraintWidget7.getParent() != null) {
                    addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.widget.horizontalRun;
                        if (horizontalWidgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            horizontalWidgetRun2.dimension.dependencies.add(this.dimension);
                            this.dimension.targets.add(this.widget.horizontalRun.dimension);
                            this.dimension.updateDelegate = this;
                        }
                    }
                }
            }
            if (this.dimension.targets.size() == 0) {
                this.dimension.readyToSolve = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DependencyNode dependencyNode = this.start;
            if (dependencyNode.resolved) {
                this.widget.setY(dependencyNode.value);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.runGroup = null;
            this.start.clear();
            this.end.clear();
            this.baseline.clear();
            this.dimension.clear();
            this.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.resolved = false;
            this.start.clear();
            this.start.resolved = false;
            this.end.clear();
            this.end.resolved = false;
            this.baseline.clear();
            this.baseline.resolved = false;
            this.dimension.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "VerticalRun " + this.widget.getDebugName();
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        DimensionDependency dimensionDependency;
        float f;
        float dimensionRatio;
        float f2;
        int i;
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dependency) == null) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
            if (i2 == 1) {
                updateRunStart(dependency);
            } else if (i2 == 2) {
                updateRunEnd(dependency);
            } else if (i2 == 3) {
                ConstraintWidget constraintWidget2 = this.widget;
                updateRunCenter(dependency, constraintWidget2.mTop, constraintWidget2.mBottom, 1);
                return;
            }
            DimensionDependency dimensionDependency2 = this.dimension;
            if (dimensionDependency2.readyToSolve && !dimensionDependency2.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget3 = this.widget;
                int i3 = constraintWidget3.mMatchConstraintDefaultHeight;
                if (i3 != 2) {
                    if (i3 == 3 && constraintWidget3.horizontalRun.dimension.resolved) {
                        int dimensionRatioSide = constraintWidget3.getDimensionRatioSide();
                        if (dimensionRatioSide == -1) {
                            ConstraintWidget constraintWidget4 = this.widget;
                            f = constraintWidget4.horizontalRun.dimension.value;
                            dimensionRatio = constraintWidget4.getDimensionRatio();
                        } else if (dimensionRatioSide == 0) {
                            f2 = constraintWidget.horizontalRun.dimension.value * this.widget.getDimensionRatio();
                            i = (int) (f2 + 0.5f);
                            this.dimension.resolve(i);
                        } else if (dimensionRatioSide == 1) {
                            ConstraintWidget constraintWidget5 = this.widget;
                            f = constraintWidget5.horizontalRun.dimension.value;
                            dimensionRatio = constraintWidget5.getDimensionRatio();
                        } else {
                            i = 0;
                            this.dimension.resolve(i);
                        }
                        f2 = f / dimensionRatio;
                        i = (int) (f2 + 0.5f);
                        this.dimension.resolve(i);
                    }
                } else {
                    ConstraintWidget parent = constraintWidget3.getParent();
                    if (parent != null) {
                        if (parent.verticalRun.dimension.resolved) {
                            this.dimension.resolve((int) ((dimensionDependency.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
                        }
                    }
                }
            }
            DependencyNode dependencyNode = this.start;
            if (dependencyNode.readyToSolve) {
                DependencyNode dependencyNode2 = this.end;
                if (dependencyNode2.readyToSolve) {
                    if (dependencyNode.resolved && dependencyNode2.resolved && this.dimension.resolved) {
                        return;
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.widget;
                        if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInVerticalChain()) {
                            int i4 = this.start.targets.get(0).value;
                            DependencyNode dependencyNode3 = this.start;
                            int i5 = i4 + dependencyNode3.margin;
                            int i6 = this.end.targets.get(0).value + this.end.margin;
                            dependencyNode3.resolve(i5);
                            this.end.resolve(i6);
                            this.dimension.resolve(i6 - i5);
                            return;
                        }
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        int i7 = (this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin);
                        DimensionDependency dimensionDependency3 = this.dimension;
                        int i8 = dimensionDependency3.wrapValue;
                        if (i7 < i8) {
                            dimensionDependency3.resolve(i7);
                        } else {
                            dimensionDependency3.resolve(i8);
                        }
                    }
                    if (this.dimension.resolved && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        DependencyNode dependencyNode4 = this.start.targets.get(0);
                        DependencyNode dependencyNode5 = this.end.targets.get(0);
                        int i9 = dependencyNode4.value + this.start.margin;
                        int i10 = dependencyNode5.value + this.end.margin;
                        float verticalBiasPercent = this.widget.getVerticalBiasPercent();
                        if (dependencyNode4 == dependencyNode5) {
                            i9 = dependencyNode4.value;
                            i10 = dependencyNode5.value;
                            verticalBiasPercent = 0.5f;
                        }
                        this.start.resolve((int) (i9 + 0.5f + (((i10 - i9) - this.dimension.value) * verticalBiasPercent)));
                        this.end.resolve(this.start.value + this.dimension.value);
                    }
                }
            }
        }
    }
}
