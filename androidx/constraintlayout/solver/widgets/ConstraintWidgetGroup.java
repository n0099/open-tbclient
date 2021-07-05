package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ConstraintWidgetGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions;
    public int mGroupHeight;
    public int mGroupWidth;
    public boolean mSkipSolver;
    public List<ConstraintWidget> mStartHorizontalWidgets;
    public List<ConstraintWidget> mStartVerticalWidgets;
    public List<ConstraintWidget> mUnresolvedWidgets;
    public HashSet<ConstraintWidget> mWidgetsToSetHorizontal;
    public HashSet<ConstraintWidget> mWidgetsToSetVertical;
    public List<ConstraintWidget> mWidgetsToSolve;

    public ConstraintWidgetGroup(List<ConstraintWidget> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGroupWidth = -1;
        this.mGroupHeight = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{-1, -1};
        this.mStartHorizontalWidgets = new ArrayList();
        this.mStartVerticalWidgets = new ArrayList();
        this.mWidgetsToSetHorizontal = new HashSet<>();
        this.mWidgetsToSetVertical = new HashSet<>();
        this.mWidgetsToSolve = new ArrayList();
        this.mUnresolvedWidgets = new ArrayList();
        this.mConstrainedGroup = list;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, arrayList, constraintWidget) == null) || constraintWidget.mGroupsToSolver) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.mGroupsToSolver = true;
        if (constraintWidget.isFullyResolved()) {
            return;
        }
        if (constraintWidget instanceof Helper) {
            Helper helper = (Helper) constraintWidget;
            int i2 = helper.mWidgetsCount;
            for (int i3 = 0; i3 < i2; i3++) {
                getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i3]);
            }
        }
        int length = constraintWidget.mListAnchors.length;
        for (int i4 = 0; i4 < length; i4++) {
            ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i4].mTarget;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
                if (constraintAnchor != null && constraintWidget2 != constraintWidget.getParent()) {
                    getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateResolvedDimension(ConstraintWidget constraintWidget) {
        ConstraintAnchor constraintAnchor;
        int i2;
        int margin;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int margin2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, constraintWidget) != null) || !constraintWidget.mOptimizerMeasurable || constraintWidget.isFullyResolved()) {
            return;
        }
        boolean z = constraintWidget.mRight.mTarget != null;
        if (z) {
            constraintAnchor = constraintWidget.mRight.mTarget;
        } else {
            constraintAnchor = constraintWidget.mLeft.mTarget;
        }
        if (constraintAnchor != null) {
            ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
            if (!constraintWidget2.mOptimizerMeasured) {
                updateResolvedDimension(constraintWidget2);
            }
            ConstraintAnchor.Type type = constraintAnchor.mType;
            if (type == ConstraintAnchor.Type.RIGHT) {
                ConstraintWidget constraintWidget3 = constraintAnchor.mOwner;
                i2 = constraintWidget3.mX + constraintWidget3.getWidth();
            } else if (type == ConstraintAnchor.Type.LEFT) {
                i2 = constraintAnchor.mOwner.mX;
            }
            if (!z) {
                margin = i2 - constraintWidget.mRight.getMargin();
            } else {
                margin = i2 + constraintWidget.mLeft.getMargin() + constraintWidget.getWidth();
            }
            constraintWidget.setHorizontalDimension(margin - constraintWidget.getWidth(), margin);
            constraintAnchor2 = constraintWidget.mBaseline.mTarget;
            if (constraintAnchor2 == null) {
                ConstraintWidget constraintWidget4 = constraintAnchor2.mOwner;
                if (!constraintWidget4.mOptimizerMeasured) {
                    updateResolvedDimension(constraintWidget4);
                }
                ConstraintWidget constraintWidget5 = constraintAnchor2.mOwner;
                int i3 = (constraintWidget5.mY + constraintWidget5.mBaselineDistance) - constraintWidget.mBaselineDistance;
                constraintWidget.setVerticalDimension(i3, constraintWidget.mHeight + i3);
                constraintWidget.mOptimizerMeasured = true;
                return;
            }
            boolean z2 = constraintWidget.mBottom.mTarget != null;
            if (z2) {
                constraintAnchor3 = constraintWidget.mBottom.mTarget;
            } else {
                constraintAnchor3 = constraintWidget.mTop.mTarget;
            }
            if (constraintAnchor3 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor3.mOwner;
                if (!constraintWidget6.mOptimizerMeasured) {
                    updateResolvedDimension(constraintWidget6);
                }
                ConstraintAnchor.Type type2 = constraintAnchor3.mType;
                if (type2 == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintWidget constraintWidget7 = constraintAnchor3.mOwner;
                    margin = constraintWidget7.mY + constraintWidget7.getHeight();
                } else if (type2 == ConstraintAnchor.Type.TOP) {
                    margin = constraintAnchor3.mOwner.mY;
                }
            }
            if (z2) {
                margin2 = margin - constraintWidget.mBottom.getMargin();
            } else {
                margin2 = margin + constraintWidget.mTop.getMargin() + constraintWidget.getHeight();
            }
            constraintWidget.setVerticalDimension(margin2 - constraintWidget.getHeight(), margin2);
            constraintWidget.mOptimizerMeasured = true;
            return;
        }
        i2 = 0;
        if (!z) {
        }
        constraintWidget.setHorizontalDimension(margin - constraintWidget.getWidth(), margin);
        constraintAnchor2 = constraintWidget.mBaseline.mTarget;
        if (constraintAnchor2 == null) {
        }
    }

    public void addWidgetsToSet(ConstraintWidget constraintWidget, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, constraintWidget, i2) == null) {
            if (i2 == 0) {
                this.mWidgetsToSetHorizontal.add(constraintWidget);
            } else if (i2 == 1) {
                this.mWidgetsToSetVertical.add(constraintWidget);
            }
        }
    }

    public List<ConstraintWidget> getStartWidgets(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return this.mStartHorizontalWidgets;
            }
            if (i2 == 1) {
                return this.mStartVerticalWidgets;
            }
            return null;
        }
        return (List) invokeI.objValue;
    }

    public Set<ConstraintWidget> getWidgetsToSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == 0) {
                return this.mWidgetsToSetHorizontal;
            }
            if (i2 == 1) {
                return this.mWidgetsToSetVertical;
            }
            return null;
        }
        return (Set) invokeI.objValue;
    }

    public List<ConstraintWidget> getWidgetsToSolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.mWidgetsToSolve.isEmpty()) {
                return this.mWidgetsToSolve;
            }
            int size = this.mConstrainedGroup.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i2);
                if (!constraintWidget.mOptimizerMeasurable) {
                    getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
                }
            }
            this.mUnresolvedWidgets.clear();
            this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
            this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
            return this.mWidgetsToSolve;
        }
        return (List) invokeV.objValue;
    }

    public void updateUnresolvedWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int size = this.mUnresolvedWidgets.size();
            for (int i2 = 0; i2 < size; i2++) {
                updateResolvedDimension(this.mUnresolvedWidgets.get(i2));
            }
        }
    }

    public ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mGroupWidth = -1;
        this.mGroupHeight = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{-1, -1};
        this.mStartHorizontalWidgets = new ArrayList();
        this.mStartVerticalWidgets = new ArrayList();
        this.mWidgetsToSetHorizontal = new HashSet<>();
        this.mWidgetsToSetVertical = new HashSet<>();
        this.mWidgetsToSolve = new ArrayList();
        this.mUnresolvedWidgets = new ArrayList();
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }
}
