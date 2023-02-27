package com.baidu.sapi2.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.sapi2.ecommerce.activity.AddressListActivity;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes2.dex */
public class EcommerceRouter implements NoProguard {
    public static EcommerceRouter instance;
    public AddressManageCallback addressManageCallback;
    public AddressManageDTO addressManageDTO;
    public Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    public InvoiceBuildCallback invoiceBuildCallback;
    public InvoiceBuildDTO invoiceBuildDTO;

    public static synchronized EcommerceRouter getInstance() {
        EcommerceRouter ecommerceRouter;
        synchronized (EcommerceRouter.class) {
            if (instance == null) {
                instance = new EcommerceRouter();
            }
            ecommerceRouter = instance;
        }
        return ecommerceRouter;
    }

    public AddressManageCallback getAddressManageCallback() {
        return this.addressManageCallback;
    }

    public AddressManageDTO getAddressManageDTO() {
        return this.addressManageDTO;
    }

    public InvoiceBuildCallback getInvoiceBuildCallback() {
        return this.invoiceBuildCallback;
    }

    public InvoiceBuildDTO getInvoiceBuildDTO() {
        return this.invoiceBuildDTO;
    }

    public synchronized void release() {
        this.addressManageDTO = null;
        this.invoiceBuildDTO = null;
        this.addressManageCallback = null;
        this.invoiceBuildCallback = null;
        PassportViewManager.getInstance().release();
        instance.context = null;
        instance = null;
    }

    private void loadNaAddressManage(Context context) {
        Intent intent;
        if (this.addressManageDTO.openPageName == "1") {
            intent = new Intent(context, AddressEditActivity.class);
        } else {
            intent = new Intent(context, AddressListActivity.class);
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        this.addressManageDTO = addressManageDTO;
        this.addressManageCallback = addressManageCallback;
        if (context == null) {
            context = this.context;
        }
        loadNaAddressManage(context);
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        this.invoiceBuildDTO = invoiceBuildDTO;
        this.invoiceBuildCallback = invoiceBuildCallback;
        if (context == null) {
            context = this.context;
        }
        Intent intent = new Intent(context, InvoiceBuildActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }
}
