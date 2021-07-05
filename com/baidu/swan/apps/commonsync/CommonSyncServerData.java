package com.baidu.swan.apps.commonsync;

import com.baidu.searchbox.NoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes4.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("count")
    public int count;
    @SerializedName("rows")
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes4.dex */
    public static class MetaItemInfo implements NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("AppKey")
        public String appKey;
        @SerializedName("AppName")
        public String appName;
        @SerializedName("CreateTime")
        public long createTime;
        @SerializedName("Icon")
        public String icon;
        @SerializedName("PayProtected")
        public int payProtected;
        @SerializedName("Scheme")
        public String scheme;
        @SerializedName("SubCategory")
        public int subCategory;

        public MetaItemInfo() {
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
    }

    public CommonSyncServerData() {
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
        this.count = 0;
    }
}
