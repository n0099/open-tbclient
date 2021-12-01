package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.PackageParams;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.utils.CollectionUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Channel> channelList;
    public JSONObject filter;
    public String runNode;
    public String runType;

    public RequestParams() {
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

    public RequestParams addChannel(Channel channel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, channel)) == null) {
            if (channel == null) {
                if (PmsConstant.DEBUG) {
                    throw new RuntimeException("channel should not be null");
                }
                return this;
            } else if (!channel.isFetchAllPackages && CollectionUtils.isEmpty(channel.packageParamsList) && channel.dataInterceptor == null) {
                if (PmsConstant.DEBUG) {
                    throw new RuntimeException("packageNames should not be empty");
                }
                return this;
            } else {
                if (this.channelList == null) {
                    this.channelList = new ArrayList();
                }
                for (int i2 = 0; i2 < this.channelList.size(); i2++) {
                    Channel channel2 = this.channelList.get(i2);
                    if (TextUtils.equals(channel2.channelId, channel.channelId)) {
                        if (PmsConstant.DEBUG) {
                            throw new RuntimeException("请求任务channelId不能重复" + channel2.channelId + "," + channel.channelId);
                        }
                        this.channelList.set(i2, channel2);
                        return this;
                    }
                }
                this.channelList.add(channel);
                return this;
            }
        }
        return (RequestParams) invokeL.objValue;
    }

    public List<Channel> getChannelList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.channelList : (List) invokeV.objValue;
    }

    public JSONObject getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.filter : (JSONObject) invokeV.objValue;
    }

    public String getRunNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.runNode : (String) invokeV.objValue;
    }

    public String getRunType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.runType : (String) invokeV.objValue;
    }

    public RequestParams setFilter(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            this.filter = jSONObject;
            return this;
        }
        return (RequestParams) invokeL.objValue;
    }

    public RequestParams setRunNode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.runNode = str;
            return this;
        }
        return (RequestParams) invokeL.objValue;
    }

    public RequestParams setRunType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.runType = str;
            return this;
        }
        return (RequestParams) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public static class Channel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PackageCallback callback;
        public String channelId;
        public IDataInterceptor dataInterceptor;
        public boolean isFetchAllPackages;
        public boolean isUsePmsVersionData;
        public List<String> packageNames;
        public List<PackageParams> packageParamsList;

        public Channel() {
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
            this.isUsePmsVersionData = true;
        }

        public PackageCallback getCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callback : (PackageCallback) invokeV.objValue;
        }

        public String getChannelId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.channelId : (String) invokeV.objValue;
        }

        public IDataInterceptor getDataInterceptor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dataInterceptor : (IDataInterceptor) invokeV.objValue;
        }

        public List<String> getPackageNames() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.packageNames : (List) invokeV.objValue;
        }

        public List<PackageParams> getPackageParamsList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.packageParamsList : (List) invokeV.objValue;
        }

        public boolean isFetchAllPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isFetchAllPackages : invokeV.booleanValue;
        }

        public boolean isUsePmsVersionData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isUsePmsVersionData : invokeV.booleanValue;
        }

        public Channel setCallback(PackageCallback packageCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, packageCallback)) == null) {
                this.callback = packageCallback;
                return this;
            }
            return (Channel) invokeL.objValue;
        }

        public Channel setChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.channelId = str;
                return this;
            }
            return (Channel) invokeL.objValue;
        }

        public Channel setDataInterceptor(IDataInterceptor iDataInterceptor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iDataInterceptor)) == null) {
                this.dataInterceptor = iDataInterceptor;
                return this;
            }
            return (Channel) invokeL.objValue;
        }

        public Channel setFetchAllPackages(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.isFetchAllPackages = z;
                return this;
            }
            return (Channel) invokeZ.objValue;
        }

        public Channel setPackageNames(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, list)) == null) {
                this.packageNames = list;
                this.packageParamsList = CollectionUtils.convertToPackageParamsList(list);
                this.isUsePmsVersionData = true;
                return this;
            }
            return (Channel) invokeL.objValue;
        }

        public Channel setPackageParamsList(List<PackageParams> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
                this.packageParamsList = list;
                this.isUsePmsVersionData = false;
                return this;
            }
            return (Channel) invokeL.objValue;
        }

        public Channel(String str, List<String> list, PackageCallback packageCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list, packageCallback};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.isUsePmsVersionData = true;
            this.channelId = str;
            this.packageNames = list;
            this.callback = packageCallback;
            this.packageParamsList = CollectionUtils.convertToPackageParamsList(list);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Channel(String str, String str2, PackageCallback packageCallback) {
            this(str, TextUtils.isEmpty(str2) ? null : Collections.singletonList(str2), packageCallback);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, packageCallback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (List) objArr2[1], (PackageCallback) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public Channel(String str, boolean z, PackageCallback packageCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), packageCallback};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.isUsePmsVersionData = true;
            this.channelId = str;
            this.isFetchAllPackages = z;
            this.callback = packageCallback;
        }
    }
}
