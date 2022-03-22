package com.baidu.ar.plugin.helper;

import android.content.ComponentName;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class ComponentNameComparator implements Comparator<ComponentName> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ComponentNameComparator() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(ComponentName componentName, ComponentName componentName2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, componentName, componentName2)) == null) {
            if (componentName == null && componentName2 == null) {
                return 0;
            }
            if (componentName == null || componentName2 != null) {
                if (componentName != null || componentName2 == null) {
                    if (componentName == null || componentName2 == null) {
                        return 0;
                    }
                    if (TextUtils.equals(componentName.getPackageName(), componentName2.getPackageName()) && TextUtils.equals(componentName.getShortClassName(), componentName2.getShortClassName())) {
                        return 0;
                    }
                    if (componentName != null) {
                        return componentName.compareTo(componentName2);
                    }
                    return -1;
                }
                return -1;
            }
            return 1;
        }
        return invokeLL.intValue;
    }
}
