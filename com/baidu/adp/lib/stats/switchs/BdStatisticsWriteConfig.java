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
/* loaded from: classes4.dex */
public class BdStatisticsWriteConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7184457133962107119L;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, BdStatisticsWriteConfigItem> item;

    /* loaded from: classes4.dex */
    public static class BdStatisticsWriteChildItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2371610422804472309L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isWrite;
        public String subType;

        public BdStatisticsWriteChildItem() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isWrite() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.isWrite : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class BdStatisticsWriteConfigItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4440010439026244319L;
        public transient /* synthetic */ FieldHolder $fh;
        public final HashMap<String, BdStatisticsWriteChildItem> childItem;
        public boolean isExac;
        public boolean isWrite;
        public int particleNum;
        public String type;

        public BdStatisticsWriteConfigItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isWrite = false;
            this.particleNum = -1;
            this.isExac = false;
            this.childItem = new HashMap<>();
        }
    }

    public BdStatisticsWriteConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.item = new HashMap<>();
    }

    public boolean isExactWriteFile(String str) {
        InterceptResult invokeL;
        BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (bdStatisticsWriteConfigItem = this.item.get(str)) == null || !bdStatisticsWriteConfigItem.isExac) ? false : true : invokeL.booleanValue;
    }

    public boolean isWrite(String str, String str2) {
        InterceptResult invokeLL;
        BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (bdStatisticsWriteConfigItem = this.item.get(str)) == null) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsWriteConfigItem.isWrite;
            }
            BdStatisticsWriteChildItem bdStatisticsWriteChildItem = bdStatisticsWriteConfigItem.childItem.get(str2);
            if (bdStatisticsWriteChildItem == null) {
                return bdStatisticsWriteConfigItem.isWrite;
            }
            return bdStatisticsWriteChildItem.isWrite() && bdStatisticsWriteConfigItem.isWrite;
        }
        return invokeLL.booleanValue;
    }
}
