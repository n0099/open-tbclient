package com.baidu.searchbox.plugin.api;
/* loaded from: classes.dex */
public class PayPluginManager {
    public static final int DIALOG_TYPE_NEGATIVE = 2;
    public static final int DIALOG_TYPE_POSITIVE = 1;
    public static final int RESULT_CODE_CANCEL = 2;
    public static final int RESULT_CODE_ERROR = 6;
    public static final int RESULT_CODE_LOGIN_ERROR = 5;
    public static final int RESULT_CODE_NOSUPPORT = 3;
    public static final int RESULT_CODE_PAYING = 1;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_TOKEN_INVALID = 4;
    public static final int RESULT_CODE_UNKNOWN = -10000;
    public static final int TYPE_ACTION_BAR_RIGHT_ZONE1 = 1;

    /* loaded from: classes.dex */
    public interface IDialogListener {
        void onClicked(int i);
    }

    /* loaded from: classes.dex */
    public interface IPluginPayListener {
        void onActionClicked(String str, int i);

        boolean onBackClicked(String str);

        void onPay(String str, int i, String str2);
    }

    /* loaded from: classes.dex */
    public interface PayPluginCallback {
        void onResult(int i, String str);
    }
}
