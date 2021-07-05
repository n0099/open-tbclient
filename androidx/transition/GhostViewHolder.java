package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class GhostViewHolder extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAttached;
    @NonNull
    public ViewGroup mParent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    public static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewGroup)) == null) ? (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder) : (GhostViewHolder) invokeL.objValue;
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, arrayList)) == null) {
            ArrayList arrayList2 = new ArrayList();
            int childCount = getChildCount() - 1;
            int i2 = 0;
            while (i2 <= childCount) {
                int i3 = (i2 + childCount) / 2;
                getParents(((GhostViewPort) getChildAt(i3)).mView, arrayList2);
                if (isOnTop(arrayList, arrayList2)) {
                    i2 = i3 + 1;
                } else {
                    childCount = i3 - 1;
                }
                arrayList2.clear();
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void getParents(View view, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, arrayList) == null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                getParents((View) parent, arrayList);
            }
            arrayList.add(view);
        }
    }

    public static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, arrayList, arrayList2)) == null) {
            if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
                return true;
            }
            int min = Math.min(arrayList.size(), arrayList2.size());
            for (int i2 = 1; i2 < min; i2++) {
                View view = arrayList.get(i2);
                View view2 = arrayList2.get(i2);
                if (view != view2) {
                    return isOnTop(view, view2);
                }
            }
            return arrayList2.size() == min;
        }
        return invokeLL.booleanValue;
    }

    public void addGhostView(GhostViewPort ghostViewPort) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ghostViewPort) == null) {
            ArrayList<View> arrayList = new ArrayList<>();
            getParents(ghostViewPort.mView, arrayList);
            int insertIndex = getInsertIndex(arrayList);
            if (insertIndex >= 0 && insertIndex < getChildCount()) {
                addView(ghostViewPort, insertIndex);
            } else {
                addView(ghostViewPort);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.mAttached) {
                super.onViewAdded(view);
                return;
            }
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onViewRemoved(view);
            if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
                this.mParent.setTag(R.id.ghost_view_holder, null);
                ViewGroupUtils.getOverlay(this.mParent).remove(this);
                this.mAttached = false;
            }
        }
    }

    public void popToOverlayTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mAttached) {
                ViewGroupUtils.getOverlay(this.mParent).remove(this);
                ViewGroupUtils.getOverlay(this.mParent).add(this);
                return;
            }
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
    }

    public static boolean isOnTop(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, view, view2)) == null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
                return view.getZ() > view2.getZ();
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i2));
                if (childAt == view) {
                    return false;
                }
                if (childAt == view2) {
                    break;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
