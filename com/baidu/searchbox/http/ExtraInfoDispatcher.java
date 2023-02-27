package com.baidu.searchbox.http;

import com.baidu.searchbox.http.callback.ExtraInfoCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class ExtraInfoDispatcher {
    public List<ExtraInfoCallback> mExtraCallbacks = new CopyOnWriteArrayList();

    public void clearCallback() {
        List<ExtraInfoCallback> list = this.mExtraCallbacks;
        if (list != null) {
            list.clear();
        }
    }

    public List<ExtraInfoCallback> getAllCallbacks() {
        return this.mExtraCallbacks;
    }

    public void addCallback(ExtraInfoCallback extraInfoCallback) {
        List<ExtraInfoCallback> list;
        if (!this.mExtraCallbacks.contains(extraInfoCallback) && (list = this.mExtraCallbacks) != null) {
            list.add(extraInfoCallback);
        }
    }

    public void removeCallback(ExtraInfoCallback extraInfoCallback) {
        List<ExtraInfoCallback> list;
        if (extraInfoCallback != null && (list = this.mExtraCallbacks) != null) {
            list.remove(extraInfoCallback);
        }
    }
}
