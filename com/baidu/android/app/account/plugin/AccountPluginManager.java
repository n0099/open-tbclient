package com.baidu.android.app.account.plugin;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AccountPluginManager {

    /* loaded from: classes.dex */
    public interface OnBindPhoneListener {
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }

    /* loaded from: classes.dex */
    public interface OnPluginGetBoxAccountListener {
        public static final int ERROR_BDUSS_EXPIRED = -1;
        public static final int ERROR_COMMON = -3;
        public static final int ERROR_NETWORK_FAILED = -2;

        void onFailed(int i);

        void onSuccess(JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public interface OnPluginGetDynamicPwdListener {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i);
    }

    /* loaded from: classes.dex */
    public interface OnPluginLoginResultListener {
        public static final int CANCELD = -2;
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }

    /* loaded from: classes.dex */
    public interface OnPluginSmsLoginListener {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i);
    }
}
