package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DimensionDependency dimension;
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    public RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    public boolean resolved;
    public RunGroup runGroup;
    public DependencyNode start;
    public ConstraintWidget widget;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-105672638, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetRun$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-105672638, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetRun$1;");
                    return;
                }
            }
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class RunType {
        public static final /* synthetic */ RunType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RunType CENTER;
        public static final RunType END;
        public static final RunType NONE;
        public static final RunType START;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-320829266, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetRun$RunType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-320829266, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetRun$RunType;");
                    return;
                }
            }
            NONE = new RunType("NONE", 0);
            START = new RunType("START", 1);
            END = new RunType("END", 2);
            RunType runType = new RunType("CENTER", 3);
            CENTER = runType;
            $VALUES = new RunType[]{NONE, START, END, runType};
        }

        public RunType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RunType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RunType) Enum.valueOf(RunType.class, str) : (RunType) invokeL.objValue;
        }

        public static RunType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RunType[]) $VALUES.clone() : (RunType[]) invokeV.objValue;
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, this, i2, i3) == null) {
            int i5 = this.matchConstraintsType;
            if (i5 == 0) {
                this.dimension.resolve(getLimitedDimension(i3, i2));
            } else if (i5 == 1) {
                this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, i2), i3));
            } else if (i5 == 2) {
                ConstraintWidget parent = this.widget.getParent();
                if (parent != null) {
                    WidgetRun widgetRun = i2 == 0 ? parent.horizontalRun : parent.verticalRun;
                    if (widgetRun.dimension.resolved) {
                        ConstraintWidget constraintWidget = this.widget;
                        this.dimension.resolve(getLimitedDimension((int) ((widgetRun.dimension.value * (i2 == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i2));
                    }
                }
            } else if (i5 != 3) {
            } else {
                ConstraintWidget constraintWidget2 = this.widget;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget2.horizontalRun;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = horizontalWidgetRun.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2 && horizontalWidgetRun.matchConstraintsType == 3) {
                    VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                    if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                        return;
                    }
                }
                ConstraintWidget constraintWidget3 = this.widget;
                WidgetRun widgetRun2 = i2 == 0 ? constraintWidget3.verticalRun : constraintWidget3.horizontalRun;
                if (widgetRun2.dimension.resolved) {
                    float dimensionRatio = this.widget.getDimensionRatio();
                    if (i2 == 1) {
                        i4 = (int) ((widgetRun2.dimension.value / dimensionRatio) + 0.5f);
                    } else {
                        i4 = (int) ((dimensionRatio * widgetRun2.dimension.value) + 0.5f);
                    }
                    this.dimension.resolve(i4);
                }
            }
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, dependencyNode, dependencyNode2, i2) == null) {
            dependencyNode.targets.add(dependencyNode2);
            dependencyNode.margin = i2;
            dependencyNode2.dependencies.add(dependencyNode);
        }
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i2, int i3) {
        InterceptResult invokeII;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            if (i3 == 0) {
                ConstraintWidget constraintWidget = this.widget;
                int i4 = constraintWidget.mMatchConstraintMaxWidth;
                max = Math.max(constraintWidget.mMatchConstraintMinWidth, i2);
                if (i4 > 0) {
                    max = Math.min(i4, i2);
                }
                if (max == i2) {
                    return i2;
                }
            } else {
                ConstraintWidget constraintWidget2 = this.widget;
                int i5 = constraintWidget2.mMatchConstraintMaxHeight;
                max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i2);
                if (i5 > 0) {
                    max = Math.min(i5, i2);
                }
                if (max == i2) {
                    return i2;
                }
            }
            return max;
        }
        return invokeII.intValue;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, constraintAnchor)) == null) {
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 == null) {
                return null;
            }
            ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return constraintWidget.verticalRun.end;
                        }
                        return constraintWidget.verticalRun.baseline;
                    }
                    return constraintWidget.verticalRun.start;
                }
                return constraintWidget.horizontalRun.end;
            }
            return constraintWidget.horizontalRun.start;
        }
        return (DependencyNode) invokeL.objValue;
    }

    public long getWrapDimension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.resolved) {
                return dimensionDependency.value;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean isCenterConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int size = this.start.targets.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (this.start.targets.get(i3).run != this) {
                    i2++;
                }
            }
            int size2 = this.end.targets.size();
            for (int i4 = 0; i4 < size2; i4++) {
                if (this.end.targets.get(i4).run != this) {
                    i2++;
                }
            }
            return i2 >= 2;
        }
        return invokeV.booleanValue;
    }

    public boolean isDimensionResolved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.dimension.resolved : invokeV.booleanValue;
    }

    public boolean isResolved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.resolved : invokeV.booleanValue;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dependency) == null) {
        }
    }

    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048591, this, dependency, constraintAnchor, constraintAnchor2, i2) == null) {
            DependencyNode target = getTarget(constraintAnchor);
            DependencyNode target2 = getTarget(constraintAnchor2);
            if (target.resolved && target2.resolved) {
                int margin = target.value + constraintAnchor.getMargin();
                int margin2 = target2.value - constraintAnchor2.getMargin();
                int i3 = margin2 - margin;
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    resolveDimension(i2, i3);
                }
                DimensionDependency dimensionDependency = this.dimension;
                if (dimensionDependency.resolved) {
                    if (dimensionDependency.value == i3) {
                        this.start.resolve(margin);
                        this.end.resolve(margin2);
                        return;
                    }
                    ConstraintWidget constraintWidget = this.widget;
                    float horizontalBiasPercent = i2 == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                    if (target == target2) {
                        margin = target.value;
                        margin2 = target2.value;
                        horizontalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.dimension.value) * horizontalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                }
            }
        }
    }

    public void updateRunEnd(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dependency) == null) {
        }
    }

    public void updateRunStart(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dependency) == null) {
        }
    }

    public long wrapSize(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.resolved) {
                long j = dimensionDependency.value;
                if (isCenterConnection()) {
                    i3 = this.start.margin - this.end.margin;
                } else if (i2 == 0) {
                    i3 = this.start.margin;
                } else {
                    return j - this.end.margin;
                }
                return j + i3;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, DimensionDependency dimensionDependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dependencyNode, dependencyNode2, i2, dimensionDependency) == null) {
            dependencyNode.targets.add(dependencyNode2);
            dependencyNode.targets.add(this.dimension);
            dependencyNode.marginFactor = i2;
            dependencyNode.marginDependency = dimensionDependency;
            dependencyNode2.dependencies.add(dependencyNode);
            dimensionDependency.dependencies.add(dependencyNode);
        }
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, constraintAnchor, i2)) == null) {
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 == null) {
                return null;
            }
            ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
            WidgetRun widgetRun = i2 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
            int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.mTarget.mType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            return null;
                        }
                    }
                }
                return widgetRun.end;
            }
            return widgetRun.start;
        }
        return (DependencyNode) invokeLI.objValue;
    }
}
