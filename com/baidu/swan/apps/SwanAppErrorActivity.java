package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.de3;
import com.repackage.fe4;
import com.repackage.gl2;
import com.repackage.ix2;
import com.repackage.kx2;
import com.repackage.qj2;
import com.repackage.qz1;
import com.repackage.t23;
import com.repackage.tg1;
import com.repackage.y53;
/* loaded from: classes2.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int INVALID_ANIM = 0;
    public static final String KEY_ERROR_FORBIDDEN_INFO = "swan_error_forbidden_info";
    public static final String KEY_ERROR_MENU_NOTICE_COUNT = "swan_error_menu_notice_count";
    public static final String KEY_ERROR_MENU_PRIVACY_COUNT = "swan_error_menu_privacy_count";
    public static final String KEY_SWAN_ERROR_CODE = "swan_error_code";
    public static final String KEY_SWAN_ERROR_TYPE = "swan_error_type";
    public static final String KEY_SWAN_WEB_PERMIT = "webPermit";
    public static final String KEY_SWAN_WEB_URL = "webUrl";
    public static final int SHOW_MENU_NOTICE_DEFAULT = 0;
    public static final String TAG = "SwanAppErrorActivity";
    public static final String TYPE_APP_FORBIDDEN = "type_app_forbidden";
    public static final String TYPE_DISK_LACK = "type_2205";
    public static final String TYPE_LOAD_V8_FAILED = "type_load_v8_failed";
    public static final String TYPE_MEMORY_LACK = "type_0049";
    public static final String TYPE_NEED_UPDATE_SDK = "type_need_update_sdk";
    public static final String TYPE_NETWORK_ERROR = "type_network_error";
    public static final String TYPE_NORMAL = "type_normal";
    public static final String TYPE_PATH_FORBIDDEN = "type_path_forbidden";
    public transient /* synthetic */ FieldHolder $fh;
    public int mEnterAnimWhenFinishing;
    public String mErrorCode;
    public String mErrorType;
    public int mExitAnimWhenFinishing;
    public ForbiddenInfo mForbiddenInfo;
    public gl2 mLaunchInfo;
    public int mMenuNoticeCount;
    public int mMenuPrivateCount;
    public y53 mSkinDecorator;
    public int mWebPermit;
    public String mWebUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537864007, "Lcom/baidu/swan/apps/SwanAppErrorActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(537864007, "Lcom/baidu/swan/apps/SwanAppErrorActivity;");
                return;
            }
        }
        DEBUG = tg1.a;
    }

    public SwanAppErrorActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSkinDecorator = null;
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
        this.mErrorCode = "";
    }

    private void loadFragment() {
        qz1 qz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            fe4 a = getSupportFragmentManager().a();
            if (getIntent() != null) {
                qz1Var = qz1.e3(this.mErrorCode, this.mErrorType, this.mWebUrl, this.mWebPermit, this.mForbiddenInfo, this.mMenuNoticeCount, this.mMenuPrivateCount);
            } else if (this.mLaunchInfo == null) {
                if (DEBUG) {
                    Log.e(TAG, "launchInfo is null,error");
                    return;
                }
                return;
            } else {
                qz1Var = new qz1();
            }
            a.a(R.id.obfuscated_res_0x7f09017e, qz1Var);
            a.e();
        }
    }

    private void parseIntent(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, intent) == null) || intent == null) {
            return;
        }
        this.mLaunchInfo = gl2.d1(intent);
        this.mForbiddenInfo = (ForbiddenInfo) intent.getParcelableExtra(KEY_ERROR_FORBIDDEN_INFO);
        this.mMenuNoticeCount = intent.getIntExtra(KEY_ERROR_MENU_NOTICE_COUNT, 0);
        this.mMenuPrivateCount = intent.getIntExtra(KEY_ERROR_MENU_PRIVACY_COUNT, 0);
        this.mWebUrl = intent.getStringExtra("webUrl");
        this.mWebPermit = intent.getIntExtra(KEY_SWAN_WEB_PERMIT, -1);
        this.mErrorCode = intent.getStringExtra(KEY_SWAN_ERROR_CODE);
        if (TextUtils.isEmpty(this.mLaunchInfo.H()) && (forbiddenInfo = this.mForbiddenInfo) != null) {
            this.mLaunchInfo.v0(forbiddenInfo.appId);
        }
        this.mErrorType = intent.getStringExtra(KEY_SWAN_ERROR_TYPE);
    }

    private void setPendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2) == null) {
            this.mEnterAnimWhenFinishing = i;
            this.mExitAnimWhenFinishing = i2;
        }
    }

    private void startExitActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.mEnterAnimWhenFinishing == 0 && this.mExitAnimWhenFinishing == 0) {
                return;
            }
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            startExitActivityAnim();
        }
    }

    public ForbiddenInfo getForbiddenInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mForbiddenInfo : (ForbiddenInfo) invokeV.objValue;
    }

    public gl2 getLaunchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLaunchInfo : (gl2) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.xd4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setPendingTransition(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010023);
            int c0 = de3.c0(this);
            super.onCreate(bundle);
            de3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d00a7);
            parseIntent(getIntent());
            loadFragment();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.onNewIntent(intent);
            parseIntent(intent);
            loadFragment();
        }
    }

    public void onNightModeCoverChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            Window window = getWindow();
            if (window == null) {
                if (DEBUG) {
                    Log.e(TAG, "activity or window is null");
                    return;
                }
                return;
            }
            if (this.mSkinDecorator == null) {
                this.mSkinDecorator = new y53();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.mSkinDecorator.a(viewGroup);
            } else {
                this.mSkinDecorator.b(viewGroup);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            updateCurrentNightMode();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        ix2 i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            if (TextUtils.equals(this.mErrorType, TYPE_APP_FORBIDDEN) && (i = kx2.k().i(this.mForbiddenInfo.appId)) != null && i.D()) {
                t23.J(this.mForbiddenInfo.appId);
            }
        }
    }

    public void updateCurrentNightMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onNightModeCoverChanged(qj2.M().a());
        }
    }
}
