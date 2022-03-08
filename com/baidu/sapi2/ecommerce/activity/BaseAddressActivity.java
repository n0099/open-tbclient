package com.baidu.sapi2.ecommerce.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity;
import com.baidu.pass.ecommerce.common.mvp.IPresenter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class BaseAddressActivity<P extends IPresenter> extends BaseMvpActivity<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AddressManageCallback addressManageCallback;
    public AddressManageDTO addressManageDTO;
    public boolean isDarkMode;
    public boolean isOpenEdit;
    public boolean isSelectAddressType;
    public boolean selectAddedAddress;

    public BaseAddressActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initAddressManage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
            AddressManageCallback addressManageCallback = EcommerceRouter.getInstance().getAddressManageCallback();
            this.addressManageCallback = addressManageCallback;
            AddressManageDTO addressManageDTO = this.addressManageDTO;
            if (addressManageDTO != null && addressManageCallback != null) {
                this.isSelectAddressType = TextUtils.equals(addressManageDTO.type, "1");
                AddressManageDTO addressManageDTO2 = this.addressManageDTO;
                this.selectAddedAddress = addressManageDTO2.selectAddedAddress;
                this.isOpenEdit = TextUtils.equals(addressManageDTO2.openPageName, "1");
                this.addressManageCallback.activityOnCreate();
                return;
            }
            AddressManageResult addressManageResult = new AddressManageResult();
            addressManageResult.setResultCode(-204);
            AddressManageCallback addressManageCallback2 = this.addressManageCallback;
            if (addressManageCallback2 != null) {
                addressManageCallback2.onFinish(addressManageResult);
            }
            finish();
        }
    }

    public void endProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AddressManageResult addressManageResult = new AddressManageResult();
            addressManageResult.setResultCode(-301);
            AddressManageCallback addressManageCallback = this.addressManageCallback;
            if (addressManageCallback != null) {
                addressManageCallback.onFinish(addressManageResult);
            }
            EcommerceRouter.getInstance().release();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
                this.isDarkMode = true;
            } else {
                this.isDarkMode = false;
            }
            super.onCreate(bundle);
            initAddressManage();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            AddressManageCallback addressManageCallback = this.addressManageCallback;
            if (addressManageCallback != null) {
                addressManageCallback.activityOnDestory();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            AddressManageCallback addressManageCallback = this.addressManageCallback;
            if (addressManageCallback != null) {
                addressManageCallback.activityOnPause();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            AddressManageCallback addressManageCallback = this.addressManageCallback;
            if (addressManageCallback != null) {
                addressManageCallback.activityOnResume();
            }
        }
    }
}
