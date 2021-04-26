package com.baidu.down.loopj.android.request.handler;

import com.baidu.down.common.intercepter.ResponseInfo;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.statistic.ThreadSpeedStat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
/* loaded from: classes2.dex */
public interface ICommonRequestHandler {
    void cancelRequest();

    boolean cloneRequest(String str);

    void closeConnection();

    void closeInputStream();

    long getContentLength();

    int getHttpStatus() throws IOException;

    InputStream getInputStream() throws IllegalStateException, IOException;

    ResponseInfo getResponseInfo() throws IOException;

    String getUrl();

    boolean isHttpRequestNull();

    boolean onContainsRequestHeader(String str);

    void onExeHttpConnect(BinaryHttpResponseHandler binaryHttpResponseHandler, ThreadSpeedStat threadSpeedStat, boolean z) throws IOException;

    String onGetHttpHeader(boolean z) throws IOException;

    String onGetRequestHeader(String str);

    String onGetResponseHeader(String str);

    void onHandleFollowRedirect(HashSet<String> hashSet) throws RedirectException;

    void onRemoveRequestHeader(String str);

    boolean onRetryRequest(IOException iOException, int i2, int i3);

    void onSetRequestHeader(String str, String str2);

    void replaceRequest(RetryRequestInfo retryRequestInfo);

    void restoreRequest();

    void saveRequest();

    void setTlsCertSkip(boolean z);
}
