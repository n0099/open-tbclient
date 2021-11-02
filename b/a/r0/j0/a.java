package b.a.r0.j0;

import android.content.pm.PackageInfo;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static Map<String, Integer> a() {
        InterceptResult invokeV;
        List<PackageInfo> installedPackages;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                synchronized (a.class) {
                    installedPackages = TbadkApplication.getInst().getPackageManager().getInstalledPackages(64);
                }
                if (ListUtils.getCount(installedPackages) == 0) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (PackageInfo packageInfo : installedPackages) {
                    hashMap.put(packageInfo.packageName, Integer.valueOf(packageInfo.versionCode));
                }
                return hashMap;
            } catch (Exception e2) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    e2.printStackTrace();
                    return null;
                }
                throw e2;
            }
        }
        return (Map) invokeV.objValue;
    }
}
