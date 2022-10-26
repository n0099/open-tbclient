package com.baidu.searchbox.pms.bean;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class ResultData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List addList;
    public List configChangeList;
    public List filterList;
    public List invalidList;
    public List updateList;

    public ResultData() {
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

    private void putString(StringBuilder sb, String str, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, sb, str, list) == null) {
            sb.append(str);
            sb.append(":");
            sb.append(list.size());
            if (list.size() > 0) {
                sb.append(" [");
                for (int i = 0; i < list.size(); i++) {
                    PackageInfo packageInfo = (PackageInfo) list.get(i);
                    if (i == 0) {
                        sb.append(packageInfo.packageName);
                    } else {
                        sb.append(",");
                        sb.append(packageInfo.packageName);
                    }
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            putString(sb, "  addList.size", this.addList);
            putString(sb, "  updateList.size", this.updateList);
            putString(sb, "  configChangeList.size", this.configChangeList);
            putString(sb, "  filterList.size", this.filterList);
            putString(sb, "  invalidList.size", this.invalidList);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
