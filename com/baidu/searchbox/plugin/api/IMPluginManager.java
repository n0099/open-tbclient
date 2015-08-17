package com.baidu.searchbox.plugin.api;

import java.util.List;
/* loaded from: classes.dex */
public final class IMPluginManager {
    public static final int ERROR_CODE_FAILED = 1;
    public static final int ERROR_CODE_SUCCESS = 0;

    /* loaded from: classes.dex */
    public interface IPluginAcceptPaPushListener {
        void onAcceptPaPushResult(int i, long j);
    }

    /* loaded from: classes.dex */
    public interface IPluginFetchMessageListener {
        void onFetchMessageResult(int i, List<String> list);
    }

    /* loaded from: classes.dex */
    public interface IPluginGenBcsObjectUrlListener {
    }

    /* loaded from: classes.dex */
    public interface IPluginGetPaInfoListener {
        void onGetPaInfoResult(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface IPluginIsSubscribedListener {
        void onIsSubscribedResult(int i, long j, boolean z);
    }

    /* loaded from: classes.dex */
    public interface IPluginMessageReceiveListener {
        void onReceiveMessage(int i, int i2, List<String> list);
    }

    /* loaded from: classes.dex */
    public interface IPluginPaSubscriptionChangeListener {
        void onPaSubscriptionChangeResult(long j, boolean z);
    }

    /* loaded from: classes.dex */
    public interface IPluginQuerySubscribedPaListListener {
        void onQuerySubscribedPaResult(int i, List<String> list);
    }

    /* loaded from: classes.dex */
    public interface IPluginSendMessageListener {
    }

    /* loaded from: classes.dex */
    public interface IPluginSubscribePaListener {
        void onSubscribePaResult(int i, long j);

        void onUnSubscribePaResult(int i, long j);
    }

    private IMPluginManager() {
    }
}
