package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class HelperReferences extends WidgetRun {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ConstraintWidget) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addDependency(DependencyNode dependencyNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, dependencyNode) == null) {
            this.start.dependencies.add(dependencyNode);
            dependencyNode.targets.add(this.start);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget instanceof Barrier) {
                this.start.delegateToWidgetRun = true;
                Barrier barrier = (Barrier) constraintWidget;
                int barrierType = barrier.getBarrierType();
                boolean allowsGoneWidget = barrier.allowsGoneWidget();
                int i2 = 0;
                if (barrierType == 0) {
                    this.start.type = DependencyNode.Type.LEFT;
                    while (i2 < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget2 = barrier.mWidgets[i2];
                        if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                            DependencyNode dependencyNode = constraintWidget2.horizontalRun.start;
                            dependencyNode.dependencies.add(this.start);
                            this.start.targets.add(dependencyNode);
                        }
                        i2++;
                    }
                    addDependency(this.widget.horizontalRun.start);
                    addDependency(this.widget.horizontalRun.end);
                } else if (barrierType == 1) {
                    this.start.type = DependencyNode.Type.RIGHT;
                    while (i2 < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i2];
                        if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget3.horizontalRun.end;
                            dependencyNode2.dependencies.add(this.start);
                            this.start.targets.add(dependencyNode2);
                        }
                        i2++;
                    }
                    addDependency(this.widget.horizontalRun.start);
                    addDependency(this.widget.horizontalRun.end);
                } else if (barrierType == 2) {
                    this.start.type = DependencyNode.Type.TOP;
                    while (i2 < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget4 = barrier.mWidgets[i2];
                        if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                            DependencyNode dependencyNode3 = constraintWidget4.verticalRun.start;
                            dependencyNode3.dependencies.add(this.start);
                            this.start.targets.add(dependencyNode3);
                        }
                        i2++;
                    }
                    addDependency(this.widget.verticalRun.start);
                    addDependency(this.widget.verticalRun.end);
                } else if (barrierType != 3) {
                } else {
                    this.start.type = DependencyNode.Type.BOTTOM;
                    while (i2 < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget5 = barrier.mWidgets[i2];
                        if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                            DependencyNode dependencyNode4 = constraintWidget5.verticalRun.end;
                            dependencyNode4.dependencies.add(this.start);
                            this.start.targets.add(dependencyNode4);
                        }
                        i2++;
                    }
                    addDependency(this.widget.verticalRun.start);
                    addDependency(this.widget.verticalRun.end);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget instanceof Barrier) {
                int barrierType = ((Barrier) constraintWidget).getBarrierType();
                if (barrierType != 0 && barrierType != 1) {
                    this.widget.setY(this.start.value);
                } else {
                    this.widget.setX(this.start.value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.runGroup = null;
            this.start.clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.start.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dependency) == null) {
            Barrier barrier = (Barrier) this.widget;
            int barrierType = barrier.getBarrierType();
            int i2 = 0;
            int i3 = -1;
            for (DependencyNode dependencyNode : this.start.targets) {
                int i4 = dependencyNode.value;
                if (i3 == -1 || i4 < i3) {
                    i3 = i4;
                }
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            if (barrierType != 0 && barrierType != 2) {
                this.start.resolve(i2 + barrier.getMargin());
            } else {
                this.start.resolve(i3 + barrier.getMargin());
            }
        }
    }
}
