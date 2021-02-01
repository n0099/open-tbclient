package com.baidu.sapi2.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.activity.AddressManageActivity;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
/* loaded from: classes5.dex */
public class EcommerceRouter implements NoProguard {
    private static EcommerceRouter instance;
    private AddressManageCallback addressManageCallback;
    private AddressManageDTO addressManageDTO;
    private Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private InvoiceBuildCallback invoiceBuildCallback;
    private InvoiceBuildDTO invoiceBuildDTO;

    private EcommerceRouter() {
    }

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

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        this.addressManageDTO = addressManageDTO;
        this.addressManageCallback = addressManageCallback;
        if (context == null) {
            context = this.context;
        }
        Intent intent = new Intent(context, AddressManageActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        this.invoiceBuildDTO = invoiceBuildDTO;
        this.invoiceBuildCallback = invoiceBuildCallback;
        if (context == null) {
            context = this.context;
        }
        Intent intent = new Intent(context, InvoiceBuildActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public synchronized void release() {
        this.addressManageDTO = null;
        this.invoiceBuildDTO = null;
        this.addressManageCallback = null;
        this.invoiceBuildCallback = null;
        PassportViewManager.getInstance().release();
        instance = null;
    }
}
