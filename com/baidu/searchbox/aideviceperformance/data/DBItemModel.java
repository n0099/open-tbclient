package com.baidu.searchbox.aideviceperformance.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class DBItemModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class UserStickinessItemModel {
        public static /* synthetic */ Interceptable $ic;
        public static final int DEFAULT_COUNT = 0;
        public static final long DEFAULT_FIRST_TIME = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, ItemDetailModel> mIdToItemDetailMap;
        public long timeStamp;

        /* loaded from: classes2.dex */
        public static class ItemDetailModel {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int count;
            public long firstTime;

            public ItemDetailModel(int i, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.count = i;
                this.firstTime = j;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return "count: " + this.count + " firstTime: " + this.firstTime;
                }
                return (String) invokeV.objValue;
            }
        }

        public UserStickinessItemModel(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mIdToItemDetailMap = new HashMap<>();
            this.timeStamp = j;
        }

        public UserStickinessItemModel(String str, int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            HashMap<String, ItemDetailModel> hashMap = new HashMap<>();
            this.mIdToItemDetailMap = hashMap;
            this.timeStamp = j2;
            hashMap.put(str, new ItemDetailModel(i, j));
        }

        public HashMap<String, ItemDetailModel> getIdToItemDetailMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mIdToItemDetailMap;
            }
            return (HashMap) invokeV.objValue;
        }

        public void putIdToItemDetailMap(String str, ItemDetailModel itemDetailModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, itemDetailModel) == null) {
                this.mIdToItemDetailMap.put(str, itemDetailModel);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = "timeStamp: " + this.timeStamp;
                for (Map.Entry<String, ItemDetailModel> entry : this.mIdToItemDetailMap.entrySet()) {
                    ItemDetailModel value = entry.getValue();
                    str = str + " id: " + entry.getKey() + " count: " + value.count + " firstTime: " + value.firstTime;
                }
                return str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class LaunchTimeItemModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long launchTime;
        public long timeStamp;

        public LaunchTimeItemModel(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.launchTime = j;
            this.timeStamp = j2;
        }
    }

    public DBItemModel() {
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
