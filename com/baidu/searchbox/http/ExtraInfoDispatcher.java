package com.baidu.searchbox.http;

import com.baidu.searchbox.http.callback.ExtraInfoCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes16.dex */
public final class ExtraInfoDispatcher {
    private List<ExtraInfoCallback> mExtraCallbacks = new CopyOnWriteArrayList();

    public void addCallback(ExtraInfoCallback extraInfoCallback) {
        if (!this.mExtraCallbacks.contains(extraInfoCallback) && this.mExtraCallbacks != null) {
            this.mExtraCallbacks.add(extraInfoCallback);
        }
    }

    public void removeCallback(ExtraInfoCallback extraInfoCallback) {
        if (extraInfoCallback != null && this.mExtraCallbacks != null) {
            this.mExtraCallbacks.remove(extraInfoCallback);
        }
    }

    public void clearCallback() {
        if (this.mExtraCallbacks != null) {
            this.mExtraCallbacks.clear();
        }
    }

    public List<ExtraInfoCallback> getAllCallbacks() {
        return this.mExtraCallbacks;
    }
}
