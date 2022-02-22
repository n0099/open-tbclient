package com.baidu.sapi2.dto;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AccountCenterDTO extends SapiWebDTO {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PassNameValuePair HIDE_PERSONAL_DATA;
    public static final PassNameValuePair HIDE_REAL_NAME;
    public static String REFER_ACCOUNT_CENTER = "account_center";
    public static String REFER_ACCOUNT_CHECK = "account_check";
    public transient /* synthetic */ FieldHolder $fh;
    public String accountToolsUrl;
    public Drawable backBtnDrawable;
    public String bduss;
    public boolean handleLogin;
    public boolean isBoldTitle;
    public boolean logoutAfterBdussInvalid;
    public List<PassNameValuePair> paramsList;
    public String refer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2120528036, "Lcom/baidu/sapi2/dto/AccountCenterDTO;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2120528036, "Lcom/baidu/sapi2/dto/AccountCenterDTO;");
                return;
            }
        }
        HIDE_PERSONAL_DATA = new PassNameValuePair("personalData", "0");
        HIDE_REAL_NAME = new PassNameValuePair("realname", "0");
    }

    public AccountCenterDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.paramsList = new ArrayList();
        this.refer = REFER_ACCOUNT_CENTER;
        this.logoutAfterBdussInvalid = true;
        this.handleLogin = false;
    }
}
