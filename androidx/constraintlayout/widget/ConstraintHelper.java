package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCount;
    public Helper mHelperWidget;
    public int[] mIds;
    public HashMap<Integer, String> mMap;
    public String mReferenceIds;
    public String mReferenceTags;
    public boolean mUseViewMeasure;
    public View[] mViews;
    public Context myContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHelper(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    private void addID(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int findId = findId(trim);
        if (findId != 0) {
            this.mMap.put(Integer.valueOf(findId), trim);
            addRscID(findId);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void addRscID(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) || i == getId()) {
            return;
        }
        int i2 = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i2 > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i3 = this.mCount;
        iArr2[i3] = i;
        this.mCount = i3 + 1;
    }

    private void addTag(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    addRscID(childAt.getId());
                }
            }
        }
    }

    private int[] convertReferenceString(View view2, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, view2, str)) == null) {
            String[] split = str.split(",");
            view2.getContext();
            int[] iArr = new int[split.length];
            int i = 0;
            for (String str2 : split) {
                int findId = findId(str2.trim());
                if (findId != 0) {
                    iArr[i] = findId;
                    i++;
                }
            }
            return i != split.length ? Arrays.copyOf(iArr, i) : iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    private int findId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
            int i = 0;
            if (isInEditMode() && constraintLayout != null) {
                Object designInformation = constraintLayout.getDesignInformation(0, str);
                if (designInformation instanceof Integer) {
                    i = ((Integer) designInformation).intValue();
                }
            }
            if (i == 0 && constraintLayout != null) {
                i = findId(constraintLayout, str);
            }
            if (i == 0) {
                try {
                    i = R.id.class.getField(str).getInt(null);
                } catch (Exception unused) {
                }
            }
            return i == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i;
        }
        return invokeL.intValue;
    }

    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == this) {
            return;
        }
        if (view2.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else if (view2.getParent() == null) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        } else {
            this.mReferenceIds = null;
            addRscID(view2.getId());
            requestLayout();
        }
    }

    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraintLayout) == null) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.mCount; i++) {
                View viewById = constraintLayout.getViewById(this.mIds[i]);
                if (viewById != null) {
                    viewById.setVisibility(visibility);
                    if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public int[] getReferencedIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.copyOf(this.mIds, this.mCount) : (int[]) invokeV.objValue;
    }

    public View[] getViews(ConstraintLayout constraintLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constraintLayout)) == null) {
            View[] viewArr = this.mViews;
            if (viewArr == null || viewArr.length != this.mCount) {
                this.mViews = new View[this.mCount];
            }
            for (int i = 0; i < this.mCount; i++) {
                this.mViews[i] = constraintLayout.getViewById(this.mIds[i]);
            }
            return this.mViews;
        }
        return (View[]) invokeL.objValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 19) {
                String string = obtainStyledAttributes.getString(index);
                this.mReferenceIds = string;
                setIds(string);
            } else if (index == 20) {
                String string2 = obtainStyledAttributes.getString(index);
                this.mReferenceTags = string2;
                setReferenceTags(string2);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(1048582, this, constraint, helperWidget, layoutParams, sparseArray) != null) {
            return;
        }
        ConstraintSet.Layout layout = constraint.layout;
        int[] iArr = layout.mReferenceIds;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.mReferenceIdString;
            if (str != null && str.length() > 0) {
                ConstraintSet.Layout layout2 = constraint.layout;
                layout2.mReferenceIds = convertReferenceString(this, layout2.mReferenceIdString);
            }
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds == null) {
            return;
        }
        int i = 0;
        while (true) {
            int[] iArr2 = constraint.layout.mReferenceIds;
            if (i >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(iArr2[i]);
            if (constraintWidget != null) {
                helperWidget.add(constraintWidget);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            String str = this.mReferenceIds;
            if (str != null) {
                setIds(str);
            }
            String str2 = this.mReferenceTags;
            if (str2 != null) {
                setReferenceTags(str2);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            if (this.mUseViewMeasure) {
                super.onMeasure(i, i2);
            } else {
                setMeasuredDimension(0, 0);
            }
        }
    }

    public void removeView(View view2) {
        int id;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view2) == null) || (id = view2.getId()) == -1) {
            return;
        }
        this.mReferenceIds = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mCount) {
                break;
            } else if (this.mIds[i2] == id) {
                while (true) {
                    i = this.mCount;
                    if (i2 >= i - 1) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i3 = i2 + 1;
                    iArr[i2] = iArr[i3];
                    i2 = i3;
                }
                this.mIds[i - 1] = 0;
                this.mCount = i - 1;
            } else {
                i2++;
            }
        }
        requestLayout();
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, constraintWidget, z) == null) {
        }
    }

    public void setIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048588, this, str) != null) {
            return;
        }
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addID(str.substring(i));
                return;
            } else {
                addID(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048589, this, str) != null) {
            return;
        }
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addTag(str.substring(i));
                return;
            } else {
                addTag(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iArr) == null) {
            this.mReferenceIds = null;
            this.mCount = 0;
            for (int i : iArr) {
                addRscID(i);
            }
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, obj) == null) {
            super.setTag(i, obj);
            if (obj == null && this.mReferenceIds == null) {
                addRscID(i);
            }
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, constraintLayout) == null) {
        }
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, constraintLayout) == null) {
        }
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, constraintLayout) == null) {
        }
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, constraintLayout) == null) {
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int findId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, constraintLayout) == null) {
            if (isInEditMode()) {
                setIds(this.mReferenceIds);
            }
            Helper helper = this.mHelperWidget;
            if (helper == null) {
                return;
            }
            helper.removeAllIds();
            for (int i = 0; i < this.mCount; i++) {
                int i2 = this.mIds[i];
                View viewById = constraintLayout.getViewById(i2);
                if (viewById == null && (findId = findId(constraintLayout, (str = this.mMap.get(Integer.valueOf(i2))))) != 0) {
                    this.mIds[i] = findId;
                    this.mMap.put(Integer.valueOf(findId), str);
                    viewById = constraintLayout.getViewById(findId);
                }
                if (viewById != null) {
                    this.mHelperWidget.add(constraintLayout.getViewWidget(viewById));
                }
            }
            this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
        }
    }

    public void validateParams() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).widget = (ConstraintWidget) this.mHelperWidget;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void applyLayoutFeatures() {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            applyLayoutFeatures((ConstraintLayout) parent);
        }
    }

    private int findId(ConstraintLayout constraintLayout, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, constraintLayout, str)) == null) {
            if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
                return 0;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    String str2 = null;
                    try {
                        str2 = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                    }
                    if (str.equals(str2)) {
                        return childAt.getId();
                    }
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, constraintWidgetContainer, helper, sparseArray) == null) {
            helper.removeAllIds();
            for (int i = 0; i < this.mCount; i++) {
                helper.add(sparseArray.get(this.mIds[i]));
            }
        }
    }
}
