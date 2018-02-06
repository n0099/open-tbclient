package com.baidu.graph.sdk.framework.bdbox;
/* loaded from: classes3.dex */
public final class AccountPluginManager {

    /* loaded from: classes3.dex */
    public interface OnBindPhoneListener {
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }

    /* loaded from: classes3.dex */
    public interface OnPluginGetDynamicPwdListener {
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }

    /* loaded from: classes3.dex */
    public interface OnPluginLoginResultListener {
        public static final int CANCELD = -2;
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }

    /* loaded from: classes3.dex */
    public interface OnPluginSmsLoginListener {
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }
}
