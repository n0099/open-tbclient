package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.common.PassSdkModel;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class ShareActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "sapi_new_share_activity";
    public transient /* synthetic */ FieldHolder $fh;
    public String callType;
    public String fromTpl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2117903119, "Lcom/baidu/sapi2/share/ShareActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2117903119, "Lcom/baidu/sapi2/share/ShareActivity;");
        }
    }

    public ShareActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void checkAuthAccountValid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ShareLoginModel.getInstance().checkAuthAccountValid(getCommonStatParams(), new BdussStatusCallback(this) { // from class: com.baidu.sapi2.share.ShareActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.sapi2.share.BdussStatusCallback
                public void onBdussInvalidate(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString(ShareLoginModel.AUTH_PASS_SDK_VERSION, "9.4.7.8.2");
                        bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, this.this$0.getPackageName());
                        bundle.putString(ShareLoginModel.INVALIDATE_BDUSS, str);
                        intent.putExtras(bundle);
                        this.this$0.setResult(-1, intent);
                        this.this$0.finish();
                    }
                }

                @Override // com.baidu.sapi2.share.BdussStatusCallback
                public void onResultAccount(SapiAccount sapiAccount) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) == null) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        if (sapiAccount != null) {
                            bundle.putParcelable(ShareLoginModel.SHARE_ACCOUNT_INFO, sapiAccount);
                        }
                        bundle.putString(ShareLoginModel.AUTH_PASS_SDK_VERSION, "9.4.7.8.2");
                        bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, this.this$0.getPackageName());
                        if (SapiContext.getInstance().shareLivingunameEnable()) {
                            intent.putExtra(ShareLoginModel.FACE_LOGIN_UIDS, SapiContext.getInstance().getV2FaceLivingUnames());
                        }
                        intent.putExtras(bundle);
                        this.this$0.setResult(-1, intent);
                        this.this$0.finish();
                    }
                }
            });
        }
    }

    private HashMap<String, String> getCommonStatParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_TPL, this.fromTpl);
            hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.callType);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    private void handleInvalid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setResult(-1, new Intent());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatService.onEventAutoStat(ShareStatKey.AUTH_APP_BACK_PRESSED, getCommonStatParams());
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = 1;
            attributes.height = 1;
            attributes.type = 2002;
            attributes.flags = 32;
            window.setAttributes(attributes);
            this.fromTpl = getIntent().getStringExtra(ShareLoginModel.SHARE_LOGIN_FROM_TPL);
            this.callType = getIntent().getStringExtra(ShareLoginModel.SHARE_LOGIN_CALL_TYPE);
            if (!PassSdkModel.getInstance().checkPassSdkInit()) {
                String str = TAG;
                Log.e(str, getPackageName() + " pass sdk没有初始化");
                handleInvalid();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_APP_INVOKED, getCommonStatParams());
            String callingPackage = getCallingPackage();
            if (!PassSdkModel.getInstance().checkPkgSign(this, callingPackage)) {
                HashMap hashMap = new HashMap();
                hashMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_TPL, this.fromTpl);
                hashMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_PKG, callingPackage);
                hashMap.put("tpl", SapiAccountManager.getInstance().getTpl());
                StatService.onEventAutoStat(ShareStatKey.SHARE_APP_PERM_ERROR_WARN, hashMap);
                String str2 = TAG;
                Log.d(str2, callingPackage + "不是已经授权的百度系app");
                handleInvalid();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            checkAuthAccountValid();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
