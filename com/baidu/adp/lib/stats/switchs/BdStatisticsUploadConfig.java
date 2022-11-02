package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdStatisticsUploadConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3356496353918792359L;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, BdStatisticsUploadConfigItem> item;

    /* loaded from: classes.dex */
    public static class BdStatisticsUploadConfigItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7225735564387772L;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, BdStatistisUploadChilidItem> childItem;
        public boolean isUpload;
        public boolean isWifi;
        public String type;

        public BdStatisticsUploadConfigItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isUpload = false;
            this.isWifi = true;
            this.childItem = new HashMap<>();
        }
    }

    /* loaded from: classes.dex */
    public static class BdStatistisUploadChilidItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 492107549674799283L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isUpload;
        public boolean isWifi;
        public int maxAlertCount;
        public int percent;
        public String subType;
        public int uploadCycle;

        public BdStatistisUploadChilidItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isUpload = false;
            this.isWifi = true;
            this.percent = -1;
            this.maxAlertCount = 0;
            this.uploadCycle = 1;
        }
    }

    public BdStatisticsUploadConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.item = new HashMap<>();
    }

    public int geUploadCycle(String str, int i) {
        InterceptResult invokeLI;
        BdStatistisUploadChilidItem bdStatistisUploadChilidItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = this.item.get("alert");
            if (bdStatisticsUploadConfigItem == null) {
                return i;
            }
            HashMap<String, BdStatistisUploadChilidItem> hashMap = bdStatisticsUploadConfigItem.childItem;
            if (hashMap != null && (bdStatistisUploadChilidItem = hashMap.get(str)) != null) {
                return bdStatistisUploadChilidItem.uploadCycle;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public int getMaxAlertCount(String str, int i) {
        InterceptResult invokeLI;
        BdStatistisUploadChilidItem bdStatistisUploadChilidItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = this.item.get("alert");
            if (bdStatisticsUploadConfigItem == null) {
                return i;
            }
            HashMap<String, BdStatistisUploadChilidItem> hashMap = bdStatisticsUploadConfigItem.childItem;
            if (hashMap != null && (bdStatistisUploadChilidItem = hashMap.get(str)) != null) {
                return bdStatistisUploadChilidItem.maxAlertCount;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public boolean isUpload(String str, String str2) {
        InterceptResult invokeLL;
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (bdStatisticsUploadConfigItem = this.item.get(str)) == null) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsUploadConfigItem.isUpload;
            }
            BdStatistisUploadChilidItem bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2);
            if (bdStatistisUploadChilidItem == null) {
                return bdStatisticsUploadConfigItem.isUpload;
            }
            if (!bdStatistisUploadChilidItem.isUpload || !bdStatisticsUploadConfigItem.isUpload) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean onlyWifiUpload(String str, String str2) {
        InterceptResult invokeLL;
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (bdStatisticsUploadConfigItem = this.item.get(str)) == null) {
                return true;
            }
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsUploadConfigItem.isWifi;
            }
            BdStatistisUploadChilidItem bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2);
            if (bdStatistisUploadChilidItem == null) {
                return bdStatisticsUploadConfigItem.isWifi;
            }
            if (bdStatistisUploadChilidItem.isWifi) {
                return true;
            }
            return bdStatisticsUploadConfigItem.isWifi;
        }
        return invokeLL.booleanValue;
    }

    public boolean smallFlowUpload(String str, String str2) {
        InterceptResult invokeLL;
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        BdStatistisUploadChilidItem bdStatistisUploadChilidItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (bdStatisticsUploadConfigItem = this.item.get(str)) == null || TextUtils.isEmpty(str2) || (bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2)) == null || 100 == bdStatistisUploadChilidItem.percent || ((int) (Math.random() * 100.0d)) < bdStatistisUploadChilidItem.percent) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
