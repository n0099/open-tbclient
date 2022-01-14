package com.baidu.searchbox.pms.init.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class RequestTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "pmsRequestTask";
    public transient /* synthetic */ FieldHolder $fh;
    public RequestParams requestParams;

    public RequestTask(@NonNull RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestParams = requestParams;
    }

    private void removeValidChannel(@NonNull RequestParams requestParams) {
        IPmsContext pmsContext;
        List<RequestParams.Channel> channelList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, requestParams) == null) || (pmsContext = PmsRuntime.getPmsContext()) == null || requestParams == null || (channelList = requestParams.getChannelList()) == null) {
            return;
        }
        Iterator<RequestParams.Channel> it = channelList.iterator();
        while (it.hasNext()) {
            if (!pmsContext.checkChannelAllow(it.next().getChannelId(), requestParams.getRunType())) {
                it.remove();
            }
        }
    }

    @Nullable
    public CloudControlRequestInfo createPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            removeValidChannel(this.requestParams);
            return RequestDataUtils.getRequestInfo(this.requestParams, this);
        }
        return (CloudControlRequestInfo) invokeV.objValue;
    }

    @NonNull
    public RequestParams getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.requestParams : (RequestParams) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CloudControlRequestInfo createPostData = createPostData();
            if (this.requestParams != null) {
                if (createPostData == null) {
                    DebugUtils.log("requestInfo is empty");
                    return;
                }
                ArrayList<CloudControlRequestInfo> arrayList = new ArrayList<>();
                arrayList.add(createPostData);
                try {
                    CloudControlManager.getInstance().fetchCloudControl(this.requestParams.getRunType(), arrayList);
                } catch (Exception e2) {
                    DebugUtils.log(e2);
                    ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, e2.getLocalizedMessage()), this.requestParams.getChannelList());
                }
            }
        }
    }
}
