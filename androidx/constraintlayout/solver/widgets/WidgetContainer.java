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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget = arrayList.get(i6);
                if (constraintWidget.getX() < i2) {
                    i2 = constraintWidget.getX();
                }
                if (constraintWidget.getY() < i3) {
                    i3 = constraintWidget.getY();
                }
                if (constraintWidget.getRight() > i4) {
                    i4 = constraintWidget.getRight();
                }
                if (constraintWidget.getBottom() > i5) {
                    i5 = constraintWidget.getBottom();
                }
            }
            rectangle.setBounds(i2, i3, i4 - i2, i5 - i3);
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
    public ConstraintWidget findWidget(float f2, float f3) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int drawX = getDrawX();
            int drawY = getDrawY();
            WidgetContainer widgetContainer = (f2 < ((float) drawX) || f2 > ((float) (getWidth() + drawX)) || f3 < ((float) drawY) || f3 > ((float) (getHeight() + drawY))) ? null : this;
            int size = this.mChildren.size();
            while (i2 < size) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
                if (constraintWidget instanceof WidgetContainer) {
                    constraintWidget = ((WidgetContainer) constraintWidget).findWidget(f2, f3);
                    i2 = constraintWidget == null ? i2 + 1 : 0;
                    widgetContainer = constraintWidget;
                } else {
                    int drawX2 = constraintWidget.getDrawX();
                    int drawY2 = constraintWidget.getDrawY();
                    int width = constraintWidget.getWidth() + drawX2;
                    int height = constraintWidget.getHeight() + drawY2;
                    if (f2 >= drawX2) {
                        if (f2 <= width) {
                            if (f3 >= drawY2) {
                                if (f3 > height) {
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

    public ArrayList<ConstraintWidget> findWidgets(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i2, i3, i4, i5)) == null) {
            ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
            Rectangle rectangle = new Rectangle();
            rectangle.setBounds(i2, i3, i4, i5);
            int size = this.mChildren.size();
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i6);
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
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
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
            for (int i2 = 0; i2 < size; i2++) {
                this.mChildren.get(i2).resetSolverVariables(cache);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.setOffset(i2, i3);
            int size = this.mChildren.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mChildren.get(i4).setOffset(getRootX(), getRootY());
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
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
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
    public WidgetContainer(int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
