package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InvoiceBuildActivity extends SlideActiviy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_PARAMS_ISCHECK = "isCheck";
    public static final String EXTRA_PARAMS_ISCHECKTAG = "isCheckTag";
    public static final String EXTRA_PARAMS_TYPE = "select";
    public static final String INVOICE_BUILD_ACTIVITY = "InvoiceBuildActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public InvoiceBuildDTO invoiceBuildDTO;
    public InvoiceBuildResult invoiceBuildResult;

    public InvoiceBuildActivity() {
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
        this.invoiceBuildResult = new InvoiceBuildResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
                return;
            }
            this.invoiceBuildResult.setResultCode(-301);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (EcommerceRouter.getInstance().getInvoiceBuildCallback() != null) {
                EcommerceRouter.getInstance().getInvoiceBuildCallback().onFinish(this.invoiceBuildResult);
            }
            EcommerceRouter.getInstance().release();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (INVOICE_BUILD_ACTIVITY.equals(getClass().getSimpleName())) {
                this.invoiceBuildResult.setResultCode(-301);
                finishActivity();
                return;
            }
            super.finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return EcommerceRouter.getInstance().getInvoiceBuildDTO();
        }
        return (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.init();
            InvoiceBuildDTO invoiceBuildDTO = EcommerceRouter.getInstance().getInvoiceBuildDTO();
            this.invoiceBuildDTO = invoiceBuildDTO;
            if (invoiceBuildDTO == null) {
                this.invoiceBuildResult.setResultCode(-204);
                finishActivity();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            back();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            back();
        }
    }

    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.sapiWebView.loadInvoiceBuild(list);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d0513);
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.invoiceBuildResult.setResultCode(-202);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void loadSlideWebview(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && SlideActiviy.INVOICE_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(this, InvoiceBuildExternalActivity.class);
            intent.putExtra("extra_external_url", str2);
            startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.setupViews();
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InvoiceBuildActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.this$0.back();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InvoiceBuildActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.invoiceBuildResult.setResultCode(-301);
                        this.this$0.finishActivity();
                    }
                }
            });
            this.sapiWebView.setInvoiceBuildCallback(new SapiJsCallBacks.InvoiceBuildCallback(this) { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InvoiceBuildActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.InvoiceBuildCallback
                public void onCallback(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.this$0.invoiceBuildResult.map.put(next, jSONObject.optString(next));
                            }
                            this.this$0.invoiceBuildResult.setResultCode(0);
                        } catch (JSONException e) {
                            Log.e(e);
                            this.this$0.invoiceBuildResult.setResultCode(-205);
                        }
                        this.this$0.finishActivity();
                    }
                }
            });
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
            InvoiceBuildDTO invoiceBuildDTO = this.invoiceBuildDTO;
            if (invoiceBuildDTO != null) {
                arrayList.add(new PassNameValuePair(EXTRA_PARAMS_TYPE, invoiceBuildDTO.TYPE));
                arrayList.add(new PassNameValuePair("tplse", this.invoiceBuildDTO.tplse));
                arrayList.add(new PassNameValuePair("tplt", this.invoiceBuildDTO.tplt));
                if (this.invoiceBuildDTO.isExamineVAT) {
                    arrayList.add(new PassNameValuePair(EXTRA_PARAMS_ISCHECK, "1"));
                }
                if (this.invoiceBuildDTO.showCheckTag) {
                    arrayList.add(new PassNameValuePair(EXTRA_PARAMS_ISCHECKTAG, "1"));
                }
            }
            loadInvoiceUrl(arrayList);
        }
    }
}
