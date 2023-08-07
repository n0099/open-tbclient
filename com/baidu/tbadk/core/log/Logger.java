package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_TYPE = "account";
    public static final String COLLECTION = "collection";
    public static final String FRS_TYPE = "frs";
    public static final String HOME_PAGE_TYPE = "homePage";
    public static final String IMG_TYPE = "img";
    public static final String IM_TYPE = "im";
    public static final String PAY_TYPE = "pay";
    public static final String PB_TYPE = "pb";
    public static final String SEARCH_TYPE = "search";
    public static final String SIGN_ALL = "sign_all";
    public static final String SOCKET_TYPE = "socket";
    public static final String SOSCAIL_SHARE = "socail_share";
    public static final String VIDEO = "video";
    public static final String WRITE = "write";
    public transient /* synthetic */ FieldHolder $fh;

    public Logger() {
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

    public static void addLog(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2, Integer.valueOf(i2), str3, objArr}) == null) {
            BdStatsItem bdStatsItem = new BdStatsItem();
            bdStatsItem.append("cmd", Integer.valueOf(i));
            if (!TextUtils.isEmpty(str2)) {
                bdStatsItem.append("action", str2);
            }
            bdStatsItem.append("errNo", String.valueOf(i2));
            if (!TextUtils.isEmpty(str3) && i2 != 0) {
                bdStatsItem.append(StatConstants.KEY_EXT_ERR_MSG, str3);
            }
            if (objArr != null && objArr.length > 0) {
                bdStatsItem.append(objArr);
            }
            if (i2 == 0) {
                BdStatisticsManager.getInstance().debug(str, j, null, bdStatsItem);
            } else {
                BdStatisticsManager.getInstance().error(str, j, (String) null, bdStatsItem);
            }
        }
    }
}
