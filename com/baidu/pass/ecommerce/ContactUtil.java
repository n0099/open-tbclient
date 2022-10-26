package com.baidu.pass.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.callback.GetContactCallback;
import com.baidu.pass.ecommerce.result.GetContactResult;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.activity.GetContactActivty;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ContactUtil {
    public static /* synthetic */ Interceptable $ic;
    public static ContactUtil instance;
    public transient /* synthetic */ FieldHolder $fh;
    public GetContactCallback getContactCallback;

    public ContactUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized ContactUtil getInstance() {
        InterceptResult invokeV;
        ContactUtil contactUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ContactUtil.class) {
                if (instance == null) {
                    instance = new ContactUtil();
                }
                contactUtil = instance;
            }
            return contactUtil;
        }
        return (ContactUtil) invokeV.objValue;
    }

    public GetContactCallback getGetContactCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.getContactCallback;
        }
        return (GetContactCallback) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.getContactCallback = null;
            instance = null;
        }
    }

    public static String hidePhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.length() <= 0) {
                return "";
            }
            if (str.length() == 11 && str.startsWith("1")) {
                return new StringBuilder(str).replace(3, 9, "******").toString();
            }
            if (str.length() == 14 && str.startsWith("+861")) {
                return new StringBuilder(str).replace(6, 12, "******").toString();
            }
            if (str.length() < 7) {
                return str;
            }
            int indexOf = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
            if (indexOf != -1 && ((str.length() - indexOf) + 1 == 8 || (str.length() - indexOf) + 1 == 7)) {
                return new StringBuilder(str).replace(indexOf, str.length() - 3, "*****").toString();
            }
            return new StringBuilder(str).replace(0, str.length() - 3, "*****").toString();
        }
        return (String) invokeL.objValue;
    }

    public void requestContact(Context context, GetContactCallback getContactCallback) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, getContactCallback) == null) {
            this.getContactCallback = new GetContactCallback(this, getContactCallback) { // from class: com.baidu.pass.ecommerce.ContactUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ContactUtil this$0;
                public final /* synthetic */ GetContactCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, getContactCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = getContactCallback;
                }

                @Override // com.baidu.pass.ecommerce.callback.GetContactCallback
                public void onCall(GetContactResult getContactResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getContactResult) == null) {
                        this.val$callback.onCall(getContactResult);
                        this.this$0.release();
                    }
                }
            };
            if (!SapiAccountManager.getInstance().getConfignation().isNightMode && !SapiAccountManager.getInstance().getConfignation().isDarkMode) {
                z = false;
            } else {
                z = true;
            }
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.isDarkMode = z;
            permissionsDTO.context = context.getApplicationContext();
            permissionsDTO.permissions = new String[]{"android.permission.READ_CONTACTS"};
            permissionsDTO.dialogTitle = "通讯录权限";
            permissionsDTO.dialogMsg = "如你选择通过通讯录添加联系人信息，则请允许" + SapiUtils.getAppName(context) + "使用通讯录权限。你可以通过系统\"设置\"进行权限的管理";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this, context) { // from class: com.baidu.pass.ecommerce.ContactUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ContactUtil this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        GetContactResult getContactResult = new GetContactResult();
                        getContactResult.setResultCode(-901);
                        this.this$0.getContactCallback.onCall(getContactResult);
                    }
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Intent intent = new Intent(this.val$context, GetContactActivty.class);
                        Context context2 = this.val$context;
                        if (context2 instanceof Activity) {
                            context2.startActivity(intent);
                            return;
                        }
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.val$context.startActivity(intent);
                    }
                }
            });
        }
    }
}
