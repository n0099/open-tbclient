package c.a.e.j;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends DefaultPackageCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DefaultDownloadCallback f2906a;

    public f(DefaultDownloadCallback defaultDownloadCallback) {
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
        this.f2906a = defaultDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onDegradeData(DegradeData degradeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            super.onDegradeData(degradeData);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onFetchError(ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) || errorInfo == null) {
            return;
        }
        BdLog.e(errorInfo.errorMsg);
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onResultData(ResultData resultData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) || resultData == null) {
            return;
        }
        DebugUtils.log(resultData);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(resultData.addList);
        arrayList.addAll(resultData.updateList);
        if (arrayList.isEmpty()) {
            return;
        }
        DownloadOptions downloadOptions = new DownloadOptions();
        downloadOptions.fileDir = new File(BdBaseApplication.getInst().getFilesDir(), "so_cache").getAbsolutePath();
        PmsManager.getInstance().download(arrayList, downloadOptions, new e(this.f2906a));
    }
}
