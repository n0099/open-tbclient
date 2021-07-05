package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a;
import d.a.q0.a.f;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.g;
import d.a.q0.a.h0.g.e;
import d.a.q0.a.k;
import d.a.q0.a.v1.c.f.c;
import d.a.q0.a.v2.q0;
import d.a.q0.o.a.a.n;
/* loaded from: classes4.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int INVALID_ANIM = 0;
    public static final String KEY_ERROR_FORBIDDEN_INFO = "swan_error_forbidden_info";
    public static final String KEY_ERROR_MENU_NOTICE_COUNT = "swan_error_menu_notice_count";
    public static final String KEY_ERROR_MENU_PRIVACY_COUNT = "swan_error_menu_privacy_count";
    public static final String KEY_SWAN_ERROR_TYPE = "swan_error_type";
    public static final int SHOW_MENU_NOTICE_DEFAULT = 0;
    public static final String TAG = "SwanAppErrorActivity";
    public static final String TYPE_APP_FORBIDDEN = "type_app_forbidden";
    public static final String TYPE_LOAD_V8_FAILED = "type_load_v8_failed";
    public static final String TYPE_NEED_UPDATE_SDK = "type_need_update_sdk";
    public static final String TYPE_NETWORK_ERROR = "type_network_error";
    public static final String TYPE_NORMAL = "type_normal";
    public static final String TYPE_PATH_FORBIDDEN = "type_path_forbidden";
    public transient /* synthetic */ FieldHolder $fh;
    public int mEnterAnimWhenFinishing;
    public String mErrorType;
    public int mExitAnimWhenFinishing;
    public ForbiddenInfo mForbiddenInfo;
    public b mLaunchInfo;
    public int mMenuNoticeCount;
    public int mMenuPrivateCount;
    public d.a.q0.a.g2.b mSkinDecorator;

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
        DEBUG = k.f49133a;
    }

    public SwanAppErrorActivity() {
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
        this.mSkinDecorator = null;
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
    }

    private void loadFragment() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            n a2 = getSupportFragmentManager().a();
            if (getIntent() != null) {
                eVar = e.R2(this.mErrorType, this.mForbiddenInfo, this.mMenuNoticeCount, this.mMenuPrivateCount);
            } else if (this.mLaunchInfo == null) {
                if (DEBUG) {
                    Log.e(TAG, "launchInfo is null,error");
                    return;
                }
                return;
            } else {
                eVar = new e();
            }
            a2.a(f.ai_apps_error_layout, eVar);
            a2.d();
        }
    }

    private void parseIntent(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, intent) == null) || intent == null) {
            return;
        }
        this.mLaunchInfo = b.b1(intent);
        this.mForbiddenInfo = (ForbiddenInfo) intent.getParcelableExtra(KEY_ERROR_FORBIDDEN_INFO);
        this.mMenuNoticeCount = intent.getIntExtra(KEY_ERROR_MENU_NOTICE_COUNT, 0);
        this.mMenuPrivateCount = intent.getIntExtra(KEY_ERROR_MENU_PRIVACY_COUNT, 0);
        if (TextUtils.isEmpty(this.mLaunchInfo.H()) && (forbiddenInfo = this.mForbiddenInfo) != null) {
            this.mLaunchInfo.u0(forbiddenInfo.appId);
        }
        this.mErrorType = intent.getStringExtra(KEY_SWAN_ERROR_TYPE);
    }

    private void setPendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65540, this, i2, i3) == null) {
            this.mEnterAnimWhenFinishing = i2;
            this.mExitAnimWhenFinishing = i3;
        }
    }

    private void startExitActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
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

    public b getLaunchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLaunchInfo : (b) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, d.a.q0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setPendingTransition(a.aiapps_hold, a.aiapps_slide_out_to_bottom);
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            setContentView(g.aiapps_error_activity);
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
                this.mSkinDecorator = new d.a.q0.a.g2.b();
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
        c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            if (TextUtils.equals(this.mErrorType, TYPE_APP_FORBIDDEN) && (i2 = d.a.q0.a.v1.c.f.e.k().i(this.mForbiddenInfo.appId)) != null && i2.C()) {
                d.a.q0.a.c2.f.g0.a.g(this.mForbiddenInfo.appId);
            }
        }
    }

    public void updateCurrentNightMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onNightModeCoverChanged(d.a.q0.a.c1.a.H().a());
        }
    }
}
