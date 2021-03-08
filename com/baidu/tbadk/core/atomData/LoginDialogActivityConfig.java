package com.baidu.tbadk.core.atomData;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LoginDialogActivityConfig extends IntentConfig {
    public static final String LOGIN_DIALOG_DATA_LOCATE = "login_dialog_data_locate";
    public static final String LOGIN_DIALOG_DATA_TYPE = "login_dialog_data_type";
    public static final String LOGIN_DIALOG_DATA_URL = "login_dialog_data_url";
    public static final String ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM = "one_key_login_encrypt_phone_num";
    public static final String ONE_KEY_LOGIN_OPERATOR = "one_key_login_operator";
    public static final String ONE_KEY_LOGIN_SIGN = "one_key_login_sign";
    public static final String SHARE_MODEL_JSON_STRING = "share_model_json_string";

    public LoginDialogActivityConfig(ar arVar, @NonNull String str) {
        this(arVar);
        getIntent().putExtra(SHARE_MODEL_JSON_STRING, str);
        getIntent().putExtra(LOGIN_DIALOG_DATA_TYPE, "hutongdenglu");
    }

    public LoginDialogActivityConfig(ar arVar, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this(arVar);
        getIntent().putExtra(ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM, str);
        getIntent().putExtra(ONE_KEY_LOGIN_OPERATOR, str2);
        getIntent().putExtra(ONE_KEY_LOGIN_SIGN, str3);
        getIntent().putExtra(LOGIN_DIALOG_DATA_TYPE, "yijiandenglu");
    }

    private LoginDialogActivityConfig(ar arVar) {
        super(arVar.getContext());
        getIntent().putExtra(LOGIN_DIALOG_DATA_LOCATE, arVar.bmm());
        String bmm = arVar.bmm();
        char c = 65535;
        switch (bmm.hashCode()) {
            case -1723264065:
                if (bmm.equals("pb_shoucang")) {
                    c = 1;
                    break;
                }
                break;
            case -1142545818:
                if (bmm.equals("frs_fabu")) {
                    c = 2;
                    break;
                }
                break;
            case -652469911:
                if (bmm.equals("pb_huifu_louzhonglou")) {
                    c = 4;
                    break;
                }
                break;
            case -72485631:
                if (bmm.equals("pb_huitie")) {
                    c = 3;
                    break;
                }
                break;
            case 844222914:
                if (bmm.equals("pb_chakanhuifu")) {
                    c = 0;
                    break;
                }
                break;
            case 1683575996:
                if (bmm.equals("sousuo_dianji")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setRequestCode(25055);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            case 1:
                setRequestCode(25058);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            case 2:
                setRequestCode(25054);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            case 3:
                setRequestCode(25057);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            case 4:
                setRequestCode(25056);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            case 5:
                getIntent().putExtra(LOGIN_DIALOG_DATA_URL, arVar.getUrl());
                return;
            default:
                return;
        }
    }
}
