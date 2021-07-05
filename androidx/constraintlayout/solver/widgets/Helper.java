package androidx.constraintlayout.solver.widgets;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    public Helper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWidgets = new ConstraintWidget[4];
        this.mWidgetsCount = 0;
    }

    public void add(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) {
            int i2 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i2 > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i3 = this.mWidgetsCount;
            constraintWidgetArr2[i3] = constraintWidget;
            this.mWidgetsCount = i3 + 1;
        }
    }

    public void removeAllIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mWidgetsCount = 0;
        }
    }
}
