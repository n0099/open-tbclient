package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
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

        public MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {widgetGroup, constraintWidget, linearSystem, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            this.orientation = i2;
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

    public WidgetGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        int i5 = count;
        count = i5 + 1;
        this.id = i5;
        this.orientation = i2;
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
            int i2 = this.orientation;
            return i2 == 0 ? "Horizontal" : i2 == 1 ? "Vertical" : i2 == 2 ? "Both" : "Unknown";
        }
        return (String) invokeV.objValue;
    }

    private int measureWrap(int i2, ConstraintWidget constraintWidget) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, constraintWidget)) == null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i2);
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                if (i2 == 0) {
                    return constraintWidget.getWidth();
                }
                return constraintWidget.getHeight();
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i2) {
        InterceptResult invokeLLI;
        int objectVariableValue;
        int objectVariableValue2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, this, linearSystem, arrayList, i2)) == null) {
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
            linearSystem.reset();
            constraintWidgetContainer.addToSolver(linearSystem, false);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList.get(i3).addToSolver(linearSystem, false);
            }
            if (i2 == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
            }
            if (i2 == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
            }
            try {
                linearSystem.minimize();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.results = new ArrayList<>();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                this.results.add(new MeasureResult(this, arrayList.get(i4), linearSystem, i2));
            }
            if (i2 == 0) {
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
            for (int i2 = 0; i2 < this.results.size(); i2++) {
                this.results.get(i2).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            int size = this.widgets.size();
            if (this.moveTo != -1 && size > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    WidgetGroup widgetGroup = arrayList.get(i2);
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
            for (int i2 = 0; i2 < this.widgets.size(); i2++) {
                if (widgetGroup.contains(this.widgets.get(i2))) {
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

    public void moveTo(int i2, WidgetGroup widgetGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, widgetGroup) == null) {
            Iterator<ConstraintWidget> it = this.widgets.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                widgetGroup.add(next);
                if (i2 == 0) {
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

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.orientation = i2;
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

    public int measureWrap(LinearSystem linearSystem, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearSystem, i2)) == null) {
            if (this.widgets.size() == 0) {
                return 0;
            }
            return solverMeasure(linearSystem, this.widgets, i2);
        }
        return invokeLI.intValue;
    }
}
