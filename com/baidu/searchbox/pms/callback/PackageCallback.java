package com.baidu.searchbox.pms.callback;

import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.ResultData;
/* loaded from: classes10.dex */
public interface PackageCallback {
    void onDegradeData(DegradeData degradeData);

    void onFetchError(ErrorInfo errorInfo);

    void onResultData(ResultData resultData);
}
