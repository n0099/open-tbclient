package com.baidu.ar.task;
/* loaded from: classes3.dex */
public interface ActionResponseListener<T> extends HttpResponseListener<T> {
    void onProgress(int i);

    void onUpdate(boolean z, float f);
}
