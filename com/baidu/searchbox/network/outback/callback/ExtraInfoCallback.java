package com.baidu.searchbox.network.outback.callback;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public abstract class ExtraInfoCallback {
    public static ExtraInfoDispatcher sExtraInfoDispatcher = new ExtraInfoDispatcher();

    public abstract void onReceiveClientIP(String str);

    /* loaded from: classes4.dex */
    public static final class ExtraInfoDispatcher {
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
            List<ExtraInfoCallback> list2 = this.mExtraCallbacks;
            if ((list2 == null || !list2.contains(extraInfoCallback)) && (list = this.mExtraCallbacks) != null) {
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

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        return sExtraInfoDispatcher;
    }
}
