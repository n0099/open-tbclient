package com.baidu.searchbox.pms.bean;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ResultData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PackageInfo> addList;
    public List<PackageInfo> configChangeList;
    public List<PackageInfo> filterList;
    public List<PackageInfo> invalidList;
    public List<PackageInfo> updateList;

    public ResultData() {
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

    private void putString(StringBuilder sb, String str, List<PackageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, sb, str, list) == null) {
            sb.append(str);
            sb.append(":");
            sb.append(list.size());
            if (list.size() > 0) {
                sb.append(" [");
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PackageInfo packageInfo = list.get(i2);
                    if (i2 == 0) {
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
