package com.baidu.searchbox.pms.statistic;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PackageFileStatisticManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "pmsPackageFileStatistic";
    public static volatile PackageFileStatisticManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes2.dex */
    public static class Code {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DOWNLOAD_RESULT_CODE_CANCEL = 4;
        public static final int DOWNLOAD_RESULT_CODE_FRONT_FAILED = 21;
        public static final int DOWNLOAD_RESULT_CODE_INIT = 5;
        public static final int DOWNLOAD_RESULT_CODE_RETRY_FAILED = 3;
        public static final int DOWNLOAD_RESULT_CODE_SILENT_FAILED = 22;
        public static final int DOWNLOAD_RESULT_CODE_SUCCESS = 1;
        public static final int DOWNLOAD_START_CODE_FRONT = 1;
        public static final int DOWNLOAD_START_CODE_SILENT = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public Code() {
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
    }

    public PackageFileStatisticManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static PackageFileStatisticManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (PackageFileStatisticManager.class) {
                    if (sInstance == null) {
                        sInstance = new PackageFileStatisticManager(AppRuntime.getApplication());
                    }
                }
            }
            return sInstance;
        }
        return (PackageFileStatisticManager) invokeV.objValue;
    }

    public void addDownloadStatistic2(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3, Long.valueOf(j), str4, str5, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || StatisticCallbackManager.getInstance(this.mContext).getStatisticCallback().addDownloadStatistic2(i, str, str2, str3, j, str4, str5, i2, i3)) {
            return;
        }
        DebugUtils.log("Host Cannot Handle the addDownloadStatistic2 Callback");
    }

    public void addFetchStatistic2(int i, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, jSONObject}) == null) || StatisticCallbackManager.getInstance(this.mContext).getStatisticCallback().addFetchStatistic2InHost(i, str, str2, jSONObject)) {
            return;
        }
        DebugUtils.log("Host Cannot Handle the addFetchStatistic2 Callback");
    }
}
