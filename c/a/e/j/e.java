package c.a.e.j;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class e extends DefaultDownloadCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DefaultDownloadCallback f2896a;

    public e(DefaultDownloadCallback defaultDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2896a = defaultDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, packageInfo, errorInfo) == null) || errorInfo == null) {
            return;
        }
        BdLog.e(errorInfo.errorMsg);
        DefaultDownloadCallback defaultDownloadCallback = this.f2896a;
        if (defaultDownloadCallback != null) {
            defaultDownloadCallback.onDownloadError(packageInfo, errorInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
        DefaultDownloadCallback defaultDownloadCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) || packageInfo == null || StringUtils.isNull(packageInfo.filePath) || StringUtils.isNull(packageInfo.name)) {
            return;
        }
        File file = new File(packageInfo.filePath);
        if (file.exists() && file.isFile()) {
            File file2 = new File(BdBaseApplication.getInst().getFilesDir() + File.separator + "so_cache" + File.separator + packageInfo.name);
            if (file2.exists()) {
                file2.delete();
            }
            if (!file.renameTo(file2) || (defaultDownloadCallback = this.f2896a) == null) {
                return;
            }
            defaultDownloadCallback.onDownloadSuccess(packageInfo, errorInfo);
        }
    }
}
