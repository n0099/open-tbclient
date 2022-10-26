package com.baidu.sapi2.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class EcommerceRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static EcommerceRouter instance;
    public transient /* synthetic */ FieldHolder $fh;
    public AddressManageCallback addressManageCallback;
    public AddressManageDTO addressManageDTO;
    public Context context;
    public InvoiceBuildCallback invoiceBuildCallback;
    public InvoiceBuildDTO invoiceBuildDTO;

    public EcommerceRouter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    }

    public static synchronized EcommerceRouter getInstance() {
        InterceptResult invokeV;
        EcommerceRouter ecommerceRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (EcommerceRouter.class) {
                if (instance == null) {
                    instance = new EcommerceRouter();
                }
                ecommerceRouter = instance;
            }
            return ecommerceRouter;
        }
        return (EcommerceRouter) invokeV.objValue;
    }

    public AddressManageCallback getAddressManageCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.addressManageCallback;
        }
        return (AddressManageCallback) invokeV.objValue;
    }

    public AddressManageDTO getAddressManageDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.addressManageDTO;
        }
        return (AddressManageDTO) invokeV.objValue;
    }

    public InvoiceBuildCallback getInvoiceBuildCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.invoiceBuildCallback;
        }
        return (InvoiceBuildCallback) invokeV.objValue;
    }

    public InvoiceBuildDTO getInvoiceBuildDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.invoiceBuildDTO;
        }
        return (InvoiceBuildDTO) invokeV.objValue;
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.addressManageDTO = null;
                this.invoiceBuildDTO = null;
                this.addressManageCallback = null;
                this.invoiceBuildCallback = null;
                PassportViewManager.getInstance().release();
                instance.context = null;
                instance = null;
            }
        }
    }

    private void loadNaAddressManage(Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
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
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, addressManageDTO, addressManageCallback) == null) {
            this.addressManageDTO = addressManageDTO;
            this.addressManageCallback = addressManageCallback;
            if (context == null) {
                context = this.context;
            }
            loadNaAddressManage(context);
        }
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, invoiceBuildDTO, invoiceBuildCallback) == null) {
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
}
