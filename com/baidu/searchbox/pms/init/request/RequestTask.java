package com.baidu.searchbox.pms.init.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.DebugUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class RequestTask implements Runnable {
    public static final String TAG = "pmsRequestTask";
    public RequestParams requestParams;

    public RequestTask(@NonNull RequestParams requestParams) {
        this.requestParams = requestParams;
    }

    private void removeValidChannel(@NonNull RequestParams requestParams) {
        List<RequestParams.Channel> channelList;
        IPmsContext pmsContext = PmsRuntime.getPmsContext();
        if (pmsContext != null && requestParams != null && (channelList = requestParams.getChannelList()) != null) {
            Iterator<RequestParams.Channel> it = channelList.iterator();
            while (it.hasNext()) {
                if (!pmsContext.checkChannelAllow(it.next().getChannelId(), requestParams.getRunType())) {
                    it.remove();
                }
            }
        }
    }

    @Nullable
    public CloudControlRequestInfo createPostData() {
        removeValidChannel(this.requestParams);
        return RequestDataUtils.getRequestInfo(this.requestParams, this);
    }

    @NonNull
    public RequestParams getRequestParams() {
        return this.requestParams;
    }

    @Override // java.lang.Runnable
    public void run() {
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
            } catch (Exception e) {
                DebugUtils.log(e);
                ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, e.getLocalizedMessage()), this.requestParams.getChannelList());
            }
        }
    }
}
