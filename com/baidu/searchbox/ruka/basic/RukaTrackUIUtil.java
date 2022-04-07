package com.baidu.searchbox.ruka.basic;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RukaTrackUIUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SEPERATOR_ARROR = "->";
    public transient /* synthetic */ FieldHolder $fh;

    public RukaTrackUIUtil() {
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

    public static String trackUI2StringPage(@NonNull TrackUI trackUI) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trackUI)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trackUI.getActivityPage())) {
                sb.append(trackUI.getActivityPage());
                sb.append(trackUI.getActivityPageTag());
            }
            if (!TextUtils.isEmpty(trackUI.getFragmentPage())) {
                sb.append("->");
                sb.append(trackUI.getFragmentPage());
                sb.append(trackUI.getFragmentPageTag());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
