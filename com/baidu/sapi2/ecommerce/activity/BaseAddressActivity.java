package com.baidu.sapi2.ecommerce.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity;
import com.baidu.pass.ecommerce.common.mvp.IPresenter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
/* loaded from: classes2.dex */
public abstract class BaseAddressActivity<P extends IPresenter> extends BaseMvpActivity<P> {
    public AddressManageCallback addressManageCallback;
    public AddressManageDTO addressManageDTO;
    public boolean isDarkMode;
    public boolean isOpenEdit;
    public boolean isSelectAddressType;
    public boolean selectAddedAddress;

    private void initAddressManage() {
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

    public void endProcess() {
        AddressManageResult addressManageResult = new AddressManageResult();
        addressManageResult.setResultCode(-301);
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.onFinish(addressManageResult);
        }
        EcommerceRouter.getInstance().release();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
            this.isDarkMode = true;
        } else {
            this.isDarkMode = false;
        }
        super.onCreate(bundle);
        initAddressManage();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnDestory();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnResume();
        }
    }
}
