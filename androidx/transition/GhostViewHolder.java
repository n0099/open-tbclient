package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090cc7, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    public static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewGroup)) == null) {
            return (GhostViewHolder) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090cc7);
        }
        return (GhostViewHolder) invokeL.objValue;
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
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (this.mAttached) {
                super.onViewAdded(view2);
                return;
            }
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, arrayList)) == null) {
            ArrayList arrayList2 = new ArrayList();
            int childCount = getChildCount() - 1;
            int i = 0;
            while (i <= childCount) {
                int i2 = (i + childCount) / 2;
                getParents(((GhostViewPort) getChildAt(i2)).mView, arrayList2);
                if (isOnTop(arrayList, arrayList2)) {
                    i = i2 + 1;
                } else {
                    childCount = i2 - 1;
                }
                arrayList2.clear();
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onViewRemoved(view2);
            if ((getChildCount() == 1 && getChildAt(0) == view2) || getChildCount() == 0) {
                this.mParent.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090cc7, null);
                ViewGroupUtils.getOverlay(this.mParent).remove(this);
                this.mAttached = false;
            }
        }
    }

    public static void getParents(View view2, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, arrayList) == null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                getParents((View) parent, arrayList);
            }
            arrayList.add(view2);
        }
    }

    public static boolean isOnTop(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, view3)) == null) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int childCount = viewGroup.getChildCount();
            if (Build.VERSION.SDK_INT >= 21 && view2.getZ() != view3.getZ()) {
                if (view2.getZ() <= view3.getZ()) {
                    return false;
                }
                return true;
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i));
                if (childAt == view2) {
                    return false;
                }
                if (childAt == view3) {
                    break;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, arrayList, arrayList2)) == null) {
            if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
                return true;
            }
            int min = Math.min(arrayList.size(), arrayList2.size());
            for (int i = 1; i < min; i++) {
                View view2 = arrayList.get(i);
                View view3 = arrayList2.get(i);
                if (view2 != view3) {
                    return isOnTop(view2, view3);
                }
            }
            if (arrayList2.size() == min) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
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
}
