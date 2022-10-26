package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GuidelineReference extends WidgetRun {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuidelineReference(ConstraintWidget constraintWidget) {
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
        constraintWidget.horizontalRun.clear();
        constraintWidget.verticalRun.clear();
        this.orientation = ((Guideline) constraintWidget).getOrientation();
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
            Guideline guideline = (Guideline) this.widget;
            int relativeBegin = guideline.getRelativeBegin();
            int relativeEnd = guideline.getRelativeEnd();
            guideline.getRelativePercent();
            if (guideline.getOrientation() == 1) {
                if (relativeBegin != -1) {
                    this.start.targets.add(this.widget.mParent.horizontalRun.start);
                    this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
                    this.start.margin = relativeBegin;
                } else if (relativeEnd != -1) {
                    this.start.targets.add(this.widget.mParent.horizontalRun.end);
                    this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
                    this.start.margin = -relativeEnd;
                } else {
                    DependencyNode dependencyNode = this.start;
                    dependencyNode.delegateToWidgetRun = true;
                    dependencyNode.targets.add(this.widget.mParent.horizontalRun.end);
                    this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
                }
                addDependency(this.widget.horizontalRun.start);
                addDependency(this.widget.horizontalRun.end);
                return;
            }
            if (relativeBegin != -1) {
                this.start.targets.add(this.widget.mParent.verticalRun.start);
                this.widget.mParent.verticalRun.start.dependencies.add(this.start);
                this.start.margin = relativeBegin;
            } else if (relativeEnd != -1) {
                this.start.targets.add(this.widget.mParent.verticalRun.end);
                this.widget.mParent.verticalRun.end.dependencies.add(this.start);
                this.start.margin = -relativeEnd;
            } else {
                DependencyNode dependencyNode2 = this.start;
                dependencyNode2.delegateToWidgetRun = true;
                dependencyNode2.targets.add(this.widget.mParent.verticalRun.end);
                this.widget.mParent.verticalRun.end.dependencies.add(this.start);
            }
            addDependency(this.widget.verticalRun.start);
            addDependency(this.widget.verticalRun.end);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (((Guideline) this.widget).getOrientation() == 1) {
                this.widget.setX(this.start.value);
            } else {
                this.widget.setY(this.start.value);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.start.clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.start.resolved = false;
            this.end.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dependency) == null) {
            DependencyNode dependencyNode = this.start;
            if (!dependencyNode.readyToSolve || dependencyNode.resolved) {
                return;
            }
            this.start.resolve((int) ((dependencyNode.targets.get(0).value * ((Guideline) this.widget).getRelativePercent()) + 0.5f));
        }
    }
}
