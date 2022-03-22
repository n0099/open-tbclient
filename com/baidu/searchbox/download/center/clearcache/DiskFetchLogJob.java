package com.baidu.searchbox.download.center.clearcache;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.retrieve.log.bean.FetchLogBean;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class DiskFetchLogJob extends IFetchJob {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static String DISK_CMD = null;
    public static String DISK_MARK_CMD = null;
    public static String DISK_UNMARK_CMD = null;
    public static final String TAG = "DiskFetchLogJob";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1603160626, "Lcom/baidu/searchbox/download/center/clearcache/DiskFetchLogJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1603160626, "Lcom/baidu/searchbox/download/center/clearcache/DiskFetchLogJob;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        DISK_CMD = "baiduboxapp_write_disk_tree_file_cmd";
        DISK_MARK_CMD = "baiduboxapp_write_disk_tree_mark_cmd";
        DISK_UNMARK_CMD = "baiduboxapp_write_disk_tree_unmark_cmd";
    }

    public DiskFetchLogJob() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchLogBean parseJsonContent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || (parseJsonContent = FetchLog.parseJsonContent(jSONObject)) == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "data " + jSONObject);
        }
        if (parseJsonContent.getSpace() != null) {
            if (parseJsonContent.getSpace().contains(DISK_MARK_CMD)) {
                DiskManager.INSTANCE.setMark(true);
            }
            if (parseJsonContent.getSpace().contains(DISK_UNMARK_CMD)) {
                DiskManager.INSTANCE.setMark(false);
            }
            if (parseJsonContent.getSpace().contains(DISK_CMD)) {
                ClearCacheUbcController.reportBaiduFile(ClearCacheUbcController.REPORT_FILE_TYPE_FISHING_BACK);
            }
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "flow" : (String) invokeV.objValue;
    }
}
