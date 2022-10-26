package com.baidu.searchbox.player.helper;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ViewOpUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewOpUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ViewOpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 != null && view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup.indexOfChild(view2) != -1) {
                    try {
                        BdVideoLog.d(TAG, "removeView " + view2.hashCode());
                        viewGroup.removeView(view2);
                        return true;
                    } catch (Exception e) {
                        BdVideoLog.e("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
