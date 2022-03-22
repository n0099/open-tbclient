package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LoginDialogActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGIN_DIALOG_DATA_LOCATE = "login_dialog_data_locate";
    public static final String LOGIN_DIALOG_DATA_TYPE = "login_dialog_data_type";
    public static final String LOGIN_DIALOG_DATA_URL = "login_dialog_data_url";
    public static final String LOGIN_DIALOG_LOGIN_LISTENER = "login_dialog_login_listener";
    public static final String MINE_PAGE_LOGIN_DIALOG_DATA_KEY = "mine_page_login_dialog_data_key";
    public static final String MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE = "mine_page_login_dialog_data_locate";
    public static final String ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM = "one_key_login_encrypt_phone_num";
    public static final String ONE_KEY_LOGIN_OPERATOR = "one_key_login_operator";
    public static final String ONE_KEY_LOGIN_SIGN = "one_key_login_sign";
    public static final String SHARE_MODEL_JSON_STRING = "share_model_json_string";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginDialogActivityConfig(LoginDialogData loginDialogData, @NonNull String str) {
        this(loginDialogData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {loginDialogData, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((LoginDialogData) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(SHARE_MODEL_JSON_STRING, str);
        getIntent().putExtra(LOGIN_DIALOG_DATA_TYPE, DialogLoginHelper.DIALOG_TYPE_SHARE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginDialogActivityConfig(LoginDialogData loginDialogData, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this(loginDialogData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {loginDialogData, str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((LoginDialogData) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM, str);
        getIntent().putExtra(ONE_KEY_LOGIN_OPERATOR, str2);
        getIntent().putExtra(ONE_KEY_LOGIN_SIGN, str3);
        getIntent().putExtra(LOGIN_DIALOG_DATA_TYPE, DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginDialogActivityConfig(LoginDialogData loginDialogData) {
        super(loginDialogData.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {loginDialogData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(LOGIN_DIALOG_DATA_LOCATE, loginDialogData.getLocate());
        getIntent().putExtra(MINE_PAGE_LOGIN_DIALOG_DATA_KEY, loginDialogData.getMinePageKey());
        getIntent().putExtra(MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE, loginDialogData.getMinePageLocate());
        if (loginDialogData.getLoginListener() != null) {
            getIntent().putExtra("login_dialog_login_listener", loginDialogData.getLoginListener());
        }
        String locate = loginDialogData.getLocate();
        char c2 = 65535;
        switch (locate.hashCode()) {
            case -1723264065:
                if (locate.equals(LoginDialogData.PB_COLLECT_RESULT_PAGE)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1142545818:
                if (locate.equals(LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) {
                    c2 = 2;
                    break;
                }
                break;
            case -652469911:
                if (locate.equals(LoginDialogData.PB_REPLY_RESULT_PAGE)) {
                    c2 = 4;
                    break;
                }
                break;
            case -360946952:
                if (locate.equals(LoginDialogData.FIRST_LOGIN_ABTEST)) {
                    c2 = 6;
                    break;
                }
                break;
            case -72485631:
                if (locate.equals(LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE)) {
                    c2 = 3;
                    break;
                }
                break;
            case 844222914:
                if (locate.equals(LoginDialogData.PB_MORE_REPLY_RESULT_PAGE)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1683575996:
                if (locate.equals(LoginDialogData.SEARCH_RESULT_PAGE)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
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
                getIntent().putExtra(LOGIN_DIALOG_DATA_URL, loginDialogData.getUrl());
                return;
            case 6:
                setRequestCode(25059);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            default:
                return;
        }
    }
}
