package com.baidu.searchbox.requestpriority;
/* loaded from: classes4.dex */
public interface IRequestCall<T> {
    int getRequestFrom();

    int getRequestSubFrom();

    boolean isFinished();

    void priorityEnqueueWithResponseCallback(T t, T t2);

    void priorityEnqueueWithStatResponseCallback(T t, T t2);

    T priorityExecuteSync() throws Exception;
}
