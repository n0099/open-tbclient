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
public class HorizontalWidgetRun extends WidgetRun {
    public static /* synthetic */ Interceptable $ic;
    public static int[] tempDimensions;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1763925190, "Landroidx/constraintlayout/solver/widgets/analyzer/HorizontalWidgetRun$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1763925190, "Landroidx/constraintlayout/solver/widgets/analyzer/HorizontalWidgetRun$1;");
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1744850355, "Landroidx/constraintlayout/solver/widgets/analyzer/HorizontalWidgetRun;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1744850355, "Landroidx/constraintlayout/solver/widgets/analyzer/HorizontalWidgetRun;");
                return;
            }
        }
        tempDimensions = new int[2];
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DependencyNode dependencyNode = this.start;
            if (dependencyNode.resolved) {
                this.widget.setX(dependencyNode.value);
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
            this.dimension.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "HorizontalRun " + this.widget.getDebugName();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ConstraintWidget) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Integer.valueOf(i5)}) == null) {
            int i6 = i2 - i;
            int i7 = i4 - i3;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 == 1) {
                        iArr[0] = i6;
                        iArr[1] = (int) ((i6 * f) + 0.5f);
                        return;
                    }
                    return;
                }
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            }
            int i8 = (int) ((i7 * f) + 0.5f);
            int i9 = (int) ((i6 / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget.measured) {
                this.dimension.resolve(constraintWidget.getWidth());
            }
            if (!this.dimension.resolved) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
                this.dimensionBehavior = horizontalDimensionBehaviour;
                if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                        int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                        addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                        addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                        this.dimension.resolve(width);
                        return;
                    } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                        this.dimension.resolve(this.widget.getWidth());
                    }
                }
            } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
                addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
            if (this.dimension.resolved) {
                ConstraintWidget constraintWidget2 = this.widget;
                if (constraintWidget2.measured) {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                    if (constraintAnchorArr[0].mTarget != null && constraintAnchorArr[1].mTarget != null) {
                        if (constraintWidget2.isInHorizontalChain()) {
                            this.start.margin = this.widget.mListAnchors[0].getMargin();
                            this.end.margin = -this.widget.mListAnchors[1].getMargin();
                            return;
                        }
                        DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                        if (target != null) {
                            addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                        return;
                    }
                    ConstraintWidget constraintWidget3 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget3.mListAnchors;
                    if (constraintAnchorArr2[0].mTarget != null) {
                        DependencyNode target3 = getTarget(constraintAnchorArr2[0]);
                        if (target3 != null) {
                            addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[1].mTarget != null) {
                        DependencyNode target4 = getTarget(constraintAnchorArr2[1]);
                        if (target4 != null) {
                            addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                            addTarget(this.start, this.end, -this.dimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget3 instanceof Helper) && constraintWidget3.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget4 = this.widget;
                int i = constraintWidget4.mMatchConstraintDefaultWidth;
                if (i != 2) {
                    if (i == 3) {
                        if (constraintWidget4.mMatchConstraintDefaultHeight == 3) {
                            this.start.updateDelegate = this;
                            this.end.updateDelegate = this;
                            VerticalWidgetRun verticalWidgetRun = constraintWidget4.verticalRun;
                            verticalWidgetRun.start.updateDelegate = this;
                            verticalWidgetRun.end.updateDelegate = this;
                            this.dimension.updateDelegate = this;
                            if (constraintWidget4.isInVerticalChain()) {
                                this.dimension.targets.add(this.widget.verticalRun.dimension);
                                this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                                VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                                verticalWidgetRun2.dimension.updateDelegate = this;
                                this.dimension.targets.add(verticalWidgetRun2.start);
                                this.dimension.targets.add(this.widget.verticalRun.end);
                                this.widget.verticalRun.start.dependencies.add(this.dimension);
                                this.widget.verticalRun.end.dependencies.add(this.dimension);
                            } else if (this.widget.isInHorizontalChain()) {
                                this.widget.verticalRun.dimension.targets.add(this.dimension);
                                this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                            } else {
                                this.widget.verticalRun.dimension.targets.add(this.dimension);
                            }
                        } else {
                            DimensionDependency dimensionDependency = constraintWidget4.verticalRun.dimension;
                            this.dimension.targets.add(dimensionDependency);
                            dimensionDependency.dependencies.add(this.dimension);
                            this.widget.verticalRun.start.dependencies.add(this.dimension);
                            this.widget.verticalRun.end.dependencies.add(this.dimension);
                            DimensionDependency dimensionDependency2 = this.dimension;
                            dimensionDependency2.delegateToWidgetRun = true;
                            dimensionDependency2.dependencies.add(this.start);
                            this.dimension.dependencies.add(this.end);
                            this.start.targets.add(this.dimension);
                            this.end.targets.add(this.dimension);
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
            }
            ConstraintWidget constraintWidget5 = this.widget;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget5.mListAnchors;
            if (constraintAnchorArr3[0].mTarget != null && constraintAnchorArr3[1].mTarget != null) {
                if (constraintWidget5.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                }
                DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
                DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
                target5.addDependency(this);
                target6.addDependency(this);
                this.mRunType = WidgetRun.RunType.CENTER;
                return;
            }
            ConstraintWidget constraintWidget6 = this.widget;
            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget6.mListAnchors;
            if (constraintAnchorArr4[0].mTarget != null) {
                DependencyNode target7 = getTarget(constraintAnchorArr4[0]);
                if (target7 != null) {
                    addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (constraintAnchorArr4[1].mTarget != null) {
                DependencyNode target8 = getTarget(constraintAnchorArr4[1]);
                if (target8 != null) {
                    addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                }
            } else if (!(constraintWidget6 instanceof Helper) && constraintWidget6.getParent() != null) {
                addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                addTarget(this.end, this.start, 1, this.dimension);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x02ca, code lost:
        if (r14 != 1) goto L133;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        DimensionDependency dimensionDependency;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        float f;
        float dimensionRatio;
        float f2;
        int i;
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dependency) == null) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        ConstraintWidget constraintWidget2 = this.widget;
                        updateRunCenter(dependency, constraintWidget2.mLeft, constraintWidget2.mRight, 0);
                        return;
                    }
                } else {
                    updateRunEnd(dependency);
                }
            } else {
                updateRunStart(dependency);
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget3 = this.widget;
                int i3 = constraintWidget3.mMatchConstraintDefaultWidth;
                if (i3 != 2) {
                    if (i3 == 3) {
                        int i4 = constraintWidget3.mMatchConstraintDefaultHeight;
                        if (i4 != 0 && i4 != 3) {
                            int dimensionRatioSide = constraintWidget3.getDimensionRatioSide();
                            if (dimensionRatioSide != -1) {
                                if (dimensionRatioSide != 0) {
                                    if (dimensionRatioSide != 1) {
                                        i = 0;
                                        this.dimension.resolve(i);
                                    } else {
                                        ConstraintWidget constraintWidget4 = this.widget;
                                        f = constraintWidget4.verticalRun.dimension.value;
                                        dimensionRatio = constraintWidget4.getDimensionRatio();
                                    }
                                } else {
                                    f2 = constraintWidget.verticalRun.dimension.value / this.widget.getDimensionRatio();
                                    i = (int) (f2 + 0.5f);
                                    this.dimension.resolve(i);
                                }
                            } else {
                                ConstraintWidget constraintWidget5 = this.widget;
                                f = constraintWidget5.verticalRun.dimension.value;
                                dimensionRatio = constraintWidget5.getDimensionRatio();
                            }
                            f2 = f * dimensionRatio;
                            i = (int) (f2 + 0.5f);
                            this.dimension.resolve(i);
                        } else {
                            ConstraintWidget constraintWidget6 = this.widget;
                            VerticalWidgetRun verticalWidgetRun = constraintWidget6.verticalRun;
                            DependencyNode dependencyNode = verticalWidgetRun.start;
                            DependencyNode dependencyNode2 = verticalWidgetRun.end;
                            if (constraintWidget6.mLeft.mTarget != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (this.widget.mTop.mTarget != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (this.widget.mRight.mTarget != null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (this.widget.mBottom.mTarget != null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            int dimensionRatioSide2 = this.widget.getDimensionRatioSide();
                            if (z && z2 && z3 && z4) {
                                float dimensionRatio2 = this.widget.getDimensionRatio();
                                if (dependencyNode.resolved && dependencyNode2.resolved) {
                                    DependencyNode dependencyNode3 = this.start;
                                    if (dependencyNode3.readyToSolve && this.end.readyToSolve) {
                                        computeInsetRatio(tempDimensions, dependencyNode3.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                        this.dimension.resolve(tempDimensions[0]);
                                        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                        return;
                                    }
                                    return;
                                }
                                DependencyNode dependencyNode4 = this.start;
                                if (dependencyNode4.resolved) {
                                    DependencyNode dependencyNode5 = this.end;
                                    if (dependencyNode5.resolved) {
                                        if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                            computeInsetRatio(tempDimensions, dependencyNode4.value + dependencyNode4.margin, dependencyNode5.value - dependencyNode5.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                            this.dimension.resolve(tempDimensions[0]);
                                            this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                DependencyNode dependencyNode6 = this.start;
                                if (dependencyNode6.readyToSolve && this.end.readyToSolve && dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                    computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                    this.dimension.resolve(tempDimensions[0]);
                                    this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                } else {
                                    return;
                                }
                            } else if (z && z3) {
                                if (this.start.readyToSolve && this.end.readyToSolve) {
                                    float dimensionRatio3 = this.widget.getDimensionRatio();
                                    int i5 = this.start.targets.get(0).value + this.start.margin;
                                    int i6 = this.end.targets.get(0).value - this.end.margin;
                                    if (dimensionRatioSide2 != -1 && dimensionRatioSide2 != 0) {
                                        if (dimensionRatioSide2 == 1) {
                                            int limitedDimension = getLimitedDimension(i6 - i5, 0);
                                            int i7 = (int) ((limitedDimension / dimensionRatio3) + 0.5f);
                                            int limitedDimension2 = getLimitedDimension(i7, 1);
                                            if (i7 != limitedDimension2) {
                                                limitedDimension = (int) ((limitedDimension2 * dimensionRatio3) + 0.5f);
                                            }
                                            this.dimension.resolve(limitedDimension);
                                            this.widget.verticalRun.dimension.resolve(limitedDimension2);
                                        }
                                    } else {
                                        int limitedDimension3 = getLimitedDimension(i6 - i5, 0);
                                        int i8 = (int) ((limitedDimension3 * dimensionRatio3) + 0.5f);
                                        int limitedDimension4 = getLimitedDimension(i8, 1);
                                        if (i8 != limitedDimension4) {
                                            limitedDimension3 = (int) ((limitedDimension4 / dimensionRatio3) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension3);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension4);
                                    }
                                } else {
                                    return;
                                }
                            } else if (z2 && z4) {
                                if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                    float dimensionRatio4 = this.widget.getDimensionRatio();
                                    int i9 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                                    int i10 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                                    if (dimensionRatioSide2 != -1) {
                                        if (dimensionRatioSide2 == 0) {
                                            int limitedDimension5 = getLimitedDimension(i10 - i9, 1);
                                            int i11 = (int) ((limitedDimension5 * dimensionRatio4) + 0.5f);
                                            int limitedDimension6 = getLimitedDimension(i11, 0);
                                            if (i11 != limitedDimension6) {
                                                limitedDimension5 = (int) ((limitedDimension6 / dimensionRatio4) + 0.5f);
                                            }
                                            this.dimension.resolve(limitedDimension6);
                                            this.widget.verticalRun.dimension.resolve(limitedDimension5);
                                        }
                                    }
                                    int limitedDimension7 = getLimitedDimension(i10 - i9, 1);
                                    int i12 = (int) ((limitedDimension7 / dimensionRatio4) + 0.5f);
                                    int limitedDimension8 = getLimitedDimension(i12, 0);
                                    if (i12 != limitedDimension8) {
                                        limitedDimension7 = (int) ((limitedDimension8 * dimensionRatio4) + 0.5f);
                                    }
                                    this.dimension.resolve(limitedDimension8);
                                    this.widget.verticalRun.dimension.resolve(limitedDimension7);
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    ConstraintWidget parent = constraintWidget3.getParent();
                    if (parent != null) {
                        if (parent.horizontalRun.dimension.resolved) {
                            this.dimension.resolve((int) ((dimensionDependency.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                        }
                    }
                }
            }
            DependencyNode dependencyNode7 = this.start;
            if (dependencyNode7.readyToSolve) {
                DependencyNode dependencyNode8 = this.end;
                if (dependencyNode8.readyToSolve) {
                    if (dependencyNode7.resolved && dependencyNode8.resolved && this.dimension.resolved) {
                        return;
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget7 = this.widget;
                        if (constraintWidget7.mMatchConstraintDefaultWidth == 0 && !constraintWidget7.isInHorizontalChain()) {
                            int i13 = this.start.targets.get(0).value;
                            DependencyNode dependencyNode9 = this.start;
                            int i14 = i13 + dependencyNode9.margin;
                            int i15 = this.end.targets.get(0).value + this.end.margin;
                            dependencyNode9.resolve(i14);
                            this.end.resolve(i15);
                            this.dimension.resolve(i15 - i14);
                            return;
                        }
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                        ConstraintWidget constraintWidget8 = this.widget;
                        int i16 = constraintWidget8.mMatchConstraintMaxWidth;
                        int max = Math.max(constraintWidget8.mMatchConstraintMinWidth, min);
                        if (i16 > 0) {
                            max = Math.min(i16, max);
                        }
                        this.dimension.resolve(max);
                    }
                    if (!this.dimension.resolved) {
                        return;
                    }
                    DependencyNode dependencyNode10 = this.start.targets.get(0);
                    DependencyNode dependencyNode11 = this.end.targets.get(0);
                    int i17 = dependencyNode10.value + this.start.margin;
                    int i18 = dependencyNode11.value + this.end.margin;
                    float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                    if (dependencyNode10 == dependencyNode11) {
                        i17 = dependencyNode10.value;
                        i18 = dependencyNode11.value;
                        horizontalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (i17 + 0.5f + (((i18 - i17) - this.dimension.value) * horizontalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                }
            }
        }
    }
}
