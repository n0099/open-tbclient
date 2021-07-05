package android.view.accessibility;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AccessibilityNodeProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HOST_VIEW_ID = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public AccessibilityNodeProvider() {
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

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return null;
        }
        return (AccessibilityNodeInfo) invokeI.objValue;
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            return null;
        }
        return (List) invokeLI.objValue;
    }

    public AccessibilityNodeInfo findFocus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return null;
        }
        return (AccessibilityNodeInfo) invokeI.objValue;
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, bundle)) == null) {
            return false;
        }
        return invokeIIL.booleanValue;
    }
}
