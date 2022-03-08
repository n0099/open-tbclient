package com.baidu.searchbox.player.helper;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ViewOpUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewOpUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ViewOpUtils() {
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

    @PublicMethod
    public static boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                    return true;
                } catch (Exception e2) {
                    BdVideoLog.e("removeView(" + System.identityHashCode(view) + SmallTailInfo.EMOTION_SUFFIX, e2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
