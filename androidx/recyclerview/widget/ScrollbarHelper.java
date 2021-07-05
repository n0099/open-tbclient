package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ScrollbarHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScrollbarHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{state, orientationHelper, view, view2, layoutManager, Boolean.valueOf(z)})) == null) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
            }
            return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
        }
        return invokeCommon.intValue;
    }

    public static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{state, orientationHelper, view, view2, layoutManager, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            int max2 = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            if (z2) {
                max = Math.max(0, (state.getItemCount() - max2) - 1);
            } else {
                max = Math.max(0, min);
            }
            return !z ? max : Math.round((max * (Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
        }
        return invokeCommon.intValue;
    }

    public static int computeScrollRange(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{state, orientationHelper, view, view2, layoutManager, Boolean.valueOf(z)})) == null) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return state.getItemCount();
            }
            return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)) * state.getItemCount());
        }
        return invokeCommon.intValue;
    }
}
