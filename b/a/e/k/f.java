package b.a.e.k;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BdAsyncTask<List<PackageInfo>, Integer, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    @SafeVarargs
    /* renamed from: b */
    public final Boolean doInBackground(List<PackageInfo>... listArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
            if (listArr != null && listArr.length != 0) {
                List<PackageInfo> list = listArr[0];
                if (list != null && !list.isEmpty()) {
                    boolean z = true;
                    for (PackageInfo packageInfo : list) {
                        if (packageInfo != null && !StringUtils.isNull(packageInfo.name)) {
                            BdBaseApplication.getInst().getResHashMap().remove(packageInfo.name);
                            File file = new File(i.b(packageInfo.name));
                            if (file.exists() && !file.delete()) {
                                z = false;
                            }
                        }
                    }
                    return Boolean.valueOf(z);
                }
                return Boolean.TRUE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }
}
