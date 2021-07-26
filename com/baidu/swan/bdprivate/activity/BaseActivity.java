package com.baidu.swan.bdprivate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b.b;
/* loaded from: classes3.dex */
public class BaseActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_BAR_TEXT_SIZE = 14;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsSlideInFromBottom;

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsSlideInFromBottom = false;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if (this.mIsSlideInFromBottom) {
                overridePendingTransition(b.aiapps_hold, b.aiapps_slide_out_to_bottom_zadjustment_top);
            } else {
                overridePendingTransition(b.aiapps_hold, b.aiapps_slide_out_to_right_zadjustment_top);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (this.mIsSlideInFromBottom) {
                overridePendingTransition(b.aiapps_slide_in_from_bottom, b.aiapps_hold);
            } else {
                overridePendingTransition(b.aiapps_slide_in_from_right, b.aiapps_hold);
            }
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            if (this.mIsSlideInFromBottom) {
                overridePendingTransition(b.aiapps_slide_in_from_bottom, b.aiapps_hold);
            } else {
                overridePendingTransition(b.aiapps_slide_in_from_right, b.aiapps_hold);
            }
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, menuItem)) == null) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setIsSlideInFromBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mIsSlideInFromBottom = z;
        }
    }
}
