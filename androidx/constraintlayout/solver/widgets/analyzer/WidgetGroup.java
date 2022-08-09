package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WidgetGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public static int count;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean authoritative;
    public int id;
    public int moveTo;
    public int orientation;
    public ArrayList<MeasureResult> results;
    public ArrayList<ConstraintWidget> widgets;

    /* loaded from: classes.dex */
    public class MeasureResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int baseline;
        public int bottom;
        public int left;
        public int orientation;
        public int right;
        public final /* synthetic */ WidgetGroup this$0;
        public int top;
        public WeakReference<ConstraintWidget> widgetRef;

        public MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {widgetGroup, constraintWidget, linearSystem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = widgetGroup;
            this.widgetRef = new WeakReference<>(constraintWidget);
            this.left = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.top = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.right = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.bottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.baseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.orientation = i;
        }

        public void apply() {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (constraintWidget = this.widgetRef.get()) == null) {
                return;
            }
            constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-423254277, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetGroup;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-423254277, "Landroidx/constraintlayout/solver/widgets/analyzer/WidgetGroup;");
        }
    }

    public WidgetGroup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.widgets = new ArrayList<>();
        this.id = -1;
        this.authoritative = false;
        this.orientation = 0;
        this.results = null;
        this.moveTo = -1;
        int i4 = count;
        count = i4 + 1;
        this.id = i4;
        this.orientation = i;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, constraintWidget)) == null) ? this.widgets.contains(constraintWidget) : invokeL.booleanValue;
    }

    private String getOrientationString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.orientation;
            return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
        }
        return (String) invokeV.objValue;
    }

    private int measureWrap(int i, ConstraintWidget constraintWidget) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, constraintWidget)) == null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i);
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                if (i == 0) {
                    return constraintWidget.getWidth();
                }
                return constraintWidget.getHeight();
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        InterceptResult invokeLLI;
        int objectVariableValue;
        int objectVariableValue2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, this, linearSystem, arrayList, i)) == null) {
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
            linearSystem.reset();
            constraintWidgetContainer.addToSolver(linearSystem, false);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList.get(i2).addToSolver(linearSystem, false);
            }
            if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
            }
            if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
            }
            try {
                linearSystem.minimize();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.results = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.results.add(new MeasureResult(this, arrayList.get(i3), linearSystem, i));
            }
            if (i == 0) {
                objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
                objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
                linearSystem.reset();
            } else {
                objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
                objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
                linearSystem.reset();
            }
            return objectVariableValue2 - objectVariableValue;
        }
        return invokeLLI.intValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, constraintWidget)) == null) {
            if (this.widgets.contains(constraintWidget)) {
                return false;
            }
            this.widgets.add(constraintWidget);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void apply() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.results != null && this.authoritative) {
            for (int i = 0; i < this.results.size(); i++) {
                this.results.get(i).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            int size = this.widgets.size();
            if (this.moveTo != -1 && size > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    WidgetGroup widgetGroup = arrayList.get(i);
                    if (this.moveTo == widgetGroup.id) {
                        moveTo(this.orientation, widgetGroup);
                    }
                }
            }
            if (size == 0) {
                arrayList.remove(this);
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.widgets.clear();
        }
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.id : invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.orientation : invokeV.intValue;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, widgetGroup)) == null) {
            for (int i = 0; i < this.widgets.size(); i++) {
                if (widgetGroup.contains(this.widgets.get(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isAuthoritative() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.authoritative : invokeV.booleanValue;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, widgetGroup) == null) {
            Iterator<ConstraintWidget> it = this.widgets.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                widgetGroup.add(next);
                if (i == 0) {
                    next.horizontalGroup = widgetGroup.getId();
                } else {
                    next.verticalGroup = widgetGroup.getId();
                }
            }
            this.moveTo = widgetGroup.id;
        }
    }

    public void setAuthoritative(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.authoritative = z;
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.orientation = i;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.widgets.size() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Iterator<ConstraintWidget> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = getOrientationString() + " [" + this.id + "] <";
            while (this.widgets.iterator().hasNext()) {
                str = str + " " + it.next().getDebugName();
            }
            return str + " >";
        }
        return (String) invokeV.objValue;
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearSystem, i)) == null) {
            if (this.widgets.size() == 0) {
                return 0;
            }
            return solverMeasure(linearSystem, this.widgets, i);
        }
        return invokeLI.intValue;
    }
}
