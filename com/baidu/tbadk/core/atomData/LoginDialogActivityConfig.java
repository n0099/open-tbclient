package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.s0;
/* loaded from: classes3.dex */
public class LoginDialogActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGIN_DIALOG_DATA_LOCATE = "login_dialog_data_locate";
    public static final String LOGIN_DIALOG_DATA_TYPE = "login_dialog_data_type";
    public static final String LOGIN_DIALOG_DATA_URL = "login_dialog_data_url";
    public static final String LOGIN_DIALOG_LOGIN_LISTENER = "login_dialog_login_listener";
    public static final String ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM = "one_key_login_encrypt_phone_num";
    public static final String ONE_KEY_LOGIN_OPERATOR = "one_key_login_operator";
    public static final String ONE_KEY_LOGIN_SIGN = "one_key_login_sign";
    public static final String SHARE_MODEL_JSON_STRING = "share_model_json_string";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginDialogActivityConfig(s0 s0Var, @NonNull String str) {
        this(s0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((s0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(SHARE_MODEL_JSON_STRING, str);
        getIntent().putExtra(LOGIN_DIALOG_DATA_TYPE, DialogLoginHelper.DIALOG_TYPE_SHARE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginDialogActivityConfig(s0 s0Var, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this(s0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var, str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((s0) newInitContext.callArgs[0]);
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
    public LoginDialogActivityConfig(s0 s0Var) {
        super(s0Var.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(LOGIN_DIALOG_DATA_LOCATE, s0Var.b());
        if (s0Var.c() != null) {
            getIntent().putExtra("login_dialog_login_listener", s0Var.c());
        }
        String b2 = s0Var.b();
        char c2 = 65535;
        switch (b2.hashCode()) {
            case -1723264065:
                if (b2.equals("pb_shoucang")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1142545818:
                if (b2.equals("frs_fabu")) {
                    c2 = 2;
                    break;
                }
                break;
            case -652469911:
                if (b2.equals("pb_huifu_louzhonglou")) {
                    c2 = 4;
                    break;
                }
                break;
            case -360946952:
                if (b2.equals("first_login_abtest")) {
                    c2 = 6;
                    break;
                }
                break;
            case -72485631:
                if (b2.equals("pb_huitie")) {
                    c2 = 3;
                    break;
                }
                break;
            case 844222914:
                if (b2.equals("pb_chakanhuifu")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1683575996:
                if (b2.equals("sousuo_dianji")) {
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
                getIntent().putExtra(LOGIN_DIALOG_DATA_URL, s0Var.d());
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
