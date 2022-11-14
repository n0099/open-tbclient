package com.baidu.swan.apps.commonsync;

import androidx.annotation.Nullable;
import com.baidu.searchbox.NoProGuard;
import com.baidu.tieba.f12;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes2.dex */
    public static class MetaItemInfo implements NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appKey;
        public String appName;
        public long createTime;
        public String icon;
        public int payProtected;
        public String scheme;
        public int subCategory;

        public MetaItemInfo() {
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

    public CommonSyncServerData() {
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
        this.count = 0;
    }

    @Nullable
    public static CommonSyncServerData parseFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            CommonSyncServerData commonSyncServerData = new CommonSyncServerData();
            commonSyncServerData.count = jSONObject.optInt("count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("rows");
            if (optJSONArray == null) {
                return null;
            }
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    MetaItemInfo metaItemInfo = new MetaItemInfo();
                    try {
                        metaItemInfo.createTime = optJSONObject.getLong("CreateTime");
                        metaItemInfo.scheme = optJSONObject.getString("Scheme");
                        metaItemInfo.icon = optJSONObject.getString("Icon");
                        metaItemInfo.appName = optJSONObject.getString("AppName");
                        metaItemInfo.subCategory = optJSONObject.getInt("SubCategory");
                        metaItemInfo.appKey = optJSONObject.getString("AppKey");
                        metaItemInfo.payProtected = optJSONObject.getInt("PayProtected");
                    } catch (JSONException e) {
                        f12.l("CommonSyncServerData", "parse item failed:" + optJSONObject.toString(), e);
                        metaItemInfo = null;
                    }
                    if (metaItemInfo != null) {
                        arrayList.add(metaItemInfo);
                    }
                }
            }
            commonSyncServerData.metaItems = arrayList;
            return commonSyncServerData;
        }
        return (CommonSyncServerData) invokeL.objValue;
    }
}
