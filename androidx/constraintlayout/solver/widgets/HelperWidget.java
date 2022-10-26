package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, constraintWidgetContainer) == null) {
        }
    }

    public HelperWidget() {
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
        this.mWidgets = new ConstraintWidget[4];
        this.mWidgetsCount = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mWidgetsCount = 0;
            Arrays.fill(this.mWidgets, (Object) null);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) && constraintWidget != this && constraintWidget != null) {
            int i = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i2 = this.mWidgetsCount;
            constraintWidgetArr2[i2] = constraintWidget;
            this.mWidgetsCount = i2 + 1;
        }
    }

    public int findGroupInDependents(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            for (int i4 = 0; i4 < this.mWidgetsCount; i4++) {
                ConstraintWidget constraintWidget = this.mWidgets[i4];
                if (i == 0 && (i3 = constraintWidget.horizontalGroup) != -1) {
                    return i3;
                }
                if (i == 1 && (i2 = constraintWidget.verticalGroup) != -1) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int i, WidgetGroup widgetGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, i, widgetGroup) == null) {
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                widgetGroup.add(this.mWidgets[i2]);
            }
            for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
                Grouping.findDependents(this.mWidgets[i3], i, arrayList, widgetGroup);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, constraintWidget, hashMap) == null) {
            super.copy(constraintWidget, hashMap);
            HelperWidget helperWidget = (HelperWidget) constraintWidget;
            this.mWidgetsCount = 0;
            int i = helperWidget.mWidgetsCount;
            for (int i2 = 0; i2 < i; i2++) {
                add(hashMap.get(helperWidget.mWidgets[i2]));
            }
        }
    }
}
