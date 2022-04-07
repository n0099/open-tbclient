package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
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
        this.mChildren = new ArrayList<>();
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, arrayList)) == null) {
            Rectangle rectangle = new Rectangle();
            if (arrayList.size() == 0) {
                return rectangle;
            }
            int size = arrayList.size();
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = arrayList.get(i5);
                if (constraintWidget.getX() < i) {
                    i = constraintWidget.getX();
                }
                if (constraintWidget.getY() < i2) {
                    i2 = constraintWidget.getY();
                }
                if (constraintWidget.getRight() > i3) {
                    i3 = constraintWidget.getRight();
                }
                if (constraintWidget.getBottom() > i4) {
                    i4 = constraintWidget.getBottom();
                }
            }
            rectangle.setBounds(i, i2, i3 - i, i4 - i2);
            return rectangle;
        }
        return (Rectangle) invokeL.objValue;
    }

    public void add(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) {
            this.mChildren.add(constraintWidget);
            if (constraintWidget.getParent() != null) {
                ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
            }
            constraintWidget.setParent(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7 */
    public ConstraintWidget findWidget(float f, float f2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            int drawX = getDrawX();
            int drawY = getDrawY();
            WidgetContainer widgetContainer = (f < ((float) drawX) || f > ((float) (getWidth() + drawX)) || f2 < ((float) drawY) || f2 > ((float) (getHeight() + drawY))) ? null : this;
            int size = this.mChildren.size();
            while (i < size) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    constraintWidget = ((WidgetContainer) constraintWidget).findWidget(f, f2);
                    i = constraintWidget == null ? i + 1 : 0;
                    widgetContainer = constraintWidget;
                } else {
                    int drawX2 = constraintWidget.getDrawX();
                    int drawY2 = constraintWidget.getDrawY();
                    int width = constraintWidget.getWidth() + drawX2;
                    int height = constraintWidget.getHeight() + drawY2;
                    if (f >= drawX2) {
                        if (f <= width) {
                            if (f2 >= drawY2) {
                                if (f2 > height) {
                                }
                                widgetContainer = constraintWidget;
                            }
                        }
                    }
                }
            }
            return widgetContainer;
        }
        return (ConstraintWidget) invokeCommon.objValue;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) {
            ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
            Rectangle rectangle = new Rectangle();
            rectangle.setBounds(i, i2, i3, i4);
            int size = this.mChildren.size();
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i5);
                Rectangle rectangle2 = new Rectangle();
                rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
                if (rectangle.intersects(rectangle2)) {
                    arrayList.add(constraintWidget);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeIIII.objValue;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mChildren : (ArrayList) invokeV.objValue;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ConstraintWidget parent = getParent();
            ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
            while (parent != null) {
                ConstraintWidget parent2 = parent.getParent();
                if (parent instanceof ConstraintWidgetContainer) {
                    constraintWidgetContainer = (ConstraintWidgetContainer) parent;
                }
                parent = parent2;
            }
            return constraintWidgetContainer;
        }
        return (ConstraintWidgetContainer) invokeV.objValue;
    }

    public void layout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            updateDrawPosition();
            ArrayList<ConstraintWidget> arrayList = this.mChildren;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, constraintWidget) == null) {
            this.mChildren.remove(constraintWidget);
            constraintWidget.setParent(null);
        }
    }

    public void removeAllChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mChildren.clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mChildren.clear();
            super.reset();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cache) == null) {
            super.resetSolverVariables(cache);
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).resetSolverVariables(cache);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.setOffset(i, i2);
            int size = this.mChildren.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mChildren.get(i3).setOffset(getRootX(), getRootY());
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.updateDrawPosition();
            ArrayList<ConstraintWidget> arrayList = this.mChildren;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mChildren = new ArrayList<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContainer(int i, int i2) {
        super(i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mChildren = new ArrayList<>();
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidgetArr) == null) {
            for (ConstraintWidget constraintWidget : constraintWidgetArr) {
                add(constraintWidget);
            }
        }
    }
}
